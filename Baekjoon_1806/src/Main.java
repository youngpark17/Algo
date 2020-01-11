import java.io.BufferedReader;

import java.io.InputStreamReader;


public class Main {

	public static int[] arr;

	public static void main(String[] args) throws Exception{
		// TODO Auto-generated method stub
		BufferedReader br = new BufferedReader(new InputStreamReader(System.in));
		String[] tmp = br.readLine().split(" ");
		int n = Integer.parseInt(tmp[0]);
		int s = Integer.parseInt(tmp[1]);
		arr = new int[n];
		tmp = br.readLine().split(" ");
		for(int i=0; i<tmp.length; i++) {
			arr[i] = Integer.parseInt(tmp[i]);
		}
		int p1 = 1;
		int p2 = 0;
		int answer = n+1;
		if(arr[p1]>=s||arr[p2]>=s) {
			System.out.println(1);
			System.exit(0);
		}
		int sum=0;
		sum+=arr[p1]+arr[p2];
		while(!(arr.length-1==p2)) { //p2가 끝에 있다면 종료.
			if(sum>=s) { //합이 목표값 보다 크거나 같을때
				 //합이 목표값일때
				int k=p1-p2+1; 
				answer = Math.min(k, answer);
				if(p2<p1) {
					sum-=arr[p2]; //합이 목표값보다 크다면 왼쪽 포인터 오른쪽으로 이동
					p2++;
				}
				else if(p1==p2) { //p1이 p2와 같을떄
					sum+=arr[++p1];
				}
				if(sum>=s) { //포인터 이동했을때 SUM이
					k = p1-p2+1;
					answer = Math.min(k, answer);
				}
						
			}
			else {
				if(p1<arr.length-1) {
					p1++;
					sum+=arr[p1];
					
				}
				else { //p1이 끝에 있다면... p2가 올라오면 더이상 만 족하는 것 없음
					break;
					
				}
			}
		}
		if(answer==n+1) {
			answer=0;
		}
		System.out.println(answer);


	}



}
