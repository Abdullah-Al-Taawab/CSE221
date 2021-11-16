/*
 * To change this license header, choose License Headers in Project Properties.
 * To change this template file, choose Tools | Templates
 * and open the template in the editor.
 */
package lab01;

import java.io.File;
import java.io.IOException;
import java.util.LinkedList;
import java.util.Scanner;

/**
 *
 * @author Mehadi Hassan
 */
public class Task03_Directed {
    public static void main (String[]args){
        File file1 = new File ("input.txt");
        Scanner sc = null;
        try{
            sc = new Scanner(file1);
        }
        
        catch(IOException e){
            System.out.println("File not found");
        }
        int i = sc.nextInt();
        
        int[][] matrixDirected = new int[i][i];
        System.out.println("Directed Graph Adjacency Matrix");
        while(sc.hasNextInt()){
            int p = sc.nextInt();
            int q = sc.nextInt();
            matrixDirected[p][q] = 1;
            
        }
        
        System.out.print("  ");
        for(int k = 0 ; k<matrixDirected.length ; k++){
            System.out.print(k+" ");
        }
        System.out.println();
        
        for(int j = 0 ; j < matrixDirected.length ; j++){
            System.out.print(j+ " ");
            for(int k = 0 ; k< matrixDirected.length ; k++){
                System.out.print(matrixDirected[j][k]+ " ");
            }
            System.out.println();
        }
        
        //-------------
        
        File file = new File ("input.txt");
        sc = null;
        try{
            sc = new Scanner (file);
        }
        catch (IOException e){   
        }
        
        LinkedList  list[] = new LinkedList[sc.nextInt()];
        int check[] = new int [list.length]; 
        int out[] = new int[list.length];
        int in[] = new int[list.length];
        
        while (sc.hasNextInt()){
             i = sc.nextInt();
            int j = sc.nextInt();
                
            if(check[i]==0){
            list[i] = new LinkedList();
            list[i].add(j);
            check[i]++;
            out[i]++;
            in[j]++;
            }
            
            else{
                list[i].add(j);
                check[i]++;
                out[i]++;
                in[j]++;
            }
        }
        
        System.out.println("\nAdjacenccy List");
        for(int m = 0; m < list.length ; m++){
//            String s = list[m].toString().replace("[", "").replace("]", "");
            System.out.println(m + "--->" + list[m]);
        }
        
         System.out.println("\nOut/In Degree:");
         for(int q = 0 ; q < list.length ; q++){
             System.out.println(q + "-->" + out[q] + "/" + in[q]);
         }
        
        
        
    }    
}
