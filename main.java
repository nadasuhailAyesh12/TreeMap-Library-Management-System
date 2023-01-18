import javafx.stage.Stage;

/**
 *
 * @author sa
 */
public class main extends Application {

    public void start(Stage stage) throws IOException {

        Parent root = FXMLLoader.load(getClass().getResource("Signup.fxml"));

        Scene scene = new Scene(root);
        stage.setScene(scene);
        stage.show();

    }

    /**
     * @param args the command line arguments
     */
    public static void main(String[] args) {
        launch(args);
    }

}
