/*
 * To change this license header, choose License Headers in Project Properties.
 * To change this template file, choose Tools | Templates
 * and open the template in the editor.
 */
package manageratm;

import java.io.FileInputStream;
import java.io.FileNotFoundException;
import java.io.FileOutputStream;
import java.util.Scanner;
import java.util.logging.Level;
import java.util.logging.Logger;

/**
 *
 * @author VIET QUANG
 */
public class Main {
    static Scanner scan = new Scanner(System.in);
    static Account account = null;
    public static void main(String[] args) {
        login();
        System.out.println("Next Step!!!!");
        int choose;
        
        do {
            showMenu();
            choose = Integer.parseInt(scan.nextLine());
            
            switch(choose){
                case 1:// tao tai khoan
                    account = new Account();
                    account.input();
                    break;
                case 2://nap tien
                    if(account != null){
                        account.addReceiver();
                        account.display();
                    } else{
                        System.err.println("TK khong ton tai");
                    }
                    
                    break;
                case 3:// gui tien
                    if(account != null){
                        account.transfer();
                        account.display();
                    } else {
                        System.err.println("TK khong ton tai");
                    }
                    break;
                case 4:
                    if(account != null){
                        account.displayReceiverHistory();
                    } else {
                        System.err.println("TK khong ton tai");
                    }
                    break;
                case 5:
                    if(account != null){
                        account.displayTransferHistory();
                    } else {
                        System.err.println("TK khong ton tai");
                    }
                    break;
                case 6:
                    saveFile();
                    break;
                case 7:
                    readFile();
                    break;
                case 8:
                    System.out.println("Thoat!!!");
                    break;
                default:
                    System.out.println("Nhap sai!!!!");
                    break;
            }
            
        }while(choose != 8);
    }
    
    static void saveFile(){
        FileOutputStream fos = null;
        
        try {
            fos = new FileOutputStream("account123.txt");
            
            //save thong tin tk
            //header
            String line = Account.getHeader() + "\n";
            fos.write(line.getBytes());
            //than
            line = account.getFileInfor() + "\n";
            fos.write(line.getBytes());
            
            //luu lich su nhan tien
            line = Receiver.getHeader() + "\n";
            fos.write(line.getBytes());
            for (Receiver receiver : account.getReceiverList()) {
                line = receiver.getFileInfor()+ "\n";
                 fos.write(line.getBytes());
            }
            
            //luu lich su chuyen tien
            line = Transfer.getHeader() + "\n";
            fos.write(line.getBytes());
            for (Transfer transfer : account.getTransferList()) {
                line = transfer.getFileInfor()+ "\n";
                 fos.write(line.getBytes());
            }
        } catch (Exception e) {
        } finally {
            try{
                if(fos != null){
                    fos.close();
                }
                
            }catch(Exception e){
            }finally{
                
            }
        }
    }
    
    static void readFile(){
        FileInputStream fis = null;
        
        try {
            fis = new FileInputStream("account123.txt");
            
            //save thong tin tk
            //header
            String line = Account.getHeader() + "\n";
            fis.read();
            //than
            line = account.getFileInfor() + "\n";
            fis.read();
            
            //luu lich su nhan tien
            line = Receiver.getHeader() + "\n";
            fis.read();
            for (Receiver receiver : account.getReceiverList()) {
                line = receiver.getFileInfor()+ "\n";
                 fis.read();
            }
            
            //luu lich su chuyen tien
            line = Transfer.getHeader() + "\n";
            fis.read();
            for (Transfer transfer : account.getTransferList()) {
                line = transfer.getFileInfor()+ "\n";
                 fis.read();
            }
        } catch (Exception e) {
        } finally {
            try{
                if(fis != null){
                    fis.close();
                }
                
            }catch(Exception e){
            }finally{
                
            }
        }
        
    }
    
    static void showMenu(){
        System.out.println("1. Khoi tao TK");
        System.out.println("2. Nap tien");
        System.out.println("3. Chuyen khoan");
        System.out.println("4. Xem lich su nap tien");
        System.out.println("5. Xem lich su chuyen tien");
        System.out.println("6. Luu");
        System.out.println("7. Doc du lieu");
        System.out.println("8. Thoat");
        System.out.println("Chon: ");
    }
    
    static void login(){
        System.out.println("====== WELCOME ======");
        System.out.println("User Name: ");
        String username = scan.nextLine();
        
        System.out.println("Password: ");
        String password = scan.nextLine();
        
        if(username.equalsIgnoreCase("quangdung") && password.equals("quangdung123")){
            System.out.println("Login Success!!!");
        } else {
            System.err.println("Login Failed!!!!");
            // trong function goi ham chinh no goi la de quy
            login();
        }
    }
}
