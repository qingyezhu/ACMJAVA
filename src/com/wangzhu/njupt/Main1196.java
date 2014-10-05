package com.wangzhu.njupt;

import java.io.FileInputStream;
import java.io.FileNotFoundException;
import java.util.Scanner;
import java.util.TreeSet;

public class Main1196 {

	/**
	 * @param args
	 * @throws FileNotFoundException
	 */
	public static void main(String[] args) throws FileNotFoundException {
		System.setIn(new FileInputStream("data.in"));
		Scanner cin = new Scanner(System.in);
		TreeSet<Stu> stuSet = new TreeSet<Stu>();
		while (cin.hasNext()) {
			stuSet.clear();

			int n = cin.nextInt();
			for (int i = 0; i < n; i++) {
				Stu stu = new Stu();
				stu.no = cin.nextInt();
				stu.score = cin.nextInt();
				stuSet.add(stu);
			}
			for (Stu stu : stuSet) {
				System.out.println(stu);
			}

		}

	}

	static class Stu implements Comparable<Stu> {
		int no;
		int score;

		public Stu() {
			super();

		}

		public Stu(int no, int score) {
			super();
			this.no = no;
			this.score = score;
		}

		@Override
		public int compareTo(Stu stu) {
			if (null == stu) {
				return 0;
			}
			if (stu instanceof Stu) {
				if (stu.score == this.score) {
					return this.no - stu.no;
				}
				return this.score - stu.score;
			}
			return 0;
		}

		@Override
		public String toString() {
			return no + " " + score;
		}

	}

}
