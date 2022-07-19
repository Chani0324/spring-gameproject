package kr.io.classicgame.domain;

import javax.persistence.Entity;
import javax.persistence.GeneratedValue;
import javax.persistence.Id;

import lombok.AllArgsConstructor;
import lombok.Data;
import lombok.NoArgsConstructor;

@Data
@NoArgsConstructor
@AllArgsConstructor

@Entity
public class Cgame2 {
	
	@Id
	@GeneratedValue
	private int num;
	
	private String nickname;
	
	private int score2;

}
