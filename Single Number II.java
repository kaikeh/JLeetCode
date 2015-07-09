/**Question
 *Given an array of integers, every element appears three times except for one. 
 *Find that single one.
 *Note:
 *Your algorithm should have a linear runtime complexity. 
 *Could you implement it without using extra memory?
**/
 
//Solution
class Solution {
    public int singleNumber(int[] nums) {
    	int num_bytes = 32;
    	int repeat_times = 3;
        int bits[] = new int[num_bytes];
        for(int i = 0; i<nums.length; i++)
        	for(int j = 0; j<32; j++)
        		bits[j] += ((nums[i] >> j) & 1);
        int result = 0;
        for (int j = 0; j < 32; j++)  
            if (bits[j] % repeat_times != 0)  
              result += (1 << j);  
        return result;
    }
}