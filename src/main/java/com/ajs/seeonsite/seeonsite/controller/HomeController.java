package com.ajs.seeonsite.seeonsite.controller;

import java.util.List;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Controller;
import org.springframework.ui.Model;
import org.springframework.web.bind.annotation.GetMapping;

import com.ajs.seeonsite.seeonsite.model.Home;
import com.ajs.seeonsite.seeonsite.repository.HomeRepository;

@Controller
public class HomeController {

	@Autowired
	HomeRepository homeRepository;

	@GetMapping("/")
	public String getHome(Model model) {
		List<Home> homes = homeRepository.findAll();
		model.addAttribute("homes", homes);

		return "home";
	}

}
