package fax.play;

import java.util.PriorityQueue;

/**
 * This solution is not efficient.
 *
 * Requires 3 nested cycles => O(n*amount*amount)
 */
public class CoinChangeLimitCoinFirst {

   public static final int IMPOSSIBLE_RESULT = -1;

   public int coinChange(int[] coins, int amount) {
      if (coins.length == 0) {
         return (amount == 0) ? 0 : IMPOSSIBLE_RESULT;
      }

      int[] prev = new int[amount + 1];
      prev[0] = 0;
      for (int j = 1; j <= amount; j++) {
         prev[j] = IMPOSSIBLE_RESULT;
      }

      for (int i = 1; i <= coins.length; i++) {
         int newCoinValue = coins[i - 1];
         int[] curr = new int[amount + 1];
         for (int j = 0; j <= amount; j++) {
            // j is the current amount
            int maxNumberOfNewCoinICanUse = j / newCoinValue;
            PriorityQueue<Integer> solutions = new PriorityQueue<>();
            if (prev[j] != IMPOSSIBLE_RESULT) {
               solutions.add(prev[j]);
            }

            for (int k = 1; k <= maxNumberOfNewCoinICanUse; k++) {
               // k is the number of new coin I'll use
               int amountGainedWithTheNewCoinUsage = k * newCoinValue;
               int inspectionOnTheSameLine = curr[j - amountGainedWithTheNewCoinUsage];
               if (inspectionOnTheSameLine != IMPOSSIBLE_RESULT) {
                  solutions.add(k + inspectionOnTheSameLine);
               }
            }

            if (solutions.isEmpty()) {
               curr[j] = IMPOSSIBLE_RESULT;
            } else {
               curr[j] = solutions.peek();
            }
         }
         prev = curr;
      }

      return prev[amount];
   }

}
