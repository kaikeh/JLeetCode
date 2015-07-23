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
    public boolean isValid(char c){
        if(c >= 'a' && c <= 'z') 
            return true;
        if(c >= '0' && c <= '9') 
            return true;
        return false;
    }
    public boolean isPalindrome(String s) {
        if(s.equals("")) 
        	return true;
        s = s.toLowerCase();
        int len = s.length();
        int left = 0, right = len - 1;
        while(left < right){
            while(!isValid(s.charAt(left))){
                left++;
                if(left >= right) 
                    return true;
            } 
            while(!isValid(s.charAt(right))){
                right--;
                if(left >= right) 
                    return true;
            }
            if(s.charAt(left) != s.charAt(right)) 
                return false;
            left++;
            right--;
        }
        return true;
    }
}
