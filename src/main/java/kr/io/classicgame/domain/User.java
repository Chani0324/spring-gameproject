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
public class User {
	
	@Id
	private String id;
	
	private String pw;
	
	private String mail;
	
	private String name;
	
	private String nickname;
	
}
