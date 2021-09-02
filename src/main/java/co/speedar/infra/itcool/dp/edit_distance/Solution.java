package co.speedar.infra.itcool.dp.edit_distance;

class Solution {
	public int minDistance(String word1, String word2) {
		int l1 = (word1 != null ? word1.length() : 0);
		int l2 = (word2 != null ? word2.length() : 0);
		// empty string
		if (l1 * l2 == 0) {
			return l1 + l2;
		}
		// init boundaries
		int[][] d = new int[l1 + 1][l2 + 1];
		for (int i = 0; i < l1 + 1; i++) {
			d[i][0] = i;
		}
		for (int j = 0; j < l2 + 1; j++) {
			d[0][j] = j;
		}
		// compute distance matrix
		// i: [1, l1], j: [1, l2]
		for (int i = 1; i < l1 + 1; i++) {
			for (int j = 1; j < l2 + 1; j++) {
				int left = d[i][j - 1] + 1;
				int down = d[i - 1][j] + 1;
				int leftDown = word1.charAt(i - 1) == word2.charAt(j - 1) ? d[i - 1][j - 1] : d[i - 1][j - 1] + 1;
				d[i][j] = Math.min(left, Math.min(down, leftDown));
			}
		}
		return d[l1][l2];
	}
}