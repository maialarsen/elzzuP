package application.controller;

import javafx.collections.FXCollections;
import javafx.collections.ObservableList;
import javafx.event.ActionEvent;
import javafx.fxml.FXML;
import javafx.scene.control.Button;
import javafx.scene.control.ChoiceBox;
import javafx.scene.control.TextField;

import application.ViewSwitcher;
import application.model.CrossPuzzle;
import application.model.CurrentPuzzle;

public class MainController{
	ObservableList<String> puzzleList = FXCollections.observableArrayList("Crossword", "WordSearch");
	
	@FXML
	private Button startButt;
	@FXML
	private TextField puzzleName;
	@FXML
	private ChoiceBox<String> puzzleChoice;
	//public CrossPuzzle currentPuzzle = new CrossPuzzle();
	@FXML
	public void initialize() {
		puzzleChoice.setItems(puzzleList);
		puzzleChoice.setValue(puzzleList.get(0));
	}
	@FXML
	void crossStart(ActionEvent event) {
		try {
		    String newPuzzleName = puzzleName.getText();
			CrossPuzzle currentPuzzle = CurrentPuzzle.getCPInstance().getCPPuzzle();
			currentPuzzle.setName(newPuzzleName);
			if (puzzleChoice.getValue().equals("Crossword"))
				ViewSwitcher.getInstance().switchView(2);
			else
				ViewSwitcher.getInstance().switchView(3);
		} catch(Exception e) {
			e.printStackTrace();
		}
	}
	

}