/*
 * To change this license header, choose License Headers in Project Properties.
 * To change this template file, choose Tools | Templates
 * and open the template in the editor.
 */
package model;

import java.util.Scanner;

/**
 *
 * @author nguyenducthao
 */
public class Person {

    private int ID;
    private String name;
    private boolean gender;
    private String address;
    private String email;
    private String phone;
    private float salary;

    public Person() {
        Scanner input=new Scanner(System.in);
        System.out.print("Nhap ID: ");
        this.ID=input.nextInt();
        System.out.print("Nhap ten: ");
        input=new Scanner(System.in);
        this.name=input.nextLine();
        System.out.print("Nhap gioi tinh(0:Nam - 1: Nu): ");
        int gioitinh=input.nextInt();
        if(gioitinh==0){
            this.gender=true;
        }
        else{
            this.gender=false;
        }
        System.out.print("Nhap dia chi: ");
        input=new Scanner(System.in);
        this.address=input.nextLine();
        System.out.print("Nhap email: ");
        input=new Scanner(System.in);
        this.email=input.nextLine();
        System.out.print("Nhap so dien thoai: ");
        input=new Scanner(System.in);
        this.phone=input.nextLine();
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

    public boolean isGender() {
        return gender;
    }

    public void setGender(boolean gender) {
        this.gender = gender;
    }

    public String getAddress() {
        return address;
    }

    public void setAddress(String address) {
        this.address = address;
    }

    public String getEmail() {
        return email;
    }

    public void setEmail(String email) {
        this.email = email;
    }

    public String getPhone() {
        return phone;
    }

    public void setPhone(String phone) {
        this.phone = phone;
    }

    public float getSalary() {
        return salary;
    }

    public void setSalary(float salary) {
        this.salary = salary;
    }
    
    
}
