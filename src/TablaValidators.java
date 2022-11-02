public class TablaValidators {
    private String white = "O";
    private String black = "X";
    public boolean validPosition(int posX,int posY,String[][] matrix){
        if (matrix[posX][posY] == this.black || matrix[posX][posY] == this.white){
            return false;
        }
        return true;
    }

    public boolean validGameOver(String[][] matrix)
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

    public void validBorders(int posX, int posY, boolean turn, String[][] matrix) {
        String val = turn ? this.white : this.black;
        String otherVal = turn ? this.black : this.white;
        try {
            if (matrix[posX - 1][posY] == val) {
                this.validOtherSide("up",posX - 1,posY,otherVal, matrix);
            }
        } catch (Exception e) {
        }
        try {
            if (matrix[posX - 1][posY + 1] == val) {
                this.validOtherSide("upRight",posX - 1,posY + 1,otherVal, matrix);
            }
        } catch (Exception e) {
        }
        try {
            if (matrix[posX - 1][posY - 1] == val) {
                this.validOtherSide("upLeft",posX - 1,posY - 1,otherVal, matrix);
            }
        } catch (Exception e) {
        }
        try {
            if (matrix[posX + 1][posY] == val) {
                this.validOtherSide("down",posX + 1,posY,otherVal, matrix);
            }
        } catch (Exception e) {
        }
        try {
            if (matrix[posX + 1][posY + 1] == val) {
                this.validOtherSide("downRight",posX + 1,posY + 1,otherVal, matrix);
            }
        } catch (Exception e) {
        }
        try {
            if (matrix[posX + 1][posY - 1] == val) {
                this.validOtherSide("downLeft",posX + 1,posY - 1,otherVal, matrix);
            }
        } catch (Exception e) {
        }
        try {
            if (matrix[posX][posY - 1] == val) {
                this.validOtherSide("left",posX,posY - 1,otherVal, matrix);
            }
        } catch (Exception e) {
        }
        try {
            if (matrix[posX][posY + 1] == val) {
                this.validOtherSide("right",posX,posY + 1,otherVal, matrix);
            }
        } catch (Exception e) {
        }
    }

    private void validOtherSide(String op,int posX, int posY,String val, String[][] matrix){
        switch (op){
            case "up":
                if (matrix[posX - 1][posY] == val){
                    matrix[posX][posY] = val;
                }
                break;
            case "down":
                if (matrix[posX + 1][posY] == val){
                    matrix[posX][posY] = val;
                }
                break;
            case "left":
                if (matrix[posX][posY - 1] == val){
                    matrix[posX][posY] = val;
                }
                break;
            case "right":
                if (matrix[posX][posY + 1] == val){
                    matrix[posX][posY] = val;
                }
                break;
            case "upRight":
                if (matrix[posX - 1][posY + 1] == val){
                    matrix[posX][posY] = val;
                }
                break;
            case "upLeft":
                if (matrix[posX - 1][posY - 1] == val){
                    matrix[posX][posY] = val;
                }
                break;
            case "downRight":
                if (matrix[posX + 1][posY + 1] == val){
                    matrix[posX][posY] = val;
                }
                break;
            case "downLeft":
                if (matrix[posX + 1][posY - 1] == val){
                    matrix[posX][posY] = val;
                }
                break;
        }
    }
}
