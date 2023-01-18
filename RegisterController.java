public class RegisterController implements Initializable {
    @FXML
    private TextField emailTxt;
    @FXML
    private TextField PasswordTxt;
   
    @FXML
    private Button login;
     User  loggedUser ;
    
      public void loginAction(ActionEvent e) throws IOException{
      
                 if (User.map.get(emailTxt.getText()) == null) {
                   Parent login1 = FXMLLoader.load(getClass().getResource("Signup.fxml"));
                Stage st = (Stage) ((Node) e.getSource()).getScene().getWindow();
                Scene scene = new Scene(login1);
                st.setScene(scene);
                st.show();
                    
                }
                if (!(User.map.get(emailTxt.getText()).checkPassword(PasswordTxt.getText()))) {
                    new Error("user name or password are invalid").show();
                    return;
                }
                loggedUser = User.map.get(emailTxt.getText());
               
               
                Parent login1 = FXMLLoader.load(getClass().getResource("Home.fxml"));
                Stage st = (Stage) ((Node) e.getSource()).getScene().getWindow();
                Scene scene = new Scene(login1);
                st.setScene(scene);
                st.show();
            }
   
    /**
     * Initializes the controller class.
     */
    @Override
    public void initialize(URL url, ResourceBundle rb) {
        login.setOnAction(e->{
            try {
                loginAction(e);
            } catch (IOException ex) {
                Logger.getLogger(SignupController.class.getName()).log(Level.SEVERE, null, ex);
            }
        });
      
    }    
    
}
