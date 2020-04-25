package application.controller;

import application.ViewSwitcher;
import application.model.CrossPuzzle;
import application.model.CurrentPuzzle;
import application.model.Entry;
import javafx.collections.FXCollections;
import javafx.collections.ObservableList;
import javafx.event.ActionEvent;
import javafx.fxml.FXML;
import javafx.scene.control.Button;
import javafx.scene.control.Label;
import javafx.scene.control.ListView;
import javafx.scene.control.TextField;

public class WSGenController {
	public static final ObservableList<String> data = 
	        FXCollections.observableArrayList();
	
	CrossPuzzle currentPuzzle = CurrentPuzzle.getCPInstance().getCPPuzzle();

    @FXML
    private Button addWord;

    @FXML
    private ListView<String> addedWords;

    @FXML
    private TextField hint;

    @FXML
    private TextField word;
    
    @FXML
    private Label newWords;

    @FXML
    void submitWord(ActionEvent event) {
    	String entryWord = word.getText();
    	String entryHint = hint.getText();
    	Entry entry = new Entry(entryWord,entryHint);
		//CrossPuzzle currentPuzzle = CurrentPuzzle.getInstance().getPuzzle();
		currentPuzzle.addEntry(entry);
		data.clear();
		for (Entry Xentry : currentPuzzle.getEntries()){
			data.add(Xentry.toString());
		}

		addedWords.setItems(data);

    }

    @FXML
    void finishCrossword(ActionEvent event) {
    	//CrossPuzzle.createPuzzle()
    }

    @FXML
    void takeMeHome(ActionEvent event) {
    	currentPuzzle.removeAllEntries(currentPuzzle.getEntries());
    	try {
    		ViewSwitcher.getInstance().switchView(1);
    	} catch(Exception e) {
    		e.printStackTrace();
    	}
    }

}