//测试用例：[73, 74, 75, 71, 69, 72, 76, 73]
//输出：[1, 1, 4, 2, 1, 1, 0, 0]
import java.util.Scanner;
public class Main {
    public static void main(String[] args) {
        Scanner in = new Scanner(System.in);
        String str0 = in.nextLine();
        String str1 = str0.substring(1,str0.length()-1);
//        System.out.println(str1);
        String[] str = str1.split(", ");
        for (int i = 0; i < str.length; i++)
            str[i].trim();
        //转为Int型
        int[] nums = new int[str.length];
        for (int i = 0; i < str.length; i++)
            nums[i] = Integer.parseInt(str[i]);
        int max = -1,pos = -1;
        for (int i = 0; i < nums.length; i++) {
            if (nums[i]>max){
                pos = i;
                max = nums[i];
            }
        }
        //最大数后置0
        for (int i = pos+1;i<nums.length;i++)
            nums[i]=0;

        for (int i = 0; i <=pos; i++) {
            int big = pos;
            for (int j = pos; j >=i; j--) {
                if (nums[j]>nums[i]){
                    big = j;
                }
            }
            nums[i] = big-i;
        }

        System.out.print("[");
        for (int i = 0; i < nums.length-1; i++)
            System.out.print(nums[i]+",");
        System.out.print(nums[nums.length-1]+"]");
    }
}