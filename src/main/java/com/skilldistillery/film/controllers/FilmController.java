package com.skilldistillery.film.controllers;

import java.sql.SQLException;

import org.springframework.stereotype.Controller;
import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.bind.annotation.RequestMethod;
import org.springframework.web.bind.annotation.RequestParam;
import org.springframework.web.servlet.ModelAndView;

import com.skilldistillery.film.database.DatabaseAccessorObject;
import com.skilldistillery.film.entities.Film;

@Controller
public class FilmController {
	
	@RequestMapping(path = {"/", "home.do"} )
	public String index() {
		return "WEB-INF/home.jsp";
	}
	
	@RequestMapping(path = "GoToDisplayFilm.do"  )
	public String cssHeaven() {
		return "WEB-INF/displayFilm.jsp";
	}
	
	@RequestMapping(path="GoToFilmDetails.do")
	public ModelAndView goToFilmDetails(@RequestParam("filmId") int id) {
		DatabaseAccessorObject db = new DatabaseAccessorObject();
		ModelAndView mv = new ModelAndView();
		System.out.println("the film id is: " + id);
//		int num = Integer.parseInt(id);
		mv.setViewName("WEB-INF/filmDetails.jsp");
		try {
			mv.addObject("film", db.findFilmById(id));
		} catch (NumberFormatException e) {
			e.printStackTrace();
		} catch (SQLException e) {
			e.printStackTrace();
		}
		return mv;
	}
	
	@RequestMapping(path="GetFilmData.do")
	public ModelAndView getFilmById(@RequestParam("filmId") int id) throws SQLException {
		DatabaseAccessorObject db = new DatabaseAccessorObject();
		ModelAndView mv = new ModelAndView();
//		int num = Integer.parseInt(id);
		if (db.findFilmById(id) == null || db.findFilmById(id).getTitle().isEmpty()) {
			mv.setViewName("WEB-INF/error.jsp");
		} else {

			mv.setViewName("WEB-INF/result.jsp");
		}
		try {
			mv.addObject("film", db.findFilmById(id));
		} catch (NumberFormatException e) {
			e.printStackTrace();
		} catch (SQLException e) {
			e.printStackTrace();
		}
		return mv;
	}
	
	@RequestMapping(path="GetByKeyword.do")
	public ModelAndView getFilmByKeyword(@RequestParam("keyword") String keyword) throws SQLException {
		DatabaseAccessorObject db = new DatabaseAccessorObject();
		ModelAndView mv = new ModelAndView();
//		int num = Integer.parseInt(id);
		if (db.findFilmsBySearchString(keyword).isEmpty()) {
			mv.setViewName("WEB-INF/error.jsp");
		} else {

			mv.setViewName("WEB-INF/result.jsp");
		}
		try {
			mv.addObject("films", db.findFilmsBySearchString(keyword));
			System.out.println(mv.toString());
		} catch (NumberFormatException e) {
			// TODO Auto-generated catch block
			e.printStackTrace();
		} catch (SQLException e) {
			// TODO Auto-generated catch block
			e.printStackTrace();
		}
		return mv;
	}
	
	@RequestMapping(path="AddFilm.do", method=RequestMethod.POST)
	public ModelAndView addFilm(Film film) throws SQLException {
		DatabaseAccessorObject db = new DatabaseAccessorObject();
		ModelAndView mv = new ModelAndView();		
						
		mv.setViewName("WEB-INF/filmAdded.jsp");
		
		try {
			mv.addObject("film", db.createFilm(film));
		} catch (NumberFormatException e) {
		
			e.printStackTrace();
		} catch (SQLException e) {
		
			e.printStackTrace();
		}
		return mv;
	}
	
	@RequestMapping(path="DeleteFilm.do", method=RequestMethod.POST)
	public ModelAndView deleteFilm(@RequestParam("id") int filmId) throws SQLException {
		DatabaseAccessorObject db = new DatabaseAccessorObject();
		ModelAndView mv = new ModelAndView();
		Film film = db.findFilmById(filmId);
	
		
		mv.setViewName("WEB-INF/filmDeleted.jsp");
		mv.addObject("film", db.deleteFilm(film));
		System.out.println(mv.toString());

		return mv;
	}
	
	@RequestMapping(path="UpdateFilm.do", method=RequestMethod.POST)
	public ModelAndView updateFilm(@RequestParam("title") String title, @RequestParam("id") int filmId, 
			@RequestParam("rentalDuration") int rentalDuration, @RequestParam("description") String description, @RequestParam("releaseYear") Integer releaseYear,
			@RequestParam("rentalRate") double rentalRate, @RequestParam("length") Integer length, @RequestParam("replacementCost") double replacementCost, 
			@RequestParam("rating") String rating, @RequestParam("specialFeatures") String specialFeatures, @RequestParam("languageName") String languageName, 
			@RequestParam("category") String category) throws SQLException {
		DatabaseAccessorObject db = new DatabaseAccessorObject();
		ModelAndView mv = new ModelAndView();
		Film film = db.findFilmById(filmId);
		
		film.setTitle(title);
		film.setRentalRate(rentalRate);
		film.setRentalDuration(rentalDuration);
		film.setDescription(description);
		film.setLength(length);
		film.setReplacementCost(replacementCost);
		film.setRating(rating);
		film.setSpecialFeatures(specialFeatures);
		film.setLanguageName(languageName);
		film.setCategory(category);
		film.setReleaseYear(releaseYear);		
		
		System.out.println(film.getCategory());
		
		mv.setViewName("WEB-INF/filmUpdated.jsp");
		try {
			mv.addObject("film", db.updateFilm(film));
		} catch (NumberFormatException e) {
		
			e.printStackTrace();
		} catch (SQLException e) {
		
			e.printStackTrace();
		}
		return mv;
		

	}
}
