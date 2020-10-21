class Solution {
    public int[] twoSum(int[] nums, int target) {
        int[] answer = new int[2];

        Map<Integer, Integer> matchingPairLocation = new HashMap<>();
        for (int i = 0; i < nums.length; i++) {
            if (matchingPairLocation.containsKey(nums[i])) {
                answer[0] = matchingPairLocation.get(nums[i]);
                answer[1] = i;
                break;
            }
            
            matchingPairLocation.put(target - nums[i], i);
        }
        
        return answer;
    }
}