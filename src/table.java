public class table {
    private String leftAlignFormat = "| %-2s| %-2s| %-2s| %-2s| %-2s| %-2s| %-2s| %-2s| %n";

    private String[][] matrix = new String[8][8];
    private int[] numbers = {1, 2, 3, 4, 5, 6, 7, 8};

    public table() {
        this.fullMatrix();
        this.printTable();
        System.out.println("Jugardor uno inicia.");
        this.turnOnGame();
    }

    private void turnOnGame(){

    }

    private void printTable(){
        System.out.format("+---+---+---+---+---+---+---+---+%n");
        System.out.format("|   | a | b | c | d | e | f | g |%n");
        System.out.format("+---+---+---+---+---+---+---+---+%n");
        for ( int i = 0; i < matrix.length; i++) {
            try {
                    System.out.format(leftAlignFormat,
                            numbers[i],
                            matrix[i][0],
                            matrix[i][1],
                            matrix[i][2],
                            matrix[i][3],
                            matrix[i][4],
                            matrix[i][5],
                            matrix[i][6],
                            matrix[i][7]);
                System.out.format("+---+---+---+---+---+---+---+---+%n");
            } catch (Exception e) {
                System.out.println(e);
            }
        }
    }

    private void fullMatrix() {
        for ( int i = 0; i < matrix.length; i++) {
            for (int j = 0; j < matrix.length; j++){
                this.matrix[i][j] = " ";
            }
        }
    }
}
