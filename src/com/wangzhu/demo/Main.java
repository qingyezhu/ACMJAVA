package com.wangzhu.demo;

/**   
 * @Title: HDU4407.java 
 * @Package com.wangzhu.hdu 
 * @Description: TODO
 * @author ����
 * @date 2012-9-22 ����7:40:27 
 * @version V1.0   
 *
 */

import java.io.BufferedInputStream;
import java.util.Arrays;
import java.util.Scanner;

/**
 * @ClassName: HDU4407
 * @Description: TODO
 * @author ����
 * @date 2012-9-22 ����7:40:27
 * 
 */
public class Main {

    public static void main(String[] args) {
        // System.setIn(new FileInputStream("data.in"));
        Scanner cin = new Scanner(new BufferedInputStream(System.in));
        int t, n, m, cas, x, y, c, p;
        initPrime();
        while (cin.hasNext()) {
            t = cin.nextInt();
            while (t-- > 0) {
                n = cin.nextInt();
                m = cin.nextInt();
                node = new Node[m + 1];
                lastIndex = new int[MAXN];
                nodeLen = 0;
                for (int i = 0; i < m; i++) {
                    cas = cin.nextInt();
                    if (cas == 2) {
                        x = cin.nextInt();
                        c = cin.nextInt();
                        node[nodeLen] = new Node(x, c);
                        lastIndex[x] = nodeLen++;
                    } else {
                        x = cin.nextInt();
                        y = cin.nextInt();
                        p = cin.nextInt();
                        work(x, y, p, n);

                    }
                }
            }
        }
        cin.close();
    }

    private final static int MAXN = 400001;
    static int[] lastIndex;
    private final static int VAL = 1000;
    static int[] prime = new int[VAL];
    static boolean[] isPrime = new boolean[VAL];
    static int primeLen;

    public static void initPrime() {
        Arrays.fill(isPrime, false);
        primeLen = 0;
        prime[primeLen++] = 2;
        for (int i = 4; i < VAL; i += 2) {
            isPrime[i] = true;
        }
        for (int i = 3; i < VAL; i += 2) {
            if (!isPrime[i]) {
                prime[primeLen++] = i;
            }
            for (int j = 0; (j < primeLen) && (i * prime[j] < VAL); j++) {
                isPrime[i * prime[j]] = true;
                if (i % prime[j] == 0) {
                    break;
                }
            }
        }
    }

    static Node[] node;
    static int nodeLen;

    static int[] primeFactor; // �洢������
    static int primeFactorLen;

    /**
     * �ֽ���p�����������
     * 
     * @param p
     */
    public static void mkPrimeFactor(int p) {
        primeFactor = new int[VAL];
        int temp = (int) Math.sqrt(1.0 * p);
        primeFactorLen = 0;
        for (int i = 0; (i < primeLen) && (prime[i] <= temp); i++) {
            if (p % prime[i] == 0) {
                primeFactor[primeFactorLen++] = prime[i];
                while (p % prime[i] == 0) {
                    p /= prime[i];
                }
            }
        }
        if (p > 1) {
            primeFactor[primeFactorLen++] = p;
        }
    }

    private static void work(int x, int y, int p, int n) {
        mkPrimeFactor(p);
        long res = getSum(y) - getSum(x - 1);
        for (int i = 0; i < nodeLen; i++) {
            if (node[i].x >= x && node[i].x <= y) {
                // ���Ƕ���޸�ͬһ���ط�����ֻȡ���һ��
                if (i != lastIndex[node[i].x]) {
                    continue;
                }
                if (isCoPrime(node[i].x, p)) {
                    res -= node[i].x;
                }
                if (isCoPrime(node[i].c, p)) {
                    res += node[i].c;
                }
            }
        }
        System.out.println(res);
    }

    private static long getSum(int i) {
        long res = (long) i * (i + 1) / 2;
        res -= dfs(0, i, 1);
        return res;
    }

    private static boolean isCoPrime(int c, int p) {
        return gcd(c, p) == 1;
    }

    /**
     * ���Լ��
     * 
     * @param a
     * @param b
     * @return
     */
    public static long gcd(long a, long b) {
        long r;
        if (a < b) {
            r = a;
            a = b;
            b = r;
        }
        while (b != 0) {
            r = a % b;
            a = b;
            b = r;
        }
        return a;
    }

    /**
     * �ݳ�ԭ�� �����n��������p���ʵ����ĺ�
     * 
     * @param start
     * @param n
     * @param now
     * @return
     */
    private static long dfs(int start, int n, long now) {
        long res = 0, temp;
        for (int i = start; i < primeFactorLen; i++) {
            temp = lcm(now, primeFactor[i]);// ÿһ����ʼ��֮���������С������
            res += getPrimeSum(temp, n) - dfs(i + 1, n, temp);
        }
        return res;
    }

    /**
     * ��С������
     * 
     * @param now
     * @param i
     * @return
     */
    private static long lcm(long now, long i) {
        return (long) now / gcd(now, i) * i;
    }

    private static long getPrimeSum(long num, int n) {
        long temp = n / num;
        return temp * (temp + 1) / 2 * num;
    }

}

class Node {
    int x;
    int c;

    public Node(int x, int c) {
        this.x = x;
        this.c = c;
    }
}