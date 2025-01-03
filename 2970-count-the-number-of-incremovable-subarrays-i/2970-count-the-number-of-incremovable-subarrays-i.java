class Solution {
    public int incremovableSubarrayCount(int[] nums) {
        int n = nums.length; // Length of the input array
        int count = 0; // Initialize the count of incremovable subarrays
        int left = Integer.MIN_VALUE; // Initialize 'left' to track the maximum value of the prefix

        // Outer loop to iterate over the array from left to right
        for (int i = 0; i < n; i++) {
            int right = Integer.MAX_VALUE; // Initialize 'right' to track the minimum value of the suffix

            // Inner loop to iterate over the array from right to left, starting from the
            // end
            for (int j = n - 1; j >= i; j--) {
                count++; // Increment the count for every subarray considered

                // Break the loop if the current subarray violates the strictly increasing
                // condition
                if (left >= nums[j] || nums[j] >= right)
                    break;

                // Update 'right' to the current element in the suffix
                right = nums[j];
            }

            // Break the outer loop if the prefix violates the strictly increasing condition
            if (left >= nums[i])
                break;

            // Update 'left' to the current element in the prefix
            left = nums[i];
        }

        // Return the total count of valid incremovable subarrays
        return count;
    }
}
