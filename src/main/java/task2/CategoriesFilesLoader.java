package task2;

import java.io.BufferedReader;
import java.io.FileReader;
import java.io.IOException;
import java.util.ArrayList;
import java.util.List;

public class CategoriesFilesLoader {

    public List<Category> readCategoriesFile() throws IOException {
        List<Category> listOfCategories = new ArrayList<>();
        FileReader categoriesFileReader = new FileReader("D:\\Dokumenty_daria\\SDA_kurs\\programowanieII\\src\\main\\resources\\categories.csv");
        BufferedReader categoriesBufferedReader = new BufferedReader(categoriesFileReader);


        try {
            String textLine = categoriesBufferedReader.readLine();
            do {
                String[] splittedLineFromCategoriesFile = textLine.split(";");
                int id = Integer.parseInt(splittedLineFromCategoriesFile[0]);
                String categoriesName = splittedLineFromCategoriesFile[1];
                int displayPriority = Integer.parseInt(splittedLineFromCategoriesFile[2]);
                Category category = new Category(id, categoriesName, displayPriority);
                listOfCategories.add(category);
                textLine = categoriesBufferedReader.readLine();
            } while (textLine != null);
        } finally {
            categoriesBufferedReader.close();
        }
        return listOfCategories;
    }

}
