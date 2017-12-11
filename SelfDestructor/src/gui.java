import java.awt.Color;
import java.awt.Font;
import java.awt.Image;
import java.awt.event.ActionEvent;
import java.awt.event.ActionListener;
import java.awt.image.BufferedImage;
import java.io.File;
import java.util.Timer;
import java.util.TimerTask;

import javax.imageio.ImageIO;
import javax.swing.ImageIcon;
import javax.swing.JButton;
import javax.swing.JFrame;
import javax.swing.JLabel;
import javax.swing.JOptionPane;
import javax.swing.JPanel;
import javax.swing.JTextField;

public class gui extends JFrame{
	private Timer previousTime;
	
	JFrame f;
	JLabel jl1, jl2;
	JTextField jtf1, jtf2;
	JButton jb1, jb2;
	
	
	gui(){
		init();
	}
	
	public void init() {
		f = new JFrame("Self Destructor :)");
		
		ImageIcon icon = new ImageIcon(getClass().getResource("icon.jpg"));  
		ImageIcon icon1 = new ImageIcon(getClass().getResource("icon2.jpg"));  
		f.setIconImage(icon.getImage());
		
		JPanel pn = new JPanel();
		pn.setLayout(null);

		JLabel p = new JLabel(icon1);
		
		jl1 = new JLabel("Select File:");
		jl1.setForeground(Color.WHITE);
		jl1.setBounds(100, 50, 100, 30);
		
		jtf1 = new JTextField();
		jtf1.setEditable(false);
		jtf1.setBounds(170, 50, 200, 30);
		
		jb1 = new JButton("...");
		jb1.setBounds(380, 50, 40, 30);
		
		jb1.addActionListener(new ActionListener() {
			
			@Override
			public void actionPerformed(ActionEvent e) {
				FileChooser fc = new FileChooser();
				
				jtf1.setText(fc.getFile(""));
				
			}
		});
		
		jl2 = new JLabel("Enter Time: ");
		jl2.setBounds(100, 100, 100, 30);
		jl2.setForeground(Color.WHITE);
		
		jtf2 = new JTextField();
		jtf2.setBounds(170, 100, 250, 30);
		
		jb2 = new JButton("Start Self-Destruction");
		jb2.setBounds(210, 180, 150, 30);
		jb2.addActionListener(new ActionListener() {
			
			@Override
			public void actionPerformed(ActionEvent e) {
				TimerDemo clock = new TimerDemo();
				clock.time.setBounds(210, 250, 200, 50);
				clock.time.setFont(new Font("Serif", Font.BOLD, 48));
				clock.time.setForeground(Color.WHITE);
				
				clock.start();
				p.add(clock.time);
				jtf2.setEditable(false);
				
				deleteFile();
			}
		});
		
		p.add(jl1);
		p.add(jtf1);
		p.add(jb1);
		
		p.add(jl2);
		p.add(jtf2);
		p.add(jb2);
		
		pn.add(p);
		
		f.add(p);
		f.setLocation(500, 300);
		f.setResizable(false);
		f.setVisible(true);
		f.setDefaultCloseOperation(EXIT_ON_CLOSE);
		f.setSize(500, 350);
	}
	
	public void deleteFile() {
		try {
			int minutes =  Integer.parseInt(jtf2.getText()) * 60000;
			
			Timer timer = new Timer();
			
			TimerTask task = new TimerTask() {
		        public void run() {
		        	File file = new File(jtf1.getText());
		        	
		        	if(file.delete()) {
		        		int dialogResult = JOptionPane.showConfirmDialog(new JPanel(), "File Deleted Successfully", "Success", JOptionPane.INFORMATION_MESSAGE);
		        		if(dialogResult == JOptionPane.YES_OPTION){		        		  
		        			f.dispose();
		        		}
		        		
		        	}else {
		        		JOptionPane.showMessageDialog(new JPanel(), "File can not be deleted!", "Error", JOptionPane.ERROR_MESSAGE);
		        		f.dispose();
		        	}	            
		        }
		    };
		    
			timer.schedule(task, minutes);
			
			
		}catch(Exception e) {
			JOptionPane.showMessageDialog(new JPanel(), "Error Occured!", "Error", JOptionPane.ERROR_MESSAGE);
		}
	}
}
