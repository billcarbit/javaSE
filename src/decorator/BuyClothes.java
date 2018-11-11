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

    private void buyWesternStyleClothes() {
        System.out.println("买一套西服");
    }
}
