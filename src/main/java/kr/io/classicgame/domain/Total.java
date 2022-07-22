package kr.io.classicgame.domain;

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
@ApiModel(value="로그인한 유저의 최신 게임 기록", description = "닉네임, 테스트리스, 뱀꼬리, 2048 게임 기록 중 최고 점수를 보유한 Domain class")
public class Total {
	
	@Id
	@ApiModelProperty(example="n1")
	private String nickname;
	
	@ApiModelProperty(example="1111")
	private int score1;
	
	@ApiModelProperty(example="2222")
	private int score2;
	
	@ApiModelProperty(example="2222")
	private int score3;
	
}
