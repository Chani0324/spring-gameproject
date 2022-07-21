package kr.io.classicgame.service;

import java.util.Collections;
import java.util.List;
import java.util.Optional;

import javax.transaction.Transactional;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;

import kr.io.classicgame.dao.UserRepository;
import kr.io.classicgame.domain.User;

@Service
public class UserServiceImpl implements UserService {

	@Autowired
	private UserRepository userRepo;

	public User getUser(User user) {
		Optional<User> findUser = userRepo.findById(user.getId());
		if (findUser.isPresent()) {
			return findUser.get();
		} else {
			return null;
		}
	}
	
	public List<User> getMail(User user) {
		List<User> findUser = userRepo.findAllByMail(user.getMail());
		if (findUser != null) {
			return findUser;
		} else {
			return Collections.<User>emptyList();
		}
	}
	
	public List<User> getNickname(User user) {
		List<User> findUser = userRepo.findAllByNickname(user.getNickname());
		if (findUser != null) {
			return findUser;
		} else {
			return Collections.<User>emptyList();
		}
	}
	
	
	
	
	
	@Transactional
	public boolean insertUser(User user) {
		// null인 경우 @ExceptionHandler를 통해 예외처리 필요. 닉네임, mail도 검증 필요.
		boolean result = false;

		if (getUser(user) == null) {
			userRepo.save(user);
			result = true;
		}
		return result;
	}

	@Transactional
	public boolean deleteUser(User user) {

		boolean result = false;

		if (getUser(user) != null) {
			userRepo.deleteById(user.getId());
			result = true;
		}
		return result;
	}

	@Transactional
	public boolean updateUser(User user) {

		boolean result = false;

		if (getUser(user) != null) {
			User findUser = userRepo.findById(user.getId()).get();
			findUser.setNickname(user.getNickname());
			findUser.setName(user.getName());
			findUser.setPw(user.getPw());
			findUser.setMail(user.getMail());
			userRepo.save(findUser);
			result = true;
		}
		return result;
	}
}
