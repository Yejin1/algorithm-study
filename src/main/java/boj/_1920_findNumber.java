package boj;
// 백준
// 1920 수 찾기
// 유형 : 탐색
// https://www.acmicpc.net/problem/1920

// 정렬 후 이분탐색으로 찾기

import java.io.BufferedReader;
import java.io.IOException;
import java.io.InputStreamReader;
import java.util.Arrays;

public class _1920_findNumber {

    static boolean binarySearch(int[] arr, int t) {
        int left = 0;
        int right = arr.length - 1;

        while (left <= right) {
            int mid = (left + right) / 2;

            if(arr[mid]==t) return true;
            else if(arr[mid]<t) left = mid+1;
            else if(arr[mid]>t) right = mid-1;
        }

        return false;
    }

    public static void main(String[] args) throws IOException {
        BufferedReader br = new BufferedReader(new InputStreamReader(System.in));
        StringBuilder sb = new StringBuilder();

        int n = Integer.parseInt(br.readLine());
        int[] a = new int[n];

        String[] as = br.readLine().split(" ");

        for (int i = 0; i < n; i++) {
            a[i] = Integer.parseInt(as[i]);
        }

        Arrays.sort(a);

        int m = Integer.parseInt(br.readLine());

        String[] bs = br.readLine().split(" ");

        for (int i = 0; i < m; i++) {
            int target = Integer.parseInt(bs[i]);
            if(binarySearch(a,target)) sb.append('1').append('\n');
            else sb.append('0').append('\n');
        }

        System.out.println(sb);

    }
}
