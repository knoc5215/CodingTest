package boj;

import java.util.HashMap;
import java.util.Map;
import java.util.Scanner;

public class p2920 {
    public static void main(String[] args) {
        Map<Integer, Character> map = new HashMap<>();
        map.put(1, 'c');
        map.put(2, 'd');
        map.put(3, 'e');
        map.put(4, 'f');
        map.put(5, 'g');
        map.put(6, 'a');
        map.put(7, 'b');
        map.put(8, 'C');

        String ascending = "cdefgabC";
        String descending = "Cbagfedc";

        Scanner sc = new Scanner(System.in);
        StringBuilder sb = new StringBuilder();
        for (int i = 0; i < 8; i++) {
            sb.append(map.get(sc.nextInt()));
        }

        if (sb.toString().equals(ascending)) {
            System.out.println("ascending");
        } else if (sb.toString().equals(descending)) {
            System.out.println("descending");
        } else {
            System.out.println("mixed");
        }

    }
}
