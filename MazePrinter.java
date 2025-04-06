public class MazePrinter {
    public static void printMaze(char[][] maze) {
        for (char[] row : maze) {
            for (char c : row)
                System.out.print(c);
            System.out.println();
        }
    }
}
