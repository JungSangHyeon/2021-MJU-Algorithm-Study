package dp;

import java.io.BufferedReader;
import java.io.IOException;
import java.io.InputStreamReader;
import java.util.StringTokenizer;

public class BOJ11053 {

	/* 21�� 11�� 1���� ( 06.11.21 ) ���� �� �����ϴ� �κ� ����
	 * 
	 * ����: ���� A�� �־����� ��, ���� �� �����ϴ� �κ� ������ ���ϴ� ���α׷��� �ۼ��Ͻÿ�.
	 *      ���� ���, ���� A = {10, 20, 10, 30, 20, 50} �� ��쿡 
	 *      ���� �� �����ϴ� �κ� ������ A = {10, 20, 10, 30, 20, 50} �̰�, ���̴� 4�̴�.
	 * 
	 * �Է�: ù° �ٿ� ���� A�� ũ�� N (1 �� N �� 1,000)�� �־�����.
	 * 		��° �ٿ��� ���� A�� �̷�� �ִ� Ai�� �־�����. (1 �� Ai �� 1,000)
	 * 
	 * ���: ù° �ٿ� ���� A�� ���� �� �����ϴ� �κ� ������ ���̸� ����Ѵ�.
	 * 
	 * Ǯ��: ���� ���� �κ� ���� (LIS),
	 *     
	 * */

	static int[] seq;
	static Integer[] dp;

	static int LIS(int N) {
		if(dp[N] == null) {
			dp[N] = 1;				
			for(int i = N - 1; i >= 0; i--) {
				if(seq[i] < seq[N]) {
					dp[N] = Math.max(dp[N], LIS(i) + 1);
				}
			}
		}
		return dp[N];
	}

	public static void main(String[] args) throws IOException {
		BufferedReader br = new BufferedReader(new InputStreamReader(System.in));
		int N = Integer.parseInt(br.readLine());
		seq = new int[N];
		dp = new Integer[N];
		StringTokenizer st = new StringTokenizer(br.readLine(), " ");
		for(int i = 0; i < N; i++) {
			seq[i] = Integer.parseInt(st.nextToken());
		}
		for(int i = 0; i < N; i++) {
			LIS(i);
		}
		int max = dp[0];
		for(int i = 1; i < N; i++) {
			max = Math.max(max, dp[i]);
		}
		System.out.println(max);
	}
}
