package kr.io.classicgame.service;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;

import kr.io.classicgame.dao.Cgame3Repository;
import kr.io.classicgame.domain.Cgame3;

@Service
public class Cgame3ServiceImpl implements Cgame3Service{

	@Autowired
	private Cgame3Repository cgame3Repo;
	
	public void insertCgame3(Cgame3 cgame3) {
		cgame3Repo.save(cgame3);
	}
}
