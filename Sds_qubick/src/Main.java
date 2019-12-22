import java.io.BufferedReader;
import java.io.InputStreamReader;
import java.util.Arrays;

public class Main {

	static int[] a = {1,2,3,4,5,6,7,8,9};
	static int[] b = {10,11,12,13,14,15,16,17,18};
	static int[] c= {19,20,21,22,23,24,25,26,27};
	static int[] d = {36,35,34,33,32,31,30,29,28};
	static int[] e = {37,38,39,40,41,42,43,44,45};
	static int[] f = {46,47,48,49,50,51,52,53,54};
	static int[] a2 = {1,2,3,4,5,6,7,8,9};
	static int[] b2 = {10,11,12,13,14,15,16,17,18};
	static int[] c2= {19,20,21,22,23,24,25,26,27};
	static int[] d2 = {36,35,34,33,32,31,30,29,28};
	static int[] e2 = {37,38,39,40,41,42,43,44,45};
	static int[] f2 = {46,47,48,49,50,51,52,53,54};

	public static void main(String[] args) throws Exception {
		// TODO Auto-generated method stub

		BufferedReader br = new BufferedReader(new InputStreamReader(System.in));
		int T = Integer.parseInt(br.readLine());
		for(int i=0; i<T; i++) {
			String[] tmp = br.readLine().split(" ");
			int rotate_count = Integer.parseInt(tmp[0]);
			for(int j=1; j<rotate_count+1; j++) {
				int k = Integer.parseInt(tmp[j]);
				switch(k) {
				case 1:
					up_col1(a,b,c,d,e);
					break;
				case 2:
					up_col2(a,b,c,d);
					break;

				case 3:
					up_col3(a,b,c,d,f);
					break;

				case 4:
					down_col1(a,b,c,d,e);
					break;
				case 5:
					down_col2(a,b,c,d);
					break;
				case 6:
					down_col3(a,b,c,d,f);
					break;
				case 7:
					left_row1(a,b,d,e,f);
					break;
				case 8:
					left_row2(b,d,e,f);
					break;
				case 9:
					left_row3(b,c,d,e,f);
					break;
				case 10:
					right_row1(a,b,d,e,f);
					break;
				case 11:
					right_row2(b,d,e,f);
					break;
				case 12:
					right_row3(b,c,d,e,f);
					break;

				}
			}

			int number = Integer.parseInt(tmp[tmp.length-1]);
			
			System.out.print("#"+(i+1)+" ");
			switch(number) {
			case 1: 
				for(int p=0; p<9; p++) {
					System.out.print(a[p]+" ");
				}
				System.out.println();
				break;
			case 2: 
				for(int p=0; p<9; p++) {
					System.out.print(b[p]+" ");
				}
				System.out.println();
				break;
			case 3: 
				for(int p=0; p<9; p++) {
					System.out.print(c[p]+" ");
				}
				System.out.println();
				break;
			case 4: 
				for(int p=8; p>=0; p--) {
					System.out.print(d[p]+" ");
				}
				System.out.println();
				break;
			case 5: 
				for(int p=0; p<9; p++) {
					System.out.print(e[p]+" ");
				}
				System.out.println();
				break;
			case 6: 
				for(int p=0; p<9; p++) {
					System.out.print(f[p]+" ");
				}
				System.out.println();
				break;
			}
			initArr();
		}



	}

	static void rotate2(int [] arr, int num) { //시계

		
		int[] arr2 = Arrays.copyOf(arr, arr.length);
		arr[0]=arr2[6];
		arr[1]=arr2[3];
		arr[2]=arr2[0];
		arr[3]=arr2[7];
		arr[4]=arr2[4];
		arr[5]=arr2[1];
		arr[6]=arr2[8];
		arr[7]=arr2[5];
		arr[8]=arr2[2];
		
		switch(num) {
		case 4:
			e=arr;
			break;
		case 12:
			c=arr;
			break;
		case 7:
			a=arr;
			break;

		
		case 3:
			f=arr;
			break;
	
			
			
		}
	}

	static void rotate1(int [] arr, int num) { //반시계
		int[] arr2 = Arrays.copyOf(arr, arr.length);
		arr[0]=arr2[2];
		arr[1]=arr2[5];
		arr[2]=arr2[8];
		arr[3]=arr2[1];
		arr[4]=arr2[4];
		arr[5]=arr2[7];
		arr[6]=arr2[0];
		arr[7]=arr2[3];
		arr[8]=arr2[6];
		
		switch(num) {
		case 10:
			a=arr;
			break;
	
		case 6:
			f=arr;
			break;
		case 9:
			c=arr;
			break;
	
		case 1:
			e=arr;
			break;
		
			
			
		}

	}

	static void up_col1(int[] arrA,int[] arrB, int[] arrC, int[] arrD, int[] arrE) {
		int[] arrA2 = Arrays.copyOf(arrA, arrA.length);
		int[] arrB2 = Arrays.copyOf(arrB, arrB.length);
		int[] arrC2 = Arrays.copyOf(arrC, arrC.length);
		int[] arrD2 = Arrays.copyOf(arrD, arrD.length);

		a[0]=arrB2[0];
		a[3]=arrB2[3];
		a[6]=arrB2[6];

		b[0]=arrC2[0];
		b[3]=arrC2[3];
		b[6]=arrC2[6];

		c[0]=arrD2[8];
		c[3]=arrD2[5];
		c[6]=arrD2[2];

		d[2]=arrA2[6];
		d[5]=arrA2[3];
		d[8]=arrA2[0];

		rotate1(e,1);

	}

	static void down_col1(int[] arrA,int[] arrB, int[] arrC, int[] arrD, int[] arrE) {

		int[] arrA2 = Arrays.copyOf(arrA, arrA.length);
		int[] arrB2 = Arrays.copyOf(arrB, arrB.length);
		int[] arrC2 = Arrays.copyOf(arrC, arrC.length);
		int[] arrD2 = Arrays.copyOf(arrD, arrD.length);

		a[0]=arrD2[2];
		a[3]=arrD2[5];
		a[6]=arrD2[8];

		b[0]=arrA2[0];
		b[3]=arrA2[3];
		b[6]=arrA2[6];

		c[0]=arrB2[0];
		c[3]=arrB2[3];
		c[6]=arrB2[6];

		d[2]=arrC2[6];
		d[5]=arrC2[3];
		d[8]=arrC2[0];

		rotate2(e,4);
	}

	static void up_col2(int[] arrA,int[] arrB, int[] arrC, int[] arrD) {
		int[] arrA2 = Arrays.copyOf(arrA, arrA.length);
		int[] arrB2 = Arrays.copyOf(arrB, arrB.length);
		int[] arrC2 = Arrays.copyOf(arrC, arrC.length);
		int[] arrD2 = Arrays.copyOf(arrD, arrD.length);

		a[1]=arrB2[1];
		a[4]=arrB2[4];
		a[7]=arrB2[7];

		b[1]=arrC2[1];
		b[4]=arrC2[4];
		b[7]=arrC2[7];

		c[1]=arrD2[7];
		c[4]=arrD2[4];
		c[7]=arrD2[1];

		d[1]=arrA2[7];
		d[4]=arrA2[4];
		d[7]=arrA2[1];
	}

	static void down_col2(int[] arrA,int[] arrB, int[] arrC, int[] arrD) {

		int[] arrA2 = Arrays.copyOf(arrA, arrA.length);
		int[] arrB2 = Arrays.copyOf(arrB, arrB.length);
		int[] arrC2 = Arrays.copyOf(arrC, arrC.length);
		int[] arrD2 = Arrays.copyOf(arrD, arrD.length);

		a[1]=arrD2[7];
		a[4]=arrD2[4];
		a[7]=arrD2[1];

		b[1]=arrA2[1];
		b[4]=arrA2[4];
		b[7]=arrA2[7];

		c[1]=arrB2[1];
		c[4]=arrB2[4];
		c[7]=arrB2[7];

		d[1]=arrC2[7];
		d[4]=arrC2[4];
		d[7]=arrC2[1];

	}

	static void up_col3(int[] arrA,int[] arrB, int[] arrC, int[] arrD, int[] arrF) {
		int[] arrA2 = Arrays.copyOf(arrA, arrA.length);
		int[] arrB2 = Arrays.copyOf(arrB, arrB.length);
		int[] arrC2 = Arrays.copyOf(arrC, arrC.length);
		int[] arrD2 = Arrays.copyOf(arrD, arrD.length);

		a[2]=arrB2[2];
		a[5]=arrB2[5];
		a[8]=arrB2[8];

		b[2]=arrC2[2];
		b[5]=arrC2[5];
		b[8]=arrC2[8];

		c[2]=arrD2[0];
		c[5]=arrD2[3];
		c[8]=arrD2[6];

		d[0]=arrA2[2];
		d[3]=arrA2[5];
		d[6]=arrA2[8];

		rotate2(f,3);
	}

	static void down_col3(int[] arrA,int[] arrB, int[] arrC, int[] arrD, int[] arrF) {

		int[] arrA2 = Arrays.copyOf(arrA, arrA.length);
		int[] arrB2 = Arrays.copyOf(arrB, arrB.length);
		int[] arrC2 = Arrays.copyOf(arrC, arrC.length);
		int[] arrD2 = Arrays.copyOf(arrD, arrD.length);

		a[2]=arrD2[6];
		a[5]=arrD2[3];
		a[8]=arrD2[0];

		b[2]=arrA2[2];
		b[5]=arrA2[5];
		b[8]=arrA2[8];
		
		c[2]=arrB2[2];
		c[5]=arrB2[5];
		c[8]=arrB2[8];

		d[6]=arrC2[2];
		d[3]=arrC2[5];
		d[0]=arrC2[8];

		rotate1(f,6);
	}

	static void right_row1(int[] arrA, int[] arrB, int[] arrD, int[] arrE, int[] arrF) {
		int[] arrB2 = Arrays.copyOf(arrB, arrB.length);
		int[] arrD2 = Arrays.copyOf(arrD, arrD.length);
		int[] arrE2 = Arrays.copyOf(arrE, arrE.length);
		int[] arrF2 = Arrays.copyOf(arrF, arrF.length);

		b[0]=arrE2[0];
		b[1]=arrE2[1];
		b[2]=arrE2[2];

		f[0]=arrB2[0];
		f[1]=arrB2[1];
		f[2]=arrB2[2];

		e[0]=arrD2[0];
		e[1]=arrD2[1];
		e[2]=arrD2[2];

		d[0] = arrF2[0];
		d[1] = arrF2[1];
		d[2] = arrF2[2];

		rotate1(a,10); //a 반시계회전

	}


	static void left_row1(int[] arrA, int[] arrB, int[] arrD, int[] arrE, int[] arrF) {
		int[] arrB2 = Arrays.copyOf(arrB, arrB.length);
		int[] arrD2 = Arrays.copyOf(arrD, arrD.length);
		int[] arrE2 = Arrays.copyOf(arrE, arrE.length);
		int[] arrF2 = Arrays.copyOf(arrF, arrF.length);

		b[0]=arrF2[0];
		b[1]=arrF2[1];
		b[2]=arrF2[2];

		f[0]=arrD2[0];
		f[1]=arrD2[1];
		f[2]=arrD2[2];


		e[0]=arrB2[0];
		e[1]=arrB2[1];
		e[2]=arrB2[2];

		d[0] = arrE2[0];
		d[1] = arrE2[1];
		d[2] = arrE2[2];

		rotate2(a,7);
	}

	static void right_row2(int[] arrB, int[] arrD, int[] arrE, int[] arrF) {
		int[] arrB2 = Arrays.copyOf(arrB, arrB.length);
		int[] arrD2 = Arrays.copyOf(arrD, arrD.length);
		int[] arrE2 = Arrays.copyOf(arrE, arrE.length);
		int[] arrF2 = Arrays.copyOf(arrF, arrF.length);

		b[3]=arrE2[3];
		b[4]=arrE2[4];
		b[5]=arrE2[5];

		f[3]=arrB2[3];
		f[4]=arrB2[4];
		f[5]=arrB2[5];


		e[3]=arrD2[3];
		e[4]=arrD2[4];
		e[5]=arrD2[5];

		d[3] = arrF2[3];
		d[4] = arrF2[4];
		d[5] = arrF2[5];

	}

	static void left_row2(int[] arrB, int[] arrD, int[] arrE, int[] arrF) {
		int[] arrB2 = Arrays.copyOf(arrB, arrB.length);
		int[] arrD2 = Arrays.copyOf(arrD, arrD.length);
		int[] arrE2 = Arrays.copyOf(arrE, arrE.length);
		int[] arrF2 = Arrays.copyOf(arrF, arrF.length);

		b[3]=arrF2[3];
		b[4]=arrF2[4];
		b[5]=arrF2[5];

		f[3]=arrD2[3];
		f[4]=arrD2[4];
		f[5]=arrD2[5];


		e[3]=arrB2[3];
		e[4]=arrB2[4];
		e[5]=arrB2[5];

		d[3] = arrE2[3];
		d[4] = arrE2[4];
		d[5] = arrE2[5];

	}

	static void right_row3(int[] arrB, int[] arrC, int[] arrD, int[] arrE, int[] arrF) {
		int[] arrB2 = Arrays.copyOf(arrB, arrB.length);
		int[] arrD2 = Arrays.copyOf(arrD, arrD.length);
		int[] arrE2 = Arrays.copyOf(arrE, arrE.length);
		int[] arrF2 = Arrays.copyOf(arrF, arrF.length);

		b[6]=arrE2[6];
		b[7]=arrE2[7];
		b[8]=arrE2[8];

		f[6]=arrB2[6];
		f[7]=arrB2[7];
		f[8]=arrB2[8];


		e[6]=arrD2[6];
		e[7]=arrD2[7];
		e[8]=arrD2[8];

		d[6] = arrF2[6];
		d[7] = arrF2[7];
		d[8] = arrF2[8];

		rotate2(c,12);

	}


	static void left_row3(int[] arrB, int[] arrC, int[] arrD, int[] arrE, int[] arrF) {
		int[] arrB2 = Arrays.copyOf(arrB, arrB.length);
		int[] arrD2 = Arrays.copyOf(arrD, arrD.length);
		int[] arrE2 = Arrays.copyOf(arrE, arrE.length);
		int[] arrF2 = Arrays.copyOf(arrF, arrF.length);

		b[6]=arrF2[6];
		b[7]=arrF2[7];
		b[8]=arrF2[8];

		f[6]=arrD2[6];
		f[7]=arrD2[7];
		f[8]=arrD2[8];


		e[6]=arrB2[6];
		e[7]=arrB2[7];
		e[8]=arrB2[8];

		d[6] = arrE2[6];
		d[7] = arrE2[7];
		d[8] = arrE2[8];

		rotate1(c,9);
	}
	
	static void initArr() {
		a=Arrays.copyOf(a2, a2.length);
		b=Arrays.copyOf(b2, b2.length);
		c=Arrays.copyOf(c2, c2.length);
		d=Arrays.copyOf(d2, d2.length);
		e=Arrays.copyOf(e2, e2.length);
		f=Arrays.copyOf(f2, f2.length);
	}
}
