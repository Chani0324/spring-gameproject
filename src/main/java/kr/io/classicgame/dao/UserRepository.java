package kr.io.classicgame.dao;

import java.util.List;

import org.springframework.data.jpa.repository.JpaRepository;

import kr.io.classicgame.domain.User;

public interface UserRepository extends JpaRepository<User, String>{
	
	public abstract List<User> findAllByNickname(String nickname);
	
	public abstract List<User> findAllByMail(String mail);
	
}
