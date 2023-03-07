/*
 * To change this license header, choose License Headers in Project Properties.
 * To change this template file, choose Tools | Templates
 * and open the template in the editor.
 */
package library;

/**
 *
 * @author sa
 */
import javafx.geometry.Insets;
import javafx.geometry.Pos;
import javafx.scene.Scene;
import javafx.scene.control.Button;
import javafx.scene.control.Label;
import javafx.scene.layout.GridPane;
import javafx.scene.layout.StackPane;
import javafx.stage.Stage;

public class Error extends Stage {
    private Label errorMessage;
    private Scene scene;
    private StackPane errorWindow;
    private Button closeBtn = new Button("close");

    Error(String errorMessage) {
        super();
        this.errorMessage = new Label(errorMessage);
        GridPane pane = new GridPane();
        pane.setHgap(15);
        pane.add(this.errorMessage, 0, 0);
        pane.add(closeBtn, 1, 1);
        pane.setPadding(new Insets(10, 10, 10, 10));
        pane.setAlignment(Pos.CENTER);
        errorWindow = new StackPane(pane);
        scene = new Scene(errorWindow, 300, 300);
        this.setScene(scene);
        closeBtn.setOnAction(evt -> {
            this.close();
        });

    }
}