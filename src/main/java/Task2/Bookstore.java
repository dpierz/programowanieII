package Task2;

//1Tworzymy projekt Mavenowy, kod umieszczamy na dowolnym repozytorium git (github, gitlab, bitbucket).
//2Wykonujemy pierwszy commit w celu sprawdzenia repozytorium
//3Pierwszym krokiem jest stworzenie konsolowego menu aplikacji.
// Na początek menu powinno zawierać opcje wyświetlenia listy książek, która póki co będzie pusta oraz wyjścia z programu.


import java.util.Scanner;

public class Bookstore {
    public static void main(String[] args) {
        Scanner scanner = new Scanner(System.in);

        plikMenu();

        int userChoice = Integer.parseInt(scanner.nextLine());

        while (userChoice < 0 && userChoice > 6) {
            userChoice = Integer.parseInt(scanner.nextLine());
        }

//        while (userChoice != 2) {
//            switch (userChoice) {
//                case 1:
//                    System.out.println("Wybrałeś: Wyświetlenie listy książek");
//                    break;
//                case 2:
//                    break;
//                case 3:
//                    System.out.println("Wybrałeś: Dodanie nowej książki");
//                    break;
//                case 4:
//                    System.out.println("Wybrałeś: Usunięcie książki po nazwie");
//                    break;
//                case 5:
//                    System.out.println("Wybrałeś: Edytowanie roku wydania książki");
//                    break;
//                case 6:
//                    System.out.println("Wybrałeś: Zapisanie listy książek do pliku csv");
//                    break;
//            }

        boolean a = true;
        while (a) {
            switch (userChoice) {
                case 1:
                    System.out.println("Wybrałeś: Wyświetlenie listy książek");
                    break;
                case 2:
                    a = false;
                    System.out.println("Wybrałeś: Koniec działania aplikacji");
                    break;
                case 3:
                    System.out.println("Wybrałeś: Dodanie nowej książki");
                    break;
                case 4:
                    System.out.println("Wybrałeś: Usunięcie książki po nazwie");
                    break;
                case 5:
                    System.out.println("Wybrałeś: Edytowanie roku wydania książki");
                    break;
                case 6:
                    System.out.println("Wybrałeś: Zapisanie listy książek do pliku csv");
                    break;
            }
            if (a) {
                plikMenu();
                userChoice = Integer.parseInt(scanner.nextLine());
            }

        }
    }


    private static void plikMenu() {
        System.out.println("Wpisz:\n " +
                "1 - aby wyświetlić listę książek\n " +
                "2 - aby wyjść z aplikacji \n " +
                "3 - aby dodać nową książkę \n " +
                "4 - aby usunąć książki po nazwie \n " +
                "5 - aby edytować roku wydania książki \n " +
                "6 - aby zapisać listę książek do pliku csv \n "
        );
    }
}