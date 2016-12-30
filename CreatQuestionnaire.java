
package QuestionnaireServey;

import java.awt.BorderLayout;
import java.awt.Color;
import java.awt.event.ActionEvent;
import java.awt.event.ActionListener;
import java.awt.event.MouseAdapter;
import java.awt.event.MouseEvent;
import java.io.FileInputStream;
import java.io.FileOutputStream;
import java.io.ObjectInputStream;
import java.io.ObjectOutputStream;

import javax.swing.JButton;
import javax.swing.JFrame;
import javax.swing.JMenu;
import javax.swing.JMenuBar;
import javax.swing.JMenuItem;
import javax.swing.JPanel;
import javax.swing.JTextField;
import java.awt.Font;

public class CreatQuestionnaire extends JFrame {

	Painter painter = new Painter();
	
	JPanel panel = new JPanel();
	
	public CreatQuestionnaire(){
		this.setBounds(0, 100,362, 450);
		getContentPane().setLayout(new BorderLayout(0, 0));
		getContentPane().add(panel, BorderLayout.NORTH);
		
		getContentPane().add(painter, BorderLayout.CENTER);
		
		JButton radioButton = new JButton("\u5355\u9009\u6846");
		
		panel.add(radioButton);
		
		JButton mutiplyButton = new JButton("\u591A\u9009\u6846");
		panel.add(mutiplyButton);
		
		JButton writeButton = new JButton("\u586B\u5199\u6846");
		panel.add(writeButton);
		
		JButton button = new JButton("\u6E05\u7A7A");
		button.addMouseListener(new MouseAdapter() {
			@Override
			public void mouseClicked(MouseEvent arg0) {
				painter.removeAll();
				painter.updateUI();
			}
		});
		panel.add(button);
		
		ArdioButtonHander radiobuttonhander = new ArdioButtonHander();
		radioButton.addActionListener(radiobuttonhander);
		
		MutiplyButtonHander mutiplybuttonhander = new MutiplyButtonHander();
		mutiplyButton.addActionListener(mutiplybuttonhander);
		
		WriteButtonHabder writebuttonhander = new WriteButtonHabder();
		writeButton.addActionListener(writebuttonhander);
		
		JMenuBar menuBar = new JMenuBar();
		setJMenuBar(menuBar);
		
		JMenu mnFile = new JMenu("file");
		menuBar.add(mnFile);
		
		JMenuItem mntmCreat = new JMenuItem("new");
		mntmCreat.addActionListener(new ActionListener() {
			
			@Override
			public void actionPerformed(ActionEvent e) {
				// TODO Auto-generated method stub
				painter.removeAll();
				painter.updateUI();
			}
		});
		mnFile.add(mntmCreat);
		
		JMenuItem mntmOpen = new JMenuItem("open");
		mntmOpen.addActionListener(new ActionListener() {
			
			@Override
			public void actionPerformed(ActionEvent arg0) {
				// TODO Auto-generated method stub
				FileInputStream freader;  
				try {
					freader = new FileInputStream("D://111.txt");
					ObjectInputStream objectInputStream = new ObjectInputStream(freader);
		            Painter pa = new Painter();
		            pa = (Painter) objectInputStream.readObject();
		            remove(painter);
		            getContentPane().add(pa, BorderLayout.CENTER);
		            pa.updateUI();
		            
		            
				} catch (Exception e) {
					// TODO Auto-generated catch block
					e.printStackTrace();
				}
			}
		});
		mnFile.add(mntmOpen);
		
		JMenuItem mntmSave = new JMenuItem("save");
		mntmSave.addActionListener(new ActionListener() {
			
			@Override
			public void actionPerformed(ActionEvent e) {
				// TODO Auto-generated method stub
//				FileDialog saveDialog = new FileDialog(CreatQuestionnaire.this, "Save", FileDialog.SAVE);
//				saveDialog.setVisible(true);
//				if (saveDialog.getFile()==null) return;
				try {
					FileOutputStream outstream = new FileOutputStream("D://111.txt");
					ObjectOutputStream out = new ObjectOutputStream(outstream);
			        out.writeObject(painter); 
			        out.close();
			        ObjectInputStream in = new ObjectInputStream(new FileInputStream("D://111.txt"));
				} catch (Exception e1) {
					// TODO Auto-generated catch block
					e1.printStackTrace();
				}
			}
		});
		mnFile.add(mntmSave);
		
		
		JMenuItem money=new JMenuItem("money");
		mnFile.add(money);
		money.addActionListener(new ActionListener() {
			
			@Override
			public void actionPerformed(ActionEvent e) {
				// TODO Auto-generated method stub
				ChoujiangPart money=new ChoujiangPart();
				
				
				
				
			}
		});
		
		
		JMenuItem mntmNewMenuItem = new JMenuItem("and so on");
		mntmNewMenuItem.addActionListener(new ActionListener() {
			
			@Override
			public void actionPerformed(ActionEvent e) {
				// TODO Auto-generated method stub
				JFrame frm = new JFrame();
				JButton attention = new JButton("研发中！");
				attention.setForeground(Color.WHITE);
				frm.getContentPane().add(attention,BorderLayout.CENTER);
				attention.setFont(new Font("隶书", Font.PLAIN, 50));
				attention.setBackground(Color.RED);
				frm.setBounds(250, 250, 250, 250);
				frm.setDefaultCloseOperation(JFrame.EXIT_ON_CLOSE);
				frm.setVisible(true);
			}
		});
		mnFile.add(mntmNewMenuItem);
	}
	class ArdioButtonHander implements ActionListener {
		@Override
		public void actionPerformed(ActionEvent e) {
			// TODO Auto-generated method stub
			RadioQuse radioquestion =  new RadioQuse();
//			System.out.println("12");
			painter.add(radioquestion,BorderLayout.NORTH);
			painter.updateUI();
		}
	}
	class MutiplyButtonHander implements ActionListener {
		@Override
		public void actionPerformed(ActionEvent e) {
			// TODO Auto-generated method stub
			MutiplyQue mutiplyquestion =  new MutiplyQue();
//			System.out.println("12");
			painter.add(mutiplyquestion,BorderLayout.CENTER);
			painter.updateUI();
		}
	}
	class WriteButtonHabder implements ActionListener {
		@Override
		public void actionPerformed(ActionEvent e) {
			// TODO Auto-generated method stub
			WriteQues writequestion =  new WriteQues();
//			System.out.println("12");
			painter.add(writequestion,BorderLayout.SOUTH);
			painter.updateUI();
		}
	}
	public static void main(String[] args){
		CreatQuestionnaire question = new CreatQuestionnaire();
		question.setDefaultCloseOperation(JFrame.EXIT_ON_CLOSE);
		question.setVisible(true);
	}
}
