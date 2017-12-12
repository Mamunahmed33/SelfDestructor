import javax.swing.UIManager;

import com.jtattoo.plaf.noire.NoireLookAndFeel;
import com.jtattoo.plaf.smart.SmartLookAndFeel;


public class MainApp {

	public static void main(String[] args) {
		
		try {
				UIManager.setLookAndFeel(new SmartLookAndFeel());
			}catch (Exception e1) {
				e1.printStackTrace();
			}
		
		gui g = new gui();
	}
}
