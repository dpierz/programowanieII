package task2;

import java.io.BufferedReader;
import java.io.FileReader;
import java.io.IOException;
import java.util.ArrayList;
import java.util.List;

public class AuthorsFilesLoader {

    public List<Author> readAuthorsFile() throws IOException {
        List<Author> listOfAuthors = new ArrayList<>();
        FileReader authorsFileReader = new FileReader("D:\\Dokumenty_daria\\SDA_kurs\\programowanieII\\src\\main\\resources\\authors.csv");
        BufferedReader authorsBufferedReader = new BufferedReader(authorsFileReader);

        try {
            String textLine = authorsBufferedReader.readLine();
            do {
                String[] splittedLineFromAuthorsFile = textLine.split(";");
                int id = Integer.parseInt(splittedLineFromAuthorsFile[0]);
                String authorsNameAndSurname = splittedLineFromAuthorsFile[1];
                int authorsAge = Integer.parseInt(splittedLineFromAuthorsFile[2]);
                Author author = new Author(id, authorsNameAndSurname, authorsAge);
                listOfAuthors.add(author);
                textLine = authorsBufferedReader.readLine();
            } while (textLine != null);
        } finally {
            authorsBufferedReader.close();
        }
        return listOfAuthors;  // todo nie do końca rozumeim jak całe to wczytywanie działa, zrobiłam analogicznie do bookFIlesLoadera
    }

}
