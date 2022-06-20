package shuati.day01;

/**
 * 一个数组中只有两种字符G，B
 * 想要所有的G都放在左侧，所有的B都放在右侧
 * 但是只能在相邻字符之间进行交换操作
 * 返回至少需要交换几次
 *
 * 双指针，O(N)
 */

//gbgbgbbbggg
public class TestTour {

    public static void main(String[] args) {
        System.out.println(TestTour.Solution("GGBGBG"));

    }


    public static int Solution(String s){
        if(s==null||s.length()==0){
            return 0;
        }

        int left=0,right=0;
        int max=0;
        for(;right<s.length();right++){
            if(s.charAt(right)=='G'){
                max+=(right-left);
                left++;
            }
        }

        return max;
    }
}

