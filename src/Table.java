import java.util.Arrays;
import java.util.Scanner;

public class Table {
    private String leftAlignFormat = "| %-2s| %-2s| %-2s| %-2s| %-2s| %-2s| %-2s| %-2s| %-2s| %n";
    private String white = "O";
    private String black = "X";
    private String[][] matrix = new String[8][8];
    private int[] numbers = {1, 2, 3, 4, 5, 6, 7, 8};
    private String[] letters = {"a","b","c","d","e","f","g","j"};
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

    public static int findIndex(String arr[], String t)
    {

        int index = Arrays.binarySearch(arr, t);
        return (index < 0) ? -1 : index;
    }
    private void fillMatrix(){
        int posX = 0;
        int posY = 0;
        try {
            System.out.println("Ingrese la posicion que desea colocar su pieza");
            System.out.println("Ingrese la posicion en la fila");
            posX = this.sc.nextInt() - 1;
            System.out.println("Ingrese la letra en la columna");
            posY = this.findIndex(this.letters,this.sc.next());
            if (this.validPosition(posX,posY)) {
                this.matrix[posX][posY] = turn ? this.black : this.white;
                this.turn = !this.turn;
            }else{
                System.out.println("Posicion invalida");
            }
        }catch (Exception e){
            System.out.println("Ocurrio un Error");
        }

    }

    private boolean validPosition(int posX,int posY){
        System.out.println(this.matrix[posX][posY]);
        if (this.matrix[posX][posY] == "X" || this.matrix[posX][posY] == "Y"){
            return false;
        }
        return true;
    }

    private boolean validGameOver()
    {
        boolean fullMatrix=false;
        int countTot=0;
        int countWhite = 0;
        int countBlack = 0;
        for (int i=0; i<8; i++)
        {
            for (int j=0; j<8; j++)
            {
                if (matrix[i][j] == this.white || matrix[i][j]== this.black)
                {
                    countTot++;
                }
                if (matrix[i][j] == this.white) countWhite++;
                if (matrix[i][j]== this.black) countBlack++;
            }
        }
        if (countTot==64)
        {
            fullMatrix=true;
            this.setWinner(countWhite,countBlack);
        }
        return fullMatrix;
    }

    private void setWinner(int countWhite,int countBlack){
        if (countWhite > countBlack){
            System.out.println("El ganador es el jugador 2");
        }else{
            System.out.println("El ganador es el jugador 1");
        }
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
                this.matrix[i][j] = " ";
            }
        }
        this.matrix[3][3]=this.black;
        this.matrix[4][4]=this.black;
        this.matrix[4][3]=this.white;
        this.matrix[3][4]=this.white;
    }

    private void validBorders(){
        for ( int i = 0; i < matrix.length; i++) {
            for (int j = 0; j < matrix.length; j++){
                try {

                }catch (Exception e){
                    System.out.println(e);
                }
                this.matrix[i][j] = " ";
            }
        }
    }
}
