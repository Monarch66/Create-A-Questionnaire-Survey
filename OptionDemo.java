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
		
		//�������
		JPanel questionpanel=new JPanel();
		this.getContentPane().add(questionpanel, BorderLayout.NORTH);
		
		final JTextArea optiontitle=new JTextArea("��������Ҫ���õ�����");
		questionpanel.add(optiontitle);
		
		
		
		//ѡ�����
		final JPanel optionpanel=new JPanel();
		optionpanel.setLayout(new GridLayout(0, 2));
		optionpanel.setPreferredSize(new Dimension(500,300));
		JScrollPane optionscoll=new JScrollPane(optionpanel);
		optionscoll.setVerticalScrollBarPolicy(JScrollPane.VERTICAL_SCROLLBAR_ALWAYS);
		this.add(optionscoll);
		optionscoll.setBounds(0,0,500,300);
		
		JLabel A=new JLabel(Character.toString(optionorder));
		JTextField option1=new JTextField("������ѡ��");
		optionpanel.add(A);
		optionpanel.add(option1);
		listtext.add(option1);

		optionorder++;
		JLabel B=new JLabel(Character.toString(optionorder));
		JTextField option2=new JTextField("������ѡ��");
		optionpanel.add(B);
		optionpanel.add(option2);
		listtext.add(option2);
				
		//��ť���
		JPanel buttonpanel=new JPanel();
		this.getContentPane().add(buttonpanel, BorderLayout.SOUTH);
		
		JButton addbtn=new JButton("���ѡ��");
		addbtn.addActionListener(new ActionListener() {
			@Override
			public void actionPerformed(ActionEvent e) {
				optionorder++;
				JLabel B=new JLabel(Character.toString(optionorder));
				JTextField option2=new JTextField("������ѡ��");
				optionpanel.add(B);
				optionpanel.add(option2);
				listtext.add(option2);
			}
		});
		
		JButton finishbtn=new JButton("���");
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
