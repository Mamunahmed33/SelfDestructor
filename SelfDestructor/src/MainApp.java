import javax.swing.UIManager;

import com.jtattoo.plaf.noire.NoireLookAndFeel;
import com.jtattoo.plaf.smart.SmartLookAndFeel;


public class MainApp {

	public static void main(String[] args) {
		
		try {
			//	UIManager.setLookAndFeel(new BernsteinLookAndFeel());
			//	UIManager.setLookAndFeel(new AcrylLookAndFeel());
			//	UIManager.setLookAndFeel(new AluminiumLookAndFeel());
			//	UIManager.setLookAndFeel(new FastLookAndFeel());
			//	UIManager.setLookAndFeel(new GraphiteLookAndFeel());
			//	UIManager.setLookAndFeel(new LunaLookAndFeel());
			//	UIManager.setLookAndFeel(new McWinLookAndFeel());
			//	UIManager.setLookAndFeel(new MintLookAndFeel());
			//	UIManager.setLookAndFeel(new NoireLookAndFeel());
				UIManager.setLookAndFeel(new SmartLookAndFeel());
				//UIManager.setLookAndFeel(new TextureLookAndFeel());
				
			} catch (Exception e1) {
				e1.printStackTrace();
			}
		
		gui g = new gui();
	}
}
