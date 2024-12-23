class Solution {
    public int totalFruit(int[] fruits) {
        // Initializing a map for keeping count of distinct fruits
        Map<Integer, Integer> fruitCount = new HashMap<>();
        
        // i is front pointer of sliding window
        // j is rear pointer of sliding window
        // ans will store the maximum subarray length
        int i = 0, j = 0, ans = 0;
        while (i < fruits.length) {
            // picking up the fruit
            fruitCount.put(fruits[i], fruitCount.getOrDefault(fruits[i], 0) + 1);
            // if no. of distinct fruits is more than two
            // we will move our rear pointer and unpick the fruits
            while (fruitCount.size() > 2) {
                int count = fruitCount.get(fruits[j]) - 1;
                fruitCount.put(fruits[j], count);
                // if fuit of a particular type are exhausted
                // clearing the index of that fruit
                if (count == 0) {
                    fruitCount.remove(fruits[j]);
                }
                // moving rear pointer
                j++;
            }
            // Storing maximum subarray length with at most 2 distinct fruits
            ans = Math.max(ans, i - j + 1);
            // moving front pointer
            i++;
        }
        // returning the maximum subarray length
        return ans;
    }
}
