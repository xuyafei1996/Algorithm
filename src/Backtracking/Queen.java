package Backtracking;
/**【问题描述】
 * 8*8棋盘，放置棋子，要求每行、列、斜线均不共线
 * 【思路分析】
 * 递推关系：放下一行第一列，判断是否共线:不共线则后移，共线则回溯父问题；
 * 递归调用树：原、子问题解决思路相同
 * 边界条件：row=7,col=7
 * */
public class Queen {
    public static int[][] Checkerboard = new int[8][8];
    public static int count;
    public static void main(String[] args) {
        EightQueen(0);
        System.out.println("一共有"+count+"种解法");
    }

    private static void EightQueen(int row) {
        //遍历当前行所有列，落子
        for(int col=0;col<8;col++){
            if(Allow(row,col)){
                Checkerboard[row][col] = 1;
                //落子后检查落子后若到了末行 则打印，否则从下一行继续落子
                if(row==7){
                    print();
                    count++;
                }else{
                    //递归方法在此！
                    EightQueen(row+1);
                }
                //★递归取消落子，自下向上清空棋盘
                //EightQueen(row+1)会先把自己的清掉
                Checkerboard[row][col] = 0;
            }
        }
    }

    private static void print() {
        System.out.println("打印棋盘：");
        for (int i = 0; i < 8; i++) {
            for (int j = 0; j < 8; j++) {
                System.out.print(Checkerboard[i][j]+" ");
            }
            System.out.println();
        }
    }

    private static boolean Allow(int row, int col) {
        boolean flag = true;
        //判断是否在同一行
        for (int i=0;i<row;i++)
            if (Checkerboard[i][col]==1)
                flag=false;
        //判断是否在同一列
        for (int j=0;j<col;j++)
            if (Checkerboard[row][j]==1)
                flag=false;
        //判断是否在同一斜线:左上
        for (int i=row,j=col;i>=0&&j>=0;i--,j--)
            if (Checkerboard[i][j]==1)
                flag = false;
        //判断是否在同一斜线:右上
        for (int i=row,j=col;i>=0&&j<=7;i--,j++)
            if (Checkerboard[i][j]==1)
                flag = false;
        return flag;
    }
}
