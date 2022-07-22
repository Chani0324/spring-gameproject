package kr.io.classicgame.controller;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Controller;
import org.springframework.ui.Model;
import org.springframework.web.bind.annotation.GetMapping;
import org.springframework.web.bind.annotation.ModelAttribute;
import org.springframework.web.bind.annotation.PostMapping;
import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.bind.annotation.SessionAttributes;

import io.swagger.annotations.ApiOperation;
import io.swagger.annotations.ApiResponse;
import io.swagger.annotations.ApiResponses;
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

	@ApiOperation(value = "테트리스 게임 점수 삽입", notes = "API 설명 부분 : 점수 값을 cgame1 테이블에 삽입하면서 total 테이블의 점수보다 새 점수값이 크다면 갱신해줌.")
    @ApiResponses({
            @ApiResponse(code = 200, message = "OK !!"),
            @ApiResponse(code = 500, message = "500 에러 발생시 출력 메세지, 가령 Internal Server Error !"),
            @ApiResponse(code = 404, message = "404 에러 발생시 출력 메세지, Not Found !")
    })
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

	@ApiOperation(value = "뱀꼬리 게임 점수 삽입", notes = "API 설명 부분 : 점수 값을 cgame2 테이블에 삽입하면서 total 테이블의 점수보다 새 점수값이 크다면 갱신해줌.")
    @ApiResponses({
            @ApiResponse(code = 200, message = "OK !!"),
            @ApiResponse(code = 500, message = "500 에러 발생시 출력 메세지, 가령 Internal Server Error !"),
            @ApiResponse(code = 404, message = "404 에러 발생시 출력 메세지, Not Found !")
    })
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

	@ApiOperation(value = "2048 게임 점수 삽입", notes = "API 설명 부분 : 점수 값을 cgame3 테이블에 삽입하면서 total 테이블의 점수보다 새 점수값이 크다면 갱신해줌.")
    @ApiResponses({
            @ApiResponse(code = 200, message = "OK !!"),
            @ApiResponse(code = 500, message = "500 에러 발생시 출력 메세지, 가령 Internal Server Error !"),
            @ApiResponse(code = 404, message = "404 에러 발생시 출력 메세지, Not Found !")
    })
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
	
	@ApiOperation(value = "total 테이블 값 갱신", notes = "API 설명 부분 : 내 정보 버튼을 누르면 현재 total 테이블의 값을 가져옴")
    @ApiResponses({
            @ApiResponse(code = 200, message = "OK !!"),
            @ApiResponse(code = 500, message = "500 에러 발생시 출력 메세지, 가령 Internal Server Error !"),
            @ApiResponse(code = 404, message = "404 에러 발생시 출력 메세지, Not Found !")
    })
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
