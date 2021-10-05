package bruteforce;

import java.util.Scanner;

public class BOJ1182 {
	
	
	/*                                                                !!!@@@@ �ذ� �� ���� ���� ���� CHECK CHECK
	 * 9�� ����������
	 * 
	 * ����: N���� ������ �̷���� ������ ���� ��, ũ�Ⱑ ����� �κм��� �߿��� �� ������ ���Ҹ� �� ���� ���� S�� �Ǵ� ����� ���� ���ϴ� ���α׷��� �ۼ��Ͻÿ�.
	 * 
	 * �Է�: ù° �ٿ� ������ ������ ��Ÿ���� N�� ���� S�� �־�����. (1 �� N �� 20, |S| �� 1,000,000) 
	 *      ��° �ٿ� N���� ������ �� ĭ�� ���̿� �ΰ� �־�����. �־����� ������ ������ 100,000�� ���� �ʴ´�.
	 * 
	 * ���: ù° �ٿ� ���� S�� �Ǵ� �κм����� ������ ����Ѵ�.
	 * 
	 * Ǯ��: ������Ʈ �˰���� DFS ����ؾ���
	 * */
	
	//���� ����: �ϴ� ������ �������� �� �𸣰���, �Է��ϴµ� �Է� ����� ��ü ������ �𸣰��� --> ���а����ؾ���
	
	static int N, S, count = 0;
	static int[] arr;
	
	public static void main(String[] args) {
		Scanner scanner = new Scanner(System.in);
		
		N = scanner.nextInt();
		S = scanner.nextInt();
		arr = new int[N]; //��������� 3������ ����� ���� ����̶� ���� ����
		
		for(int i = 0; i < N; i++) { //�ֵ�������?
			arr[i] = scanner.nextInt();
		}
		
		dfs(0, 0);
		
		if(S == 0) { //count ���� 0�϶� �������� ���Եȴٰ� ������Ѵٰ��ϴµ� �̺κи� ���ذ�
			count--;
			System.out.println(count);
		} else {
			System.out.println(count);
		}
	}
	
	static void dfs(int value, int c) {
		if(value == N) { //dfs�� ���ٰ� value �������� ���� ���ϴ� ������ Ȯ���ϴ� ��
			if(c == S) {
				count++;
			}
			return;
		}
		//�κм����� ���Ҹ� �����ϰų� ���ϴ°� ��µ� ���� !@!@!@!@ CHECK CHECK
		dfs(value+1, c+arr[value]); // ����
		dfs(value+1, c); // ���þ���
	}
	
	

}
