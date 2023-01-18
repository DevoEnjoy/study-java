package dao;

import java.io.BufferedReader;
import java.io.BufferedWriter;
import java.io.IOException;
import java.util.ArrayList;
import java.util.Collections;
import java.util.HashSet;
import java.util.stream.Collectors;

import vo.BoyVO;
import vo.GirlVO;
import vo.ModelVO;
import vo.NameDTO;

public class NameDAO {

	public ArrayList<BoyVO> boys;
	public ArrayList<GirlVO> girls;

//	����
//	�� ���� ������ �ϳ��� ���ο� ���Ϸ� �����Ѵ�.
//	path1 : ���� ���� ��� 1
//	path2 : ���� ���� ��� 2
//	path3 : ���յ� ������ ����� ���
	public void merge(String path1, String path2, String path3) throws IOException {
		String line = null;
		String temp = "";

//		���� ���� ����		
		boys = new ArrayList<BoyVO>();
		// boys ��̸���Ʈ ����

//		���� ���� ����
		girls = new ArrayList<GirlVO>();
		// girls ��̸���Ʈ ����

		BoyDAO boyDAO = new BoyDAO();
		GirlDAO girlDAO = new GirlDAO();
//		������ ���� BoyDAO�� GirlDAO ����

//		���� ���� �о���̱�
		BufferedReader boyReader = DBConnecter.getReader(path1);
//		DBConnecter�� �̿��ؼ� ���� �Է�

		while ((line = boyReader.readLine()) != null) {
//			���� ������ ��� ������ while�� ����
			temp += line + "\n";
//			������� ������ �о���� ������ temp�� �̾���
			boys.add(boyDAO.setModel(line));
//			boys ��̸���Ʈ�� DAO�� setModel�� �̿��� �̸�, ����, �α����� ���� ���
		}
		boyReader.close();
//		boy �о���̱� ����

//		���� ���� �о���̱�
		BufferedReader girlReader = DBConnecter.getReader(path2);
//		DBConnecter�� �̿��ؼ� ���� �Է�

		while ((line = girlReader.readLine()) != null) {
			temp += line + "\n";
			girls.add(girlDAO.setModel(line));
		}
		girlReader.close();

//		���ο� ���� ���� �� ���		
		BufferedWriter bw = DBConnecter.getWriter(path3);
//		DBConnecter�� Writer ����� ȣ��
		bw.write(temp);
//		temp�� path3 ��ο� ���
		bw.close();
//		BufferedWriter ����
	}

//	��ŷ����
//	���յ� ������ ��θ� ���޹޴´�.
	int ranking = 1;
//	��ŷ ������ 1������
	String temp = "";
//	�ؽ�Ʈ ������ ���� ���� temp
	int count = 0;

	public void updateRanking(String path) throws IOException {
//		boys, girls �� ArrayList�� ������ ArrayList
		ArrayList<ModelVO> datas = new ArrayList<ModelVO>();
//		��ü ���� �� �α� ���� ����� ArrayList
		ArrayList<Integer> arListPopulations = new ArrayList<Integer>();
//		�α� �� �߿��� �ߺ��� ������ HashSet
		HashSet<Integer> hashSetPopulations = new HashSet<Integer>();

//		boys, girls ��ü�� ��� ������ datas�� ���
		datas.addAll(boys);
		datas.addAll(girls);

//		�� ��ü�� �α������� ���� arListPopulations�� ���
		datas.stream().map(ModelVO::getPopulation).collect(Collectors.toList());
		/* forEach(arListPopulations::add) */
		
		//	3��
//		boys.stream().map(v -> v.getPopulation()).forEach(arListPopulations::add);
//		girls.stream().map(v -> v.getPopulation()).forEach(arListPopulations::add);

		//	����
		arListPopulations.stream().map(hashSetPopulations::add);	//	�ߺ� ����
		arListPopulations = new ArrayList<Integer>(hashSetPopulations); //	�ߺ� ���ŵ� ��ü ArrayList�� ���

		//	2��
//		//	�ߺ� ����
//		for (Integer popu : arListPopulations) {
//			hashSetPopulations.add(popu);
//		}

//		//	�ߺ� ���ŵ� ��ü ArrayList�� ���
//		for (Integer popu : hashSetPopulations) {
//			arListPopulations.add(popu);
//		}

		//	1��
////		�α� �� �ߺ� ����
//		populationSet = new HashSet(populations);
////		���� �ο�
//		populations = new ArrayList<Integer>(populationSet);

//		Collections.sort(populations);
//		�ߺ��� ���ŵ� �α��� �������� ����
		
		
		arListPopulations = (ArrayList<Integer>)	//	List�� ��ȯ�� ���� ArrayList�� 
				arListPopulations.stream()	//	������ ���� stream()
				.sorted(Collections.reverseOrder())	//	�������� ����
				.collect(Collectors.toList());	//	����Ʈ�� ��ȯ	
		for (Integer population : arListPopulations) {	//	�α��� �ϳ��� ������� population�� �ӽ÷� ��� �񱳿� ��
			count = 0;	//	�ߺ�ī��Ʈ ���� �ʱ�ȭ
			for (Object vo : datas) {	//	��� ����(���� + ����)�� �ϳ��� vo�� �ӽ÷� ��� Ȯ���Ѵ�
				
				if (vo instanceof BoyVO) { // ���� ������?
					BoyVO boyVO = (BoyVO) vo;	//	population�ʵ忡 �����ϱ� ���ؼ� down casting ����
					if (boyVO.getPopulation() == population) { // �̹� ������������ ���ĵ� ���ھ����� �α� ���� ��ü �������� ���Ѵ�.
						NameDTO result = new NameDTO();	//	�ش� �α��� ���� ��ü�� ã�Ҵٸ�

						result.setName(boyVO.getName());//	NameDTO�� �־��ش�.
						result.setRanking(ranking);
						result.setPopulation(boyVO.getPopulation());
						result.setGender("B");
						
						temp += result;	//	�ش� ����� temp�� �������ش�.
						count++;	//	���ھ��̿� ���ھ��� �� �� ������ �α� ���� ��� count�� 2�� �ȴ�.
					}
				}

				if (vo instanceof GirlVO) {
					GirlVO girlVO = (GirlVO) vo;
					if (girlVO.getPopulation() == population) {
						NameDTO result = new NameDTO();

						result.setName(girlVO.getName());
						result.setRanking(ranking);
						result.setPopulation(girlVO.getPopulation());
						result.setGender("G");

						temp += result;
						count++;
					}
				}
			}
			
//			���� �α� ���� �����ϸ�,
//			���� �α� �� ��ŭ�� ���� ��ŷ�� �ݿ��Ѵ�.
			if (count > 1) {
				ranking += count;
				continue;
			}
//			if (count > 1) {
//				ranking += count - 1;
//			}
			ranking++;
		}
		BufferedWriter bw = DBConnecter.getWriter(path);
		bw.write(temp);
		bw.close();
	}
}
