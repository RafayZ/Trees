package ex1;
/* This is the first type of Tree*/
public class Bamboo extends Tree{

    public Bamboo(int height){
        super(height);
    }

    @Override
    public String getSegment(int level) {
        if (getHeight() == 0) {
            return " "; }
        else if (level == getHeight()) {
            return "^";
        } else {
            return "|";
        }
    }
}
