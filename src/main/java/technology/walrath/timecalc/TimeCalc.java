package technology.walrath.timecalc;

import javafx.application.Application;
import javafx.event.ActionEvent;
import javafx.event.EventHandler;
import javafx.scene.Scene;
import javafx.scene.control.Button;
import javafx.scene.layout.StackPane;
import javafx.stage.Stage;

/**
 * It all starts here.
 */
public class TimeCalc extends Application {
    public static void main(String[] args) {
        launch(args);
    }

    @Override
    public void start(Stage primaryStage) throws Exception {
        configureDefaultWindow(primaryStage);

        Button button1 = new Button();
        button1.setText("Say 'Hello, World!'");
        button1.setOnAction(event -> System.out.println("Hello, World!"));

        StackPane root = new StackPane();
        root.getChildren().add(button1);
        primaryStage.setScene(new Scene(root, 300, 250));
        primaryStage.show();
    }

    /**
     * Set the basic settings of the main window.
     */
    private void configureDefaultWindow(Stage primaryStage) {
        primaryStage.setTitle("Time Card Calculator");
        primaryStage.setMinWidth(400);
        primaryStage.setMinHeight(400);
    }
}
