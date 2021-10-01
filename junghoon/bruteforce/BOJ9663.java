package bruteforce;

import java.io.BufferedReader;
import java.io.IOException;
import java.io.InputStreamReader;

public class BOJ9663 {
	
	

	/*
	 * 9�� ����������          ���� �ű���
	 * 
	 * ����: N-Queen ������ ũ�Ⱑ N �� N�� ü���� ���� �� N���� ���� ������ �� ���� ���� �����̴�.
	 *  - N�� �־����� ��, ���� ���� ����� ���� ���ϴ� ���α׷��� �ۼ��Ͻÿ�.
	 * 
	 * �Է�: ù° �ٿ� N�� �־�����. (1 �� N < 15)
	 * 
	 * ���: ù° �ٿ� �� N���� ���� ������ �� ���� ���� ����� ���� ����Ѵ�.
	 * 
	 * Ǯ��: Backtracking
	 * */
	
	public static int[] arr;
	public static int N; //ü���� ũ��
	public static int count = 0;
	
	public static void main(String[] args) throws IOException {
		BufferedReader br = new BufferedReader(new InputStreamReader(System.in));
		N = Integer.parseInt(br.readLine());
		arr = new int[N];
		
		nQueen(0);
		System.out.println(count);
	}
	
	
	//��� ȣ�� �κ� -> 1���� �迭�� �����ؼ� ǰ, index = ��, ���� = ��
	public static void nQueen(int depth) {
		//ù�ٺ��� Ȯ���ϴµ� ���� �� ä��� 1�����ϰ� ����
		if(depth == N) {
			count++;
			return;
		}
		
		for(int i = 0; i < N; i++) {
			arr[depth] = i;
			//possibility���� �ش� ���� i ��°�� ���� �� �ִ��� �˻�
			if(Possibility(depth)) {
				nQueen(depth + 1);
			}
		}
	}
	
	//���̴� ���̰� �ٸ� ���̶� ��ġ���� Ȯ��
	public static boolean Possibility(int collapse) {
		for(int i = 0; i < collapse; i++) {
			if(arr[collapse] == arr[i]) {
				return false;
			}
			//�밢���� ���� �� ==> ��� ��: ���� ���� ���� ���� ������ �밢���̶��� @@@@@@ �̰� �������� �𸣰���
			else if(Math.abs(collapse - i) == Math.abs(arr[collapse] - arr[i])){
				return false;
			}
		}
		return true;
	}

}
