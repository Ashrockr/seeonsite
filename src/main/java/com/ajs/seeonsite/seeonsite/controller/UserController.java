package com.ajs.seeonsite.seeonsite.controller;

import java.util.List;
import java.util.Optional;

import javax.servlet.http.HttpSession;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Controller;
import org.springframework.ui.Model;
import org.springframework.web.bind.annotation.GetMapping;
import org.springframework.web.bind.annotation.ModelAttribute;
import org.springframework.web.bind.annotation.PathVariable;
import org.springframework.web.bind.annotation.PostMapping;
import org.springframework.web.bind.annotation.RequestParam;
import org.springframework.web.servlet.mvc.support.RedirectAttributes;

import com.ajs.seeonsite.seeonsite.model.User;
import com.ajs.seeonsite.seeonsite.repository.UserRepository;

@Controller
public class UserController {

	@Autowired
	UserRepository userRepository;

	@PostMapping("/login")
	public String login(@RequestParam String email,
			@RequestParam String password, Model model, HttpSession httpSession,
			RedirectAttributes redir) {
		if (httpSession.getAttribute("user") != null) {
			return "redirect:";
		}

		User userFound = userRepository.findByEmail(email);
		if (userFound == null) {
			redir.addFlashAttribute("error", "Invalid user name");
		} else if (!userFound.getPassword().equals(password)) {
			redir.addFlashAttribute("error", "Invalid password");
		} else {
			httpSession.setAttribute("user", userFound);
		}

		return "redirect:";
	}

	@GetMapping("/register")
	public String register(Model model, HttpSession httpSession) {
		if (httpSession.getAttribute("user") != null) {
			return "redirect:";
		}
		model.addAttribute("user", new User());
		return "register";
	}

	@PostMapping("/register")
	public String register(@ModelAttribute("user") User user, Model model,
			HttpSession httpSession, RedirectAttributes redir) {
		if (httpSession.getAttribute("user") != null) {
			return "redirect:";
		}
		User userFound = userRepository.findByEmail(user.getEmail());
		if (userFound != null) {
			redir.addFlashAttribute("error", "Already registered");
			return "redirect:/login";
		} else {
			user = userRepository.save(user);
			httpSession.setAttribute("user", user);
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
	public String logout(Model model, HttpSession httpSession,
			RedirectAttributes redir) {
		httpSession.setAttribute("user", null);
		redir.addFlashAttribute("info", "Logged out sucessfully");
		return "redirect:/login";
	}

	@GetMapping("/admin/viewUsers")
	public String viewUsers(Model model, HttpSession httpSession,
			RedirectAttributes redir) {
		List<User> users = userRepository.findAll();
		users.remove(httpSession.getAttribute("user"));
		model.addAttribute("users", users);
		return "viewUsers";
	}

	@GetMapping("/admin/delete/{id}")
	public String deleteUser(@PathVariable("id") long id, Model model,
			HttpSession httpSession, RedirectAttributes redir) {
		Optional<User> user = userRepository.findById(id);
		if (!user.isPresent()) {
			redir.addFlashAttribute("error", "User Not Found");
			return "redirect:/admin/viewUsers";
		}
		userRepository.delete(user.get());
		List<User> users = userRepository.findAll();
		users.remove(httpSession.getAttribute("user"));
		redir.addFlashAttribute("users", users);
		redir.addFlashAttribute("Success", "User deleted successfully");
		return "redirect:/admin/viewUsers";
	}

}
