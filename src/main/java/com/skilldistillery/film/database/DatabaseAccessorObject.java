package com.skilldistillery.film.database;

import java.sql.Connection;
import java.sql.DriverManager;
import java.sql.PreparedStatement;
import java.sql.ResultSet;
import java.sql.SQLException;
import java.sql.Statement;
import java.util.ArrayList;
import java.util.List;

import com.skilldistillery.film.entities.Actor;
import com.skilldistillery.film.entities.Film;
import com.skilldistillery.film.entities.InventoryItem;

public class DatabaseAccessorObject implements DatabaseAccessor {
	private static final String URL = "jdbc:mysql://localhost:3306/sdvid?useSSL=false";
	private String user = "student";
	private String pass = "student";

	static {
		try {
			Class.forName("com.mysql.jdbc.Driver");
		} catch (ClassNotFoundException e) {
			// TODO Auto-generated catch block
			e.printStackTrace();
		}
	}

	@Override
	public Film findFilmById(int filmId) throws SQLException {
		Connection conn = DriverManager.getConnection(URL, user, pass);
		Film film = null;

		List<Actor> aL = findActorsByFilmId(filmId);
		List<InventoryItem> invL = findInventoryByFilmId(filmId);

		// THE COLUMNS AFTER SELECT ARE THE ONLY ONES WE CAN USE LATER, TRY * TO GET ALL
		// OF THE AVAILABLE COLUMNS
		String sql = "SELECT * FROM film WHERE id = ?";
		PreparedStatement stmt = conn.prepareStatement(sql);
		// THE NUMBER IS THE INDEX OF THE ? TO REPLACE WITH THE SECOND PARAM
		stmt.setInt(1, filmId);
		ResultSet rs = stmt.executeQuery();

		// CAN USE NAMES OR COLUMN NUMBERS AS PARAMS OF getString()
		while (rs.next()) {
			film = new Film();
			film.setiD(rs.getInt("id"));
			film.setDescription(rs.getString("description"));
			film.setLanguageId(rs.getInt("language_id"));
			film.setLength(rs.getInt("length"));
			film.setRating(rs.getString("rating"));
			film.setReleaseYear(rs.getInt("release_year"));
			film.setRentalDuration(rs.getInt("rental_duration"));
			film.setRentalRate(rs.getDouble("rental_rate"));
			film.setReplacementCost(rs.getDouble("replacement_cost"));
			film.setSpecialFeatures(rs.getString("special_features"));
			film.setTitle(rs.getString("title"));
			film.setLanguageName(findLanguageById(film.getLanguageId()));
			film.setActorList(aL);
			film.setInventoryList(invL);
			film.setCategory(findCategoryById(filmId));
		}
		rs.close();
		stmt.close();
		conn.close();

		return film;
	}

	@Override
	public Actor findActorById(int actorId) throws SQLException {
		Connection conn = DriverManager.getConnection(URL, user, pass);
		Actor actor = new Actor();

		// THE COLUMNS AFTER SELECT ARE THE ONLY ONES WE CAN USE LATER, TRY * TO GET ALL
		// OF THE AVAILABLE COLUMNS
		String sql = "SELECT * FROM actor WHERE id = ?";
		PreparedStatement stmt = conn.prepareStatement(sql);
		// THE NUMBER IS THE INDEX OF THE ? TO REPLACE WITH THE SECOND PARAM
		stmt.setInt(1, actorId);
		ResultSet rs = stmt.executeQuery();

		System.out.println();

		// CAN USE NAMES OR COLUMN NUMBERS AS PARAMS OF getString()
		while (rs.next()) {
			actor.setiD(rs.getInt("id"));
			actor.setFirstName(rs.getString("first_name"));
			actor.setLastName(rs.getString("last_name"));

		}
		rs.close();
		stmt.close();
		conn.close();

		return actor;
	}

	@Override
	public List<Actor> findActorsByFilmId(int filmId) throws SQLException {
		Connection conn = DriverManager.getConnection(URL, user, pass);
		List<Actor> actorList = new ArrayList<Actor>();

		String sql = "SELECT * FROM actor JOIN film_actor ON actor.id = film_actor.actor_id "
				+ " WHERE film_actor.film_id = ?";
		PreparedStatement stmt = conn.prepareStatement(sql);
		stmt.setInt(1, filmId);
		ResultSet rs = stmt.executeQuery();
		while (rs.next()) {
			Actor actor = new Actor(rs.getInt("id"), rs.getString("first_name"), rs.getString("last_name"));
			actorList.add(actor);
		}
		rs.close();
		stmt.close();
		conn.close();

		return actorList;

	}

	@Override
	public List<Film> findFilmsBySearchString(String searchString) throws SQLException {
		Connection conn = DriverManager.getConnection(URL, user, pass);
		List<Film> filmList = new ArrayList<Film>();
		List<InventoryItem> invL = null;
		List<Actor> aL = null;
		Film film = null;

		String sql = "SELECT * FROM film WHERE description LIKE ? OR title LIKE ?";
		PreparedStatement stmt = conn.prepareStatement(sql);
		stmt.setString(1, "%" + searchString + "%");
		stmt.setString(2, "%" + searchString + "%");

//		System.out.println(stmt);
		ResultSet rs = stmt.executeQuery();

		while (rs.next()) {
			film = new Film();
			film.setiD(rs.getInt("id"));
			film.setDescription(rs.getString("description"));
			film.setLanguageId(rs.getInt("language_id"));
			film.setLength(rs.getInt("length"));
			film.setRating(rs.getString("rating"));
			film.setReleaseYear(rs.getInt("release_year"));
			film.setRentalDuration(rs.getInt("rental_duration"));
			film.setRentalRate(rs.getDouble("rental_rate"));
			film.setReplacementCost(rs.getDouble("replacement_cost"));
			film.setSpecialFeatures(rs.getString("special_features"));
			film.setTitle(rs.getString("title"));
			film.setLanguageName(findLanguageById(film.getLanguageId()));
			aL = findActorsByFilmId(film.getiD());
			film.setActorList(aL);
			invL = findInventoryByFilmId(film.getiD());
			film.setInventoryList(invL);
			filmList.add(film);
			film.setCategory(findCategoryById(film.getiD()));

		}
		rs.close();
		stmt.close();
		conn.close();

		return filmList;
	}

	@Override
	public String findLanguageById(int langId) throws SQLException {
		Connection conn = DriverManager.getConnection(URL, user, pass);
		String language = null;

		String sql = "SELECT * FROM language " + " WHERE id = ?";
		PreparedStatement stmt = conn.prepareStatement(sql);
		stmt.setInt(1, langId);
		ResultSet rs = stmt.executeQuery();
		while (rs.next()) {
			language = rs.getString("name");
		}
		rs.close();
		stmt.close();
		conn.close();

		return language;
	}
	
	@Override
	public int findLanguageByName(String langName) throws SQLException {
		Connection conn = DriverManager.getConnection(URL, user, pass);
		int langId = 0;

		String sql = "SELECT id FROM language WHERE name=?";
		PreparedStatement stmt = conn.prepareStatement(sql);
		stmt.setString(1, langName);
		ResultSet rs = stmt.executeQuery();
		while (rs.next()) {
			langId = rs.getInt("id");
		}
		rs.close();
		stmt.close();
		conn.close();

		return langId;
	}

	@Override
	public String findCategoryById(int filmId) throws SQLException {
		Connection conn = DriverManager.getConnection(URL, user, pass);
		String category = null;

		String sql = "SELECT name FROM category JOIN film_category on category.id = film_category.category_id "
				+ " WHERE film_id = ?";
		PreparedStatement stmt = conn.prepareStatement(sql);
		stmt.setInt(1, filmId);
		ResultSet rs = stmt.executeQuery();
		while (rs.next()) {
			category = rs.getString("name");
		}
		rs.close();
		stmt.close();
		conn.close();

		return category;
	}
	
	@Override
	public int findCategoryIdByName(String categoryName) throws SQLException {
		Connection conn = DriverManager.getConnection(URL, user, pass);
		int categoryId = 0;

		String sql = "SELECT id FROM category WHERE name = ?";
		PreparedStatement stmt = conn.prepareStatement(sql);
		stmt.setString(1, categoryName);
		ResultSet rs = stmt.executeQuery();
		while (rs.next()) {
			categoryId = rs.getInt("id");
		}
		rs.close();
		stmt.close();
		conn.close();

		return categoryId;
	}

	@Override
	public List<InventoryItem> findInventoryByFilmId(int filmId) throws SQLException {
		Connection conn = DriverManager.getConnection(URL, user, pass);
		List<InventoryItem> inventoryList = new ArrayList<>();

		String sql = "SELECT * FROM inventory_item JOIN film ON inventory_item.film_id = film.id "
				+ " WHERE film.id = ?";
		PreparedStatement stmt = conn.prepareStatement(sql);
		stmt.setInt(1, filmId);
		ResultSet rs = stmt.executeQuery();
		while (rs.next()) {
			InventoryItem item = new InventoryItem(rs.getInt("id"), rs.getInt("film_id"), rs.getInt("store_id"),
					rs.getString("media_condition"), rs.getString("last_update"));
			inventoryList.add(item);
		}
		rs.close();
		stmt.close();
		conn.close();

		return inventoryList;
	}

	@Override
	public Film createFilm(Film film) throws SQLException {		
//		String sql = "INSERT INTO film (title, language_id) VALUES (?, ?)";
		Connection conn = null;
		int langId = findLanguageByName(film.getLanguageName()); 
	
		System.out.println(film.getSpecialFeatures());
		
		  try {
			  conn = DriverManager.getConnection(URL, user, pass);
		    
		    conn.setAutoCommit(false); // START TRANSACTION
		    String sql = "INSERT INTO film (title, language_id, rental_duration, "
		    		+ "release_year, description, length, replacement_cost, "
		    		+ "rating, special_features, rental_rate) VALUES (?,?,?,?,?,?,?,?,?,?)"; 
		    
		    PreparedStatement stmt = conn.prepareStatement(sql, Statement.RETURN_GENERATED_KEYS);
		    
		    stmt.setString(1, film.getTitle());  
		    stmt.setInt(2, langId); 
		    stmt.setInt(3, film.getRentalDuration());
		    stmt.setInt(4, film.getReleaseYear());
		    stmt.setString(5, film.getDescription());
		    stmt.setInt(6, film.getLength());
			stmt.setDouble(7, film.getReplacementCost());
			stmt.setString(8, film.getRating());
			stmt.setString(9, film.getSpecialFeatures());
			stmt.setDouble(10, film.getRentalRate());
//			stmt.setInt(11, film.getiD());		
			

		    int updateCount = stmt.executeUpdate();
		     ResultSet keys = stmt.getGeneratedKeys();
		     if (keys.next()) {
		        int newFilmId = keys.getInt(1);
		        film.setiD(newFilmId);
		        createCategory(film, conn);
		    }
		    
		      conn.commit();           // COMMIT TRANSACTION
//		    }
		  } catch (SQLException sqle) {
		    sqle.printStackTrace();
		    if (conn != null) {
		      try { conn.rollback(); } // ROLLBACK TRANSACTION ON ERROR
		      catch (SQLException sqle2) {
		        System.err.println("Error trying to rollback");
		      }
		    }
		    return null;
		  }
		  return film;
	}
	
	public boolean createCategory(Film film, Connection conn) throws SQLException {
//		  Connection conn = null;
		  int categoryId = findCategoryIdByName(film.getCategory());
		  System.out.println(film.getiD());
		  
		try {
//		    conn = DriverManager.getConnection(URL, user, pass);
		    
		    conn.setAutoCommit(false); // START TRANSACTION
		    String sql = "INSERT INTO film_category (category_id, film_id) VALUES (?, ?)";
		    
		    PreparedStatement stmt = conn.prepareStatement(sql);
		    stmt.setInt(1, categoryId);
		    stmt.setInt(2, film.getiD());
		    
		    int uc = stmt.executeUpdate();
		    
		    if (uc != 1) {
				System.err.println("We done goofed inside createCategory!");
				conn.rollback();
				return false;
			}
		    conn.commit();             // COMMIT TRANSACTION
		  }
		  catch (SQLException sqle) {
		    sqle.printStackTrace();
		    if (conn != null) {
		      try { conn.rollback(); }
		      catch (SQLException sqle2) {
		        System.err.println("Error trying to rollback");
		      }
		    }
		    return false;
		  }
		  return true;
	}
	
	public Film deleteFilm(Film film) {
		  Connection conn = null;
		
		try {
		    conn = DriverManager.getConnection(URL, user, pass);
		    
		    conn.setAutoCommit(false); // START TRANSACTION
		    String sql = "DELETE FROM film WHERE id = ?";
		    
		    PreparedStatement stmt = conn.prepareStatement(sql);
		    stmt.setInt(1, film.getiD());
		    
		    deleteCategory(film, conn);
		    
		    int uc = stmt.executeUpdate();
		    
		    if (uc != 1) {
				System.err.println("We done goofed inside the deleteFilm!");
				conn.rollback();
				return film;
			}
		    conn.commit();             // COMMIT TRANSACTION
		  }
		  catch (SQLException sqle) {
		    sqle.printStackTrace();
		    if (conn != null) {
		      try { conn.rollback(); }
		      catch (SQLException sqle2) {
		        System.err.println("Error trying to rollback");
		      }
		    }
		    return film;
		  }
		  return null;
	}
	
	public boolean deleteCategory(Film film, Connection conn) throws SQLException {
//		  Connection conn = null;
//		  int categoryId = findCategoryIdByName(film.getCategory());
//		  System.out.println(film.getiD());
		  
		try {
//		    conn = DriverManager.getConnection(URL, user, pass);
		    
		    conn.setAutoCommit(false); // START TRANSACTION
		    String sql = "DELETE FROM film_category WHERE film_id = ?";
		    
		    PreparedStatement stmt = conn.prepareStatement(sql);
//		    stmt.setInt(1, categoryId);
		    stmt.setInt(1, film.getiD());
		    System.out.println("from inside delete category the sql string is: " + sql);
		    
		    int uc = stmt.executeUpdate();
		    
		    if (uc != 1) {
				System.err.println("We done goofed inside deleteCategory!");
				conn.rollback();
				return false;
			}
		    conn.commit();             // COMMIT TRANSACTION
		  }
		  catch (SQLException sqle) {
		    sqle.printStackTrace();
		    if (conn != null) {
		      try { conn.rollback(); }
		      catch (SQLException sqle2) {
		        System.err.println("Error trying to rollback");
		      }
		    }
		    return false;
		  }
		  return true;
	}
	
	public boolean updateCategory(Film film) throws SQLException {
		  Connection conn = null;
		  int categoryId = findCategoryIdByName(film.getCategory());
		  System.out.println(film.getiD());
		  
		try {
		    conn = DriverManager.getConnection(URL, user, pass);
		    
		    conn.setAutoCommit(false); // START TRANSACTION
		    String sql = "UPDATE film_category SET category_id=? WHERE film_id = ?";
		    
		    PreparedStatement stmt = conn.prepareStatement(sql);
		    stmt.setInt(1, categoryId);
		    stmt.setInt(2, film.getiD());
		    
		    int uc = stmt.executeUpdate();
		    
		    if (uc != 1) {
				System.err.println("We done goofed inside updateCategory!");
				conn.rollback();
				return false;
			}
		    conn.commit();             // COMMIT TRANSACTION
		  }
		  catch (SQLException sqle) {
		    sqle.printStackTrace();
		    if (conn != null) {
		      try { conn.rollback(); }
		      catch (SQLException sqle2) {
		        System.err.println("Error trying to rollback");
		      }
		    }
		    return false;
		  }
		  return true;
	}

	@Override
	public Film updateFilm(Film film) throws SQLException {
		Connection conn = null;
		int langId = findLanguageByName(film.getLanguageName()); 
		
		  try {
		    conn = DriverManager.getConnection(URL, user, pass);
		    
		    conn.setAutoCommit(false); // START TRANSACTION
		    String sql = "UPDATE film SET title=?, language_id=?, rental_duration=?, release_year=?, description=?, length=?, replacement_cost=?, "
		    		+ "rating=?, special_features=?, rental_rate=? WHERE id=?"; 
		    
		    PreparedStatement stmt = conn.prepareStatement(sql);
		    
		    stmt.setString(1, film.getTitle());  
		    stmt.setInt(2, langId); 
		    stmt.setInt(3, film.getRentalDuration());
		    stmt.setInt(4, film.getReleaseYear());
		    stmt.setString(5, film.getDescription());
		    stmt.setInt(6, film.getLength());
			stmt.setDouble(7, film.getReplacementCost());
			stmt.setString(8, film.getRating());
			stmt.setString(9, film.getSpecialFeatures());
			stmt.setDouble(10, film.getRentalRate());
			stmt.setInt(11, film.getiD());		
			
			updateCategory(film);

		    int updateCount = stmt.executeUpdate();
		    
		      conn.commit();           // COMMIT TRANSACTION
//		    }
		  } catch (SQLException sqle) {
		    sqle.printStackTrace();
		    if (conn != null) {
		      try { conn.rollback(); } // ROLLBACK TRANSACTION ON ERROR
		      catch (SQLException sqle2) {
		        System.err.println("Error trying to rollback");
		      }
		    }
		    return null;
		  }
		  return film;
	}

	

}
