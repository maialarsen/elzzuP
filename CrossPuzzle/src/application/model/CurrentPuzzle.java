package application.model;

/**
 * This class keeps instance of current puzzle 
 * @author Team elzzuP
 *
 */
public class CurrentPuzzle {
	private static WordSearch wsInstance = null;
	private static CurrentPuzzle cpInstance = null;

	private WordSearch wordsearch;
	
	/**
	 * Get instance of current puzzle
	 * @return instance of puzzle
	 */
	public static CurrentPuzzle getCPInstance() {
		if(cpInstance == null)
			cpInstance = new CurrentPuzzle();
		return cpInstance;
	}
	
	/**
	 * Get instance of word search
	 * @return instance of word search
	 */
	public static WordSearch getWSInstance() {
		if(wsInstance == null)
			wsInstance = new WordSearch();
		return wsInstance;
	}
	
	/**
	 * Get wordSearch puzzle
	 * @return current word search
	 */
	public WordSearch getWSPuzzle() {
		return wordsearch;
	}
}