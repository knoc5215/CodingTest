package boj;

import java.io.BufferedReader;
import java.io.IOException;
import java.io.InputStreamReader;
import java.util.ArrayList;
import java.util.List;
import java.util.StringTokenizer;

public class p7568 {
    public static void main(String[] args) throws IOException {
        BufferedReader br = new BufferedReader(new InputStreamReader(System.in));
        int N = Integer.parseInt(br.readLine());

        List<Person> list = new ArrayList<>();
        StringTokenizer st;
        for (int i = 0; i < N; i++) {
            st = new StringTokenizer(br.readLine());
            int weight = Integer.parseInt(st.nextToken());
            int height = Integer.parseInt(st.nextToken());
            Person person = new Person(weight, height, 0);
            list.add(person);
        }


        for (int i = 0; i < N; i++) {
            Person p1 = list.get(i);
            int rank = 1;
            for (int j = 0; j < N; j++) {
                if (i == j) continue;
                Person p2 = list.get(j);
                if (p1.height < p2.height && p1.weight < p2.weight) {
                    rank++;
                }
            }
            p1.setRank(rank);
        }

        for (int i = 0; i < N; i++) {
            System.out.print(list.get(i).getRank() + " ");
        }

    }

    public static boolean isBig(Person p1, Person p2) {
        return p1.weight < p2.weight && p1.height < p2.height;
    }

    static class Person {
        int weight, height;
        int rank;

        public Person(int weight, int height, int rank) {
            this.weight = weight;
            this.height = height;
            this.rank = rank;
        }

        public int getRank() {
            return rank;
        }

        public void setRank(int rank) {
            this.rank = rank;
        }
    }

}
