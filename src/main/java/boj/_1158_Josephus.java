package boj;

import java.util.ArrayDeque;
import java.util.Deque;
import java.util.Scanner;

// 백준
// 1158 요세푸스
// https://www.acmicpc.net/problem/1158
// 유형 : 구현, 자료구조

public class _1158_Josephus {
    public static void main(String[] args) {
        Scanner sc = new Scanner(System.in);
        int n = sc.nextInt();
        int k = sc.nextInt();

        Deque<Integer> q = new ArrayDeque<>();
        for (int i = 1; i < n+1; i++) {
            q.addLast(i);
        }

        StringBuilder sb = new StringBuilder();
        sb.append('<');

        while(!q.isEmpty()) {
            for (int i = 0; i < k - 1; i++) {
                q.addLast(q.removeFirst());
            }
            sb.append(q.removeFirst());
            if(!q.isEmpty()) sb.append(", ");
        }

        sb.append('>');
        System.out.println(sb.toString());
    }
}
