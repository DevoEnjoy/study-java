package fileTest;

import java.io.BufferedWriter;
import java.io.File;
import java.io.FileWriter;
import java.io.IOException;

public class FileTest {
	public static void main(String[] args) throws IOException {

//		���� ���: ��𿡼� �ۼ��ص� ã�ư� �� �ִ� ���, C:/a/b
//		��� ���: ���� ��ġ�� ���� ����Ǵ� ���, ../a/b
		BufferedWriter bufferedWriter = null;
		bufferedWriter = new BufferedWriter(new FileWriter("src/test.txt"));

//		if (bufferedWriter != null) {
//		bufferedWriter.close();
//		//	�� �������� �ٽ� Ȯ���غ���!
//		System.gc();
//		System.runFinalization();
//		}
		
		File file = new File("src/test.txt");
		if (file.exists()) {
			file.delete();
		}
	}
}
