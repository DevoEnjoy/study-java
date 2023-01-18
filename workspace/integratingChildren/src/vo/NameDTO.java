package vo;

public class NameDTO {
	private String name;
	private int ranking;
	private int population;
	private String gender;

	public NameDTO() {;}

	public String getName() {
		return name;
	}

	public void setName(String name) {
		this.name = name;
	}

	public int getRanking() {
		return ranking;
	}

	public void setRanking(int ranking) {
		this.ranking = ranking;
	}

	public int getPopulation() {
		return population;
	}

	public void setPopulation(int population) {
		this.population = population;
	}

	public String getGender() {
		return gender;
	}

	public void setGender(String gender) {
		this.gender = gender;
	}

	@Override
	public String toString() {
		String str = null;
//		���� �α����� ���ڿ��� ��ȯ
		String data = String.valueOf(population);
		String populationWithComma = "";

		for (int i = 0; i < data.length(); i++) {
//			i�� 3�� ����� ��� ���� �ڸ� ������ �ϳ��� ������ �־��ش�.
			if (i % 3 == 0 && i != 0) {
				populationWithComma = "," + populationWithComma;
			}
			populationWithComma = data.charAt(data.length() - i - 1) + populationWithComma;
		}

		//	����
		if (name.length() == 1) {
			name += "\t";
		}
		if (ranking < 100 && population <= 10_000) {
			name += "\t";
		}
		return gender + "\t" + ranking + "\t" + name + "\t" + populationWithComma + "\n";

		//	2��
//		if (ranking < 100 && population > 10_000) {
//			return ranking + "\t" + name + "\t" + populationWithComma + "\t" + gender + "\n";
//		} else if (ranking < 100 && population <= 10_000) {
//			return ranking + "\t" + name + "\t\t" + populationWithComma + "\t" + gender + "\n";
//		} else {
//			return ranking + "\t" + name + "\t" + populationWithComma + "\t" + gender + "\n";
//		}
		
		//	1��
//		str = ranking + "\t";
//
//		if (ranking < 100) {
//			str += "\t";
//		}
//
//		str += name + "\t";
//
//		if (name.length() == 1) {
//			str += "\t";
//		}
//
//		str += /* population */populationWithComma + "\t";
//
//		if (population < 10000) {
//			str += "\t";
//		}
//
//		str += gender + "\n";
//
//		return str;
	}

}
