package com.wangzhu.poj;

import java.io.FileInputStream;
import java.io.FileNotFoundException;
import java.util.ArrayList;
import java.util.Collections;
import java.util.Comparator;
import java.util.List;
import java.util.Scanner;

public class Main2503 {
	private static final int LEN = 100010;

	public static void main(String[] args) throws FileNotFoundException {
		System.setIn(new FileInputStream("data.in"));
		Scanner cin = new Scanner(System.in);
		List<Node> nodeList = new ArrayList<Node>(LEN);
		while (cin.hasNext()) {
			String str = cin.nextLine();
			if (str.length() == 0) {
				break;
			}
			String[] arr = str.split(" ");
			Node node = new Node(arr[0], arr[1]);
			nodeList.add(node);
		}

		Collections.sort(nodeList, new Comparator<Node>() {

			@Override
			public int compare(Node o1, Node o2) {
				int index = o1.getForeign().compareTo(o2.getForeign());
				if (index > 0) {
					return 1;
				} else if (index < 0) {
					return -1;
				}
				return 0;
			}

		});
		while (cin.hasNext()) {
			String str = cin.nextLine();
			if (str.length() == 0) {
				break;
			}
			int index = binarySearch(nodeList, str);
			if (index == -1) {
				System.out.println("eh");
			} else {
				System.out.println(nodeList.get(index).getWord());
			}
		}
	}

	private static int binarySearch(List<Node> nodeList, String key) {
		int left = 0, right = nodeList.size() - 1;
		while (left <= right) {
			int mid = (left + right) >> 1;
			String foreign = nodeList.get(mid).getForeign();
			int index = foreign.compareTo(key);
			if (index == 0) {
				return mid;
			} else if (index > 0) {
				right = mid - 1;
			} else {
				left = mid + 1;
			}
		}
		return -1;
	}
}

class Node {
	private String word;
	private String foreign;

	public String getWord() {
		return word;
	}

	public void setWord(String word) {
		this.word = word;
	}

	public String getForeign() {
		return foreign;
	}

	public Node(String word, String foreign) {
		super();
		this.word = word;
		this.foreign = foreign;
	}

	public void setForeign(String foreign) {
		this.foreign = foreign;
	}
}
