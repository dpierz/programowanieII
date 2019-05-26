package task2;

import java.io.IOException;
import java.util.ArrayList;
import java.util.List;

public class CategoriesMethod {
    CategoriesFilesLoader categoriesLoader = new CategoriesFilesLoader();
    List<Category> listOfCategories = new ArrayList<>();//załadowanie pliku

    {
        try {
            listOfCategories = categoriesLoader.readCategoriesFile();
        } catch (IOException e) {
            System.out.println("Nie udało się załadować kategorii z pliku");
            throw new IllegalStateException(e.getMessage()); //wywalenie programu
        }
    }

    void displayListOfCategories() {
        System.out.println("Wybrałeś: Wyświetlenie listy kategorii.");
        for (Category category : listOfCategories) {
            System.out.println(category.getCategoriesName());
        }
    }

}
