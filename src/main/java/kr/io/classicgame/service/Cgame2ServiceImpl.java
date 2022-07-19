package kr.io.classicgame.service;

import java.util.Optional;

import javax.transaction.Transactional;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;

import kr.io.classicgame.dao.Cgame2Repository;
import kr.io.classicgame.domain.Cgame2;

@Service
public class Cgame2ServiceImpl implements Cgame2Service{
	
	@Autowired
	private Cgame2Repository cgame2Repo;
	
	public Optional<Cgame2> getNickname(Cgame2 cgame2) {
		Optional<Cgame2> findNickname = cgame2Repo.findByNickname(cgame2.getNickname());
		
		if(findNickname.isPresent()) {
			return findNickname;
		} else {
			return null;
		}
	}
	
	@Transactional
	public boolean insertCgame2(Cgame2 cgame2) {

		boolean result = false;

		if(cgame2.getNickname() != null) {
			cgame2Repo.save(cgame2);
			result = true;
		}
		return result;
	}
	
	
	
}
