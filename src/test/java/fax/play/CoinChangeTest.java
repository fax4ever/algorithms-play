package fax.play;

import static org.assertj.core.api.Assertions.assertThat;

import org.junit.jupiter.api.Test;

public class CoinChangeTest {

   private final CoinChangeLimitCoinFirst coinFirst = new CoinChangeLimitCoinFirst();
   private final CoinChangeLimitAmountFirst amountFirst = new CoinChangeLimitAmountFirst();

   @Test
   public void smokeTest() {
      assertThat(coinFirst.coinChange(new int[]{2, 5, 7}, 16)).isEqualTo(3);
      assertThat(coinFirst.coinChange(new int[]{186, 419, 83, 408}, 6249)).isEqualTo(20);

      assertThat(amountFirst.coinChange(new int[]{2, 5, 7}, 16)).isEqualTo(3);
      assertThat(amountFirst.coinChange(new int[]{186, 419, 83, 408}, 6249)).isEqualTo(20);
   }
}
