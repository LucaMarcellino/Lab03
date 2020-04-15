package it.polito.tdp.spellchecker.model;

import java.io.*;
import java.util.*;

public class Dictionary {
	
	List<String> dizionarioInglese=new LinkedList<String>();
	List<String> dizionarioItalian=new LinkedList<String>();
	List<String> dizionario=new LinkedList<String>();
//	List<String> dizionario=new ArrayList<String>();
	
	
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
		//List<RichWord> listaTesto= new ArrayList<RichWord>();
		
		for(String s : inputTextList) {
			if(!dizionario.contains(s)) {
				listaTesto.add(new RichWord(s,false));
			}
		}
		return listaTesto;
	}
	
	public List<RichWord> spellCheckTextDicotomic(List<String> inputText){
		List<RichWord> listaErr= new LinkedList<RichWord>();
		
		for(String s : inputText) {
			if( !binarySearch(s)) {
				listaErr.add(new RichWord(s,false));
			}
		}
		
		return listaErr;
	}
	
	public boolean binarySearch(String sTemp) {
			int inizio=0;
			int fine= dizionario.size();
			
			while(inizio !=fine) {
				int medio=inizio+(fine-inizio)/2;
				if(sTemp.compareToIgnoreCase(dizionario.get(medio))==0) {
					return true;
				}
				else if(sTemp.compareToIgnoreCase(dizionario.get(medio))>0) {
					inizio=medio+1;
				}
				else
					fine=medio;
			}
		return false;
	}
	
	

}
