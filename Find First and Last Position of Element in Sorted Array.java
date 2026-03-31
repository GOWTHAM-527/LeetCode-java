class Solution {
    public int[] searchRange(int[] nums, int target) {
             int[] result = new int[2];
        result[0] = findFirst(nums, target);
        result[1] = findLast(nums, target);
        return result;
    }
    private int findFirst(int[] nums, int target) {
        int index = -1, low = 0, high = nums.length - 1;
        while (low <= high) {
            int mid = low + (high - low) / 2;
            if (nums[mid] >= target) high = mid - 1;
            else low = mid + 1;
            if (nums[mid] == target) index = mid;
        }
        return index;
    }
    private int findLast(int[] nums, int target) {
        int index = -1, low = 0, high = nums.length - 1;
        while (low <= high) {
            int mid = low + (high - low) / 2;
            if (nums[mid] <= target) low = mid + 1;
            else high = mid - 1;
            if (nums[mid] == target) index = mid;
        }
        return index;
    }
}