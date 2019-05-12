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

        while (userChoice != 1 && userChoice != 2) {
            userChoice = Integer.parseInt(scanner.nextLine());
        }

        while (userChoice != 2) {
            switch (userChoice) {
                case 1:
                    System.out.println("Wyświetlenie listy książek");
                    break;
                case 2:
                    break;
            }
            plikMenu();
            userChoice = Integer.parseInt(scanner.nextLine());
        }
        System.out.println("Koniec działania aplikacji");

    }

    private static void plikMenu() {
        System.out.println("Wpisz:\n " +
                "1 - aby wyświetlić listę książek\n " +
                "2 - aby wyjść z aplikacji");
    }
}