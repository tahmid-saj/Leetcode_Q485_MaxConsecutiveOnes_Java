class Solution {
    public int findMaxConsecutiveOnes(int[] nums) {
        if (nums.length == 1 && nums[0] == 1) {
            return 1;
        }

        boolean counting = false, oneExists = false;
        int currConsec = 0, maxConsec = 0;

        for (int i = 0, j = 1; j < nums.length; i++, j++) {
            if (nums[i] == 1 || nums[j] == 1) {
                oneExists = true;
            }

            if (counting == false && nums[i] == 1 && nums[j] == 1) {
                counting = true;
                currConsec += 2;
            } else if (counting == true && nums[i] == 1 && nums[j] == 1) {
                currConsec++;
            }

            if (maxConsec < currConsec) {
                maxConsec = currConsec;
            }

            if (nums[i] == 0 || nums[j] == 0) {
                currConsec = 0;
                counting = false;
            }
        }

        if (oneExists && maxConsec == 0) {
            return 1;
        }

        return maxConsec;
    }
}
