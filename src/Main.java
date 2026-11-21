public class Main {
    public static int[][] takenPos = {};

    static boolean isPosTaken(int x, int y) {
        boolean takened = false;

        for (int i = 0; i < takenPos.length; i++) {
            if (takenPos[i][1] == x && takenPos[i][2] == y) {
                takened = true;
                break;
            }
        }

        return takened;
    }

    static int[][] getStartingPositions(int maxX, int maxY, int numOfItems) {
        int [][] positions = new int[numOfItems][2];

        for ( int i = 0; i < numOfItems; i++) {
            int randomX = (int) (Math.random() * maxX);
            int randomY = (int) (Math.random() * maxY);

            // Makes sure the position is not the start or is takened
            while (randomX == 0 && randomY == 0 && isPosTaken(randomX, randomY)) {
                randomX = (int) (Math.random() * maxX);
                randomY = (int) (Math.random() * maxY);

                // Inserts the postions into the global array
                takenPos[takenPos.length][1] = randomX;
                takenPos[takenPos.length][2] = randomY;
            }

            positions[i][0] = randomX;
            positions[i][1] = randomY;
        }


        return positions;
    }


    static void main(String[] args) {
        final int rows = 8;
        final int cols = 8;
        final int start_health = 10;

        final int rockAmount = 5;
        final int treasureAmount = 5;
        final int trapAmount = 5;

        int [][] rockPostions = getStartingPositions(cols, rows, rockAmount);
        int [][] treasurePositions = getStartingPositions(cols, rows, treasureAmount);
        int [][] trapPositions = getStartingPositions(cols, rows, trapAmount);

        int[][][] posTable = {rockPostions, treasurePositions, trapPositions};

        char[][] map = new char[rows][cols];

        String charType = " . ";

        for (char y = 0; y < rows; y ++) {

            for (char x = 0; x < cols; x++) {

                for (int i = 0; i < posTable.length; i ++) {

                    for (int z = 0; z < posTable[i][z].length; z++) {

                        if (posTable[i][z][0] == x && posTable[i][z][1] == y) {
                            switch (i) {
                                case 0:
                                    charType = "#";
                                    break;

                                case 1:
                                    charType = "X";
                                    break;
                                case 2:
                                    charType = "T";
                                    break;
                            }
                        }

                    }

                }

                System.out.println(charType);
            }
        }

        int row = 0, col = 0, health = start_health, gold = 0;

        String commands = "EEESSSWWNNEEESSS";

        for (int i = 0; i < commands.length(); i++) {
            char move = commands.charAt(i);
            int newRow = row, newCol = col;

            switch (move) {
                case 'N' :
                    newRow--;
                    break;
            }


        }
    }
}
