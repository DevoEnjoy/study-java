package dao;

import java.io.BufferedReader;
import java.io.BufferedWriter;
import java.io.IOException;
import java.nio.file.Files;
import java.nio.file.Paths;
import java.util.ArrayList;

import domain.SalaryVO;

public class SalaryDAO {
//   추가
	public void insert(SalaryVO salaryVO) throws IOException {
		BufferedWriter bufferedWriter = DBConnecter.getAppend();
		String content = new String(Files.readAllBytes(Paths.get(DBConnecter.PATH)));
		String temp = null;
		temp = content.charAt(content.length() - 1) == '\n' ? "" : "\n";
		temp += salaryVO.toString();
		bufferedWriter.write(temp);
		bufferedWriter.close();
	}

//   수정(소득세)
	public void update(SalaryVO salaryVO) throws IOException {
		BufferedReader bufferedReader = DBConnecter.getReader();
		String line = null, temp = "";

		while ((line = bufferedReader.readLine()) != null) {
			if (line.split("   ")[0].equals(insertComma(salaryVO.getSalary()) + "만원")) {
				String data = line.substring(0, line.lastIndexOf("   "));

				temp += data.substring(0, data.lastIndexOf("   ")) + "   " + insertComma(salaryVO.getIncomeTax())
						+ "   " + insertComma(salaryVO.getLocalTax()) + "\n";
				continue;
			}
			temp += line + "\n";
		}
		BufferedWriter bufferedWriter = DBConnecter.getWriter();
		bufferedWriter.write(temp);

		bufferedWriter.close();
		bufferedReader.close();
	}

//	삭제
	public void delete(String salary) throws IOException {
		BufferedReader bufferedReader = DBConnecter.getReader();
		String line = null, temp = null;
		final String TARGET = salary;
		while ((line = bufferedReader.readLine()) != null) {
			if (line.startsWith(TARGET)) {
				continue;
			}
			temp += line + "\n";
		}
		BufferedWriter bufferedWriter = DBConnecter.getWriter();
		bufferedWriter.write(temp);

		bufferedWriter.close();
		bufferedReader.close();

	}
	
//	삭제by int
	public void delete(int salary) throws IOException {
		BufferedReader bufferedReader = DBConnecter.getReader();
		String line = null, temp = null;
		final String TARGET = insertComma(salary) + "만원";
		while ((line = bufferedReader.readLine()) != null) {
			if (line.startsWith(TARGET)) {
				continue;
			}
			temp += line + "\n";
		}
		BufferedWriter bufferedWriter = DBConnecter.getWriter();
		bufferedWriter.write(temp);

		bufferedWriter.close();
		bufferedReader.close();
	}

//	조회
	public SalaryVO select(int salary) throws IOException {
		BufferedReader bufferedReader = DBConnecter.getReader();
		String line = null;
		SalaryVO result = new SalaryVO();
		final int TARGET = salary;
		while ((line = bufferedReader.readLine()) != null) {
			if ((insertComma(TARGET) + "만원").equals(line.split("   ")[0])) {
				result = removeComma(line);
				break;
			}
		}
		return result;
	}

//	목록
	public ArrayList<SalaryVO> selectAll() throws IOException {
		BufferedReader bufferedReader = DBConnecter.getReader();
		ArrayList<SalaryVO> arListResult = new ArrayList<SalaryVO>();
		String line = null;
		while ((line = bufferedReader.readLine()) != null) {
			arListResult.add(removeComma(line));
		}
		return arListResult;
	}

//	반점 넣기
	public static String insertComma(int number) {
		String temp = String.valueOf(number);
		String result = "";

		for (int i = 0; i < temp.length(); i++) {
			if (i != 0 && i % 3 == 0) {
				result = "," + result;
			}
			result = temp.charAt(temp.length() - 1 - i) + result;
		}
		return result;
	}

//	반점 제거 SalaryVO 리턴
	public static SalaryVO removeComma(String line) {
		SalaryVO salaryVO = new SalaryVO();
		String[] arTemp = line.split("   ");
		arTemp[0] = arTemp[0].replaceAll("만원", "");
		for (int i = 0; i < arTemp.length; i++) {
			arTemp[i] = arTemp[i].replaceAll(",", "");
		}

		salaryVO.setSalary(Integer.parseInt(arTemp[0]));
		salaryVO.setNetPay(Integer.parseInt(arTemp[1]));
		salaryVO.setTaxDeductionAmount(Integer.parseInt(arTemp[2]));
		salaryVO.setPension(Integer.parseInt(arTemp[3]));
		salaryVO.setHealthInsurance(Integer.parseInt(arTemp[4]));
		salaryVO.setLongTermCarePay(Integer.parseInt(arTemp[5]));
		salaryVO.setEmploymentInsurance(Integer.parseInt(arTemp[6]));
		salaryVO.setIncomeTax(Integer.parseInt(arTemp[7]));
		salaryVO.setLocalTax(Integer.parseInt(arTemp[8]));
		return salaryVO;
	}

////	readLine을 SalaryVO타입으로
//	private static SalaryVO toVo(String line) {
//		SalaryVO result = new SalaryVO();
//		result.setSalary(Integer.parseInt(removeComma(line.split("   ")[0]).getSalary()));
//		
//		
//		
//		
//		
//		return result;
//	}

}
