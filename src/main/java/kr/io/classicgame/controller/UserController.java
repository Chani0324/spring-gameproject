package kr.io.classicgame.controller;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Controller;
import org.springframework.ui.Model;
import org.springframework.web.bind.annotation.DeleteMapping;
import org.springframework.web.bind.annotation.GetMapping;
import org.springframework.web.bind.annotation.ModelAttribute;
import org.springframework.web.bind.annotation.PostMapping;
import org.springframework.web.bind.annotation.PutMapping;
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
	
	@Autowired
	private ScoreController	scoreController;
	
	@ModelAttribute("user")
	public User setUser() {
		return new User();
	}
	
	/* pw저장 시에는 비밀번호 그대로 말고 바꿔서 저장하는 기능 넣어야 할듯. */
	/* parameter에 Requestbody 넣으면 인식을 json으로 하기 때문에 html에서 controller에 전달 해줄 때 json으로 변경해야함.
	 * 보통 html에서 post나 put방식으로 보낼 때 따로 설정이 없으면 content-type은 application/x-www-form-urlencoded으로 되어있다.
	 * json으로 controller에 넘겨주려면 html에서 content-type을 application/json으로 설정 해야함. */
	@PostMapping("/signup")
	public String signUpUser(User user, Model model) {
		boolean result = userService.insertUser(user);
		
		if(result) {
			model.addAttribute("message", "회원가입 완료. 로그인을 진행해 주세요.");
			return "forward:login.jsp";
		}else {
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
			scoreController.findUserTotal(findUser, model);
			model.addAttribute("user", findUser);
			return "forward:main.jsp";
		} else {
			model.addAttribute("message", "로그인 실패. 아이디 비밀번호 확인 필요");
			return "forward:login.jsp";
		}
	}
	
	@GetMapping("/logout")
	public void logout(SessionStatus status) {
		status.setComplete();
	}
	
	@PostMapping("/checkId")
	public String checkId(User user, Model model) {
		User findUser = userService.getUser(user);
		if(findUser == null && user.getId().length() != 0) {
			model.addAttribute("message", "사용 가능한 id 입니다.");
		}else if(user.getId().length() == 0) {
			model.addAttribute("message", "");
		}else {
			model.addAttribute("message", "중복된 id입니다.");
		}
		return "forward:view.jsp";
	}
	
	@DeleteMapping("/deleteUser")
	public void deleteUser(@ModelAttribute("user") User sessionUser) {
		
		if (sessionUser.getId() == null) {
			System.out.println("로그인 필요");
		}
		
		boolean result = userService.deleteUser(sessionUser);
		
		if(result) {
			System.out.println("삭제 완료");
		}else {
			System.out.println("해당 아이디 없음.");
		}
	}
	
	@PutMapping("/updateUser") 
	public void updateUser(@ModelAttribute("user") User sessionUser, User user) {
		
		if (sessionUser.getId() == null) {
			System.out.println("로그인 필요");
		} 
		boolean result = userService.updateUser(user);
		
		if (result) {
			System.out.println("업데이트 완료");
		} else {
			System.out.println("해당 유저의 id 재확인 바람.");
		}
	}

}
