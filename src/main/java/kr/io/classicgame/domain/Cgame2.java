package kr.io.classicgame.domain;

import javax.persistence.Entity;
import javax.persistence.GeneratedValue;
import javax.persistence.GenerationType;
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
@ApiModel(value="뱀꼬리 게임 기록", description = "게임실행 순서, 닉네임, 뱀꼬리 게임 기록을 보유한 Domain class")
public class Cgame2 {
	
	@Id
	@GeneratedValue(strategy = GenerationType.IDENTITY)
	@ApiModelProperty(example="1")
	private int num;
	
	@ApiModelProperty(example="n1")
	private String nickname;
	
	@ApiModelProperty(example="2222")
	private int score2;

}
