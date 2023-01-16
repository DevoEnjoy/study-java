package strudy230115;

public class OutterClass {
//	Name name = new Name();
	public int add1(int num1) {return num1;}
	
	private static class Name {
		private static int add1(int num1) {
			return num1;
		}
		
		public void add() {};
	}
	
	public static void main(String[] args) {
		OutterClass o = new OutterClass();
//		Name name = new Name();
		Name.add1(0);
//		add1(0);
		
		
	}
}
