package DP;

import java.io.BufferedReader;
import java.io.IOException;
import java.io.InputStreamReader;
import java.util.StringTokenizer;

public class BOJ1912 {

	/* 21�� 11�� 1���� ( 05.11.21 )
	 * 
	 * ����: n���� ������ �̷���� ������ ������ �־�����. 
	 *      �츮�� �� �� ���ӵ� �� ���� ���� �����ؼ� ���� �� �ִ� �� �� ���� ū ���� ���Ϸ��� �Ѵ�.
	 *      ��, ���� �� �� �̻� �����ؾ� �Ѵ�.
	 *      ���� �� 10, -4, 3, 1, 5, 6, -35, 12, 21, -1 �̶�� ������ �־����ٰ� ����. 
	 *      ���⼭ ������ 12+21�� 33�� ������ �ȴ�.

	 * �Է�: ù° �ٿ� ���� n(1 �� n �� 100,000)�� �־����� ��° �ٿ��� n���� ������ �̷���� ������ �־�����.
	 *      ���� -1,000���� ũ�ų� ����, 1,000���� �۰ų� ���� �����̴�.
	 * 
	 * ���: ù° �ٿ� ���� ����Ѵ�.
	 * 
	 * Ǯ��: Top down ������� �Է¹�� �����Ͽ� �ľ�
	 *     
	 * */


	static int[] arr;		
	static Integer[] dp;	
	static int max;		

	static int recur(int N) {

		if(dp[N] == null) {
			dp[N] = Math.max(recur(N - 1) + arr[N], arr[N]);

			max = Math.max(dp[N], max);
		}

		return dp[N];
	}

	public static void main(String[] args) throws IOException {
		BufferedReader br = new BufferedReader(new InputStreamReader(System.in));

		int N = Integer.parseInt(br.readLine());

		arr = new int[N];
		dp = new Integer[N];

		StringTokenizer st = new StringTokenizer(br.readLine(), " ");

		for(int i = 0; i < N; i++) {
			arr[i] = Integer.parseInt(st.nextToken());
		}

		dp[0] = arr[0];
		max = arr[0];

		recur(N - 1);

		System.out.println(max);
	}



}
