import java.io.File;
import javax.swing.JFileChooser;
import javax.swing.JFrame;

public class FileChooser extends JFrame{
	private static FileChooser instance= null;
	
	FileChooser() {
		
	}
	
	public static FileChooser getFileChooserInstance() {
		if(instance == null)
		{
			instance = new FileChooser();
		}
		
		return instance;
	}
	
	public String getFile(String initialPath) {
		JFileChooser fChooser = new JFileChooser();
		
		fChooser.setCurrentDirectory(new File(initialPath));
		int filechoosen = fChooser.showOpenDialog(new JFrame());
		
		if(filechoosen == fChooser.APPROVE_OPTION){
			
			return fChooser.getSelectedFile().toString();
		}
		
		return "";
	}
	
}