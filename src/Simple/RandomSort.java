package Simple;
//Step1.先录入元素个数num
//Step2.创建size=1000的数组并初始化为0，
//      for i:0~num，录入数据并在对应位置处标记1
//step3.for i:0~1001,数据不为0时输出对应位序
import java.util.*;
public class RandomSort {
    public static void main(String args){
        Scanner sc = new Scanner(System.in);
        while(sc.hasNext()){
            //Step1.先录入元素个数num
            int num = sc.nextInt();
            //Step2.创建size=1001的数组并初始化为0，
            int[] arr = new int[1001];
            //for i:0~num，录入数据并在对应位置处标记1
            for(int i=0;i<num;i++){
                int data = sc.nextInt();
                arr[data] = 1;
            }
            //step3.for i:0~1001,数据不为0时输出对应位序
            for(int i=0;i<1001;i++)
                if(arr[i]==1)
                    System.out.println(i);
        }
        sc.close();
    }
}