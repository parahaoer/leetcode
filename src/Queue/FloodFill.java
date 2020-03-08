package Queue;

import java.util.*;

class FloodFill {
    public int[][] floodFill(int[][] image, int sr, int sc, int newColor) {
        int m = image.length;
        int n =image[0].length;

        int[][] newImage = new int[m][n];
        //newImage = image;
        for(int i=0;i<m;i++)
            for(int j=0;j<n;j++)
                newImage[i][j] = image[i][j];


        Queue<Integer> queue = new LinkedList();
        Set<Integer> visited = new HashSet();
        queue.offer(n * sr + sc);
        visited.add(n*sr + sc);
        while(!queue.isEmpty()) {
            int size = queue.size();

            for(int i=0; i< size; i++) {
                int temp = queue.poll();
                int nr = temp / n;
                int nc = temp % n;
                //System.out.println(nr);
                newImage[nr][nc] = newColor;
                if(nr -1 >=0 && !visited.contains((nr-1)*n+nc) && image[nr-1][nc] == image[nr][nc]) {
                    queue.offer((nr-1)*n+nc);
                    visited.add((nr-1)*n+nc);
                }

                if(nr +1 <m && !visited.contains((nr+1)*n+nc) && image[nr+1][nc] == image[nr][nc]) {
                    queue.offer((nr+1)*n+nc);
                    visited.add((nr+1)*n+nc);
                }

                if(nc -1 >=0 && !visited.contains(nr*n+nc-1) && image[nr][nc-1] == image[nr][nc]) {
                    queue.offer(nr*n+nc-1);
                    visited.add(nr*n+nc-1);
                }

                if(nc +1 <n && !visited.contains(nr*n+nc+1) && image[nr][nc+1] == image[nr][nc]) {
                    queue.offer(nr*n+nc+1);
                    visited.add(nr*n+nc+1);
                }

            }

        }
        return newImage;

    }


    public static void main(String[] args) {
        int[][] iamge = {{0,0,0}, {0,0,0}};
        FloodFill floodFill = new FloodFill();
        floodFill.floodFill(iamge, 0,0,2);
    }
}
