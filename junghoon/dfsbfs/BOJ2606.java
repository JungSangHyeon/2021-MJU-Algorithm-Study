package dfsbfs;

import java.util.LinkedList;
import java.util.Queue;
import java.util.Scanner;

public class BOJ2606 {
	/* ���̷���
	 * 
	 * ����: ���� ���̷����� �� ���̷����� ��Ʈ��ũ�� ���� ���ĵȴ�. 
	 *      �� ��ǻ�Ͱ� �� ���̷����� �ɸ��� �� ��ǻ�Ϳ� ��Ʈ��ũ �󿡼� ����Ǿ� �ִ� ��� ��ǻ�ʹ� �� ���̷����� �ɸ��� �ȴ�.
	 *      ���� ��� 7���� ��ǻ�Ͱ� <�׸� 1>�� ���� ��Ʈ��ũ �󿡼� ����Ǿ� �ִٰ� ����. 
	 *      1�� ��ǻ�Ͱ� �� ���̷����� �ɸ��� �� ���̷����� 2���� 5�� ��ǻ�͸� ���� 3���� 6�� ��ǻ�ͱ��� ���ĵǾ� 
	 *      2, 3, 5, 6 �� ���� ��ǻ�ʹ� �� ���̷����� �ɸ��� �ȴ�. 
	 *      ������ 4���� 7�� ��ǻ�ʹ� 1�� ��ǻ�Ϳ� ��Ʈ��ũ�󿡼� ����Ǿ� ���� �ʱ� ������ ������ ���� �ʴ´�.
	 *      ��� �� 1�� ��ǻ�Ͱ� �� ���̷����� �ɷȴ�. 
	 *      ��ǻ���� ���� ��Ʈ��ũ �󿡼� ���� ����Ǿ� �ִ� ������ �־��� ��, 
	 *      1�� ��ǻ�͸� ���� �� ���̷����� �ɸ��� �Ǵ� ��ǻ���� ���� ����ϴ� ���α׷��� �ۼ��Ͻÿ�.
	 * 
	 * �Է�: ù° �ٿ��� ��ǻ���� ���� �־�����. ��ǻ���� ���� 100 �����̰� �� ��ǻ�Ϳ��� 1�� ���� ���ʴ�� ��ȣ�� �Ű�����. 
	 *      ��° �ٿ��� ��Ʈ��ũ �󿡼� ���� ����Ǿ� �ִ� ��ǻ�� ���� ���� �־�����. 
	 *      �̾ �� ����ŭ �� �ٿ� �� �־� ��Ʈ��ũ �󿡼� ���� ����Ǿ� �ִ� ��ǻ���� ��ȣ ���� �־�����.
	 * 
	 * ���: 1�� ��ǻ�Ͱ� �� ���̷����� �ɷ��� ��, 1�� ��ǻ�͸� ���� �� ���̷����� �ɸ��� �Ǵ� ��ǻ���� ���� ù° �ٿ� ����Ѵ�.
	 * 
	 * Ǯ��: ������ �׷����� arraylist�� �̿��Ͽ� ����.
	 *      1�� ���� �����ϴ� dfsŽ���ϰ�, depth�� ���� ���̷��� ���� ��Ų ��ǻ�͸� ������ ��
	 *     
	 * */
	
	static int node[][];
	static int check[]; 
	
	static void bfs(int start) { 
		
		Queue<Integer> queue = new LinkedList<>();
		
		check[start] =1;
		queue.offer(start);
		
		int cnt = 0; 
		
		while(!queue.isEmpty()) {
			int x = queue.poll();
			
			for(int i=1;i<node.length;i++) { 
				if(node[x][i]==1 && check[i]!=1) {
					queue.offer(i);
					check[i] = 1;
					cnt++;
				}
			}
		}
		System.out.println(cnt); 
	}
	
	public static void main(String[] args) {
		Scanner sc = new Scanner(System.in);	
		
		int n= sc.nextInt(); 
		int m = sc.nextInt(); 
		
		node=new int[n+1][n+1];
		check = new int[n+1];
		
		for(int i=0;i<m;i++) { 
			int a=sc.nextInt();
			int b = sc.nextInt();
			node[a][b]=1;
			node[b][a]=1;
			
		}
		
		bfs(1);
		
		
	}

}
