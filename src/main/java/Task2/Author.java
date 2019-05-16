package Task2;

public class Author {
    private int authorsId;
    private String authorsName;
    private int authorsAge;

    public Author(int id, String authorsName, String authorsSurname, int authorsAge) {
        this.authorsId = id;
        this.authorsName = authorsName;
        this.authorsAge = authorsAge;
    }

    public int getAuthorsId() {
        return authorsId;
    }

    public String getAuthorsName() {
        return authorsName;
    }

    @Override
    public String toString() {
        return authorsId + " " + authorsName;
    }
}
