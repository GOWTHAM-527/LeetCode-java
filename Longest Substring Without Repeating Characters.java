import java.util.HashSet;
class Solution {
    public int lengthOfLongestSubstring(String s) {
        HashSet<Character> a=new HashSet<>();
        int l=0;
        int m=0;
        int r;
        for(r=0;r<s.length();r++){
            while (a.contains(s.charAt(r))) {
                a.remove(s.charAt(l));
                l++;
        }
        a.add(s.charAt(r));
        m=Math.max(m,r-l+1);
        }
        return m;
    }
}