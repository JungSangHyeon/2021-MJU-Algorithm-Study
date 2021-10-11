package binarysearch;

import java.io.BufferedReader;
import java.io.IOException;
import java.io.InputStreamReader;
import java.util.Arrays;
import java.util.StringTokenizer;

public class BOJ1920 {
	
	/* 21�� 10�� 1���� ( 02.10.21 )
	 * 
	 * ����: N���� ���� A[1], A[2], ��, A[N]�� �־��� ���� ��, �� �ȿ� X��� ������ �����ϴ��� �˾Ƴ��� ���α׷��� �ۼ��Ͻÿ�.
	 * 
	 * �Է�: ù° �ٿ� �ڿ��� N(1 �� N �� 100,000)�� �־�����. ���� �ٿ��� N���� ���� A[1], A[2], ��, A[N]�� �־�����. ���� �ٿ��� M(1 �� M �� 100,000)�� �־�����. 
	 *      ���� �ٿ��� M���� ������ �־����µ�, �� ������ A�ȿ� �����ϴ��� �˾Ƴ��� �ȴ�. ��� ������ ������ -231 ���� ũ�ų� ���� 231���� �۴�.
	 * 
	 * ���: M���� �ٿ� ���� ����Ѵ�. �����ϸ� 1��, �������� ������ 0�� ����Ѵ�.
	 * 
	 * Ǯ��: binary search ���� �� ã�� --> �߰������� �����ؼ� �� �ٿ����� ���ư��鼭 ã�Ƴ������ --> array.sort ������ �ʿ� ������ �Ǿ��־�� �߰����� ©�� ã�� ����
	 *     
	 * */
	
	public static int[] arr;
	
	static int binarySearch(int key) {
		int left = 0; // index[0]
		int right = arr.length -1; //index[������]
		
		while(left <= right) { //������ �ٵ�? �ƴ�? Ȯ���ϴ°�
			
			int mid = (left + right) / 2;
			
			if(key < arr[mid]) {
				right = mid -1;
			} else if(key > arr[mid]) {
				left = mid +1;
			} else {
				return mid;
			}			
		}
		//���� �������� ������ ������ ��ȯ�ؼ� ��� Ȯ��
		return -1;
	}
	
	public static void main(String[] args) throws IOException {
		BufferedReader br = new BufferedReader(new InputStreamReader(System.in));
		
		int n = Integer.parseInt(br.readLine());
		arr = new int[n];
		
		StringTokenizer st = new StringTokenizer(br.readLine(), " ");
		for(int i = 0; i < n; i++) {
			arr[i] = Integer.parseInt(st.nextToken());
		}
		
		Arrays.sort(arr);
		
		int m = Integer.parseInt(br.readLine());
		
		st = new StringTokenizer(br.readLine(), " ");
		
		StringBuilder sb = new StringBuilder();
		for(int i = 0; i < m; i++) {
			if(binarySearch(Integer.parseInt(st.nextToken())) >= 0) {
				sb.append(1).append("\n");
			} else {
				sb.append(0).append("\n");
			}
		}
		System.out.println(sb);
	}

}
