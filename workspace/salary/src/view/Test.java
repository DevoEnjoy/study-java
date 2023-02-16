package view;

import java.io.IOException;

import dao.SalaryDAO;
import domain.SalaryVO;

public class Test {
	public static void main(String[] args) throws IOException {
		SalaryVO salaryVO = new SalaryVO();
		SalaryDAO salaryDAO = new SalaryDAO();
//      
      salaryVO.setSalary(3500);
//      salaryVO.setIncomeTax(1000000);
//      salaryVO.setNetPay(9_000_000);

		// 추가
//      salaryDAO.insert(salaryVO);

		// 수정
//      salaryDAO.update(salaryVO);

		// 삭제
//      salaryDAO.delete("7,900만원");

		// 조회
//      System.out.println(salaryDAO.select("6,400만원"));;

      	// -실험-
//		System.out.println(SalaryDAO.removeComma("3,500만원   2,580,346   336,320   126,740   87,870   6,480   18,300   88,120   8,810"));
		
		// 목록
//		salaryDAO.selectAll().forEach(System.out::println);
	}
}