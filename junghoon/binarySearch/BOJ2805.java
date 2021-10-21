package binarysearch;

import java.io.BufferedReader;
import java.io.IOException;
import java.io.InputStreamReader;
import java.util.StringTokenizer;

public class BOJ2805 {
	
	/* 21�� 10�� 2���� ( 09.10.21 )
	 * 
	 * ����: ����̴� ���� M���Ͱ� �ʿ��ϴ�. ��ó�� ������ ������ ���� ��� ���ع��ȱ� ������, ���ο� ���� �㰡�� ��û�ߴ�. 
	 *     ���δ� ����̳� �� ��ó�� ���� �� �ٿ� ���� ���� �㰡�� ���־���, ����̴� ���� ������ �������ܱ⸦ �̿��ؼ� ������ ���Ұ��̴�.
	 *     �������ܱ�� ������ ���� �����Ѵ�. ����, ����̴� ���ܱ⿡ ���� H�� �����ؾ� �Ѵ�. ���̸� �����ϸ� �鳯�� �����κ��� H���� ���� �ö󰣴�.
	 *     �� ����, �� �ٿ� �������ִ� ������ ��� �����ع�����. 
	 *     ����, ���̰� H���� ū ������ H ���� �κ��� �߸� ���̰�, ���� ������ �߸��� ���� ���̴�. 
	 *     ���� ���, �� �ٿ� �������ִ� ������ ���̰� 20, 15, 10, 17�̶�� ����. ����̰� ���̸� 15�� �����ߴٸ�, 
	 *     ������ �ڸ� ���� ���̴� 15, 15, 10, 15�� �� ���̰�, ����̴� ���̰� 5�� ������ 2�� ������ ��� ���� �� ���̴�. 
	 *     (�� 7���͸� ���� ��� ����) ���ܱ⿡ ������ �� �ִ� ���̴� ���� ���� �Ǵ� 0�̴�.
	 *     ����̴� ȯ�濡 �ſ� ������ ���� ������, 
	 *     ������ �ʿ��� ��ŭ�� ������ ���������� �Ѵ�. 
	 *     �̶�, ��� M������ ������ ���� �������� ���ؼ� ���ܱ⿡ ������ �� �ִ� ������ �ִ��� ���ϴ� ���α׷��� �ۼ��Ͻÿ�.
	 * 
	 * �Է�: ù° �ٿ� ������ �� N�� ����̰� ������ ���������� �ϴ� ������ ���� M�� �־�����. (1 �� N �� 1,000,000, 1 �� M �� 2,000,000,000) 
	 *      ��° �ٿ��� ������ ���̰� �־�����. 
	 *      ������ ������ ���� �׻� M���� ũ�ų� ���� ������, ����̴� ���� �ʿ��� ������ �׻� ������ �� �ִ�. ���̴� 1,000,000,000���� �۰ų� ���� ���� ���� �Ǵ� 0�̴�.
	 * 
	 * ���: ��� M������ ������ ���� �������� ���ؼ� ���ܱ⿡ ������ �� �ִ� ������ �ִ��� ����Ѵ�.
	 * 
	 * Ǯ��: upperbound����̶�µ� *****************�ʹ� ��ƴ�
	 *     
	 * */

public static void main(String[] args) throws IOException {
		
		BufferedReader br = new BufferedReader(new InputStreamReader(System.in));
		
		StringTokenizer st = new StringTokenizer(br.readLine(), " ");
		
		int N = Integer.parseInt(st.nextToken());
		int M = Integer.parseInt(st.nextToken());
		
		int[] tree = new int[N];
		
		int min = 0;
		int max = 0;
		
		st = new StringTokenizer(br.readLine(), " ");
		for(int i = 0; i < N; i++) {
			tree[i] = Integer.parseInt(st.nextToken());
			if(max < tree[i]) {
				max = tree[i];
			}
		}
		
		while(min < max) {//���Ⱑ upperbound �̺�Ž�� ���
			
			int mid = (min + max) / 2;
			long sum = 0;
			for(int treeHeight : tree) {				
				if(treeHeight - mid > 0) { 
					sum += (treeHeight - mid);
				}
			}			
			if(sum < M) {
				max = mid;
			}			
			else {
				min = mid + 1;
			}
		}		
		System.out.println(min - 1);
		
	}

}
