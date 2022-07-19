package kr.io.classicgame.service;

import kr.io.classicgame.domain.User;

public interface UserService {
	
	boolean insertUser(User user);
	
	User getUser(User user);
	
	boolean updateUser(User user);
	
	boolean deleteUser(User user);
}
