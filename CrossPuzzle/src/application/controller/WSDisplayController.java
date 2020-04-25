package application.controller;

import java.util.ArrayList;

import application.ViewSwitcher;
import application.model.Board;
import javafx.event.ActionEvent;
import javafx.fxml.FXML;
import javafx.scene.control.TextArea;

public class WSDisplayController {
	private Board board;
	private ArrayList<String> words;
	
	public WSDisplayController(Board board, ArrayList<String> words) {
		this.board = board;
		this.words = words;
	}
	
	@FXML 
	private TextArea boardDisplay;
	
	@FXML
	private TextArea wordList;
	
	@FXML 
	public void initialize() {
		boardDisplay.setEditable(false);
		wordList.setEditable(false);
		boardDisplay.setText("");
		wordList.setText("");
		boardDisplay.setText(board.displayBoard());
		wordList.setText(board.displayWords(words));
	}
	
	@FXML public void goHome(ActionEvent event) {
		words.clear();
		try {
    		ViewSwitcher.getInstance().switchView(1);
    	} catch(Exception e) {
    		e.printStackTrace();
    	}
	}
}
