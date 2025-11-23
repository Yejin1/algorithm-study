package boj;

// 백준
// 1927 최소힙
// 유형 : 자료구조
// https://www.acmicpc.net/problem/1927

// 힙 직접 구현해서 풀기

import java.util.PriorityQueue;
import java.util.Scanner;

public class _1927_minHeap2 {

    static class Minheap{
        int[] heap;
        int size;

        Minheap(int maxSize) {
            size = 0;
            heap = new int[maxSize+1];
        }

        public void insert(int x) {
            size++;
            heap[size] = x;
            int idx = size;

            while (idx > 1) {
                int parent = idx/2;
                if (heap[parent] > heap[idx]) {
                    swap(idx,parent);
                    idx = parent;
                } else break;
            }
        }

        public int remove() {
            if(size==0) return 0;
            int smallest = heap[1];

            heap[1] = heap[size];
            heap[size] = 0;
            size--;
            heapifyDown(1);

            return smallest;
        }

        private void heapifyDown(int ind) {
            while (true) {
                int left = ind * 2;
                int right = ind * 2 + 1;
                int smallest = ind;

                if (left <= size && heap[left] < heap[smallest]) {
                    smallest = left;
                }
                if (right <= size && heap[right] < heap[smallest]) {
                    smallest = right;
                }

                if (smallest == ind) {
                    break;
                }
                swap(ind, smallest);
                ind = smallest;
            }
        }

        private void swap(int a, int b) {
            int temp = heap[a];
            heap[a] = heap[b];
            heap[b] = temp;

        }
    }
    public static void main(String[] args) {
        Scanner sc = new Scanner(System.in);

        int n = sc.nextInt();
        Minheap mh = new Minheap(n);

        for (int i = 0; i < n; i++) {
            int num = sc.nextInt();
            if (num == 0) {
                System.out.println(mh.remove());
            }
            else {
                mh.insert(num);
            }
        }
    }
}
