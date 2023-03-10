package library;

import java.util.ArrayList;
import java.util.HashMap;
import java.util.Map;

/*
 * To change this license header, choose License Headers in Project Properties.
 * To change this template file, choose Tools | Templates
 * and open the template in the editor.
 */
/**
 *
 * @author sa
 */
public class User {
    int id;
    String email;
    String password;
    String first_name;
    String last_name;
    int age;
    ArrayList<Book> list = new ArrayList<>();
    static Map<String, User> map = new HashMap<>();
    static User authUser;

    public User(int id, String email, String password, String first_name, String last_name, int age) {
        this.id = id;
        this.email = email;
        this.password = password;
        this.first_name = first_name;
        this.last_name = last_name;
        this.age = age;
    }

    public String getEmail() {
        return this.email;
    }

    public boolean checkPassword(String password) {
        return this.password.equals(password);
    }

    public ArrayList<Book> getAvailableBooks() {
        return list;
    }

    public String getBooksrepresentation() {
        return list.toString();
    }

    public String getPassword() {
        return password;
    }

    public String getFirstName() {
        return first_name;
    }

    public String getLastName() {
        return last_name;
    }

    public int getID() {
        return id;
    }

    public int getAge() {
        return age;
    }
}
