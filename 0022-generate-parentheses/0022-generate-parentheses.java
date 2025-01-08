class Solution {
     List<String> list = new ArrayList<>();

    public static String toString(char[] a) {
        String string = new String(a);
        return string;
    }

    public  void generate(int n, char[] ch, int k, int left, int right) {
        if (k == n) {
            if (left == right) {
                list.add(toString(ch));
            }
            return;
        }
        if (left < n / 2) {
            ch[k] = '(';
            generate(n, ch, k + 1, left + 1, right);
        }
        if (right < left) {
            ch[k] = ')';
            generate(n, ch, k + 1, left, right + 1);
        }
    }

     void fun(int n) {
        if (n <= 0)
            return;
        char[] ch = new char[n];
        ch[0] = '(';
        generate(n, ch, 1, 1, 0);
    }

    public List<String> generateParenthesis(int n) {
        list.clear(); 
        fun(n * 2);
        return list;
    }
}