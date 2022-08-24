import org.junit.jupiter.api.Test;

import static org.junit.jupiter.api.Assertions.*;

class SolutionTest {
  final private Solution sol = new Solution();
  @Test
  void minWindowExample1() {
    assertEquals("BANC", sol.minWindow("ADOBECODEBANC", "ABC"));
  }
  @Test
  void minWindowExample2() {
    assertEquals("a", sol.minWindow("aa", "a"));
  }
  @Test
  void minWindowExample3() {
    assertEquals("", sol.minWindow("a", "aa"));
  }
}