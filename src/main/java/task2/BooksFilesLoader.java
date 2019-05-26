package task2;

import java.io.*;
import java.util.ArrayList;
import java.util.List;

public class BooksFilesLoader {

    public List<Book> readBooksFile() throws IOException {
        List<Book> listOfBooks = new ArrayList<>();
        FileReader BookFileReader = new FileReader("D:\\Dokumenty_daria\\SDA_kurs\\programowanieII\\src\\main\\resources\\books.csv");
        BufferedReader booksBufferedReader = new BufferedReader(BookFileReader);


        try {
            String textLine = booksBufferedReader.readLine();
            AuthorsFilesLoader authorsLoader = new AuthorsFilesLoader();
            CategoriesFilesLoader categoriesLoader = new CategoriesFilesLoader();
            List<Author> listOfAuthors = new ArrayList<>();
            listOfAuthors = getAuthorsFromFile(authorsLoader);
            List<Category> listOfCategories = new ArrayList<>();//załadowanie pliku
            listOfCategories = getCategories(categoriesLoader);

            do {
                String[] splittedLineFromBooksFile = textLine.split(";");
                String title = splittedLineFromBooksFile[1];
                int yearOfPublished = Integer.parseInt(splittedLineFromBooksFile[3]);
                long numberIsbn = Long.parseLong(splittedLineFromBooksFile[2]);
                String authorsId= splittedLineFromBooksFile[5];
                final List<Author> authorsIdFilter = getAuthorsForBook(authorsId, listOfAuthors);


                int categoryId = Integer.parseInt(splittedLineFromBooksFile[6]);
                final Category categoryIdFilter = listOfCategories.stream().filter(category -> category.getId() == categoryId).findFirst().get();
                Book book = new Book(title, numberIsbn, yearOfPublished, authorsIdFilter, categoryIdFilter);
                listOfBooks.add(book);
                textLine = booksBufferedReader.readLine();
            } while (textLine != null);
        } finally {
            booksBufferedReader.close();
        }
        return listOfBooks;
    }

    private List<Author> getAuthorsForBook(String authorsId, List<Author> listOfAuthors) {
        List<Author> bookAuthors = new ArrayList<>();
        final String[] split = authorsId.split(",");
        for (String authorId : split) {
            final Author author1 = listOfAuthors.stream().filter(author -> author.getAuthorsId() == Integer.parseInt(authorId)).findFirst().get();
            bookAuthors.add(author1);
        }

        return bookAuthors;
    }

    private List<Author> getAuthorsFromFile(AuthorsFilesLoader authorsLoader) { // todo nie rozumiem tego w sesnie w łądowaniu pliku
        List<Author> listOfAuthors;
        try {
            listOfAuthors = authorsLoader.readAuthorsFile();
        } catch (IOException e) {
            System.out.println("Nie udało się załadować kategorii z pliku");
            throw new IllegalStateException(e.getMessage()); //wywalenie programu
        }
        return listOfAuthors;
    }

    private List<Category> getCategories(CategoriesFilesLoader categoriesLoader) {
        List<Category> listOfCategories;
        try {
            listOfCategories = categoriesLoader.readCategoriesFile();
        } catch (IOException e) {
            System.out.println("Nie udało się załadować kategorii z pliku");
            throw new IllegalStateException(e.getMessage()); //wywalenie programu
        }
        return listOfCategories;
    }

}
