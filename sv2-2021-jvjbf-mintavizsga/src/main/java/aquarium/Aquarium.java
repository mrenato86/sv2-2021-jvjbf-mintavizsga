package aquarium;

import java.util.ArrayList;
import java.util.List;

public class Aquarium {

    public static final int CAPACITY = 20;
    private static final int WATER_NEED_PER_FISH = 5;

    private final List<Fish> fishList = new ArrayList<>();

    public void addFish(Fish fish) {
        //if (CAPACITY - fishList.size() * WATER_NEED_PER_FISH < WATER_NEED_PER_FISH) {
        if (CAPACITY / (fishList.size() + 1) < WATER_NEED_PER_FISH) {
            throw new IllegalStateException("Can not add fish because there is no more space.");
        }
        fishList.add(fish);
    }

    public void feed() {
        for (Fish fish : fishList) {
            fish.feed();
        }
    }

    public void removeFish(int maxWeight) {
        List<Fish> fishesToRemove = new ArrayList<>(fishList.size());
        for (Fish fish : fishList) {
            if (fish.getWeight() > maxWeight) {
                fishesToRemove.add(fish);
            }
        }
        fishList.removeAll(fishesToRemove);
    }

    public List<String> getStatus() {
        List<String> statusList = new ArrayList<>(fishList.size());
        for (Fish fish : fishList) {
            statusList.add(fish.getStatus());
        }
        return statusList;
    }

    public int getNumberOfFishWithMemoryLoss() {
        int numberOfFishWithMemoryLoss = 0;
        for (Fish fish : fishList) {
            if (fish.hasMemoryLoss()) {
                numberOfFishWithMemoryLoss++;
            }
        }
        return numberOfFishWithMemoryLoss;
    }

    public boolean isThereFishWithGivenColor(String color) {
        for (Fish fish : fishList) {
            if (fish.getColor().equalsIgnoreCase(color)) {
                return true;
            }
        }
        return false;
    }

    public Fish getSmallestFish() {
        if (fishList.isEmpty()) {
            throw new IllegalArgumentException("There is no fish in this aquarium!");
        }
        Fish minWeightFish = fishList.get(0);
        for (Fish fish : fishList) {
            if (fish.getWeight() < minWeightFish.getWeight()) {
                minWeightFish = fish;
            }
        }
        return minWeightFish;
    }

}
