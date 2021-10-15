package greedy;

import java.io.BufferedReader;
import java.io.IOException;
import java.io.InputStreamReader;
import java.util.StringTokenizer;

public class BOJ11047 {
	
	/* 21�� 10�� 2���� ( 09.10.21 )
	 * 
	 * ����: �ر԰� ������ �ִ� ������ �� N�����̰�, ������ ������ �ſ� ���� ������ �ִ�.
	 *      ������ ������ ����ؼ� �� ��ġ�� ���� K�� ������� �Ѵ�. �̶� �ʿ��� ���� ������ �ּڰ��� ���ϴ� ���α׷��� �ۼ��Ͻÿ�.
	 * 
	 * �Է�: ù° �ٿ� N�� K�� �־�����. (1 �� N �� 10, 1 �� K �� 100,000,000)
	 *      ��° �ٺ��� N���� �ٿ� ������ ��ġ Ai�� ������������ �־�����. (1 �� Ai �� 1,000,000, A1 = 1, i �� 2�� ��쿡 Ai�� Ai-1�� ���)
	 * 
	 * ���: ù° �ٿ� K���� ����µ� �ʿ��� ���� ������ �ּڰ��� ����Ѵ�.
	 * 
	 * Ǯ��: greedy �˰���, �� �� ���ÿ��� ���� ���ƺ��̴� ������ �Ͽ� ���� ã�ư�
	 *     
	 * */
	
	public static void main(String[] args) throws IOException {
		 
		BufferedReader br = new BufferedReader(new InputStreamReader(System.in));
		
		StringTokenizer st = new StringTokenizer(br.readLine(), " ");
		
		int N = Integer.parseInt(st.nextToken());
		int K = Integer.parseInt(st.nextToken());
		
		int[] coin = new int[N];
		
		for(int i = 0; i < N; i++) {
			coin[i] = Integer.parseInt(br.readLine());
		}
		
		int count = 0;
 
		for(int i = N - 1; i >= 0; i--) {
			if(coin[i] <= K) {
				count += (K / coin[i]);
				K = K % coin[i];
			}
		}
		System.out.println(count);
	}

}
