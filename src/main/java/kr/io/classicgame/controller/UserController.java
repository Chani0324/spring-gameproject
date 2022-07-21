package kr.io.classicgame.controller;

import java.util.List;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Controller;
import org.springframework.ui.Model;
import org.springframework.web.bind.annotation.GetMapping;
import org.springframework.web.bind.annotation.ModelAttribute;
import org.springframework.web.bind.annotation.PostMapping;
import org.springframework.web.bind.annotation.SessionAttributes;
import org.springframework.web.bind.support.SessionStatus;

import kr.io.classicgame.domain.Total;
import kr.io.classicgame.domain.User;
import kr.io.classicgame.service.UserService;

@SessionAttributes("user")
// @RestController 사용시 주의사항 : String return 값을 전부 문자열로 처리하겠다는 것이 됨. 그냥 @controller 쓰면 String 반환값 주소로 이동.
@Controller
public class UserController {

	@Autowired
	private UserService userService;

	@ModelAttribute("user")
	public User setUser() {
		return new User();
	}

	/* pw저장 시에는 비밀번호 그대로 말고 바꿔서 저장하는 기능 넣어야 할듯. */
	/*
	 * parameter에 Requestbody 넣으면 인식을 json으로 하기 때문에 html에서 controller에 전달 해줄 때
	 * json으로 변경해야함. 보통 html에서 post나 put방식으로 보낼 때 따로 설정이 없으면 content-type은
	 * application/x-www-form-urlencoded으로 되어있다. json으로 controller에 넘겨주려면 html에서
	 * content-type을 application/json으로 설정 해야함.
	 */
	@PostMapping("/signup")
	public String signUpUser(User user, Model model) {
		boolean result = userService.insertUser(user);

		if (result) {
			model.addAttribute("message", "회원가입 완료. 로그인을 진행해 주세요.");
			return "forward:login.jsp";
		} else {
			model.addAttribute("message", "회원가입 실패. 다시 정보를 입력해 주세요.");
			return "forward:signUp.jsp";
		}
	}

	/* 로그인 인증 방법 boot security 통해서 추가 구현 예정. */
	@PostMapping("/login")
	public String login(User user, Total total, Model model) {
		User findUser = userService.getUser(user);

		/* pw검증 뒤에서 할건지 앞에서 할건지 */
		if (findUser != null && findUser.getPw().equals(user.getPw())) {
			model.addAttribute("user", findUser);
			return "forward:main.jsp";
		} else {
			model.addAttribute("message", "로그인 실패. 아이디 비밀번호 확인 필요");
			return "forward:login.jsp";
		}
	}

	@GetMapping("/logout")
	public String logout(SessionStatus status, Model model) {
		status.setComplete();
		model.addAttribute("message", "로그아웃 완료.");
		return "forward:main.jsp";
	}

	@PostMapping("/checkId")
	public String checkId(User user, Model model) {
		User findUser = userService.getUser(user);
		if (findUser == null && user.getId().length() != 0) {
			model.addAttribute("message", "사용 가능한 id 입니다.");
		} else if (user.getId().length() == 0) {
			model.addAttribute("message", "");
		} else {
			model.addAttribute("message", "중복된 id입니다.");
		}
		return "forward:view.jsp";
	}

	@PostMapping("/checkMail")
	public String checkMail(User user, Model model) {
		List<User> findMail = userService.getMail(user);
		
		if (findMail.isEmpty() && user.getMail().length() != 0) {
			model.addAttribute("message", "사용 가능한 email 입니다.");
		} else if (user.getId().length() == 0) {
			model.addAttribute("message", "");
		} else {
			model.addAttribute("message", "중복된 email입니다.");
		}
		return "forward:view.jsp";
	}

	@PostMapping("/checkNickname")
	public String checkNickname(User user, Model model) {
		List<User> findNickname = userService.getNickname(user);

		if (findNickname.isEmpty() && user.getNickname().length() != 0) {
			model.addAttribute("message", "사용 가능한 닉네임입니다.");
		} else if (user.getId().length() == 0) {
			model.addAttribute("message", "");
		} else {
			model.addAttribute("message", "중복된 닉네임입니다.");
		}
		return "forward:view.jsp";
	}

	@GetMapping("/deleteUser")
	public String deleteUser(@ModelAttribute("user") User sessionUser, Model model, SessionStatus status) {

		if (sessionUser.getId() == null) {
			return "redirect:login.jsp";
		}

		boolean result = userService.deleteUser(sessionUser);

		if (result) {
			status.setComplete();
			model.addAttribute("message", "계정 삭제 완료");
		} else {
			model.addAttribute("message", "계정 삭제 실패");
		}
		return "forward:main.jsp";
	}

	@PostMapping("/updateUser")
	public String updateUser(@ModelAttribute("user") User sessionUser, User user, Model model) {

		if (sessionUser.getId() == null) {
			return "redirect:login.jsp";
		}

		boolean result = userService.updateUser(user);
		
		if (result) {
			model.addAttribute("message", "업데이트 완료");
		} else {
			model.addAttribute("message", "업데이트 실패. 닉네임 또는 이메일을 재확인 하세요");
		}
		return "forward:main.jsp";
	}

}
