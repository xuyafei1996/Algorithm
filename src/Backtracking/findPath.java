package Backtracking;

import java.util.Scanner;

/**������������
 *  ����һ������matrix���ַ���str���ж�matrix�Ƿ����һ��str��·��
 *  ��˼·������
 *  �Ծ����е�ÿ����������һ��hasPath()����
 *  ����һ���ȴ�Boolean�������󣬼�¼�Ƿ���·��
 *  ��������> �ַ�ch��Ӧ��·���ϵ�i���ַ������������Ҽ����ݹ飻
 *        �ַ�����Ӧ��·���ϵ�i���ַ������ݵ���һλ�ã�
 *  ������������
 *  ���ܲ��ԣ�char[][] matrix = {{'a','b','t','g'},{'c','f','c','s'},{'j','d','e','h'}}
 *           String str = bfce ����>true
 *           String str = abfb ����>false
 *  �߽���ԣ�char[][] matrix = {{'a','b','t','g'}}
 *           String str = btg ����>true
 *           String str = atg ����>false
 *           char[][] matrix = {{'a'},{'c'},{'j'}}
 *           String str = cj ����>true
 *           String str = aj ����>false
 *           char[][] matrix = {{'a'},{'a'},{'a'}}
 *           String str = aa ����>true
 *           String str = aj ����>false
 *  ������ԣ�char[][] matrix = null ����>false
 * */
public class findPath {
    public static void main(String[] args) {
        char[][] matrix = {{'a','b','t','g'},{'c','f','c','s'},{'j','d','e','h'}};
//        char[][] matrix = {{'a','b','t','g'}};
//        char[][] matrix = {{'a'},{'c'},{'j'}};
//        char[][] matrix = {{'a'},{'a'},{'a'}};
//        char[][] matrix = null;
        System.out.println("�������ַ�����");
        String str = new Scanner(System.in).nextLine();
        if (hasPath(matrix,str))
            System.out.println("���ڸ�·��");
        else
            System.out.println("·�������ڣ�");

    }

    private static boolean hasPath(char[][] matrix, String str) {
        if (matrix==null||matrix.length<1||matrix[0].length<1||str==null)
            return false;
        //�����ȴ�Boolean��������
        boolean[][] visited = getAssistant(matrix);
        int pathLength = 0;
        for (int i = 0; i < matrix.length; i++) {
            for (int j = 0; j < matrix[0].length; j++) {
                //��str�ĵ�0��λ�ÿ�ʼ�ȶ�
                if (find(matrix,visited,str,0,i,j))
                    return true;//�ܹ�������ȶ��������ַ�
            }
        }
        return false;
    }

    private static boolean find(char[][] matrix, boolean[][] visited, String str, int pathLength,int row,int col) {
        if (pathLength==str.length())
            return true;//�ȶ����������ַ�
        boolean hasPath = false;
        //!visit[row][col]���ڻ���ʱ�������ظ�·��
        if (row>=0&&row<matrix.length&&col>=0&&col<matrix[0].length
                &&matrix[row][col]==str.charAt(pathLength)&&!visited[row][col]){
            pathLength++;
            visited[row][col] = true;
            //Ѱ����һλ��(�ϡ��¡�����)�ַ�
            hasPath = find(matrix,visited,str,pathLength,row+1,col)
                    ||find(matrix,visited,str,pathLength,row,col+1)
                    ||find(matrix,visited,str,pathLength,row-1,col)
                    ||find(matrix,visited,str,pathLength,row,col-1);
            if (!hasPath){//�����һλ��ƥ�䲻�ԣ����ݵ���һλ��
                pathLength--;
                visited[row][col]=false;
            }
            return hasPath;
        }
        return false;
    }

    private static boolean[][] getAssistant(char[][] matrix) {
        boolean[][] assist = new boolean[matrix.length][matrix[0].length];
        for (int i = 0; i < assist.length; i++)
            for (int j = 0; j < assist[0].length; j++)
                assist[i][j] = false;
        return assist;
    }
}
