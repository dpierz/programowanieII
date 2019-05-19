//import org.junit.Assert;

import org.assertj.core.api.Assertions;
import org.junit.Assert;
import org.junit.Before;
import org.junit.Test;
import task2.Book;
import task2.Task3BookFunctions;

import java.util.*;

public class Task3BookFunctionsTest {
    Task3BookFunctions bookFunctions = new Task3BookFunctions();
    List<Book> books = new ArrayList<>();
    ArrayList<Book> emptyList = new ArrayList<>();

    @Before
    public void init() {
        books = new ArrayList<>();
        books.add(new Book("Clean Code", 132350882, 2008));
        books.add(new Book("Effective Java (3rd Edition)", 134685997, 2018));
        books.add(new Book("Test Driven Development: By Example", 321146530, 2001));
        books.add(new Book("Patterns of Enterprise Application Architecture", 321127420, 2002));
        books.add(new Book("Head First Design Patterns", 596007124, 2004));
        books.add(new Book("Clean Architecture", 134494164, 2017));
    }

    @Test //1 test loop
    public void testIsbnFinderLoop() {
        Book book = bookFunctions.isbnFinderLoop(134494164, books);
        Assert.assertEquals("Clean Architecture", book.getTitle());
    }

    @Test //1 test stream
    public void testIsbnFinderStream() {
        Book book = bookFunctions.isbnFinderStream(134494164, books).get();
        Assert.assertEquals("Clean Architecture", book.getTitle());
    }

    @Test //2 test loop
    public void testLastTwoBookFinder() {
        List<Book> books1 = bookFunctions.lastTwoBookFinderLoop(books);
        Assert.assertEquals("Clean Architecture", books1.get(1).getTitle()); //TODO jak bez 0 i 1? assert j biblioteka
        Assert.assertEquals("Head First Design Patterns", books1.get(0).getTitle());
    }

    @Test //2 test stream
    public void testLastTwoBookFinderStream() {
        List<Book> books1 = bookFunctions.lastTwoBookFinderStream(books);
        Assertions.assertThat(books1).containsExactly(books.get(4), books.get(5));
    }

    @Test //3 test loop
    public void testTheOldestBookFinderLoop() {
        Book book = bookFunctions.theOldestBookFinderLoop(books);
        Assert.assertEquals("Test Driven Development: By Example", book.getTitle());
    }

    @Test //3 test stream
    public void testTheOldestBookFinderStream() {
        Optional<Book> optionalBook = bookFunctions.theOldestBookFinderStream(books);
        Book book = optionalBook.get();
        Assert.assertEquals("Test Driven Development: By Example", book.getTitle());
    }

    @Test //3 test stream should not find
    public void testTheOldestBookNotFinderStream() {
        Optional<Book> book = bookFunctions.theOldestBookFinderStream(emptyList);
        Assert.assertFalse(book.isPresent());
    }

    @Test //4 test loop
    public void testTheYoungestBookFinderLoop() {
        Book book = bookFunctions.theYoungestBookFinderLoop(books);
        Assert.assertEquals("Effective Java (3rd Edition)", book.getTitle());
    }

    @Test //4 test stream
    public void testTheYoungestBookFinderStream() {
        Optional<Book> optionalBook = bookFunctions.theYoungestBookFinderStream(books);
        Assert.assertEquals("Effective Java (3rd Edition)", optionalBook.get().getTitle());
    }

    @Test //4 test stream pusta lista
    public void testTheYoungestBookNotFinderStream() {
        Optional<Book> optionalBook = bookFunctions.theYoungestBookFinderStream(emptyList);
        Assert.assertFalse(optionalBook.isPresent());
    }

    @Test //5 Loop
    public void testSumOfYearForAllBooksLoop() {
        int sumOfYear = bookFunctions.sumOfYearForAllBooksLoop(books);
        Assert.assertEquals(12050, sumOfYear);
    }

    @Test //5 Stream
    public void testSumOfYearForAllBooksStream() {
        int sumOfYear = bookFunctions.sumOfYearForAllBooksStream(books);
        Assert.assertEquals(12050, sumOfYear);
    }

//    @Test //5 Stream
//    public void testSumOfYearForAllBooksStream2222() {
//        int sumOfYear = bookFunctions.sumOfYearForAllBooksStream(new ArrayList<>());
//        Assert.assertEquals(12050, sumOfYear);
//    }

//Test stream is empty?


    @Test //6 Loop
    public void testCountAmountOfBooksAfter2007() {
        int counterOfBooks = bookFunctions.countAmountOfBooksAfter2007Loop(books);
        Assert.assertEquals(3, counterOfBooks);
    }


    @Test //6 Stream
    public void testCountAmountOfBooksAfter2007Stream() {
        int counterOfBooks = bookFunctions.countAmountOfBooksAfter2007Stream(books);
        Assert.assertEquals(3, counterOfBooks);
    }

    @Test //7 Loop
    public void testIsEveryBookPublishedAfter2000Loop() {
        boolean isTrue = bookFunctions.isEveryBookPublishedAfter2000Loop(books);
        Assert.assertEquals(true, isTrue);
    }

    @Test //7 Stream
    public void testIsEveryBookPublishedAfter2000Stream() {
        boolean isTrue = bookFunctions.isEveryBookPublishedAfter2000Stream(books);
        Assert.assertEquals(true, isTrue);
    }

    // Test //7 stream isEmpty

    @Test //8 Loop
    public void testavarageOfBooksYearsLoop() {
        double average = bookFunctions.avarageOfBooksYears(books);
        Assert.assertEquals(2008.33, average, 0.1);//todo jak zaokrąglic do dwóch
    }

    @Test //8 Stream
    public void testAvarageOfBooksYearsStream() {
        double average = bookFunctions.avarageOfBooksYearsStream(books).getAsDouble();
        Assert.assertEquals(2008.33, average, 0.1); // 0.1 trzeci parametr, pokazuje możliwy błąd


        // Double average = bookFunctions.avarageOfBooksYearsStream(new ArrayList<>());
//        Assert.assertEquals(2008.33, average, 0.1);//todo jak wyzej
    }

    @Test //9 Loop
    public void testisAnyBookPublishedBefore2003Loop() {
        boolean isAny = bookFunctions.isAnyBookPublishedBefore2003Loop(books);
        Assert.assertEquals(true, isAny);
    }

    @Test //9 Stream
    public void testisAnyBookPublishedBefore2003Stream() {
        boolean isAny = bookFunctions.isAnyBookPublishedBefore2003Stream(books);
        Assert.assertEquals(true, isAny);
    }

    // Test //9 stream isEmpty

    @Test //10 Loop
    public void testReturnAllBooksOnCLetterAndPublishedAfter2000Loop() {
        List<Book> bookOnCAndAfter2007 = bookFunctions.returnAllBooksOnCLetterAndPublishedAfter2007Loop(books);
        Assertions.assertThat(bookOnCAndAfter2007).containsExactly(books.get(0), books.get(5));
    }

    @Test //10 Stream
    public void testReturnAllBooksOnCLetterAndPublishedAfter2000Stream() {
        List<Book> bookOnCAndAfter2007 = bookFunctions.returnAllBooksOnCLetterAndPublishedAfter2007Stream(books);
        Assertions.assertThat(bookOnCAndAfter2007).containsExactly(books.get(0), books.get(5));
    }

    @Test //11 Loop
    public void testIsDivisibleBy2LoopLoop() {
        List<Book> bookYearIsDivisibleBy2 = bookFunctions.isDivisibleBy2Loop(books);
        Assertions.assertThat(bookYearIsDivisibleBy2).containsExactly(books.get(0), books.get(1), books.get(3), books.get(4));
    }

    @Test //11 Stream
    public void testIsDivisibleBy2LoopStream() {
        List<Book> bookYearIsDivisibleBy2 = bookFunctions.isDivisibleBy2Stream(books);
        Assertions.assertThat(bookYearIsDivisibleBy2).containsExactly(books.get(0), books.get(1), books.get(3), books.get(4));
    }

    @Test //12 Loop
    public void testMapOfIsbnAndBookLoop() {
        Map<String, Book> map = bookFunctions.mapOfIsbnAndBookLoop(books);
        Assertions.assertThat(map).containsEntry("132350882", books.get(0));
        Assertions.assertThat(map).containsEntry("134685997", books.get(1));
        Assertions.assertThat(map).containsEntry("321146530", books.get(2));
        Assertions.assertThat(map).containsEntry("321127420", books.get(3));
        Assertions.assertThat(map).containsEntry("596007124", books.get(4));
        Assertions.assertThat(map).containsEntry("134494164", books.get(5));
    }

    @Test //12 Stream
    public void testMapOfIsbnAndBookStream() {
        Map<String, Book> map = bookFunctions.mapOfIsbnAndBookStream(books);
        Assertions.assertThat(map).containsEntry("132350882", books.get(0));
        Assertions.assertThat(map).containsEntry("134685997", books.get(1));
        Assertions.assertThat(map).containsEntry("321146530", books.get(2));
        Assertions.assertThat(map).containsEntry("321127420", books.get(3));
        Assertions.assertThat(map).containsEntry("596007124", books.get(4));
        Assertions.assertThat(map).containsEntry("134494164", books.get(5));
    }


    @Test //13 Loop
    public void testSortBooksFromTheYoungestLoop() {
        List<Book> book = bookFunctions.sortBooksFromTheYoungestLoop(books);
        //  Assertions.assertThat(book).containsExactly(books.get(2), books.get(3), books.get(4), books.get(0),books.get(5), books.get(1));
        Assertions.assertThat(book).containsExactly(books.get(1), books.get(5), books.get(0), books.get(4), books.get(3), books.get(2));
    }

    @Test //13 Stream
    public void testSortBooksFromTheYoungestStream() {
        List<Book> book = bookFunctions.sortBooksFromTheYoungestStream(books);
        Assertions.assertThat(book).containsExactly(books.get(1), books.get(5), books.get(0), books.get(4), books.get(3), books.get(2));
    }

    @Test //14 Loop
    public void testSortBooksFromTheOldestLoop() {
        List<Book> book = bookFunctions.sortBooksFromTheOldestLoop(books);
        Assertions.assertThat(book).containsExactly(books.get(2), books.get(3), books.get(4), books.get(0), books.get(5), books.get(1));
    }

    @Test //13 Stream
    public void testSortBooksFromTheOldestStream() {
        List<Book> book = bookFunctions.sortBooksFromTheOldestStream(books);
        Assertions.assertThat(book).containsExactly(books.get(2), books.get(3), books.get(4), books.get(0), books.get(5), books.get(1));
    }
}

