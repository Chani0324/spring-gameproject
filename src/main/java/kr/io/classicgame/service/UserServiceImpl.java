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

	// mail에 unique를 나중에 적용함. 그래서 이전에 설정한 List형태로 메소드 만들어있음. 나중 참고용으로 따로 수정은 안함.
	public List<User> getMail(User user) {
		List<User> findUser = userRepo.findAllByMail(user.getMail());
		if (findUser != null) {
			return findUser;
		} else {
			return Collections.<User>emptyList();
		}
	}

	// nickname에 unique를 나중에 적용함. 그래서 이전에 설정한 List형태로 메소드 만들어있음. 나중 참고용으로 따로 수정은 안함.
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

		User findUser = userRepo.findById(user.getId()).get();
		List<User> findMail = userRepo.findAllByMail(user.getMail());
		List<User> findNickname = userRepo.findAllByNickname(user.getNickname());

		if (findMail.size() == 0 && findNickname.size() == 0) {

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
