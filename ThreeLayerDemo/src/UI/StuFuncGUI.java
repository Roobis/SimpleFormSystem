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
		JFrame frame = new JFrame("欢迎使用学生管理系统");
		JButton stuadd = new JButton("增加");
		stuadd.addActionListener(new ActionListener() {
			public void actionPerformed(ActionEvent e) {
				Register();
			}
		});
		
		JButton studele = new JButton("删除");
		studele.addActionListener(new ActionListener() {
			public void actionPerformed(ActionEvent e) {
				JFrame frame = new JFrame("删除");
				JPanel pane = new JPanel();
				JLabel id = new JLabel("按学号删除");
				final JTextField userid = new JTextField(20);
				JLabel name = new JLabel("按姓名删除");
				final JTextField usename = new JTextField(20);
				JButton button = new JButton("确定");
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
		
		JButton stures = new JButton("修改");
		stures.addActionListener(new ActionListener() {

			public void actionPerformed(ActionEvent e) {
				JFrame frame = new JFrame("修改");
				JPanel pane = new JPanel();
				JButton rename = new JButton("按姓名修改");
				rename.addActionListener(new ActionListener() {
					public void actionPerformed(ActionEvent e) {
						JFrame frame = new JFrame("修改");
						JPanel pane = new JPanel();
						JLabel name = new JLabel("原来的姓名");
						final JTextField usename = new JTextField(20);
						JLabel aftername = new JLabel("修改后姓名");
						final JTextField afterusename = new JTextField(20);
						JButton button = new JButton("确定");
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
				JButton reid = new JButton("按学号修改");
				reid.addActionListener(new ActionListener() {
					public void actionPerformed(ActionEvent e) {
						JFrame frame = new JFrame("修改");
						JPanel pane = new JPanel();
						JLabel id = new JLabel("原来的学号");
						final JTextField userid = new JTextField(20);
						JLabel afterid = new JLabel("修改后学号");
						final JTextField afteruserid = new JTextField(20);
						JButton button = new JButton("确定");
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
		JButton stusee = new JButton("查找");
		stusee.addActionListener(new ActionListener() {
			public void actionPerformed(ActionEvent e) {
				JFrame frame = new JFrame("查找");
				JPanel pane = new JPanel();
				JButton namesee = new JButton("按姓名查找");
				namesee.addActionListener(new ActionListener() {
					public void actionPerformed(ActionEvent e) {
						JFrame frame = new JFrame("查找");
						JPanel pane = new JPanel();
						JLabel name = new JLabel("输入姓名");
						final JTextField username = new JTextField(20);
						JButton button = new JButton("确定");
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
				JButton idsee = new JButton("按学号查找");
				idsee.addActionListener(new ActionListener() {
					public void actionPerformed(ActionEvent arg0) {
						JFrame frame = new JFrame("查找");
						JPanel pane = new JPanel();
						JLabel id = new JLabel("输入学号");
						final JTextField userid = new JTextField(20);
						JButton button = new JButton("确定");
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
		final JFrame frame = new JFrame("欢迎使用学生管理系统");
		
		JLabel label = new JLabel("用户名");
		final JTextField usename = new JTextField(20);

		JLabel label1 = new JLabel("密     码");
		final JPasswordField password = new JPasswordField(20);
		
		JLabel label2 = new JLabel("邮     箱");
		final JTextField useEmail = new JTextField(20);
		
		JButton button = new JButton("确定");
		button.addActionListener(new ActionListener() {
			public void actionPerformed(ActionEvent e) {
				StuInfo b = new StuInfo();
				Picture p = new Picture();
				String name = usename.getText();
				String id =String.copyValueOf(password.getPassword());	//将字符数组转字符串
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
					JOptionPane.showMessageDialog(null, "添加成功！");
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
