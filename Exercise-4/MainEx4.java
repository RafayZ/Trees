package ex4;

import javax.swing.*;
import java.io.IOException;

public class MainEx4 {
    public static void main(String[] args) throws IOException {
        TreePriceData tpd = new TreePriceData();
        tpd.sortTreePrices();
        TreePricePlot plot = new TreePricePlot(tpd);

        JFrame jf = new JFrame();
        jf.getContentPane().add(plot);
        jf.setSize(1000, 500);
        jf.setDefaultCloseOperation(JFrame.EXIT_ON_CLOSE);
        jf.setLocationRelativeTo(null);
        jf.setVisible(true);
    }
}
