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

//	병합
//	두 개의 파일을 하나의 새로운 파일로 병합한다.
//	path1 : 기존 파일 경로 1
//	path2 : 기존 파일 경로 2
//	path3 : 병합된 내용을 출력할 경로
	public void merge(String path1, String path2, String path3) throws IOException {
		String line = null;
		String temp = "";

//		남자 정보 저장		
		boys = new ArrayList<BoyVO>();
		// boys 어레이리스트 생성

//		여자 정보 저장
		girls = new ArrayList<GirlVO>();
		// girls 어레이리스트 생성

		BoyDAO boyDAO = new BoyDAO();
		GirlDAO girlDAO = new GirlDAO();
//		병합을 위한 BoyDAO와 GirlDAO 생성

//		남자 정보 읽어들이기
		BufferedReader boyReader = DBConnecter.getReader(path1);
//		DBConnecter를 이용해서 리더 입력

		while ((line = boyReader.readLine()) != null) {
//			다음 라인이 비어 있으면 while문 종료
			temp += line + "\n";
//			비어있지 않으면 읽어들인 라인을 temp에 이어담기
			boys.add(boyDAO.setModel(line));
//			boys 어레이리스트에 DAO의 setModel을 이용해 이름, 순위, 인구수를 나눠 담기
		}
		boyReader.close();
//		boy 읽어들이기 종료

//		여자 정보 읽어들이기
		BufferedReader girlReader = DBConnecter.getReader(path2);
//		DBConnecter를 이용해서 리더 입력

		while ((line = girlReader.readLine()) != null) {
			temp += line + "\n";
			girls.add(girlDAO.setModel(line));
		}
		girlReader.close();

//		새로운 파일 생성 후 출력		
		BufferedWriter bw = DBConnecter.getWriter(path3);
//		DBConnecter의 Writer 기능을 호출
		bw.write(temp);
//		temp를 path3 경로에 출력
		bw.close();
//		BufferedWriter 종료
	}

//	랭킹수정
//	병합된 파일의 경로를 전달받는다.
	int ranking = 1;
//	랭킹 시작은 1위부터
	String temp = "";
//	텍스트 내용을 담을 변수 temp
	int count = 0;

	public void updateRanking(String path) throws IOException {
//		boys, girls 두 ArrayList를 병합할 ArrayList
		ArrayList<ModelVO> datas = new ArrayList<ModelVO>();
//		전체 정보 중 인구 수만 담아줄 ArrayList
		ArrayList<Integer> arListPopulations = new ArrayList<Integer>();
//		인구 수 중에서 중복을 제거할 HashSet
		HashSet<Integer> hashSetPopulations = new HashSet<Integer>();

//		boys, girls 객체의 모든 정보를 datas에 담기
		datas.addAll(boys);
		datas.addAll(girls);

//		각 객체의 인구수만을 전부 arListPopulations에 담기
		datas.stream().map(ModelVO::getPopulation).collect(Collectors.toList());
		/* forEach(arListPopulations::add) */
		
		//	3차
//		boys.stream().map(v -> v.getPopulation()).forEach(arListPopulations::add);
//		girls.stream().map(v -> v.getPopulation()).forEach(arListPopulations::add);

		//	최종
		arListPopulations.stream().map(hashSetPopulations::add);	//	중복 제거
		arListPopulations = new ArrayList<Integer>(hashSetPopulations); //	중복 제거된 객체 ArrayList에 담기

		//	2차
//		//	중복 제거
//		for (Integer popu : arListPopulations) {
//			hashSetPopulations.add(popu);
//		}

//		//	중복 제거된 객체 ArrayList에 담기
//		for (Integer popu : hashSetPopulations) {
//			arListPopulations.add(popu);
//		}

		//	1차
////		인구 수 중복 제거
//		populationSet = new HashSet(populations);
////		순서 부여
//		populations = new ArrayList<Integer>(populationSet);

//		Collections.sort(populations);
//		중복이 제거된 인구수 내림차순 정렬
		
		
		arListPopulations = (ArrayList<Integer>)	//	List로 변환된 것을 ArrayList로 
				arListPopulations.stream()	//	정렬을 위한 stream()
				.sorted(Collections.reverseOrder())	//	내림차순 정렬
				.collect(Collectors.toList());	//	리스트로 변환	
		for (Integer population : arListPopulations) {	//	인구수 하나씩 순서대로 population에 임시로 담아 비교에 씀
			count = 0;	//	중복카운트 변수 초기화
			for (Object vo : datas) {	//	모든 정보(남자 + 여자)를 하나씩 vo에 임시로 담아 확인한다
				
				if (vo instanceof BoyVO) { // 남자 정보니?
					BoyVO boyVO = (BoyVO) vo;	//	population필드에 접근하기 위해서 down casting 수행
					if (boyVO.getPopulation() == population) { // 이미 내림차순으로 정렬된 남자아이의 인구 수를 전체 정보에서 비교한다.
						NameDTO result = new NameDTO();	//	해당 인구를 가진 객체를 찾았다면

						result.setName(boyVO.getName());//	NameDTO에 넣어준다.
						result.setRanking(ranking);
						result.setPopulation(boyVO.getPopulation());
						result.setGender("B");
						
						temp += result;	//	해당 결과를 temp에 누적해준다.
						count++;	//	남자아이와 여자아이 둘 다 동일한 인구 수일 경우 count는 2가 된다.
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
			
//			공동 인구 수가 존재하면,
//			공동 인구 수 만큼을 다음 랭킹에 반영한다.
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
