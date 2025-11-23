package hackerrank;
// 해커랭크
// Java Priority Queue
// 유형 : 자료구조
// https://www.hackerrank.com/challenges/java-priority-queue/
import java.util.ArrayList;
import java.util.List;
import java.util.Scanner;
import java.util.PriorityQueue;
public class java_priority_queue {

    public static class Student {
        private int id;
        private String name;
        private double cgpa;

        Student(int id, String name, double cgpa) {
            this.id = id;
            this.name = name;
            this.cgpa = cgpa;
        }

        int getId() {
            return id;
        }

        String getName() {
            return name;
        }

        double getCGPA() {
            return cgpa;
        }

    }

    public static class Priorities {

        public List<Student> getStudents(List<String> events) {
            PriorityQueue<Student> studentsQueue = new PriorityQueue<>(
                    (s1, s2) -> {
                        //
                        int cg = Double.compare(s2.getCGPA(), s1.getCGPA());
                        if (cg != 0) return cg;

                        //
                        int name = s1.getName().compareTo(s2.getName());
                        if (name != 0) return name;

                        //
                        return Integer.compare(s1.getId(), s2.getId());
                    });

            for(String event : events) {
                if(!event.equals("SERVED")) {
                    String[] infos = event.split(" ");
                    String name = infos[1];
                    double cgpa = Double.parseDouble(infos[2]);
                    int id = Integer.parseInt(infos[3]);

                    studentsQueue.add(new Student(id, name, cgpa));
                } else {
                    studentsQueue.poll();
                }
            }

            ArrayList<Student> list = new ArrayList<>();
            while (!studentsQueue.isEmpty()) {
                list.add(studentsQueue.poll());  //
            }
            return list;

        }
    }


    public class Solution {
        private final static Scanner scan = new Scanner(System.in);
        private final static Priorities priorities = new Priorities();

        public static void main(String[] args) {
            int totalEvents = Integer.parseInt(scan.nextLine());
            List<String> events = new ArrayList<>();

            while (totalEvents-- != 0) {
                String event = scan.nextLine();
                events.add(event);
            }

            List<Student> students = priorities.getStudents(events);

            if (students.isEmpty()) {
                System.out.println("EMPTY");
            } else {
                for (Student st: students) {
                    System.out.println(st.getName());
                }
            }
        }
    }

}
