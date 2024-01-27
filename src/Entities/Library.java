package Entities;

import java.util.ArrayList;
import java.util.Scanner;


public class Library {
    Scanner sc=new Scanner(System.in);
    public String libraryName;
    private ArrayList<Book> books;
    public int bookCount;

    public Library() {
        books = new ArrayList<>();
        this.bookCount = 0;
    }

    public void addBook(Book newBook) {
        boolean isBookExists = books.stream()
                .filter(book -> book.Name.equalsIgnoreCase(newBook.Name)).findFirst().isPresent();
        if (isBookExists) {
            books.stream().filter(book -> book.Name.equalsIgnoreCase(newBook.Name)).findFirst().ifPresent(book -> book.Count += newBook.Count);
        } else {
            books.add(newBook);
        }

    }
    public void newBook(){
        System.out.print("Enter book name: ");
        String name = sc.nextLine();
        System.out.print("Enter author name: ");
        String author = sc.nextLine();
        System.out.print("Enter language: ");
        String language = sc.nextLine();
        System.out.print("Enter book price: ");
        double price = sc.nextDouble();
        System.out.print("Enter book count: ");
        int count = sc.nextInt();

        Book newBook = new Book(name, author, language, price, count);
        addBook(newBook);
    }


    public void updateBook(Book updatedBook, double newPrice) {
        books.stream()
                .filter(book -> book == updatedBook)
                .findFirst().ifPresent(book -> {
                    book.Price = newPrice;
                });
    }

    public void deleteBook(int Id) {
        boolean isRemoved = books.removeIf(book -> book.getId() == Id);
        if (isRemoved) {
            System.out.println("Book with ID " + Id + " deleted successfully!");
        } else {
            System.out.println("Book with ID " + Id + " not found.");
        }

    }

    public Book findBookByName(String Name) {
        for (Book book : books) {
            if (book.Name.equalsIgnoreCase(Name)) {
                return book;
            }
        }
        return null;
    }
    public String emptyString() {
        Scanner sc = new Scanner(System.in);
        String libName = " ";
        while (true) {
            libName = sc.nextLine();
            if (libName.isEmpty()) {
                System.out.print("Please enter library name ");
            } else return libName;
        }
    }

    public Book findBookById(int Id) {
        for (Book book : books) {
            if (book.getId() == Id) {
                return book;
            }
        }
        return null;
    }

    public void showBooks() {
        books.forEach(Book::fullInfo);
    }

}