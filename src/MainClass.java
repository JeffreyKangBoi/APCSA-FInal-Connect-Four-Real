import jdk.nashorn.internal.objects.Global;

import javax.swing.*;
import java.awt.*;
import java.awt.event.ActionEvent;
import java.awt.event.ActionListener;
import java.awt.event.WindowEvent;
import java.util.ArrayList;

public class MainClass {

    public static void main (String[] args) {

            JFrame frame = new JFrame();
            frame.setTitle("Connect Four");
            frame.setSize(1000, 1000);
            frame.setDefaultCloseOperation(JFrame.EXIT_ON_CLOSE);
            Player[] playerlist = new Player[2];
            Board a = new Board();

            JPanel p = new JPanel();
            JPanel p2 = new JPanel();
            JPanel p4 = new JPanel();
           /* JPanel p3 = new JPanel();
            JButton playagain  = new JButton("playagain");
            playagain.addActionListener(new ActionListener() {
                @Override
                public void actionPerformed(ActionEvent e) {
                    main(new String[2]);

                }
            });

            JButton stop = new JButton("Stop");
            stop.addActionListener(new ActionListener() {
                @Override
                public void actionPerformed(ActionEvent e) {
                    frame.dispatchEvent(new WindowEvent(frame, WindowEvent.WINDOW_CLOSING));
                }
            });
            p3.add(playagain);
            p3.add(stop);
            JLabel ending = new JLabel("");
            ending.setBounds(500, 500, 200, 200);
            p3.add(ending);
            stop.setBounds(400, 400,50, 50);
            playagain.setBounds(200,250,50,50);
*/
           JButton  newgame = new JButton("new Game");
           newgame.addActionListener(new ActionListener() {
               @Override
               public void actionPerformed(ActionEvent e) {
                   main(new String[2]);
               }
           });

            JButton PvP = new JButton("PvP");
            PvP.addActionListener(new ActionListener() {
                @Override
                public void actionPerformed(ActionEvent e) {
                    playerlist[0] = new Player(1);
                    playerlist[1] = new Player(2);
                    p.setVisible(false);
                    p4.setVisible(true);
                    frame.getContentPane().add(p4);
                    frame.remove(p);
                    frame.remove(p2);
                    frame.setVisible(true);


                }
            });
            p.setLayout(null);
            newgame.setBounds(600, 600, 100, 100);
            PvP.setBounds(200, 250, 50, 50);
            JLabel ending = new JLabel("");
            ending.setBounds(100, 600, 200, 200);
            p.add(ending);
            p.add(PvP);
            p.add(newgame);

            frame.setVisible(true);

            //JPanel p1 = new JPanel();
            JButton AI = new JButton("AI");
            AI.addActionListener(new ActionListener() {
                @Override
                public void actionPerformed(ActionEvent e) {
                    playerlist[0] = new Player(1);
                    playerlist[1] = new AI(2);
                    p.setVisible(false);
                    p2.setVisible(true);
                    frame.getContentPane().add(p2);
                    frame.getContentPane().remove(p);
                }
            });
            //p1.setLayout(null);
            AI.setBounds(400, 250, 100, 50);
            //p1.add(AI);
            p.add(AI);
            //frame.add(p1);
            //p1.setVisible(true);
            frame.add(p);
            p.setVisible(true);
            frame.setVisible(true);

            JButton onX = new JButton("Second");
            onX.addActionListener(new ActionListener() {
                @Override
                public void actionPerformed(ActionEvent e) {
                    p2.setVisible(false);
                    p4.setVisible(true);
                    frame.getContentPane().add(p4);
                }
            });
            p2.setLayout(null);
            onX.setBounds(200, 250, 100, 50);
            p2.add(onX);
            //frame.add(p2);

            frame.setVisible(true);

            //JPanel p3 = new JPanel();

            JButton onO = new JButton("First");
            onO.addActionListener(new ActionListener() {
                @Override
                public void actionPerformed(ActionEvent e) {
                    playerlist[0].setTurnNumber(2);
                    playerlist[1].setTurnNumber(1);
                    p2.setVisible(false);
                    p4.setVisible(true);
                    frame.getContentPane().add(p4);
                }
            });
            //p3.setLayout(null);
            onO.setBounds(400, 250, 100, 50);
            p2.add(onO);
            //frame.add(p3);
            //p3.setVisible(false);
            p2.setVisible(true);
            frame.setVisible(true);

            JButton Start = new JButton("Start");
            Start.addActionListener(new ActionListener() {

                @Override
                public void actionPerformed(ActionEvent e) {

                    Start.setVisible(false);
                    frame.remove(p4);
                    frame.remove(p2);

                    //frame.setLayout(null);
                    GridLayout grid = new GridLayout(6, 7, 10, 10);
                    frame.setLayout(grid);
                   /* for(int i = 0; i < playerlist.length; i++) {
                        if(playerlist[i].getTurnNumber()==1 && playerlist[i].getType().equals("AI")){
                            a.getSpot(5, 4).getButton().setText(playerlist[i].getSymbol());
                            a.setSpot(5, 4,playerlist[i].getTurnNumber());
                            //a.incrementTurn();
                        }
                    }*/


                    a.setStart();
                    for (int i = 0; i < 6; i++) {
                        for (int j = 0; j < 7; j++) {

                            frame.add(a.getSpot(i, j).getButton());
                            //a.getSpot(i,j).getButton().setBounds(i*100+i*10, j*100+j*10, 100, 100);
                            //System.out.println(i*100+i*10);
                            int finalI = i;
                            int finalJ = j;
                            a.getSpot(i, j).getButton().addActionListener(new ActionListener() {


                                public void actionPerformed(ActionEvent e) {
                                    /*ArrayList<Integer> k = a.findAvilSpots();
                                    int count = 0;
                                    if(finalI==k.get(finalJ)){
                                        count++;
                                    }
                                    //System.out.println(k);
                                    //System.out.println(count);
                                    if(count==1) {
                                        if(b.getTurn()%2==1) {
                                            a.getSpot(finalI, finalJ).getButton().setText("X");
                                            a.setSpot(finalI, finalJ, 1);
                                            if(a.completeCheck(1)){
                                                a.end();
                                                //System.out.println("!");

                                            }
                                        }else {
                                            a.getSpot(finalI, finalJ).getButton().setText("O");
                                            a.setSpot(finalI, finalJ, 2);
                                            if(a.completeCheck(2)){
                                                a.end();
                                                System.out.println("!");

                                            }


                                        }
                                        b.increment();
                                    }
                                    a.printThings();*/


                                    boolean count = false;
                                    //System.out.println(playerlist[0].getTurnNumber() + " " + playerlist[0].getType() );
                                    //System.out.println(playerlist[1].getTurnNumber() + " " + playerlist[1].getType());
                                    //System.out.println(a.getTurn() + " Turn");

                                    for (int i = 0; i < playerlist.length; i++) {
                                        //System.out.println("owoeifbn");
                                        //System.out.println(a.getTurn() % 2 + " wow");
                                        if (playerlist[i].getTurnNumber() == (a.getTurn() % 2 + 1)) {
                                            //System.out.println(playerlist[i].getTurnNumber());

                                            if (playerlist[i].getType().equals("Player")) {
                                                int[] spot = playerlist[i].spotChooser(a, playerlist[i], finalI, finalJ);
                                                if (spot[0] != -1) {
                                                    a.getSpot(spot[0], spot[1]).getButton().setText(playerlist[i].getSymbol());
                                                    a.setSpot(spot[0], spot[1], playerlist[i].getTurnNumber());
                                                    //a.incrementTurn();
                                                    if (a.completeCheck(playerlist[i].getTurnNumber())) {
                                                        frame.setLayout(null);
                                                        a.end();

                                                        ending.setText(playerlist[i].getSymbol() + "  Won");

                                                        frame.getContentPane().add(p);
                                                        p.remove(PvP);
                                                        p.remove(AI);
                                                        p.setVisible(true);
                                                        frame.setVisible(true);




                                                    }
                                                    count = true;


                                                }
                                            }


                                            if (playerlist[i].getType().equals("AI")) {


                                                int[] spot = playerlist[i].spotChooser(a, playerlist[Math.abs(i - 1)], finalI, finalJ);
                                                if (spot[0] != -1) {
                                                    a.getSpot(spot[0], spot[1]).getButton().setText(playerlist[i].getSymbol());
                                                    a.setSpot(spot[0], spot[1], playerlist[i].getTurnNumber());
                                                    //a.incrementTurn();
                                                    if (a.completeCheck(playerlist[i].getTurnNumber())) {
                                                        frame.setLayout(null);
                                                        a.end();
                                                        JLabel ending = new JLabel();
                                                        ending.setText(playerlist[i].getSymbol() + "  Won");

                                                        frame.getContentPane().add(p);
                                                        p.setVisible(true);
                                                        newgame.setVisible(true);
                                                        frame.setVisible(true);

                                                    }
                                                    count = true;

                                                }
                                            }


                                        }


                                    }
                                    if (count) {
                                        a.incrementTurn();
                                    }

                                }
                            });

                        }
                    }

                    frame.setVisible(true);
                }
            });
            p4.setLayout(null);
            Start.setBounds(300, 250, 100, 50);
            p4.add(Start);
            p4.setVisible(false);
            frame.getContentPane().add(p4);
            frame.setVisible(true);


            frame.setVisible(true);



        /*Board c = new Board();
        c.setSpot(5,6,5);
        c.setSpot(5,5,5);
        c.setSpot(5,4,5);
        System.out.println(c.findAvilSpots());
        c.printThings();*/

       /*Board a = new Board("");
       a.setSpot(0,0,1);
       a.setSpot(0,1,1);
       a.setSpot(0,2,1);
       a.setSpot(0,3,1);

       System.out.println(a.completeCheck(1))
       */


        }

        /*public static void main(){

        }
        */

}
