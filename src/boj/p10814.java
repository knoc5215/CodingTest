package boj;

import java.io.BufferedReader;
import java.io.IOException;
import java.io.InputStreamReader;
import java.util.ArrayList;
import java.util.List;
import java.util.StringTokenizer;

public class p10814 {
    public static void main(String[] args) throws IOException {
        BufferedReader br = new BufferedReader(new InputStreamReader(System.in));
        int n = Integer.parseInt(br.readLine());
        List<Person> people = new ArrayList<>();
        int idx = 0;
        while (n-- > 0) {
            String input = br.readLine();
            StringTokenizer st = new StringTokenizer(input);
            int age = Integer.parseInt(st.nextToken());
            String name = st.nextToken();
            people.add(new Person(age, idx++, name));
        }

        people.sort((o1, o2) -> {
            if (o1.age == o2.age) {
                return o1.idx - o2.idx;
            } else {
                return o1.age - o2.age;
            }
        });

        for (Person p : people)
            System.out.println(p.age + " " + p.name);
    }

    static class Person {
        int age;
        int idx;
        String name;

        public Person(int age, int idx, String name) {
            this.age = age;
            this.idx = idx;
            this.name = name;
        }
    }
}
