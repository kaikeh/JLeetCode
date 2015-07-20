/**
 *Question
 *Implement strStr().
 *Returns the index of the first occurrence of needle in haystack,
 *or -1 if needle is not part of haystack.
**/

//Solution
public class Solution {
    public int strStr(String haystack, String needle) {
        if(needle.isEmpty()) 
        	return 0;
        if(needle.length() > haystack.length()) 
        	return -1;
        int hlength = haystack.length();
        int nlength = needle.length();
        for(int i=0; i<(hlength-nlength+1); i++) {
        	int j = 0;
        	for(j=0; j<nlength; j++) {
        		if(haystack.charAt(i+j) != needle.charAt(j)) 
        			break;
        	}
        	if(j == nlength) 
        		return i;
        }
        return -1;
    }
}
