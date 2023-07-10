package ex2;

import java.io.*;
import java.util.*;

public class TreeData {
    private HashMap<String, Integer> treesPerBorough = new HashMap<>();
    private HashMap<String, Integer> treesPerAgeGroup = new HashMap<>();
    private HashMap<String, Double> sumHeightPerTree = new HashMap<>();
    private HashMap<String, Integer> countPerTree = new HashMap<>();

    //Constructor to read the file and add it to the different Hashmaps accordingly
    public TreeData(String fileName) {
        try (Scanner scanner = new Scanner(new File(fileName))) {
            System.out.println("File has been successfully read!!");
            boolean header = true;
            while (scanner.hasNextLine()) {
                String line = scanner.nextLine();
                if (header) {
                    header = false;
                    continue; // skip header line
                }
                String[] parts = line.split(",");
                String borough = parts[1];
                String ageGroup = parts[3];
                String treeName = parts[2];
                double height = Double.parseDouble(parts[4]);
                Tree Tree = new Tree(borough, treeName, ageGroup, height);
                treesPerBorough.put(Tree.getLocation(), treesPerBorough.getOrDefault(Tree.getLocation(), 0) + 1);
                treesPerAgeGroup.put(Tree.getAge(), treesPerAgeGroup.getOrDefault(Tree.getAge(), 0) + 1);
                if (sumHeightPerTree.containsKey(treeName)) {
                    double sumHeight = sumHeightPerTree.get(treeName);
                    sumHeight += height;
                    sumHeightPerTree.put(treeName, sumHeight);
                    countPerTree.put(treeName, countPerTree.get(treeName) + 1);
                } else {
                    sumHeightPerTree.put(treeName, Tree.getHeight());
                    countPerTree.put(treeName, 1);
                }
            }
        } catch (FileNotFoundException e) {
            System.out.println("Error!! Your File was not found!");
            System.exit(1);
        }
    }


    //method to print the trees per borough
    public void printTreesPerBorough() {
        for (String borough : treesPerBorough.keySet()) {
            System.out.println(borough + "=" + treesPerBorough.get(borough));
        }
        System.out.println(" ");
    }


    //method to print the most common age amongst trees with the respective type
    public void printMostCommonAge() {
        Map.Entry<String, Integer> largestEntry = null;
        for (Map.Entry<String, Integer> entry : treesPerAgeGroup.entrySet()) {
            if (largestEntry == null || entry.getValue() > largestEntry.getValue()) {
                largestEntry = entry;
            }
        }
        System.out.println(largestEntry.getKey() + "=" + largestEntry.getValue());
    }


    //method to print the least common age amongst the trees with the respective type
    public void printLeastCommonAge() {
        Map.Entry<String, Integer> smallestEntry = null;
        for (Map.Entry<String, Integer> entry : treesPerAgeGroup.entrySet()) {
            if (smallestEntry == null || entry.getValue() < smallestEntry.getValue()) {
                smallestEntry = entry;
            }
        }
        System.out.println(smallestEntry.getKey() + "=" + smallestEntry.getValue());
    }


    //This is printing all the names of the trees with their respective heights
    public void printAverageHeightPerTreeName() {
        for (String treeName : sumHeightPerTree.keySet()) {
            double sumHeight = sumHeightPerTree.get(treeName);
            int count = countPerTree.get(treeName);
            double averageHeight = sumHeight / count;
            System.out.println(treeName + "=" + averageHeight);
        }
        System.out.println(" ");
    }


    //this is taking in a tree name through user input and then searching through a list to check for that tree name and finally giving its height
    public void printAverageHeightForTree(String treeName) {
        if (sumHeightPerTree.containsKey(treeName)) {
            double sumHeight = sumHeightPerTree.get(treeName);
            int count = countPerTree.get(treeName);
            double averageHeight = sumHeight / count;
            System.out.println(averageHeight);
        } else {
            System.out.println("No trees of type " + treeName + " found.");
        }
        System.out.println(" ");
    }
}



