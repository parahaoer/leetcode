class Solution {
    public boolean exist(char[][] board, String word) {
        int m = board.length;
        int n = board[0].length;
        for(int i=0; i<m; i++)
            for(int j=0; j<n; j++) {
                if(board[i][j] == word.charAt(0)) {
                    LinkedList<Character> track = new LinkedList<>();
                    Set<Integer> visited =new HashSet();
                    track.add(board[i][j]);
                    visited.add(i*n+j);
                    if(backtrack(board, track, i, j, 1, word, visited))
                        return true;
                }
            }
        return false;
    }


    int[] dx = {0, 1,  0, -1};
    int[] dy = {1, 0, -1, 0};


    public boolean backtrack(char[][] board, LinkedList<Character> track, int row, int col, int j, String word, Set<Integer> visited) {
        
        int m = board.length;
        int n = board[0].length;

        if(j==word.length()) 
            return true;
        char ch = word.charAt(j); 

        for(int i=0; i<4; i++) {
            int nr = row + dx[i];
            int nc = col + dy[i];
            if(nr>=0 && nc>=0 && nr<m && nc<n && board[nr][nc] == word.charAt(j) && !visited.contains(nr*n+nc)) {
                track.add(ch);
                visited.add(nr*n+nc);
                if(backtrack(board, track, nr, nc, j+1, word, visited))
                    return true;
                track.removeLast();
                visited.remove(nr*n+nc);
            }
        }
        return false;
    }
}