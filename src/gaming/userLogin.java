package gaming;
// The user interface for the login phase
import java.awt.*;
import java.awt.event.*;
import javax.swing.*;

public class userLogin extends JFrame
{
	JPanel panel;
	JLabel username;
	JTextField name;
	JButton login;
	loginHandler handle = new loginHandler();
	Online24 game;
	String uname;
	static userLogin ex;
	
	//initiator method, called when the program is run
	public userLogin(){
		setSize(new Dimension(500,500));
		setGUI();
		setDefaultCloseOperation(JFrame.EXIT_ON_CLOSE);
		setVisible(true);
		setTitle("Online-24 Game");
	}
	
	//describes how the GUI for login will look like
	protected void setGUI(){
		Dimension dim = getSize();
		panel = new JPanel();
		panel.setLayout(null);
		setContentPane(panel);
		//username
		username = new JLabel("Username: ");
		username.setBounds((dim.width/2)-80, (dim.height/2)-50, 100, 20);
		panel.add(username);
		// textfield for the user to enter their nickname
		name = new JTextField();
		name.setBounds((dim.width/2), (dim.height/2-50), 100, 20);
		panel.add(name);
		// button for logging in
		login = new JButton("Login");
		login.setBounds((dim.width/2)-30, (dim.height/2)-20, 70, 30);
		login.addActionListener(handle); //action listener for the login button
		panel.add(login);
	}
	
	public static void main(String[] args)
	{
		SwingUtilities.invokeLater(new Runnable() {
            @Override
			public void run() {
                ex = new userLogin();
                ex.setVisible(true);
            }
        });
	}
	
	/*
	 * Private class LoginHandler to implement the action listener for the login button
	 */
	
	class loginHandler implements ActionListener{
		@Override
		public void actionPerformed(ActionEvent e){
			if (name.getText().equals("")){
				JLabel err = new JLabel("<HTML><FONT COLOR = red>"+"Please enter your nickname. <FONT><HTML>");
				JOptionPane.showMessageDialog(null,err);
				name.setText("");
				}
			else{
				game = new Online24();
				Online24.createAndShowGUI();
				uname = ex.name.getText();
				ex.dispose();
			}
		}
	}
}
