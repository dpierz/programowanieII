package Task2;

public class Book {
    private String title;
    private long numberIsbn;
    private int yearOfPublished; //todo integer
//    List<Author>

   public Book(String title, long numberIsbn, int yearOfPublished) {

        this.title = title;
        this.numberIsbn = numberIsbn;
        this.yearOfPublished = yearOfPublished;
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

    public int getYearOfPublished() {
        return yearOfPublished;
    }

    public void setYearOfPublished(int yearOfPublished) {
        this.yearOfPublished = yearOfPublished;
    }

}
