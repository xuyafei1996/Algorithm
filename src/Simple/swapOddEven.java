package Simple;

import javax.swing.*;
import java.util.Scanner;
//123
/**������������
 * ������������
 * 2,4,6,1,3,5
 * 1,2,3
 * 4,4,4,4
 * 1,1,1,3
 * -1,2,0,-22,3,6,11,-6,0,23
 * */
public class swapOddEven {
    public static void main(String[] args) {
        while (true){
            String[] str= new Scanner(System.in).nextLine().trim().split(",");
            if (str==null||str.length==0
                    ||(str.length==1&&str[0].equals("0"))||(str.length==1&&str[0].equals("")))
                break;
            int num[] = new int[str.length];
            for (int i = 0; i < str.length; i++)
                num[i] = Integer.parseInt(str[i]);
            swap(num);
            //��ӡ
            print(num);
        }
    }

    private static void print(int[] num) {
        for (int i = 0; i < num.length-1; i++)
            System.out.print(num[i]+",");
        System.out.println(num[num.length-1]);
    }

    private static int[] swap(int[] num) {
        int i=0,j=num.length-1;
        while (i<j){
            //ǰ��ָ����ƣ�ֱ��ָ��һ��ż��
            while ((i<j)&&func(num[i]))
                i++;
            while ((i<j)&&!func(num[j]))
                j--;
            if (i<j){
                int tmp = num[i];
                num[i] = num[j];
                num[j] = tmp;
                i++;j--;
            }
        }
        return num;
    }

    private static boolean func(int num) {
        return num%2!=0;//ǰ����������
//        return num%3==0;//ǰ�����ܱ�3����
//        return num<0;//ǰ�����Ǹ���
    }
}
