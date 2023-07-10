package ex4;

public class PriceDate implements Comparable<PriceDate> {
    private final int day;
    private final int month;
    private final int year;

    public PriceDate(int day, int month, int year) {
        this.day = day;
        this.month = month;
        this.year = year;
    }

    //Getter method to return the year
    public int getYear() {
        return year;
    }

    //Comparable to compare the PriceDates etc
    @Override
    public int compareTo(PriceDate other) {
        if (this.year != other.year) {
            return Integer.compare(this.year, other.year);
        } else if (this.month != other.month) {
            return Integer.compare(this.month, other.month);
        } else {
            return Integer.compare(this.day, other.day);
        }
    }


    //toString method format properly
    @Override
    public String toString() {
        String[] months = {"Jan", "Feb", "Mar", "Apr", "May", "Jun", "Jul", "Aug", "Sep", "Oct", "Nov", "Dec"};
        String monthStr = months[this.month - 1];
        return String.format("%02d-%s-%02d", this.day, monthStr, this.year % 100);
    }
}

