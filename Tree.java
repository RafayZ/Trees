package ex1;

//basic Tree implementation for all the trees
public abstract class Tree {
    private int height;

    public Tree(int height){
        this.height = height;
    }

    public int getHeight(){
        return height;
    }

    public abstract String getSegment(int level);

    @Override
    public String toString() {
        StringBuilder sb = new StringBuilder();
        for (int i = height; i >= 0; i--) {
            sb.append(getSegment(i)).append('\n');
        }
        return sb.toString();
    }
}
