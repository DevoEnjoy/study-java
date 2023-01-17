package fileTest;

import java.io.BufferedWriter;
import java.io.File;
import java.io.FileWriter;
import java.io.IOException;

public class FileTest {
	public static void main(String[] args) throws IOException {

//		절대 경로: 어디에서 작성해도 찾아갈 수 있는 경로, C:/a/b
//		상대 경로: 현재 위치에 따라 변경되는 경로, ../a/b
		BufferedWriter bufferedWriter = null;
		bufferedWriter = new BufferedWriter(new FileWriter("src/test.txt"));

//		if (bufferedWriter != null) {
//		bufferedWriter.close();
//		//	웹 서버에서 다시 확인해보자!
//		System.gc();
//		System.runFinalization();
//		}
		
		File file = new File("src/test.txt");
		if (file.exists()) {
			file.delete();
		}
	}
}
