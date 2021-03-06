package CreateSurvey;

import java.awt.BorderLayout;
import java.awt.Dimension;
import java.awt.FileDialog;
import java.awt.GridLayout;
import java.awt.event.ActionEvent;
import java.awt.event.ActionListener;
import java.awt.event.MouseEvent;
import java.awt.event.MouseListener;
import java.io.File;
import java.util.ArrayList;

import javax.swing.JButton;
import javax.swing.JDialog;
import javax.swing.JFrame;
import javax.swing.JLabel;
import javax.swing.JPanel;
import javax.swing.JScrollPane;
import javax.swing.JTextArea;
import javax.swing.JTextField;


public class OptionDemo extends JFrame{
	
	char optionorder='A';
	ArrayList<JTextField> listtext=new ArrayList<JTextField>();
	public OptionDemo(String name,final ArrayList<String> liststring){
		this.setTitle(name);
		this.setDefaultCloseOperation(2);
		
		//问题面板
		JPanel questionpanel=new JPanel();
		this.getContentPane().add(questionpanel, BorderLayout.NORTH);
		
		final JTextArea optiontitle=new JTextArea("请输入需要设置的问题");
		questionpanel.add(optiontitle);
		
		
		
		//选项面板
		final JPanel optionpanel=new JPanel();
		optionpanel.setLayout(new GridLayout(0, 2));
		optionpanel.setPreferredSize(new Dimension(500,300));
		JScrollPane optionscoll=new JScrollPane(optionpanel);
		optionscoll.setVerticalScrollBarPolicy(JScrollPane.VERTICAL_SCROLLBAR_ALWAYS);
		this.add(optionscoll);
		optionscoll.setBounds(0,0,500,300);
		
		JLabel A=new JLabel(Character.toString(optionorder));
		JTextField option1=new JTextField("请输入选项");
		optionpanel.add(A);
		optionpanel.add(option1);
		listtext.add(option1);

		optionorder++;
		JLabel B=new JLabel(Character.toString(optionorder));
		JTextField option2=new JTextField("请输入选项");
		optionpanel.add(B);
		optionpanel.add(option2);
		listtext.add(option2);
				
		//按钮面板
		JPanel buttonpanel=new JPanel();
		this.getContentPane().add(buttonpanel, BorderLayout.SOUTH);
		
		JButton addbtn=new JButton("添加选项");
		addbtn.addActionListener(new ActionListener() {
			@Override
			public void actionPerformed(ActionEvent e) {
				optionorder++;
				JLabel B=new JLabel(Character.toString(optionorder));
				JTextField option2=new JTextField("请输入选项");
				optionpanel.add(B);
				optionpanel.add(option2);
				listtext.add(option2);
			}
		});
		
		JButton finishbtn=new JButton("完成");
		finishbtn.addActionListener(new ActionListener() {
			@Override
			public void actionPerformed(ActionEvent e) {
				liststring.add(optiontitle.getText());
				for(int i=0;i<=listtext.size();i++){
					liststring.add(listtext.get(i).getText());
				}	
				
			}
		});
		
		buttonpanel.add(addbtn);
		buttonpanel.add(finishbtn);
		
		
		this.setBounds(200, 200, 500, 300);
		this.setVisible(true);
		
		
	}
	
	public static void main(String[] args){
	}
	
	
	
}
