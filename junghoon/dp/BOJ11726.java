package DP;

import java.util.Scanner;

public class BOJ11726 {
	
	/* 21�� 10�� 4���� ( 23.10.21 )
	 * 
	 * ����: 2��n ũ���� ���簢���� 1��2, 2��1 Ÿ�Ϸ� ä��� ����� ���� ���ϴ� ���α׷��� �ۼ��Ͻÿ�.
	 *      �Ʒ� �׸��� 2��5 ũ���� ���簢���� ä�� �� ���� ����� ���̴�.(https://www.acmicpc.net/problem/11726)
	 * 
	 * �Է�: ù° �ٿ� n�� �־�����. (1 �� n �� 1,000)
	 * 
	 * ���: ù° �ٿ� 2��n ũ���� ���簢���� ä��� ����� ���� 10,007�� ���� �������� ����Ѵ�.
	 * 
	 * Ǯ��: 2xn Ÿ�ϸ� -> dp[n] = 2 x N ũ���� ���簢���� ä��� ����� ���� 
	 *      �Ǻ���ġ�� ����ϴٰ� �ϴµ� �� �Ǻ���ġ�� �򰥸� -> �Ǻ���ġ ���� ##
	 *     
	 * */
	
	static int recur(int[] dp, int n) {
		for(int i = 3; i <= n; i++) {
			dp[i] = (dp[i-1] + dp[i-2]) % 10007;
		}
		return dp[n];
	}
	
	public static void main(String[] args) {
		Scanner sc = new Scanner(System.in);
		int n = sc.nextInt();
		int[] dp = new int[n+2];
		dp[0] = 1;
		dp[1] = 1;
		dp[2] = 2;
		
		recur(dp, n);
		System.out.println(recur(dp, n));
	}

}
