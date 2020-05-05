package application.controller;

import javafx.event.ActionEvent;
import javafx.fxml.FXML;
import javafx.scene.control.TextField;
import application.ViewSwitcher;

/**
 * This class controls the startup view Main.fxml
 * @author Team elzzuP
 *
 */
public class MainController{	
	@FXML private TextField puzzleName;
	
	/**
	 * Get text entered into TextField as puzzle name
	 * @return
	 */
	public String getPuzzleName() {
		return puzzleName.getText();
	}

	@FXML
	/**
	 * Controls button to start creating puzzle
	 * @param event
	 */
	void crossStart(ActionEvent event) {
		try {
			ViewSwitcher.getInstance().switchView(2);
		} catch(Exception e) {
			e.printStackTrace();
		}
	}
	

}