package ex1;
/* This is the second type of Tree*/
public class PineTree extends Tree {

    public PineTree(int height) {
        super(height);
    }

    @Override
    public String getSegment(int level) {
        if (getHeight() == 0) {
            return " "; }
        else if (level == getHeight()) {
            return "*";
        } else {
            return "|";
        }
    }
}
