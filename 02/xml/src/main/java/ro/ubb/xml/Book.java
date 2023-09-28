package ro.ubb.xml;

public class Book {
    private String title;
    private String category;
    private String author;
    private int year;
    private float price;

    public Book() {
    }

    public Book(String title, String category, String author, int year, float price) {
        this.title = title;
        this.category = category;
        this.author = author;
        this.year = year;
        this.price = price;
    }

    @Override
    public String toString() {
        return "Book{" +
                "title='" + title + '\'' +
                ", category='" + category + '\'' +
                ", author='" + author + '\'' +
                ", year=" + year +
                ", price=" + price +
                '}';
    }

    public String getTitle() {
        return title;
    }

    public String getCategory() {
        return category;
    }

    public String getAuthor() {
        return author;
    }

    public int getYear() {
        return year;
    }

    public float getPrice() {
        return price;
    }
}
