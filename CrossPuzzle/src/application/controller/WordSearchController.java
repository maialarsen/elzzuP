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

public class WordSearchController {
	private String name;
	private WordSearch currentPuzzle = CurrentPuzzle.getWSInstance();
	private Board gameBoard;	
	private ObservableList<String> sizeList = FXCollections.observableArrayList("8", "10", "12", "15", "20");
	
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
	public void initialize() {
		wordList.setEditable(false);
		sizeChoice.setItems(sizeList);
		sizeChoice.setValue(sizeList.get(0));
	}
	
	public Board getBoard() {
		return this.gameBoard;
	}
	
	public WordSearch getCurrentPuzzle() {
		return this.currentPuzzle;
	}
	
	public String getName() {
		return this.name;
	}
	
	public void setName(String name) {
		this.name = name;
	}
	
	@FXML
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
