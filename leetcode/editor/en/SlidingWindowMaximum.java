//You are given an array of integers nums, there is a sliding window of size k 
//which is moving from the very left of the array to the very right. You can only 
//see the k numbers in the window. Each time the sliding window moves right by one 
//position. 
//
// Return the max sliding window. 
//
// 
// Example 1: 
//
// 
//Input: nums = [1,3,-1,-3,5,3,6,7], k = 3
//Output: [3,3,5,5,6,7]
//Explanation: 
//Window position                Max
//---------------               -----
//[1  3  -1] -3  5  3  6  7       3
// 1 [3  -1  -3] 5  3  6  7       3
// 1  3 [-1  -3  5] 3  6  7       5
// 1  3  -1 [-3  5  3] 6  7       5
// 1  3  -1  -3 [5  3  6] 7       6
// 1  3  -1  -3  5 [3  6  7]      7
// 
//
// Example 2: 
//
// 
//Input: nums = [1], k = 1
//Output: [1]
// 
//
// Example 3: 
//
// 
//Input: nums = [1,-1], k = 1
//Output: [1,-1]
// 
//
// Example 4: 
//
// 
//Input: nums = [9,11], k = 2
//Output: [11]
// 
//
// Example 5: 
//
// 
//Input: nums = [4,-2], k = 2
//Output: [4]
// 
//
// 
// Constraints: 
//
// 
// 1 <= nums.length <= 10⁵ 
// -10⁴ <= nums[i] <= 10⁴ 
// 1 <= k <= nums.length 
// 
// Related Topics Array Queue Sliding Window Heap (Priority Queue) Monotonic 
//Queue 👍 7808 👎 279

  
  package editor.en;

import java.util.ArrayDeque;
import java.util.Arrays;
import java.util.Deque;


  public class SlidingWindowMaximum{
      public static void main(String[] args) {
           Solution solution = new SlidingWindowMaximum().new Solution();
           int[] nums = new int[]{1,3,-1,-3,5,3,6,7};
           int k = 3;
           int[] out = solution.maxSlidingWindow(nums, k);
           System.out.print(Arrays.toString(out));
      }
      //leetcode submit region begin(Prohibit modification and deletion)
      class Solution {

          public int[] maxSlidingWindow(int[] a, int k) {
              if (a == null || k <= 0) {
                  return new int[0];
              }
              int n = a.length;
              int[] r = new int[n - k + 1];
              int ri = 0;

              // store index
              Deque<Integer> q = new ArrayDeque<>();

              for (int i = 0; i < a.length; i++) {
                  // remove numbers out of range k
                  while (!q.isEmpty() && q.peek() < i - k + 1) {
                      q.poll();
                  }
                  // remove smaller numbers in k range as they are useless
                  while (!q.isEmpty() && a[q.peekLast()] < a[i]) {
                      q.pollLast();
                  }
                  // q contains index... r contains content
                  q.offer(i);
                  if (i >= k - 1) {
                      r[ri++] = a[q.peek()];
                  }
              }
              return r;
          }
      }
//leetcode submit region end(Prohibit modification and deletion)

  }