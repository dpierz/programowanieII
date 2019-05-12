package Task2;

import java.io.IOException;
import java.util.Scanner;

public class Menu {
    static Scanner scanner = new Scanner(System.in);

    public static void main(String[] args) throws IOException {

        boolean a = true;
        while (a) {
            fileMenu();
            int userChoice = getUserChoice();
            while (userChoice < 0 || userChoice > 6) {
                infoError();
                fileMenu();
                userChoice = getUserChoice();
            }

            switch (userChoice) {
                case 1:
                    System.out.println("Wybrałeś: Wyświetlenie listy książek.");
                    FileLoader loader = new FileLoader();
                    loader.readBooksFile();
                    //loader.readAuthorsFile();
                    //loader.readCategoriesFile();
                    break;
                case 2:
                System.out.println("Wybrałeś: Dodanie nowej książki.");
                    Book book = new Book();
                    System.out.println("Podaj tytuł książki");
                    book.setTitle(scanner.nextLine());
                    System.out.println("Podaj datę wydania");
                    book.setYearOfPublished(scanner.nextLine());
                    System.out.println("Podaj numer ISBN");
                    book.setNumberIsbn(scanner.nextLine());
                break;
                case 3:
                System.out.println("Wybrałeś: Usunięcie książki po nazwie.");
                System.out.println("Podaj nazwę książki, którą chcesz usunąć");
                break;
                case 4:
                System.out.println("Wybrałeś: Edytowanie roku wydania książki.");
                    System.out.println("Podaj tytuł książki");
                   // String title = book.getTitle(scanner.nextLine());

                    break;
                case 5:
                System.out.println("Wybrałeś: Zapisanie listy książek do pliku csv.");
                break;
                case 6:
                    a = false;
                    System.out.println("Wybrałeś: Koniec działania aplikacji.");
                    break;
            }
            System.out.println();
            infoAnotherChoiceMenu();// TODO: 12.05.2019
        }
    }

    private static int getUserChoice() {
        return Integer.parseInt(scanner.nextLine());
    }

    private static void fileMenu() {
        System.out.println("Wpisz:\n " +
                "1 - aby wyświetlić listę książek\n " +
                "2 - aby dodać nową książkę \n " +
                "3 - aby usunąć książki po nazwie \n " +
                "4 - aby edytować roku wydania książki \n " +
                "5 - aby zapisać listę książek do pliku csv \n "+
                "6 - aby wyjść z aplikacji \n "
        );
    }

    private static void infoError() {
        System.out.println("Wybrałeś/aś nieprawidłową wartość.");
    }

    private static void infoAnotherChoiceMenu() {
        System.out.println("Jeżeli chcesz zmienić wybór skorzystaj z poniższego menu.");
    }
}