package kr.io.classicgame.domain;

import javax.persistence.Entity;
import javax.persistence.GeneratedValue;
import javax.persistence.GenerationType;
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
	@GeneratedValue(strategy = GenerationType.IDENTITY) 
	private int num;
	
	private String nickname;
	
	private int score2;

}
