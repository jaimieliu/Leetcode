class Solution {
    public int findTheCity(int n, int[][] edges, int distanceThreshold)     {
        //keeps track of distance to get from city[n] to city [n][x]
        int[][] distance = new int[n][n];
        for(int[] dist: distance){
            Arrays.fill(dist, 10001);
        }
        //city to itself is 0 length
        for(int i = 0; i < n; i++){
            distance[i][i] = 0;
        }
        
        //process edges
        for(int[] edge: edges){
            distance[edge[0]][edge[1]] = edge[2];
            distance[edge[1]][edge[0]] = edge[2];
        }
        //***IMPORTANT MID ON OUTSIDE THEN CITY1 CITY2
       for(int mid = 0; mid < n; mid++){
           for(int city1 = 0; city1 < n; city1++){
               for(int city2 = 0; city2 < n; city2++){
                   distance[city1][city2] = Math.min(distance[city1][city2], distance[city1][mid] + distance[mid][city2]);
               }
           }
       }
        int cityNum = 0;
        int count = 0;
        int index = 0;
        int min = Integer.MAX_VALUE;
        for(int[] cityDistances: distance){
            count = 0;
            for(int dist: cityDistances){
                if(dist <= distanceThreshold)
                    count++;
            }
            System.out.println(count);
            if(count <= min){
                min = count;
                cityNum = index;
            }
            index++;
        }
        
        return cityNum;
    }
}