package task2;

import org.apache.commons.lang3.StringUtils;

import java.util.List;
import java.util.Scanner;

public class Menu {
    static Scanner scanner = new Scanner(System.in);
    BooksMethods booksMethods = new BooksMethods();
    Task3BookFunctions task3BookFunctions = new Task3BookFunctions();
    AuthorsMethod authorsMethod = new AuthorsMethod();
    CategoriesMethod categoriesMethod = new CategoriesMethod();
    DisplayFormat displayFormat = new DisplayFormat();
    BookPrintStrategy bookPrintStrategy = new TitleYearIsbnBookPrintStrategy();

    void menuApp() {
        boolean startMenu = true;
        while (startMenu) {
            printBookstoreMenu();
            int usersChoice = getUsersChoice();
            switch (usersChoice) {
                case 1:
                    bookPrintStrategy.print(booksMethods.listOfBooks);
                    break;
                case 2:
                    booksMethods.addBook();
                    break;
                case 3:
                    booksMethods.removeBookByTitle();
                    break;
                case 4:
                    booksMethods.editYearOfPublication();
                    break;
                case 5:
                    booksMethods.saveToCsv();
                    break;
                case 6:
                    final List<Book> booksFromTheOldest = task3BookFunctions.sortBooksFromTheOldestStream(booksMethods.listOfBooks);
                    bookPrintStrategy.print(booksFromTheOldest);
                    break;
                case 7:
                    final List<Book> booksFromTheYoungest = task3BookFunctions.sortBooksFromTheYoungestStream(booksMethods.listOfBooks);
                    bookPrintStrategy.print(booksFromTheYoungest);
                    break;
                case 8:
                    final List<Book> booksAfter2007 = task3BookFunctions.returnAllBooksOnCLetterAndPublishedAfter2007Stream(booksMethods.listOfBooks);
                    bookPrintStrategy.print(booksAfter2007);
                    break;
                case 9:
                    categoriesMethod.displayListOfCategories();
                    break;
                case 10:
                    authorsMethod.displayListOfAuthors();
                    break;
                case 11:
                    bookPrintStrategy = new TitleYearIsbnBookPrintStrategy();
                    System.out.println("Wybrano format tytul, rok, isbn");
                    break;
                case 12:
                    bookPrintStrategy = new YearTitleIsbnBookPrintStrategy();
                    System.out.println("Wybrano format rok, tytul, isbn");
                    break;
                case 13:
                    bookPrintStrategy = new IsbnYearTitleBookPrintStrategy();
                    System.out.println("Wybrano format isbn, rok, tytul");
                    break;
                case 14:
                    startMenu = false;
                    booksMethods.exitApp();
                    break;
                default:
                    printBookstoreMenu();

            }
            if(startMenu) {
                booksMethods.printInfoAnotherChoiceMenu();
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
                "6 - aby posortować książki po roku wydania rosnąco \n " +
                "7 - aby posortować książki po roku wydania malejąco \n " +
                "8 - aby wyświetlić liczbę książek wydanych po 2007 roku \n " +
                "9 - aby wyświetlić listę kategorii \n " +
                "10 - aby wyświetlić listę autorów \n " +
                "11 - aby wyświetlić w formacie tytuł, rok, isbn \n " +
                "12 - aby wyświetlić w formacie rok, tytuł, isbn \n " +
                "13 - aby wyświetlić w formacie isbn, rok, tytuł \n " +
                "14 - aby wyjść z aplikacji \n "
        );
    }

    int getUsersChoice() {
        String s = scanner.nextLine().trim();
        boolean numeric = StringUtils.isNumeric(s);
        while (!numeric) {
            System.out.println("Podałeś nieprawidłowy typ danych, wpisz wartość zgodnie z menu:");
            printBookstoreMenu();
            s = scanner.nextLine().trim();
            numeric = StringUtils.isNumeric(s);
        }
        return Integer.parseInt(s);
    }
}