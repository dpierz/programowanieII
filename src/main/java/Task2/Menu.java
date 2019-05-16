package Task2;

import java.io.IOException;
import java.util.ArrayList;
import java.util.List;
import java.util.Scanner;

public class Menu {
    static Scanner scanner = new Scanner(System.in);
    BooksFileLoader loader = new BooksFileLoader();
    List<Book> listOfBooks = new ArrayList<>();//załadowanie pliku
    String title;
    static BooksFileWriter booksFileWriter = new BooksFileWriter();

    {
        try {
            listOfBooks = loader.readBooksFile();
        } catch (IOException e) {
            e.printStackTrace();
        }
    }

    void menuApp() {
        printBookstoreMenu();
        boolean startMenu = true;
        while (startMenu) {
            int usersChoice = getUsersChoice();
            switch (usersChoice) {
                case 1:
                    displayListOfBooks();
                    break;
                case 2:
                    addBook();
                    break;
                case 3:
                    removeBookByTitle();
                    break;
                case 4:
                    editYearOfPublication();
                    break;
                case 5:
                    saveToCsv();
                    break;
                case 6:
                    startMenu = false; //todo przez if'a nie kończy działania aplikacji
                    exitApp();
                    break;
                default:
                    printInfoError();
            }
            if(startMenu) { //todo dlaczego while nie działa i dodaje do case 6 kolejny wybór
                System.out.println();
                printInfoAnotherChoiceMenu();
                menuApp();
            }
        }
    }

    void printBookstoreMenu() {
        System.out.println("Wpisz:\n " +
                "1 - aby wyświetlić listę książek \n " +
                "2 - aby dodać nową książkę \n " +
                "3 - aby usunąć książki po nazwie \n " +
                "4 - aby edytować rok wydania książki \n " +
                "5 - aby zapisać listę książek do pliku csv \n " +
                "6 - aby wyjść z aplikacji \n "
        );
    }

    int getUsersChoice() {
        return Integer.parseInt(scanner.nextLine());
    }

    void displayListOfBooks() {
        System.out.println("Wybrałeś: Wyświetlenie listy książek.");
        for (Book book : listOfBooks) {
            System.out.println(book.getTitle() + " " + book.getYearOfPublication() + " " + book.getNumberIsbn());
        }
    }

    void addBook() {
        System.out.println("Wybrałeś: Dodanie nowej książki. \n" + "Podaj tytuł książki, którą chcesz dodać:");
        title = scanner.nextLine();
        System.out.println("Podaj datę wydania");
        int year = Integer.parseInt(scanner.nextLine());
        System.out.println("Podaj numer ISBN");
        long isbn = Long.parseLong(scanner.nextLine());
        listOfBooks.add(new Book(title, isbn, year));
    }

    void removeBookByTitle() {
        System.out.println(
                "Wybrałeś: Usunięcie książki po nazwie. \n" + "Podaj tytuł książki, którą chcesz usunąć:");
        title = scanner.nextLine();
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