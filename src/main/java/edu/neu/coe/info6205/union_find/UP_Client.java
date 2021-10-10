package edu.neu.coe.info6205.union_find;

import edu.neu.coe.info6205.graphs.BFS_and_prims.StdRandom;

import java.util.Scanner;

public class UP_Client {
    public static int count(int n){
        UF_HWQUPC ufObj = new UF_HWQUPC(n);
        int m = 0;
        while(ufObj.components()>1){
            int a= StdRandom.uniform(n),b=StdRandom.uniform(n);//Generating random numbers (a,b) with uniform distribution
            if(!ufObj.isConnected(a,b)){//checking if both the components are connected or not
                ufObj.union(a,b);//perform union if they are not connected
            }
            m++;
        }
        return m;
    }

    public static void main(String args[]){
        Scanner scan = new Scanner(System.in);//scanner class to take command line input
        System.out.print("Enter the Initial Number of Sites(n): ");
        int sites=scan.nextInt();
        int trails=25;//number of trails to be performed
        for(int i=sites;i<100000000;i+=i){//using doubling method to get the average number of pairs required to reduce the components to one
            double sum=0;
            for (int j=0;j<trails;j++){
                sum+=count(i);
            }
            System.out.println("Number of objects (n): " + i + ", Number of pairs (m) :" + sum/trails);//computing the averages of the trails
        }
    }
}