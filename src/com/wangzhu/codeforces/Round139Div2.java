/**   
 * @Title: Round139Div2.java 
 * @Package com.wangzhu.codeforces 
 * @Description: n个骰子摆成塔，相邻骰子有联系的面上的数不同。看见的是最上面的骰子的面和所有骰子的侧面的数，问，凭这些数，能否唯一确定所有骰子面的数
 * @author 王竹
 * @date 2012-9-20 下午10:44:44 
 * @version V1.0   
 *
 */
package com.wangzhu.codeforces;

/** 
 * @ClassName: Round139Div2 
 * @Description: n个骰子摆成塔，相邻骰子有联系的面上的数不同。看见的是最上面的骰子的面和所有骰子的侧面的数，问，凭这些数，能否唯一确定所有骰子面的数
 * @author 王竹 
 * @date 2012-9-20 下午10:44:44 
 *  
 */
import java.io.BufferedInputStream;
import java.util.Scanner;

public class Round139Div2 {

	public static void main(String[] args) {
		Scanner cin = new Scanner(new BufferedInputStream(System.in));
		int len = 101;
		int[] x = new int[len];
		int[] y = new int[len];
		int z = -1, n = -1;
		boolean flag;
		while (cin.hasNext()) {
			n = cin.nextInt();
			z = cin.nextInt();
			flag = true;
			for (int i = 0; i < n; i++) {
				x[i] = cin.nextInt();
				y[i] = cin.nextInt();
				if (flag && (0 != i)) {
					if (isTrue(x[i], z) || isTrue(y[i], z)) {
						flag = false;
					}
				}
			}
			if (flag) {
				System.out.printf("YES");
			} else {
				System.out.printf("NO");
			}
		}
		cin.close();
	}

	private static boolean isTrue(int i, int z) {
		if (i == z || i + z == 7) {
			return true;
		}
		return false;
	}
}
