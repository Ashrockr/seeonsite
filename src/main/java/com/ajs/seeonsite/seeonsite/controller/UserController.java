package com.ajs.seeonsite.seeonsite.controller;

import javax.servlet.http.HttpSession;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Controller;
import org.springframework.ui.Model;
import org.springframework.web.bind.annotation.GetMapping;
import org.springframework.web.bind.annotation.PostMapping;
import org.springframework.web.bind.annotation.RequestParam;

import com.ajs.seeonsite.seeonsite.model.User;
import com.ajs.seeonsite.seeonsite.repository.UserRepository;

@Controller
public class UserController {

	@Autowired
	UserRepository userRepository;

	@PostMapping("/login")
	public String login(@RequestParam String userName,
			@RequestParam String password, Model model,
			HttpSession httpSession) {
		if (httpSession.getAttribute("user") != null) {
			return "redirect:";
		}

		User userFound = userRepository.findByUserName(userName);
		if (userFound == null) {
			model.addAttribute("error", "Invalid user name");
		} else if (!userFound.getPassword().equals(password)) {
			model.addAttribute("error", "Invalid password");
		} else {
			httpSession.setAttribute("user", userFound);
		}

		return "redirect:";
	}

	@GetMapping("/login")
	public String login(Model model, HttpSession httpSession) {
		if (httpSession.getAttribute("user") != null) {
			return "redirect:";
		}
		return "login";
	}

	@GetMapping("/logout")
	public String logout(Model model, HttpSession httpSession) {
		httpSession.setAttribute("user", null);
		model.addAttribute("info", "Logged out sucessfully");
		return "redirect:/login";
	}

}
