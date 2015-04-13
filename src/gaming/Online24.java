package gaming;
import java.awt.*;
import java.awt.event.*;
import javax.swing.*;

public class Online24 extends JFrame
{
	JPanel panel;
	JLabel txt;
	JButton startBttn;
	JDesktopPane dTop;
	JMenuBar menu;
	JMenu file, about;
	JMenuItem startNew, close, help;
	Dimension dim;
	Console cons;
	//String name;
	
	
	public Online24(){
		super("Online-24 Game");
		dTop = new JDesktopPane();
		dTop.setBackground(Color.WHITE);
		setContentPane(dTop);
		dim = new Dimension(800,600);
		setPreferredSize(dim);
		setJMenuBar(setMenu());
		addListeners();
		dTop.setDragMode(JDesktopPane.LIVE_DRAG_MODE);
	}
	
	public static void main(String[] args){
		javax.swing.SwingUtilities.invokeLater(new Runnable() {
            @Override
			public void run() {
               createAndShowGUI();
            }
        });
	}
	
	public static void createAndShowGUI(){
		Online24 gui = new Online24();
		gui.setDefaultCloseOperation(JFrame.EXIT_ON_CLOSE);
		gui.pack();
		gui.setVisible(true);
	}
	
	public JMenuBar setMenu(){
		menu = new JMenuBar(); // initialize the JMenuBar obect, if not, it yeilds a null-pointer exception
		file = new JMenu("File");
		about = new JMenu("About");
		startNew = new JMenuItem("Start new");
		close = new JMenuItem("Close");
		help = new JMenuItem("Help");
		file.add(startNew);
		file.add(close);
		about.add(help);
		menu.add(file);
		menu.add(about);
		return menu;
	}

	
	private void addListeners(){
		startNew.setMnemonic(KeyEvent.VK_N);
		startNew.setAccelerator(KeyStroke.getKeyStroke(KeyEvent.VK_N, ActionEvent.CTRL_MASK ));
		startNew.addActionListener(new ActionListener(){
			@Override
			public void actionPerformed(ActionEvent e){
				cons = new Console();
				//System.out.print("Welcome to the game!!");
			}
		});
		
		close.addActionListener(new ActionListener(){
			@Override
			public void actionPerformed(ActionEvent e){
				System.exit(0);
			}
		});
		
		help.setMnemonic(KeyEvent.VK_F1);
		help.setAccelerator(KeyStroke.getKeyStroke(KeyEvent.VK_F1,ActionEvent.CTRL_MASK));
		help.addActionListener(new ActionListener(){
			@Override
			public void actionPerformed(ActionEvent e){
				System.out.print("This part is the part that describes the rules of the game.");
			}
		});
	}
}
