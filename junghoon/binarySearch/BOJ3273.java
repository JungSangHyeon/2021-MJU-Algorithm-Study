package binarysearch;

import java.io.BufferedReader;
import java.io.IOException;
import java.io.InputStreamReader;
import java.util.Arrays;

public class BOJ3273 {
	
	/* 21�� 10�� 1���� ( 02.10.21 )
	 * 
	 * ����: n���� ���� �ٸ� ���� ���� a1, a2, ..., an���� �̷���� ������ �ִ�. 
	 *      ai�� ���� 1���� ũ�ų� ����, 1000000���� �۰ų� ���� �ڿ����̴�. �ڿ��� x�� �־����� ��, 
	 *      ai + aj = x (1 �� i < j �� n)�� �����ϴ� (ai, aj)���� ���� ���ϴ� ���α׷��� �ۼ��Ͻÿ�.
	 * 
	 * �Է�: ù° �ٿ� ������ ũ�� n�� �־�����. ���� �ٿ��� ������ ���ԵǴ� ���� �־�����. ��° �ٿ��� x�� �־�����. (1 �� n �� 100000, 1 �� x �� 2000000)
	 * 
	 * ���: ������ ������ �����ϴ� ���� ������ ����Ѵ�.
	 * 
	 * Ǯ��: �� �����Ͷ���Ѵ�. �� ���� ������ �Է°� �޾Ƽ� �迭�� ������ ���� -> �״㿡 ���ϱ�
	 * */
	
	public static void main(String[] args) throws IOException {
		BufferedReader br = new BufferedReader(new InputStreamReader(System.in));
		int n = Integer.parseInt(br.readLine());
		int[] input = Arrays.stream(br.readLine().split(" ")).mapToInt(Integer::parseInt).sorted().toArray();
		int target = Integer.parseInt(br.readLine());
		int count = 0;
		int start = 0;
		int end = n-1;
		while(start < end) {
			int sum = input[start] + input[end];
			if(sum == target) {
				end--;
				start++;
				count++;
			} else if(sum > target) {
				end--;
			} else {
				start++;
			}
		}
		System.out.println(count);
	}

}
