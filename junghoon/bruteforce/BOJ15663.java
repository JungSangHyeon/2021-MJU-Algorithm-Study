package bruteforce;

import java.util.Arrays;
import java.util.LinkedHashSet;
import java.util.Scanner;

public class BOJ15663 {

	

	/*
	 * 9�� ����������                                                           @@@@@@@@@@���� ����
	 * 
	 * ����: N���� �ڿ����� �ڿ��� M�� �־����� ��, �Ʒ� ������ �����ϴ� ���̰� M�� ������ ��� ���ϴ� ���α׷��� �ۼ��Ͻÿ�.
	 *  - N���� �ڿ��� �߿��� M���� �� ����
	 * 
	 * �Է�: ù° �ٿ� N�� M�� �־�����. (1 �� M �� N �� 8)
	 *      ��° �ٿ� N���� ���� �־�����. �Է����� �־����� ���� 10,000���� �۰ų� ���� �ڿ����̴�.
	 * 
	 * ���: �� �ٿ� �ϳ��� ������ ������ �����ϴ� ������ ����Ѵ�. �ߺ��Ǵ� ������ ���� �� ����ϸ� �ȵǸ�, �� ������ �������� �����ؼ� ����ؾ� �Ѵ�.
	 *      ������ ���� ������ �����ϴ� ������ ����ؾ� �Ѵ�.
	 * 
	 * Ǯ��: permutationȰ���ؼ� ������ ���ϴ� ���� (permutation: ���� �ణ ���̳ʸ� ������  1���� 2�� 2���� 3���� ���� ������ hierarchy����)
	 * 
	 * �ñ�: �ٵ� �� ù����� ���ð� �Ǵ°��� ���ٿ� �ϳ��� ���ǿ� �����ϴ� ������ ����ϴ°ǵ� ?
	 * */
	
	static int N, M;
	static int[] nums, perm;
	static boolean[] visit;
	static LinkedHashSet<String> ans;
	//Treeset�� �ƴ� LinkedHashset����ϴ� ����
	//�� �� ������ ������ Set�̶�� ���� ����!
	//LinkedHashSet�� �Է¼����� ����
	//TreeSet�� ������ ���ڷ� Comparator�� �Ѱ����� �ʴ´ٸ� �⺻������ �������� ����
	
	public static void main(String[] args) {
		Scanner scanner = new Scanner(System.in);
		N = scanner.nextInt();
		M = scanner.nextInt();
		
		nums = new int[N];
		perm = new int[M];
		visit = new boolean[N];
		ans = new LinkedHashSet<>();
		
		 for (int i = 0; i < N; i++)
	            nums[i] = scanner.nextInt();

	        Arrays.sort(nums);
	        permutation(0);
	        ans.forEach(System.out::println);
	}
	
	 static void permutation(int cnt) {
	        if (cnt == M) {
	            StringBuilder sb = new StringBuilder();
	            for (int p : perm)
	                sb.append(p).append(' ');
	            ans.add(sb.toString());
	            return;
	        }

	        for (int i = 0; i < N; i++) {
	            if (visit[i])
	                continue;
	            visit[i] = true;
	            perm[cnt] = nums[i];
	            permutation(cnt + 1);
	            visit[i] = false;
	        }
	    }

	
	
}
