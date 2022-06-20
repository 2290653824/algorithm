package shuati.day01;

import java.io.File;
import java.util.LinkedList;

/**
 * 给定一个文件目录，写出一个函数统计这个目录下所
 * 有文件的文件数量并返回隐藏文件也算，但是文件夹不算
 */
public class TestTwo {

    public static void main(String[] args) {
        TestTwo testTwo = new TestTwo();
        System.out.println(testTwo.solution("D:\\小孟资源"));
    }

    public int solution(String filePath){
        File file = new File(filePath);
        LinkedList<File>  list= new LinkedList<>();
        int count=0;
        list.add(file);
        while(!list.isEmpty()){
            File f = list.pop();
            File[] files = f.listFiles();
            if(files==null){
                continue;
            }
            for (File file1 : files) {
                if(file1.isFile()){
                    count++;
                }else{
                    list.push(file1);
                }
            }


        }

        return count;
    }
}



