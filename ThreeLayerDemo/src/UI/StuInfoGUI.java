package UI;

import java.awt.event.ActionEvent;
import java.awt.event.ActionListener;

import javax.swing.JButton;
import javax.swing.JFrame;
import javax.swing.JLabel;
import javax.swing.JPanel;
import javax.swing.JPasswordField;
import javax.swing.JTextField;

import DAL.StuInfoDAL;

public class StuInfoGUI  {
	static JPanel pane = new JPanel();
	static JFrame frame = new JFrame("��ӭʹ��ѧ������ϵͳ");
	static JLabel label = new JLabel("�û���");
	static JTextField usename = new JTextField(20);
	
	static final JLabel label1 = new JLabel("��     ��");
	static JPasswordField password = new JPasswordField(20);
	
	static JButton button = new JButton("��¼");
	static JButton button1 = new JButton("ע��");
	
	
	public static  void GUI() {
		button.addActionListener(new ActionListener() {
			public void actionPerformed(ActionEvent e) {
				String id = String.valueOf(password.getPassword());
				Boolean flag = new StuInfoDAL().checkStu(usename.getText(),id);
				if(flag == true){
					StuFuncGUI.StuUseGUI();
					button.setEnabled(false);
				}

			}
		});
		button1.addActionListener(new ActionListener(){
			public void actionPerformed(ActionEvent e) {
				StuFuncGUI.Register();
			}
		});
		frame.setVisible(true);
		frame.setBounds(200, 200, 300, 300);
		frame.setDefaultCloseOperation(JFrame.EXIT_ON_CLOSE);
		pane.add(label);
		pane.add(usename);
		pane.add(label1);
		pane.add(password);
		pane.add(button);
		pane.add(button1);
		frame.add(pane);

	}

	
		public static void main(String [] args) {
			GUI();
		}
}
