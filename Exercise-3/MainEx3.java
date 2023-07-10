package ex3;

import javax.swing.*;

public class MainEx3 {
    public static void main(String[] args) {
        // Instantiate a JFrame
        JFrame jf = new JFrame("Vegetation Data");

        // Instantiate a PlotVegetation object and add it to the JFrame
        VegetationData vd = new VegetationData(1000, 500); // Change resolution as needed
        PlotVegetation plot = new PlotVegetation(vd, true, true);
        jf.getContentPane().add(plot);

        // Set the properties of the JFrame
        jf.setSize(1000, 500); // Change size as needed
        jf.setDefaultCloseOperation(JFrame.EXIT_ON_CLOSE);
        jf.setLocationRelativeTo(null);
        jf.setVisible(true);
    }
}