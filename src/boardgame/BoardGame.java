package boardgame;

import javax.swing.WindowConstants;

public class BoardGame {

    public static void main(String[] args) {
        //Initierea jocului si a ferestrei de trade:
        Map m = new Map();
        m.setVisible(true);
        m.setTitle("Monopoly");
        Trade trade = new Trade(m);
        trade.setVisible(false);
        trade.setTitle("Trade");
        trade.setDefaultCloseOperation(WindowConstants.DISPOSE_ON_CLOSE);
        m.setTrade(trade);
    }
}
