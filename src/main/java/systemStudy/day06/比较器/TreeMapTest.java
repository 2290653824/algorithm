package systemStudy.day06.比较器;

import java.util.TreeMap;

/**
 * 在TreeMap中，key是有序的，当key为基本数据类型的包装类型时，就会按照基本数据类型的比较方法进行排序。
 * 如果key是一个引用对象，我们就必须传入一个比较器Comparator，指定一个比较规则才行。另外如果比较器返回为0，即判断两个key是相同的，ktreemap就会舍弃后一个
 * 添加的key，这一点一定要注意。
 */
public class TreeMapTest {


    private static TreeMap<Student,String> treeMap=new TreeMap<>(new Student.idSheng());



    public static void main(String[] args) {
        Student s1 = new Student(1, "A", 11);
        Student s2 = new Student(6, "B", 12);
        Student s3 = new Student(3, "C", 13);
        Student s4 = new Student(2, "D", 14);
        Student s5 = new Student(7, "E", 15);
        Student s6 = new Student(0, "F", 16);



        treeMap.put(s1,"A");
        treeMap.put(s2,"B");
        treeMap.put(s3,"C");
        treeMap.put(s4,"D");
        treeMap.put(s5,"E");
        treeMap.put(s6,"F");

        treeMap.forEach((s,g)->{
            System.out.println(s);
            System.out.println(g);
        });

//        for(Student s: treeMap.keySet()){
//            System.out.println(s);
//        }
//        treeMap.put(s1,"A");
    }
}
