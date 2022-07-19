package kr.io.classicgame.dao;

import java.util.Optional;

import org.springframework.data.jpa.repository.JpaRepository;

import kr.io.classicgame.domain.Cgame3;

public interface Cgame3Repository extends JpaRepository<Cgame3, Integer>{
	
	public abstract Optional<Cgame3> findByNickname(String nickname);
}
