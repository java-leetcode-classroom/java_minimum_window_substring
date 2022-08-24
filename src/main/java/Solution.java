public class Solution {
  public String minWindow(String s, String t) {
    int sLen = s.length(), tLen = t.length();
    String result = "";
    if (sLen < tLen || sLen == 0 || tLen == 0) {
      return result;
    }
    int[] sFreq = new int[256], tFreq = new int[256];
    int count = 0;
    int minW = sLen + 1, left = 0, right = -1, subLeft = -1, subRight = -1;
    for (int pos = 0; pos < tLen; pos++) {
      tFreq[t.charAt(pos)]++;
    }
    while(left < sLen) {
      // check if slide window is enough large
      if (right + 1 < sLen && count < tLen) {
        if (sFreq[s.charAt(right+1)] < tFreq[s.charAt(right+1)]) {
          count++;
        }
        sFreq[s.charAt(right+1)]++;
        right++;
      } else {
        if (right - left + 1 < minW && count == tLen) {
          minW = right - left + 1;
          subLeft = left;
          subRight = right;
        }
        if (sFreq[s.charAt(left)] == tFreq[s.charAt(left)]) {
          count--;
        }
        sFreq[s.charAt(left)]--;
        left++;
      }
    }
    if (subLeft != -1) {
      result = s.substring(subLeft, subRight+1);
    }
    return result;
  }
}
