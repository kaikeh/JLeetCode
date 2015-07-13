/**
 *Question
 *Compare two version numbers version1 and version2.
 *If version1 > version2 return 1, if version1 < version2 return -1, otherwise return 0.
 *
 *You may assume that the version strings are non-empty and contain only digits and the '.' character.
 *The '.' character does not represent a decimal point and is used to separate number sequences.
 *For instance, 2.5 is not "two and a half" or "half way to version three", 
 *it is the fifth second-level revision of the second first-level revision.
 *
 *Here is an example of version numbers ordering:
 *0.1 < 1.1 < 1.2 < 13.37
**/

//Solution
class Solution {
	int compareInt(int i1, int i2) {
		if(i1 > i2)
			return 1;
		if(i1 == i2)
			return 0;
		if(i1 < i2)
			return -1;
		return 0;
	}
    public int compareVersion(String version1, String version2) {
        int num1, num2;
        int index1, index2;
        
        do{
        	index1 = version1.lastIndexOf(".");
        	if(index1 == -1)
        		break;
        	num1 = Integer.parseInt(version1.substring(index1+1, version1.length()));
        	if(num1 == 0)
        		version1 = version1.substring(0, index1);
        }while(num1 == 0);
        
        do{
        	index2 = version2.lastIndexOf(".");
        	if(index2 == -1)
        		break;
        	num2 = Integer.parseInt(version2.substring(index2+1, version2.length()));
        	if(num2 == 0)
        		version2 = version2.substring(0, index2);
        }while(num2 == 0);
        
        while(true) {
        	index1 = version1.indexOf(".");
        	index2 = version2.indexOf(".");
        	if(index1 == -1) {
        		if(index2 == -1) {
        			num1 = Integer.parseInt(version1);
        			num2 = Integer.parseInt(version2);
        			return compareInt(num1, num2);
        		}
        		else {
        			num1 = Integer.parseInt(version1);
        			num2 = Integer.parseInt(version2.substring(0, index2));
        			if(num1 == num2)
        				return -1;
        			else
        				return compareInt(num1, num2);
        		}
        	}
        	else {
        		if(index2 == -1) {
        			num1 = Integer.parseInt(version1.substring(0, index1));
        			num2 = Integer.parseInt(version2);
        			if(num1 == num2)
        				return 1;
        			else
        				return compareInt(num1, num2);
        		}
        		else {
        			num1 = Integer.parseInt(version1.substring(0, index1));
        			num2 = Integer.parseInt(version2.substring(0, index2));
        			if(num1 == num2) {
        				version1 = version1.substring(index1+1, version1.length());
        				version2 = version2.substring(index2+1, version2.length());
        				continue;
        			}
        			else
        				return compareInt(num1, num2);
        		}        			
        	}
        }
    }
}
