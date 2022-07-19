package kr.io.classicgame.service;

import java.util.Optional;

import kr.io.classicgame.domain.Cgame3;

public interface Cgame3Service {

	boolean insertCgame3(Cgame3 cgame3);
	
	public Optional<Cgame3> getNickname(Cgame3 cgame3);
}
