package Simple;
//Step1.��¼��Ԫ�ظ���num
//Step2.����size=1000�����鲢��ʼ��Ϊ0��
//      for i:0~num��¼�����ݲ��ڶ�Ӧλ�ô����1
//step3.for i:0~1001,���ݲ�Ϊ0ʱ�����Ӧλ��
import java.util.*;
public class RandomSort {
    public static void main(String args){
        Scanner sc = new Scanner(System.in);
        while(sc.hasNext()){
            //Step1.��¼��Ԫ�ظ���num
            int num = sc.nextInt();
            //Step2.����size=1001�����鲢��ʼ��Ϊ0��
            int[] arr = new int[1001];
            //for i:0~num��¼�����ݲ��ڶ�Ӧλ�ô����1
            for(int i=0;i<num;i++){
                int data = sc.nextInt();
                arr[data] = 1;
            }
            //step3.for i:0~1001,���ݲ�Ϊ0ʱ�����Ӧλ��
            for(int i=0;i<1001;i++)
                if(arr[i]==1)
                    System.out.println(i);
        }
        sc.close();
    }
}