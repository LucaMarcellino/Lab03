package it.polito.tdp.spellchecker.model;

import java.io.*;
import java.util.*;

public class Dictionary {
	
	List<String> dizionarioInglese=new LinkedList<String>();
	List<String> dizionarioItalian=new LinkedList<String>();
	List<String> dizionario=new LinkedList<String>();
	
	
	public void loadDictionary() {
		try {
			FileReader fr= new FileReader("src/main/resources/English.txt");
				BufferedReader br=new BufferedReader(fr);
			String word;
			while((word = br.readLine()) != null){
				dizionario.add(word.toLowerCase());
			}
			br.close();
		}catch(IOException e) {
			System.out.println("errore nella lettura da file ");
		}
		
		try {
			FileReader fr= new FileReader("src/main/resources/Italian.txt");
				BufferedReader br=new BufferedReader(fr);
			String word;
			while((word = br.readLine()) != null){
				dizionario.add(word.toLowerCase());
			}
			br.close();
		}catch(IOException e) {
			System.out.println("errore nella lettura da file ");
		}

	}
	
	public List<RichWord> spellCheckText(List<String> inputTextList){
		List<RichWord> listaTesto= new LinkedList<RichWord>();
		
		for(String s : inputTextList) {
			if(!dizionario.contains(s)) {
				listaTesto.add(new RichWord(s,false));
			}
		}
		return listaTesto;
	}
	
	

}
