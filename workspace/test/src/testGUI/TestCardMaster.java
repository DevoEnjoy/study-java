package testGUI;

import java.awt.Button;
import java.awt.Dimension;
import java.awt.FlowLayout;
import java.awt.Frame;
import java.awt.TextArea;
import java.awt.Toolkit;
import java.awt.event.ActionEvent;
import java.awt.event.ActionListener;
import java.awt.event.WindowAdapter;
import java.awt.event.WindowEvent;

public class TestCardMaster extends Frame implements ActionListener {

	@Override
	public void actionPerformed(ActionEvent e) {
		switch (e.getActionCommand()) {
		case "고":
			btnGo();
			break;
		case "다이":
			btnDie();
			break;
		}
	}

	public void btnGo() {

	}

	public void btnDie() {

	}

	public TestCardMaster() {
		super("테스트");
		
		String message = "1. 대결하기\n2. 나의 정보\n3. 나가기";
		// 메시지
		
		String depositMessage = "1. 추가금액 입력\n2. 추가금액 없이 진행";
		// 추가금 여부 입력 메시지
		Button buttonGo = new Button("고");
		Button buttonDie = new Button("다이");
		TextArea textArea = new TextArea();
		textArea.append(message);

		buttonGo.addActionListener(this);
		buttonDie.addActionListener(this);

		this.add(buttonGo);
		this.add(buttonDie);
		this.add(textArea);
		
		setLayout(new FlowLayout());
		setSize(500, 600);
		Dimension d = Toolkit.getDefaultToolkit().getScreenSize();
		int x = (d.width - this.getWidth()) / 2;
		int y = (d.height - this.getHeight()) / 2;

		setLocation(x, y);

		this.addWindowListener(new WindowAdapter() {

			@Override
			public void windowClosing(WindowEvent e) {
				System.exit(0);
			}

		});
		setVisible(true);
	}

	public static void main(String[] args) {
		new TestCardMaster();
	}
}
