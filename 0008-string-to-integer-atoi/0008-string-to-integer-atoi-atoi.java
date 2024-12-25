class Solution {
    public int myAtoi(String s) {
        if (s == null || s.length() == 0) {
            return 0; // Null or empty string, return 0
        }

        s = s.trim(); // Remove leading/trailing whitespace
        if (s.length() == 0) {
            return 0; // String contains only whitespace
        }

        int i = 0, sign = 1;
        long res = 0;

        // Check for sign
        if (s.charAt(i) == '-') {
            sign = -1;
            i++;
        } else if (s.charAt(i) == '+') {
            i++;
        }

        // Process digits
        while (i < s.length() && Character.isDigit(s.charAt(i))) {
            res = res * 10 + (s.charAt(i) - '0');

            // Handle overflow
            if (res > Integer.MAX_VALUE) {
                return sign == 1 ? Integer.MAX_VALUE : Integer.MIN_VALUE;
            }
            i++;
        }

        return (int) res * sign;
    }
}
