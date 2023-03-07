package library;

import java.io.IOException;
import java.net.URL;
import java.util.ArrayList;
import java.util.Optional;
import java.util.ResourceBundle;
import java.util.TreeMap;
import java.util.logging.Level;
import java.util.logging.Logger;
import javafx.collections.FXCollections;
import javafx.collections.ObservableList;
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
import javafx.scene.control.ButtonType;
import javafx.scene.control.MenuItem;
import javafx.scene.control.TableColumn;
import javafx.scene.control.TableView;
import javafx.scene.control.TextField;
import javafx.scene.control.cell.PropertyValueFactory;
import javafx.stage.Stage;
import java.util.Comparator;
import java.util.Map;

/**
 * FXML Controller class
 *
 * @author sa
 */
public class HomeController implements Initializable {

    @FXML
    TableView<Book> view;
    @FXML
    private TextField search;
    @FXML
    private Button searchbtn;
    @FXML
    private Button save;
    @FXML
    private TextField t3;
    @FXML
    private TextField t4;
    @FXML
    private TextField t5;
    @FXML
    private TextField t6;
    @FXML
    private TextField t7;
    @FXML
    private TextField t1;
    @FXML
    private TextField t2;
    @FXML
    private MenuItem d1;
    @FXML
    private Button buybtn;
    @FXML
    private TableView view1;
    @FXML
    private Button logout;
    @FXML
    private Button sort;

    @Override
    public void initialize(URL url, ResourceBundle rb) {
        TableColumn title = new TableColumn("title");
        TableColumn author = new TableColumn("author ");
        TableColumn isbn = new TableColumn("isbn ");
        TableColumn publisher = new TableColumn("publisher ");
        TableColumn total_pages = new TableColumn("total_pages");
        TableColumn rating = new TableColumn("rating ");
        TableColumn published_date = new TableColumn("published_date");

        title.setCellValueFactory(new PropertyValueFactory<Book, String>("title"));
        author.setCellValueFactory(new PropertyValueFactory<Book, String>("author"));
        isbn.setCellValueFactory(new PropertyValueFactory<Book, Long>("isbn"));
        publisher.setCellValueFactory(new PropertyValueFactory<Book, String>("publisher"));
        total_pages.setCellValueFactory(new PropertyValueFactory<Book, Integer>("total_pages"));
        rating.setCellValueFactory(new PropertyValueFactory<Book, Integer>("rating"));
        published_date.setCellValueFactory(new PropertyValueFactory<Book, String>("published_date"));

        TableColumn title1 = new TableColumn("title");
        TableColumn rating1 = new TableColumn("rating ");
        title1.setCellValueFactory(new PropertyValueFactory<Book, String>("title"));
        rating1.setCellValueFactory(new PropertyValueFactory<Book, Integer>("rating"));

        view1.getColumns().addAll(title1, rating1);
        view.getColumns().addAll(title, author, publisher, total_pages, rating, published_date);
        view.setItems(getBooks());

        searchbtn.setOnAction(event -> {
            searchAction();
        });

        save.setOnAction(event -> {
            try {
                view.setItems(add());
            } catch (IOException ex) {
                Logger.getLogger(HomeController.class.getName()).log(Level.SEVERE, null, ex);
            }
        });

        buybtn.setOnAction(event -> {

            try {
                handelbuy();
            } catch (IOException ex) {
                Logger.getLogger(HomeController.class.getName()).log(Level.SEVERE, null, ex);
            }
        });
        logout.setOnAction(event -> {

            try {
                handellogout(event);
            } catch (IOException ex) {
                Logger.getLogger(HomeController.class.getName()).log(Level.SEVERE, null, ex);
            }
        });

    }

    public ObservableList<Book> getBooks() {
        ObservableList<Book> list = FXCollections.observableArrayList();

        Data o = new Data();
        list = o.add();

        return list;
    }

    public ArrayList<Book> SearchMap(String required, TreeMap<String, Book> map) {
        ArrayList<Book> list = new ArrayList<>();
        for (String s : map.keySet()) {
            if (s.startsWith(required,0)) {
                list.add(map.get(s));
            }
        }
        return list;
    }

    public ObservableList<Book> AddSearchResult() {
        fileRead file = new fileRead();
        TreeMap<String, Book> map = file.Read();
        ObservableList<Book> list = FXCollections.observableArrayList();
        String s = search.getText().toUpperCase();
        ArrayList<Book> result = SearchMap(s, map);
        for (int i = 0; i < result.size(); i++) {
            String title = result.get(i).getTitle();
            String author = result.get(i).getAuthor();
            String isbn = result.get(i).getIsbn();
            String publisher = result.get(i).getPublisher();
            int total_pages = result.get(i).getTotal_pages();
            double rating = result.get(i).getRating();
            String published_date = result.get(i).getPublished_date();
            list.add(new Book(title, author, isbn, publisher,
                    total_pages, rating,
                    published_date
            ));
        }
        return list;
    }

    public void searchAction() {
        view.getItems().clear();
        view.setItems(AddSearchResult());
    }

    public ObservableList<Book> add() throws IOException {
        fileRead file = new fileRead();
        TreeMap<String, Book> map = file.Read();
        String authorValue = t2.getText();
        String isbnValue = t3.getText();
        String publisherValue = t4.getText();
        int totalPagesValue = Integer.parseInt(t5.getText());
        double ratingValue = Double.parseDouble(t6.getText());
        String titleValue = t1.getText();
        String dateValue = t7.getText();
        Book book = new Book(titleValue, authorValue, publisherValue, isbnValue, totalPagesValue, ratingValue, dateValue);

        ObservableList<Book> l = getBooks();
        insertToMap(book, map);
        l.add(book);
        return l;

    }

    public void delete() {
        fileRead file = new fileRead();
        TreeMap<String, Book> map = file.Read();
        Book book = view.getSelectionModel().getSelectedItem();
        Alert alert = new Alert(AlertType.CONFIRMATION);
        alert.setHeaderText("deleting book");
        alert.setContentText("Are you sure you want to delete it");
        Optional<ButtonType> result = alert.showAndWait();
        if (result.get() == ButtonType.OK) {
            if (deleteFromMap(book.getTitle(), map)) {
                view.getItems().removeAll(view.getSelectionModel().getSelectedItem());
            }
        }

    }

    public Book insertToMap(Book book, TreeMap<String, Book> map) {
        return map.put(book.getTitle(), book);
    }

    public boolean deleteFromMap(String required, TreeMap<String, Book> map) {
        if (!(map.containsKey(required))) {
            return false;
        } else {
            map.remove(required);
            return true;
        }
    }

    public void handelbuy() throws IOException {
        Book temp = view.getSelectionModel().getSelectedItem();
        String title = temp.getTitle();
        double rating = temp.getRating();
        Book b = new Book(title, rating);
        view1.getItems().addAll(temp);
  String author = temp.getAuthor();
            String isbn = temp.getIsbn();
            String publisher = temp.getPublisher();
            int totalPages = temp.getTotal_pages();
            String PublishDate=temp.getPublished_date();
            Book c=new Book(title,author,isbn,publisher,totalPages,rating, PublishDate);
            User.authUser.getAvailableBooks().add(c);
    }

    public void handellogout(ActionEvent e) throws IOException {
        User.authUser = null;
        Parent login1 = FXMLLoader.load(getClass().getResource("Register.fxml"));
        Stage st = (Stage) ((Node) e.getSource()).getScene().getWindow();
        Scene scene = new Scene(login1);
        st.setScene(scene);
        st.show();

    }
}

   