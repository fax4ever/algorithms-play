package fax.play;

import org.assertj.core.api.Assertions;
import org.junit.jupiter.api.Test;

public class PaliDPTest {

   @Test
   public void substring() {
      PaliSubstringDP palyDP = new PaliSubstringDP();

      String longestPalindrome = palyDP.longestPalindrome("abbcbbxxx");
      Assertions.assertThat(longestPalindrome).isEqualTo("bbcbb");
   }
}
