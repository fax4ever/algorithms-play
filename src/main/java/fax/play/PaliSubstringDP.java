package fax.play;

public class PaliSubstringDP {

   private String input;
   private boolean[][] dp;
   private int n;

   public String longestPalindrome(String s) {
      input = s;
      n = s.length();
      dp = new boolean[n][n];
      int maxI = 0;
      int maxJ = 0;

      for (int size = 1; size <= s.length(); size++) {
         for (int i = 0; i <= n - size; i++) {
            int j = i + size - 1;
            boolean paly = dp(i, j);
            if (paly) {
               maxI = i;
               maxJ = j;
            }
         }
      }

      return input.substring(maxI, maxJ + 1);
   }

   private boolean dp(int i, int j) {
      if (i == j) {
         dp[i][j] = true;
         return true;
      }
      boolean match = input.charAt(i) == input.charAt(j);
      if (!match) {
         return false;
      }
      if (i == j - 1) {
         dp[i][j] = true;
         return true;
      }
      boolean subStringPoly = dp[i + 1][j - 1];
      if (subStringPoly) {
         dp[i][j] = true;
         return true;
      }
      return false;
   }
}
