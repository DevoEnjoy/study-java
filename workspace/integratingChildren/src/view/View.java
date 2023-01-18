package view;

import java.io.IOException;

import dao.NameDAO;

public class View {
	public static void main(String[] args) throws IOException {
		NameDAO nameDAO = new NameDAO();
		//	앞의 두 파일을 뒤의 이름으로 병합
		nameDAO.merge("boy.txt", "girl.txt", "name.txt");
		
		//	해당 내용 업데이트
		nameDAO.updateRanking("name.txt");
	}
}
