package domain;

public class BoyVO{
	private String name;
	private int ranking;
	private int population;
	
	public BoyVO() {;}

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

	@Override
	public String toString() {
		return "BoyVO [name=" + name + ", ranking=" + ranking + ", population=" + population + "]";
	}
	
	
	
}
