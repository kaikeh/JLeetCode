/**
 *Question
 *Given an array of integers, find if the array contains any duplicates. 
 *Your function should return true if any value appears at least twice 
 *in the array, and it should return false if every element is distinct.
**/

//Solution
public class Solution {
    public boolean containsDuplicate(int[] nums) {
    	HashSet<Integer> hs = new HashSet<>();
    	for(int i=0;  i<nums.length; i++) {
        	if(hs.contains(Integer.valueOf(nums[i]))) 
        		return true;
        	else 
        		hs.add(Integer.valueOf(nums[i]));
        }
        return false;
    }
}
