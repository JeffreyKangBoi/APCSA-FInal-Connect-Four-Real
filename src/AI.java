import java.util.ArrayList;

public class AI extends Player {
    public AI (int turntype){
        super(turntype);
        setType("AI");
    }

    public int[] spotChooser(Board b, Player p,int i1, int j1) {
        ArrayList<Integer> k = b.findAvilSpots();
        /*int[][] arr  = new int[b.getBoard().length][b.getBoard()[0].length]
        for(int i =0; i < b.getBoard().length; i++){
            for (int j = 0 ; j <b.getBoard()[0].length; j++){
                arr[i][j] = b.getSpot(i,j).getNum();
            }
        }*/
        int[] thing = new int[2];
        thing[0] = -1;
        thing[1] = -1;
        ArrayList<Integer> badSpots = new ArrayList<>();
        ArrayList<Integer> goodSpots = new ArrayList<>();

        for(int i = 0; i < k.size(); i++) {
            if(k.get(i) !=-1){
                //System.out.println(i + "i");
                //System.out.println(k.get(i));

                //checks if possible to instantly win
                b.setSpot(k.get(i), i, getTurnNumber());
                if(b.completeCheck(getTurnNumber())){

                    thing[0] = k.get(i);
                    thing[1] = i;
                    b.setSpot(k.get(i), i, 0);
                    return thing;

                }
                b.setSpot(k.get(i), i, 0);

                //checks if there is any spot that would be lost if not placed
                b.setSpot(k.get(i), i, p.getTurnNumber());
                if(b.completeCheck(p.getTurnNumber())){
                    thing[0] = k.get(i);
                    thing[1] = i;
                    b.setSpot(k.get(i), i, 0);
                    return thing;
                }
                b.setSpot(k.get(i), i, 0);

                //Check if placing there would result in losing game
                b.setSpot(k.get(i), i, p.getTurnNumber());
                ArrayList<Integer> yum = b.findAvilSpots();
                for(int j = 0; j <yum.size(); j++) {
                    if(yum.get(j)!=-1) {
                        b.setSpot(yum.get(j), j, p.getTurnNumber());
                        if (b.completeCheck(p.getTurnNumber())) {
                            badSpots.add(i);

                        }
                        b.setSpot(yum.get(j), j, 0);
                    }

                }
                b.setSpot(k.get(i), i, 0);

                //check if it is a "good" square



            }



        }
        //checks if there are any good spots, if not then doesn't change so will instant lose
        if(findnumneg1(k) == badSpots.size()) {
            for (int i = 0; i < badSpots.size(); i++) {
                k.set(badSpots.get(i), -1);

            }
        }

        while (true) {
            int r = (int) (Math.random() * k.size());
            if(k.get(r)!= -1) {
                thing[0] = k.get(r);
                thing[1] = r;
                return thing;
            }
        }


    }

    public int findnumneg1 (ArrayList<Integer> a) {
        int count = 0;
        for (int i = 0; i < a.size(); i++) {
            if(a.get(i)==-1) {
                count++;
            }
        }
        return count;
    }
}
