package task2;

import java.util.ArrayList;
import java.util.List;
import java.util.stream.Collectors;

public class DisplayFormat {

    void standardFormat(List<Book> listOfBooks){
        for (Book book : listOfBooks) {            final List<Author> authors = book.getAuthors();
            final String collect = authors.stream().map(author -> String.valueOf(author.getAuthorsId())).collect(Collectors.joining(", "));
            System.out.println(book.getTitle() + " " + book.getYearOfPublication() + " " + book.getNumberIsbn()+ " " + collect
                    + " " + book.getCategory());
        }
    }
    void formatTitleYearIsbn(List<Book> listOfBooks){
        for (Book book : listOfBooks) {
            System.out.println(book.getTitle()+ " " + book.getYearOfPublication() + " " + book.getNumberIsbn());
        };
    }

    void formatYearTitleIsbn(List<Book> listOfBooks){
        for (Book book : listOfBooks) {
            System.out.println(book.getYearOfPublication() + " " + book.getTitle() + " " + book.getNumberIsbn());
        };
    }

    void formatIsbnYeartitle(List<Book> listOfBooks){
        for (Book book : listOfBooks) {
            System.out.println(+ book.getNumberIsbn()+ " "+ book.getYearOfPublication() + " " + book.getTitle());
        };
    }
}
