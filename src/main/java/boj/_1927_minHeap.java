package boj;

// 백준
// 1927 최소힙
// 유형 : 자료구조
// https://www.acmicpc.net/problem/1927

import java.util.PriorityQueue;
import java.util.Scanner;

public class _1927_minHeap {
    public static void main(String[] args) {
        Scanner sc = new Scanner(System.in);

        int n = sc.nextInt();
        PriorityQueue<Integer> pq = new PriorityQueue<>();

        for (int i = 0; i < n; i++) {
            int num = sc.nextInt();
            if (num == 0) {
                if(pq.isEmpty()) System.out.println(0);
                else {
                    System.out.println( pq.poll());
                }
            }
            else {
                pq.add(num);
            }
        }
    }
}
