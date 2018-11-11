package decorator;

public class BuyShoes implements Merry {

    private Merry mMerry;

    public BuyShoes(Merry merry) {
        mMerry = merry;
    }

    @Override
    public void merry() {
        buyLeatherShoes();
        mMerry.merry();
    }

    public Merry buyLeatherShoes() {
        System.out.println("买一双皮鞋");
        return this;
    }
}
