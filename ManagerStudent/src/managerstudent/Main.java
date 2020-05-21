/*
 * To change this license header, choose License Headers in Project Properties.
 * To change this template file, choose Tools | Templates
 * and open the template in the editor.
 */
package managerstudent;

import java.io.FileInputStream;
import java.io.FileOutputStream;
import java.io.ObjectInputStream;
import java.io.ObjectOutputStream;
import java.util.ArrayList;
import java.util.Collections;
import java.util.Comparator;
import java.util.List;
import java.util.Scanner;

/**
 *
 * @author VIET QUANG
 */
public class Main {

    public static void main(String[] args) {
        List<Student> studentList = new ArrayList<>();
        int choose;
        Scanner input = new Scanner(System.in);

        do {
            showMenu();
            choose = Integer.parseInt(input.nextLine());
            switch (choose) {
                case 1:
                    System.out.println("Nhap so sv can them : ");
                    int n = Integer.parseInt(input.nextLine());
                    for (int i = 0; i < n; i++) {
                        Student std = new Student();
                        std.input();

                        studentList.add(std);
                    }
                    break;
                case 2:
                    System.out.println("Nhap ID sv can sua : ");
                    int id = Integer.parseInt(input.nextLine());
                    for (int i = 0; i < studentList.size(); i++) {
                        if (studentList.get(i).getId() == id) {
                            studentList.get(i).edit();
                        }
                    }
                    break;
                case 3:
                    System.out.println("Nhap ID sv can delete : ");
                    int deleteID = Integer.parseInt(input.nextLine());
                    for (int i = 0; i < studentList.size(); i++) {
                        if (studentList.get(i).getId() == deleteID) {
                            studentList.remove(i);
                        }
                    }
                    break;
                case 4:
                    Collections.sort(studentList, ( o1,  o2) -> {
                        if (o1.getGpa() < o2.getGpa()) {
                            return -1;
                        }
                        return 1;
            });
                    for (int i = 1; i < studentList.size(); i++) {
                        studentList.get(i).display();
                    }
                    break;
                case 5:
                    Collections.sort(studentList, new Comparator<Student>() {
                        @Override
                        public int compare(Student o1, Student o2) {
                            return o1.getName().compareTo(o2.getName());
                      
                    }
                        
                    });
                    for (int i = 0; i < studentList.size(); i++) {
                        studentList.get(i).display();
                    }
                    break;
                case 6:
                    for (int i = 0; i < studentList.size(); i++) {
                        studentList.get(i).display();
                    }
                    break;
                case 7:
                    FileOutputStream fos = null;
                    ObjectOutputStream oos = null;
                    
                    try {
                        fos = new FileOutputStream("studentpro123.dat");
                        oos = new ObjectOutputStream(fos);
                        
                        oos.writeObject(studentList);
                        
                    } catch(Exception e){
                    } finally {
                        try{
                            if(fos != null){
                                fos.close();
                            }
                            if(oos != null){
                                oos.close();
                            }
                        }catch (Exception e){
                        }
                        
                    }
                    break;
                case 8:
                    FileInputStream fis = null;
                    ObjectInputStream ois = null;
                    try {
                        fis = new FileInputStream("studentpro123.dat");
                        ois = new ObjectInputStream(fis);
                        
                        studentList = (List<Student>) ois.readObject();
                        
                    }catch (Exception e){
                        
                    } finally {
                        try{
                            if(fis != null){
                                fis.close();
                            }
                            if(ois != null){
                                ois.close();
                            }
                            
                        }catch(Exception e ){}
                        
                    }

                    break;
                case 9:
                    System.out.println("GoodBye!!!");
                    break;
                default:
                    System.out.println("Input Failed!!!");
                    break;

            }
        } while (choose != 9);
    }

    static void showMenu() {
        System.out.println("1. Add student");
        System.out.println("2. Edit student by ID");
        System.out.println("3. Delete student by ID");
        System.out.println("4. Sort student by GPA");
        System.out.println("5. Sort student by Name");
        System.out.println("6. Show student");
        System.out.println("7. Save");
        System.out.println("8. Read");
        System.out.println("9. Exit");
        System.out.println("Choose");

    }

}
