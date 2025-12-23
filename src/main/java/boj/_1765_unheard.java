package boj;
// 백준
// 1765 듣보잡
// 유형 : 자료구조 활용
// https://www.acmicpc.net/problem/1765

import java.io.BufferedReader;
import java.io.IOException;
import java.io.InputStreamReader;
import java.util.ArrayList;
import java.util.Collections;
import java.util.HashSet;
import java.util.Set;

public class _1765_unheard {
    public static void main(String[] args) throws IOException {
        BufferedReader bf = new BufferedReader(new InputStreamReader(System.in));
        String[] nm = bf.readLine().split(" ");
        int n = Integer.parseInt(nm[0]);
        int m = Integer.parseInt(nm[1]);

        Set<String> names = new HashSet<>();
        ArrayList<String> unheard = new ArrayList<>();

        for (int i = 0; i < n; i++) {
            names.add(bf.readLine());
        }

        for (int i = 0; i < m; i++) {
            String tmp = bf.readLine();
            if (names.contains(tmp)) {
                unheard.add(tmp);
            }
        }

        Collections.sort(unheard);

        System.out.println(unheard.size());
        for (String s : unheard) {
            System.out.println(s);
        }
    }
}

