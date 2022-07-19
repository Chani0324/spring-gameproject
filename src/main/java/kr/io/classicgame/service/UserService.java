package kr.io.classicgame.service;

import kr.io.classicgame.domain.User;

public interface UserService {
	
	boolean insertUser(User user);
	
	User getUser(User user);
	
	void updateUserNickname(User user);
	
	void deleteUser(User user);
}
