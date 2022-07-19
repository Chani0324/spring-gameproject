package kr.io.classicgame.dao;

import java.util.Optional;

import org.springframework.data.jpa.repository.JpaRepository;

import kr.io.classicgame.domain.Cgame2;

public interface Cgame2Repository extends JpaRepository<Cgame2, Integer>{

	public abstract Optional<Cgame2> findByNickname(String nickname);
	
}
