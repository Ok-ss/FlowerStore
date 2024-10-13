package flower.store;

import org.junit.jupiter.api.BeforeEach;
import org.junit.jupiter.api.Test;

import java.util.ArrayList;
import java.util.Optional;

import static org.junit.jupiter.api.Assertions.*;

public class StoreTest {
    private Store store;
    private Flower rose;
    private Flower tulip;
    private FlowerPack rosePack;
    private FlowerPack tulipPack;
    private FlowerBucket bucket1;
    private FlowerBucket bucket2;

    @BeforeEach
    public void setUp() {
        store = new Store();
        rose = new Rose();
        tulip = new Tulip();

        rosePack = new FlowerPack(rose, 10);
        tulipPack = new FlowerPack(tulip, 20);

        bucket1 = new FlowerBucket();
        bucket1.add(rosePack);

        bucket2 = new FlowerBucket();
        bucket2.add(tulipPack);

        store.addBucket(bucket1);
        store.addBucket(bucket2);
    }

    @Test
    public void testAddBucket() {
        assertEquals(2, store.searchBucket(Optional.empty(), Optional.empty(), Optional.empty()).size());
    }

    @Test
    public void testSearchPackByFlowerType() {
        ArrayList<FlowerPack> result = store.searchPack(Optional.of(FlowerType.ROSE), Optional.empty(), Optional.empty());
        assertEquals(1, result.size());
        assertEquals(rosePack, result.get(0));
    }

    @Test
    public void testSearchPackByQuantity() {
        ArrayList<FlowerPack> result = store.searchPack(Optional.empty(), Optional.of(10), Optional.empty());
        assertEquals(1, result.size());
        assertEquals(rosePack, result.get(0));
    }

    @Test
    public void testSearchPackByPrice() {
        ArrayList<FlowerPack> result = store.searchPack(Optional.empty(), Optional.empty(), Optional.of(rosePack.getPrice()));
        assertEquals(1, result.size());
        assertEquals(rosePack, result.get(0));
    }

    @Test
    public void testSearchBucketByFlowerTypes() {
        ArrayList<FlowerType> flowerTypes = new ArrayList<>();
        flowerTypes.add(FlowerType.ROSE);

        ArrayList<FlowerBucket> result = store.searchBucket(Optional.of(flowerTypes), Optional.empty(), Optional.empty());
        assertEquals(1, result.size());
        assertEquals(bucket1, result.get(0));
    }

    @Test
    public void testSearchBucketByNumberOfPacks() {
        ArrayList<FlowerBucket> result = store.searchBucket(Optional.empty(), Optional.of(1), Optional.empty());
        assertEquals(2, result.size());
    }

    @Test
    public void testSearchBucketByPrice() {
        ArrayList<FlowerBucket> result = store.searchBucket(Optional.empty(), Optional.empty(), Optional.of(bucket1.getPrice()));
        assertEquals(1, result.size());
        assertEquals(bucket1, result.get(0));
    }

    @Test
public void testSearchPackByFlowerTypeAndQuantity() {
    ArrayList<FlowerPack> result = store.searchPack(
        Optional.of(FlowerType.ROSE), 
        Optional.of(10), 
        Optional.empty()
    );
    assertEquals(1, result.size());
    assertEquals(rosePack, result.get(0));
}

@Test
public void testSearchPackByFlowerTypeAndPrice() {
    ArrayList<FlowerPack> result = store.searchPack(
        Optional.of(FlowerType.TULIP), 
        Optional.empty(), 
        Optional.of(tulipPack.getPrice())
    );
    assertEquals(1, result.size());
    assertEquals(tulipPack, result.get(0));
}

@Test
public void testSearchPackByAllCriteria() {
    ArrayList<FlowerPack> result = store.searchPack(
        Optional.of(FlowerType.ROSE), 
        Optional.of(10), 
        Optional.of(rosePack.getPrice())
    );
    assertEquals(1, result.size());
    assertEquals(rosePack, result.get(0));
}

@Test
public void testSearchBucketByFlowerTypesAndNumOfPacks() {
    ArrayList<FlowerType> flowerTypes = new ArrayList<>();
    flowerTypes.add(FlowerType.ROSE);

    ArrayList<FlowerBucket> result = store.searchBucket(
        Optional.of(flowerTypes), 
        Optional.of(1), 
        Optional.empty()
    );
    assertEquals(1, result.size());
    assertEquals(bucket1, result.get(0));
}

@Test
public void testSearchBucketByFlowerTypesAndPrice() {
    ArrayList<FlowerType> flowerTypes = new ArrayList<>();
    flowerTypes.add(FlowerType.TULIP);

    ArrayList<FlowerBucket> result = store.searchBucket(
        Optional.of(flowerTypes), 
        Optional.empty(), 
        Optional.of(bucket2.getPrice())
    );
    assertEquals(1, result.size());
    assertEquals(bucket2, result.get(0));
}

@Test
public void testSearchBucketByAllCriteria() {
    ArrayList<FlowerType> flowerTypes = new ArrayList<>();
    flowerTypes.add(FlowerType.ROSE);

    ArrayList<FlowerBucket> result = store.searchBucket(
        Optional.of(flowerTypes), 
        Optional.of(1), 
        Optional.of(bucket1.getPrice())
    );
    assertEquals(1, result.size());
    assertEquals(bucket1, result.get(0));
}


}
