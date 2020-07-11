package Backtracking;

import java.util.Scanner;

/**������������
 * m��n�о���matrix��������ֻ�����������ƶ������ƶ��ĸ�������λ���� <= k(����̨����)�����������ൽ����ٸ��ӣ�
 * ��˼·������
 * �ӵ�һ�е�һ��ʼ�ߣ����λ���� > 18���ͻ��ݵ���һλ��
 * �����ȴ�Boolean�������ݣ�����count����
 * */
public class RobotMoving {
    public static void main(String[] args) {
        while (true){
            System.out.print("�������");
            int m=new Scanner(System.in).nextInt();
            System.out.print("�������");
            int n=new Scanner(System.in).nextInt();
            int[][] matrix = new int[m][n];
            System.out.println("������k��");
            int k = new Scanner(System.in).nextInt();
            System.out.println(findNums(matrix,k,m,n));
        }

    }

    private static int findNums(int[][] matrix, int k,int m,int n) {
        if (matrix==null||k<0||m<=0||n<=0)
            return 0;
        boolean[][] visited = getAssistance(matrix);
        return Count(matrix,visited,m,n,k,0,0);
    }

    private static int Count(int[][] matrix, boolean[][] visited, int m, int n,int k, int row, int col) {
        int count = 0;
        if ((getDigitSum(row)+getDigitSum(col))<=k
                &&row<m&&row>=0&&col<n&&col>=0
        &&!visited[row][col]){//���Լ�������
            visited[row][col] = true;
            System.out.println(row+","+col);
            count = 1 + Count(matrix,visited,m,n,k,row+1,col)
                    + Count(matrix,visited,m,n,k,row,col+1)
                    + Count(matrix,visited,m,n,k,row-1,col)
                    + Count(matrix,visited,m,n,k,row,col-1);
        }
        return count;
    }

    private static int getDigitSum(int num) {
        int sum=0;
        while (num>0){
            sum += num%10;
            num /= 10;
        }
        return sum;
    }


    private static boolean[][] getAssistance(int[][] matrix) {
        boolean[][] visited = new boolean[matrix.length][matrix[0].length];
        for (int i = 0; i < visited.length; i++) {
            for (int j = 0; j < visited[0].length; j++) {
                visited[i][j] = false;
            }
        }
        return visited;
    }
}
