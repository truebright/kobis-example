package kr.hoseo.kobis.example;

import lombok.Data;

@Data
public class BoxOfficeMovie {
	private int rnum;
	private int rank;
	private int rankInten;
	private String rankOldAndNew;
	private String movieCd;
	private String movieNm;
	private String openDt;
	private long salesAmt;
	private float salesShare;
	private float salesInten;
	private float salesChange;
	private float salesAcc;
	private long audiCnt;
	private float audiAcc;
	private float audiInten;
	private float audiChange;
	private long scrnCnt;
	private long showCnt;
}
