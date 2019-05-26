package task2;

import java.io.IOException;
import java.util.ArrayList;
import java.util.List;

public class AuthorsMethod {
    AuthorsFilesLoader authorsLoader = new AuthorsFilesLoader();
    List<Author> listOfAuthors = new ArrayList<>();//załadowanie pliku

    {
        try {
            listOfAuthors = authorsLoader.readAuthorsFile();
        } catch (IOException e) {
            System.out.println("Nie udało się załadować autorów z pliku");
            throw new IllegalStateException(e.getMessage()); //wywalenie programu
        }
    }


    void displayListOfAuthors() {
        System.out.println("Wybrałeś: Wyświetlenie listy autorów.");
        for (Author author : listOfAuthors) {
            System.out.println(author.getAuthorsNameAndSurname());
        }
    }

}
