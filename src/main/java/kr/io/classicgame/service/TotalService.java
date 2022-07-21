package kr.io.classicgame.service;

import kr.io.classicgame.domain.Total;
import kr.io.classicgame.domain.User;

public interface TotalService {

	void updateTotal(Total total);
	
	Total getUserTotal(User user);
	
}
