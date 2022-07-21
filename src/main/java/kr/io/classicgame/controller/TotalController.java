package kr.io.classicgame.controller;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Controller;
import org.springframework.ui.Model;
import org.springframework.web.bind.annotation.GetMapping;
import org.springframework.web.bind.annotation.ModelAttribute;
import org.springframework.web.bind.annotation.SessionAttributes;

import kr.io.classicgame.domain.Total;
import kr.io.classicgame.domain.User;
import kr.io.classicgame.service.TotalService;

@SessionAttributes("user")
@Controller
public class TotalController {
	
	@Autowired
	private TotalService totalService;
	
	@ModelAttribute("user")
	public User setUser() {
		return new User();
	}
	
	@GetMapping("/getTotalByNickname")
	public String getTotalByNickname(@ModelAttribute("user") User user, Model model, Total total) {
		return "";
	}
	
}
