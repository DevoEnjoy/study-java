package dao;

import vo.GirlVO;

//	예)
//서연	1	36,825
//서윤	2	36,327
//지우	3	31,748

public class GirlDAO {
	
	//	각 줄의 정보String을 Object(VO)로 바꾸는 셋 모델
	public GirlVO setModel(String line) {
		
		//	각 줄의 정보를 탭 즉 \t를 기준으로 split 메소드 사용
		String[] datas = line.split("\t");
		
		//	return할 VO객체 생성
		GirlVO girlVO = new GirlVO();
		
		//	split으로 나눈 0번 방의 값을 객체의 이름에 담음
		girlVO.setName(datas[0]);
		
		//	split으로 나눈 1번 방의 값을 객체의 순위에 담음
		girlVO.setRanking(Integer.valueOf(datas[1]));
		
		girlVO.setPopulation(Integer	//	split으로 나눈 2번 방의 값을 객체의 인구수에 담음
				.valueOf(removeComma(datas[2])));	//	담기 전에 쉼표를 지움
		return girlVO;	//	그렇게 세팅된 VO를 리턴함
	}
	
	//	반점 제거 메소드
	public String removeComma(String data) {
		return data.replaceAll(",", "");
	}
	
}
