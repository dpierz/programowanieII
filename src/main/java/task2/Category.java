package task2;

public class Category {
    private int id;
    private String categoriesName;
    private int displayPriority;

    public Category(int id, String categoriesName, int displayPriority) {
        this.id = id;
        this.categoriesName = categoriesName;
        this.displayPriority = displayPriority;
    }

    public int getId() {
        return id;
    }

    public void setId(int id) {
        this.id = id;
    }

    public String getCategoriesName() {
        return categoriesName;
    }

    public int getDisplayPriority() {
        return displayPriority;
    }

    @Override
    public String toString() {
        return "Id kategorii: " + id;
    }
}

