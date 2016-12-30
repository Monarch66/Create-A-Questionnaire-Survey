package QuestionnaireServey;
import java.io.*;
import java.awt.Graphics;
import java.awt.Image;
import javax.swing.*;
import javax.imageio.*;


public class ChoujiangPart extends JFrame {
	public ChoujiangPart() {
		this.setTitle("É¨ÂëÇÀºì°ü£¬Ç×£¡");
		this.setLayout(null);
        ImagePanel ip=new ImagePanel();
        ip.setBounds(0,0,200,200);
        this.getContentPane().add(ip);
        this.setBounds(200,200,300,300);
        this.setVisible(true);
	}

    class ImagePanel extends JPanel{
    	Image img;
    	public void paint(Graphics g){
    		try{
    			img=ImageIO.read(new File("D://²¶»ñ.jpg"));
    		}catch(IOException e){
    			e.printStackTrace();
    		}
    		g.drawImage(img,0,0,200,200,null);
    	}
    }
}
    