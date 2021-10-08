package binarysearch;

import java.io.BufferedReader;
import java.io.IOException;
import java.io.InputStreamReader;
import java.util.StringTokenizer;

public class BOJ6236 {
	
	/* 21�� 10�� 1���� ( 02.10.21 )                        ******���� ���� �ʿ�*******
	 * 
	 * ����: ����� �뵷�� ȿ�������� Ȱ���ϱ� ���� ��ȹ�� ¥��� �Ͽ���. 
	 *      ����� ������ N�� ���� �ڽ��� ����� �ݾ��� ����Ͽ���, ���� ���� ���� �ʱ� ���� ��Ȯ�� M���� ���忡�� ���� ���� ����� �Ͽ���. 
	 *      ����� ���忡�� K���� �����ϸ�, ���忡�� �� ������ �Ϸ縦 ���� �� ������ �״�� ����ϰ�, ���ڶ�� �Ǹ� ���� �ݾ��� ���忡 ����ְ� �ٽ� K���� �����Ѵ�. 
	 *      �ٸ� ����� M�̶�� ���ڸ� �����ϱ� ������, ��Ȯ�� M���� ���߱� ���ؼ� ���� �ݾ��� �׳� ����� �ݾ׺��� ������ ���� �ݾ��� ���忡 ����ְ� �ٽ� K���� ������ �� �ִ�. 
	 *      ����� ���� �Ƴ��� ���� ���� �ݾ� K�� �ּ�ȭ�ϱ�� �Ͽ���. ���찡 �ʿ��� �ּ� �ݾ� K�� ����ϴ� ���α׷��� �ۼ��Ͻÿ�.
	 * 
	 * �Է�: 1��° �ٿ��� N�� M�� �������� �־�����. (1 �� N �� 100,000, 1 �� M �� N)
	 *      2��° �ٺ��� �� N���� �ٿ��� ���찡 i��° ���� �̿��� �ݾ��� �־�����. (1 �� �ݾ� �� 10000)
	 * 
	 * ���: ù ��° �ٿ� ���찡 ���忡�� �����ؾ� �� �ּ� �ݾ� K�� ����Ѵ�.
	 * 
	 * Ǯ��: ���� M�� ���Ϸ� ä��� �����ϰ� �ְ� �� �� ����. �̰� �ٽ� 
	 *           *****�蹫�� �����ڴ� �ڵ� Ȯ��******
	 * */
	
	static int n, m;
	static int[] costs;
	
	static int getCount(int mid) {
		int remain = mid;
		int count = 1;
		for(int i = 0; i < n; i++) {
			if(remain - costs[i] < 0) {
				remain = mid;
				count++;
			}
			remain -= costs[i];
		}
		return count;
	}
	
	public static void main(String[] args) throws IOException{
		BufferedReader br = new BufferedReader(new InputStreamReader(System.in));
		StringTokenizer st = new StringTokenizer(br.readLine());
		n = Integer.parseInt(st.nextToken());
		m = Integer.parseInt(st.nextToken());
		costs = new int[n];
		int low = 1;
		int high = (int)1e9;
		int answer = 0;
		for (int i = 0; i < n; i++) {
            costs[i] = Integer.parseInt(br.readLine());
            low = Math.max(low, costs[i]);
        }

        while (low <= high) {
            int mid = (low + high) / 2;

            if (getCount(mid) > m) {
                low = mid + 1;
            } else {
                answer = mid;
                high = mid - 1;
            }
        }

        System.out.println(answer);
    }
	

}
