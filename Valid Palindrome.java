/**
 *Question
 *Given a string, determine if it is a palindrome, 
 *considering only alphanumeric characters and ignoring cases.
 *For example,
 *"A man, a plan, a canal: Panama" is a palindrome.
 *"race a car" is not a palindrome.
 *Note:
 *Have you consider that the string might be empty? This is a good question to ask during an interview.
 *For the purpose of this problem, we define empty string as valid palindrome.
**/

//Solution
public class Solution {
    public boolean isPalindrome(String s) {
        String change = s.toLowerCase();
		char c1 = 'a',c2 = 'b';
		int length = s.length();
		int i=0,j=length-1;
		if(s.length() <= 1)
			return true;
		while(i<j) {
			for(;i<j;i++) {
				c1 = change.charAt(i);
				if(c1<'a' || c1>'z')
					break;
			}
			for(;i<j;j--) {
				c2 = change.charAt(j);
				if(c2<'a' || c2>'z')
					break;
			}
			if(c1 != c2)
				return false;
		}
		return true;
    }
}
