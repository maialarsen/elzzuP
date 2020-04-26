package application.model;

public class CurrentPuzzle {
	private static WordSearch wsInstance = null;
	private static CurrentPuzzle cpInstance = null;

	private WordSearch wordsearch;
	
	public static CurrentPuzzle getCPInstance() {
		if(cpInstance == null)
			cpInstance = new CurrentPuzzle();
		return cpInstance;
	}
	
	public static WordSearch getWSInstance() {
		if(wsInstance == null)
			wsInstance = new WordSearch();
		return wsInstance;
	}
	
	public WordSearch getWSPuzzle() {
		return wordsearch;
	}
}