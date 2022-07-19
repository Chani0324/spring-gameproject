package kr.io.classicgame.dao;

import java.util.Optional;

import org.springframework.data.jpa.repository.JpaRepository;

import kr.io.classicgame.domain.Cgame1;

public interface Cgame1Repository extends JpaRepository<Cgame1, Integer>{

	public abstract Optional<Cgame1> findByNickname(String nickname);
	
}
