package systemStudy.day06.比较器;

import java.util.ArrayList;
import java.util.Comparator;

public class Student {
    @Override
    public String toString() {
        return "Student{" +
                "id=" + id +
                ", name='" + name + '\'' +
                ", age=" + age +
                '}';
    }

    private int id;

    private String name;

    private int age;

    public static class idSheng implements Comparator<Student> {


        @Override
        public int compare(Student o1, Student o2) {
            return o2.id-o1.id;
        }
    }

    public static void main(String[] args) {
        Student s1 = new Student(1, "A", 11);
        Student s2 = new Student(6, "B", 12);
        Student s3 = new Student(3, "C", 13);
        Student s4 = new Student(2, "D", 14);
        Student s5 = new Student(7, "E", 15);
        Student s6 = new Student(0, "F", 16);

        ArrayList<Student> students = new ArrayList<>();
        students.add(s1);
        students.add(s2);
        students.add(s3);
        students.add(s4);
        students.add(s5);
        students.add(s6);

        students.sort(new idSheng());

        System.out.println(students);
    }



    public int getId() {
        return id;
    }

    public void setId(int id) {
        this.id = id;
    }

    public String getName() {
        return name;
    }

    public void setName(String name) {
        this.name = name;
    }

    public int getAge() {
        return age;
    }

    public void setAge(int age) {
        this.age = age;
    }

    public Student() {
    }

    public Student(int id, String name, int age) {
        this.id = id;
        this.name = name;
        this.age = age;
    }
}
