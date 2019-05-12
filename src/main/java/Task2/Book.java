package Task2;

public class Book {
    private String title;
    private String numberIsbn;
    private String yearOfPublished; //todo integer

   // public Book(String title, String numberIsbn, String yearOfPublished) {todo konstruktor bezwarunkowy zrobiłam, a powinen chyba wymuszać żeby ksiażka tak wyglądała, ale nie wiem co wpisać w klasie menu
    public Book (){
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

    public String getNumberIsbn() {
        return numberIsbn;
    }

    public void setNumberIsbn(String numberIsbn) {
        this.numberIsbn = numberIsbn;
    }

    public String getYearOfPublished() {
        return yearOfPublished;
    }

    public void setYearOfPublished(String yearOfPublished) {
        this.yearOfPublished = yearOfPublished;
    }

    @Override
    public String toString() {
        return
                title+" "+yearOfPublished+" "+numberIsbn +"\n";//todo dlaczego tak głupio się wyświetla przecinki?
    }
}
