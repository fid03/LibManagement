package Entities;

public class Book {
    public String Name;
    public String Author;
    public String Language;
    public double Price;
    public int Count;
    private int Id;
    public static int id;

    public Book(){

    }
    public Book(String Name,String Author,String Language,double Price,int Count){
        id++;
        Id=id;
        this.Name=Name;
        this.Author=Author;
        this.Language=Language;
        this.Price=Price;
        this.Count=Count;
    }
    public int getId(){
        return Id;
    }
    public void fullInfo(){
        System.out.println();
        System.out.println("Id: " + Id);
        System.out.println("Name: " + this.Name);
        System.out.println("Author: " + this.Author);
        System.out.println("Language: " + this.Language);
        System.out.println("Price: "+ this.Price);
        System.out.println("Count: "+ this.Count);
        System.out.println("--------------------");
    }
}
