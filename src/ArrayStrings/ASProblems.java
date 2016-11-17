package arrayStrings;

import java.util.*;

public class ASProblems {
	
	// Problem 1.3
	public static char[] urlify(char[] str) {
		// find index of last character
		boolean isFound = false;
		int currIndex = str.length - 1;
		
		while (!isFound && currIndex >=0) {
			if (str[currIndex] != ' ') {
				isFound = true;
			} else {
				currIndex--;
			}
		}
		
		int stringLength = currIndex + 1;
		int stringEndIndex = currIndex;

		/// count number of spaces in the string
		int spacesCount = 0;
		for (int i = 0; i < stringLength; i++) {
			if (str[i] == ' ')
				spacesCount++;
		}
		
		/// find current length of string & compare to new length
			// to identify how many spaces are at the end of the string
		int numberOfSpacesAtEnd = (str.length - (2 * spacesCount + stringLength)) / 3;
		if ((str.length - (2 * spacesCount + stringLength)) % 3 != 0)
			throw new IllegalArgumentException();
		
		/// work backwards from the end of the array to shift elements into 
			// their proper position
		
		// first append spaces at the end
		currIndex = str.length - 1;
		for (int i = 0; i < numberOfSpacesAtEnd; i++) {
			str[currIndex] = '0';
			str[currIndex - 1] = '2';
			str[currIndex - 2] = '%';
			currIndex -= 3;
		}
		// now, start shifting letters to their position
		int letterIndex = stringEndIndex;
		while (letterIndex >= 0) {
			if (str[letterIndex] != ' ') {
				str[currIndex] = str[letterIndex];
				currIndex--;
			} else {
				str[currIndex] = '0';
				str[currIndex - 1] = '2';
				str[currIndex - 2] = '%';
				currIndex -= 3;
			}
			letterIndex--;
		}
		
		return str;
	}
	
	// Problem 1.4
	public static boolean palindromePermut(String str) {
		str = str.toLowerCase();
		Map<Character, Integer> map = new HashMap<Character, Integer>();
		char c; int asciiVal; int count;
		for (int i = 0; i < str.length(); i++) {
			c = str.charAt(i);
			asciiVal = (int) c;
			if (asciiVal >= 97 && asciiVal <= 122) {
				if (!map.containsKey(c)) {
					map.put(c, 1);
				} else {
					count = map.get(c);
					map.put(c, count + 1);
				}
			}
		}

		boolean oddIsFound = false;
		for (Map.Entry<Character, Integer> entry : map.entrySet()) {
			count = entry.getValue();
			if (count % 2 == 1 && !oddIsFound) {
				oddIsFound = true;
			} else if (count % 2 == 1 && oddIsFound) {
				return false;
			}
		}

		return true;
	}
	
	// Problem 1.5
	public static boolean oneAway(String str1, String str2, boolean saveMem) {
		if (str2.length() > str1.length() + 1 || str2.length() < str1.length() - 1) {
			return false;
		}
		if (!saveMem) {
			Map<Character, Boolean> map = new HashMap<Character, Boolean>();
			
			char[] chars1 = str1.toCharArray();
			char[] chars2 = str2.toCharArray();
			
			for (int i = 0; i < chars1.length; i++) {
				map.put(chars1[i], false);
			}
			
			for (int i = 0; i < chars2.length; i++) {
				if (map.containsKey(chars2[i]) && map.get(chars2[i]) == false) {
					map.put(chars2[i], true);
				}
			}
			
			int falseCount = 0;
			for (Character key : map.keySet()) {
				if (map.get(key) == false)
					falseCount++;
			}
			
			return (falseCount <= 1 ? true : false);
		} else {
			if (str1.length() == str2.length()) {
				boolean discrepFound = false;
				
				for (int i = 0; i < str1.length(); i++) {
					if (str1.charAt(i) != str2.charAt(i)) {
						if (!discrepFound) {
							discrepFound = true;
						} else {
							return false;
						}
					}
				}
				return true;
			} else {
				String smaller; String larger;
				if (str1.length() < str2.length()) {
					smaller = str1;
					larger = str2;
				} else {
					smaller = str2;
					larger = str1;
				}
				int smallIndex = 0;
				int largeIndex = 0;

				while (smallIndex < smaller.length() && largeIndex < larger.length()) {
					if (smaller.charAt(smallIndex) != larger.charAt(largeIndex)) {
						if (smallIndex == largeIndex) {
							largeIndex++;
						} else {
							return false;
						}
					} else {
						smallIndex++;
						largeIndex++;
					}
				}
				return true;
			}
		}
	}
	
	public static void main(String[] args) {
		
	}
}
