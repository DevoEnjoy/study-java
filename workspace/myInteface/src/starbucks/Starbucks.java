package starbucks;

public class Starbucks {
	
//	String[] arMenu;
	
	public void register(Form form) {
		if(form instanceof FormAdapter) {
			System.out.println("무료 나눔 매장입니다.");
		}
		String[] arMenu = form.getMenu();
		for (int i = 0; i < arMenu.length; i++) {
			System.out.println(i + 1 + ". " + arMenu[i]);
		}
		
//		form.sellType();
//		for (int i = 0; i < form.getMenu().length; i++) {
//			System.out.println(form.getMenu()[i]);
//		};
		
		
//		this.arMenu = form.getMenu();
		
//		this.printarMenu(form.getMenu());
	}

//	public String[] getArMenu() {
//		return this.arMenu;
//	}
	
//	public void printarMenu(String[] menu) {
//		for (int i = 0; i < menu.length; i++) {
//			System.out.println(i+1+". " + menu[i]);
//		}
//	}

}
