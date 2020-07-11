package Simple;

import java.util.*;

/**【问题描述】
 * 某商店规定：三个空汽水瓶可以换一瓶汽水。 小张手上有十个空汽水瓶，她最多可以换多少瓶汽水喝？
 * 【测试用例】
 * 批量录入，以0为结尾
 * */
public class Coca {
    public static void main(String[] args) {
        List list = new LinkedList();
        Scanner sc = new Scanner(System.in);
        while (true) {//千万别用while (sc.hasNext())
            int num=sc.nextInt();
            if(num==0)
                break;
            else
                list.add(num);
        }

        for (int i = 0; i < list.size(); i++) {
            int times = 0;
            int n = (int) list.get(i);
            while (n>2){
                int full = n/3;
                int empty_left = n%3;
                times+=full;
                n = full+empty_left;
            }
            if (n==2)//还剩两个空瓶时，问老板借一瓶再兑换
                times++;
            System.out.println(times);
        }

    }
}
