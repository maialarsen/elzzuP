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


public class ViewSwitcher {
	private static ViewSwitcher instance = null;
	private Stage stage;
	private BorderPane rootPane;
	
	WordSearchController wordSearchController = null;
	MainController mainController = null;

	public static ViewSwitcher getInstance() {
		if (instance == null)
			instance = new ViewSwitcher();
		return instance;
	}

	public void initStage() throws IOException {
		Scene scene = new Scene(rootPane, 600, 400);
		stage.setTitle("WordSearch Generator");
		stage.setScene(scene);
		stage.show();
		switchView(1);
	}

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

	public Stage getStage() {
		return stage;
	}

	public void setStage(Stage stage) {
		this.stage = stage;
	}

	public BorderPane getRootPane() {
		return rootPane;
	}

	public void setRootPane(BorderPane rootPane) {
		this.rootPane = rootPane;
	}

	public static void setInstance(ViewSwitcher instance) {
		ViewSwitcher.instance = instance;
	}
}
