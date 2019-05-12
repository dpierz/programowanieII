package Task2;

import java.io.IOException;
import java.util.Scanner;

public class Bookstore {
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
                    loader.readAuthorsFile();
                    loader.readCategoriesFile();
                    break;
                case 2:
                    a = false;
                    System.out.println("Wybrałeś: Koniec działania aplikacji.");
                    break;
                case 3:
                    System.out.println("Wybrałeś: Dodanie nowej książki.");
                    break;
                case 4:
                    System.out.println("Wybrałeś: Usunięcie książki po nazwie.");
                    break;
                case 5:
                    System.out.println("Wybrałeś: Edytowanie roku wydania książki.");
                    break;
                case 6:
                    System.out.println("Wybrałeś: Zapisanie listy książek do pliku csv.");
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
                "2 - aby wyjść z aplikacji \n " +
                "3 - aby dodać nową książkę \n " +
                "4 - aby usunąć książki po nazwie \n " +
                "5 - aby edytować roku wydania książki \n " +
                "6 - aby zapisać listę książek do pliku csv \n "
        );
    }

    private static void infoError() {
        System.out.println("Wybrałeś/aś nieprawidłową wartość.");
    }

    private static void infoAnotherChoiceMenu() {
        System.out.println("Jeżeli chcesz zmienić wybór skorzystaj z poniższego menu.");
    }
}