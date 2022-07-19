package kr.io.classicgame.domain;

import javax.persistence.Entity;
import javax.persistence.Id;

import lombok.AllArgsConstructor;
import lombok.Data;
import lombok.NoArgsConstructor;

@Data
@NoArgsConstructor
@AllArgsConstructor

@Entity
public class Total {
	
	@Id
	private String nickname;
	
	private int score1;
	
	private int score2;
	
	private int score3;
	
}
