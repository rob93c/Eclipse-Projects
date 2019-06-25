package it.academy_modis;

import java.io.BufferedReader;
import java.io.File;
import java.io.FileNotFoundException;
import java.io.FileReader;
import java.io.IOException;

public class Lettura {

	public static void main(String[] args) {
		
		String dir = "logs";
		
		Lettura l = new Lettura();
		l.esempioFileReader(dir + File.separator + "file-writer.txt");
		
		System.out.println("-------------------------------");
		
		l.esempioBufferedReader(dir + File.separator + "buffered-writer.txt");
		
		System.out.println("-------------------------------");
		
	}

	public void esempioFileReader(String filePath) {
		File f = new File(filePath);
		
		if(f.exists()) {
			
			FileReader fr = null;
			try {
				fr = new FileReader(f);
				int i;
				String s = "";
				while((i = fr.read()) != -1) {
					s += (char)i;
				}
				System.out.println(s);
			} catch(FileNotFoundException e) {
				e.printStackTrace();
			} catch(IOException e) {
				e.printStackTrace();
			} finally {
				try {
					fr.close();
				} catch(IOException e) {
					e.printStackTrace();
				}
			}
		}	
	}
	
	public void esempioBufferedReader(String filePath) {
		File f = new File(filePath);
		
		if(f.exists()) {
			BufferedReader br = null;
			try {
				br = new BufferedReader(new FileReader(f));
				int i;
				String s = "";
				while((i = br.read()) != -1) {
					s += (char)i;
				}
				System.out.println(s);
			} catch (FileNotFoundException e) {
				e.printStackTrace();
			} catch (IOException e) {
				e.printStackTrace();
			} finally {
				try {
					br.close();
				} catch(IOException e) {
					e.printStackTrace();
				}
			}
		} 
	}
}
