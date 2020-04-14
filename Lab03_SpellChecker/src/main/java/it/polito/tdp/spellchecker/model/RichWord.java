package it.polito.tdp.spellchecker.model;

public class RichWord {
	
	private String word;
	private boolean corretto;
	
	
	public RichWord(String word, boolean corretto) {
		this.word = word;
		this.corretto = corretto;
	}


	public String getWord() {
		return word;
	}


	public void setWord(String word) {
		this.word = word;
	}


	public void setCorretto(boolean corretto) {
		this.corretto = corretto;
	}


	public boolean isCorretto() {
		return corretto;
	}


	@Override
	public String toString() {
		return word + "\n";
	}

	

	
	
	
	

	
	
}
