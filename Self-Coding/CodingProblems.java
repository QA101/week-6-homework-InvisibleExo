import java.lang.reflect.Array;
import java.util.Arrays;
import java.util.HashMap;
import java.util.Map;

public class CodingProblems {

	public static void main(String[] args) {
		//Part 1
		int [] original = {1,5,1,-1,1,1,1,1};
		System.out.println(keepPositive(original));
		
		//Part 2
		palindromeCheck("Civic");
		palindromeCheck("Batman");
		
		//Part 3
		int [] originalList = {5, 0, 5};
		int [] originalList2 = {3, 4, 5};
		System.out.println(Arrays.toString(originalList) + intPalindrome(originalList));
		System.out.println(Arrays.toString(originalList2)+ intPalindrome(originalList2));
		
		
		// Part 4
		String theThing = "ahhhhhhhhhbbbbbbbhhhhhhhhgggggssssssschhhhhhhhdddddddddd";
		duplicatesFound(theThing);
		
		//Part 5
		System.out.println("Unique characters for " + theThing + " are: " + noDupes(theThing));
		
		//Part 6
		String subject1 = "Parachute".toLowerCase();
		String subject2 = "Raphtueac".toLowerCase();
		anagramCheck(subject1, subject2);
		
	}
	//Part 1
	
	public static String keepPositive(int [] original) {
		String result = "";
		int i = 0;
		while (i < original.length) {
			if (original[i] > 0 ) {
				result = result + " " + (original[i]);
			}
			else if(original[i] <= 0) {
				result = "";
			}
			i++;
		}
		return result;
	}
	
	//Part 2
	public static String wordBackward(String subject) {
		String result = "";
		for(int i = subject.length()-1; i >= 0; i--) {
			result += subject.charAt(i);
		}
		return result;
	}
	public static boolean palindromeCheck(String subject) {
		if (subject.equalsIgnoreCase(wordBackward(subject))) {
			System.out.println(subject + " is a palindrome.");
			return true;
		}
		else {
			System.out.println(subject + " isn't a palindrome.");
			return false;
		}
	}
	
	//Part 3
	public static int [] reverseArr(int [] original) {
		int [] reverse = new int [original.length];
		for (int i = 0; i < reverse.length; i++) {
			reverse[i] = original[(reverse.length-1)-i];
		}
		return reverse;
	}
	public static boolean intPalindrome(int [] original) {
		if (Arrays.equals(original, reverseArr(original))){
			System.out.println("This is a palindrome number.");
			return true;
		}
		else {
			System.out.println("This isn't a palindrome number.");
			return false;
		}
	}
	
	//Part 4
	public static Map<Character, Integer> duplicatesFound(String subject){
		Map <Character,Integer> dupChar = new HashMap<>();
		int i = 0;
		while (i < subject.length()) {
			if (dupChar.containsKey(subject.charAt(i))) {
				int count = dupChar.get(subject.charAt(i));
				dupChar.put(subject.charAt(i), count+1);
			}
			else {
				dupChar.put(subject.charAt(i), 1);
			}
			i++;
		}
		System.out.println("Duplicate letters are: ");
		for (Character e : dupChar.keySet()) {
			if (dupChar.get(e) > 1) {
				System.out.println(e + " : " + dupChar.get(e));
			}
		}
		return dupChar;
	}

	//Part 5
	public static String noDupes(String subject) {
		String result = "";
		Map<Character, Integer> dupChar = new HashMap<>();
		int i = 0;
		while (i < subject.length()) {
			if(dupChar.containsKey(subject.charAt(i))) {
				int count = dupChar.get(subject.charAt(i));
				dupChar.put(subject.charAt(i), count + 1);
			}
			else {
				dupChar.put(subject.charAt(i), 1);
				result = result + subject.charAt(i);
			}
			i++;
		}
		return result;
	}
	
	//Part 6
	public static void anagramCheck(String str1, String str2) {
		int i = 0;
		Map<Character, Integer> map1 = new HashMap<>();
		Map<Character, Integer> map2 = new HashMap<>();
		
		do {
			if (map1.containsKey(str1.charAt(i))){
				int count = map1.get(str1.charAt(i));
				map1.put(str1.charAt(i), count + 1);
			}
			else {
				map1.put(str1.charAt(i), 1);
			}
			i++;
		} while (i < str1.length());
		i = 0;
		do {
			if (map2.containsKey(str2.charAt(i))){
				int count = map2.get(str2.charAt(i));
				map2.put(str2.charAt(i), count + 1);
			}
			else {
				map2.put(str2.charAt(i), 1);
			}
			i++;
		} while (i <str2.length());
		if (map1.keySet().equals(map2.keySet())){
			System.out.println(str1 + " & " + str2 + " are anagrams.");
		}
		else {
			System.out.println(str1 + " & " + str2 + " aren't anagrams.");
		}
		
	}
	
}
