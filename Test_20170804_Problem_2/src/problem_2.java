/*
 * Test 20170804 第一次評測上機考
 * Problem_2
 * 20170814 訂正版
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
		// result 用以儲存結果，result[0]儲存離目標數n的距離最小值，
		//					  result[1], result[2]儲存此最小值的組合index.
		int[] result = new int [3];
		
		//填入-1
		result[0] = -1;

		int temp;
		for (int i = 0; i < nums.length - 1; i++) {
			if (nums[i] != 0) {
				for (int j = i + 1; j < nums.length - i; j++) {
					if (nums[j] != 0) {
						temp = Math.abs((nums[i] + nums[j]) - target);
						if (result[0] == -1) {
							result[0] = temp;
							result[1] = j;
							result[2] = i;
						}
						else if (temp < result[0]) {
							result[0] = temp;
							result[1] = i;
							result[2] = j;
						}
					}
				}
			}
		}
		
		System.out.print("Answer 1 (two numbers):");
		System.out.printf("%d  %d\n", nums[result[1]], nums[result[2]]);
	}
	
	public static void threeNumbers(int target, int[] nums) {
		// result 用以儲存結果，result[0]儲存離目標數n的距離最小值，
		//                   result[1]至result[3]儲存此最小值的組合index.
		int[] result = new int [4];
		result[0] = -1;
		int temp;

		for (int i = 0; i < nums.length - 2; i++) {
			if (nums[i] != 0) {
				for (int j = i + 1; j < nums.length - 1; j++) {
					if (nums[j] != 0) {
						for (int k = j + 1; k < nums.length; k++) {
							if (nums[k] != 0) {
								temp = Math.abs((nums[i] + nums[j] + nums[k]) - target);
								if (result[0] == -1) {
									result[0] = temp;
								}
								else if (temp < result[0]) {
									result[0] = temp;
									result[1] = i;
									result[2] = j;
									result[3] = k;
								}
							}
						}
					}
				}
			}
		}
		System.out.print("Answer 2 (three numbers):");
		System.out.printf("%d  %d  %d\n", nums[result[1]], nums[result[2]], nums[result[3]]);

	}

}
