package task2;

public class Author {
    private int authorsId;
    private String authorsNameAndSurname;
    private int authorsAge;

    public Author(int id, String authorsNameAndSurname, int authorsAge) {
        this.authorsId = id;
        this.authorsNameAndSurname = authorsNameAndSurname;
        this.authorsAge = authorsAge;
    }

    public int getAuthorsId() {
        return authorsId;
    }

    public String getAuthorsNameAndSurname() {
        return authorsNameAndSurname;
    }

    public int getAuthorsAge() {
        return authorsAge;
    }

    public void setAuthorsId(int authorsId) {
        this.authorsId = authorsId;
    }

    @Override
    public String toString() {
        return ""+authorsId;
    }
}
