/*
 * To change this license header, choose License Headers in Project Properties.
 * To change this template file, choose Tools | Templates
 * and open the template in the editor.
 */
package lab01;

import java.io.File;
import java.io.IOException;
import java.util.*;

/**
 *
 * @author Mehadi Hassan
 */
public class Task03_Undirected {
    public static void main (String[]args){
        
        File file1 = new File ("input.txt");
        Scanner sc = null;
        try{
            sc = new Scanner(file1);
        }
        
        catch(IOException e){
            System.out.println("File not found");
        }
        int w = sc.nextInt();
        int[] outDegree = new int [6];
        int[][] matrixUndirected = new int[w][w];
        System.out.println("Undirected Graph Adjacency Matrix");
        while(sc.hasNextInt()){
            int p = sc.nextInt();
            int q = sc.nextInt();
            matrixUndirected[p][q] = 1;
            matrixUndirected[q][p] = 1;
            outDegree[p]++;
            outDegree[q]++;
        }
        
        System.out.print("  ");
        for(int k = 0 ; k<matrixUndirected.length ; k++){
            System.out.print(k+" ");
        }
        System.out.println();
        
        for(int j = 0 ; j < matrixUndirected.length ; j++){
            System.out.print(j+ " ");
            for(int k = 0 ; k< matrixUndirected.length ; k++){
                System.out.print(matrixUndirected[j][k]+ " ");
            }
            System.out.println();
        }
        
        
        //------------------------
        
        
        File file = new File ("input.txt");
        sc = null;
        try{
            sc = new Scanner (file);
        }
        catch (IOException e){   
        }
        
        LinkedList  list[] = new LinkedList[sc.nextInt()];
        int check[] = new int [list.length]; 
        
        while (sc.hasNextInt()){
            try{
                int i = sc.nextInt();
                int j = sc.nextInt();
                
                if(check[i]==0){
                    list[i] = new LinkedList();
                    list[i].add(j);
                    check[i]++;
                
                    if(check[j]== 0){
                        list[j] = new LinkedList();
                        list[j].add(i);
                        check[j]++;
                    }
                    else{
                        list[j].add(i);
                        check[j]++;
                    }
                }
                
                else{
                    list[i].add(j);
                    check[i]++;
                    
                    if(check[j]== 0){
                        list[j] = new LinkedList();
                        list[j].add(i);
                        check[j]++;
                    }
                    else{
                        list[j].add(i);
                        check[j]++;
                    }
                }
            }
            catch(Exception e){
                
            }
        }
        System.out.println("\n"+"Adjacency List");
        
         for(int i = 0 ; i < list.length ; i++){
             System.out.println(i + "--->" + list[i]);
         }
         
         System.out.println("\nOut degree:");
         for(int i = 0 ; i < check.length ; i++){
             System.out.println(i + "--->" + check[i]);
         }
        
        
    }
    
}
