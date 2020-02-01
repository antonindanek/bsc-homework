package homework.loading;

import java.io.File;
import java.io.FileNotFoundException;
import java.util.Scanner;

import homework.data.Storage;

public class InputFileReader extends InputReader {
	
	File file;

	public InputFileReader(Storage storage, String[] args) {
		super(storage);
		
		String filename = parseFilename(args);
		file = filename == null ? null : new File(filename);
	}
	
	@Override
	public void run() {
		
		if(file != null && file.exists()) {
			try (Scanner sc = new Scanner(file)) {
				
	            while (sc.hasNextLine()) {
	                readAndStoreLine(sc);
	            }
				
			} catch (FileNotFoundException e) {
				e.printStackTrace();
			}
		}
	}

	private String parseFilename(String[] args) {
		
		if(args != null && args.length == 1) {
			return args[0];
		}
		
		return null;
	}

}
