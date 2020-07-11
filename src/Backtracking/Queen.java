package Backtracking;
/**������������
 * 8*8���̣��������ӣ�Ҫ��ÿ�С��С�б�߾�������
 * ��˼·������
 * ���ƹ�ϵ������һ�е�һ�У��ж��Ƿ���:����������ƣ���������ݸ����⣻
 * �ݹ��������ԭ����������˼·��ͬ
 * �߽�������row=7,col=7
 * */
public class Queen {
    public static int[][] Checkerboard = new int[8][8];
    public static int count;
    public static void main(String[] args) {
        EightQueen(0);
        System.out.println("һ����"+count+"�ֽⷨ");
    }

    private static void EightQueen(int row) {
        //������ǰ�������У�����
        for(int col=0;col<8;col++){
            if(Allow(row,col)){
                Checkerboard[row][col] = 1;
                //���Ӻ������Ӻ�������ĩ�� ���ӡ���������һ�м�������
                if(row==7){
                    print();
                    count++;
                }else{
                    //�ݹ鷽���ڴˣ�
                    EightQueen(row+1);
                }
                //��ݹ�ȡ�����ӣ����������������
                //EightQueen(row+1)���Ȱ��Լ������
                Checkerboard[row][col] = 0;
            }
        }
    }

    private static void print() {
        System.out.println("��ӡ���̣�");
        for (int i = 0; i < 8; i++) {
            for (int j = 0; j < 8; j++) {
                System.out.print(Checkerboard[i][j]+" ");
            }
            System.out.println();
        }
    }

    private static boolean Allow(int row, int col) {
        boolean flag = true;
        //�ж��Ƿ���ͬһ��
        for (int i=0;i<row;i++)
            if (Checkerboard[i][col]==1)
                flag=false;
        //�ж��Ƿ���ͬһ��
        for (int j=0;j<col;j++)
            if (Checkerboard[row][j]==1)
                flag=false;
        //�ж��Ƿ���ͬһб��:����
        for (int i=row,j=col;i>=0&&j>=0;i--,j--)
            if (Checkerboard[i][j]==1)
                flag = false;
        //�ж��Ƿ���ͬһб��:����
        for (int i=row,j=col;i>=0&&j<=7;i--,j++)
            if (Checkerboard[i][j]==1)
                flag = false;
        return flag;
    }
}
