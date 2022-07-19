package kr.io.classicgame.service;

import java.util.Optional;

import javax.transaction.Transactional;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;

import kr.io.classicgame.dao.Cgame1Repository;
import kr.io.classicgame.domain.Cgame1;

@Service
public class Cgame1ServiceImpl implements Cgame1Service {

	@Autowired
	private Cgame1Repository cgame1Repo;

	public Optional<Cgame1> getNickname(Cgame1 cgame1) {
		Optional<Cgame1> findNickname = cgame1Repo.findByNickname(cgame1.getNickname());
		
		if(findNickname.isPresent()) {
			return findNickname;
		} else {
			return null;
		}
	}
	
	@Transactional
	public boolean insertCgame1(Cgame1 cgame1) {

		boolean result = false;

		if(cgame1.getNickname() != null) {
			cgame1Repo.save(cgame1);
			result = true;
		}
		return result;
	}
}