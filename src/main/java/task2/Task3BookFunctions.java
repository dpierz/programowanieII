package task2;

import java.util.*;
import java.util.stream.Collectors;

public class Task3BookFunctions {
    BookComparator bookComparator = new BookComparator();

    //1 Znajdź książkę o podanym ISBN. Metoda przyjmuje 2 parametry (isbn, lista wszystkich książek) i zwraca podaną książkę.
    //1 Loop
    public Book isbnFinderLoop(long numberIsbn, List<Book> listOfBooks) {
        for (Book book : listOfBooks) {
            if(book.getNumberIsbn() == numberIsbn) {
                return book;
            }
        }
        return null;
    }

    //1 Stream
    public Optional<Book> isbnFinderStream(long numberIsbn, List<Book> listOfBooks) {
        return listOfBooks.stream().filter(book -> book.getNumberIsbn() == numberIsbn).findFirst(); //porównuje cos z czymś i zwraca booleana
    }

    //2 Zwróć dwie ostatnie książki.
    //2 Loop
    public List<Book> lastTwoBookFinderLoop(List<Book> listOfBooks) {
        return listOfBooks.subList(listOfBooks.size() - 2, listOfBooks.size());
    }

    //2 Stream
    public List<Book> lastTwoBookFinderStream(List<Book> listOfBooks) {
        return listOfBooks.stream().skip(listOfBooks.size() - 2).collect(Collectors.toList());
    }

    //3 Zwróć najwcześniej wydana książkę.
    //3 Loop
    public Book theOldestBookFinderLoop(List<Book> listOfBooks) {
        Book min = listOfBooks.get(0);
        for (Book listOfBook : listOfBooks) {
            if(listOfBook.getYearOfPublication() < min.getYearOfPublication()) {
                min = listOfBook;
            }
        }
        return min;
    }

    //3 Stream
    public Optional<Book> theOldestBookFinderStream(List<Book> listOfBooks) {
        //return listOfBooks.stream()
        //        .min(Comparator.comparingInt(Book::getYearOfPublication));
        return listOfBooks.stream()
                .min(bookComparator);
    }

    //4 Zwróć najpóźniej wydana książkę.
    //4 Loop
    public Book theYoungestBookFinderLoop(List<Book> listOfBooks) {
        Book youngestBook = listOfBooks.get(0);
        for (Book listOfBook : listOfBooks) {
            if(listOfBook.getYearOfPublication() > youngestBook.getYearOfPublication()) {
                youngestBook = listOfBook;
            }
        }
        return youngestBook;
    }

    //4 Stream
    public Optional<Book> theYoungestBookFinderStream(List<Book> listOfBooks) {
        return listOfBooks.stream()
                .max(bookComparator);
    }

    //5 Zwróć sumę lat wydania wszystkich książek.
    //5 Loop
    public int sumOfYearForAllBooksLoop(List<Book> listOfBooks) {
        int sum = 0;
        for (Book book : listOfBooks) {
            sum += book.getYearOfPublication();
        }
        return sum;
    }

    //5 Stream
    public int sumOfYearForAllBooksStream(List<Book> listOfBooks) {
        int sum = listOfBooks.stream().mapToInt(book -> book.getYearOfPublication()).sum(); //W komentarzu masz "mapa która zmapuje coś na coś" To nie jest mapa, piszę to tylko po to, żebyś dokładnie widziała różnicę między Mapą w javie (klucz, wartość) a metodą map na streamie. Map to po prostu funkcja, która zamienia jedno na drugie.
        return sum;
    }

    //public int sumOfYearForAllBooksStream(List<Book> listOfBooks) {
    //        if (listOfBooks.isEmpty()) {
    //            throw new RuntimeException("dsadsad");
    //        }
    //        int sum = listOfBooks.stream().mapToInt(book -> book.getYearOfPublication()).sum(); //mapa która zmapuje coś na coś
    //        return sum;
    //    }//todo pusta z wyjątkiem, albo zwracając zero

    //6 Zwróć liczbę książek wydanych po 2007 roku.
    //6 Loop
    public int countAmountOfBooksAfter2007Loop(List<Book> listOfBooks) {
        int counter = 0;
        for (Book book : listOfBooks) {
            if(book.getYearOfPublication() > 2007) {
                counter++;
            }
        }
        return counter;
    }

    //6 Stream
    public int countAmountOfBooksAfter2007Stream(List<Book> listOfBooks) {
        return (int) listOfBooks.stream().filter(book -> book.getYearOfPublication() > 2007).count();
    }

    // 7 Zwróć informacje o tym czy wszystkie książki w naszym katalogu są wydane po 2000 roku.
    // 7 Loop
    public boolean isEveryBookPublishedAfter2000Loop(List<Book> listOfBooks) {
        ArrayList<Book> list = new ArrayList<>();
        for (Book book : listOfBooks) {
            if(book.getYearOfPublication() < 2000) {
                return false;
            }
        }
        return true;
    }

    //7 Stream
    public boolean isEveryBookPublishedAfter2000Stream(List<Book> listOfBooks) {
        return listOfBooks.stream().allMatch(book -> book.getYearOfPublication() > 2000);
    }

    //8 Zwróć średni rok wydania książki w naszym katalogu.
    //8 Loop
    public double avarageOfBooksYears(List<Book> listOfBooks) {
        double sum = 0;
        double average = 0;
        for (Book book : listOfBooks) {
            sum += book.getYearOfPublication();
            average = sum / listOfBooks.size();
        }
        return average;
    }

    //8 Stream
    public OptionalDouble avarageOfBooksYearsStream(List<Book> listOfBooks) {
        return listOfBooks.stream().mapToDouble(book -> book.getYearOfPublication()).average(); //todo dlaczego nie może być po prostu double i dlaczego przy samym doublu nie działą tylko musi być optional
    }

    //9 Zwróć informacje o tym czy jakakolwiek książka w naszym katalogu jest wydana przed  2003 rokiem.
    //9 Loop
    public boolean isAnyBookPublishedBefore2003Loop(List<Book> listOfBooks) {
        boolean isAnyBefore2003 = false;
        for (Book book : listOfBooks) {
            if(book.getYearOfPublication() < 2003) {
                return true;
            }
        }
        return false;
    }

    //9 Stream
    public boolean isAnyBookPublishedBefore2003Stream(List<Book> listOfBooks) {
        return listOfBooks.stream().anyMatch(book -> book.getYearOfPublication() < 2003);
    }

    //10 Zwróć wszystkie książki, których tytuł zaczyna się od litery “C” i były one wydane po 2007 roku.
    //10 Loop
    public List<Book> returnAllBooksOnCLetterAndPublishedAfter2007Loop(List<Book> listOfBooks) {
        ArrayList<Book> list = new ArrayList<>();
        for (Book book : listOfBooks) {
            if(book.getTitle().startsWith("C") && book.getYearOfPublication() > 2007) {
                list.add(book);
            }
        }
        return list;
    }

    //10 Stream
    public List<Book> returnAllBooksOnCLetterAndPublishedAfter2007Stream(List<Book> listOfBooks) {
        return listOfBooks.stream().filter(book -> book.getTitle().startsWith("C"))
                .filter(book -> book.getYearOfPublication() > 2007)
                .collect(Collectors.toList());
    }

    //11 Zwróć tytuły wszystkich książek, których rok jest podzielny przez 2.
    //11 Loop
    public List<Book> isDivisibleBy2Loop(List<Book> listOfBooks) {
        List<Book> list = new ArrayList<>();
        for (Book book : listOfBooks) {
            if(book.getYearOfPublication() % 2 == 0) {
                list.add(book);
            }
        }
        return list;
    }

    //11 Stream
    public List<Book> isDivisibleBy2Stream(List<Book> listOfBooks) {
        return listOfBooks.stream().filter(book -> book.getYearOfPublication() % 2 == 0).collect(Collectors.toList());
    }

    //12 Zwróć mapę, która będzie miała klucz isbn i wartość obiekt Book (Map<String, Book>).
    //12 Loop
    public Map<String, Book> mapOfIsbnAndBookLoop(List<Book> listOfBooks) {
        Map<String, Book> map = new HashMap<>();
        for (Book book : listOfBooks) {
            map.put(String.valueOf(book.getNumberIsbn()), book);
        }
        return map;
    }

    //12 Stream
    public Map<String, Book> mapOfIsbnAndBookStream(List<Book> listOfBooks) {
        return listOfBooks.stream().collect(Collectors.toMap(book -> String.valueOf(book.getNumberIsbn()), book1 -> book1));
    }

    //13 Posortuj książki po roku wydania zaczynając od wydanej najpóźniej.
    //13 Loop
    public List<Book> sortBooksFromTheYoungestLoop(List<Book> listOfBooks) {
        List<Book> books = new ArrayList<>(listOfBooks);
        books.sort(new BookComparator().reversed()); //powinno byc tak jak teraz, bo List.sort nie działa
        return books;
    }
//13 Stream
    public List<Book> sortBooksFromTheYoungestStream(List<Book> listOfBooks) {
        return listOfBooks.stream().sorted(bookComparator.reversed()).collect(Collectors.toList());
    }

    //14 Posortuj książki po roku wydania zaczynając od wydanej najwcześniej.
    //14 Loop
    public List<Book> sortBooksFromTheOldestLoop(List<Book> listOfBooks) {
        ArrayList<Book> books = new ArrayList<>(listOfBooks);
        Collections.sort(books, new BookComparator());
        return books;
    }

    //14 Stream
    public List<Book> sortBooksFromTheOldestStream(List<Book> listOfBooks) {
        return listOfBooks.stream().sorted(bookComparator).collect(Collectors.toList());
    }

    //15 Podziel listę książek na 3 listy po 2 książki i zwróć z metody. (*) (bez streama)
    public Map<String, List<Book>> splitList(List<Book> listsOfBooks) {

        int sizeList = listsOfBooks.size();
        List<Book> list1 = new ArrayList<>(listsOfBooks.subList(0,(sizeList/3)));
        List<Book> list2 = new ArrayList<>(listsOfBooks.subList((sizeList/3),((sizeList/3)+2)));
        List<Book> list3 = new ArrayList<>(listsOfBooks.subList(((sizeList/3)+2), sizeList));

        Map<String, List<Book>> mapOfLists= new HashMap<>();
        mapOfLists.put("list1", list1);
        mapOfLists.put("list2", list2);
        mapOfLists.put("list3", list3);
        return mapOfLists;
    }
}
