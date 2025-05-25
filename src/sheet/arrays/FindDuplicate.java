package sheet.arrays;

public class FindDuplicate {


    public static void main(String[] args) {
        FindDuplicate fd = new FindDuplicate();
        int[] nums = {1, 3, 4, 2, 2};
        System.out.println(fd.findDuplicate(nums));
    }


    public int findDuplicate(int[] nums) {
        // return byModifying(nums);
        return floydHareTortoise(nums);
    }

    private int floydHareTortoise(int[] nums) {
        int slow = nums[0];
        int fast = nums[0];

        do {
            slow = nums[slow];
            fast = nums[nums[fast]];
        } while (slow != fast);

        // start slow2 from first positoin
        int slow2 = nums[0];
        while (slow != slow2) {
            slow = nums[slow];
            slow2 = nums[slow2];
        }

        return slow;
    }

    private int byModifying(int[] nums) {
        for (int i = 0; i < nums.length; i++) {
            int valueAt = Math.abs(nums[i]);
            if (nums[valueAt - 1] < 0)
                return valueAt;
            nums[valueAt - 1] *= -1;
        }
        return -1;
    }
}
