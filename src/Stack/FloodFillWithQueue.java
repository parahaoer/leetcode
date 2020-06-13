class Solution {
    public int[][] floodFill(int[][] image, int sr, int sc, int newColor) {
        
        int r = image.length;
        int c = image[0].length;

        // 将队列换成栈也能通过
        Queue<Integer> q = new LinkedList();
        
        Set<Integer> visited = new HashSet();
        
        q.offer(sc * r + sr);
        visited.add(sc * r + sr);
        int oldColor = image[sr][sc];
        image[sr][sc] = newColor;
        
        int dir[][] = {{-1, 0}, {1, 0}, {0, -1}, {0, 1}};
        
        while(!q.isEmpty()) {
            
            int temp = q.poll();
            
            int tc = temp/r;
            int tr = temp%r;
            
            for(int i=0; i<4; i++) {
                int nr = tr + dir[i][0];
                int nc = tc + dir[i][1];
                if(nr >=0 && nr<r && nc >=0 && nc <c && !visited.contains(nc*r+nr) && image[nr][nc] == oldColor) {
                    q.offer(nc*r+nr);
                    visited.add(nc*r+nr);
                    image[nr][nc] = newColor;
                }
            }
            
       
        }
        return image;
    }
}