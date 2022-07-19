package kr.io.classicgame.controller;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.ui.Model;
import org.springframework.web.bind.annotation.DeleteMapping;
import org.springframework.web.bind.annotation.GetMapping;
import org.springframework.web.bind.annotation.ModelAttribute;
import org.springframework.web.bind.annotation.PostMapping;
import org.springframework.web.bind.annotation.PutMapping;
import org.springframework.web.bind.annotation.RestController;
import org.springframework.web.bind.annotation.SessionAttributes;
import org.springframework.web.bind.support.SessionStatus;

import kr.io.classicgame.domain.User;
import kr.io.classicgame.service.UserService;

@SessionAttributes("User")
@RestController
public class UserController {
	
	@Autowired
	private UserService userService;
	
	@ModelAttribute("User")
	public User setUser() {
		return new User();
	}
	
	/* pw저장 시에는 비밀번호 그대로 말고 바꿔서 저장하는 기능 넣어야 할듯. */
	/* parameter에 Requestbody 넣으면 인식을 json으로 하기 때문에 html에서 controller에 전달 해줄 때 json으로 변경해야함.
	 * 보통 html에서 post나 put방식으로 보낼 때 따로 설정이 없으면 content-type은 application/x-www-form-urlencoded으로 되어있다.
	 * json으로 controller에 넘겨주려면 html에서 content-type을 application/json으로 설정 해야함. */
	@PostMapping("/signup")
	public void signUpUser(User user) {
		
		boolean result = userService.insertUser(user);
		
		if(result) {
			System.out.println("저장 성공");
		}else {
			System.out.println("저장 실패");
		}
	}

	/* 로그인 인증 방법 boot security 통해서 추가 구현 예정. */
	@PostMapping("/login") 
	public void login(User user, Model model) {
		User findUser = userService.getUser(user);
		
		/* pw검증 뒤에서 할건지 앞에서 할건지 */
		if (findUser != null && findUser.getPw().equals(user.getPw())) {
			model.addAttribute("user", findUser);
			System.out.println("로그인 성공");
		} else {
			System.out.println("로그인 실패");
		}
	}
	
	@GetMapping("/logout")
	public void logout(SessionStatus status) {
		status.setComplete();
		System.out.println("로그아웃 완료");
	}
	
	@DeleteMapping("/deleteUser")
	public void deleteUser(@ModelAttribute("User") User sessionUser) {
		
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
	public void updateUser(@ModelAttribute("User") User sessionUser, User user) {
		
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
