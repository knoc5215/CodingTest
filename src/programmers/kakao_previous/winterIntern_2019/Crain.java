package programmers.kakao_previous.winterIntern_2019;

import java.util.Stack;

public class Crain {
    public static void main(String[] args) {
        int[][] board = {
                {0, 0, 0, 0, 0},
                {0, 0, 1, 0, 3},
                {0, 2, 5, 0, 1},
                {4, 2, 4, 4, 2},
                {3, 5, 1, 3, 1}
        };

        int[] moves = {1, 5, 3, 5, 1, 2, 1, 4};

        int answer = solution(board, moves);
        System.out.println(answer);
    }

    //크레인을 모두 작동시킨 후 터트려져 사라진 인형의 개수를 return 하도록 solution 함수를 완성해주세요.
    public static int solution(int[][] board, int[] moves) {
        int answer = 0;

        int row = board.length;
        Stack<Integer> stack = new Stack<>();   //뽑기스택

        for (int move : moves) {
            int c = move - 1;
            for (int r = 0; r < row; r++) {
                if (board[r][c] > 0) {  // 인형이 있다면
                    int pick = board[r][c]; // 뽑기
                    board[r][c] = 0;    // 뽑았으니 비어있다
                    if (stack.size() > 0) {
                        int top = stack.peek(); // 맨위에
                        if (top == pick) {   // 2개 겹치면
                            stack.pop();
                            answer += 2;
                        } else {
                            stack.push(pick);
                        }
                    } else {
                        stack.push(pick);
                    }
                    break;  // 다음 moves
                }
            }
        }
        return answer;
    }
}
