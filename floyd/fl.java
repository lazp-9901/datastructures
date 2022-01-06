class fl
{

    private static void printPath(int[][] path, int v, int u)
    {
        if (path[v][u] == v) {
            return;
        }
 
        printPath(path, v, path[v][u]);
        System.out.print((path[v][u]+1) + " ");
    }
 
    private static void printSolution(int[][] cost, int[][] path, int N)
    {
        
        System.out.println("Độ dài đường đi giữa các đỉnh");
        for (int i = 0; i < N; ++i) {
            for (int j = 0; j < N; ++j) {
              if (cost[i][j] == INF)
                System.out.print("INF ");
              else
                System.out.print(cost[i][j] + "  ");
            }
            System.out.println();
          }
        System.out.println("\n\n");
        System.out.println("Ma trận p[i][j]"); //đỉnh đi trước j trên đường đi ngắn nhất từ i đến j
        for (int i = 0; i < N; ++i) {
        	for (int j = 0; j < N; ++j) {
                  System.out.print(path[i][j] + "  ");
              }
              System.out.println();
          }
        System.out.println("hiển thị các điểm trung gian");
        for (int v = 0; v < N; v++)
          {
        	for (int u = 0; u < N; u++)
              {
        		if (u != v && path[v][u] != -1)
                  {
                      System.out.printf("The shortest path from %d —> %d is (%d ", v+1, u+1, v+1);
                      printPath(path, v, u);
                      System.out.println(u+1 + ")" +" with cost = "+ cost[v][u]);
                      
                  }
              }
          }
    }
 

    public static void floydWarshall(int[][] c, int N)
    {

        int[][] cost = new int[N][N];
        int[][] path = new int[N][N];
 
        for (int v = 0; v < N; v++)
        {
            for (int u = 0; u < N; u++)
            {
                cost[v][u] = c[v][u];
 
                if (v == u) {
                    path[v][u] = 0;
                }
                else if (cost[v][u] != Integer.MAX_VALUE) {
                    path[v][u] = v;
                }
                else {
                    path[v][u] = -1;
                }
            }
        }
 
        for (int k = 0; k < N; k++)
        {
            for (int v = 0; v < N; v++)
            {
                for (int u = 0; u < N; u++)
                {
                    if (cost[v][k] != Integer.MAX_VALUE
                            && cost[k][u] != Integer.MAX_VALUE
                            && (cost[v][k] + cost[k][u] < cost[v][u]))
                    {
                        cost[v][u] = cost[v][k] + cost[k][u];
                        path[v][u] = path[k][u];
                    }
                }
 
                 if (cost[v][v] < 0)
                {
                    System.out.println("Negative-weight cycle found!!");
                    return;
                }
            }
        }
 
        printSolution(cost, path, N);
    }
    final static int INF = Integer.MAX_VALUE;
    public static void main(String[] args)
    {
        final int N = 5;
 
        int c[][] = { { 0, 3, 8, INF, -4 }, 
        			  { INF, 0, INF, 1, 7}, 
        			  { INF, 4, 0 ,INF,INF }, 
        			  { 2, INF, -5, 0, INF }, 
        			  { INF, INF, INF, 6, 0 } };
        floydWarshall(c, N);
    }
}