package StringMethods;

import java.util.Arrays;
import java.util.Base64;

/*
Visit the JavaDocs for the String class to view everything you can do with a String.  


HINT:  Here are some String methods you might find useful 
contains
replace
trim
length
getBytes
endsWith
split 
indexOf
lastIndexOf
compareTo(IgnoreCase)
substring


Here are some Character methods you might find useful:
Character.toLowerCase(char c);
Character.isLetter(char c);
Character.isDigit(char c);
Character.getNumericValue(char c);
 */

public class StringMethods {

	// Given Strings s1 and s2, return the longer String
	public static String longerString(String s1, String s2) {
		if(s1.length()>s2.length()) {
			return s1;
		}
		return s2;
	}

	
	// if String s contains the word "underscores", change all of the spaces to underscores
	public static String formatSpaces(String s) {
		
		if(s.contains("underscores")) {
				s =	s.replaceAll(" ", "_");
		}
		return s;
	}

	
	// Return the name of the person whose LAST name would appear first if they were in alphabetical order
	// You cannot assume there are no extra spaces around the name, but you can
	// assume there is only one space between the first and last name
	public static String lineLeader(String s1, String s2, String s3) {
		s1 = s1.trim();
		s2 = s2.trim();
		s3 = s3.trim();
		String[] temp1 = new String[2];
		temp1 = s1.split(" ");
		String[] temp2 = new String[2];
		temp2 = s2.split(" ");
		String[] temp3 = new String[2];
		temp3 = s3.split(" ");
		if(temp1[1].compareTo(temp2[1])<0&&temp1[1].compareTo(temp3[1])<0) {
			return s1;
		}
		else if(temp2[1].compareTo(temp1[1])<0&&temp2[1].compareTo(temp3[01])<0) {
			return s2;
		}
		else {
		return s3;
		}
	}
	
	
	// Return the sum of all numerical digits in the String
	public static int numeralSum(String s) {
		int end = 0;
		for(int i = 0; i<s.length();i++) {
			if(s.substring(i, i+1).equals("0")) {
				end=end;
			}
			else if(s.substring(i, i+1).equals("1")) {
				end+=1;
			}
			else if(s.substring(i, i+1).equals("2")) {
				end+=2;
			}
			else if(s.substring(i, i+1).equals("3")) {
				end+=3;
			}
			else if(s.substring(i, i+1).equals("4")) {
				end+=4;
			}
			else if(s.substring(i, i+1).equals("5")) {
				end+=5;
			}
			else if(s.substring(i, i+1).equals("6")) {
				end+=6;
			}
			else if(s.substring(i, i+1).equals("7")) {
				end+=7;
			}
			else if(s.substring(i, i+1).equals("8")) {
				end+=8;
			}
			else if(s.substring(i, i+1).equals("9")) {
				end+=9;
			}
		}
		return end;
	}
	
	
	// Return the number of times String substring appears in String s
	public static int substringCount(String s, String substring) {
		int end = 0;
		int length = substring.length();
		for(int i = 0; i<=s.length()-length;i++) {
			if(s.substring(i, i+length).equals(substring)) {
				end++;
			}
		}
		
		return end;
	}

	// Call Utitilities.encrypt to encrypt String s
	public static String encrypt(String s, char key) {
	s= Utilities.encrypt(s.getBytes(), (byte) key);
		return s;
	}

	// Call Utilities.decrypt to decrypt the cyphertext
	public static String decrypt(String s, char key) {
	s =	Utilities.decrypt(s, (byte) key);
		return s;
	}


	// Return the number of words in String s that end with String substring
	// You can assume there are no punctuation marks between words
	public static int wordsEndsWithSubstring(String s, String substring) {
		int end = 0;
		String[] temp;
		temp = s.split(" ");
		for(int i = 0; i<temp.length;i++) {
			if(temp[i].endsWith(substring)) {
//				System.out.println(i);
//				System.out.println(temp[i]);
				end++;
			}
		}
		return end;
	}
	

	// Given String s, return the number of characters between the first occurrence
	// of String substring and the final occurrence
	// You can assume that substring will appear at least twice
	public static int distance(String s, String substring) {
//		int start = 0;;
//		int length = substring.length();
//		for(int i = 0; i<=s.length()-length;i++) {
//			if(s.substring(i, i+length).equals(substring)) {
//				start =i;
//				break;
//				}
//			}
//		int end = 0;
//		for(int i = 0; i<=s.length()-length;i++) {
//			if(s.substring(i, i+length).equals(substring)) {
//				end = i+1;
//			}
//		}
//		System.out.println(end-start);
//		return end-start;
	int start =	s.indexOf(substring);
	int end = s.lastIndexOf(substring);
	int distance = 0;
	for(int i = substring.length()+start;i<end;i++) {
		distance++;
	}
	return distance;
	}


	// Return true if String s is a palindrome
	// palindromes are words or phrases are read the same forward as backward.
	// HINT: ignore/remove all punctuation and spaces in the String
	public static boolean palindrome(String s) {
		String temp = "";
	s =	s.toLowerCase();
	s = s.trim();
	for(int i= s.length()-1; i>=0;i--) {
		if(s.charAt(i)!=','&&s.charAt(i)!='?'&&s.charAt(i)!=':'&&s.charAt(i)!='.'&&s.charAt(i)!=' ') {
		temp = temp+s.charAt(i);
		}
	}
		s=temp;
		String end = "";
		for(int i= s.length()-1; i>=0;i--) {
			if(s.charAt(i)!=','&&s.charAt(i)!='?'&&s.charAt(i)!=':'&&s.charAt(i)!='.'&&s.charAt(i)!=' ') {
			end = end+s.charAt(i);
			}
		}
		System.out.println(end);
		System.out.println(s);
		if(end.equals(s)) {
			return true;
		}
		return false;
	}
	
}

class Utilities {
	// This basic encryption scheme is called single-byte xor. It takes a single
	// byte and uses exclusive-or on every character in the String.
	public static String encrypt(byte[] plaintext, byte key) {
		for (int i = 0; i < plaintext.length; i++) {
			plaintext[i] = (byte) (plaintext[i] ^ key);
		}
		return Base64.getEncoder().encodeToString(plaintext);
	}

	public static String decrypt(String cyphertext, byte key) {
		byte[] b = Base64.getDecoder().decode(cyphertext);
		for (int i = 0; i < b.length; i++) {
			b[i] = (byte) (b[i] ^ key);
		}
		return new String(b);
	}
}
