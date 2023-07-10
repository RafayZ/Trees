package ex3;

import java.awt.Color;
import java.awt.Graphics;
import java.awt.Graphics2D;
import javax.swing.JComponent;

public class PlotVegetation extends JComponent {
    private final VegetationData vd;
    private final boolean useColour;
    private final boolean useMap;

    //constructor to initialize all the variables
    public PlotVegetation(VegetationData vd, boolean useColour, boolean useMap) {
        this.vd = vd;
        this.useColour = useColour;
        this.useMap = useMap;
    }


    //main paintComponent method to draw the map
    @Override
    public void paintComponent(Graphics g) {
        Graphics2D g2 = (Graphics2D) g;
        int width = getWidth();
        int height = getHeight();

        // Loop through the pixels and draw them
        for (int y = 0; y < height; y++) {
            for (int x = 0; x < width; x++) {
                int treeDensity;
                if (useMap) {
                    double longitude = ((double) x / width) * 360 - 180;
                    double latitude = 90 - ((double) y / height) * 180;
                    treeDensity = vd.getFromMap(longitude, latitude);
                } else {
                    treeDensity = vd.getFromArray(x, y);
                }

                // Set the colour based on the tree density
                if (treeDensity == 0) {
                    g2.setColor(useColour ? Color.WHITE : Color.BLACK);
                } else if (treeDensity == 254) {
                    g2.setColor(useColour ? Color.BLUE : Color.WHITE);
                } else {
                    float hue = (float) (0.13 + (treeDensity / 255.0) * 0.2); // hue ranges from 0.13 (brown) to 0.33 (green)
                    float saturation = 0.7f; // constant saturation
                    float brownBrightness = (float) (0.7 + (treeDensity / 255.0) * 0.3); // brightness ranges from 0.6 (dark) to 1.0 (light)
                    float greenBrightness = (float) (0.1 + (treeDensity / 255.0) * 0.9); // brightness ranges from 0.3 (dark) to 1.0 (light)
                    if (hue < 0.25) { // if brown
                        g2.setColor(useColour ? Color.getHSBColor(hue, saturation, brownBrightness) : new Color(treeDensity, treeDensity, treeDensity));
                    } else { // if green
                        g2.setColor(useColour ? Color.getHSBColor(hue, saturation, greenBrightness) : new Color(treeDensity, treeDensity, treeDensity));
                    }
                }
                g2.fillRect(x, y, 1, 1);
            }
        }
    }
}

