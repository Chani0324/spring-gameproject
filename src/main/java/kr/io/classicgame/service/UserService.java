package kr.io.classicgame.service;

import java.util.List;

import kr.io.classicgame.domain.User;

public interface UserService {
	
	boolean insertUser(User user);
	
	User getUser(User user);
	
	boolean updateUser(User user);
	
	boolean deleteUser(User user);
	
	List<User> getMail(User user);
	
	List<User> getNickname(User user);
	
}
