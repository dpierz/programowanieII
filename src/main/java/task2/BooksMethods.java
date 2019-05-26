package task2;

import java.io.IOException;
import java.util.ArrayList;
import java.util.List;
import java.util.Scanner;

public class BooksMethods {
    static Scanner scanner = new Scanner(System.in);
    BooksFilesLoader loader = new BooksFilesLoader();
    List<Book> listOfBooks = new ArrayList<>();//załadowanie pliku
    static FileWriter booksFileWriter = new FileWriter();
    DisplayFormat displayFormat = new DisplayFormat();

    {
        try {
            listOfBooks = loader.readBooksFile();
        } catch (IOException e) {
            System.out.println("Nie udało się załadować książek z pliku");
            throw new IllegalStateException(e.getMessage()); //wywalenie programu
        }
    }

    void displayListOfBooks(List<Book> listOfBooks) {
        System.out.println("Wybrałeś: Wyświetlenie listy książek.");
        System.out.println(listOfBooks);
    }

    void addBook() {
        System.out.println("Wybrałeś: Dodanie nowej książki. \n" + "Podaj tytuł książki, którą chcesz dodać:");
        String title = scanner.nextLine(); //defi
        System.out.println("Podaj datę wydania");
        int year = Integer.parseInt(scanner.nextLine());
        System.out.println("Podaj numer ISBN");
        long isbn = Long.parseLong(scanner.nextLine());
        listOfBooks.add(new Book(title, isbn, year, null, null));
    }

    void removeBookByTitle() {
        System.out.println(
                "Wybrałeś: Usunięcie książki po nazwie. \n" + "Podaj tytuł książki, którą chcesz usunąć:");
        String title = scanner.nextLine();
        for (Book book : listOfBooks) {
            if(book.getTitle().equals(title)) {
                listOfBooks.remove(book);
                System.out.println("Książka " + title + " została usunięta.");
                return;
            }
        }
        printInfoError();
    }

    void editYearOfPublication() {
        System.out.println(
                "Wybrałeś: Edytowanie roku wydania książki. \n" + "Podaj tytuł książki, której rok wydania chcesz edytować:");
        String title = scanner.nextLine();
        System.out.println("Podaj prawidłowy rok wydania, dla książki " + title + ".");
        int year = Integer.parseInt(scanner.nextLine());
        for (Book book : listOfBooks) {
            if(book.getTitle().equals(title)) {
                book.setYearOfPublication(year);
                System.out.println("Rok wydania książki " + title + " został zmieniony na rok: " + year + ".");
                return;
            }
        }
        printInfoError();
    }

    void saveToCsv() {
        System.out.println("Wybrałeś: Zapisanie listy książek do pliku csv.");
        booksFileWriter.saveData(listOfBooks);
    }

    void exitApp() {
        System.out.println("Wybrałeś: Koniec działania aplikacji.");
    }

    void printInfoError() {
        System.out.println("Wybrałeś/aś nieprawidłową wartość. Spróbuj jeszcze raz.");
    }

    void printInfoAnotherChoiceMenu() {
        System.out.println("Jeżeli chcesz zmienić wybór skorzystaj z poniższego menu.");
    }
}
