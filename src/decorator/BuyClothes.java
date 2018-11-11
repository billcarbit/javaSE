package decorator;

public class BuyClothes implements Merry {

    private Merry mMerry;

    public BuyClothes(Merry merry) {
        mMerry = merry;
    }

    @Override
    public void merry() {
        buyWesternStyleClothes();
        mMerry.merry();
    }

    public Merry buyWesternStyleClothes() {
        System.out.println("买一套西服");
        return this;
    }
}
