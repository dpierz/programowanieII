package Task2;

public class Author {
    private int id;
    private String authorsName;
    private String authorsSurname;
    private int authorsAge;

    public Author(int id, String authorsName, String authorsSurname, int authorsAge) {
        this.id = id;
        this.authorsName = authorsName;
        this.authorsSurname = authorsSurname;
        this.authorsAge = authorsAge;
    }


    public int getId() {
        return id;
    }

    public void setId(int id) {
        this.id = id;
    }

    public String getAuthorsName() {
        return authorsName;
    }

    public void setAuthorsName(String authorsName) {
        this.authorsName = authorsName;
    }

    public String getAuthorsSurname() {
        return authorsSurname;
    }

    public void setAuthorsSurname(String authorsSurname) {
        this.authorsSurname = authorsSurname;
    }

    public int getAuthorsAge() {
        return authorsAge;
    }

    public void setAuthorsAge(int authorsAge) {
        this.authorsAge = authorsAge;
    }
}
