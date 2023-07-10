package ex1;
/* This is the three type of Tree*/
public class BroadleafTree extends Tree{

    public BroadleafTree(int height){
        super(height);
    }

    @Override
    public String getSegment(int level) {
        if (getHeight() == 0) {
            return " "; }
        else if (level == getHeight()) {
            return "~";
        } else {
            return "=";
        }
    }
}
