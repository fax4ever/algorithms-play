package fax.play;

import java.util.Arrays;
import java.util.PriorityQueue;

public class CutStickBottomUp {
   private int n;
   private int[] c;

   public int minCost(int length, int[] cuts) {
      Arrays.sort(cuts);
      n = cuts.length + 1;
      c = new int[n + 1];
      c[0] = 0;
      for (int i = 0; i < cuts.length; i++) {
         this.c[i + 1] = cuts[i];
      }
      c[n] = length;

      // memory can be optimized here
      int[][] solutions = new int[n+1][n+1];
      for (int size = 2; size <= n; size++) {
         for (int left = 0; left <= n - size; left++) {
            int right = left + size;
            int currentLength = c[right] - c[left];
            if (size == 2) {
               // single cut =>  base case
               solutions[left][right] = currentLength;
            } else {
               PriorityQueue<Integer> localSolutions = new PriorityQueue<>(size);
               for (int k = left + 1; k <= right - 1; k++) {
                  int iTOk = solutions[left][k];
                  int kTOj = solutions[k][right];

                  localSolutions.add(currentLength + iTOk + kTOj);
               }
               Integer solution = localSolutions.peek();
               solutions[left][right] = solution;
            }
         }
      }

      return solutions[0][n];
   }
}
