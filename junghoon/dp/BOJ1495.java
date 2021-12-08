package DP;

import java.io.BufferedReader;
import java.io.IOException;
import java.io.InputStreamReader;
import java.util.ArrayList;

public class BOJ1495 {
	
	/* ��Ÿ����Ʈ
	 * 
	 * ����: Day Of Mourning�� ��Ÿ����Ʈ ����� �ٰ����� �������� ������ N���� ���� �����ϰ� �ִ�.
	 *      ���ݱ��� �������� �ٸ� ������ �����ֱ� ���ؼ� �̹� ���������� �Ź� ���� �����ϱ� ���� ������ �ٲٰ� �����Ϸ��� �Ѵ�.
	 *      ����, ������ �����ϱ� ���� ������ ���� �����ϱ� ���� �ٲ� �� �ִ� ������ ����Ʈ�� �������. 
	 *      �� ����Ʈ�� V��� ���� ��, V[i]�� i��° ���� �����ϱ� ���� �ٲ� �� �ִ� ������ �ǹ��Ѵ�. 
	 *      �׻� ����Ʈ�� ���� ���̷θ� ������ �ٲ� �� �ִ�. ��, ���� ������ P�̰� ���� i��° ���� �����ϱ� ���̶��, 
	 *      i�� ���� P+V[i]�� P-V[i] �� �����ؾ� �Ѵ�. ������, 0���� ���� ������ ������ �ٲٰų�, M���� ū ������ ������ �ٲ� �� ����.
	 *      ���� ���� N�� ���� ���� S, �׸��� M�� �־����� ��, ������ ���� ������ �� �ִ� ���� �� �ִ��� ���ϴ� ���α׷��� �ۼ��Ͻÿ�. 
	 *      ��� ���� ����Ʈ�� ���� ������� �����ؾ� �Ѵ�.
	 * 
	 * �Է�: ù° �ٿ� N, S, M�� �־�����. (1 �� N �� 50, 1 �� M �� 1,000, 0 �� S �� M) ��° �ٿ��� �� ���� �����ϱ� ���� �� �� �ִ� ������ ���̰� �־�����. 
	 *      �� ���� 1���� ũ�ų� ����, M���� �۰ų� ����.
	 * 
	 * ���: ù° �ٿ� ������ ������ ���� ���� �� �ִ��� ����Ѵ�. ���� ������ ���� ������ �� ���ٸ� (�߰��� ���� ������ �� �� ���ٸ�) -1�� ����Ѵ�.
	 * 
	 * Ǯ��: �� 0~M�� ������ volume, volume[v] = i�� i��° ���ֿ��� ���� v���� ������ �� �ִٴ� �� �ǹ��� 
	 *      ��, ���� v�� ������ �� �ִ� �� ��ȣ�� i�̴�. ���������� volume[x] = N �� x�߿��� ���� ū ���� �����
	 *     
	 * */
	
	 public static void main(String[] args) throws IOException {

	        BufferedReader br = new BufferedReader(new InputStreamReader(System.in));
	        
	        String[] inputs = br.readLine().split(" ");
	        
	        int N = Integer.parseInt(inputs[0]);
	        int S = Integer.parseInt(inputs[1]);
	        int M = Integer.parseInt(inputs[2]);

	        int[] diff = new int[N+1];
	        
	        inputs = br.readLine().split(" ");
	        
	        for (int i = 1; i <= N; i++) {
	            diff[i] = Integer.parseInt(inputs[i-1]);
	        }

	        int[] volume = new int[M + 1];
	        
	        for(int i=0; i<=M; i++){ 
	            volume[i] = -1;
	        }
	        
	        volume[S] = 0;

	        ArrayList<Integer> list = new ArrayList<>();

	        for(int i=1; i<=N; i++){ 
	            list.clear();
	            for(int j=0; j<=M; j++) { 
	                if(volume[j] == i-1) { 
	                    if (0 <= j - diff[i] && j - diff[i] <= M) {
	                        list.add(j - diff[i]);
	                    }
	                    if (0 <= j + diff[i] && j + diff[i] <= M) {
	                        list.add(j + diff[i]);
	                    }
	                }
	            }
	            for (int v : list) {
	                volume[v] = i;
	            }
	        }

	        for(int i=M; i>=0; i--){
	            if(volume[i] == N){
	                System.out.println(i);
	                return;
	            }
	        }
	        
	        System.out.println(-1);
	    }

}
