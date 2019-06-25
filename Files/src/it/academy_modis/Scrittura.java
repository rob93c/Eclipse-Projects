package it.academy_modis;

import java.io.BufferedWriter;
import java.io.File;
import java.io.FileWriter;
import java.io.IOException;

public class Scrittura {

	public static void main(String[] args) {
		
		String dir = "logs";
		
		Scrittura scrittura = new Scrittura();
		
		scrittura.esempioFileWriter(dir + File.separator + 
				"file-writer.txt", "Lorem ipsum...", false);
		
		scrittura.esempioBufferedFileWriter(
				dir + File.separator + "buffered-writer.txt",
				new String[] {"Pippo", "Pluto", "Franco", "Ciccio"},
				true
				);
		
	}
	
	public void esempioBufferedFileWriter(String filePath, String[] testo, boolean append) {
		
		BufferedWriter bw = null;
		
		try {
			bw = new BufferedWriter(new FileWriter(getFile(filePath), append));
			
			for(String string: testo) {
				bw.write(string);
				bw.newLine();
			}
		} catch (IOException e) {
			e.printStackTrace();
		} finally {
			try {
				bw.close();
			} catch (IOException e) {
				e.printStackTrace();
			}
		}
	}

	public void esempioFileWriter(String filePath, String testo, boolean append) {
		FileWriter fw = null;
		
		try {
			fw = new FileWriter(getFile(filePath), append);
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
}
