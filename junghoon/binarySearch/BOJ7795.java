package binarysearch;

import java.io.BufferedReader;
import java.io.IOException;
import java.io.InputStreamReader;
import java.util.Arrays;
import java.util.StringTokenizer;

public class BOJ7795 {
	
	/* 21�� 10�� 1���� ( 02.10.21 )
	 * 
	 * ����: ���ؿ��� �� ������ ����ü A�� B�� �����Ѵ�. A�� B�� �Դ´�. A�� �ڱ⺸�� ũ�Ⱑ ���� ���̸� ���� �� �ִ�. 
	 *     ���� ���, A�� ũ�Ⱑ {8, 1, 7, 3, 1}�̰�, B�� ũ�Ⱑ {3, 6, 1}�� ��쿡 A�� B�� ���� �� �ִ� ���� ������ 7������ �ִ�. 
	 *     8-3, 8-6, 8-1, 7-3, 7-6, 7-1, 3-1.
	 *     �� ����ü A�� B�� ũ�Ⱑ �־����� ��, A�� ũ�Ⱑ B���� ū ���� �� ���� �ִ��� ���ϴ� ���α׷��� �ۼ��Ͻÿ�.
	 * 
	 * �Է�: ù° �ٿ� �׽�Ʈ ���̽��� ���� T�� �־�����. �� �׽�Ʈ ���̽��� ù° �ٿ��� A�� �� N�� B�� �� M�� �־�����. 
	 *      ��° �ٿ��� A�� ũ�Ⱑ ��� �־�����, ��° �ٿ��� B�� ũ�Ⱑ ��� �־�����. ũ��� ���� �����̴�. (1 �� N, M �� 20,000) 
	 * 
	 * ���: �� �׽�Ʈ ���̽�����, A�� B���� ū ���� ������ ����Ѵ�.
	 * 
	 * Ǯ��: binarysearch�� �����°� �ϳ��� Ȯ���Ѵ����� Ǯ����
	 *      ������ ���ؾȉ�µ� �׳� �����ֵ� �ϳ��� �Դ´ٴ� �ŷ� ���������� ������� �������� (�ڼ� ���� ī�� ���� Ȯ��)
	 * */
	
	public static void main(String[] args) throws IOException{
		BufferedReader br = new BufferedReader(new InputStreamReader(System.in));
		StringBuilder sb = new StringBuilder();
		int T = Integer.parseInt(br.readLine());
		while(T --> 0) {
			StringTokenizer st = new StringTokenizer(br.readLine());
			int[] a = Arrays.stream(br.readLine().split(" ")).mapToInt(Integer:: parseInt).sorted().toArray();
			int[] b = Arrays.stream(br.readLine().split(" ")).mapToInt(Integer::parseInt).sorted().toArray();
			
			int count = 0;
			for(int i : a) {
				for(int j : b) {
					if(i <= j) {
						break;
					} else {
						count++;
					}
					sb.append(count+"\n");
				}
				System.out.print(sb);
			}
		}
	}
	
}
