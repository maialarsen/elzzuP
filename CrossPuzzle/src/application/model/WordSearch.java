package application.model;

import java.util.ArrayList;

/**
 * This class holds the data for the word search 
 * @author Team elzzuP
 *
 */
public class WordSearch {
	private String name;
	private ArrayList<String> words;
	
	/**
	 * Contructs a new word search with given name
	 * @param name
	 */
	public WordSearch(String name) {
		this.name = name;
		this.words = new ArrayList<String>();
	}
	
	/**
	 * Default word search given no name
	 */
	public WordSearch() {
		this.name = "";
		this.words = new ArrayList<String>();
	}

	/**
	 * returns name of word search
	 * @return word search name
	 */
	public String getName() {
		return this.name;
	}
	
	/**
	 * sets name of word search
	 * @param name
	 */
	public void setName(String name) {
		this.name = name;
	}
	
	/**
	 * Get the list of words added
	 * @return word list
	 */
	public ArrayList<String> getWords() {
		return this.words;
	}
	
	/**
	 * Adds word to list
	 * @param word
	 */
	public void addWord(String word) {
		this.words.add(word);
	}
	
	/**
	 * Removes word from list
	 * @param word
	 */
	public void removeWord(String word) {
		this.words.remove(word);
	}
	
	@Override
	public String toString() {
		return "WordSearch: " + name + " entries [" + words + "]";
	}
}
