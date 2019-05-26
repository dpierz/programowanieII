package task2;

import java.util.List;

public class YearTitleIsbnBookPrintStrategy implements BookPrintStrategy {
    @Override
    public void print(List<Book> bookList) {
        for (Book book : bookList) {
            System.out.println
                    (book.getYearOfPublication() + " " +
                            book.getTitle() + " " +
                            book.getNumberIsbn());
        }
    }
}
