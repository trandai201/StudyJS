/*
 * To change this license header, choose License Headers in Project Properties.
 * To change this template file, choose Tools | Templates
 * and open the template in the editor.
 */
package productmanagement;

import java.util.ArrayList;
import java.util.Collections;
import java.util.Scanner;

/**
 *
 * @author nguyenducthao
 */
public class ProductManagement {

    /**
     * @param args the command line arguments
     */
    ArrayList<Product> listProduct;

    public ProductManagement() {
        listProduct = new ArrayList<>();
    }

    void addAnProduct() {
        do {
            String name;
            Scanner input = new Scanner(System.in);
            System.out.print("Input product name " + (listProduct.size() + 1) + ": ");
            name = input.nextLine();
            if (name.contains("quit")) {
                break;
            } else {
                Product product = new Product(listProduct.size() + 1, name);
                listProduct.add(product);
            }
        } while (true);

    }

    void deleteProduct() {
        System.out.print("Input ID product tobe delete: ");
        Scanner input = new Scanner(System.in);
        int IDDelete = input.nextInt();
        boolean delete = false;
        for (int i = 0; i < listProduct.size(); i++) {
            if (listProduct.get(i).getID() == IDDelete) {
                listProduct.remove(i);
                delete = true;
            }
        }
        if (!delete) {
            System.out.println("No product found");
        }
    }

    void displayProduct() {
        System.out.println("\tID\t\tName\t\tQuantity\t\tPrice($)");
        for (int i = 0; i < listProduct.size(); i++) {
            listProduct.get(i).showProduct();
        }
    }

    void shortByID() {
        for (int i = 0; i < listProduct.size() - 1; i++) {
            for (int j = 0; j < listProduct.size(); j++) {
                if (listProduct.get(i).getID() > listProduct.get(j).getID()) {
                    Product product = new Product();
                    product = listProduct.get(i);
                    listProduct.set(i, listProduct.get(j));
                    listProduct.set(j, product);
                }

            }

        }
    }

    void shortByPrice() {
        for (int i = 0; i < listProduct.size() - 1; i++) {
            for (int j = 0; j < listProduct.size(); j++) {
                if (listProduct.get(i).getPrice() > listProduct.get(j).getPrice()) {
                    Product product = new Product();
                    product = listProduct.get(i);
                    listProduct.set(i, listProduct.get(j));
                    listProduct.set(j, product);
                }

            }

        }
    }

    void shortByName() {
        for (int i = 0; i < listProduct.size() - 1; i++) {
            for (int j = 0; j < listProduct.size(); j++) {
                if (listProduct.get(i).getName().substring(0, listProduct.get(i).getName().indexOf(" ")).compareToIgnoreCase(listProduct.get(j).getName().substring(0, listProduct.get(j).getName().indexOf(" "))) > 0) {
                    Product product = new Product();
                    product = listProduct.get(i);
                    listProduct.set(i, listProduct.get(j));
                    listProduct.set(j, product);
                }

            }

        }
    }

    public static void main(String[] args) {
        // TODO code application logic here
        int choice = 0;
        ProductManagement productManagement = new ProductManagement();
        Scanner input = new Scanner(System.in);
        do {
            System.out.println("1. Add an product");
            System.out.println("2. Display all products");
            System.out.println("3. Delete an product");
            System.out.println("4. Sort by id");
            System.out.println("5. Sort by price");
            System.out.println("6. Sort by name (first name)");
            System.out.println("7. Quit");
            System.out.print("Your choice: ");
            choice = input.nextInt();
            switch (choice) {
                case 1:
//                    System.out.println("1");
                    productManagement.addAnProduct();
                    break;
                case 2:
//                    System.out.println("2");
                    productManagement.displayProduct();
                    break;
                case 3:
//                    System.out.println("3");
                    productManagement.deleteProduct();
                    break;
                case 4:
//                    System.out.println("4");
                    productManagement.shortByID();
                    break;
                case 5:
//                    System.out.println("5");
                    productManagement.shortByPrice();
                    break;
                case 6:
//                    System.out.println("6");
                    productManagement.shortByName();
                    break;
                case 7:
                    System.exit(0);
            }
        } while (true);

    }

}
