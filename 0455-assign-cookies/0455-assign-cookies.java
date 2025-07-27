class Solution {
    public int findContentChildren(int[] g, int[] s) {
         Arrays.sort(g);  // Sort greed factors
        Arrays.sort(s);  // Sort cookie sizes
        
        int i = 0; // Child index
        int j = 0; // Cookie index
        
        while (i < g.length && j < s.length) {
            if (s[j] >= g[i]) {
                i++;  // Assign cookie to child
            }
            j++;  // Move to next cookie
        }
        
        return i; // Number of satisfied children
    
        
    }
}