import java.io.File;
import java.io.IOException;
import java.util.*;
public class Task01 {
 public static boolean check[];
 public static int timeStart[];
 public static int timeEnd[];

    public static void main (String[]args){
        
        File file1 = new File ("E:\\CSE221 (Lab)\\LAB ANS\\BRACUCSE221-master\\LAB 04\\graph.txt");
        Scanner sc = null;
        try{
            sc = new Scanner(file1);
        }
        
        catch(IOException e){
            System.out.println("File not found");
        }

        int w = sc.nextInt() + 1;
        int[][] graph = new int[w][w];
        check = new boolean [w];
        timeStart = new int [w];
        timeEnd = new int [w];

        while(sc.hasNextInt()){
            int p = sc.nextInt();
            int q = sc.nextInt();
            graph[p][q] = 1;
        }

         System.out.println("Adjacency List");
        
         for(int j = 0 ; j < graph.length ; j++){
          check[j] = false;
            System.out.print(j+ " ");
            for(int k = 0 ; k< graph.length ; k++){
                System.out.print(graph[j][k]+ " ");
            }
            System.out.println();
        }
        System.out.println("\nDiscoverd Nodes:");
        dfsVisit(graph , 1);
        
    }

     public static void dfsVisit(int[][] graph, int source){
      System.out.print(source+" ");
      timeStart[source]++;
      for(int i = 0 ; i < graph.length ; i++){
       if(graph[source][i] == 1 && check[i] == false){
        check[i] = true;
        dfsVisit(graph, i);
       }
      }
      timeEnd[source]++;
    }

}