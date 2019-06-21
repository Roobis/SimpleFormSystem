package UI;

import java.awt.event.ActionEvent;
import java.awt.event.ActionListener;
import java.io.File;

import javax.swing.JButton;
import javax.swing.JFileChooser;
import javax.swing.JFrame;
import javax.swing.JLabel;
import javax.swing.JOptionPane;
import javax.swing.JPanel;
import javax.swing.JPasswordField;
import javax.swing.JTextField;

import BLL.StuInfoBLL;
import BLL.StuPicBLL;
import Model.Picture;
import Model.StuInfo;
import Util.MySqlHelper;

public class StuFuncGUI {
	public static  void StuUseGUI() {
		JPanel pane = new JPanel();
		JFrame frame = new JFrame("��ӭʹ��ѧ������ϵͳ");
		JButton stuadd = new JButton("����");
		stuadd.addActionListener(new ActionListener() {
			public void actionPerformed(ActionEvent e) {
				Register();
			}
		});
		
		JButton studele = new JButton("ɾ��");
		studele.addActionListener(new ActionListener() {
			public void actionPerformed(ActionEvent e) {
				JFrame frame = new JFrame("ɾ��");
				JPanel pane = new JPanel();
				JLabel id = new JLabel("��ѧ��ɾ��");
				final JTextField userid = new JTextField(20);
				JLabel name = new JLabel("������ɾ��");
				final JTextField usename = new JTextField(20);
				JButton button = new JButton("ȷ��");
				button.addActionListener(new ActionListener() {
					public void actionPerformed(ActionEvent arg0) {
						String id = String.valueOf(userid.getText());
						String name = String.valueOf(usename.getText());
						StuInfo s = new StuInfo();
						s.setName(name);
						s.setId(id);
						new StuInfoBLL().deleteStu(s);
					}
				});
				frame.setVisible(true);
				frame.setBounds(200, 200, 300, 300);
				frame.setDefaultCloseOperation(JFrame.DISPOSE_ON_CLOSE);
				pane.add(id);
				pane.add(userid);
				pane.add(name);
				pane.add(usename);
				pane.add(button);
				frame.add(pane);
			}
		});
		
		JButton stures = new JButton("�޸�");
		stures.addActionListener(new ActionListener() {

			public void actionPerformed(ActionEvent e) {
				JFrame frame = new JFrame("�޸�");
				JPanel pane = new JPanel();
				JButton rename = new JButton("�������޸�");
				rename.addActionListener(new ActionListener() {
					public void actionPerformed(ActionEvent e) {
						JFrame frame = new JFrame("�޸�");
						JPanel pane = new JPanel();
						JLabel name = new JLabel("ԭ��������");
						final JTextField usename = new JTextField(20);
						JLabel aftername = new JLabel("�޸ĺ�����");
						final JTextField afterusename = new JTextField(20);
						JButton button = new JButton("ȷ��");
						button.addActionListener(new ActionListener() {
							public void actionPerformed(ActionEvent e) {
								String n = String.valueOf(afterusename.getText());
								StuInfo s = new StuInfo();
								s.setName(n);
								new StuInfoBLL().reciseNameStu(s,usename.getText());
							}
						});
						frame.setVisible(true);
						frame.setBounds(200, 200, 300, 300);
						frame.setDefaultCloseOperation(JFrame.DISPOSE_ON_CLOSE);
						pane.add(name);
						pane.add(usename);
						pane.add(aftername);
						pane.add(afterusename);
						pane.add(button);
						frame.add(pane);
					}
					
				});
				JButton reid = new JButton("��ѧ���޸�");
				reid.addActionListener(new ActionListener() {
					public void actionPerformed(ActionEvent e) {
						JFrame frame = new JFrame("�޸�");
						JPanel pane = new JPanel();
						JLabel id = new JLabel("ԭ����ѧ��");
						final JTextField userid = new JTextField(20);
						JLabel afterid = new JLabel("�޸ĺ�ѧ��");
						final JTextField afteruserid = new JTextField(20);
						JButton button = new JButton("ȷ��");
						button.addActionListener(new ActionListener() {
							public void actionPerformed(ActionEvent e) {
								String n = String.valueOf(afteruserid.getText());
								StuInfo s = new StuInfo();
								s.setId(n);
								new StuInfoBLL().reciseIdStu(s,userid.getText());
							}
						});
						frame.setVisible(true);
						frame.setBounds(200, 200, 300, 300);
						frame.setDefaultCloseOperation(JFrame.DISPOSE_ON_CLOSE);
						pane.add(id);
						pane.add(userid);
						pane.add(afterid);
						pane.add(afteruserid);
						pane.add(button);
						frame.add(pane);
					}
				});
				frame.setVisible(true);
				frame.setBounds(200, 200, 220, 300);
				frame.setDefaultCloseOperation(JFrame.DISPOSE_ON_CLOSE);
				pane.add(rename);
				pane.add(reid);
				frame.add(pane);
			}
		});
		JButton stusee = new JButton("����");
		stusee.addActionListener(new ActionListener() {
			public void actionPerformed(ActionEvent e) {
				JFrame frame = new JFrame("����");
				JPanel pane = new JPanel();
				JButton namesee = new JButton("����������");
				namesee.addActionListener(new ActionListener() {
					public void actionPerformed(ActionEvent e) {
						JFrame frame = new JFrame("����");
						JPanel pane = new JPanel();
						JLabel name = new JLabel("��������");
						final JTextField username = new JTextField(20);
						JButton button = new JButton("ȷ��");
						button.addActionListener(new ActionListener() {
							public void actionPerformed(ActionEvent e) {
								String n = String.valueOf(username.getText());
								StuInfo stu = new StuInfo();
								stu.setName(n);
								new StuInfoBLL().seenameStu(stu);
							}
						});
						frame.setVisible(true);
						frame.setBounds(200, 200, 300, 300);
						frame.setDefaultCloseOperation(JFrame.DISPOSE_ON_CLOSE);
						pane.add(name);
						pane.add(username);
						pane.add(button);
						frame.add(pane);
					}
				});
				JButton idsee = new JButton("��ѧ�Ų���");
				idsee.addActionListener(new ActionListener() {
					public void actionPerformed(ActionEvent arg0) {
						JFrame frame = new JFrame("����");
						JPanel pane = new JPanel();
						JLabel id = new JLabel("����ѧ��");
						final JTextField userid = new JTextField(20);
						JButton button = new JButton("ȷ��");
						button.addActionListener(new ActionListener() {
							public void actionPerformed(ActionEvent e) {
								String i = String.valueOf(userid.getText());
								StuInfo stu = new StuInfo();
								stu.setName(i);
								new StuInfoBLL().seeidStu(stu);
							}
						});
						frame.setVisible(true);
						frame.setBounds(200, 200, 300, 300);
						frame.setDefaultCloseOperation(JFrame.DISPOSE_ON_CLOSE);
						pane.add(id);
						pane.add(userid);
						pane.add(button);
						frame.add(pane);
					}
				});
				frame.setVisible(true);
				frame.setBounds(200, 200, 220, 300);
				frame.setDefaultCloseOperation(JFrame.DISPOSE_ON_CLOSE);
				pane.add(namesee);
				pane.add(idsee);
				frame.add(pane);
			}
		});
		
		frame.setVisible(true);
		frame.setBounds(200, 200, 300, 300);
		frame.setDefaultCloseOperation(JFrame.DISPOSE_ON_CLOSE);
		pane.add(stuadd);
		pane.add(studele);
		pane.add(stures);
		pane.add(stusee);
		frame.add(pane);
	}
	public static void Register() {
		JPanel pane = new JPanel();
		final JFrame frame = new JFrame("��ӭʹ��ѧ������ϵͳ");
		
		JLabel label = new JLabel("�û���");
		final JTextField usename = new JTextField(20);

		JLabel label1 = new JLabel("��     ��");
		final JPasswordField password = new JPasswordField(20);
		
		JLabel label2 = new JLabel("��     ��");
		final JTextField useEmail = new JTextField(20);
		
		JButton button = new JButton("ȷ��");
		button.addActionListener(new ActionListener() {
			public void actionPerformed(ActionEvent e) {
				StuInfo b = new StuInfo();
				Picture p = new Picture();
				String name = usename.getText();
				String id =String.copyValueOf(password.getPassword());	//���ַ�����ת�ַ���
				String email = useEmail.getText();
				JFileChooser chooser = new JFileChooser();
				int returnVal = chooser.showOpenDialog(frame);
				if (returnVal == JFileChooser.APPROVE_OPTION) {
					System.out.println("You chose to open this file: "
							+ chooser.getSelectedFile().getName());
				}
				Boolean flag = MySqlHelper.checkEmail(email);
				if(flag == true) {
					String path = chooser.getSelectedFile().getPath();
					File f = new File(path);
					p.setPicname(chooser.getSelectedFile().getName());
					p.setPic(f);
					b.setEmail(email);
					b.setName(name);
					b.setId(id);
					new StuInfoBLL().addStu(b);
					new StuPicBLL().addStuPic(p);
					JOptionPane.showMessageDialog(null, "��ӳɹ���");
				}
			}
		});
		
		frame.setVisible(true);
		frame.setBounds(200, 200, 300, 300);
		frame.setDefaultCloseOperation(JFrame.DISPOSE_ON_CLOSE);
		pane.add(label);
		pane.add(usename);
		pane.add(label1);
		pane.add(password);
		pane.add(label2);
		pane.add(useEmail);
		pane.add(button);
		frame.add(pane);
	}
	public static void Catalog () {
		
	}
}
