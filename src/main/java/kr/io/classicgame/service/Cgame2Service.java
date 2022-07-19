package kr.io.classicgame.service;

import java.util.Optional;

import kr.io.classicgame.domain.Cgame2;

public interface Cgame2Service {

	boolean insertCgame2(Cgame2 cgame2);
	
	public Optional<Cgame2> getNickname(Cgame2 cgame2);
}
