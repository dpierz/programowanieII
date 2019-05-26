package task2;

import java.util.List;

public class TitleYearIsbnBookPrintStrategy implements BookPrintStrategy{

    @Override
    public void print(List<Book> bookList) {
        for (Book book : bookList) {
            System.out.println
                    (book.getTitle() + " " +
                            book.getYearOfPublication() + " " +
                            book.getNumberIsbn());
        }
    }
}
