package application;

import javafx.application.Application;
//import javafx.scene.Scene;
import javafx.scene.layout.BorderPane;
import javafx.stage.Stage;

public class Main extends Application{

    public static void main(String[] args) {
        launch(args);
    }
    
    @Override
	public void stop() throws Exception{
		super.stop();
	}

    @Override
    public void start(Stage arg0) throws Exception {
        BorderPane rootPane = new BorderPane();
        ViewSwitcher.getInstance().setStage(arg0);
        ViewSwitcher.getInstance().setRootPane(rootPane);
        ViewSwitcher.getInstance().initStage();
    }

}