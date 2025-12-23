package boj;

// 백준
// 2470 두 용액
// 유형 : 투포인터
// https://www.acmicpc.net/problem/2470

// 복습

import java.io.BufferedReader;
import java.io.IOException;
import java.io.InputStreamReader;
import java.util.Arrays;

public class _2470_twoLiquid_2 {
    public static void main(String[] args) throws IOException {
        BufferedReader bf = new BufferedReader(new InputStreamReader(System.in));
        int n = Integer.parseInt(bf.readLine());
        int[] liquids = new int[n];
        int[] two = new int[2];
        int min_sum = Integer.MAX_VALUE;

        String[] tmp = bf.readLine().split(" ");


        for (int i = 0; i < n; i++) {
            liquids[i] = Integer.parseInt(tmp[i]);
        }

        Arrays.sort(liquids);
        int left = 0;
        int right = n - 1;

        while (left < right) {
            int sum = liquids[left] + liquids[right];
            int abs = Math.abs(sum);

            if (abs < min_sum) {
                two[0] = liquids[left];
                two[1] = liquids[right];
                min_sum = abs;
                if (abs == 0) {
                    break;
                }
            }

            if(sum < 0) left++;
            if(sum > 0) right--;
        }

        System.out.print(two[0]);
        System.out.print(" ");
        System.out.print(two[1]);
    }
}
