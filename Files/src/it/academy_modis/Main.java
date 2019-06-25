package it.academy_modis;

import java.io.File;
import java.io.IOException;

public class Main {

	public static void main(String[] args) {
		
		Main m = new Main();
		
		String dir = "logs";
//		dir += File.separator + "pippo";
		String file = dir + File.separator + "test-file.txt";
		
		m.creaDirectory(dir);
		m.creaFile(file);
		
		System.out.println("-------------------------------");
		
		// se è una directory
		File d = new File(dir);
		if(d.isDirectory())
			System.out.println(dir + " è una directory.");
		else
			System.out.println(dir + " non è una directory.");
		
		System.out.println("-------------------------------");
		
		// se è un file
		File f = new File(file);
		if(f.isFile()) 
			System.out.println(file + " è un file.");
		else 
			System.out.println(file + " non è un file.");
		
		System.out.println("-------------------------------");
		
		// lista i file di una directory
		File[] files = d.listFiles();
		for(File fl: files) {
			//fl.delete(); // elimina i file
			System.out.println(fl.getName() + " eliminato.");
		}
		
		System.out.println("-------------------------------");
		
	}
	
	public void creaDirectory(String path) {
		File d = new File(path);
		
		if(!d.exists()) {
			d.mkdir();
		} else {
			System.out.println("Directory already exists.");
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
		} else {
			System.out.println("File already exists.");
		}
	}
}
