package decorator;

public class DecoratorTest {

    public static void main(String[] args) {
        Merry wangning = new Wangning();
        Merry buyClothes = new BuyClothes(wangning);
        Merry buyShoes = new BuyShoes(wangning);
        buyClothes.merry();
        buyShoes.merry();

    }
}
