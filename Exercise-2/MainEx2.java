package ex2;

import java.util.*;
public class MainEx2 {
    public static void main(String[] args) {
        Scanner input = new Scanner(System.in);
        TreeData td = new TreeData("src/ex2/treesPruned.csv");
        System.out.println(" ");
        //while true loop to have a recurring menu
        while(true){
            System.out.println("Please enter:\n" +
                    "1 to print number of trees per borough\n" +
                    "2 to print most common tree age\n" +
                    "3 to print least common tree age\n" +
                    "4 to print average height per tree name\n" +
                    "5 to enter tree name and print average height\n" +
                    "quit to quit");
            System.out.println(" ");
            String choice = input.nextLine();
            switch (choice){
                case "1":
                    td.printTreesPerBorough();
                    break;
                case "2":
                    td.printMostCommonAge();
                    break;
                case "3":
                    td.printLeastCommonAge();
                    break;
                case "4":
                    td.printAverageHeightPerTreeName();
                    break;
                case "5":
                    Scanner inputTree = new Scanner(System.in);
                    System.out.println("Enter the Tree name: ");
                    String treeChoice = inputTree.nextLine();
                    td.printAverageHeightForTree(treeChoice);
                    break;
                case "quit":
                    System.out.println("Bye!");
                    input.close();
                    System.exit(0);
                default:
                    System.out.println("Invalid option!");
                    break;
            }
        }
    }
}
