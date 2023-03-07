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
import java.util.Scanner;
import java.util.ArrayList;
import java.io.*;
import java.io.BufferedReader;
import java.io.BufferedReader;
import java.io.FileNotFoundException;
import java.io.FileReader;
import java.io.IOException;
import java.util.Arrays;
import java.util.HashMap;
import java.util.Map;
import java.util.TreeMap;
import javafx.application.Application;
import javafx.scene.Scene;
import javafx.scene.control.Label;
import javafx.scene.layout.GridPane;
import javafx.stage.Stage;

public class fileRead {

    public  TreeMap<String, Book> Read() {
        Scanner input = new Scanner(System.in);
        BufferedReader br = null;

        TreeMap<String, Book> list = new TreeMap();
        try {
            br = new BufferedReader(new FileReader("books.txt"));

        } catch (FileNotFoundException ex) {
            System.out.println(ex.getMessage() + "The file not found ");
            System.exit(0);
        }
        try {
            final int num = Integer.parseInt(br.readLine());
            for (int i = 0; i < 10; i++) {
                int id = Integer.parseInt(br.readLine());
                String[] values = new String[7];
                for (int j = 0; j < 7; j++) {
                    String line = br.readLine();
                    int index = line.indexOf(' ', (line.indexOf(' ')) + 1) + 1;

                    String attribute_value = line.substring(index);
                    if (index == line.length()) {

                        values[j] = "0";
                    } else {
                        values[j] = attribute_value;
                    }


                }
                list.put(values[0], new Book(id, values[0], values[1], (values[2]), values[3], Integer.parseInt(values[4]), Double.parseDouble(values[5]), values[6]));

                br.readLine();

            }

        } catch (IOException ex) {
            System.out.println(ex.getMessage() + "Erorr reading file ");
        }
        return list;
    }
    public static void ReadUsers(String fileName, Map<String, User> map,TreeMap<String,Book> map1) throws Exception {
        File note = new File(fileName);
        Scanner input = new Scanner(note);
        while (input.hasNext()) {
            int id = Integer.parseInt(input.next());
            String email = input.next();
            String firstName = input.next();
            String lastName = input.next();
            int age = input.nextInt();
            String password = input.next();
            User user = new User(id, email, password, firstName, lastName, age);
            String list = input.next();
         
            String[] boughtBooks = list.substring(list.indexOf("[") + 1, list.indexOf("]")).split(",");
 for (int i = 0; i < boughtBooks.length; i++) {
               if (map1.get(boughtBooks[i]) != null) {
                   user.getAvailableBooks().add(map1.get(boughtBooks[i]));
              }
           }
            map.put(user.getEmail(), user);
        }
        input.close();
    }
     public static void writeUsers(User user, String fileName) {
        try {
            File file = new File(fileName);
            String s = "";
            if (!(file.length() > 0)) {
                s += "\n";
            }
            s += user.getID() + " " + user.getEmail() + " " + user.getFirstName() + " " + user.getLastName() + " "
                    + user.getAge() + " " + user.getPassword() + " " + user.getBooksrepresentation() + "\n";
            FileWriter fw = new FileWriter(fileName, true);
            fw.write(s);
            fw.close();
        } catch (IOException e) {
        }
    }
}

  
    


