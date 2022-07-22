package kr.io.classicgame.domain;

import javax.persistence.Column;
import javax.persistence.Entity;
import javax.persistence.Id;

import io.swagger.annotations.ApiModel;
import io.swagger.annotations.ApiModelProperty;
import lombok.AllArgsConstructor;
import lombok.Data;
import lombok.NoArgsConstructor;

@Data
@NoArgsConstructor
@AllArgsConstructor

@Entity
@ApiModel(value="가입한 유저의 정보를 저장", description = "ID, PW, E-MAIL, 이름, 닉네임을 보유한 Domain class")
public class User {
	
	@Id
	@ApiModelProperty(example="n1")
	private String id;
	
	@ApiModelProperty(example="n1")
	private String pw;
	
	@Column(unique=true)
	@ApiModelProperty(example="n1@naver.com")
	private String mail;
	
	@ApiModelProperty(example="n1")
	private String name;
	
	@ApiModelProperty(example="n1")
	@Column(unique=true)
	private String nickname;
	
}
