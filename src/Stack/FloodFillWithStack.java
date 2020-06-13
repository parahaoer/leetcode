class Solution {
    public int[][] floodFill(int[][] image, int sr, int sc, int newColor) {
        
        int r = image.length;
        int c = image[0].length;
        Stack<Integer> s = new Stack();
        
        Set<Integer> visited = new HashSet();
        
        s.push(sc * r + sr);
        visited.add(sc * r + sr);
        int oldColor = image[sr][sc];
        image[sr][sc] = newColor;
        
        int dir[][] = {{-1, 0}, {1, 0}, {0, -1}, {0, 1}};
        
        while(!s.isEmpty()) {
            
            int temp = s.pop();
            
            int tc = temp/r;
            int tr = temp%r;
            
            for(int i=0; i<4; i++) {
                int nr = tr + dir[i][0];
                int nc = tc + dir[i][1];
                if(nr >=0 && nr<r && nc >=0 && nc <c && !visited.contains(nc*r+nr) && image[nr][nc] == oldColor) {
                    s.push(nc*r+nr);
                    visited.add(nc*r+nr);
                    image[nr][nc] = newColor;
                }
            }
            
       
        }
        return image;
    }
}