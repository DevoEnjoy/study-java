package dao;

import vo.GirlVO;

//	��)
//����	1	36,825
//����	2	36,327
//����	3	31,748

public class GirlDAO {
	
	//	�� ���� ����String�� Object(VO)�� �ٲٴ� �� ��
	public GirlVO setModel(String line) {
		
		//	�� ���� ������ �� �� \t�� �������� split �޼ҵ� ���
		String[] datas = line.split("\t");
		
		//	return�� VO��ü ����
		GirlVO girlVO = new GirlVO();
		
		//	split���� ���� 0�� ���� ���� ��ü�� �̸��� ����
		girlVO.setName(datas[0]);
		
		//	split���� ���� 1�� ���� ���� ��ü�� ������ ����
		girlVO.setRanking(Integer.valueOf(datas[1]));
		
		girlVO.setPopulation(Integer	//	split���� ���� 2�� ���� ���� ��ü�� �α����� ����
				.valueOf(removeComma(datas[2])));	//	��� ���� ��ǥ�� ����
		return girlVO;	//	�׷��� ���õ� VO�� ������
	}
	
	//	���� ���� �޼ҵ�
	public String removeComma(String data) {
		return data.replaceAll(",", "");
	}
	
}
