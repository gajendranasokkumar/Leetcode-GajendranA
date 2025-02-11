class Solution {
    public String removeOccurrences(String s, String part) {
        StringBuilder st = new StringBuilder(s);
        int idx = st.indexOf(part);
        int len = part.length();
        while (idx != -1) {
            st.delete(idx, idx + len); // Corrected deletion range
            idx = st.indexOf(part);
        }
        return st.toString();
    }
}
