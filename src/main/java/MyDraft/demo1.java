package MyDraft;

public class demo1 {
    public static void main(String[] args) {
        Product2.instance.show();
    }

}

/**
 * 饿汉式
 */
class Product{

    private static Product instance=new Product();



    private Product(){

    }

    public static Product getInstance(){
        return instance;
    }

}

/**
 * 双重检验锁
 */
class Product1{

    private static volatile Product1 instance;

    private Product1(){

    }

    public static Product1 getInstance(){
        if(instance==null){
            synchronized (Product1.class){
                if(instance==null){
                    instance=new Product1();
                }
            }
        }
        return instance;
    }
}

/**
 * 枚举类
 */
enum Product2{
    instance;

    public void show (){
        System.out.println("haha");
    }
}


