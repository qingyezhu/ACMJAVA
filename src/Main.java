import java.io.BufferedInputStream;
import java.util.Scanner;

public class Main {
	public static void main(String[] args) {
		Scanner cin = new Scanner(new BufferedInputStream(System.in));
		while (cin.hasNext()) {
			int n = cin.nextInt();
			for (int i = 0; i < n; i++) {
				arr[i] = cin.nextInt();
			}
			Segment root = new Segment();
			build(root, 1, n);
			int m = cin.nextInt();
			int[] queryL = new int[m];
			int[] queryR = new int[m];
			for (int i = 0; i < m; i++) {
				queryL[i] = cin.nextInt();
				queryR[i] = cin.nextInt();
			}
			int ret = -1;
			for (int i = 0; i < m; i++) {
				ret = query(root, queryL[i], queryR[i]);
				System.out.println(ret);
			}
		}
	}

	public static int[] arr = new int[100010];

	public static void build(Segment root, int L, int R) {
		root.left = L;
		root.right = R;
		if (L != R) {
			int mid = (L + R) / 2;
			root.leftChild = new Segment();
			root.rightChild = new Segment();
			build(root.leftChild, L, mid);
			build(root.rightChild, mid + 1, R);
			root.min = Math.min(root.leftChild.min, root.rightChild.min);
		} else {
			root.min = Math.min(arr[L - 1], arr[R - 1]);
			return;
		}
	}

	public static int query(Segment root, int L, int R) {
		if (L == root.left && R == root.right) {
			return root.min;
		} else {
			int ret = -1;
			int mid = (root.left + root.right) / 2;
			if (R <= mid) {
				ret = query(root.leftChild, L, R);
			} else if (L > mid) {
				ret = query(root.rightChild, L, R);
			} else {
				ret = Math.min(query(root.leftChild, L, mid),
						query(root.rightChild, mid + 1, R));
			}
			return ret;
		}
	}
}

class Segment {
	int left;
	int right;
	Segment leftChild;
	Segment rightChild;
	int min;
}
