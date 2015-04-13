package gaming;

import java.awt.*;
import java.awt.event.ActionEvent;
import java.awt.event.ActionListener;
import javax.swing.*;
import java.util.*;

public class GameGUI extends JFrame
{
	JPanel p;
	JLabel clName, servName, whosTurn, tLabel, ans, clock;
	static long clk;
	JButton num1, num2, num3, num4, restart;
	JButton lBracket, rBracket, plus, minus, times, divide, clr;
	int n1,n2, n3, n4, count = 0;
	static int eval = 0;
	JTextArea equation;
	static String username, eq = " ";
	static long TIME_OUT = 60000;
    static java.text.SimpleDateFormat sdf = new java.text.SimpleDateFormat("mm: ss");
	
	public GameGUI(){
		setSize(new Dimension(600,600));
		setDefaultCloseOperation(JFrame.EXIT_ON_CLOSE);
		setVisible(true);
		setTitle("Online-24 Game");
		username = userLogin.ex.uname;
		setGameGUI();
		addListeners();
		new javax.swing.Timer(1000, new TimeHandler()).start();
	}
	
	public static void main(String[] args){
		SwingUtilities.invokeLater(new Runnable() {
            @Override
			public void run() {
                GameGUI cons = new GameGUI();
                cons.setVisible(true);
            }
        });
	}
	
	protected void setGameGUI(){
		n1 = (int)(Math.random()*10);
		n2 = (int)(Math.random()*10);
		n3 = (int)(Math.random()*10);
		n4 = (int)(Math.random()*10);
		
		p = new JPanel();
		p.setLayout(null);
		setContentPane(p);
	
		clName = new JLabel(username + ": 0");
		clName.setBounds(20, 30, 100, 30);
		p.add(clName);
		
		servName = new JLabel("Thato: 0");
		servName.setBounds(130,30,100,30);
		p.add(servName);
		
		whosTurn = new JLabel("It is now "+ username + "'s turn.");
		whosTurn.setBounds(50, 100, 200, 30);
		p.add(whosTurn);
		
		tLabel = new JLabel("Time remaining: ");
		tLabel.setBounds(350, 100, 100, 30);
		p.add(tLabel);
		
		clock = new JLabel(""+sdf.format(new Date(TIME_OUT)));
	    clock.setBounds(460, 100, 80, 30);
	    p.add(clock);
		
		num1 = new JButton(""+Integer.toString(n1)+"");
		num1.setBounds(50, 200, 80, 80);
		p.add(num1);
		
		num2 = new JButton(""+Integer.toString(n2)+"");
		num2.setBounds(145, 200, 80, 80);
		p.add(num2);
		
		num3 = new JButton(""+Integer.toString(n3)+"");
		num3.setBounds(240, 200, 80, 80);
		p.add(num3);
		
		num4 = new JButton(""+Integer.toString(n4)+"");
		num4.setBounds(335, 200, 80, 80);
		p.add(num4);
		
		clr = new JButton("Del");
		clr.setBounds(450, 220, 80, 40);
		p.add(clr);
		
		equation = new JTextArea();
		equation.setBounds(175, 325, 200, 50);
		p.add(equation);
		
		ans = new JLabel(" =       ");
		ans.setBounds(390, 325, 100, 50);
		p.add(ans);
		
		lBracket = new JButton("(");
		lBracket.setBounds(60, 425, 50, 50);
		p.add(lBracket);
		lBracket.addActionListener(new Handler());
		
		rBracket = new JButton(")");
		rBracket.setBounds(140, 425, 50, 50);
		p.add(rBracket);
		rBracket.addActionListener(new Handler());
		
		plus = new JButton("+");
		plus.setBounds(220, 425, 50, 50);
		p.add(plus);
		plus.addActionListener(new Handler());
		
		minus = new JButton("-");
		minus.setBounds(300, 425, 50, 50);
		p.add(minus);
		minus.addActionListener(new Handler());
		
		times = new JButton("*");
		times.setBounds(380, 425, 50, 50);
		p.add(times);
		times.addActionListener(new Handler());
		
		divide = new JButton("/");
		divide.setBounds(460, 425, 50, 50);
		p.add(divide);
		divide.addActionListener(new Handler());
		
		restart = new JButton("Restart");
		restart.setBounds(240, 490, 100, 40);
		p.add(restart);
	}
	
	private void addListeners(){
		clk = System.nanoTime();
		restart.addActionListener(new ActionListener(){
			public void actionPerformed(ActionEvent e){
				new GameGUI();
				dispose();
			}
		});
		
		num1.addActionListener(new ActionListener(){
			@Override
			public void actionPerformed(ActionEvent e){
				equation.append(num1.getText());
				eq += num1.getText();
				num1.setEnabled(false);
				count++;
				
				if(count==4){
					eval = Calculator.evalRPN(eq);
					ans = new JLabel("=       "+eval+"");
					ans.setBounds(390, 325, 100, 50);
					p.add(ans);
					p.validate();
				}
			}
		});
		
		num2.addActionListener(new ActionListener(){
			@Override
			public void actionPerformed(ActionEvent e){
				equation.append(num2.getText());
				eq += num2.getText();
				num2.setEnabled(false);
				count++;
				
				if(count==4){
					eval = Calculator.evalRPN(eq);
					ans = new JLabel("=       "+eval+"");
					ans.setBounds(390, 325, 100, 50);
					p.add(ans);
					p.validate();
				}
			}
		});
		
		num3.addActionListener(new ActionListener(){
			@Override
			public void actionPerformed(ActionEvent e){
				equation.append(num3.getText());
				eq += num3.getText();
				num3.setEnabled(false);
				count++;
				
				if(count==4){
					eval = Calculator.evalRPN(eq);
					ans = new JLabel("=       "+eval+"");
					ans.setBounds(390, 325, 100, 50);
					p.add(ans);
					p.validate();
				}
			}
		});
		
		num4.addActionListener(new ActionListener(){
			@Override
			public void actionPerformed(ActionEvent e){
				equation.append(num4.getText());
				eq += num4.getText();
				num4.setEnabled(false);
				count++;
				
				if(count==4){
					eval = Calculator.evalRPN(eq);
					ans = new JLabel("=       "+eval+"");
					ans.setBounds(390, 325, 100, 50);
					p.add(ans);
					p.validate();
				}
			}
		});
		
		clr.addActionListener(new ActionListener(){
			public void actionPerformed(ActionEvent e){
				equation.setText(null);
				num1.setEnabled(true);
				num2.setEnabled(true);
				num3.setEnabled(true);
				num4.setEnabled(true);
			}
		});
	}
	
	class TimeHandler implements ActionListener{
		long x = TIME_OUT - 1000;
		public void actionPerformed(ActionEvent e){
			while (x>=0){
				clock.setText(sdf.format(new Date(x)));
		        x -= 1000;
		        break;
			}
			if(x == 0){
				clr.setEnabled(false);
				equation.setText(null);
				num1.setEnabled(false);
				num2.setEnabled(false);
				num3.setEnabled(false);
				num4.setEnabled(false);
			}
		}
	}

	class Handler implements ActionListener{
		@Override
		public void actionPerformed(ActionEvent e){
			JButton src = (JButton)e.getSource();
			if(src.getText().equals("(")){
				equation.append("(");
				eq += "(";}
			else if(src.getText().equals(")")){
				equation.append(")");
				eq += ")";}
			else if(src.getText().equals("+")){
				equation.append("+");
				eq += "+";}
			else if(src.getText().equals("-")){
				equation.append("-");
				eq += "-";}
			else if(src.getText().equals("*")){
				equation.append("*");
				eq += "*";}
			else{
				equation.append("/");
				eq += "/";}
		}
	}
}
