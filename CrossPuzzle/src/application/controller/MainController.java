package application.controller;

import javafx.event.ActionEvent;
import javafx.fxml.FXML;
import javafx.scene.control.TextField;
import application.ViewSwitcher;

public class MainController{	
	@FXML private TextField puzzleName;
	
	public String getPuzzleName() {
		return puzzleName.getText();
	}

	@FXML
	void crossStart(ActionEvent event) {
		try {
			ViewSwitcher.getInstance().switchView(2);
		} catch(Exception e) {
			e.printStackTrace();
		}
	}
	

}