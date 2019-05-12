package Task2;

import java.io.*;
import java.util.ArrayList;
import java.util.List;

public class FileLoader {

    public void readBooksFile() throws IOException {
        List<Book> bookList = new ArrayList<>();
        FileReader fileReader = new FileReader("D:\\Dokumenty_daria\\SDA_kurs\\programowanieII\\src\\main\\resources\\books.csv");
        BufferedReader bufferedReader = new BufferedReader(fileReader);

        try {
            String textLine = bufferedReader.readLine();
            do {
                String[] split = textLine.split(";");
                String title = split[0];
                String yearOfPublished = split[2]; // TODO: 12.05.2019 powinien być integer
                String numberIsbn = split[1];
//                System.out.println(textLine);
                Book book = new Book();
                bookList.add(book);
                textLine = bufferedReader.readLine();
            } while (textLine != null);
        } finally {
            bufferedReader.close();
        }
        System.out.println(bookList);
    }

    public void readAuthorsFile() throws IOException {
        FileReader fileReader = new FileReader("D:\\Dokumenty_daria\\SDA_kurs\\programowanieII\\src\\main\\resources\\authors.csv");
        BufferedReader bufferedReader = new BufferedReader(fileReader);

        try {
            String textLine = bufferedReader.readLine();
            do {
                System.out.println(textLine);
                textLine = bufferedReader.readLine();
            } while (textLine != null);
        } finally {
            bufferedReader.close();
        }
    }

    public void readCategoriesFile() throws IOException {
        FileReader fileReader = new FileReader("D:\\Dokumenty_daria\\SDA_kurs\\programowanieII\\src\\main\\resources\\categories.csv");
        BufferedReader bufferedReader = new BufferedReader(fileReader);

        try {
            String textLine = bufferedReader.readLine();
            do {
                System.out.println(textLine);
                textLine = bufferedReader.readLine();
            } while (textLine != null);
        } finally {
            bufferedReader.close();
        }
    }
}
