/*
 * To change this license header, choose License Headers in Project Properties.
 * To change this template file, choose Tools | Templates
 * and open the template in the editor.
 */
//
package LAB07;

/**
 *

 */
import java.util.*;
import java.io.*;

public class Knap {

    public String filepath;
    public Scanner sc;
    public int testcases;
    public int count = 0;
    public int p1;
    public int p2;
    public int min;
    public int coin;

    public Knap(String s) throws Exception {
        this.filepath = s;
        File f = new File(s);
        sc = new Scanner(f);
        testcases = sc.nextInt();
        System.out.println(testcases+" testcases.");
    }

    public int[] getArray() {
        int l = sc.nextInt();
        int c[] = new int[l];
        for (int i = 0; i < c.length; i++) {
            c[i] = sc.nextInt();
        }
        return c;
    }

    public void knapsack(int W, int wt[], int val[], int n) {
        int i, w;
        int V[][] = new int[n + 1][W + 1];
        for (i = 0; i <= n; i++) {
            for (w = 0; w <= W; w++) {
                if (i == 0 || w == 0) {
                    V[i][w] = 0;
                } else if (wt[i - 1] <= w) {
                    V[i][w] = max(val[i - 1] + V[i - 1][w - wt[i - 1]], V[i - 1][w]);
                    //System.out.println(val[i-1]);
                } else {
                    V[i][w] = V[i - 1][w];
                }
            }
        }
        int R = V[n][W];
        System.out.println(R);
        w = W;
        for (i = n; i > 0 && R > 0; i--) {
            if (R != V[i - 1][w]) {
                System.out.println(wt[i - 1]);
                R = R - val[i - 1];
                w = w - wt[i - 1];
            }
        }
    }

    public int max(int a, int b) {
        if (a >= b) {
            return a;
        } else {
            return b;
        }
    }

    public void divide() {
        System.out.println();
        int k = 0;
        int c[] = getArray();
        int n = summation(c) / 2;
        int[] arr = coin(n, c);
        System.out.print("P1 :");
        ArrayList p = distribute(arr, c, n);
        count++;
        System.out.print("\nP2 :");
        int i = 0;
        while (k < c.length) {
            if (!p.contains(k)) {
                System.out.print(" " + c[k]);
                p2 += c[k];
            }
            k++;
        }
        int d = Math.abs(p1 - p2);
        System.out.println("\nDifference :" + d);
        if (count < testcases) {
            divide();
        }
    }

    public int summation(int a[]) {
        int sum = 0;
        for (int i = 0; i < a.length; i++) {
            sum += a[i];
        }
        return sum;
    }

    public int[] coin(int n, int[] c) {
        int m[] = new int[n + 1];
        int s[] = new int[n + 1];
        int d[] = new int[c.length];
        m[0] = 0;
        for (int p = 1; p < n + 1; p++) {
            min = Integer.MAX_VALUE;
            for (int i = 1; i < c.length; i++) {
                if (c[i] <= p && 1 + m[p - c[i]] < min) {
                    min = 1 + m[p - c[i]];
                    coin = i;
                }
            }
            m[p] = min;
            s[p] = coin;
        }
        return s;
    }

    public ArrayList distribute(int[] s, int[] c, int n) {
        ArrayList a = new ArrayList();
        int i = 0;
        while (n > 0) {
            a.add(s[n]);
            System.out.print(" " + c[s[n]]);
            p1 += c[s[n]];
            n = n - c[s[n]];
        }
        return a;
    }
}
