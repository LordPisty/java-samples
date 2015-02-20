package problems;

import java.util.HashSet;
import java.util.Set;

public class Part1 {

	/**
	 * @param args
	 */
	public static void main(String[] args) {
		System.out.println(solution(new int[]{4,1,1,2,4,2,4,1}));
		System.out.println(solution(new int[]{1,3,1}));
		System.out.println(solution("1321"));
		System.out.println(solution("2113"));
		System.out.println(solution("7"));
		System.out.println(solution("777"));
		
		
	}
	
	// duplicate half string with next number
	// 1321 ==> 1414
	// 7 ==> 11
	public static String solution(String S) {
		
		if (S.length() % 2 == 0) {
			// even
			int leftN = new Integer(S.substring(0, S.length() / 2));
			int rightN = new Integer(S.substring(S.length() / 2));
			
			if (leftN >= rightN) {
				return S.substring(0, S.length() / 2) + S.substring(0, S.length() / 2);
			} else {
				String half = String.valueOf(leftN + 1);
				return half + half;
			}
			
		} else {
			// odd
			String half = "1";
			for (int i = 0; i < S.length() / 2; i++){
				half += "0";
			}
			return half + half;
		}
		
	}
	
	// split array with all unique numbers right and left
	public static int solution(int[] A) {
		int counter = 0;
		
		int[] left = new int[A.length];
		Set<Integer> uniqueL = new HashSet<Integer>();
		
		int[] right = new int[A.length];
		Set<Integer> uniqueR = new HashSet<Integer>();
		
		Set<Integer> unique = new HashSet<Integer>();
		
		for (int i = 0; i < A.length; i++) {
			unique.add(A[i]);
			left[i] = uniqueL.size();
			uniqueL.add(A[i]);
		}
		
		for (int i = A.length-1; i >= 0; i--) {
			uniqueR.add(A[i]);
			right[i] = uniqueR.size();
		}
		
		for (int i = 0; i < A.length; i++) {
			if (left[i] == right[i] && left[i] == unique.size()) {
				counter++;
			}
		}
		
		return counter;
	}

}
