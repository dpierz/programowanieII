package Task2;

import java.io.*;
import java.util.ArrayList;
import java.util.List;

public class BooksFileLoader {

    public List<Book> readBooksFile() throws IOException {
        List<Book> listOfBooks = new ArrayList<>();
        FileReader fileReader = new FileReader("D:\\Dokumenty_daria\\SDA_kurs\\programowanieII\\src\\main\\resources\\booksStart.csv");
        BufferedReader bufferedReader = new BufferedReader(fileReader);

        try {
            String textLine = bufferedReader.readLine();
            do {
                String[] split = textLine.split(";");
                String title = split[0];
                int yearOfPublished = Integer.parseInt(split[2]);
                long numberIsbn = Long.parseLong(split[1]);
//                System.out.println(textLine);
                //3,4
                //list autorow
                //list autorow -> 3,4 --- > 2 autorow

                Book book = new Book(title, numberIsbn, yearOfPublished);
                listOfBooks.add(book);
                textLine = bufferedReader.readLine();
            } while (textLine != null);
        } finally {
            bufferedReader.close();
        }

        return listOfBooks;
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
