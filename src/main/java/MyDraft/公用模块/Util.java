package MyDraft.公用模块;

public class 对数器 {


}

class Util{
    public static int[] getRandomArr(int maxLength,int maxValue){
        int len=(int)(Math.random()*maxLength);
        int[] arr=new int[len];
        for (int i = 0; i < arr.length; i++) {
            arr[i]=(int)(Math.random() * maxValue);
        }
        return arr;

    }
}


