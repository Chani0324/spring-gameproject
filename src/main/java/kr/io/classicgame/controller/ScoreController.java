package kr.io.classicgame.controller;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.ui.Model;
import org.springframework.web.bind.annotation.ModelAttribute;
import org.springframework.web.bind.annotation.PostMapping;
import org.springframework.web.bind.annotation.RestController;
import org.springframework.web.bind.annotation.SessionAttributes;

import kr.io.classicgame.domain.Cgame1;
import kr.io.classicgame.domain.Cgame2;
import kr.io.classicgame.domain.Cgame3;
import kr.io.classicgame.domain.Total;
import kr.io.classicgame.domain.User;
import kr.io.classicgame.service.Cgame1Service;
import kr.io.classicgame.service.Cgame2Service;
import kr.io.classicgame.service.Cgame3Service;
import kr.io.classicgame.service.TotalService;

@SessionAttributes("User")
@RestController
public class ScoreController {

	@Autowired
	private TotalService totalService;

	@Autowired
	private Cgame1Service cgame1Service;

	@Autowired
	private Cgame2Service cgame2Service;

	@Autowired
	private Cgame3Service cgame3Service;

	@ModelAttribute("User")
	public User setUser() {
		return new User();
	}

	@PostMapping("/insertCgame1")
	public void insertCgame1(@ModelAttribute("User") User sessionUser, Model model, Cgame1 cgame1, Total total) {

		if (sessionUser.getId() == null) {
			System.out.println("로그인 인증 만료 재로그인 필요.");
			return;
		}

		if (total.getScore2() == 0 && total.getScore3() == 0) {

			boolean result = cgame1Service.insertCgame1(cgame1);

			if (result) {
				totalService.updateTotal(total);
				System.out.println("저장 완료");
			} else {
				System.out.println("저장 실패");
			}
		} else {
			System.out.println("요청받은 game의 점수가 아닙니다.");
		}
	}

	@PostMapping("/insertCgame2")
	public void insertCgame2(@ModelAttribute("User") User sessionUser, Model model, Cgame2 cgame2, Total total) {

		if (sessionUser.getId() == null) {
			System.out.println("로그인 인증 만료 재로그인 필요.");
			return;
		}

		if (total.getScore1() == 0 && total.getScore3() == 0) {

			boolean result = cgame2Service.insertCgame2(cgame2);

			if (result) {
				totalService.updateTotal(total);
				System.out.println("저장 완료");
			} else {
				System.out.println("저장 실패");
			}
		} else {
			System.out.println("요청받은 game의 점수가 아닙니다.");
		}
	}

	@PostMapping("/insertCgame3")
	public void insertCgame3(@ModelAttribute("User") User sessionUser, Model model, Cgame3 cgame3, Total total) {

		if (sessionUser.getId() == null) {
			System.out.println("로그인 인증 만료 재로그인 필요.");
			return;
		}

		if (total.getScore1() == 0 && total.getScore2() == 0) {

			boolean result = cgame3Service.insertCgame3(cgame3);

			if (result) {
				totalService.updateTotal(total);
				System.out.println("저장 완료");
			} else {
				System.out.println("저장 실패");
			}
		} else {
			System.out.println("요청받은 game의 점수가 아닙니다.");
		}
	}

}
