/*
 * To change this license header, choose License Headers in Project Properties.
 * To change this template file, choose Tools | Templates
 * and open the template in the editor.
 */
package library;

import java.io.IOException;
import javafx.application.Application;
import javafx.fxml.FXMLLoader;
import javafx.scene.Parent;
import javafx.scene.Scene;
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
//        TreeMap<Book ,String> v =new TreeMap(new  sortKey());
//         Book b1 = new Book(1,"data","f");
//         Book b2 = new Book(2,"java","d");
//         Book b3 =new   Book(3,"c++","r");
//          v.put(b1,b1.getTitle());
//          v.put(b2,b2.getTitle());
//          v.put(b3, b3.getTitle());
//          for(Map.Entry<Book,String> entry:v.entrySet()){
//              System.out.println( entry.getKey());  
//              
//          }
//import java.util.Comparator; 
//class sortKey implements Comparator<Book>{
//
//    @Override
//    public int compare(Book o1, Book o2) {
//        return o1.getTitle().compareTo(o2.getTitle());
//    }
//}
        launch(args);
    }

}
