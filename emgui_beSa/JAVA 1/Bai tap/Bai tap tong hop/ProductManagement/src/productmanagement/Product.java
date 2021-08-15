/*
 * To change this license header, choose License Headers in Project Properties.
 * To change this template file, choose Tools | Templates
 * and open the template in the editor.
 */
package productmanagement;

import java.util.Scanner;

/**
 *
 * @author nguyenducthao
 */
public class Product {

    private int ID;
    private String name;
    private int quantity;
    private int price;

    public Product() {
    }

    public Product(int ID, String name) {
        this.ID = ID;
        Scanner input = new Scanner(System.in);
        this.name = name;
        System.out.print("Input product quantity: ");
        this.quantity = input.nextInt();
        System.out.print("Input product price: ");
        this.price = input.nextInt();
    }

    public int getID() {
        return ID;
    }

    public void setID(int ID) {
        this.ID = ID;
    }

    public String getName() {
        return name;
    }

    public void setName(String name) {
        this.name = name;
    }

    public int getQuantity() {
        return quantity;
    }

    public void setQuantity(int quantity) {
        this.quantity = quantity;
    }

    public int getPrice() {
        return price;
    }

    public void setPrice(int price) {
        this.price = price;
    }

    public void showProduct() {
        System.out.println("\t" + this.ID + "\t\t" + this.name + "\t" + this.quantity + "\t\t" + this.price);
//        System.out.println("\tProduct name: "+this.name);
//        System.out.println("\tProduct quantity: "+this.quantity);
//        System.out.println("\tProduct price: "+this.price);
    }
}
