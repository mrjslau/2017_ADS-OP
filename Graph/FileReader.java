import java.io.File;
import java.util.ArrayList;
import java.util.List;
import java.util.Scanner;

public class FileReader {
	private Scanner x;
	protected List<String> readStrings;
	
	public FileReader() {
		readStrings = new ArrayList<String>();
	}
	
	public void openFile(String path) {
		try {
			x = new Scanner(new File(path));
		} catch (Exception e) {
			System.out.println("Could not find file");
		}
	}
	
	public void readFilebyLines() {
		readStrings.clear();
		while (x.hasNext()) {
			readStrings.add(x.nextLine());
		}
	}
	
	public void closeFile() {
		x.close();
	}
}
