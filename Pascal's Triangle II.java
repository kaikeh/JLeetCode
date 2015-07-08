/*
*Question
*Given an index k, return the k^th row of the Pascal's triangle.
*For example, given k = 3,
*Return [1,3,3,1].
*Note:
*Could you optimize your algorithm to use only O(k) extra space?
*/

//Solution
public class Solution {
    public List<Integer> getRow(int rowIndex) {
        List<Integer> ptRow = new ArrayList<>();
		int res[][] = new int[2][rowIndex+1];
		int rowNum = 0;
		int point1=0, point2=0;
		for(;rowNum <= rowIndex; rowNum++) {
			for(int i=0; i<=rowNum; i++) {
				point1 = rowNum%2;
				point2 = (rowNum+1)%2;
				if(i == 0 || i == rowNum) {
					res[point1][i] = 1;
					continue;
				}
				res[point1][i] = res[point2][i-1] + res[point2][i];
			}
		}
		for(int j=0; j <= rowIndex; j++) {
			ptRow.add(res[point1][j]);
		}
		return ptRow;
    }
}
