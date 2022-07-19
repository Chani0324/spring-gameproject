package kr.io.classicgame.service;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;

import kr.io.classicgame.dao.TotalRepository;
import kr.io.classicgame.domain.Total;

@Service
public class TotalServiceImpl implements TotalService{

	@Autowired
	private TotalRepository totalRepo;

	public void updateTotal(Total total) {
		// get으로 가져온 값이 null인 경우 @ExceptionHandler를 통해 NoSuchElementException 처리 필요.
		Total findTotal = totalRepo.findById(total.getNickname()).get();
		
		if (findTotal.getScore1() < total.getScore1()) {
			findTotal.setScore1(total.getScore1());
		} else if (findTotal.getScore2() < total.getScore2()) {
			findTotal.setScore2(total.getScore2());
		} else if (findTotal.getScore3() < total.getScore3()) {
			findTotal.setScore3(total.getScore3());
		}
		totalRepo.save(findTotal);
	}
}
