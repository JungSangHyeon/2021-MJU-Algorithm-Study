package year_2021.month_07.day_27;

import java.io.BufferedReader;
import java.io.IOException;
import java.io.InputStreamReader;
import java.util.Arrays;
import java.util.StringTokenizer;

public class BOJ2470 {
	
	// Scanner ���� �Ʒ��� ���� ���� �о�� �ڴ�.
	// �̰� ���ϱ� �ð� �ʰ� �� �ɸ���

	public static void main(String[] args) throws NumberFormatException, IOException {
		BufferedReader br = new BufferedReader(new InputStreamReader(System.in));
		int n = Integer.parseInt(br.readLine());
		int[] numbers = new int[n];
		StringTokenizer st = new StringTokenizer(br.readLine());
		for (int i = 0; i < n; i++) numbers[i] = Integer.parseInt(st.nextToken());
		Arrays.sort(numbers);

		int lowIndex = 0, highIndex = n - 1;
		int minSumAbs = 2000000000;
		int[] answer = new int[2];
		while (lowIndex < highIndex) {
			int sum = numbers[lowIndex] + numbers[highIndex];

			if (minSumAbs > Math.abs(sum)) {
				minSumAbs = Math.abs(sum);
				answer[0] = numbers[lowIndex];
				answer[1] = numbers[highIndex];
			}

			if (sum < 0) lowIndex++;
			else if (sum > 0) highIndex--;
			else if (sum == 0) break;
		}
		System.out.println(answer[0] + " " + answer[1]);
	}
}
