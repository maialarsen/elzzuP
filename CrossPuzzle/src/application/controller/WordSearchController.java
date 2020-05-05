package application.controller;

import application.ViewSwitcher;
import application.model.Board;
import application.model.CurrentPuzzle;
import application.model.WordSearch;
import javafx.collections.FXCollections;
import javafx.collections.ObservableList;
import javafx.event.ActionEvent;
import javafx.fxml.FXML;
import javafx.scene.control.ChoiceBox;
import javafx.scene.control.Label;
import javafx.scene.control.TextArea;
import javafx.scene.control.TextField;
/**
 * This class controls the view to add words to word search
 * @author Team elzzuP
 *
 */
public class WordSearchController {
	private String name;
	private WordSearch currentPuzzle = CurrentPuzzle.getWSInstance();
	private Board gameBoard;	
	private ObservableList<String> sizeList = FXCollections.observableArrayList("8", "10", "12", "15", "20");
	
	/**
	 * This constructs a WordSearchController with a name
	 * @param name name of Word Search
	 */
	public WordSearchController(String name) {
		this.name = name;
	}
	
	@FXML
	private Label errorMsg;
	
	@FXML
	private ChoiceBox<String> sizeChoice;
	
	@FXML
	public TextField word;
	
	@FXML
	public TextArea wordList;

	@FXML
	/**
	 * Initialize fxml views
	 */
	public void initialize() {
		wordList.setEditable(false);
		sizeChoice.setItems(sizeList);
		sizeChoice.setValue(sizeList.get(0));
	}
	
	/**
	 * Get the current board
	 * @return instance of Board class
	 */
	public Board getBoard() {
		return this.gameBoard;
	}
	
	/**
	 * Set current game board
	 * @param board
	 */
	public void setBoard(Board board) {
		this.gameBoard = board;
	}
	
	/**
	 * Get the current word search puzzle
	 * @return instance of Word Search class
	 */
	public WordSearch getCurrentPuzzle() {
		return this.currentPuzzle;
	}
	
	/**
	 * Set the current word search puzzle
	 * @param wordSearch
	 */
	public void setCurrentPuzzle(WordSearch wordSearch) {
		this.currentPuzzle = wordSearch;
	}
	
	/**
	 * Get name of puzzle
	 * @return name of puzzle
	 */
	public String getName() {
		return this.name;
	}
	
	/**
	 * Set name of puzzle
	 * @param name
	 */
	public void setName(String name) {
		this.name = name;
	}
	
	@FXML
	/**
	 * Controls button to add word from textfield into word ArrayList
	 * @param event
	 */
	public void addWord(ActionEvent event) {
		String newWord = word.getText();
		
		if (newWord.length() > Integer.parseInt(sizeChoice.getValue())) 
			errorMsg.setText("Your word needs to be less than or \nequal to the board size");
		else {
			errorMsg.setText("");
			currentPuzzle.addWord(newWord);
			wordList.appendText(newWord + "\n");
		}
	}
	
	@FXML
	/**
	 * Controls finish button to go back to main view when pressed
	 * @param event
	 */
	public void goHome(ActionEvent event) {
		currentPuzzle.getWords().clear();
		wordList.clear();
    	try {
    		ViewSwitcher.getInstance().switchView(1);
    	} catch(Exception e) {
    		e.printStackTrace();
    	}
	}
	
	@FXML
	/**
	 * Controls finish button to switch to display view 
	 * @param event
	 */
	public void finishPuzzle(ActionEvent event) {
			gameBoard = new Board(Integer.parseInt(sizeChoice.getValue()));
			gameBoard.generate(currentPuzzle.getWords());
			try {
				ViewSwitcher.getInstance().switchView(3);
			} catch(Exception e) {
				e.printStackTrace();
			}	
	}
}
