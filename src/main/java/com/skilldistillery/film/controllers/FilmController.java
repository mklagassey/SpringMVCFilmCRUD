package com.skilldistillery.film.controllers;

import java.sql.SQLException;

import org.springframework.stereotype.Controller;
import org.springframework.web.bind.annotation.RequestMapping;
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
	
}
