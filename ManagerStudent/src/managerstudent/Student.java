/*
 * To change this license header, choose License Headers in Project Properties.
 * To change this template file, choose Tools | Templates
 * and open the template in the editor.
 */
package managerstudent;

import java.io.Serializable;
import java.util.Scanner;

/**
 *
 * @author VIET QUANG
 */
public class Student implements Serializable{
    int id;
    String name;
    int age;
    String address;
    float gpa;

    public Student() {
    }

    public Student(int id, String name, int age, String address, float gpa) {
        this.id = id;
        this.name = name;
        this.age = age;
        this.address = address;
        this.gpa = gpa;
    }

    public int getId() {
        return id;
    }

    public void setId(int id) {
        this.id = id;
    }

    public String getName() {
        return name;
    }

    public void setName(String name) {
        this.name = name;
    }

    public int getAge() {
        return age;
    }

    public void setAge(int age) {
        this.age = age;
    }

    public String getAddress() {
        return address;
    }

    public void setAddress(String address) {
        this.address = address;
    }

    public float getGpa() {
        return gpa;
    }

    public void setGpa(float gpa) {
        this.gpa = gpa;
    }
    
    public void input(){
        Scanner input = new Scanner(System.in);
        System.out.println("Nhap ID : ");
        id = Integer.parseInt(input.nextLine());
       
        edit();
    }

    public void edit(){
        Scanner input = new Scanner(System.in);
        
        System.out.println("Nhap Name : ");
        name = input.nextLine();
        
        System.out.println("Nhap Age : ");
        age = Integer.parseInt(input.nextLine());
        
        System.out.println("Nhap Address : ");
        address = input.nextLine();
        
        System.out.println("Nhap GPA : ");
        gpa = Float.parseFloat(input.nextLine());
    }
    @Override
    public String toString() {
        return "Student{" + "id=" + id + ", name=" + name + ", age=" + age + ", address=" + address + ", gpa=" + gpa + '}';
    }
    
    public void display(){
        System.out.println(toString());
    }
}
