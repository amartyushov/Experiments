package io.mart.round.six.zero.four;

import java.util.Scanner;
import java.util.regex.Matcher;
import java.util.regex.Pattern;

public class ProblemA {
	
	public static void main(String[] args) {
		Scanner scanner = new Scanner(System.in);
		
		while (scanner.hasNextLine()) {
			int number = Integer.parseInt(scanner.nextLine().trim());
			
			for (int k = 0; k < number; k++) {
				
				String line = scanner.nextLine();
				char[] chars = line.toCharArray();
				int length = chars.length;
				
				Pattern p = Pattern.compile("(\\w)\\1+");
				
				Matcher m = p.matcher(line);
				if (m.find()) {
					System.out.println("-1");
					continue;
				}
				
				if (length == 1) {
					if (chars[0] == '?') {
						System.out.println("a");
						continue;
					} else {
						System.out.println(chars[0]);
					}
				}
				
				if (length == 2) {
					char first = chars[0];
					char second = chars[1];
					
					if (first == '?' && second == '?') {
						System.out.println("ab");
					} else if (first == second) {
						System.out.println("-1");
					} else if (first == '?') {
						first = findSubstitute(second);
						System.out.println(first + "" + second);
					} else if (second == '?') {
						second = findSubstitute(first);
						System.out.println(first + "" + second);
					} else {
						System.out.println(first + "" + second);
					}
					continue;
				}
				
				for (int i = 0; i < length; i++) {
					if (chars[i] == '?' && i == 0) {
						chars[i] = findSubstitute(chars[i + 1]);
					} else if (chars[i] == '?' && i == length - 1) {
						if (chars[i - 1] == 'a') {
							chars[i] = 'b';
						}
						if (chars[i - 1] == 'b') {
							chars[i] = 'c';
						}
						if (chars[i - 1] == 'c') {
							chars[i] = 'b';
						}
					} else if (chars[i] == '?') {
						chars[i] = findSubstitute(chars[i - 1], chars[i + 1]);
					}
				}
				System.out.println(new String(chars));
			}
		}
	}
	
	private static char findSubstitute(char another) {
		if (another == 'a') {
			return 'b';
		}
		
		if (another == 'b') {
			return 'c';
		}
		
		if (another == 'c') {
			return 'a';
		}
		if (another == '?') {
			return 'a';
		}
		return 't';
	}
	private static char findSubstitute(char prev, char next) {
		if (prev == 'a' && next == 'b') {
			return 'c';
		}
		if (prev == 'a' && next == 'c') {
			return 'b';
		}
		if (prev == 'b' && next == 'a') {
			return 'c';
		}
		if (prev == 'b' && next == 'c') {
			return 'a';
		}
		if (prev == 'c' && next == 'a') {
			return 'b';
		}
		if (prev == 'c' && next == 'b') {
			return 'a';
		}
		if (prev == 'a' && next == 'a') {
			return 'b';
		}
		if (prev == 'b' && next == 'b') {
			return 'a';
		}
		if (prev == 'c' && next == 'c') {
			return 'a';
		}
		if (prev == 'a' && next == '?') {
			return 'b';
		}
		if (prev == 'b' && next == '?') {
			return 'c';
		}
		if (prev == 'c' && next == '?') {
			return 'a';
		}
		return 't';
	}
	
}

//10
//a
//b
//c
//?
//ab
//bb
//cc
//??
//a?
//b?
//c?
//?a
//?b
//?c

//1
//???????

//1
//bbb?