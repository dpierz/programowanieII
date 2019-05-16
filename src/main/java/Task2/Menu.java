package Task2;

import java.io.IOException;
import java.util.List;
import java.util.Scanner;

public class Menu {
    static Scanner scanner = new Scanner(System.in);

    private static void loadingFile(){
        FileLoader loader = new FileLoader();
        try {
            List<Book> books = loader.readBooksFile();//załądowanie pliku
        } catch (IOException e) {
            e.printStackTrace();
        }
    }

    public static void main(String[] args) throws IOException {
        FileLoader loader = new FileLoader();
        List<Book> books = loader.readBooksFile();//załądowanie pliku

        boolean a = true;
        while (a) {
            printingFileMenu();
            int userChoice = getUsersChoice();
            while (userChoice < 0 || userChoice > 6) {
                printingInfoError();
                printingFileMenu();
                userChoice = getUsersChoice();
            }

            switch (userChoice) {
                case 1:
                    System.out.println("Wybrałeś: Wyświetlenie listy książek.");
                    for (Book book : books) {
                        System.out.println(book.getTitle() + " " + book.getYearOfPublished() + " " + book.getNumberIsbn());
                    }
                    //loader.readAuthorsFile();
                    //loader.readCategoriesFile();
                    break;
                case 2:
                    System.out.println("Wybrałeś: Dodanie nowej książki.");
                    System.out.println("Podaj tytuł książki");
                    String title = scanner.nextLine();
                    System.out.println("Podaj datę wydania");
                    int year = Integer.parseInt(scanner.nextLine());
                    System.out.println("Podaj numer ISBN");
                    long isbn = Long.parseLong(scanner.nextLine());
                    Book book = new Book(title, isbn, year);
                    books.add(book); //todo nie zapisują sie ksiązki, gdzie jez apisacx na stałe
                    break;

                case 3:
                    System.out.println("Wybrałeś: Usunięcie książki po nazwie.");
                    System.out.println("Podaj tytuł książki, którą chcesz usunąć");
                    String titleToRemove = scanner.nextLine().toLowerCase();
                    books.remove(books.indexOf(titleToRemove));//todo pętla contains może być book.get equals
                    for (Book book1 : books) {
                        if (book1.getTitle().toLowerCase().contains(titleToRemove)){
                            boolean remove = books.remove(book1);
                        }
                    }
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
            printingInfoAnotherChoiceMenu();// TODO: 12.05.2019
        }
    }

    private static int getUsersChoice() {
        return Integer.parseInt(scanner.nextLine());
    }

    private static void printingFileMenu() {
        System.out.println("Wpisz:\n " +
                "1 - aby wyświetlić listę książek\n " +
                "2 - aby dodać nową książkę \n " +
                "3 - aby usunąć książki po nazwie \n " +
                "4 - aby edytować roku wydania książki \n " +
                "5 - aby zapisać listę książek do pliku csv \n " +
                "6 - aby wyjść z aplikacji \n "
        );
    }

    private static void printingInfoError() {
        System.out.println("Wybrałeś/aś nieprawidłową wartość.");
    }

    private static void printingInfoAnotherChoiceMenu() {
        System.out.println("Jeżeli chcesz zmienić wybór skorzystaj z poniższego menu.");
    }
}