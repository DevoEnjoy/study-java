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
		case "��":
			btnGo();
			break;
		case "����":
			btnDie();
			break;
		}
	}

	public void btnGo() {

	}

	public void btnDie() {

	}

	public TestCardMaster() {
		super("�׽�Ʈ");
		
		String message = "1. ����ϱ�\n2. ���� ����\n3. ������";
		// �޽���
		
		String depositMessage = "1. �߰��ݾ� �Է�\n2. �߰��ݾ� ���� ����";
		// �߰��� ���� �Է� �޽���
		Button buttonGo = new Button("��");
		Button buttonDie = new Button("����");
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
