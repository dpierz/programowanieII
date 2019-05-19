package task2;

import java.io.*;
import java.util.List;

public class BooksFileWriter {
    void saveData(List<Book> listOfBooks) {
        try (FileWriter fileWriter = new FileWriter("D:\\Dokumenty_daria\\SDA_kurs\\programowanieII\\src\\main\\resources\\books.csv")) {
            try (BufferedWriter bufferedWriter = new BufferedWriter(fileWriter)) {
                for (Book book : listOfBooks) {
                    bufferedWriter.write(book.getTitle() + ";" + book.getNumberIsbn() + ";" + book.getYearOfPublication() + " \n");
                }
                System.out.println("Lista została zapisana.");
            }
        } catch (IOException e) {
            System.out.println("Coś poszło nie tak. Lista nie została zapisana.");
        }
    }
}