package fax.play;

import java.util.Arrays;
import java.util.HashMap;
import java.util.PriorityQueue;

public class CutStickMinimumCost {

   private HashMap<Key, Integer> solutions;
   private int n;
   private int[] c;

   public int minCost(int length, int[] cuts) {
      if (length == 0 || cuts.length == 0) {
         return 0;
      }

      Arrays.sort(cuts);
      solutions = new HashMap<>();
      n = cuts.length + 1;
      c = new int[n + 1];
      c[0] = 0;
      for (int i = 0; i < cuts.length; i++) {
         this.c[i + 1] = cuts[i];
      }
      c[n] = length;

      return solution(0, n);
   }

   private int solution(int i, int j) {
      if (i == j || (j - i == 1)) {
         return 0;
      }

      Key key = new Key(i, j);
      if (solutions.containsKey(key)) {
         return solutions.get(key);
      }

      int currentLength = c[j] - c[i];
      PriorityQueue<Integer> localSolutions = new PriorityQueue<>(j - i);
      for (int k = i + 1; k <= j - 1; k++) {
         int iTOk = solution(i, k);
         int kTOj = solution(k, j);

         localSolutions.add(currentLength + iTOk + kTOj);
      }
      Integer solution = localSolutions.peek();
      solutions.put(key, solution);
      return solution;
   }

   private record Key(int start, int end) {

      @Override
      public boolean equals(Object o) {
         if (this == o) return true;
         if (o == null || getClass() != o.getClass()) return false;
         Key key = (Key) o;
         return start == key.start && end == key.end;
      }
   }
}
