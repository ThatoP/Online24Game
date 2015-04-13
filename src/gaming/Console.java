package gaming;

import java.awt.*;
import java.awt.event.ActionEvent;
import java.awt.event.ActionListener;
import java.awt.event.KeyEvent;

import javax.swing.*;

public class Console extends JFrame 
{
	JPanel panel;
	JLabel txt;
	JButton startBttn;
	userLogin user;
	static String name;
	
	public Console(){
		setSize(new Dimension(500,500));
		setDefaultCloseOperation(JFrame.EXIT_ON_CLOSE);
		setVisible(true);
		setTitle("Online-24 Game");
		//addListener();
		//user = new userLogin();
		//name = user.uname.toString();
		name = userLogin.ex.uname;
		setConsGUI();
	}
	
	protected void setConsGUI(){
		Dimension dim = getSize();
		panel = new JPanel();
		panel.setLayout(null);
		setContentPane(panel);
		// showing the text on the welcome screen
		txt = new JLabel("Welcome to Online24 Game, "+ name +" !!");
		txt.setBounds((dim.width/2)-130, 150, 250, 40);
		panel.add(txt);
		// placing the start button on the canvas
		startBttn = new JButton(" START ");
		startBttn.setBounds((dim.width/2)-50,300,80,40);
		panel.add(startBttn);
		startBttn.addActionListener(new ButtonHandler());
	}
	
	public static void main(String[] args){
		SwingUtilities.invokeLater(new Runnable() {
            @Override
			public void run() {
                Console cons = new Console();
                //System.out.print(name);
                cons.setVisible(true);
            }
        });
	}
	
	class ButtonHandler implements ActionListener{
		@Override
		public void actionPerformed(ActionEvent e){
			startBttn.setMnemonic(KeyEvent.VK_ENTER);
			GameGUI g = new GameGUI();
			dispose();
		}
	}
}
