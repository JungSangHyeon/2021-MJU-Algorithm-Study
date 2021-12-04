package DP;

import java.io.BufferedReader;
import java.io.IOException;
import java.io.InputStreamReader;
import java.util.StringTokenizer;

public class BOJ11049 {
	
	/* ��� ���� ����
	 * 
	 * ����: ũ�Ⱑ N��M�� ��� A�� M��K�� B�� ���� �� �ʿ��� ���� ������ ���� �� N��M��K���̴�. 
	 *      ��� N���� ���ϴµ� �ʿ��� ���� ������ ���� ����� ���ϴ� ������ ���� �޶����� �ȴ�.
	 *      ���� ���, A�� ũ�Ⱑ 5��3�̰�, B�� ũ�Ⱑ 3��2, C�� ũ�Ⱑ 2��6�� ��쿡 ����� �� ABC�� ���ϴ� ��츦 �����غ���.
	 *      AB�� ���� ���ϰ� C�� ���ϴ� ��� (AB)C�� �ʿ��� ���� ������ ���� 5��3��2 + 5��2��6 = 30 + 60 = 90���̴�.
	 *      BC�� ���� ���ϰ� A�� ���ϴ� ��� A(BC)�� �ʿ��� ���� ������ ���� 3��2��6 + 5��3��6 = 36 + 90 = 126���̴�.
	 *      ���� ����������, ������ �ϴ� ������ ���� ���� ������ ���� �޶�����.
	 *      ��� N���� ũ�Ⱑ �־����� ��, ��� ����� ���ϴµ� �ʿ��� ���� ���� Ƚ���� �ּڰ��� ���ϴ� ���α׷��� �ۼ��Ͻÿ�. 
	 *      �Է����� �־��� ����� ������ �ٲٸ� �� �ȴ�.
	 * 
	 * �Է�: ù° �ٿ� ����� ���� N(1 �� N �� 500)�� �־�����.
	 * ��° �ٺ��� N�� �ٿ��� ����� ũ�� r�� c�� �־�����. (1 �� r, c �� 500)
	 * �׻� ������� ������ �� �� �ִ� ũ�⸸ �Է����� �־�����.
	 * 
	 * ���: ù° �ٿ� �Է����� �־��� ����� ���ϴµ� �ʿ��� ���� ������ �ּڰ��� ����Ѵ�. 
	 *      ������ 231-1 ���� �۰ų� ���� �ڿ����̴�. ����, �־��� ������ �����ص� ���� Ƚ���� 231-1���� �۰ų� ����.
	 * 
	 * Ǯ��: ��� ���� : A��� * B��� = A���� �� * A���� �� * B�� ���� �� = ��İ���Ƚ��
	 *     
	 * */
	
	public static void main(String [] args) throws IOException{
		
        BufferedReader reader = new BufferedReader(new InputStreamReader(System.in));
        
        int n = Integer.parseInt(reader.readLine());
  
        int [][] a = new int[n][2];
        int [][] dp = new int[n][n];
        
        for(int i=0; i<n; i++) {
            StringTokenizer st = new StringTokenizer(reader.readLine());
            a[i][0] = Integer.parseInt(st.nextToken());
            a[i][1] = Integer.parseInt(st.nextToken());
        }
        
        for(int i=1; i<n; i++) {
            for(int j=0; j<n-i; j++) {
                dp[j][j+i] = Integer.MAX_VALUE;
                for(int k=0; k<i; k++) {
                    int cost = dp[j][j+k] + dp[j+k+1][j+i] + a[j][0] * a[j+k][1] * a[j+i][1];
                    dp[j][j+i] = Math.min(dp[j][j+i], cost);
                }
            }
        }
        System.out.println(dp[0][n-1]);
    }


}
