package com.wangzhu.njupt;

import java.io.BufferedInputStream;
import java.io.FileInputStream;
import java.io.IOException;
import java.io.StreamTokenizer;
import java.util.Arrays;

/**
 * 还有重复的字符数组的全排列
 * 
 * @ClassName: Main1369
 * @Description: TODO
 * @author 王竹
 * @date 2014-10-5 下午3:04:55
 * 
 */
public class Main1369 {

	/**
	 * @param args
	 * @throws IOException
	 */
	public static void main(String[] args) throws IOException {
		System.setIn(new FileInputStream("data.in"));
		StreamTokenizer in = new StreamTokenizer(new BufferedInputStream(
				System.in));
		while (in.nextToken() != StreamTokenizer.TT_EOF) {
			String str = in.sval;
			char[] buf = str.toCharArray();
			Arrays.sort(buf);
			int len = buf.length;
			boolean[] flagArr = new boolean[len];
			Arrays.fill(flagArr, true);
			char[] res = new char[len];
			dfs(0, len, buf, res, flagArr);
		}
	}

	/**
	 * 输入：<br/>
	 * abc<br/>
	 * BCA<br/>
	 * 输出：<br/>
	 * abc<br/>
	 * acb<br/>
	 * bac<br/>
	 * bca<br/>
	 * cab<br/>
	 * cba<br/>
	 * ABC<br/>
	 * ACB<br/>
	 * BAC<br/>
	 * BCA<br/>
	 * CAB<br/>
	 * CBA<br/>
	 */
	/**
	 * 
	 * @param dep
	 * @param maxDep
	 * @param buf
	 * @param res
	 * @param flagArr
	 */
	private static void dfs(int dep, int maxDep, char[] buf, char[] res,
			boolean[] flagArr) {
		if (dep == maxDep) {
			System.out.println(new String(res));
			return;
		}
		for (int i = 0; i < maxDep; i++) {
			if (!flagArr[i]
					&& (i != 0 && buf[i] == buf[i - 1] && flagArr[i - 1])) {
				// 当有重复的时候
				continue;
			}
			flagArr[i] = false;
			res[dep] = buf[i];
			dfs(dep + 1, maxDep, buf, res, flagArr);
			flagArr[i] = true;
		}
	}
}
