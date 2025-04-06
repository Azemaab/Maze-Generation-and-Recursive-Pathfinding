public class Pathfinder {
    public static boolean findPath(char[][] maze, boolean[][] visited, int x, int y) {
        int rows = maze.length, cols = maze[0].length;

        if (x == rows - 1 && y == cols - 2) {
            maze[x][y] = '.';
            return true;
        }

        if (!isValid(maze, visited, x, y))
            return false;

        visited[x][y] = true;

        int[][] directions = { {0, 1}, {1, 0}, {0, -1}, {-1, 0} };
        for (int[] d : directions) {
            int nx = x + d[0], ny = y + d[1];
            if (findPath(maze, visited, nx, ny)) {
                maze[x][y] = '.';
                return true;
            }
        }

        return false;
    }

    private static boolean isValid(char[][] maze, boolean[][] visited, int x, int y) {
        return x >= 0 && y >= 0 && x < maze.length && y < maze[0].length &&
               maze[x][y] == ' ' && !visited[x][y];
    }
}
