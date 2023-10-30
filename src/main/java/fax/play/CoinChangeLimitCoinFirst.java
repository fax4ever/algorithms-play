package fax.play;

/**
 * This solution is now efficient.
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
            int oldSolution = prev[j];
            int newSolution = IMPOSSIBLE_RESULT;

            if (j >= newCoinValue) {
               int inspectionOnTheSameLine = curr[j - newCoinValue];
               if (inspectionOnTheSameLine != IMPOSSIBLE_RESULT) {
                  newSolution = 1 + inspectionOnTheSameLine;
               }
            }

            if (oldSolution == IMPOSSIBLE_RESULT) {
               curr[j] = newSolution;
            } else if (newSolution == IMPOSSIBLE_RESULT) {
               curr[j] = oldSolution;
            } else {
               curr[j] = Math.min(oldSolution, newSolution);
            }
         }
         prev = curr;
      }

      return prev[amount];
   }
}
