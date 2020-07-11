// 本题为考试单行多行输入输出规范示例，无需提交，不计分。
import java.util.Scanner;
public class Main2 {
    public static void main(String[] args) {
        String outcome;
        Scanner in = new Scanner(System.in);
        int n = in.nextInt();
        String[] num = new String[n];
        if(n==1)
            num[0] = "1";
            //统计上一行不相邻不同元素出现次数times;
        else if(n==2){
            num[0] = "1";
            num[1] = "11";
        }else{

            num[0] = "1";
            num[1] = "11";
            for(int i = 2;i<n;i++){
                int times = 1;
                String lastLine = num[i-1];
                //int len = lastLine.length();
                for(int j = 1;j<lastLine.length();j++)
                    if(lastLine.charAt(j)!=lastLine.charAt(j-1))
                        times++;
                //本行的长度为2*times;
                String[] ch = new String[2*times];
                int nn =0;
                for(int k=1;k<=times;k++){
                    int pos = 0 ;
                    for(int j = pos+1;j<lastLine.length();j++){
                        int count = 1;
                        if(lastLine.charAt(j)==lastLine.charAt(pos)){
                            break;
                        }else{
                            count++;
                            pos++;
                        }
                        nn=count;
                    }
                    ch[2*(times-1)] = nn+"";

                    ch[(2*(times-1)+1)] = String.valueOf(num[i-1].charAt(pos));

                }
                System.out.println(ch[2*(times-1)] );
                System.out.println(ch[(2*(times-1)+1)] );
                num[i] = ch.toString();
            }
        }
        //System.out.println(nums[n-1]);
        System.out.println(num[n-1].trim());
    }
}