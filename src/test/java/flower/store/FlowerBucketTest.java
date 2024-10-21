package flower.store;

import org.junit.jupiter.api.BeforeEach;
import org.junit.jupiter.api.Test;
import org.junit.jupiter.api.Assertions;

import static org.junit.jupiter.api.Assertions.assertArrayEquals;
import static org.junit.jupiter.api.Assertions.assertEquals;

import java.util.Random;
import java.util.ArrayList;
import java.util.Optional;

public class FlowerBucketTest {
    private static final Random RANDOM_GENERATOR = new Random();
    private static final int MAX_QUANTITY = 1000;
    private static final int MAX_PRICE = 100;

    private FlowerBucket flowerBucket;

    @BeforeEach
    public void init() {
        flowerBucket = new FlowerBucket();
    }

    @Test
    public void testPrice() {
        int price = RANDOM_GENERATOR.nextInt(MAX_PRICE);
        int quantity = RANDOM_GENERATOR.nextInt(MAX_QUANTITY);
        Flower flower = new Rose();
        flower.setPrice(price);
        FlowerPack flowerPack = new FlowerPack(flower, quantity);
        flowerBucket.add(flowerPack);
        Assertions.assertEquals(price * quantity, flowerBucket.getPrice());
    }

    @Test
    public void testAdd() {
        Chamomile cham = new Chamomile();
        double f_price = RANDOM_GENERATOR.nextInt(MAX_PRICE);
        cham.setPrice(f_price);
        int quantity = RANDOM_GENERATOR.nextInt(MAX_QUANTITY);

        FlowerPack pack = new FlowerPack(cham, quantity);
        double start_price = flowerBucket.getPrice();
        flowerBucket.add(pack);
        assertEquals(start_price + pack.getPrice(), flowerBucket.getPrice());
    }

    @Test
    public void testSearchByAll() {
        double price_1 = RANDOM_GENERATOR.nextDouble(MAX_PRICE);
        Chamomile chamomile = new Chamomile();
        chamomile.setPrice(price_1);
        int quantity_1 = RANDOM_GENERATOR.nextInt(MAX_QUANTITY);
        FlowerPack pack_1 = new FlowerPack(chamomile, quantity_1);

        double price_2 = RANDOM_GENERATOR.nextDouble(MAX_PRICE);
        Tulip tulip = new Tulip();
        tulip.setPrice(price_2);
        int quantity_2 = RANDOM_GENERATOR.nextInt(MAX_QUANTITY);
        FlowerPack pack_2 = new FlowerPack(tulip, quantity_2);

        double price_3 = RANDOM_GENERATOR.nextDouble(MAX_PRICE);
        Rose rose = new Rose();
        rose.setPrice(price_3);
        int quantity_3 = RANDOM_GENERATOR.nextInt(MAX_QUANTITY);
        FlowerPack pack_3 = new FlowerPack(rose, quantity_3);

        double price_4 = RANDOM_GENERATOR.nextDouble(MAX_PRICE);
        Chamomile chamomile_2 = new Chamomile();
        chamomile_2.setPrice(price_4);
        int quantity_4 = RANDOM_GENERATOR.nextInt(MAX_QUANTITY);
        FlowerPack pack_4 = new FlowerPack(chamomile_2, quantity_4);

        flowerBucket.add(pack_1);
        flowerBucket.add(pack_2);
        flowerBucket.add(pack_3);
        flowerBucket.add(pack_4);


        ArrayList<FlowerPack> output = new ArrayList<>();
        output.add(pack_1);
        Object[] expOut = output.toArray();
        Optional<FlowerType> flower = Optional.of(FlowerType.CHAMOMILE);
        Optional<Integer> quantity = Optional.of(quantity_1);
        Optional<Double> price = Optional.of(price_1*quantity_1);

        ArrayList<FlowerPack> real = flowerBucket.search(flower, quantity, price);
        Object[] actOut = real.toArray();

        assertArrayEquals(expOut, actOut);
    }

    @Test
    public void testSearchBy2() {
        double price_1 = RANDOM_GENERATOR.nextDouble(MAX_PRICE);
        Chamomile chamomile = new Chamomile();
        chamomile.setPrice(price_1);
        int quantity_1 = RANDOM_GENERATOR.nextInt(MAX_QUANTITY);
        FlowerPack pack_1 = new FlowerPack(chamomile, quantity_1);

        double price_2 = RANDOM_GENERATOR.nextDouble(MAX_PRICE);
        Tulip tulip = new Tulip();
        tulip.setPrice(price_2);
        int quantity_2 = RANDOM_GENERATOR.nextInt(MAX_QUANTITY);
        FlowerPack pack_2 = new FlowerPack(tulip, quantity_2);

        double price_3 = RANDOM_GENERATOR.nextDouble(MAX_PRICE);
        Rose rose = new Rose();
        rose.setPrice(price_3);
        int quantity_3 = RANDOM_GENERATOR.nextInt(MAX_QUANTITY);
        FlowerPack pack_3 = new FlowerPack(rose, quantity_3);

        double price_4 = RANDOM_GENERATOR.nextDouble(MAX_PRICE);
        Chamomile chamomile_2 = new Chamomile();
        chamomile_2.setPrice(price_4);
        int quantity_4 = RANDOM_GENERATOR.nextInt(MAX_QUANTITY);
        FlowerPack pack_4 = new FlowerPack(chamomile_2, quantity_4);

        flowerBucket.add(pack_1);
        flowerBucket.add(pack_2);
        flowerBucket.add(pack_3);
        flowerBucket.add(pack_4);


        ArrayList<FlowerPack> output = new ArrayList<>();
        output.add(pack_1);
        Object[] expOut = output.toArray();
        Optional<FlowerType> flower = Optional.of(FlowerType.CHAMOMILE);
        Optional<Integer> quantity = Optional.empty();
        Optional<Double> price = Optional.of(price_1*quantity_1);

        ArrayList<FlowerPack> real = flowerBucket.search(flower, quantity, price);
        Object[] actOut = real.toArray();

        assertArrayEquals(expOut, actOut);
    }

    @Test
    public void testSearchBy1() {
        double price_1 = RANDOM_GENERATOR.nextDouble(MAX_PRICE);
        Chamomile chamomile = new Chamomile();
        chamomile.setPrice(price_1);
        int quantity_1 = RANDOM_GENERATOR.nextInt(MAX_QUANTITY);
        FlowerPack pack_1 = new FlowerPack(chamomile, quantity_1);

        double price_2 = RANDOM_GENERATOR.nextDouble(MAX_PRICE);
        Tulip tulip = new Tulip();
        tulip.setPrice(price_2);
        int quantity_2 = RANDOM_GENERATOR.nextInt(MAX_QUANTITY);
        FlowerPack pack_2 = new FlowerPack(tulip, quantity_2);

        double price_3 = RANDOM_GENERATOR.nextDouble(MAX_PRICE);
        Rose rose = new Rose();
        rose.setPrice(price_3);
        int quantity_3 = RANDOM_GENERATOR.nextInt(MAX_QUANTITY);
        FlowerPack pack_3 = new FlowerPack(rose, quantity_3);

        double price_4 = RANDOM_GENERATOR.nextDouble(MAX_PRICE);
        Chamomile chamomile_2 = new Chamomile();
        chamomile_2.setPrice(price_4);
        int quantity_4 = RANDOM_GENERATOR.nextInt(MAX_QUANTITY);
        FlowerPack pack_4 = new FlowerPack(chamomile_2, quantity_4);

        flowerBucket.add(pack_1);
        flowerBucket.add(pack_2);
        flowerBucket.add(pack_3);
        flowerBucket.add(pack_4);


        ArrayList<FlowerPack> output = new ArrayList<>();
        output.add(pack_1);
        output.add(pack_4);
        Object[] expOut = output.toArray();
        Optional<FlowerType> flower = Optional.of(FlowerType.CHAMOMILE);
        Optional<Integer> quantity = Optional.empty();
        Optional<Double> price = Optional.empty();

        ArrayList<FlowerPack> real = flowerBucket.search(flower, quantity, price);
        Object[] actOut = real.toArray();

        assertArrayEquals(expOut, actOut);
    }
}
