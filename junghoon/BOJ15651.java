package bruteforce;

import java.io.BufferedReader;
import java.io.IOException;
import java.io.InputStreamReader;
import java.util.StringTokenizer;

public class BOJ15651 {
	
	/*
	 * 
	 * ����: �ڿ��� N�� M�� �־����� ��, �Ʒ� ������ �����ϴ� ���̰� M�� ������ ��� ���ϴ� ���α׷��� �ۼ��Ͻÿ�.
	 *  - 1���� N���� �ڿ��� �߿��� M���� �� ����
	 *  - ���� ���� ���� �� ��� �ȴ�.
	 * 
	 * �Է�: ù° �ٿ� �ڿ��� N�� M�� �־�����. (1 �� M �� N �� 7)
	 * 
	 * ���: �� �ٿ� �ϳ��� ������ ������ �����ϴ� ������ ����Ѵ�. �ߺ��Ǵ� ������ ���� �� ����ϸ� �ȵǸ�, �� ������ �������� �����ؼ� ����ؾ� �Ѵ�.
	 *      ������ ���� ������ �����ϴ� ������ ����ؾ� �Ѵ�.
	 * 
	 * */
	
	//�׷��ٸ� ������ 3���� 1~N���� �� ����, M�� ������ == depth, �ߺ�����
	// ���⼱ scanner�� print ���� �ð� ���ٵ�
	
	public static int[] arr; //�������ܽ��ϰ� ����
	public static int N, M; //�̰͵� �Ȱ���
	public static StringBuilder sb = new StringBuilder();
	
	public static void main(String[] args) throws IOException {
		
		BufferedReader br = new BufferedReader(new InputStreamReader(System.in));
		
		StringTokenizer st = new StringTokenizer(br.readLine()); //��Ʈ�� ��ūȭ�ϱ����ؼ�
		
		N = Integer.parseInt(st.nextToken());
		M = Integer.parseInt(st.nextToken());
		
		arr = new int[M];
		dfs(0);
		System.out.println(sb);
	}
	
	public static void dfs(int depth) {
		if(depth == M) { //���̸� �ִ�� �尫���� �ڽľ����� return
			for(int i = 0; i < M; i++) {
				sb.append(arr[i]).append(' ');
			}
			sb.append('\n');
			return;
		}
		
		for(int i = 1; i <= N; i++) {
			arr[depth] = i;
			dfs(depth + 1); //�ߺ�����, �׸��� 1�� �÷����鼭 ���ȣ��
		}
	}
	

}
