package kr.io.classicgame.dao;

import org.springframework.data.jpa.repository.JpaRepository;

import kr.io.classicgame.domain.User;

public interface UserRepository extends JpaRepository<User, String>{

}
