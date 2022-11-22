package meatshop;

import meats.*;
import java.util.ArrayList;
import java.util.Scanner;

public class menu {

    public static void run() {
        println("Beat my Meat Shop");
        while (true) {
            int buyerChoice = user();
            if (buyerChoice == 1) {
                asOwner();
            } else if (buyerChoice == 2) {
                asBuyer();
            }
            else if (buyerChoice == 0) {
            println("Bye");
            System.exit(0);
        }
            else {
                println("Invalid Input!");
            }
        }
    }

    static int user(){
        print("Are you a: \n1.Owner\n2.Buyer\n0.Exit\n-> ");
        int choice = sc.nextInt();
        return choice;
    }
    static void asOwner(){
        print("""
                1.Add Meat
                2.View Meat
                3.Update Meat
                -> \s""");
        int choice = sc.nextInt();
        sc.nextLine();
        switch (choice){
            case 1 -> addMeat();
            case 2 -> viewMeat();
            case 3 ->updateMeat();
            default -> println("invalid");
        }
    }
    static void addMeat(){
        print("Enter the price of Meat: ");
        int price = sc.nextInt();
        sc.nextLine();
        print("Enter the Stock of meat: ");
        int stock = sc.nextInt();
        sc.nextLine();
        print("""
                Enter a type of Meat:
                1. Pork
                2. Chicken Meat
                3. Beef
                -> \s""");
        int choice = sc.nextInt();
        sc.nextLine();
        switch (choice){
            case 1 -> {
                meat pork = new pork(price , stock);
                meats.add(pork);
            }
            case 2 -> {
                meat chicken = new chickenMeat(price , stock);
                meats.add(chicken);
            }
            case 3 -> {
                meat beef = new beef(price, stock);
                meats.add(beef);
            }
        }

    }
    static void viewMeat(){
        int ctr = 1;
        for (meat meat : meats){
            println("[" + ctr + "]");
            meat.display();
            ctr++;
        }
        ctr = 1;
        println("");
    }
    static void updateMeat(){
        viewMeat();
        print("Enter the position of meat you want to edit: ");
        int position = sc.nextInt();
        sc.nextLine();
        position-=1;
        print("""
                1. Update Price
                2. Update Stock
                -> \s""");
        int choice = sc.nextInt();
        sc.nextLine();
        switch (choice){
            case 1 -> {
                print("Enter new price: ");
                int newPrice = sc.nextInt();
                sc.nextLine();
                meats.get(position).setMeatPrice(newPrice);
            }
            case 2 -> {
                print("Enter new stock: ");
                int newStock = sc.nextInt();
                sc.nextLine();
                meats.get(position).setMeatStock(newStock);
            }
        }
    }
    static void asBuyer(){
        if (meats.size()!=-0) {
            viewMeat();
            print("Enter the meat number you want to buy: ");
            int toBuy = sc.nextInt();
            sc.nextLine();
            print("How many meat you want to buy: ");
            int quantity = sc.nextInt();
            sc.nextLine();
            toBuy -= 1;
            if (quantity > meats.get(toBuy).getMeatStock()) {
                println("Not enough stock. Please choose the right amount of katangahan sa buhay!");
            }
            else {

                int soldMeat = meats.get(toBuy).getMeatStock();
                soldMeat -= quantity;
                meats.get(toBuy).setMeatStock(soldMeat);
                int total = meats.get(toBuy).getMeatPrice();
                total = total * quantity;
                println("You bought " + quantity + " ");
                meats.get(toBuy).display();
                println("Your total amount is: " + total);
                checker();
                buyAgain();
            }
        }
        else {
            println("no more stock bye uwi kana di na ako galit");
        }
    }
    static void buyAgain(){
        print("do you want to buy more?\n1.[Yes]   2.[No]\n-> ");
        int buymore = sc.nextInt();
        switch (buymore){
            case 1 ->{
                asBuyer();
            }
            case 2 ->{
                println("k bye");
            }
            default -> {
                println("invalid");
            }

        }

    }
    static void checker(){
        for(int i = 0; i<meats.size(); i++) {
            if (meats.get(i).getMeatStock() == 0) {
                meats.remove(i);
            }
        }
    }
     static void println(Object o){
    System.out.println(o);
}
    static void print(Object o){
        System.out.print(o);
    }
    private static final Scanner sc = new Scanner(System.in);
    private static final ArrayList<meat> meats = new ArrayList<>();
}
