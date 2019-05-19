package task2;

import org.apache.commons.lang3.StringUtils;

import java.util.Scanner;

public class Menu {
    static Scanner scanner = new Scanner(System.in);
    BooksMethods booksMethods = new BooksMethods();

    void menuApp() {
        boolean startMenu = true;
        while (startMenu) {
            printBookstoreMenu();
            int usersChoice = getUsersChoice();
            switch (usersChoice) {
                case 1:
                    booksMethods.displayListOfBooks();
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
                "6 - aby wyjść z aplikacji \n "
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
//        if(!numeric) {
//            menuApp(); //TODO rekurencja
//        }
        return Integer.parseInt(s);
    }
}