package greedy;

import java.io.IOException;
import java.util.PriorityQueue;
import java.util.Scanner;

public class BOJ1715 {
	
	/* 21�� 10�� 4���� ( 23.10.21 )
	 * 
	 * ����: ���ĵ� �� ������ ���� ī�尡 �ִٰ� ����. 
	 *      �� ������ ī���� ���� A, B�� �ϸ� ���� �� ������ ���ļ� �ϳ��� ����� ������ A+B ���� �񱳸� �ؾ� �Ѵ�. 
	 *      �̸��׸�, 20���� ���� ī�� ������ 30���� ���� ī�� ������ ��ġ���� 50���� �񱳰� �ʿ��ϴ�.
	 *      �ſ� ���� ���� ī�� ������ å�� ���� ���� �ִ�. 
	 *      �̵��� �� ������ ��� ���� ���ĳ����ٸ�, ���� ������ ���� �� Ƚ���� �ſ� �޶�����. 
	 *      ���� ��� 10��, 20��, 40���� ������ �ִٸ� 10��� 20���� ��ģ ��, ��ģ 30�� ������ 40���� ��ģ�ٸ� (10 + 20) + (30 + 40) = 100���� �񱳰� �ʿ��ϴ�. 
	 *      �׷��� 10��� 40���� ��ģ ��, ��ģ 50�� ������ 20���� ��ģ�ٸ� (10 + 40) + (50 + 20) = 120 ���� �񱳰� �ʿ��ϹǷ� �� ȿ������ ����̴�.
	 *      N���� ���� ī�� ������ ������ ũ�Ⱑ �־��� ��, �ּ��� �� ���� �񱳰� �ʿ������� ���ϴ� ���α׷��� �ۼ��Ͻÿ�.
	 * 
	 * �Է�: ù° �ٿ� ���� �־�����. ���� ��0��~��9��, ��+��, �׸��� ��-�������� �̷���� �ְ�, ���� ó���� ������ ���ڴ� �����̴�. 
	 *      �׸��� �����ؼ� �� �� �̻��� �����ڰ� ��Ÿ���� �ʰ�, 5�ڸ����� ���� ���ӵǴ� ���ڴ� ����. 
	 *      ���� 0���� ������ �� �ִ�. �Է����� �־����� ���� ���̴� 50���� �۰ų� ����.
	 * 
	 * ���: ù° �ٿ� ������ ����Ѵ�.
	 * 
	 * Ǯ��: ť�� ����ؼ� ���� �͵���� ���ֶ�, n �� 1�̸� �񱳸� ���� �ʱ⿡ 0 �� ���;��Ѵ�.
	 *     
	 * */
	
	static int solve(PriorityQueue<Integer> pq, int n) {
		if(n == 1) {
			return 0;
		}
		
		int result = 0;
		
		while(true) {
			int sum = 0;
			sum+=pq.poll();
			sum+=pq.poll();
			result+=sum;
			if(pq.isEmpty()) break;
			pq.add(sum);
		}
		return result;
	}
	
	public static void main(String[] args) throws NumberFormatException, IOException {
		int result = 0;
		Scanner sc = new Scanner(System.in);
		PriorityQueue<Integer> pq = new PriorityQueue<Integer>();
		int N = sc.nextInt();
		
		for(int i = 0; i < N; i++) {
			pq.add(sc.nextInt());
		}
		
		result = solve(pq,N);
		System.out.println(result);
	}

}
