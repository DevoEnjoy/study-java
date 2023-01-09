package nike;

import starbucks.Form;
import starbucks.FormAdapter;

public class Nike {
	public void register(Form form) {
		if(form instanceof FormAdapter) {
			System.out.println("무료 나눔 매장입니다.");
		}
		
		form.sell("운동화");
		
	}
	
}
