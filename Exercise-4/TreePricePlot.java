package ex4;

import java.awt.event.MouseAdapter;
import java.awt.event.MouseEvent;
import java.awt.geom.AffineTransform;
import java.awt.*;
import java.util.List;

import javax.swing.JComponent;

public class TreePricePlot extends JComponent {
    private TreePriceData treePriceData;

    public TreePricePlot(TreePriceData treePriceData) {
        this.treePriceData = treePriceData;
        addMouseListener(new MouseAdapter() {
            @Override
            public void mouseClicked(MouseEvent e) {
                displayClosestPrices(e.getX());
            }
        });
    }

    //Main paint method to draw the graph
    @Override
    public void paintComponent(Graphics g) {
        Graphics2D g2d = (Graphics2D) g;

        if (treePriceData == null) {
            return;
        }

        List<TreePrice> treePrices = treePriceData.getTreePrices();

        // Calculate the maximum and minimum prices
        double maxPrice = Double.MIN_VALUE;
        double minPrice = Double.MAX_VALUE;
        for (TreePrice treePrice : treePrices) {
            double nominalPrice = treePrice.getNominalPrice();
            double realPrice = treePrice.getRealPrice();
            maxPrice = Math.max(maxPrice, Math.max(nominalPrice, realPrice));
            minPrice = Math.min(minPrice, Math.min(nominalPrice, realPrice));
        }

        // Set the color and font for the nominal price line
        g2d.setColor(Color.BLUE);
        g2d.setFont(new Font("Arial", Font.PLAIN, 12));

        // Plot the nominal price line
        int x1 = 50;
        int y1 = (int) ((maxPrice - treePrices.get(0).getNominalPrice()) / (maxPrice - minPrice) * (getHeight() - 100)) + 50;
        for (int i = 0; i < treePrices.size(); i++) {
            int x2 = (int) ((double) i / (treePrices.size() - 1) * (getWidth() - 100)) + 50;
            int y2 = (int) ((maxPrice - treePrices.get(i).getNominalPrice()) / (maxPrice - minPrice) * (getHeight() - 100)) + 50;
            g2d.drawLine(x1, y1, x2, y2);
            x1 = x2;
            y1 = y2;

            // Save the current graphics state
            AffineTransform savedTransform = g2d.getTransform();

            // Rotate the graphics object by 45 degrees around the current point
            double radians = Math.toRadians(45);
            g2d.rotate(radians, x1, getHeight() - 25);

            // Print the date beneath each data point at the rotated angle
            String dateString = treePrices.get(i).getPriceDate().toString();
            g2d.drawString(dateString, x1 - 25, getHeight() - 25);

            // Restore the saved graphics state
            g2d.setTransform(savedTransform);
        }

        // Set the color and font for the real price line
        g2d.setColor(Color.RED);
        g2d.setFont(new Font("Arial", Font.PLAIN, 12));

        // Plot the real price line
        x1 = 50;
        y1 = (int) ((maxPrice - treePrices.get(0).getRealPrice()) / (maxPrice - minPrice) * (getHeight() - 100)) + 50;
        for (int i = 0; i < treePrices.size(); i++) {
            int x2 = (int) ((double) i / (treePrices.size() - 1) * (getWidth() - 100)) + 50;
            int y2 = (int) ((maxPrice - treePrices.get(i).getRealPrice()) / (maxPrice - minPrice) * (getHeight() - 100)) + 50;
            g2d.drawLine(x1, y1, x2, y2);
            x1 = x2;
            y1 = y2;
        }
    }

    private void displayClosestPrices(int x) {
        if (treePriceData == null) {
            return;
        }
        List<TreePrice> treePrices = treePriceData.getTreePrices();

        // Find the index of the closest data point to the clicked point
        int closestIndex = 0;
        double closestDistance = Double.MAX_VALUE;
        for (int i = 0; i < treePrices.size(); i++) {
            int pointX = (int) ((double) i / (treePrices.size() - 1) * (getWidth() - 100)) + 50;
            double distance = Math.abs(pointX - x);
            if (distance < closestDistance) {
                closestIndex = i;
                closestDistance = distance;
            }
        }

        // Get the closest nominal and real prices
        double closestNominalPrice = treePrices.get(closestIndex).getNominalPrice();
        double closestRealPrice = treePrices.get(closestIndex).getRealPrice();

        // Print the prices to the console
        System.out.println("Closest nominal price: " + closestNominalPrice);
        System.out.println("Closest real price: " + closestRealPrice);
    }

}

