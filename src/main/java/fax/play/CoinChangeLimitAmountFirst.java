package fax.play;

/**
 * Alternatively we can limit the amount in the outer cycle.
 */
public class CoinChangeLimitAmountFirst {

   public static final int IMPOSSIBLE_RESULT = -1;

   public int coinChange(int[] coins, int amount) {
      int[][] solution = new int[amount + 1][coins.length + 1];

      for (int i = 0; i <= amount; i++) {
         for (int j = 0; j <= coins.length; j++) {
            if (i == 0) {
               solution[i][j] = 0;
               continue;
            }
            if (j == 0) {
               solution[i][j] = IMPOSSIBLE_RESULT;
               continue;
            }

            int oldSolution = solution[i][j-1];
            int newSolution = IMPOSSIBLE_RESULT;

            // find a solution with the new amount
            int currentCoin = coins[j-1];
            if (currentCoin <= i) {
               // I can try to find a solution using the current coin

               int rest = i - currentCoin;
               int fullSolutionForRest = solution[rest][coins.length];
               if (fullSolutionForRest != IMPOSSIBLE_RESULT) {
                  newSolution = fullSolutionForRest + 1;
               }
            }

            if (oldSolution == IMPOSSIBLE_RESULT) {
               solution[i][j] = newSolution;
            } else if (newSolution == IMPOSSIBLE_RESULT) {
               solution[i][j] = oldSolution;
            } else {
               solution[i][j] = Math.min(oldSolution, newSolution);
            }
         }
      }

      return solution[amount][coins.length];
   }

}
