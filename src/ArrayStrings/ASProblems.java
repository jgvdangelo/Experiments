package ArrayStrings;

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
	
	public static void main(String[] args) {
		// Problem 1.3
		char[] toURL = " Diana Ross Jr         ".toCharArray();
		System.out.println(new String(urlify(toURL)));
	}
}
