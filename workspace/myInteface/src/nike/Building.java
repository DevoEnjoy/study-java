package nike;

import starbucks.Form;
import starbucks.FormAdapter;

public class Building {
	public static void main(String[] args) {
		Nike jamsil = new Nike();
		Nike gangnam = new Nike();

		jamsil.register(new Form() {

			@Override
			public void sell(String menu) {
				String[] arMenu = getMenu();
				for (int i = 0; i < arMenu.length; i++) {
					if (arMenu[i].equals(menu)) {
						System.out.println(menu + " 판매 완료되었습니다.");
					}
				}
			}

			@Override
			public String[] getMenu() {
//				String[] arMenu = {
//					"물"
//				};
//				return arMenu;
				
				return new String[] {"운동화", "바지"};
			}
		});

		gangnam.register(new FormAdapter() {

			@Override
			public String[] getMenu() {

				return new String[] {"물"};
			}
		});

	}
}
