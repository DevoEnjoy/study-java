package dao;

import vo.BoyVO;

public class BoyDAO {
	//	�ּ��� GirlDAO�� ����
	
	public BoyVO setModel(String line) {
		
		String[] datas = line.split("\t");
		BoyVO boyVO = new BoyVO();
		int i = 0;
		boyVO.setName(datas[i++]);
		boyVO.setRanking(Integer.parseInt(datas[i++]));
		boyVO.setPopulation(Integer.parseInt(removeComma(datas[i++])));

		return boyVO;
	}
	
	public String removeComma(String data) {
		return data.replaceAll(",", "");
	}
	
	
	
}
