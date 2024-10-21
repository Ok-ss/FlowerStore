package flower.store;
import java.util.ArrayList;
import java.util.Optional;


public class FlowerBucket {
    ArrayList<FlowerPack> packs;

    FlowerBucket(){
        this.packs = new ArrayList<>();
    }

    FlowerBucket(ArrayList<FlowerPack> packs) {
        this.packs = packs;
    }

    public double getPrice(){
        double price = 0;
        for (int i = 0; i<packs.size(); i++){
            price += packs.get(i).getPrice();
        }
        return price;
    }

    public void add(FlowerPack pack) {
        this.packs.add(pack);
    }

    public ArrayList<FlowerPack> search(Optional<FlowerType> flower, 
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
}
