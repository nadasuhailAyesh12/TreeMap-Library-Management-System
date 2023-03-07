/*
 * To change this license header, choose License Headers in Project Properties.
 * To change this template file, choose Tools | Templates
 * and open the template in the editor.
 */
package library;

import java.util.ArrayList;
import java.util.Map;
import java.util.TreeMap;
import javafx.collections.FXCollections;
import javafx.collections.ObservableList;
import javafx.scene.control.Button;

/**
 *
 * @author sa
 */
public class Data {

    public ObservableList<Book> add() {
        ObservableList<Book> list = FXCollections.observableArrayList();
        fileRead file = new fileRead();
        TreeMap<String, Book> map = file.Read();
        for (Map.Entry<String, Book> entry : map.entrySet()) {
            String title = entry.getValue().getTitle();
            String author = entry.getValue().getAuthor();
            String isbn = entry.getValue().getIsbn();
            String publisher = entry.getValue().getPublisher();
            int totalPages = entry.getValue().getTotal_pages();
            double rating = entry.getValue().getRating();
            String publishDate = entry.getValue().getPublished_date();
            list.add(new Book(title, author, isbn, publisher, totalPages, rating, publishDate));

        }
        return list;
    }

}
