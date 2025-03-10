class Solution {
    public int bestTeamScore(int[] scores, int[] ages) {
        int n = scores.length;
        Player[] players = new Player[n];

        for (int i = 0; i < n; i++) {
            players[i] = new Player(scores[i], ages[i]);
        }
        Arrays.sort(players, (a, b) -> a.age == b.age ? a.score - b.score : a.age - b.age);

        int[][] memo = new int[n][n + 1];
        for (int[] row : memo) {
            Arrays.fill(row, -1);
        }

        return findMaxScore(players, 0, -1, memo);
    }

    private int findMaxScore(Player[] players, int idx, int prevIdx, int[][] memo) {
        if (idx == players.length) {
            return 0;
        }

        if (memo[idx][prevIdx + 1] != -1) {
            return memo[idx][prevIdx + 1];
        }

        int skip = findMaxScore(players, idx + 1, prevIdx, memo);

        int include = 0;
        if (prevIdx == -1 || players[idx].score >= players[prevIdx].score) {
            include = players[idx].score + findMaxScore(players, idx + 1, idx, memo);
        }

        return memo[idx][prevIdx + 1] = Math.max(skip, include);
    }
}
class Player {
    int score, age;
    public Player(int score, int age) {
        this.score = score;
        this.age = age;
    }
}
