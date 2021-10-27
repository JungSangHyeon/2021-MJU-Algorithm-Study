package greedy;

import java.io.BufferedReader;
import java.io.IOException;
import java.io.InputStreamReader;
import java.util.Arrays;
import java.util.Comparator;
import java.util.StringTokenizer;

public class BOJ1931 {

	/* 21�� 10�� 3���� ( 16.10.21 )
	 * 
	 * ����: �� ���� ȸ�ǽ��� �ִµ� �̸� ����ϰ��� �ϴ� N���� ȸ�ǿ� ���Ͽ� ȸ�ǽ� ���ǥ�� ������� �Ѵ�. 
	 *      �� ȸ�� I�� ���� ���۽ð��� ������ �ð��� �־��� �ְ�, �� ȸ�ǰ� ��ġ�� �ʰ� �ϸ鼭 ȸ�ǽ��� ����� �� �ִ� ȸ���� �ִ� ������ ã�ƺ���. 
	 *      ��, ȸ�Ǵ� �ѹ� �����ϸ� �߰��� �ߴܵ� �� ������ �� ȸ�ǰ� ������ �Ͱ� ���ÿ� ���� ȸ�ǰ� ���۵� �� �ִ�. 
	 *      ȸ���� ���۽ð��� ������ �ð��� ���� ���� �ִ�. �� ��쿡�� �������ڸ��� ������ ������ �����ϸ� �ȴ�.
	 * 
	 * �Է�: ù° �ٿ� ȸ���� �� N(1 �� N �� 100,000)�� �־�����. 
	 *      ��° �ٺ��� N+1 �ٱ��� �� ȸ���� ������ �־����µ� �̰��� ������ ���̿� �ΰ� ȸ���� ���۽ð��� ������ �ð��� �־�����. 
	 *      ���� �ð��� ������ �ð��� 231-1���� �۰ų� ���� �ڿ��� �Ǵ� 0�̴�.
	 * 
	 * ���: ù° �ٿ� �ִ� ����� �� �ִ� ȸ���� �ִ� ������ ����Ѵ�.
	 * 
	 * ��Ʈ: (1,4), (5,7), (8,11), (12,14) �� �̿��� �� �ִ�.
	 * 
	 * Ǯ��: greedy �˰��� --> Activity Selection Problem -> �� ����� �ϳ��� �۾��� ����, �׷��ٸ� �ִ� �۾�����? �� ȸ�ǰ� ��ġ�� �ʰ� ���ϱ�
	 *     
	 * */

	public static void main(String[] args) throws IOException {

		BufferedReader br = new BufferedReader(new InputStreamReader(System.in));

		int n = Integer.parseInt(br.readLine());

		int[][] time = new int[n][2];

		StringTokenizer st;

		for(int i = 0; i < n; i++) {
			st = new StringTokenizer(br.readLine(), " ");
			time[i][0] = Integer.parseInt(st.nextToken());
			time[i][1] = Integer.parseInt(st.nextToken());
		}

		Arrays.sort(time, new Comparator<int[]>(){ //÷���� 
			@Override
			public int compare(int[] o1, int[] o2) {
				if(o1[1] == o2[1]) {
					return o1[0] - o2[0];
				}
				return o1[1] - o2[1];
			}
		});

		int count = 0;
		int prevEndTime=0;

		for(int i = 0; i < n; i ++) {
			if(prevEndTime <= time[i][0]) {
				prevEndTime = time[i][1];
				count++;
			}
		}
		
		System.out.println(count);
	}


}
