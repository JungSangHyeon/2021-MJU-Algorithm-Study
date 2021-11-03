package greedy;

import java.util.ArrayList;
import java.util.Collections;
import java.util.Scanner;

/* 21년 10월 4주차 ( 23.10.21 )
 * 
 * 문제: 언제나 최고만을 지향하는 굴지의 대기업 진영 주식회사가 신규 사원 채용을 실시한다. 
 *      인재 선발 시험은 1차 서류심사와 2차 면접시험으로 이루어진다. 
 *      최고만을 지향한다는 기업의 이념에 따라 그들은 최고의 인재들만을 사원으로 선발하고 싶어 한다.
 *      그래서 진영 주식회사는, 다른 모든 지원자와 비교했을 때 서류심사 성적과 면접시험 성적 중 적어도 하나가 
 *      다른 지원자보다 떨어지지 않는 자만 선발한다는 원칙을 세웠다. 
 *      즉, 어떤 지원자 A의 성적이 다른 어떤 지원자 B의 성적에 비해 서류 심사 결과와 면접 성적이 모두 떨어진다면 A는 결코 선발되지 않는다.
 *      이러한 조건을 만족시키면서, 진영 주식회사가 이번 신규 사원 채용에서 선발할 수 있는 신입사원의 최대 인원수를 구하는 프로그램을 작성하시오.
 * 
 * 입력: 첫째 줄에는 테스트 케이스의 개수 T(1 ≤ T ≤ 20)가 주어진다.
 *      각 테스트 케이스의 첫째 줄에 지원자의 숫자 N(1 ≤ N ≤ 100,000)이 주어진다. 
 *      둘째 줄부터 N개 줄에는 각각의 지원자의 서류심사 성적, 면접 성적의 순위가 공백을 사이에 두고 한 줄에 주어진다. 
 *      두 성적 순위는 모두 1위부터 N위까지 동석차 없이 결정된다고 가정한다.
 * 
 * 출력: 각 테스트 케이스에 대해서 진영 주식회사가 선발할 수 있는 신입사원의 최대 인원수를 한 줄에 하나씩 출력한다.
 * 
 * 풀이: 순위 등수를 입력받음 -> 1,2 들어오면 1이 더 높은거임 -> 서로 따로따로따로 서류와 면접 순위를 비교해서 골라야함 --> 좀 까다롭네
 *      1, 서류 등수 오름차순 -> 서류 1등은 비교 안해도됨, 이후에 2등부터 면접등수로 판단
 *     
 * */

class Grade implements Comparable<Grade>{
	int a;
	int b;
	
	Grade(int a, int b){
		this.a = a;
		this.b =b;
	}
	
	@Override
	public int compareTo(Grade o) {
		if(this.a > o.a) {
			return 1;
		} else {
			return -1;
		}
	}
}

public class BOJ1946 {
	
	public static void main(String[] args) {
		Scanner sc = new Scanner(System.in);
		int T = sc.nextInt();

		for(int t = 0; t < T; t++) {
			int N = sc.nextInt();
			ArrayList<Grade> list = new ArrayList<>();

			for(int i = 0; i < N; i++) {
				int a = sc.nextInt();
				int b = sc.nextInt();

				list.add(new Grade(a, b));
			}

			Collections.sort(list); //여기가 서류 정렬

			int ans = 1; 
			int min = list.get(0).b; 
			for(int i = 1; i < N; i++) { 
				if(list.get(i).b < min) { 
					ans++;
					min = list.get(i).b;
				}
			}
			System.out.println(ans);
		}	
	}
	
}
