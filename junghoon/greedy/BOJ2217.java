package greedy;

import java.io.BufferedReader;
import java.io.IOException;
import java.io.InputStreamReader;
import java.util.Arrays;
import java.util.StringTokenizer;

public class BOJ2217 {
	
	/* 21�� 10�� 3���� ( 16.10.21 )
	 * 
	 * ����: N(1 �� N �� 100,000)���� ������ �ִ�. 
	 *      �� ������ �̿��Ͽ� �̷� ���� ��ü�� ���ø� �� �ִ�. 
	 *      ������ ������ �� ���⳪ ���̰� �ٸ��� ������ �� �� �ִ� ��ü�� �߷��� ���� �ٸ� ���� �ִ�.
	 *      ������ ���� ���� ������ ���ķ� �����ϸ� ������ ������ �ɸ��� �߷��� ���� �� �ִ�. 
	 *      k���� ������ ����Ͽ� �߷��� w�� ��ü�� ���ø� ��, ������ �������� ��� ���� w/k ��ŭ�� �߷��� �ɸ��� �ȴ�.
	 *      �� �����鿡 ���� ������ �־����� ��, �� �������� �̿��Ͽ� ���ø� �� �ִ� ��ü�� �ִ� �߷��� ���س��� ���α׷��� �ۼ��Ͻÿ�. 
	 *      ��� ������ ����ؾ� �� �ʿ�� ������, ���Ƿ� �� ���� ������ ��� ����ص� �ȴ�.
	 * 
	 * �Է�: ù° �ٿ� ���� N�� �־�����. ���� N���� �ٿ��� �� ������ ��ƿ �� �ִ� �ִ� �߷��� �־�����. �� ���� 10,000�� ���� �ʴ� �ڿ����̴�.
	 * 
	 * ���: ù° �ٿ� ���� ����Ѵ�.
	 * 
	 * Ǯ��: greedy �˰���, ���ķ� ����� ������ ��ƿ �� �ִ� �ִ� �߷�// w = min(����� ���� �߷�) * ������ ��
	 *     
	 * */
	
	public static void main(String[] args) throws IOException {
        BufferedReader br = new BufferedReader(new InputStreamReader(System.in));
        StringTokenizer st = new StringTokenizer(br.readLine());
        
        int cnt = Integer.parseInt(st.nextToken());
        int arr[] = new int[cnt];
        for(int i=0; i < cnt; i++) {
            st = new StringTokenizer(br.readLine());
            arr[i] = Integer.parseInt(st.nextToken());
        }
        Arrays.sort(arr);
        
        long max = 0;
        for(int i = cnt-1; i >= 0; i--) {
            arr[i] = arr[i] * (cnt-i);
            if(max < arr[i]) max = arr[i];
        }
        System.out.println(max);
    }

}
