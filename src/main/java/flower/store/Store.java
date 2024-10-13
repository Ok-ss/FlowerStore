package flower.store;

import java.util.ArrayList;
import java.util.List;
import java.util.Optional;

public class Store {
    private List<FlowerBucket> buckets;
    private List<FlowerPack> packs;

    Store() {
        buckets = new ArrayList<>();
        packs = new ArrayList<>();
    }

    public void addBucket(FlowerBucket fB) {
        buckets.add(fB);
        packs.addAll(fB.packs);
    }

    public ArrayList<FlowerPack> searchPack(Optional<FlowerType> flower, 
                                        Optional<Integer> quantity, 
                                        Optional<Double> price) {
        ArrayList<FlowerPack> res = new ArrayList<>();
        for (int i = 0; i<packs.size(); i++) {
            boolean matches = true;
            FlowerPack pack = packs.get(i);
            if (flower.isPresent() && !flower.equals(Optional.of(pack.getFlower().getFlowerType()))){
                matches = false;
            }
            if (quantity.isPresent() && !quantity.equals(Optional.of(pack.getQuantity()))){
                matches = false;
            }
            if (price.isPresent() && !price.equals(Optional.of(pack.getPrice()))){
                matches = false;
            }
            if (matches) {
                res.add(pack);
            }
        }
        
        return res;
    }

    public ArrayList<FlowerBucket> searchBucket(Optional<ArrayList<FlowerType>> flowerTypes, 
                                        Optional<Integer> numOfPacks, 
                                        Optional<Double> price) {
        ArrayList<FlowerBucket> res = new ArrayList<>();
        for (int i = 0; i<buckets.size(); i++) {
            boolean matches = true;
            FlowerBucket bucket = buckets.get(i);
            if (flowerTypes.isPresent() && !flowerTypes.equals(Optional.of(bucket.types))){
                matches = false;
            }
            if (numOfPacks.isPresent() && !numOfPacks.equals(Optional.of(bucket.packs.size()))){
                matches = false;
            }
            if (price.isPresent() && !price.equals(Optional.of(bucket.getPrice()))){
                matches = false;
            }
            if (matches) {
                res.add(bucket);
            }
        }
        
        return res;
    }

    public static void main(String[] args) {
        Store s = new Store();
        ArrayList<FlowerType> lst = new ArrayList<>();
        lst.add(FlowerType.ROSE);
        Rose r = new Rose();
        FlowerPack p = new FlowerPack(r, 10);
        FlowerBucket b = new FlowerBucket();
        b.add(p);
        s.addBucket(b);
        s.searchBucket(Optional.of(lst), Optional.empty(), Optional.empty());
    }
}
