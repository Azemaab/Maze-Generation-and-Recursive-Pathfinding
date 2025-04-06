import java.util.Random;

public class MazeGenerator {
    private final int rows, cols;
    public char[][] maze;

    public MazeGenerator(int rows, int cols) {
        this.rows = rows | 1; // Ensure odd dimensions
        this.cols = cols | 1;
        maze = new char[this.rows][this.cols];
        initializeMaze();
        generateMaze(1, 1);
        maze[0][1] = ' '; // Start
        maze[this.rows - 1][this.cols - 2] = ' '; // Exit
    }

    private void initializeMaze() {
        for (int i = 0; i < rows; i++)
            for (int j = 0; j < cols; j++)
                maze[i][j] = '#';
        maze[1][1] = ' ';
    }

    private void generateMaze(int x, int y) {
        int[][] directions = { {0, 2}, {2, 0}, {0, -2}, {-2, 0} };
        shuffle(directions);

        for (int[] dir : directions) {
            int nx = x + dir[0], ny = y + dir[1];
            if (isValid(nx, ny) && maze[nx][ny] == '#') {
                maze[x + dir[0] / 2][y + dir[1] / 2] = ' ';
                maze[nx][ny] = ' ';
                generateMaze(nx, ny);
            }
        }
    }

    private boolean isValid(int x, int y) {
        return x > 0 && y > 0 && x < rows && y < cols;
    }

    private void shuffle(int[][] arr) {
        Random rand = new Random();
        for (int i = arr.length - 1; i > 0; i--) {
            int j = rand.nextInt(i + 1);
            int[] tmp = arr[i];
            arr[i] = arr[j];
            arr[j] = tmp;
        }
    }
}

