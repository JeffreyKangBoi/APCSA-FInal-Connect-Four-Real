import java.util.ArrayList;

public class Player {
    int turnNumber;
    String symbol;
    String type;

    public Player (int theTurntype) {
        turnNumber = theTurntype;
        if(theTurntype%2==1) {
            symbol = "X";
        }else{
            symbol = "O";
        }
        type= "Player";

    }

    public int getTurnNumber(){
        return turnNumber;
    }


    public String getSymbol() {
        return symbol;
    }

    public void setTurnNumber(int i) {
        turnNumber = i;

    }

    public String getType() {
        return type;
    }

    public void setType(String s) {
        type = s;
    }

    public int[] spotChooser (Board b, Player p, int i, int j) {
        //System.out.println("yay");
        ArrayList<Integer> k = b.findAvilSpots();
        int count = 0;
        if(i==k.get(j)){
            count++;
        }
        if (count ==1) {
            int [] thing = new int[2];
            thing[0] = i;
            thing[1] = j;
            return thing;
        }
        int[] bad = new int[1];
        bad[0] = -1;
        return bad;



    }

}
