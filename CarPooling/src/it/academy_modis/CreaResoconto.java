package it.academy_modis;

import java.io.BufferedWriter;
import java.io.File;
import java.io.FileWriter;
import java.io.IOException;

public class CreaResoconto {
	
	public void creaDirectory(String path) {
		File d = new File(path);
		
		if(!d.exists()) {
			d.mkdir();
		}
	}
	
	public void creaFile(String path) {
		File f = new File(path);
		if(!f.exists()) {
			try {
	            f.createNewFile();
			} catch (IOException e) {
				e.printStackTrace();
			}
		}
	}
	
	private File getFile(String filePath) {
		File file = new File(filePath);
		
		if(!file.exists()) {
			try {
				file.createNewFile();
			} catch (IOException e) {
				e.printStackTrace();
			}
		}
		
		return file;
	}
	
	public void fileWriter(String filePath, String testo) {
		FileWriter fw = null;
		try {
			fw = new FileWriter(getFile(filePath));
			fw.write(testo);
		} catch (IOException e) {
			e.printStackTrace();
		} finally {
			try {
				fw.close();
			} catch (IOException e) {
				e.printStackTrace();
			}
		}
	}
	
}
