package dfsbfs;

import java.util.ArrayList;
import java.util.Collections;
import java.util.Scanner;

public class BOJ2667 {
	/* ������ȣ���̱�
	 * 
	 * ����: <�׸� 1>�� ���� ���簢�� ����� ������ �ִ�. 1�� ���� �ִ� ����, 0�� ���� ���� ���� ��Ÿ����. 
	 *      ö���� �� ������ ������ ����� ���� ������ ������ �����ϰ�, ������ ��ȣ�� ���̷� �Ѵ�. 
	 *      ���⼭ ����Ǿ��ٴ� ���� � ���� �¿�, Ȥ�� �Ʒ����� �ٸ� ���� �ִ� ��츦 ���Ѵ�. 
	 *      �밢���� ���� �ִ� ���� ����� ���� �ƴϴ�. 
	 *      <�׸� 2>�� <�׸� 1>�� �������� ��ȣ�� ���� ���̴�. 
	 *      ������ �Է��Ͽ� �������� ����ϰ�, �� ������ ���ϴ� ���� ���� ������������ �����Ͽ� ����ϴ� ���α׷��� �ۼ��Ͻÿ�.
	 * 
	 * �Է�: ù ��° �ٿ��� ������ ũ�� N(���簢���̹Ƿ� ���ο� ������ ũ��� ������ 5��N��25)�� �Էµǰ�, �� ���� N�ٿ��� ���� N���� �ڷ�(0Ȥ�� 1)�� �Էµȴ�.
	 * 
	 * ���: ù ��° �ٿ��� �� �������� ����Ͻÿ�. �׸��� �� ������ ���� ���� ������������ �����Ͽ� �� �ٿ� �ϳ��� ����Ͻÿ�.
	 * 
	 * Ǯ��: ���ںپ��־, String������ �޾Ƽ� charAt�ؼ� �������, �迭���� 1�� �߰ߵǸ� 1����, �׸��� arrayList�� �־��� �� ũ�Ⱑ ������ ������ ��
	 *     
	 * */
	
	static int N;
	static int[][] Map;
	static int count;
	static int[] dr = {-1, 1, 0, 0};
	static int[] dc = {0, 0, -1, 1};
	
	static ArrayList<Integer> result;
	static boolean[][] check;
	
	public static void main(String[] args) {
		Scanner sc= new Scanner(System.in);
		N = sc.nextInt();
		Map = new int[N][N];
		check = new boolean[N][N];
		for(int i = 0; i < N; i++) {
			String input = sc.next();
			for(int j = 0; j < N; j++) {
				Map[i][j] = input.charAt(j)-'0';
			}
		}
		count = 0;
		result = new ArrayList<>();
		for(int i = 0; i < N; i++) {
			for(int j = 0; j < N; j++) {
				if(Map[i][j]==1 && !check[i][j]) {
					count = 1;
					Search(i, j);
					result.add(count);
				}
			}
		}
		Collections.sort(result);
		System.out.println(result.size());
		for(int c : result) System.out.println(c);
	}
	
	public static int Search(int x, int y) {
		check[x][y] = true;
		for(int i =0; i < 4; i++) {
			int nx = x +dr[i];
			int ny = y +dc[i];
			
			if(nx >= 0 && ny >= 0 && nx < N && ny < N) {
				if(Map[nx][ny] ==1 && !check[nx][ny]) {
					Search(nx, ny);
					count++;
				}
			}
		}
		return count;
	}

}