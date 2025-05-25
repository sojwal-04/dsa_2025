package sheet.arrays;

public class WordSearchOne {

//    https://leetcode.com/problems/word-search/submissions/1639542466/
    public static void main(String[] args) {
        WordSearchOne one = new WordSearchOne();


        char[][] board = {
                {'A', 'B', 'C', 'E'},
                {'S', 'F', 'C', 'S'},
                {'A', 'D', 'E', 'E'}
        };

        String word = "ABCCED";

        boolean exists = one.exist(board,word);

        System.out.println(exists ? "The word Found" : "The word not found");
    }

    private final int[][] directions = {{1, 0}, {-1, 0}, {0, 1}, {0, -1}};


//    TC : O(m × n × 4^L) whre L is the length of the word

//   SC:  O(L) - depth of recursion
    public boolean exist(char[][] board, String word) {
        int m = board.length, n = board[0].length;
        for(int i = 0; i < m; i++){
            for(int j = 0; j < n; j++){
                if(exists(board, i, j, word, 0)){
                    return true;
                }
            }
        }
        return false;
    }

    private boolean exists(
            char[][] board,
            int r, int c,
            String word,
            int index)
    {

        int m = board.length, n = board[0].length;

        if(index == word.length()) return true;

        if(r < 0 || r >= m || c < 0 || c >= n ||
                board[r][c] == '#' || (word.charAt(index) != board[r][c])
        )
            return false;


        char tempStore = board[r][c];

        board[r][c] = '#'; // Marking as vis

        for(int[] direction: directions){

            int nr = r + direction[0];
            int nc = c + direction[1];

            if(exists(board, nr, nc, word, index + 1)){
                board[r][c] = tempStore; // restore value
                return true;
            }

        }

        board[r][c] = tempStore; // Backtrack, restore the value adn mark non vis
        return false;
    }
}
