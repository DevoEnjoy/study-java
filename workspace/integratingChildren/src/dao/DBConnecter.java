package dao;

import java.io.BufferedReader;
import java.io.BufferedWriter;
import java.io.FileReader;
import java.io.FileWriter;
import java.io.IOException;

public class DBConnecter {
	
	//	입력된 경로에 따라 각 메소드 실행
	public static BufferedWriter getWriter(String path) throws IOException{
		return new BufferedWriter(new FileWriter(path));
	}
	
	public static BufferedWriter getAppend(String path) throws IOException{
		return new BufferedWriter(new FileWriter(path, true));
	}
	
	public static BufferedReader getReader(String path) throws IOException{
		return new BufferedReader(new FileReader(path));
	}
}
