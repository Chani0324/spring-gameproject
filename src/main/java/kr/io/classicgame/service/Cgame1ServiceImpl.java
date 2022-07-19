package kr.io.classicgame.service;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;

import kr.io.classicgame.dao.Cgame1Repository;
import kr.io.classicgame.domain.Cgame1;

@Service
public class Cgame1ServiceImpl implements Cgame1Service{
	
	@Autowired
	private Cgame1Repository cgame1Repo;
	
	public void insertCgame1(Cgame1 cgame1) {
		cgame1Repo.save(cgame1);
	}
	
}
