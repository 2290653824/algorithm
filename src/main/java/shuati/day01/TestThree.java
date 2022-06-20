package shuati.day01;

/**
 * 给定一个非负整数num
 * 再不使用循环的情况下，返回>=num,并且离num最近，2的某次放
 */
public class TestThree {

    public static void main(String[] args) {
        TestThree testThree = new TestThree();
        System.out.println(testThree.getMin(-2));
    }

    public int getMin(int x){
        x--;
        x|=x>>>1;
        x|=x>>>2;
        x|=x>>>4;
        x|=x>>>8;
        x|=x>>>16;

        return x<0?1:x+1;
    }
}



