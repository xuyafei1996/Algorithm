package Simple;

public class RaidxConvertor {
    public static void main(String[] args) {
        System.out.println(H2D(20+""));
    }

    //十六进制转十进制:累加法
    private static String H2D(String str) {
        Long Decimal = 0l;
        for (int i = 0; i < str.length(); i++)
            Decimal = Decimal*16 + H2D(str.charAt(i));
        return Decimal+"";
    }
    private static long H2D(char i) {
        if (i>='A'&&i<='F')
            return 10+i-'A';
        else
            return i-'0';
    }
    //八进制转十进制：累加法
    private static String O2D(String str){
        Long Decimal = 0l;
        for (int i = 0; i < str.length(); i++)
            Decimal = Decimal*8 + Integer.parseInt(str,str.charAt(i));
        return Decimal+"";
    }
    //二进制转十进制：累加法
    private static String B2D(String str){
        StringBuffer buf = new StringBuffer();
        Long Decimal = 0l;
        for (int i = 0; i < str.length(); i++)
            Decimal = Decimal*2 + Integer.parseInt(str,str.charAt(i));
        return Decimal+"";
    }

    //十六进制转二进制:一位转四位
    private static String H2B(String str){
        StringBuffer buf = new StringBuffer();
        for (int i = 0; i < str.length(); i++) {
            switch (str.charAt(i)){
                case '0':buf.append("0000");break;
                case '1':buf.append("0001");break;
                case '2':buf.append("0010");break;
                case '3':buf.append("0011");break;
                case '4':buf.append("0100");break;
                case '5':buf.append("0101");break;
                case '6':buf.append("0110");break;
                case '7':buf.append("0111");break;
                case '8':buf.append("1000");break;
                case '9':buf.append("1001");break;
                case 'A':buf.append("1010");break;
                case 'B':buf.append("1011");break;
                case 'C':buf.append("1100");break;
                case 'D':buf.append("1101");break;
                case 'E':buf.append("1110");break;
                case 'F':buf.append("1111");break;
                default:break;
            }
        }
        return buf.toString();
    }
    //十进制转二进制:对2取余
    private static String D2B(String str){
        int num = Integer.parseInt(str);
        if (num==0){
            return "0";
        }else {
            StringBuffer buf = new StringBuffer();
            while (num!=0){
                int remainder = num%2;
                buf.append((char)remainder+'0');
                num /=2;
            }
            //逆置buf
            return buf.reverse().toString();
        }
    }
    //八进制转二进制：一位转三位
    private static String O2B(String str){
        StringBuffer buf = new StringBuffer();
        for (int i = 0; i < str.length(); i++) {
            switch (str.charAt(i)){
                case '0':buf.append("000");break;
                case '1':buf.append("001");break;
                case '2':buf.append("010");break;
                case '3':buf.append("011");break;
                case '4':buf.append("100");break;
                case '5':buf.append("101");break;
                case '6':buf.append("110");break;
                case '7':buf.append("111");break;
                default:break;
            }
        }
        return buf.toString();
    }

    //十进制转十六进制:对16取余
    private static String D2H(String str){
        int num = Integer.parseInt(str);
        if (num==0){
            return "0";
        }else {
            StringBuffer buf = new StringBuffer();
            while (num!=0){
                int remainder = num%16;
                if (remainder>=0&&remainder<=9)
                    buf.append((char)remainder+'0');
                else
                    buf.append((char)remainder-10+'A');
                num /=16;
            }
            //逆置buf
            return buf.reverse().toString();
        }
    }
    //八进制转十六进制：O2B——>B2H
    //二进制转十六进制：四位聚一位
    private static String B2H(String str){
        StringBuffer buf = new StringBuffer();
        //去高位的0
        if (str.subSequence(0,4).equals("0000"))
            str = str.substring(4,str.length());
        //补0
        if(str.length()%4==1)
            str = "000"+str;
        else if (str.length()%4==2)
            str = "00"+str;
        else if (str.length()%4==3)
            str = "0"+str;
        //每4位截取
        for (int i = 0; i < str.length()-3; i+=4) {
            switch (str.substring(i,i+4)){
                case"0000":buf.append("0");break;
                case"0001":buf.append("1");break;
                case"0010":buf.append("2");break;
                case"0011":buf.append("3");break;
                case"0100":buf.append("4");break;
                case"0101":buf.append("5");break;
                case"0110":buf.append("6");break;
                case"0111":buf.append("7");break;
                case"1000":buf.append("8");break;
                case"1001":buf.append("9");break;
                case"1010":buf.append("A");break;
                case"1011":buf.append("B");break;
                case"1100":buf.append("C");break;
                case"1101":buf.append("D");break;
                case"1110":buf.append("E");break;
                case"1111":buf.append("F");break;
                default:break;
            }
        }
        return buf.toString();
    }

    //十进制转八进制:对8取余
    private static String D2O(String str){
        int num = Integer.parseInt(str);
        if (num==0){
            return "0";
        }else {
            StringBuffer buf = new StringBuffer();
            while (num!=0){
                int remainder = num%8;
                buf.append((char)remainder+'0');
                num /=8;
            }
            //逆置buf
            return buf.reverse().toString();
        }
    }
    //二进制转八进制：三位聚一位
    private static String B2O(String str){
        StringBuffer buf = new StringBuffer();
        //去高位的0
        if (str.subSequence(0,3).equals("000"))
            str = str.substring(3,str.length());
        //补0
        if(str.length()%3==1)
            str = "00"+str;
        else if (str.length()%3==2)
            str = "0"+str;
        //每3位截取
        for (int i = 0; i < str.length()-2; i+=3) {
            switch (str.substring(i,i+3)){
                case"000":buf.append("0");break;
                case"001":buf.append("1");break;
                case"010":buf.append("2");break;
                case"011":buf.append("3");break;
                case"100":buf.append("4");break;
                case"101":buf.append("5");break;
                case"110":buf.append("6");break;
                case"111":buf.append("7");break;
                default:break;
            }
        }
        return buf.toString();
    }
    //十六进制转八进制：H2B → B2O
}
