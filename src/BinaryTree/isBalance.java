package BinaryTree;
/**【问题描述】
 * 给定一个二叉树，判断它是否是高度平衡的二叉树。
 * 【思路分析】
 * 判断左右子树高度差 < 1
 * height(p) = -1 p=null
 *           = max(height(p.left),height,p.right) + 1;
 * 【测试用例】
 * [null] ——> true
 * [3,9,20,null,null,15,7] ——> true
 * [1,2,2,3,3,null,null,4,4] ——> false
 * */
public class isBalance {
}
