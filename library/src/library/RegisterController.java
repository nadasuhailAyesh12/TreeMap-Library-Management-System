/*
 * To change this license header, choose License Headers in Project Properties.
 * To change this template file, choose Tools | Templates
 * and open the template in the editor.
 */
package library;

import java.io.IOException;
import java.net.URL;
import java.util.Optional;
import java.util.ResourceBundle;
import java.util.logging.Level;
import java.util.logging.Logger;
import javafx.event.ActionEvent;
import javafx.fxml.FXML;
import javafx.fxml.FXMLLoader;
import javafx.fxml.Initializable;
import javafx.scene.Node;
import javafx.scene.Parent;
import javafx.scene.Scene;
import javafx.scene.control.Alert;
import javafx.scene.control.Button;
import javafx.scene.control.ButtonType;
import javafx.scene.control.TextField;
import javafx.stage.Stage;

/**
 * FXML Controller class
 *
 * @author sa
 */
public class RegisterController implements Initializable {

    @FXML
    private TextField emailTxt;
    @FXML
    private TextField PasswordTxt;

    @FXML
    private Button login;
    User loggedUser;

    public void loginAction(ActionEvent e) throws IOException {

        if (User.map.get(emailTxt.getText()) == null) {
            Alert a = new Alert(Alert.AlertType.INFORMATION);
            a.setContentText("you  don’t have account signup instead");
            a.show();
            Parent login1 = FXMLLoader.load(getClass().getResource("Signup.fxml"));
            Stage st = (Stage) ((Node) e.getSource()).getScene().getWindow();
            Scene scene = new Scene(login1);
            st.setScene(scene);
            st.show();

        }
        else if (!(User.map.get(emailTxt.getText()).checkPassword(PasswordTxt.getText()))) {
            new Error("user name or password are invalid").show();
            
        }
        else{
        loggedUser = User.map.get(emailTxt.getText());
        User.authUser = loggedUser;

        Parent login1 = FXMLLoader.load(getClass().getResource("Home.fxml"));
        Stage st = (Stage) ((Node) e.getSource()).getScene().getWindow();
        Scene scene = new Scene(login1);
        st.setScene(scene);
        st.show();
        }
    }

    /**
     * Initializes the controller class.
     */
    @Override
    public void initialize(URL url, ResourceBundle rb) {
        login.setOnAction(e -> {
            try {
                loginAction(e);
            } catch (IOException ex) {
                Logger.getLogger(SignupController.class.getName()).log(Level.SEVERE, null, ex);
            }
        });
        // TODO
    }

}
