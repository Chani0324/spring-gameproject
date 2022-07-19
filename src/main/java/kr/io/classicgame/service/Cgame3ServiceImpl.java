package kr.io.classicgame.service;

import java.util.Optional;

import javax.transaction.Transactional;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;

import kr.io.classicgame.dao.Cgame3Repository;
import kr.io.classicgame.domain.Cgame3;

@Service
public class Cgame3ServiceImpl implements Cgame3Service{

	@Autowired
	private Cgame3Repository cgame3Repo;
	
	public Optional<Cgame3> getNickname(Cgame3 cgame3) {
		Optional<Cgame3> findNickname = cgame3Repo.findByNickname(cgame3.getNickname());
		
		if(findNickname.isPresent()) {
			return findNickname;
		} else {
			return null;
		}
	}
	
	@Transactional
	public boolean insertCgame3(Cgame3 cgame3) {

		boolean result = false;

		if(cgame3.getNickname() != null) {
			cgame3Repo.save(cgame3);
			result = true;
		}
		return result;
	}
}
