/*
 * To change this license header, choose License Headers in Project Properties.
 * To change this template file, choose Tools | Templates
 * and open the template in the editor.
 */

import java.util.Arrays;

/**
 *
 * @author 17101177
 */
public class SortTest {

    /**
     * @param args the command line arguments
     */
    public static void main(String[] args) {
        // TODO code application logic here
        
        int array[] = {3, 5 , 10, 23, 25, 8, 7, 9, 50, 47};
        
        //Task 1
        System.out.println("Task 1: Built in Sort");
        int[] temp = new int[array.length];
        System.arraycopy(array, 0, temp , 0, (array.length));
        System.out.println("Unsorted Array");
        MyArray.toMyString(temp);
        int timeStart = (int) ((System.currentTimeMillis()));
        Arrays.sort(temp);
        int timeEnd  = (int) ((System.currentTimeMillis())) - timeStart;
        System.out.println("Sorted Array:");
        MyArray.toMyString(temp);
        System.out.println("Time required: " + timeEnd + " ms\n");
        
        //Task 2
        System.out.println("Task 2: Insertion Sort");
        System.arraycopy(array, 0, temp , 0, (array.length));
        System.out.println("Unsorted Array");
        MyArray.toMyString(temp);
        timeStart = (int) ((System.currentTimeMillis()));
        temp = MyArray.insertionSort(temp);
        timeEnd  = (int) ((System.currentTimeMillis())) - timeStart;
        System.out.println("Sorted Array:");
        MyArray.toMyString(temp);
        System.out.println("Time required: " + timeEnd + " ms\n");
        
        
        //Task 3
        System.out.println("Task 3: Merge Sort");
        System.arraycopy(array, 0, temp , 0, (array.length));
        System.out.println("Unsorted Array");
        MyArray.toMyString(temp);
        timeStart = (int) ((System.currentTimeMillis()));
        temp = MyArray.mergeSort(temp);
        timeEnd  = (int) ((System.currentTimeMillis())) - timeStart;
        System.out.println("Sorted Array:");
        MyArray.toMyString(temp);
        System.out.println("Time required: " + timeEnd + " ms\n");
        
        
         //Task 4(a)
        System.out.println("Task 4(a): Quick Sort");
        System.arraycopy(array, 0, temp , 0, (array.length));
        System.out.println("Unsorted Array");
        MyArray.toMyString(temp);
        timeStart = (int) ((System.currentTimeMillis()));
        temp = MyArray.quickSort(temp , 0 , temp.length-1);
        timeEnd  = (int) ((System.currentTimeMillis())) - timeStart;
        System.out.println("Sorted Array:");
        MyArray.toMyString(temp);
        System.out.println("Time required: " + timeEnd + " ms\n");
        
        // Task 4(b)
        System.out.print("Task 4(b): 3rd element: ");
        System.arraycopy(array, 0, temp , 0, (array.length));
        System.out.println(MyArray.findK(temp, 0 , temp.length-1 , 3) + "\n");
        
         //Task 5
        System.out.println("Task 5: Quick Sort using randomized pivot");
        System.arraycopy(array, 0, temp , 0, (array.length));
        System.out.println("Unsorted Array");
        MyArray.toMyString(temp);
        timeStart = (int) ((System.currentTimeMillis()));
        temp = MyArray.quickSortR(temp , 0 , temp.length-1);
        timeEnd  = (int) ((System.currentTimeMillis())) - timeStart;
        System.out.println("Sorted Array:");
        MyArray.toMyString(temp);
        System.out.println("Time required: " + timeEnd + " ms\n");
        
        
        //Task 6
        System.out.println("Task 6: Heap Sort");
        System.arraycopy(array, 0, temp , 0, (array.length));
        System.out.println("Unsorted Array");
        MyArray.toMyString(temp);
        timeStart = (int) ((System.currentTimeMillis()));
        MyArray.heapSort(temp);
        timeEnd  = (int) ((System.currentTimeMillis())) - timeStart;
        System.out.println("Sorted Array:");
        MyArray.toMyString(temp);
        System.out.println("Time required: " + timeEnd + " ms\n");
        
    }
    
}
