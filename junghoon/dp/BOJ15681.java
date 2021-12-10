package DP;

import java.io.BufferedReader;
import java.io.BufferedWriter;
import java.io.IOException;
import java.io.InputStreamReader;
import java.io.OutputStreamWriter;
import java.util.ArrayList;
import java.util.StringTokenizer;

public class BOJ15681 {
	
	/* Ʈ���� ����
	 * 
	 * ����: ������ ����ġ�� ���⼺�� ���� ������ ��Ʈ �ִ� Ʈ���� �־����� ��, �Ʒ��� ������ ���غ����� ����.
	 *      ���� U�� ��Ʈ�� �ϴ� ����Ʈ���� ���� ������ ���� ����Ѵ�.
	 *      ���� �� ������ �ذ��ϴ� ���� ������� �ִٸ�, �ϴ��� ��Ʈ�� ÷���� ������ ��������.
	 * 
	 * �Է�: Ʈ���� ������ �� N�� ��Ʈ�� ��ȣ R, ������ �� Q�� �־�����. (2 �� N �� 105, 1 �� R �� N, 1 �� Q �� 105)
	 *      �̾� N-1�ٿ� ����, U V�� ���·� Ʈ���� ���� ������ ������ �־�����. (1 �� U, V �� N, U �� V)
	 *      �̴� U�� V�� �� �������� �ϴ� ������ Ʈ���� ������ �ǹ��Ѵ�.
	 *      �̾� Q�ٿ� ����, ������ ������ U�� �ϳ��� �־�����. (1 �� U �� N)
	 *      �Է����� �־����� Ʈ���� �׻� �ùٸ� Ʈ������ ����ȴ�.
	 * 
	 * ���: Q�ٿ� ���� �� ������ ���� ���� �ϳ��� ����Ѵ�.
	 * 
	 * Ǯ��: Ʈ������ DP ����, Ʈ���� ���� �� ��Ʈ�� �����ϰ� �����ϴ� ���� ����. Ʈ���� ����鼭 �迭�� �ڽ��� ������ ������ ����ϸ� �ȴ�.
	 *      �Լ��� ��������� ȣ���ϸ� terminal node���� �Լ��� ����Ǳ� ������ ���� ������ �� �ִ�.
	 *     
	 * */
	
	static int[] dp;
	static ArrayList<ArrayList<Integer>> graph;
	
	static int buildTree(int cur, int parent) {
		if(dp[cur] != 0) {
			return dp[cur];
		}
		dp[cur] = 1;
		
		for(int child : graph.get(cur)) {
			if(parent != child) {
				dp[cur] += buildTree(child, cur);
			}
		}
		return dp[cur];
	}
	
	public static void main(String[] args) throws IOException {
		BufferedReader br = new BufferedReader(new InputStreamReader(System.in));
		BufferedWriter bw = new BufferedWriter(new OutputStreamWriter(System.out));
		StringTokenizer st = new StringTokenizer(br.readLine());
		graph = new ArrayList<>();
		
		int n = Integer.parseInt(st.nextToken());
		int r = Integer.parseInt(st.nextToken());
		int q = Integer.parseInt(st.nextToken());
		dp = new int[n+1];
		
		for(int i = 0; i < n; i++) {
			graph.add(new ArrayList<>());
		}
		
		for(int i = 0; i < n - 1; i++) {
			st = new StringTokenizer(br.readLine());
			int u = Integer.parseInt(st.nextToken());
			int v = Integer.parseInt(st.nextToken());
			graph.get(u).add(v);
			graph.get(v).add(u);
		}
		buildTree(r, -1);
		
		StringBuilder sb=  new StringBuilder();
		for(int i = 0; i < q; i++) {
			int u = Integer.parseInt(br.readLine());
			sb.append(dp[u]).append("\n");
		}
		bw.write(sb.toString());
		bw.close();
		br.close();
	}

}
