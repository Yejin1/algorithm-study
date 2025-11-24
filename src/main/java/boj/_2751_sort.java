package boj;
// 백준
// 2751 수 정렬하기 2
// 유형 : 정렬
// https://www.acmicpc.net/problem/2751

// 퀵 소트 메소드 구현해서 풀기

import java.io.BufferedReader;
import java.io.IOException;
import java.io.InputStreamReader;
import java.util.Arrays;

public class _2751_sort {

    static void quickSort(int[] arr, int left, int right) {
        if (left >= right) return;

        int pivot = partition(arr, left, right);
        quickSort(arr, left, pivot-1);
        quickSort(arr, pivot+1, right);

    }

    static int partition(int[] arr, int left, int right) {
        int pivot = arr[right];
        int i = left-1;

        for (int j = left; j < right; j++) {
            if(arr[j] < pivot) {
                i++;
                swap(arr,i,j);
            }
        }

        swap(arr,i+1,right);
        return i+1;
    }

    static void swap(int[] arr, int i, int j) {
        int tmp = arr[i];
        arr[i] = arr[j];
        arr[j] = tmp;
    }

    public static void main(String[] args) throws IOException {
        BufferedReader br = new BufferedReader(new InputStreamReader(System.in));
        StringBuilder sb = new StringBuilder();
        int n = Integer.parseInt(br.readLine());
        int[] arr = new int[n];

        for (int i = 0; i < n; i++) {
            arr[i] = Integer.parseInt(br.readLine());
        }

        quickSort(arr,0,n-1);

        //백준에서는 기본 메소드 써야 통과됨 (듀얼 피봇 퀵정렬)
        //Arrays.sort(arr);


        for (int i = 0; i < n; i++) {
            sb.append(arr[i]).append('\n');
        }

        System.out.println(sb);


    }
}
