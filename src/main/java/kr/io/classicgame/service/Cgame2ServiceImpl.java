package kr.io.classicgame.service;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;

import kr.io.classicgame.dao.Cgame2Repository;
import kr.io.classicgame.domain.Cgame2;

@Service
public class Cgame2ServiceImpl implements Cgame2Service{
	
	@Autowired
	private Cgame2Repository cgame2Repo;
	
	public void insertCgame2(Cgame2 cgame2) {
		cgame2Repo.save(cgame2);
	}
}
