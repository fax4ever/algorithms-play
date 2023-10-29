package fax.play;

import org.assertj.core.api.Assertions;
import org.junit.jupiter.api.Test;

public class CutStickTest {

   private CutStickMinimumCost testTarget = new CutStickMinimumCost();

   @Test
   public void test() {
      Assertions.assertThat(testTarget.minCost(7, new int[]{1, 3, 4, 5})).isEqualTo(16);
      Assertions.assertThat(testTarget.minCost(9, new int[]{5, 6, 1, 4, 2})).isEqualTo(22);
   }
}
