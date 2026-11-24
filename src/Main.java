public class Main {
    static void main(String[] args) {
        final int rows = 8;
        final int cols = 8;
        final int start_health = 10;

        char[][] map;
        map = new char[rows][cols];

        for (char r = 0; r < rows; r ++) {

            for (char c = 0; c < cols; c++) {
                map[r][c] = '.';
            }
        }

        map[0][0] = 'P';

        final int numOfTreasures = 6;
        final int numOfTraps = 10;
        final int numOfRocks = 4;

        for (int i = 0; i < numOfTreasures; i++) {
           int r = (int) (Math.random() * rows);
           int c = (int) (Math.random() * cols);

           // Runs while the position is not empty space or the position is starting
           while (map[r][c] != '.' || r + c == 0) {
               r = (int) (Math.random() * rows);
               c = (int) (Math.random() * cols);
           }

          map[r][c] = 'X';
        }

        for (int i = 0; i < numOfTraps; i++) {
            int r = (int) (Math.random() * rows);
            int c = (int) (Math.random() * cols);

            // Runs while the position is not empty space or the position is starting
            while (map[r][c] != '.' || r + c == 0) {
                r = (int) (Math.random() * rows);
                c = (int) (Math.random() * cols);
            }

            map[r][c] = 'T';
        }

        for (int i = 0; i < numOfRocks; i++) {
            int r = (int) (Math.random() * rows);
            int c = (int) (Math.random() * cols);

            // Runs while the position is not empty space or the position is starting
            while (map[r][c] != '.' || r + c == 0) {
                r = (int) (Math.random() * rows);
                c = (int) (Math.random() * cols);
            }

            map[r][c] = '#';
        }

        // prints the map.
        for (char r = 0; r < rows; r++) {
            String collum = "";
            for (char c = 0; c < cols; c++) {
                collum += " "  + map[r][c] + " ";
            }

            System.out.println(collum);
        }

        System.out.println();
        System.out.println();

        // Above this is setting up the map.

        int row = 0, col = 0, health = start_health, gold = 0;
        int timesMoved = 0;
        String commands = "EEEEEEEESSSSSSSS";

        for (int i = 0; i < commands.length(); i++) {
            char move = commands.charAt(i);
            int newRow = row, newCol = col;

            // Movement
            switch (move) {
                case 'N' :
                    newRow -= 1;
                    break;

                case 'S' :
                    newRow += 1;
                    break;

                case 'E':
                    newCol += 1;
                    break;

                case 'W':
                    newCol -= 1;
                    break;
            }

            newRow = Math.clamp(0, newRow, rows);
            newCol = Math.clamp(0, newCol, cols);

            timesMoved += 1;

            if (newRow > map.length) {

            }

            int tile = map[newRow][newCol];

//            if (tile) {
//                continue;
//            }

            if (tile == '#') {
                continue;
            } else if (tile == 'T') {
                map[row][col] = '.';

                System.out.println("TRAAAP");

                health -= 5;

                // break out of the for loop because game is over
                if (health <= 0) {
                    break;
                }

            } else if (tile == 'X') {
                map[row][col] = '.';

                gold += 10;

                // Empty space
            } else {
                map[row][col] = '.';
            }

            row = newRow;
            col = newCol;
            map[newRow][newCol] = 'p';

            // Prints map
            for (char r = 0; r < rows; r++) {
                String collum = "";
                for (char c = 0; c < cols; c++) {
                    collum += " "  + map[r][c] + " ";
                }

                System.out.println(collum);
            }

            System.out.println();
            System.out.println();
        }

       System.out.println("Legend: Gold-" + gold + " Survived-" + (health > 0) + " TimesMoved-" + timesMoved);

    }
}
