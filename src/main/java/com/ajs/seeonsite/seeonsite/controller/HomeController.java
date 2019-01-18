package com.ajs.seeonsite.seeonsite.controller;

import java.util.Date;
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
import org.springframework.web.bind.annotation.PutMapping;
import org.springframework.web.servlet.mvc.support.RedirectAttributes;

import com.ajs.seeonsite.seeonsite.model.Home;
import com.ajs.seeonsite.seeonsite.model.User;
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

	@GetMapping("/postRoom")
	public String postHome(Model model) {
		model.addAttribute("home", new Home());
		return "postRoom";
	}

	@PostMapping("/postRoom")
	public String submitRoom(@ModelAttribute("home") Home home, Model model,
			HttpSession session) {

		home.setOwner((User) session.getAttribute("user"));
		home.setPostedOn(new Date());
		homeRepository.save(home);
		model.addAttribute("info", "Successfully posted");
		return "redirect:/";
	}

	@PutMapping("/postRoom/{homeId}")
	public String updateRoom(@PathVariable("homeId") long homeId,
			@ModelAttribute("home") Home home, Model model, HttpSession session,
			RedirectAttributes redir) {
		Optional<Home> homeFromDB = homeRepository.findById(homeId);
		Home updatedHome = homeFromDB.get();
		updatedHome.setName(home.getName());
		updatedHome.setLocation(home.getLocation());
		updatedHome.setDescription(home.getDescription());
		homeRepository.save(updatedHome);
		redir.addFlashAttribute("success", "Successfully updated");
		return "redirect:/";
	}

	@GetMapping("/viewRoom/{homeId}")
	public String viewHome(@PathVariable("homeId") long homeId, Model model) {
		Optional<Home> home = homeRepository.findById(homeId);
		model.addAttribute("home", home.get());
		return "viewHome";
	}

	@GetMapping("/occupied/{homeId}")
	public String setStatusOccupied(@PathVariable("homeId") long homeId,
			Model model) {
		Optional<Home> home = homeRepository.findById(homeId);
		home.get().setIsApplied(Boolean.TRUE);
		homeRepository.save(home.get());
		model.addAttribute("home", home.get());
		return "viewHome";
	}

	@GetMapping("/unoccupied/{homeId}")
	public String setStatusUnoccupied(@PathVariable("homeId") long homeId,
			Model model) {
		Optional<Home> home = homeRepository.findById(homeId);
		home.get().setIsApplied(Boolean.FALSE);
		homeRepository.save(home.get());
		model.addAttribute("home", home.get());
		return "viewHome";
	}

	@GetMapping("/updateRoom/{homeId}")
	public String updateRoom(@PathVariable("homeId") long homeId, Model model,
			RedirectAttributes redir) {
		Optional<Home> home = homeRepository.findById(homeId);
		if (!home.isPresent()) {
			redir.addFlashAttribute("error", "No room available");
			return "redirect:";
		}
		model.addAttribute("home", home.get());
		return "updateRoom";
	}

}
