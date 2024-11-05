class Solution {

public int maxVowels(String s, int k) {
	boolean[] vowels = new boolean['z' + 1];
		vowels['u'] = true;
		vowels['e'] = true;
		vowels['i'] = true;
		vowels['o'] = true;
		vowels['a'] = true;

	char[] chars = s.toCharArray();
	int r = 0, maxN = 0;
	for (;r < k; r++)
		if (vowels[chars[r]])
			maxN++;

	int len = s.length(), l = 0, n = maxN;
	for (;r < len; l++, r++) {
		if (vowels[chars[l]])
			n--;
		if (vowels[chars[r]])
			n++;
		if (n > maxN)
			maxN = n;
	}
	return maxN;
}

}