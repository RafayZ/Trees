package ex1;

import java.util.ArrayList;
import java.util.Random;

public class Forest {
    private ArrayList<Tree> trees = new ArrayList<>();
    int bambooCounter = 0;
    int broadCounter = 0;
    int pineCounter = 0;

    //Constructor to take parameters and select different trees
    public Forest(int numTrees, int maxHeight) {
        Random random = new Random();

        for (int i = 0; i < numTrees; i++) {
            int height = random.nextInt(maxHeight);

            int treeType = random.nextInt(3);
            Tree tree = null;
            switch (treeType) {
                case 0:
                    tree = new Bamboo(height);
                    bambooCounter++;
                    break;
                case 1:
                    tree = new BroadleafTree(height);
                    broadCounter++;
                    break;
                case 2:
                    tree = new PineTree(height);
                    pineCounter++;
                    break;
            }
            trees.add(tree);
        }

    }

    //method to print the trees
    @Override
    public String toString() {
        int max = 0;
        for (Tree tree : trees) {
            if (tree.getHeight() > max) {
                max = tree.getHeight();
            }
        }
        StringBuilder sb = new StringBuilder();
        int maxTreeHeight = max;

        for (int i = maxTreeHeight; i >= 0; i--) {
            for (Tree tree : trees) {
                if (tree.getHeight() >= i) {
                    sb.append(tree.getSegment(i) + " ");
                } else {
                    sb.append("  ");
                }
            }
            sb.append("\n");
        }
        return sb.toString();
    }

    //methods to count specific type of trees
     public int GetBambooCounter(){
        return bambooCounter;
     }

    public int GetBroadCounter(){
        return broadCounter;
    }

    public int GetPineCounter(){
        return pineCounter;
    }
}

