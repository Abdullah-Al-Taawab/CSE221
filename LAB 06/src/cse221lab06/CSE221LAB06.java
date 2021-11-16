/*
 * To change this license header, choose License Headers in Project Properties.
 * To change this template file, choose Tools | Templates
 * and open the template in the editor.
 */
package cse221lab06;

/**
 *
 * @author Administrator
 */
import java.io.File;
import java.io.IOException;
import java.util.*;
public class CSE221LAB06 {


	public static int[][] graph = new int[14][14];
    public static int[] parent = new int[14];
    public static int[] distance = new int[14];
    public static boolean[] check = new boolean[14];
    public static String[] city = {"Motijheel" , "A" , "B" , "C" , "D", "E" , 
                                   "F" , "G" , "H" , "I" , "J" , "K" , "L" , "MOGHBAZAR" };
    
    public static void main(String[] args) {
        // TODO code application logic here
        File file = new File ("C:\\Users\\Administrator\\Desktop\\Cse material\\CSE221\\CSE221LAB solves\\CSE221LAB06\\input.txt");
        Scanner sc = null;
        try{
            sc = new Scanner(file);
        }
        
        catch(IOException e){
            System.out.println("File not found");
        }
        
        while(sc.hasNext()){
            String a = sc.next();
            int p = 0;
            for(int i = 0 ; i < city.length ; i++){
               if(a.equals(city[i])){
                   p = i;
               }
            }
            
            a = sc.next();
            int q = 0;
            for(int i = 0 ; i < graph.length ; i++){
               if(a.equals(city[i])){
                   q = i;
               }
            }
            graph[p][q] = sc.nextInt();
        }
        
    dij(graph , "Motijheel" , "MOGHBAZAR");
    
    }
    
    
    public static void dij(int[][] graph , String s , String e){
        int start = 0  , end = 0;
        for (int i = 0 ; i < graph.length ; i++){
            distance[i] = 5000;
            parent[i] = -1;
            check[i] = false;
        }
        
        for(int i = 0 ; i <city.length ; i++){
            if(s.equals(city[i])){
                start = i;
            }
        }
        
        for(int i = 0 ; i <city.length ; i++){
            if(e.equals(city[i])){
                end = i;
            }
        }
        
        distance[start] = 0;

        for(int i = 0 ; i < graph.length ; i++){
            int minKey = min(distance , check);
            check[minKey] = true;
            for(int j = 0 ; j < graph.length ; j++){
                 if (!check[j] && graph[minKey][j]!=0 &&  distance[minKey]+graph[minKey][j] < distance[j]) { 
                    parent[j] = minKey; 
                    distance[j] = distance[minKey] + graph[minKey][j]; 
                } 
            } 
        }
//print();
        print(start , end);     
    }

    public static int min (int[] key , boolean[] check){
        int min = 50000 , minIndex = -1 ;
        for(int i = 0 ; i <key.length ; i++){
            if(check[i] == false && key[i] < min){
                min = key[i];
                minIndex = i;
            }
        }
        return minIndex;
    }

    public static void print (int start , int end){
  		
  		int temp = end;

    	String s = "";
    	while (start != end){
    		s+=city[end] + " ";
    		end = parent[end];
    	}

    	System.out.println("Source: " + city[start] + " & Destination: " + city[temp]);
    	System.out.println("Cost: " + distance[temp]);
    	System.out.print("Shortest Path: ");
    	System.out.print(city[start]+" > ");
    	
    	String[] print = s.split(" ");
    	
    	for(int i = print.length - 1 ; i >= 1 ; i--){
    		System.out.print(print[i] +" > ");
    	}
    	System.out.println(print[0]);
    }
}

