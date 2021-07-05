package com.skilldistillery.film.database;

import java.sql.SQLException;
import java.util.List;

import com.skilldistillery.film.entities.Actor;
import com.skilldistillery.film.entities.Film;
import com.skilldistillery.film.entities.InventoryItem;

public interface DatabaseAccessor {
	public String findLanguageById(int langId) throws SQLException;

	public String findCategoryById(int filmId) throws SQLException;

	public Film findFilmById(int filmId) throws SQLException;

	public Actor findActorById(int actorId) throws SQLException;

	public List<Actor> findActorsByFilmId(int filmId) throws SQLException;

	public List<Film> findFilmsBySearchString(String searchString) throws SQLException;

	public List<InventoryItem> findInventoryByFilmId(int filmId) throws SQLException;
	
	public Film createFilm(Film film) throws SQLException;
	
	public Film deleteFilm(Film film) throws SQLException;
	
	public Film updateFilm(Film film) throws SQLException;

	int findLanguageByName(String langName) throws SQLException;


}
