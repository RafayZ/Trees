package ex1;

public class MainEx1 {
    public static void main(String[] args) {
        Forest forest = new Forest(10, 6);
        System.out.println("Forest: " + "\n");
        System.out.println(forest);
        System.out.println("Number Of Bamboo Trees: " + forest.GetBambooCounter());
        System.out.println("Number Of BroadLeaf Trees: " + forest.GetBroadCounter());
        System.out.println("Number Of Pine Trees: " + forest.GetPineCounter());
        System.exit(0);
    }
}
