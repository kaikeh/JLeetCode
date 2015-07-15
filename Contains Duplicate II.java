/**
 *Question
 *Given an array of integers and an integer k, find out whether there there are 
 *two distinct indices i and j in the array such that nums[i] = nums[j] and 
 *the difference between i and j is at most k.
**/

//Solution
public class Solution {
    public boolean containsNearbyDuplicate(int[] nums, int k) {
        HashSet<Integer> hs = new HashSet<>();
        for(int i=0; i<nums.length; i++) {
        	if(i > k) {
        		hs.remove(Integer.valueOf(nums[i-k-1]));
        	}
        	if(hs.contains(Integer.valueOf(nums[i]))) 
        		return true;
        	else 
        		hs.add(Integer.valueOf(nums[i]));
        }
        return false;
    }
}
