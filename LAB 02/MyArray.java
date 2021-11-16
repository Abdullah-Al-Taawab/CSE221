/*
 * To change this license header, choose License Headers in Project Properties.
 * To change this template file, choose Tools | Templates
 * and open the template in the editor.
 */

import java.util.Arrays;
import java.util.Random;

/**
 * @author 17101177
 */
public class MyArray {
    
    
    public static int[] insertionSort(int[] a){
      
        for(int j = 1 ; j < a.length ; j++){
            int key = a[j];
            int i = j -1;
            
            while(i > 0 && a[i] > key){
                a[i+1] = a[i];
                i--;
            }
            a[i+1] = key;
        }
        
        return  a;
    }
    
    public static int[] mergeSort(int[] a){
        
       if(a.length == 1){
       return a;
       }
       
       else{
           int mid = a.length/2;
           int a1[] = mergeSort(split(a , 0, mid));
           int a2[] = mergeSort(split(a , mid , a.length));
           int a3[] = merge(a1, a2);
           return a3;
       }
    }



    public static int[] split(int a[] , int start, int end){
        int temp[] = new int[end-start];
        System.arraycopy(a, start, temp, 0, (temp.length));
        return temp;
    }

    
    public static int[] merge(int[] a1 , int[] a2){
        int[] c = new int [a1.length+a2.length];
        int i = 0 , j = 0 , k = 0;
        
        while (i < a1.length && j < a2.length){
            if(a1[i] <= a2[j]){
                c[k] = a1[i];
                i++;
            }
            else{
                c[k] = a2[j];
                j++;
            }
            k++;
        }
        
        while(i < a1.length){
            c[k] = a1[i];
            i++;
            k++;
        }
        
        while(j < a2.length){
            c[k] = a2[j];
            j++;
            k++;
        }
        return c;
    }
    
    public static int[] quickSort(int[] a,int start, int end){
        
        if(start<end){
            int pIndex = partition(a , start , end);
            quickSort(a, start , pIndex-1);
            quickSort(a, pIndex+1 , end);
        }
        return a;
    }
    
     public static int[] quickSortR(int[] a,int start, int end){
        
        if(start<end){
            int pIndex = partitionR(a , start , end);
            quickSort(a, start , pIndex-1);
            quickSort(a, pIndex+1 , end);
        }
        return a;
    }
    
    public static int partition(int[] a , int start , int end){
        int pivot = a[end];
        int pIndex = start;
        
        for(int i = start ; i< end ; i++){
            if(a[i]<=pivot){
                int swap = a[i];
                a[i] = a[pIndex];
                a[pIndex] = swap;
                pIndex++;
            }
        }

        int swap = a[pIndex];
        a[pIndex] = a[end];
        a[end] = swap;

        return pIndex;
    }
    
    public static int partitionR(int[] a , int start , int end){
        Random random = new Random();
        int i = random.nextInt((end - start) + 1) + start;
        int temp = a[end];
        a[end] = a[i];
        a[i] = temp;
        return partition(a , start ,end);
        
    }
    
    public static void heapSort(int[] a){
       int n = a.length;
        for (int i = n/2 - 1 ; i >= 0 ; i--){ 
            heapify(a, n, i);
        }
        
        for (int i=n-1; i>=0; i--){
            int temp = a[0]; 
            a[0] = a[i]; 
            a[i] = temp;
            heapify(a, i, 0); 
        } 
   }
   
    public static void heapify(int arr[], int n, int i) 
    { 
        int largest = i;
        int l = 2*i + 1;
        int r = 2*i + 2;
        
        if (l < n && arr[l] > arr[largest]){ 
            largest = l;
        }
        
        if (r < n && arr[r] > arr[largest]) 
            largest = r; 
  
        if (largest != i){ 
            int swap = arr[i]; 
            arr[i] = arr[largest]; 
            arr[largest] = swap;
            heapify(arr, n, largest); 
        } 
    } 
    
    public static int findK(int[] a, int start, int end, int k){
        int i = partition(a , start , end);
        
        
        while(i!=(k-1)){
        if(i == (k-1)){
            return a[i];
        }
        
        else if(i < k-1){
            i = partition(a , i+1 , end);
          }
          
         else if(i > k-1){
            i = partition(a , start , i-1);
          }
        }
        return a[i];
    }
    
    
    public static void toMyString(int[] a){
       for(int i = 0 ; i < a.length-1 ; i++){
           System.out.print(a[i]+", ");
       }
       System.out.println(a[a.length-1]);
    }
    
    
}
