package ex4;

public class TreePrice implements Comparable<TreePrice> {
    private double realPrice;
    private double nominalPrice;
    private PriceDate priceDate;

    public TreePrice(double realPrice, double nominalPrice, PriceDate priceDate) {
        this.realPrice = realPrice;
        this.nominalPrice = nominalPrice;
        this.priceDate = priceDate;
    }


    //Below are some getter methods
    public double getRealPrice() {
        return realPrice;
    }

    public double getNominalPrice() {
        return nominalPrice;
    }

    public PriceDate getPriceDate() {
        return priceDate;
    }

    //Comparing the priceDate to others
    @Override
    public int compareTo(TreePrice other) {
        return this.priceDate.compareTo(other.priceDate);
    }

    //method to format the data
    @Override
    public String toString() {
        return String.format("%s Nominal: %.1f Real: %.1f", this.priceDate.toString(), this.nominalPrice, this.realPrice);
    }
}

