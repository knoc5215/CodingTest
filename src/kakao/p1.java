package kakao;

import java.util.ArrayList;
import java.util.List;
import java.util.Stack;

public class p1 {

    public static void main(String[] args) {
        int[][] board = {
                {0, 0, 0, 0, 0},
                {0, 0, 1, 0, 3},
                {0, 2, 5, 0, 1},
                {4, 2, 4, 4, 2},
                {3, 5, 1, 3, 1}
        };

        int[] moves = {1, 5, 3, 5, 1, 2, 1, 4};
        int ret = solution(board, moves);

        System.out.println(ret);
    }

    public static int solution(int[][] board, int[] moves) {
        int answer = 0;

        Stack<Integer> stack = new Stack<>();
        for (int i = 0; i < moves.length; i++) {
            int idx = moves[i] - 1;





            for (int row = 0; row < board.length; row++) {
                if (board[row][idx] > 0) {
                    int val = board[row][idx];
                    board[row][idx] = 0;

                    if (stack.isEmpty()) {
                        stack.add(val);
                        System.out.println("ADDED " + val);


                    } else {

                        int top = stack.peek();
                        if (top == val) {
                            stack.pop();
                            answer += 2;
                        } else {

                            stack.add(val);
                            System.out.println("ADDED " + val);


                        }


                    }
break;
                }
            }


        }

        return answer;
    }
}
