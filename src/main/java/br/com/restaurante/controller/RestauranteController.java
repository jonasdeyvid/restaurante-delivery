package br.com.restaurante.controller;

import org.springframework.stereotype.Controller;
import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.servlet.ModelAndView;

@Controller
public class RestauranteController {

	public RestauranteController() {
		// TODO Auto-generated constructor stub
	}

	@RequestMapping("/")
	public ModelAndView home() {
		ModelAndView mv = new ModelAndView("Inicio");
		return mv;
	}
}
