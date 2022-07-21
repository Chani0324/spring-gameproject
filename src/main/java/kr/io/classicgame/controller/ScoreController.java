package kr.io.classicgame.controller;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Controller;
import org.springframework.ui.Model;
import org.springframework.web.bind.annotation.GetMapping;
import org.springframework.web.bind.annotation.ModelAttribute;
import org.springframework.web.bind.annotation.PostMapping;
import org.springframework.web.bind.annotation.SessionAttributes;

import kr.io.classicgame.domain.Cgame1;
import kr.io.classicgame.domain.Cgame2;
import kr.io.classicgame.domain.Cgame3;
import kr.io.classicgame.domain.Total;
import kr.io.classicgame.domain.User;
import kr.io.classicgame.exception.UserException;
import kr.io.classicgame.service.Cgame1Service;
import kr.io.classicgame.service.Cgame2Service;
import kr.io.classicgame.service.Cgame3Service;
import kr.io.classicgame.service.TotalService;

@SessionAttributes("user")
@Controller
public class ScoreController {

	@Autowired
	private TotalService totalService;

	@Autowired
	private Cgame1Service cgame1Service;

	@Autowired
	private Cgame2Service cgame2Service;

	@Autowired
	private Cgame3Service cgame3Service;

	@ModelAttribute("user")
	public User setUser() {
		return new User();
	}

	@PostMapping("/insertCgame1")
	public String insertCgame1(@ModelAttribute("user") User sessionUser, Model model, Cgame1 cgame1, Total total) {

		// AOP 적용 예정
		if (sessionUser.getId() == null) {
			return "redirect:/login.html";
		}

		if (total.getScore2() == 0 && total.getScore3() == 0) {

			boolean result = cgame1Service.insertCgame1(cgame1);

			if (result) {
				totalService.updateTotal(total);
			}
		}
		return "redirect:/main.jsp";
	}

	@PostMapping("/insertCgame2")
	public String insertCgame2(@ModelAttribute("user") User sessionUser, Model model, Cgame2 cgame2, Total total) {

		// AOP 적용 예정
		if (sessionUser.getId() == null) {
			return "redirect:/login.html";
		}

		if (total.getScore1() == 0 && total.getScore3() == 0) {

			boolean result = cgame2Service.insertCgame2(cgame2);

			if (result) {
				totalService.updateTotal(total);
			}
		}
		return "redirect:/main.jsp";
	}

	@PostMapping("/insertCgame3")
	public String insertCgame3(@ModelAttribute("user") User sessionUser, Model model, Cgame3 cgame3, Total total) {

		if (sessionUser.getId() == null) {
			return "redirect:/login.html";
		}

		if (total.getScore1() == 0 && total.getScore2() == 0) {

			boolean result = cgame3Service.insertCgame3(cgame3);

			if (result) {
				totalService.updateTotal(total);
			}
		}
		return "redirect:/main.jsp";
	}
	
	@GetMapping("/userTotal")
	public String findUserTotal(@ModelAttribute("user") User sessionUser, Model model) {
		
		if (sessionUser.getId() == null) {
			return "redirect:/login.html";
		}
		
		Total userTotal = totalService.getUserTotal(sessionUser);
		
		model.addAttribute("userTotal", userTotal);
		return "forward:userTotalView.jsp";
		
	}

}
