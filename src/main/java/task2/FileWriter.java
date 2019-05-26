package task2;

import java.io.*;
import java.util.List;

public class FileWriter {
    void saveData(List<Book> listOfBooks) {
        try (java.io.FileWriter fileWriter = new java.io.FileWriter("D:\\Dokumenty_daria\\SDA_kurs\\programowanieII\\src\\main\\resources\\books123.csv")) {
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