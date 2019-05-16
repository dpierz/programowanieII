package Task2;

public class Category {
    private int id;
    private int displayPriority;
    private String categoriesName;

    public Category(int id, int displayPriority, String categoriesName) {
        this.id = id;
        this.displayPriority = displayPriority;
        this.categoriesName = categoriesName;
    }

    public int getId() {
        return id;
    }

    @Override
    public String toString() {
        return "Id kategorii: "+id;
    }
}

