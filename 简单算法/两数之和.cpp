/*给定一个整数数组 nums 和一个目标值 target，请你在该数组中找出和为目标值的那 两个 整数，并返回他们的数组下标。

你可以假设每种输入只会对应一个答案。但是，你不能重复利用这个数组中同样的元素。

示例:

给定 nums = [2, 7, 11, 15], target = 9

因为 nums[0] + nums[1] = 2 + 7 = 9
所以返回 [0, 1]
*/
class Solution {
public:
    vector<int> twoSum(vector<int>& nums, int target) {
        vector<int> result;
		int first_num;
		for (int i = 0; i < nums.size()-1; i++){
			first_num = nums[i];
			for (int j = i + 1; j < nums.size(); j++) {
				if (first_num + nums[j] == target) {
					result.push_back(i);
					result.push_back(j);
					return result;
				}
			}
		}
        return result;
    }
};
