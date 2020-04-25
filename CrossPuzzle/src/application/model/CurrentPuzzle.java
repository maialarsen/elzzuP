package application.model;

public class CurrentPuzzle {
	private static WordSearch wsInstance = null;
	private static CurrentPuzzle cpInstance = null;

	private CrossPuzzle crosspuzzle;
	private WordSearch wordsearch;
	
	private CurrentPuzzle() {
		crosspuzzle = new CrossPuzzle();
	}
	
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
	
	public CrossPuzzle getCPPuzzle() {
		return crosspuzzle;
	}
	
	public WordSearch getWSPuzzle() {
		return wordsearch;
	}
}