package application.model;

import java.util.ArrayList;

public class WordSearch {
	private String name;
	private ArrayList<String> words;
	
	public WordSearch(String name) {
		this.name = name;
		this.words = new ArrayList<String>();
	}
	
	public WordSearch() {
		this.name = "";
		this.words = new ArrayList<String>();
	}

	public String getName() {
		return this.name;
	}
	
	public void setName(String name) {
		this.name = name;
	}
	
	public ArrayList<String> getWords() {
		return this.words;
	}
	
	public void addWord(String word) {
		this.words.add(word);
	}
	
	public void removeWord(String word) {
		this.words.remove(word);
	}
	
	@Override
	public String toString() {
		return "WordSearch: " + name + " entries [" + words + "]";
	}
}
