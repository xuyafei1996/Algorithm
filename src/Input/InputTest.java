package Input;

import java.util.*;

public class InputTest {
    public static void main(String[] args) {
//        input1();
        input2();
    }



    //录入以空格/逗号/"->"为分界的序列
    private static void input1() {
        Scanner sc = new Scanner(System.in);
        String[] str = sc.nextLine().split("->");
        int[] nums = new int[str.length];
        for (int i = 0; i < str.length; i++)
            nums[i] = Integer.parseInt(str[i]);
        for (int i = 0; i < nums.length; i++)
            System.out.println(nums[i]);
    }

    //录入N行数据，每行单词用空格隔开，输出N行数据，每行结果为该行单词数
    private static void input2() {
        Scanner scanner = new Scanner(System.in);
        while (true) {
            String nextLine = scanner.nextLine();
            if (nextLine == null || nextLine.trim().length() == 0) {
                System.out.println("empty, break.");
                break;
            }
            System.out.println(nextLine);
        }

//        String s;
//        String[] s_array;
//        Queue<Integer> queue = new LinkedList<>();
//        Set s_set =new HashSet<>();
//        Scanner sc=new Scanner(System.in);
//        while (sc.hasNext()) {
//            if (sc.nextLine()==""||sc.nextLine()==null||sc.nextLine().trim().length()==0)
//                break;
//            String[] str = sc.nextLine().split(" ");//录入该行所有单词
//            queue.add(str.length);
//        }
//        for (int i = 0; i < queue.size(); i++) {
//            System.out.println(queue.remove());
//        }
    }
}
