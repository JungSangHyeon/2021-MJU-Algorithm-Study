package bruteforce;

import java.io.BufferedReader;
import java.io.IOException;
import java.io.InputStreamReader;
import java.util.Arrays;

public class BOJ1759 {


	/*
	 * 9�� ����������
	 * 
	 * ����: �ٷ� ���� �ֹ��� ������ �� ���踦 �ָӴϿ� ���� ä �����ϰ� ����� �� ������ Ȳ���� ��Ȳ�� ������ ��������, 
	 *     702ȣ�� ���ο� ���� �ý����� ��ġ�ϱ�� �Ͽ���. �� ���� �ý����� ���谡 �ƴ� ��ȣ�� �����ϰ� �Ǿ� �ִ� �ý����̴�.
	 *     ��ȣ�� ���� �ٸ� L���� ���ĺ� �ҹ��ڵ�� �����Ǹ� �ּ� �� ���� ����(a, e, i, o, u)�� �ּ� �� ���� �������� �����Ǿ� �ִٰ� �˷��� �ִ�. 
	 *     ���� ���ĵ� ���ڿ��� ��ȣ�ϴ� �������� �������� �̷�� ���� ��ȣ�� �̷�� ���ĺ��� ��ȣ���� �����ϴ� ������ �迭�Ǿ��� ���̶�� �����ȴ�. 
	 *     ��, abc�� ���ɼ��� �ִ� ��ȣ������ bac�� �׷��� �ʴ�.
	 *     �� ���� �ý��ۿ��� �������� ��ȣ�� ������� ���� ������ ������ C������ �ִٰ� �Ѵ�. 
	 *     �� ���ĺ��� �Լ��� �ν�, ���� ������ �������� �濡 ħ���ϱ� ���� ��ȣ�� ������ ������ �Ѵ�. 
	 *     C���� ���ڵ��� ��� �־����� ��, ���ɼ� �ִ� ��ȣ���� ��� ���ϴ� ���α׷��� �ۼ��Ͻÿ�.
	 * 
	 * �Է�: ù° �ٿ� �� ���� L, C�� �־�����. (3 �� L �� C �� 15) ���� �ٿ��� C���� ���ڵ��� �������� ���еǾ� �־�����. �־����� ���ڵ��� ���ĺ� �ҹ����̸�, �ߺ��Ǵ� ���� ����
	 * 
	 * ���: �� �ٿ� �ϳ���, ���������� ���ɼ� �ִ� ��ȣ�� ��� ����Ѵ�.
	 * 
	 * Ǯ��: Backtracking (DFS)
	 * 
	 * �ع�: ���۰� ���ÿ� �迭 �����ϰ� ������ ���� ���� �ľ��ϸ� ��.
	 * */

	
	private static String[] arr;
    private static int l, c;
    
    //���� ��� ����
    // 1. ���ڿ� L��
    // 2. �ּ� ���� 1�� ���� 2�� �̻��̿����ϳ� == �̰� �������� ���� �ߺ�����
 
    public static void main(String[] args) throws IOException {
        BufferedReader br = new BufferedReader(new InputStreamReader(System.in));
        String[] tmp = br.readLine().split(" ");
        l = Integer.parseInt(tmp[0]);
        c = Integer.parseInt(tmp[1]);
 
        arr = br.readLine().split(" ");
        Arrays.sort(arr);
 
        solve(0,"");
    }
    private static void solve(int idx, String str){
        if(str.length() == l){// ���� 1
            if(isPossible(str)){ // ���� 1��, ���� 2�� �̻� ����
                System.out.println(str);
            }
            return;
        }
        if(idx >= c ){// �ǳ����� �������� 
            return;
        }
        
        // ���ڿ� �ڱⰡ ���ԵǾ� �ִ��� �ƴ��� Ȯ��
        solve(idx+ 1, str + arr[idx]);// �ڱ��ڽŰ� ���� ���ڱ��� ����
        solve(idx+ 1, str );// �ڱ��ڽŸ�
    }
 
    private static boolean isPossible(String str){
        int vowel = 0, consonant = 0;
        for (int i = 0; i < str.length(); i++) {
            if(isVowel(str.charAt(i))){
                vowel++;
            }else {
                consonant++;
            }
        }
        return vowel>=1 && consonant >=2;
    }
 
 
    private static boolean isVowel( char ch ){
        return ch == 'a' | ch=='e' | ch=='i' | ch=='o' | ch=='u';
    }
}






//�̿�
//�̰Ŵ� ���� ������ ���� ������, Ǯ�� ����� ���� ���ͳݿ��� ã�ƺ�������, �Ϻ����� �ʾ���
//�׷��� �� ����� �������Ѽ� ������ �Ϻ��� �ش��� �����س��� ������ ������ ã�� ���ϰ���.
