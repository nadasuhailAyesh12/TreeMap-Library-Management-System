/*
 * To change this license header, choose License Headers in Project Properties.
 * To change this template file, choose Tools | Templates
 * and open the template in the editor.
 */
package library;

import java.io.IOException;
import java.net.URL;
import java.util.ResourceBundle;
import java.util.TreeMap;
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
import javafx.scene.control.Alert.AlertType;
import javafx.scene.control.Button;
import javafx.scene.control.MenuItem;
import javafx.scene.control.TableView;
import javafx.scene.control.TextField;
import javafx.stage.Stage;

public class SignupController implements Initializable {

    @FXML
    private TextField firstNameTxt;
    @FXML
    private TextField LastNameTxt;
    @FXML
    private TextField emailTxt;
    @FXML
    private TextField PasswordTxt;
    @FXML
    private TextField ageTxt;

    @FXML
    private Button SignUp;
   

    /**
     * Initializes the controller class.
     */
    public void signupAction(ActionEvent e) throws IOException, Exception {
        fileRead file = new fileRead();
        TreeMap<String, Book> m = file.Read();
        fileRead.ReadUsers("user.txt", User.map, m);
        User user = new User((int) Math.floor(Math.random() * 10000), emailTxt.getText(), PasswordTxt.getText(),
          firstNameTxt.getText(), LastNameTxt.getText(),
        Integer.parseInt(ageTxt.getText()));
        User.authUser = user;
        if (User.map.get(emailTxt.getText()) != null) {
            Alert a = new Alert(AlertType.INFORMATION);
            a.setContentText("you are aready registerd  we want to redirect you login instead");
            a.show();
            //already registerd
            Parent login1 = FXMLLoader.load(getClass().getResource("Register.fxml"));
            Stage st = (Stage) ((Node) e.getSource()).getScene().getWindow();
            Scene scene = new Scene(login1);
            st.setScene(scene);
            st.show();
            return;
        }
        User.map.put(user.getEmail(), user);
        fileRead.writeUsers(user, "user.txt");
        Parent login1 = FXMLLoader.load(getClass().getResource("Home.fxml"));
        Stage st = (Stage) ((Node) e.getSource()).getScene().getWindow();
        Scene scene = new Scene(login1);
        st.setScene(scene);
        st.show();
    }

    @Override
    public void initialize(URL url, ResourceBundle rb) {
        // TODO
        SignUp.setOnAction(e -> {
            try {
                signupAction(e);
            } catch (IOException ex) {
                Logger.getLogger(SignupController.class.getName()).log(Level.SEVERE, null, ex);
            } catch (Exception ex) {
                Logger.getLogger(SignupController.class.getName()).log(Level.SEVERE, null, ex);
            }
        });
      
        
    }

}
