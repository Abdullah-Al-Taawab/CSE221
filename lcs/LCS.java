/*
 * To change this license header, choose License Headers in Project Properties.
 * To change this template file, choose Tools | Templates
 * and open the template in the editor.
 */
package lcs;

/**
 *
 * @author 18101049
 */
import java.io.*;
import java.util.*;
public class LCS {
    /**
     * @param args the command line arguments
     */
    public static void main(String[] args) {
        // TODO code application logic here
        String a="ABEJ";
        String b="AJBCE";
        
        int m = a.length();
        int n = b.length();
        LCS(a,b,m,n);
    }
     public static void LCS(String a, String b, int m, int n  ){
         int[][] L = new int [m+1][n+1];
         
         for (int i=0 ; i <= m; i++) {
             for (int j=0; j<=n ; j++) {
                 if (i==0 || j==0) {
                     L[i][j]=0;
                 }
                 else if(a.charAt(i-1)==b.charAt(j-1)){
                     L[i][j] = L[i-1][j-1]+1;
                 }
                 else {
                     L[i][j] = Math.max(L[i-1][j],L[i][j-1]);
                 }
             }
         }
         int index = L[m][n];
         int temp = index;
         
         char[] lcsChar = new char[index+1];
         
         lcsChar[index]=' ';
         
         int i=m, j=n;
         
         while (i>0 && j>0) {
             if(a.charAt(i-1)==b.charAt(j-1)){
             lcsChar[index-1] = a.charAt(i-1);
             
             i--;
             j--;
             index--;
         }else if (L[i-1][j]>L[i][j-1]){
                   i--; 
                 }else {
                    j--;
                 }
             
             }
         System.out.print("LCS of "+a+" and "+b+ " is ");
         for (int p=0; p<=temp; p++) {
             System.out.print(lcsChar[p]);
         }
         
            
             
         
         System.out.println();
         for (int[] r:L) {
             System.out.println(Arrays.toString(r)); 
         }
    
         
     }
     
}