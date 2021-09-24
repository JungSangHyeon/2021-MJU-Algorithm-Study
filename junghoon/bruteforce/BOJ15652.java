package bruteforce;

import java.io.BufferedReader;
import java.io.IOException;
import java.io.InputStreamReader;
import java.util.StringTokenizer;

public class BOJ15652 {
	
	/*
	 * 
	 * ����: �ڿ��� N�� M�� �־����� ��, �Ʒ� ������ �����ϴ� ���̰� M�� ������ ��� ���ϴ� ���α׷��� �ۼ��Ͻÿ�.
	 *  - 1���� N���� �ڿ��� �߿��� M���� �� ����
	 *  - ���� ���� ���� �� ��� �ȴ�.
	 *  - �� ������ �񳻸������̾�� �Ѵ�.
	 *     -> ���̰� K�� ���� A�� A1 �� A2 �� ... �� AK-1 �� AK�� �����ϸ�, �񳻸������̶�� �Ѵ�. ---> �ϴ� �̰� �������� �𸣰���
	 *    !!!@@!@!@!@!@ �ϴ� �� ���������̶�°� �׳� �ߺ��� ����Ѵٰ� �����ϸ�ȴٰ��� �� 15650�̶� �Ȱ����� �׳� ����Ҷ� i�� �Ѱ��ָ� ��
	 * 
	 * �Է�: ù° �ٿ� �ڿ��� N�� M�� �־�����. (1 �� M �� N �� 8)
	 * 
	 * ���: �� �ٿ� �ϳ��� ������ ������ �����ϴ� ������ ����Ѵ�. �ߺ��Ǵ� ������ ���� �� ����ϸ� �ȵǸ�, �� ������ �������� �����ؼ� ����ؾ� �Ѵ�.
	 *      ������ ���� ������ �����ϴ� ������ ����ؾ� �Ѵ�.
	 * 
	 * */

	//�������� scanner�ִ��� �Ⱦ�����,, ���ɿ� ���� ���� --> �ٸ� ������� Ǫ�� �͵� �����ϰ� �Ѿ����
	
	public static int[] arr;
	public static int N, M;
	public static StringBuilder sb = new StringBuilder();
	
	public static void main(String[] args) throws IOException {
		
		BufferedReader br = new BufferedReader(new InputStreamReader(System.in));
		
		StringTokenizer st = new StringTokenizer(br.readLine(), " ");
		
		N = Integer.parseInt(st.nextToken());
		M = Integer.parseInt(st.nextToken());
		arr = new int[M];
		
		dfs(1, 0);
		System.out.println(sb);
	}
	
	public static void dfs(int at, int depth) {
		if(depth == M) {
			for(int val: arr) {
				sb.append(val).append(' ' );
			}
			sb.append('\n');
			return;
		}
		
		for(int i = at; i <= N; i++) {
			arr[depth] = i;
			dfs(i, depth +1); // �׳� �����ſ� i�� �־��ָ� ����
		}
	}
	
}
