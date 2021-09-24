package bruteforce;

import java.util.Scanner;

public class BOJ15650 {
	
	/*
	 * 
	 * ����: �ڿ��� N�� M�� �־����� ��, �Ʒ� ������ �����ϴ� ���̰� M�� ������ ��� ���ϴ� ���α׷��� �ۼ��Ͻÿ�.
	 *  - 1���� N���� �ڿ��� �߿��� �ߺ� ���� M���� �� ����
	 *  - �� ������ ���������̾�� �Ѵ�.
	 * 
	 * �Է�: ù° �ٿ� �ڿ��� N�� M�� �־�����. (1 �� M �� N �� 8)
	 * 
	 * ���: �� �ٿ� �ϳ��� ������ ������ �����ϴ� ������ ����Ѵ�. �ߺ��Ǵ� ������ ���� �� ����ϸ� �ȵǸ�, �� ������ �������� �����ؼ� ����ؾ� �Ѵ�.
	 *      ������ ���� ������ �����ϴ� ������ ����ؾ� �Ѵ�.
	 * 
	 * */
	
	//15649�� ����ѵ� at������ �߰��آZ������
	//int at�� ���� ��ġ�� ���� 
	
	public static int[] arr;
	public static int N, M;
	
	public static void main(String[] args) {
		
		Scanner scanner = new Scanner(System.in);
		
		N = scanner.nextInt();
		M = scanner.nextInt();
		
		arr = new int[M];
		
		dfs(1, 0);
	}
	
	public static void dfs(int at, int depth) { // at�� ���� ��ġ
		if(depth == M) { //�̰� ���̰� M�̶� �������� ����ѵ�
			for(int val : arr) {
				System.out.print(val + " ");
			}
			System.out.println();
			return;
		}
		
		for(int i = at; i <= N; i++) { // �׷��� ���� ��ġ�� at���� ������
			arr[depth] = i;
			dfs(i + 1, depth + 1);//++���� �����Ǽ� �Ⱦ��°��� --> ���ȣ�⶧ ���� �������� ȣ��������ϱ⶧���ε� ���⼭ +1 �ؼ� ������ ���·� ȣ��Ǵµ� ++�ϸ� ������ ���� �״�� ���Ե�
		}
	}

}
