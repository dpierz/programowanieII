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

    public void setId(int id) {
        this.id = id;
    }

    public int getDisplayPriority() {
        return displayPriority;
    }

    public void setDisplayPriority(int displayPriority) {
        this.displayPriority = displayPriority;
    }

    public String getCategoriesName() {
        return categoriesName;
    }

    public void setCategoriesName(String categoriesName) {
        this.categoriesName = categoriesName;
    }
}
