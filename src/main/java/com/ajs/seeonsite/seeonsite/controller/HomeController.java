package com.ajs.seeonsite.seeonsite.controller;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Controller;
import org.springframework.ui.Model;
import org.springframework.web.bind.annotation.GetMapping;
import org.springframework.web.bind.annotation.PostMapping;
import org.springframework.web.bind.annotation.RequestBody;

import com.ajs.seeonsite.seeonsite.model.User;
import com.ajs.seeonsite.seeonsite.repository.UserRepository;

@Controller
public class HomeController {

	@Autowired
	UserRepository userRepository;

	@GetMapping("/")
	public String getHome(Model model) {

		model.addAttribute("user", null);

		return "home";
	}

	@PostMapping("/login")
	public String login(@RequestBody User user, Model model) {

		User userFound = userRepository.findByUserName(user.getUserName());
		if (userFound == null) {
			model.addAttribute("error", "Invalid user name");
		} else if (!userFound.getPassword().equals(user.getPassword())) {
			model.addAttribute("error", "Invalid password");
		} else {
			model.addAttribute("user", userFound);
		}

		return "home";
	}
}
