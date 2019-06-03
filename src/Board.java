import javax.swing.*;
import java.awt.event.ActionEvent;
import java.awt.event.ActionListener;
import java.util.ArrayList;

public class Board {
    private static BoardObjects [][] board = new BoardObjects[6][7];
    private int turn;

    public Board () {
        for(int i = 0; i < board.length; i++) {
            for(int j = 0; j <board[0].length;j++) {
                board[i][j] = new BoardObjects( 0);
            }
        }
        turn = 1;
    }

    //public BoardObjects[][] getBoard(){
        //return board;
   // }


    public int getTurn() {
        return turn;
    }

    public void incrementTurn() {
        turn++;
    }

    public void setStart () {
        for(int i = 0; i < board.length; i++) {
            for(int j = 0; j <board[0].length;j++) {
                board[i][j].setNum(0);
                board[i][j].startvisible();
                board[i][j].setText("");
                turn=1;
            }
        }


    }

    public ArrayList<Integer> findAvilSpots() {
        ArrayList<Integer> a = new ArrayList<Integer>();
        for(int i = 0; i < 7; i++){
            for (int j =5; j > -1; j--) {
                if (board[j][i].getNum()==0) {
                    a.add(j);
                    break;
                }

            }
            if(a.size()<i+1){
                a.add(-1);
            }
        }
        return a;
    }

    public void setSpot (int row, int col, int num) {
        board[row][col].setNum(num);
    }

    public BoardObjects getSpot (int row, int col) {
        return board[row][col];
    }

    public void printThings () {
        for (int i = 0; i< board.length;i++) {
            System.out.println();
            for(int j = 0; j < board[0].length; j++) {
                System.out.print(board[i][j].getNum());
            }
        }
        System.out.println("");

    }

    /*public boolean horizontalCheck(int n) {
        for (int i = 0; i < board.length;i++) {
            for(int j =0; j <board[0].length;j++) {
                if (board[i][j].getNum() == n && board[i][j+1].getNum() == n && board[i][j+2].getNum() == 0 && board[i][j+3].getNum() == n) {
                    return true;
                }
            }
        }
        return false;
    }

    public boolean verticalCHeck(int n) {
        for(int i =0; i <board[0].length; i++) {
            for(int j =0; j <board.length; j++) {

            }
        }
    }*/
    public boolean horizontalCheck (int row, int col, int n){
        if(board[row][col].getNum()==n && board[row][col + 1].getNum()==n && board[row][col + 2].getNum()==n && board[row][col + 3].getNum()==n){
            return true;
        }
        return false;
    }

    public boolean verticalCheck (int row, int col, int n){
        if(board[row][col].getNum()==n && board[row+1][col].getNum()==n && board[row+2][col].getNum()==n && board[row+3][col].getNum()==n){
            return true;
        }
        return false;
    }

    public boolean diagonalCheckbottoTop (int row, int col, int n){
        if(board[row][col].getNum()==n && board[row+1][col+1].getNum()==n && board[row+2][col+2].getNum()==n && board[row+3][col+3].getNum()==n){
            return true;
        }
        return false;
    }

    public boolean diagonalChecktoptoBot (int row, int col, int n) {
        if(board[row][col].getNum()==n && board[row-1][col+1].getNum()==n && board[row-2][col+2].getNum()==n && board[row-3][col+3].getNum()==n){
            return true;
        }
        return false;
    }

    public boolean completeCheck(int n) {
        for(int i = 0; i < board.length-3; i++) {
            for(int j = 0; j < board[0].length-3;j++) {
                if(diagonalCheckbottoTop(i,j,n)){
                    return true;
                }
            }
        }
        for(int i = 0; i < board.length-3; i++) {
            for(int j = 0; j < board[0].length;j++) {
                if(verticalCheck(i,j,n)){
                    return true;
                }
            }
        }

        for(int i = 0; i < board.length; i++) {
            for(int j = 0; j < board[0].length-3;j++) {
                if(horizontalCheck(i,j,n)){
                    return true;
                }
            }
        }
        for(int i = board.length-1; i > 2; i--) {
            for(int j =0; j <board[0].length- 3;j++) {
                if(diagonalChecktoptoBot(i,j,n)){
                    return true;
                }
            }
        }
        /*for(int i = board.length-3; i > 2; i--) {
            for(int j =0 ; j < board[0].length-3; j++) {
                if(diagonalCheck(i,j,n)){
                    return true;
                }
            }
        }*/
        return false;
    }

    public void end () {
        for(int i =0; i <board.length; i++) {
            for (int j =0; j < board[0].length;j++){
                board[i][j].stopvisible();
            }
        }
    }

    /*public JButton buttonMaker(Player p, int i, int j){
        getSpot(i,j).getButton().addActionListener(new ActionListener() {



            public void actionPerformed(ActionEvent e) {
                ArrayList<Integer> k = findAvilSpots();
                int count = 0;
                if(i==k.get(j)){
                    count++;
                }
                //System.out.println(k);
                //System.out.println(count);
                if(count==1) {
                    if(b.getTurn()%2==1) {
                        getSpot(i, j).getButton().setText("X");
                        setSpot(i, j, 1);
                        if(completeCheck(1)){
                            end();
                            System.out.println("!");

                        }
                    }else {
                        a.getSpot(i, j).getButton().setText("O");
                        a.setSpot(i, j, 2);
                        if(a.completeCheck(2)){
                            a.end();
                            System.out.println("!");

                        }


                    }
                    b.increment();
                }
                a.printThings();
            }
        });

    }*/
}
