package boj;

import java.util.ArrayList;
import java.util.Scanner;

public class p1927 {
    public static void main(String[] args) {
        Scanner sc = new Scanner(System.in);
        int N = sc.nextInt();
        MinHeap heap = new MinHeap();
        while (N-- > 0) {
            int method = sc.nextInt();

            if (method == 0) {
                System.out.println(heap.delete());
            } else {
                heap.insert(method);
            }
        }
    }

    static class MinHeap {
        private final ArrayList<Integer> heap;

        public MinHeap() {
            heap = new ArrayList<>();
            heap.add(0);
        }

        public void insert(int val) {
            heap.add(val);
            int pointer = heap.size() - 1;
            while (pointer > 1 && heap.get(pointer / 2) > heap.get(pointer)) {
                int temp = heap.get(pointer / 2);
                heap.set(pointer / 2, heap.get(pointer));
                heap.set(pointer, temp);
                pointer /= 2;
            }
        }

        public int delete() {
            // 1. 힙이 비어있으면 return
            if (heap.size() - 1 < 1) {
                return 0;
            }

            // 2. root 노드를 삭제할 것임
            int deleteItem = heap.get(1);

            // 3. root에는 힙의 마지막 노드를 넣고, 마지막 노드는 비워준다.
            heap.set(1, heap.get(heap.size() - 1));
            heap.remove(heap.size() - 1);

            // 4. 루트부터 돌면서
            int pos = 1;
            while ((pos * 2) < heap.size()) {
                // 5. 왼쪽 자식 노드의 값과 인덱스를 가져온다.
                int min = heap.get(pos * 2);
                int minPos = pos * 2;

                // 6. 오른쪽 자식 노드와 비교해서 더 작은 값과 인덱스를 갱신해준다.
                if (((pos * 2 + 1) < heap.size()) && min > heap.get(pos * 2 + 1)) {
                    min = heap.get(pos * 2 + 1);
                    minPos = pos * 2 + 1;
                }

                // 7. 부모노드보다 크다면 (최소힙) 그대로 종료.
                if (heap.get(pos) < min) {
                    break;
                }

                // 8. 부모노드보다 작다면 부모와 자식을 교환한다.
                int temp = heap.get(pos);
                heap.set(pos, heap.get(minPos));
                heap.set(minPos, temp);
                pos = minPos;
            }

            return deleteItem;
        }
    }

}


