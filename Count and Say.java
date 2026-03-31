class Solution {
    public String countAndSay(int n) {
        String result = "1";
        for (int i = 1; i < n; i++) {
            StringBuilder sb = new StringBuilder();
            int count = 1;
            for (int j = 1; j <= result.length(); j++) {
                if (j < result.length() && result.charAt(j) == result.charAt(j - 1)) {
                    count++;
                } else {
                    sb.append(count).append(result.charAt(j - 1));
                    count = 1; // Reset count
                }
            }
            result = sb.toString();
        }
        return result;
    }
}