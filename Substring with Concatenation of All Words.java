class Solution {
    public List<Integer> findSubstring(String s, String[] words) {
        List<Integer> res = new ArrayList<>();
        if (s == null || words.length == 0) return res;

        int n = s.length(), cnt = words.length, len = words[0].length();
        Map<String, Integer> counts = new HashMap<>();
        for (String w : words) counts.put(w, counts.getOrDefault(w, 0) + 1);
        for (int i = 0; i < len; i++) {
            int left = i, count = 0;
            Map<String, Integer> seen = new HashMap<>();
            
            for (int j = i; j <= n - len; j += len) {
                String word = s.substring(j, j + len);
                if (counts.containsKey(word)) {
                    seen.put(word, seen.getOrDefault(word, 0) + 1);
                    count++;
                    while (seen.get(word) > counts.get(word)) {
                        String leftWord = s.substring(left, left + len);
                        seen.put(leftWord, seen.get(leftWord) - 1);
                        count--;
                        left += len;
                    }
                    if (count == cnt) res.add(left);
                } else {
                    seen.clear();
                    count = 0;
                    left = j + len;
                }
            }
        }
        return res;
    }
}