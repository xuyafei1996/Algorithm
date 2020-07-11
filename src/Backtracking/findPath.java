package Backtracking;

import java.util.Scanner;

/**【问题描述】
 *  给定一个矩阵matrix和字符串str，判断matrix是否包含一个str的路径
 *  【思路分析】
 *  对矩阵中的每个数，调用一次hasPath()函数
 *  定义一个等大Boolean辅助矩阵，记录是否有路径
 *  ————> 字符ch对应于路径上第i个字符，向上下左右继续递归；
 *        字符不对应于路径上第i个字符，回溯到上一位置；
 *  【测试用例】
 *  功能测试：char[][] matrix = {{'a','b','t','g'},{'c','f','c','s'},{'j','d','e','h'}}
 *           String str = bfce ——>true
 *           String str = abfb ——>false
 *  边界测试：char[][] matrix = {{'a','b','t','g'}}
 *           String str = btg ——>true
 *           String str = atg ——>false
 *           char[][] matrix = {{'a'},{'c'},{'j'}}
 *           String str = cj ——>true
 *           String str = aj ——>false
 *           char[][] matrix = {{'a'},{'a'},{'a'}}
 *           String str = aa ——>true
 *           String str = aj ——>false
 *  特殊测试：char[][] matrix = null ——>false
 * */
public class findPath {
    public static void main(String[] args) {
        char[][] matrix = {{'a','b','t','g'},{'c','f','c','s'},{'j','d','e','h'}};
//        char[][] matrix = {{'a','b','t','g'}};
//        char[][] matrix = {{'a'},{'c'},{'j'}};
//        char[][] matrix = {{'a'},{'a'},{'a'}};
//        char[][] matrix = null;
        System.out.println("请输入字符串：");
        String str = new Scanner(System.in).nextLine();
        if (hasPath(matrix,str))
            System.out.println("存在该路径");
        else
            System.out.println("路径不存在！");

    }

    private static boolean hasPath(char[][] matrix, String str) {
        if (matrix==null||matrix.length<1||matrix[0].length<1||str==null)
            return false;
        //创建等大Boolean辅助矩阵
        boolean[][] visited = getAssistant(matrix);
        int pathLength = 0;
        for (int i = 0; i < matrix.length; i++) {
            for (int j = 0; j < matrix[0].length; j++) {
                //从str的第0个位置开始比对
                if (find(matrix,visited,str,0,i,j))
                    return true;//能够按规则比对完所有字符
            }
        }
        return false;
    }

    private static boolean find(char[][] matrix, boolean[][] visited, String str, int pathLength,int row,int col) {
        if (pathLength==str.length())
            return true;//比对完了所有字符
        boolean hasPath = false;
        //!visit[row][col]用于回溯时避免走重复路径
        if (row>=0&&row<matrix.length&&col>=0&&col<matrix[0].length
                &&matrix[row][col]==str.charAt(pathLength)&&!visited[row][col]){
            pathLength++;
            visited[row][col] = true;
            //寻找下一位置(上、下、左、右)字符
            hasPath = find(matrix,visited,str,pathLength,row+1,col)
                    ||find(matrix,visited,str,pathLength,row,col+1)
                    ||find(matrix,visited,str,pathLength,row-1,col)
                    ||find(matrix,visited,str,pathLength,row,col-1);
            if (!hasPath){//如果下一位置匹配不对，回溯到上一位置
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
