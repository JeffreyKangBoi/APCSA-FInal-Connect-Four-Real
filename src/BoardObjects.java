import javax.swing.*;


public class BoardObjects {
    private JButton a;
    //private int col;
    //private int row;
    private JPanel b;
    private int thing;
    /*public BoardObjects(int xx, int yy) {
        col = yy;
        row = xx;
        a = new JButton();
    }

    public int getCol () {
        return col;
    }

    public int getRow() {
        return row;
    }*/

    public BoardObjects(int num) {
        thing = num;
        a = new JButton("");
        b = new JPanel();
        b.add(a);
    }

    public JButton getButton() {
        return a;
    }

    public JPanel getPannel() {
        return b;

    }

    public void setNum(int n){
        thing=n;
    }

    public int getNum() {
        return thing;
    }

    public void stopvisible() {
        a.setVisible(false);
    }
    public void startvisible() {
        a.setVisible(true);
    }

    public void setText(String s) {
        a.setText(s);
    }
}
