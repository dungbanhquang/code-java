/*
 * To change this license header, choose License Headers in Project Properties.
 * To change this template file, choose Tools | Templates
 * and open the template in the editor.
 */
package book;

import java.util.Scanner;

/**
 *
 * @author VIET QUANG
 */
public class Book {
    String bookname;
    String createdAt;
    String nickname;

    public Book() {
    }

    public Book(String bookname, String createdAt, String nickname) {
        this.bookname = bookname;
        this.createdAt = createdAt;
        this.nickname = nickname;
    }
    
    public void input(){
        Scanner input = new Scanner(System.in);
        System.out.println("Nhap ten sach : ");
        bookname = input.nextLine();
        
        System.out.println("Ngay xuat ban : ");
        createdAt = input.nextLine();
        
        System.out.println("Nhap but danh : ");
        nickname = input.nextLine();
    }

    public void display(){
        System.out.println(toString());
    }
    
    @Override
    public String toString() {
        return "Book{" + "bookname=" + bookname + ", createdAt=" + createdAt + ", nickname=" + nickname + '}';
    }

    
    
    public String getBookname() {
        return bookname;
    }

    public void setBookname(String bookname) {
        this.bookname = bookname;
    }

    public String getCreatedAt() {
        return createdAt;
    }

    public void setCreatedAt(String createdAt) {
        this.createdAt = createdAt;
    }

    public String getNickname() {
        return nickname;
    }

    public void setNickname(String nickname) {
        this.nickname = nickname;
    }
    
    
}
