/*
 * To change this license header, choose License Headers in Project Properties.
 * To change this template file, choose Tools | Templates
 * and open the template in the editor.
 */
package testarray;

public class Test {

    public static void main(String[] args) {
        //    int[] arr = new int[10];
        
//        String[] str = new String[100];
//        String[] str = {};
        //length : 10, index: 0 -9
        
        int[][] arr2 = {
            {1, 2, 3, 4},
            {5, 6, 7, 8},
            {9, 10, 11, 12},
    };// new int[3][4]
        for (int i = 0; i < 3; i++) {
            for (int j = 0; j < 4; j++) {
                System.out.println(arr2[i][j]);
                
            }
            
        }
        
//        int[] arr = {10, 20, 30, 40, 50, 60, 70, 80, 90, 100};
//       
//        System.out.println("length : " + arr.length);
//        for (int i = 0; i < arr.length; i++) {
//            System.out.println("arr["+i+"] = " + arr[i]);
//        }
    }
  
}
