import java.util.Scanner;

public class Table {
    private String leftAlignFormat = "| %-2s| %-2s| %-2s| %-2s| %-2s| %-2s| %-2s| %-2s| %-2s| %n";
    private String white = "O";
    private String black = "X";
    private String[][] matrix = new String[8][8];
    private int[] numbers = {1, 2, 3, 4, 5, 6, 7, 8};
    private boolean turn = true;
    private Scanner sc = new Scanner(System.in);
    public Table() {
        this.fullMatrix();
        this.turnOnGame();
    }

    private void turnOnGame(){
        while(!this.validGameOver()){
            this.printTable();
            if (turn) {
                System.out.println("Es el turno del jugador 1 'X'");
            } else {
                System.out.println("Es el turno del jugador 2 'O'");
            }
            this.fillMatrix();
        }
    }

    private void fillMatrix(){
        int posX = 0;
        int posY = 0;
        try {
            System.out.println("Ingrese la posicion que desea colocar su pieza");
            System.out.println("Ingrese la posicion en la fila");
            posX = this.sc.nextInt();
            System.out.println("Ingrese la posicion en la columna");
            posY = this.sc.nextInt();
            this.matrix[posX][posY] = turn ? this.black : this.white;
            this.turn = !this.turn;
        }catch (Exception e){
            System.out.println("Ocurrio un Error");
        }

    }

    private boolean validGameOver()
    {
        boolean fullMatrix=false;
        int countTot=0;
        for (int i=0; i<8; i++)
        {
            for (int j=0; j<8; j++)
            {
                if (matrix[i][j] == this.white || matrix[i][j]== this.black)
                {
                    countTot++;
                }
            }
        }
        if (countTot==64)
        {
            fullMatrix=true;
        }
        return fullMatrix;
    }

    private void printTable(){
        System.out.format("+---+---+---+---+---+---+---+---+---+%n");
        System.out.format("|   | a | b | c | d | e | f | g | h |%n");
        System.out.format("+---+---+---+---+---+---+---+---+---+%n");
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
                System.out.format("+---+---+---+---+---+---+---+---+---+%n");
            } catch (Exception e) {
                System.out.println(e);
            }
        }
    }

    private void fullMatrix() {
        for ( int i = 0; i < matrix.length; i++) {
            for (int j = 0; j < matrix.length; j++){
                if ((i == 3) && (j == 4)){
                    this.matrix[i][j] = "X";
                }
                this.matrix[i][j] = " ";
            }
        }
    }
}
