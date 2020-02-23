package Queue;

import java.util.*;

class NumberofIslands6 {
    public int numIslands(char[][] grid) {

        int m = grid.length;
        if(m == 0) return 0;
        int n = grid[0].length;
        boolean[][] visited = new boolean[m][n];
        
        int result = 0;
        for(int i=0; i<m; i++) 
            for(int j=0; j<n; j++) {
                if(grid[i][j] =='1' && visited[i][j]==false) {
                    result ++;
                    Pointer p = new Pointer(i,j);
                    visited[i][j] = true;
                    bfs(grid, visited, p);
                }
            }
        return result;
    }
    
    public void bfs(char[][] grid, boolean[][] visited, Pointer p) {
        int m = grid.length;
        int n = grid[0].length;
        Queue<Pointer> queue = new LinkedList();
        queue.offer(p);
        while(!queue.isEmpty()) {
            int size = queue.size();
            
            for(int i=0; i<size; i++) {
                Pointer q = queue.poll();
                int nx = q.x;
                int ny = q.y;
                
                if(nx-1>=0 && !visited[nx-1][ny] && grid[nx-1][ny] =='1') {
                    queue.offer(new Pointer(nx-1, ny));
                    visited[nx-1][ny] = true;
                } 
                
                if(nx+1<m && !visited[nx+1][ny] && grid[nx+1][ny] =='1') {
                    queue.offer(new Pointer(nx+1, ny));
                    visited[nx+1][ny] = true;
                } 
                
                if(ny-1>=0 && !visited[nx][ny-1] && grid[nx][ny-1] =='1') {
                    queue.offer(new Pointer(nx, ny-1));
                    visited[nx][ny-1] = true;
                } 
                
                if(ny+1<n && !visited[nx][ny+1] && grid[nx][ny+1] =='1') {
                    queue.offer(new Pointer(nx, ny+1));
                    visited[nx][ny+1] = true;
                } 
                
            }
        }
    }
    
    class Pointer {     
        int x;
        int y;
        public Pointer(int x, int y) {
            this.x = x;
            this.y = y;
        }
    }
}