package fax.play;

import org.assertj.core.api.Assertions;
import org.junit.jupiter.api.Test;

public class CutStickTest {

   private CutStickMinimumCost testTarget = new CutStickMinimumCost();
   private CutStickBottomUp bottomUp = new CutStickBottomUp();

   @Test
   public void memoization() {
      Assertions.assertThat(testTarget.minCost(7, new int[]{1, 3, 4, 5})).isEqualTo(16);
      Assertions.assertThat(testTarget.minCost(9, new int[]{5, 6, 1, 4, 2})).isEqualTo(22);
   }

   @Test
   public void bottomUp() {
      Assertions.assertThat(bottomUp.minCost(7, new int[]{1, 3, 4, 5})).isEqualTo(16);
      Assertions.assertThat(bottomUp.minCost(9, new int[]{5, 6, 1, 4, 2})).isEqualTo(22);
   }
}
