import java.io.File;
import javax.swing.JFileChooser;
import javax.swing.JFrame;
import javax.swing.UIManager;
import com.jtattoo.plaf.smart.SmartLookAndFeel;

public class FileChooser extends JFrame{
	private static FileChooser instance= null;
	private String filePath = "";
	
	private FileChooser() {
		
	}
	
	public static FileChooser getFileChooserInstance() {
		if(instance == null)
		{
			instance = new FileChooser();
		}
		
		return instance;
	}
	
	public File[] getFile(String initialPath) {
		
		try {
				UIManager.setLookAndFeel(new SmartLookAndFeel());
				
			} catch (Exception e1) {
				e1.printStackTrace();
			}
		
		JFileChooser fChooser = new JFileChooser();
		fChooser.setMultiSelectionEnabled(true);
				
		fChooser.setCurrentDirectory(new File(initialPath));
		int filechoosen = fChooser.showOpenDialog(new JFrame());
		
		if(filechoosen == fChooser.APPROVE_OPTION){
			filePath = fChooser.getSelectedFile().toString();
			
			return fChooser.getSelectedFiles();
		}
		
		return null;
	}
	
	public String getFilePath() {
		return filePath;
	}
	
}