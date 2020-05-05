package application;

import java.io.IOException;
import java.net.URL;

import application.controller.MainController;
import application.controller.WSDisplayController;
import application.controller.WordSearchController;
import javafx.fxml.FXMLLoader;
import javafx.scene.Scene;
import javafx.scene.layout.BorderPane;
import javafx.stage.Stage;

/**
 * This class switches the views of the application
 * @author Team elzzuP
 *
 */
public class ViewSwitcher {
	private static ViewSwitcher instance = null;
	private Stage stage;
	private BorderPane rootPane;
	
	WordSearchController wordSearchController = null;
	MainController mainController = null;

	/**
	 * Get instance of ViewSwitcher
	 * @return instance of ViewSwitcher class
	 */
	public static ViewSwitcher getInstance() {
		if (instance == null)
			instance = new ViewSwitcher();
		return instance;
	}

	/**
	 * Initializes stage for application
	 * @throws IOException
	 */
	public void initStage() throws IOException {
		Scene scene = new Scene(rootPane, 600, 400);
		stage.setTitle("WordSearch Generator");
		stage.setScene(scene);
		stage.show();
		switchView(1);
	}

	/**
	 * Switches view from list of fxml files
	 * @param view
	 * @throws IOException
	 */
	public void switchView(int view) throws IOException {
		URL fxmlFile;
		FXMLLoader loader;
		String[] fxmlFiles = { "view/Main.fxml", "view/WordSearchView.fxml", "view/WSDisplayView.fxml"};
		fxmlFile = this.getClass().getResource(fxmlFiles[view - 1]);
		loader = new FXMLLoader(fxmlFile);
		switch (view) {
		case 1:
			mainController = new MainController();
			loader.setController(mainController);
			rootPane.setCenter(loader.load());
			break;
		case 2:
			wordSearchController = new WordSearchController(mainController.getPuzzleName());
			loader.setController(wordSearchController);
			rootPane.setCenter(loader.load());
			break;
		case 3:
			WSDisplayController wsDisplayController = new WSDisplayController(wordSearchController.getName(), wordSearchController.getBoard(), wordSearchController.getCurrentPuzzle().getWords());
			loader.setController(wsDisplayController);
			rootPane.setCenter(loader.load());
			break;
		}
	}
	
	/**
	 * Get stage of application
	 * @return application main stage
	 */
	public Stage getStage() {
		return stage;
	}
	
	/** 
	 * Set stage of application
	 * @param stage
	 */
	public void setStage(Stage stage) {
		this.stage = stage;
	}

	/**
	 * Get BorderPane of application
	 * @return
	 */
	public BorderPane getRootPane() {
		return rootPane;
	}

	/**
	 * Set BorderPane of application
	 * @param rootPane
	 */
	public void setRootPane(BorderPane rootPane) {
		this.rootPane = rootPane;
	}

	/**
	 * Set instance of ViewSwitcher
	 * @param instance
	 */
	public static void setInstance(ViewSwitcher instance) {
		ViewSwitcher.instance = instance;
	}
}
