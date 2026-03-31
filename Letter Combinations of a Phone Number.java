class Solution {
   private Map<Character, String> map = Map.of(
        '2', "abc", '3', "def", '4', "ghi", '5', "jkl",
        '6', "mno", '7', "pqrs", '8', "tuv", '9', "wxyz"
    );
    public List<String> letterCombinations(String digits) {
        List<String> res = new ArrayList<>();
        if (digits == null || digits.length() == 0) return res;
        backtrack(res, digits, new StringBuilder(), 0);
        return res;
    }
    private void backtrack(List<String> res, String digits, StringBuilder path, int index) {
        if (index == digits.length()) {
            res.add(path.toString());
            return;
        }
        String letters = map.get(digits.charAt(index));
        for (char c : letters.toCharArray()) {
            path.append(c);
            backtrack(res, digits, path, index + 1);
            path.deleteCharAt(path.length() - 1);
        }
    }
}