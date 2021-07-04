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
			// TODO Auto-generated catch block
			e.printStackTrace();
		} catch (SQLException e) {
			// TODO Auto-generated catch block
			e.printStackTrace();
		}
		return mv;
	}
	
	@RequestMapping(path="GetFilmData.do")
	public ModelAndView getFilmById(@RequestParam("filmId") int id) {
		DatabaseAccessorObject db = new DatabaseAccessorObject();
		ModelAndView mv = new ModelAndView();
//		int num = Integer.parseInt(id);
		mv.setViewName("WEB-INF/result.jsp");
		try {
			mv.addObject("film", db.findFilmById(id));
		} catch (NumberFormatException e) {
			// TODO Auto-generated catch block
			e.printStackTrace();
		} catch (SQLException e) {
			// TODO Auto-generated catch block
			e.printStackTrace();
		}
		return mv;
	}
	
	@RequestMapping(path="GetByKeyword.do")
	public ModelAndView getFilmByKeyword(@RequestParam("keyword") String keyword) {
		DatabaseAccessorObject db = new DatabaseAccessorObject();
		ModelAndView mv = new ModelAndView();
//		int num = Integer.parseInt(id);
		mv.setViewName("WEB-INF/result.jsp");
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
	
	@RequestMapping(path="AddFilm.do")
	public ModelAndView addFilm(@RequestParam("title") String title, @RequestParam("languageId") int languageId) {
		DatabaseAccessorObject db = new DatabaseAccessorObject();
		ModelAndView mv = new ModelAndView();
		Film film = new Film();
		
		film.setTitle(title);
		film.setLanguageId(languageId);
		
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
		
//		film.setTitle(title);
//		film.setLanguageId(languageId);
		
		mv.setViewName("WEB-INF/filmDeleted.jsp");
		mv.addObject("film", db.deleteFilm(film));
		System.out.println(mv.toString());
//		try {
//		} catch (NumberFormatException e) {
//		
//			e.printStackTrace();
//		} catch (SQLException e) {
//		
//			e.printStackTrace();
//		}
		return mv;
	}
	
	@RequestMapping(path="UpdateFilm.do")
	public ModelAndView updateFilm(@RequestParam("title") String title, @RequestParam("id") int filmId, @RequestParam("languageId") int languageId) throws SQLException {
		DatabaseAccessorObject db = new DatabaseAccessorObject();
		ModelAndView mv = new ModelAndView();
		Film film = db.findFilmById(filmId);
		
		film.setTitle(title);
		film.setLanguageId(languageId);
		
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
