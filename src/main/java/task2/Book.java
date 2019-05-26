package task2;

import java.util.List;
import java.util.Objects;

public class Book {
    private String title;
    private long numberIsbn;
    private int yearOfPublication;
    private List<Author> authors;
    private Category category;

    public Book(String title, long numberIsbn, int yearOfPublication) {
        this.title = title;
        this.numberIsbn = numberIsbn;
        this.yearOfPublication = yearOfPublication;
    }

    public Book(String title, long numberIsbn, int yearOfPublication, List<Author> authors, Category category) { //List<Author> authors, Category category) {
        this.title = title;
        this.numberIsbn = numberIsbn;
        this.yearOfPublication = yearOfPublication;
        this.authors = authors;
        this.category = category;
    }

    public String getTitle() {
        return title;
    }

    public void setTitle(String title) {
        this.title = title;
    }

    public long getNumberIsbn() {
        return numberIsbn;
    }

    public void setNumberIsbn(long numberIsbn) {
        this.numberIsbn = numberIsbn;
    }

    public int getYearOfPublication() {
        return yearOfPublication;
    }

    public void setYearOfPublication(int yearOfPublication) {
        this.yearOfPublication = yearOfPublication;
    }

    public List<Author> getAuthors() {
        return authors;
    }

    public void setAuthors(List<Author> authors) {
        this.authors = authors;
    }

    public Category getCategory() {
        return category;
    }

    public void setCategory(Category category) {
        this.category = category;
    }


    @Override
    public String toString() {
        return "Book{" +
                "title='" + title + '\'' +
                ", numberIsbn=" + numberIsbn +
                ", yearOfPublication=" + yearOfPublication +
                ", authors=" + authors +
                ", category=" + category +
                '}';
    }
}
