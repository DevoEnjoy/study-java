package myApiTest;

import apiTest.Calc;

public class API_TEST {
	public static void main(String[] args) {
		Calc calc = new Calc();
		System.out.println(calc.div(3, 0));;
	}
}
