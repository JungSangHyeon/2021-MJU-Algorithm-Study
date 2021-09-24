package bruteforce;

import java.util.Scanner;

public class BOJ15649 {

	
	/*
	 * 
	 * ����: �ڿ��� N�� M�� �־����� ��, �Ʒ� ������ �����ϴ� ���̰� M�� ������ ��� ���ϴ� ���α׷��� �ۼ��Ͻÿ�.
	 *  - 1���� N���� �ڿ��� �߿��� �ߺ� ���� M���� �� ����
	 * 
	 * �Է�: ù° �ٿ� �ڿ��� N�� M�� �־�����. (1 �� M �� N �� 8)
	 * 
	 * ���: �� �ٿ� �ϳ��� ������ ������ �����ϴ� ������ ����Ѵ�. �ߺ��Ǵ� ������ ���� �� ����ϸ� �ȵǸ�, �� ������ �������� �����ؼ� ����ؾ� �Ѵ�.
	 *      ������ ���� ������ �����ϴ� ������ ����ؾ� �Ѵ�.
	 * 
	 * Ǯ��: Backtracking (bruteforce�� ��� ����� �� ã�°��� --> �ڹپ˰��� 290�ʿ� ���� ����)
	 * */
	
	
	public static int[] arr; //���鼭 �� ����
	public static boolean[] visit; // Nũ��� ����, ������ �湮������ �Ѿ���ϱ�����
	
	public static void main(String[] args) {
		
		Scanner scanner = new Scanner(System.in);
		
		int N = scanner.nextInt(); // N
		int M = scanner.nextInt(); // M
		
		arr = new int[M];
		visit = new boolean[N];
		dfs(N, M, 0);
	}
	
	public static void dfs(int N, int M, int depth) { //dfs�� ��Ʈ��ŷ ��� �� �ϳ��� ���̳ʸ�Ʈ������ �Ӵٸ����ٸ���
		if(depth == M) {
			for(int val: arr) { //?
				System.out.print(val + " ");
			}
			System.out.println();
			return;
		}
		for(int i = 0; i < N; i++) {
			if(!visit[i]) { //���� ���Ҵ���
				visit[i] = true;
				arr[depth] = i + 1; //�ٵ� ���ʿ� 0
				dfs(N, M, depth + 1); //�� �׷��� ���⼭ +1���� ++�ϸ�ȵ� �׷��� --���������
				visit[i] = false;
			}
		}
	}
}
