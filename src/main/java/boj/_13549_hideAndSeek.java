package boj;

import java.util.*;
import java.lang.*;

// 백준
// 13549 숨바꼭질3
// https://www.acmicpc.net/problem/13549
// 유형 : BFS

class _13549_hideAndSeek {
    public static void main(String[] args) {
        Scanner sc = new Scanner(System.in);
        int n = sc.nextInt();
        int k = sc.nextInt();
        int d[] = new int[100001];

        Queue<Integer> q = new LinkedList<>();



        for(int i=0; i<100001; i++) d[i] = 200000;

        q.add(n);
        d[n] = 0;

        while(!q.isEmpty()){
            int x = q.poll();

            if(x-1 >= 0){
                if(d[x-1] > d[x]+1){
                    d[x-1] = d[x] + 1;
                    q.add(x-1);
                }
            }

            if(x+1 < 100001){
                if(d[x+1] > d[x]+1){
                    d[x+1] = d[x] + 1;
                    q.add(x+1);
                }
            }

            if(2*x < 100001){
                if(d[x*2] > d[x]){
                    d[x*2] = d[x];
                    q.add(2*x);
                }
            }




        }

        System.out.println(d[k]);
    }
}