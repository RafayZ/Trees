package ex4;

import java.io.*;
import java.util.*;

public class TreePriceData {
    private ArrayList<TreePrice> treePrices = new ArrayList<>();
    ArrayList<TreePrice> finalList = new ArrayList<>();

    //constructor to read the file, split it and add it to an ArrayList
    public TreePriceData() throws IOException {
        BufferedReader reader = new BufferedReader(new FileReader("src/ex4/treePrices.csv"));
        String line;
        boolean firstLine = true;
        while ((line = reader.readLine()) != null) {
            if (firstLine) {
                firstLine = false;
                continue; // Skip first line with column headers
            }
            String[] fields = line.split(",");
            int day = Integer.parseInt(fields[0].substring(0, 2));
            int month = getMonth(fields[0].substring(3, 6));
            int year = Integer.parseInt(fields[0].substring(7));
            PriceDate priceDate = new PriceDate(day, month, year);
            double nominalPrice = Double.parseDouble(fields[1]);
            double realPrice = Double.parseDouble(fields[2]);
            TreePrice treePrice = new TreePrice(realPrice, nominalPrice, priceDate);
            treePrices.add(treePrice);
        }
        reader.close();
        Collections.sort(treePrices);
    }

    //Loop through the months to check for the matching month
    private int getMonth(String monthStr) {
        String[] months = {"Jan", "Feb", "Mar", "Apr", "May", "Jun", "Jul", "Aug", "Sep", "Oct", "Nov", "Dec"};
        for (int i = 0; i < months.length; i++) {
            if (months[i].equals(monthStr)) {
                return i + 1;
            }
        }
        return -1;
    }


    //method to sort out the TreePrices according to their year
    public ArrayList<TreePrice> sortTreePrices() {
        ArrayList<TreePrice> firstResult = new ArrayList<>();
        for (TreePrice treePrice : treePrices) {
            int year = treePrice.getPriceDate().getYear();
            if (year >= 86 && year <= 99) {
                firstResult.add(treePrice);
            }
        }
        ArrayList<TreePrice> secondResult = new ArrayList<>();
        for (TreePrice treePrice : treePrices) {
            int year = treePrice.getPriceDate().getYear();
            if (year >= 00 && year <= 22) {
                secondResult.add(treePrice);
            }
        }
        finalList.addAll(firstResult);
        finalList.addAll(secondResult);
        return finalList;
    }


    //Getter method to return that respective array
    public ArrayList<TreePrice> getTreePrices() {
        return finalList;
    }
}