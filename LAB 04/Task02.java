import java.io.File;
import java.io.IOException;
import java.util.*;
public class Task02 {

	public static boolean check[];
	public static int timeStart[];
	public static int timeEnd[];
    public static int sortArray[];
    public static int x;
    public static int time = 0;

    public static void main (String[]args){
        
        File file1 = new File ("graph.txt");
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
        sortArray = new int [w];
        x = w-1;

        while(sc.hasNextInt()){
            int p = sc.nextInt();
            int q = sc.nextInt();
            graph[p][q] = 1;
        }

         System.out.println("Adjacency Matrix");
         System.out.print("  ");
         for(int k = 0 ; k<graph.length ; k++){
            System.out.print(k+" ");
        }
        System.out.println();
        
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
        System.out.println();
        String s = "";
        System.out.print("\nAfter Topological Sort: Nodes: ");
        for(int i = 1 ; i < graph.length-1 ; i++){
            System.out.print(sortArray[i] + " -> ");
            s = s + timeEnd[sortArray[i]]+ " ";
        }
        System.out.println(sortArray[graph.length-1]);
        s = s + timeEnd[sortArray[graph.length-1]]+ " ";
        System.out.println("Finish Times: " + s);
        
    }

     public static void dfsVisit(int[][] graph, int source){
     	System.out.print(source+" ");
     	timeStart[source] = ++time;
     	for(int i = 0 ; i < graph.length ; i++){
     		if(graph[source][i] == 1 && check[i] == false){
     			check[i] = true;
     			dfsVisit(graph, i);
     		}
     	}
        sortArray[x] = source;
        x--;
     	timeEnd[source] = ++time;
    }

}