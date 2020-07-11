package Simple;

import java.util.*;
public class H2D {
    public static void main(String[] args){
        Scanner sc = new Scanner(System.in);
        while(sc.hasNext()){
            String str = sc.nextLine();
            String num = str.substring(2,str.length());
            int Decimal = 0;
            for(int i=0;i<num.length();i++){
                Decimal = Decimal*16 + H2D(num.charAt(i));
            }
            System.out.println(Decimal);
        }
        sc.close();

    }

    public static int H2D(char i){
        if (i>='A'&&i<='F')
            return 10+i-'A';
        else
            return i-'0';
    }
}