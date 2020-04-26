package application.controller;

import java.util.ArrayList;

import application.ViewSwitcher;
import application.model.Board;
import javafx.event.ActionEvent;
import javafx.fxml.FXML;
import javafx.scene.control.Label;
import javafx.scene.control.TextArea;

public class WSDisplayController {
	private String name;
	private Board board;
	private ArrayList<String> words;
	
	public WSDisplayController(String name, Board board, ArrayList<String> words) {
		this.name = name;
		this.board = board;
		this.words = words;
	}
	
	@FXML 
	private Label puzzleName;
	
	@FXML 
	private TextArea boardDisplay;
	
	@FXML
	private TextArea wordList;
	
	@FXML 
	public void initialize() {
		boardDisplay.setEditable(false);
		wordList.setEditable(false);
		boardDisplay.setText(board.displayBoard());
		wordList.setText(board.displayWords(words));
		puzzleName.setText(this.name);
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
