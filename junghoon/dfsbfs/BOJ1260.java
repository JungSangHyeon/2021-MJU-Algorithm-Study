package dfsbfs;

import java.io.IOException;
import java.util.LinkedList;
import java.util.Queue;
import java.util.Scanner;

public class BOJ1260 {
	/* DFS�� BFS
	 * 
	 * ����: �׷����� DFS�� Ž���� ����� BFS�� Ž���� ����� ����ϴ� ���α׷��� �ۼ��Ͻÿ�. 
	 *      ��, �湮�� �� �ִ� ������ ���� ���� ��쿡�� ���� ��ȣ�� ���� ���� ���� �湮�ϰ�, �� �̻� �湮�� �� �ִ� ���� ���� ��� �����Ѵ�. 
	 *      ���� ��ȣ�� 1������ N�������̴�.
	 * 
	 * �Է�: ù° �ٿ� ������ ���� N(1 �� N �� 1,000), ������ ���� M(1 �� M �� 10,000), Ž���� ������ ������ ��ȣ V�� �־�����. 
	 *     ���� M���� �ٿ��� ������ �����ϴ� �� ������ ��ȣ�� �־�����. � �� ���� ���̿� ���� ���� ������ ���� �� �ִ�. 
	 *     �Է����� �־����� ������ ������̴�.
	 * 
	 * ���: ù° �ٿ� DFS�� ������ �����, �� ���� �ٿ��� BFS�� ������ ����� ����Ѵ�. V���� �湮�� ���� ������� ����ϸ� �ȴ�.
	 * 
	 * Ǯ��: �׷����� dfs, bfs �̿��Ͽ� Ž��, dfs bfs�������� �����ֳ�? ���̶� �ʺ�  dfs�� �ϸ鼭 bfs�� �ϳ�?
	 *     
	 * */
	
	 static int[][] check;
	  static boolean[] checked; 
	  static int n; 
	  static int m; 
	  static int start; 	 
	  
	  public static void dfs(int i) {
	    checked[i] = true;
	    System.out.print(i + " ");
	    
	    for(int j = 1; j <= n; j++) {
	      if(check[i][j] == 1 && checked[j] == false) {
	        dfs(j);
	      }
	    }
	  }
	  
	  public static void bfs() {
	    Queue<Integer> queue = new LinkedList<Integer>();
	    queue.offer(start); 
	    checked[start] = true;
	    System.out.print(start + " ");
	    
	    while(!queue.isEmpty()) {
	      int temp = queue.poll();
	      
	      for(int j = 1; j <= n; j++) {
	        if(check[temp][j] == 1 && checked[j] == false) {
	          queue.offer(j);
	          checked[j] = true;
	          System.out.print(j + " ");
	        }
	      }
	    }
	  }
	  
	  public static void main(String[] args) throws IOException {
		  Scanner sc = new Scanner(System.in);
		  n = sc.nextInt();
		  m = sc.nextInt();
		  start = sc.nextInt();
		  
		  check = new int[1001][1001];
		  checked = new boolean[1001];
		  
		  for(int i = 0; i < m; i++) {
		    int x = sc.nextInt();
		    int y = sc.nextInt();
		    
		    check[x][y] = check[y][x] = 1;
		  }
		  
		  dfs(start);
		  
		  checked = new boolean[1001];
		  System.out.println();
		  
		  bfs(); 
		  }

}
