public class Book {

    private int book_id;
    private String author;
    private String title;
    private String isbn;
    private String publisher;
    private int total_pages;
    private double rating;
    private String published_date;
    private Button buy;

    public Book(int book_id, String title, String author, String isbn, String publisher, int total_pages, double rating, String published_date) {
        this.book_id = book_id;
        this.author = author;
        this.title = title;
        this.isbn = isbn;
        this.publisher = publisher;
        this.total_pages = total_pages;
        this.rating = rating;
        this.published_date = published_date;
    }

    public Book(String title, String author, String isbn, String publisher, int total_pages, double rating, String published_date) {

        this.author = author;
        this.title = title;
        this.isbn = isbn;
        this.publisher = publisher;
        this.total_pages = total_pages;
        this.rating = rating;
        this.published_date = published_date;
        this.buy = new Button("buy");

    }

    public Button getBuy() {
        return buy;
    }

    public int getBook_id() {
        return book_id;
    }

    public String getAuthor() {
        return author;
    }

    public String getTitle() {
        return title;
    }

    public String getIsbn() {
        return isbn;
    }

    public String getPublisher() {
        return publisher;
    }

    public int getTotal_pages() {
        return total_pages;
    }

    public double getRating() {
        return rating;
    }

    public String getPublished_date() {
        return published_date;
    }

    public void setBook_id(int book_id) {
        this.book_id = book_id;
    }

    public void setAuthor(String author) {
        this.author = author;
    }

    public void setTitle(String title) {
        this.title = title;
    }

    public void setIsbn(String isbn) {
        this.isbn = isbn;
    }

    public void setPublisher(String publisher) {
        this.publisher = publisher;
    }

    public void setTotal_pages(int total_pages) {
        this.total_pages = total_pages;
    }

    public void setRating(float rating) {
        this.rating = rating;
    }

    public void setPublished_date(String published_date) {
        this.published_date = published_date;
    }

    public Book(String title, double rating) {
        this.title = title;
        this.rating = rating;
    }

    public String toString() {
        return book_id + " " + title + " " + author + " " + isbn + " " + publisher + " " + total_pages + " " + rating + " " + published_date;
    }

}
