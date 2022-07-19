package kr.io.classicgame.service;

import java.util.Optional;

import kr.io.classicgame.domain.Cgame1;

public interface Cgame1Service {
	
	boolean insertCgame1(Cgame1 cgame1);
	
	public Optional<Cgame1> getNickname(Cgame1 cgame1);
		
}
