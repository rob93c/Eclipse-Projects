package it.academy_modis;

import java.util.LinkedList;

public class EsempioLinkedList {

	public static void main(String[] args) {
		
		LinkedList<String> linkedList = new LinkedList<String>();
		
		linkedList.addFirst("cane");
		linkedList.addLast("gatto");
		linkedList.addLast("topo");
		linkedList.addFirst("asino");
		linkedList.addLast("gallo");
		
		linkedList.removeFirst();
		
		for(String s: linkedList) {
			System.out.println("Dio " + s);
		}
		
		System.out.println("------------------------");
		
		System.out.println("Dimensione linkedList: " + linkedList.size());
		
		System.out.println(linkedList.get(3));
		
		System.out.println("------------------------");
		
		
		
	}

}
