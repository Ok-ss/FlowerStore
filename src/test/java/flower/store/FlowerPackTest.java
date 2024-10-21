package flower.store;

import static org.junit.jupiter.api.Assertions.assertEquals;

import java.util.Random;

import org.junit.jupiter.api.Test;

public class FlowerPackTest {
    private static final Random RANDOM_GENERATOR = new Random();
    private static final int MAX_PRICE = 100;
    private static final int MAX_QUANTITY = 1000;



//ROSE PACK
    @Test
    public void testRosePack() {
        double price_r = RANDOM_GENERATOR.nextDouble(MAX_PRICE);
        Rose rose = new Rose();
        rose.setPrice(price_r);
        int quantity = RANDOM_GENERATOR.nextInt(MAX_QUANTITY);

        FlowerPack pack = new FlowerPack(rose, quantity);
        assertEquals(pack.getPrice(), price_r*quantity);
    }

    @Test
    public void testEmptyRosePack() {
        double price_r = RANDOM_GENERATOR.nextDouble(MAX_PRICE);
        Rose rose = new Rose();
        rose.setPrice(price_r);
        int quantity = 0;

        FlowerPack pack = new FlowerPack(rose, quantity);
        assertEquals(pack.getPrice(), price_r*quantity);
    }

//TULIP PACK 
    @Test 
    public void testTulipPack() {
        double price_t = RANDOM_GENERATOR.nextDouble(MAX_PRICE);
        Tulip tulip = new Tulip();
        tulip.setPrice(price_t);
        int quantity = RANDOM_GENERATOR.nextInt(MAX_QUANTITY);

        FlowerPack pack = new FlowerPack(tulip, quantity);
        assertEquals(pack.getPrice(), quantity*price_t);
    }

    @Test
    public void testEmptyTulipPack() {
        double price_t = RANDOM_GENERATOR.nextDouble(MAX_PRICE);
        Tulip tulip = new Tulip();
        tulip.setPrice(price_t);
        int quantity = 0;
    
        FlowerPack pack = new FlowerPack(tulip, quantity);
        assertEquals(pack.getPrice(), quantity*price_t);
    }


//CHAMOMILE PACK  
    @Test
    public void testChamomilePack() {
        double price_c = RANDOM_GENERATOR.nextDouble(MAX_PRICE);
        Chamomile chamomile = new Chamomile();
        chamomile.setPrice(price_c);
        int quantity = RANDOM_GENERATOR.nextInt(MAX_QUANTITY);

        FlowerPack pack = new FlowerPack(chamomile, quantity);
        assertEquals(pack.getPrice(), quantity*price_c);
    }

    @Test
    public void testEmptyChamomilePack() {
        double price_c = RANDOM_GENERATOR.nextDouble(MAX_PRICE);
        Chamomile chamomile = new Chamomile();
        chamomile.setPrice(price_c);
        int quantity = 0;

        FlowerPack pack = new FlowerPack(chamomile, quantity);
        assertEquals(pack.getPrice(), quantity*price_c);
    }
}
