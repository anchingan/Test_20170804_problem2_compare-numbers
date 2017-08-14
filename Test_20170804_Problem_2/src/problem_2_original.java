/*
 * Test 20170804 第一次評測上機考
 * Problem_2
 */

import java.util.Scanner;

public class problem_2 {

	public static void main(String[] args) {
		Scanner scanner = new Scanner(System.in);
		
		//Input 10 numbers.
		int[] numbers = new int [10];
		System.out.print("Numbers:");
		for (int i = 0; i < 10; i++)
			numbers[i] = scanner.nextInt();
		
		int n;
		do {
			System.out.print("n (-1 to quit):");
			n = scanner.nextInt();
			if (n == -1)
				break;
			twoNumbers(n, numbers);
			threeNumbers(n, numbers);
		} while (true);
		
		System.out.print("Program terminate.");

	}
	
	public static void twoNumbers(int target, int[] nums){
		// result 用以儲存結果，result[0][i]儲存離目標數n的距離最小值，result[1][i]儲存此最小值的組合index.
		int[][] result = new int [2][10];
		
		//填入-1
		for (int i = 0; i < 10; i++)
			result[0][i] = -1;
		int temp;
		for (int i = 0; i < nums.length; i++) {
			if (nums[i] != 0) {
				for (int j = i + 1; j < nums.length - i; j++) {
					if (nums[j] != 0) {
						temp = Math.abs((nums[i] + nums[j]) - target);
						if (result[0][i] == -1) {
							result[0][i] = temp;
							result[1][i] = j;
							result[0][j] = temp;
							result[1][j] = i;
						}
						else if (temp < result[0][i]) {
							result[0][i] = temp;
							result[1][i] = j;
						}
					}
				}
			}
		}
		//找出所有結果的最小值
		int indexOfMin = 0;
		int min = result[0][0];
		for (int i = 1; i < result.length; i++) {
			if (result[0][i] < min) {
				indexOfMin = i;
				min = result[0][i];
			}
		}
		System.out.print("Answer 1 (two numbers):");
		System.out.printf("%d  %d\n", nums[indexOfMin], nums[(result[1][indexOfMin])]);
	}
	
	public static void threeNumbers(int target, int[] nums) {
		// result 用以儲存結果，result[0][i]儲存離目標數n的距離最小值，
		//                   result[1][i]及result[2][i]儲存此最小值的組合index.
		int[][] result = new int [3][10];
		
		//填入-1
		for (int i = 0; i < 10; i++)
			result[0][i] = -1;
		int temp;
		for (int i = 0; i < nums.length; i++) {
			if (nums[i] != 0) {
				for (int j = i + 1; j < nums.length - i; j++) {
					if (nums[j] != 0) {
						for (int k = j + 1; k < nums.length - i; k++) {
							if (nums[k] != 0) {
								temp = Math.abs((nums[i] + nums[j] + nums[k]) - target);
								if (result[0][i] == -1) {
									result[0][i] = temp;
									result[1][i] = j;
									result[2][i] = k;
									result[0][j] = temp;
									result[1][j] = i;
									result[2][j] = k;
									result[0][k] = temp;
									result[1][k] = i;
									result[2][k] = j;
									
								}
								else if (temp < result[0][i]) {
									result[0][i] = temp;
									result[1][i] = j;
									result[2][i] = k;
								}
							}
						}
					}
				}
			}
		}
		//找出所有結果的最小值
		int indexOfMin = 0;
		int min = result[0][0];
		for (int i = 1; i < result.length; i++) {
			if (result[0][i] < min) {
				indexOfMin = i;
				min = result[0][i];
			}
		}
		System.out.print("Answer 2 (three numbers):");
		System.out.printf("%d  %d  %d\n", nums[indexOfMin], nums[(result[1][indexOfMin])], nums[(result[2][indexOfMin])]);

	}

}
