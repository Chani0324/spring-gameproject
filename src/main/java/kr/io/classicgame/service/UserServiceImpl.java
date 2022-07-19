package kr.io.classicgame.service;

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

	public void deleteUser(User user) {
		userRepo.deleteById(user.getId());
	}

	public void updateUserNickname(User user) {
		User findUser = userRepo.findById(user.getId()).get();
		findUser.setNickname(user.getNickname());
		userRepo.save(findUser);
	}

}
