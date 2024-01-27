import Entities.Book;
import Entities.Library;
import Helper.Helper;

import java.util.Scanner;

public class Main {
    public static void main(String[] args) {


        Scanner sc=new Scanner(System.in);
        Library library = new Library();
        System.out.print("Welcome to  Library!\n PLease enter library name...");
        library.libraryName=library.emptyString();
        System.out.println("~~~ Welcome to "+library.libraryName+" library ~~~");


        Book book1 = new Book("Anna Karenina", "Leo Tolstoy", "ru", 25.90, 6);
        Book book2 = new Book("Hercule Poirot S Christmas by Agatha Christie", "Agatha Christie", "en", 22.39, 8);
        Book book3 = new Book("Səfillər", "Viktor Hüqo", "az", 15.40, 4);
        Book book4 = new Book("A Brief History of Black Holes", "Becky Smethurst", "en", 26.32, 12);


        library.addBook(book1);
        library.addBook(book2);
        library.addBook(book3);
        library.addBook(book4);

        while (true) {
            System.out.println("Please enter operation:" +
                    "\n1.Add book" +
                    "\n2.Update book" +
                    "\n3.Delete book" +
                    "\n4.Find book" +
                    "\n5.Show books" +
                    "\n6.Exit");

            String choice = sc.next();
            int userInput=Helper.convertToInt(choice);

            switch (userInput) {
                case 1:
                    library.newBook();
                    break;
                case 2:
                    System.out.print("Enter book ID to update: ");
                    int id = sc.nextInt();
                    Book updatedBook = library.findBookById(id);
                    if (updatedBook != null) {
                        System.out.print("Enter new price: ");
                        double newPrice = sc.nextDouble();
                        library.updateBook(updatedBook,newPrice);
                    } else {
                        System.out.println("Book not found. Update failed.");
                    }
                    break;
                case 3:
                    System.out.print("Enter book ID to delete: ");
                    int deleteId = sc.nextInt();
                    library.deleteBook(deleteId);
                    break;
                case 4:
                    System.out.print("Enter book ID to find ");
                    int findId = sc.nextInt();
                    library.findBookById(findId).fullInfo();
                    break;
                case 5:
                    library.showBooks();
                    break;
                case 6:
                    System.out.println("Exit program");
                    System.exit(0);
                    break;
                case 7:
                    System.out.println("Please choose correct operation!");
                    break;
            }
        }
    }
}
