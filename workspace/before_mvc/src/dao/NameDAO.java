package dao;

import java.io.BufferedReader;
import java.io.BufferedWriter;
import java.io.FileReader;
import java.io.IOException;
import java.util.ArrayList;
import java.util.Collections;
import java.util.HashSet;
import java.util.stream.Collectors;

import vo.BoyVO;
import vo.GirlVO;
import vo.NameDTO;

public class NameDAO {
	
	public ArrayList<BoyVO> boys;
	public ArrayList<GirlVO> girls;
	
	//병합
	//두 개의 파일을 하나의 새로운 파일로 병합한다.
	//path1 : 기존 파일 경로 1
	//path2 : 기존 파일 경로 2
	//path3 : 병합된 내용을 출력할 경로
	public void merge(String path1, String path2, String path3) throws IOException {
		String line = null;
		String temp = "";
//		남자 정보 저장
		boys = new ArrayList<BoyVO>();
//		여자 정보 저장
		girls = new ArrayList<GirlVO>();
		
		BoyDAO boyDAO = new BoyDAO();
		GirlDAO girlDAO = new GirlDAO();
		
		BufferedReader boyReader = DBConnecter.getReader(path1);
		
		while((line = boyReader.readLine()) != null) {
			temp += line + "\n";
			boys.add(boyDAO.setModel(line));
		}
		
		boyReader.close();
		
		BufferedReader girlReader = DBConnecter.getReader(path2);
		
		while((line = girlReader.readLine()) != null) {
			temp += line + "\n";
			girls.add(girlDAO.setModel(line));
		}
		
		girlReader.close();
		
//		새로운 파일 생성 후 출력
		BufferedWriter bw = DBConnecter.getWriter(path3);
		bw.write(temp);
		bw.close();
	}
	
	//랭킹 수정
	//병합된 파일의 경로를 전달받는다.
	public void update(String path) throws IOException{
		ArrayList<Object> datas = new ArrayList<Object>();
		ArrayList<Integer> populations = new ArrayList<Integer>();
		HashSet<Integer> populationSet = null;
		int ranking = 1;
		String temp = "";
		int count = 0;
		
		datas.addAll(boys);
		datas.addAll(girls);
		
		boys.stream().map(v -> v.getPopulation()).forEach(populations::add);
		girls.stream().map(v -> v.getPopulation()).forEach(populations::add);
		
		populationSet = new HashSet(populations);
		populations = new ArrayList<Integer>(populationSet);
		
		populations = (ArrayList<Integer>)populations.stream().sorted(Collections.reverseOrder()).collect(Collectors.toList());
		
		for (Integer population : populations) {
			count = 0;
			for (Object vo : datas) {
				if(vo instanceof BoyVO) {
					BoyVO boyVO = (BoyVO) vo;
					if(boyVO.getPopulation() == population) {
						NameDTO result = new NameDTO();
						
						result.setName(boyVO.getName());
						result.setRanking(ranking);
						result.setPopulation(boyVO.getPopulation());
						result.setGender("M");
						System.out.println(result);
						temp += result;
						count ++;
					}
				}
				
				if(vo instanceof GirlVO) {
					GirlVO girlVO = (GirlVO) vo;
					if(girlVO.getPopulation() == population) {
						NameDTO result = new NameDTO();
						
						result.setName(girlVO.getName());
						result.setRanking(ranking);
						result.setPopulation(girlVO.getPopulation());
						result.setGender("W");
						System.out.println(result);
						temp += result;
						count ++;
					}
				}
			}
			if(count > 1) { ranking += count - 1;}
			ranking++;
		}
		BufferedWriter bw = DBConnecter.getWriter(path);
		bw.write(temp);
		bw.close();
	}
}



















