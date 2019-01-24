package rebuild.chapter1;

public class NewReleasePrice extends Price {


    public double getCharge(int daysRented) {
        return daysRented * 3;
    }


    @Override
    protected int getPriceCode() {
        return Movie.NEW_RELEASE;
    }
}
