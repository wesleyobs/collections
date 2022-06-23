package br.com.collections.list;

import java.util.Arrays;
import java.util.List;
import java.util.Random;
import java.util.UUID;

public class CollectionExperiment {
    private final List<String> list;

    public CollectionExperiment(final List list) {
        this.list = list;
    }

    public void toList(final String[] stringArray) {
        Arrays.stream(stringArray).forEach(string -> this.list.add(string));
    }

    public void addElementsAtGeneratedAndDeterminedRandomPosition(int numberElementsToBeAddedRandomly) {
        final Random random = new Random();
        while (numberElementsToBeAddedRandomly >= 1) {
            int position = random.nextInt(this.list.size() - 1);
            this.list.add(position, UUID.randomUUID().toString());
            numberElementsToBeAddedRandomly--;
        }
    }

    public void removeElementsFromListRandomly(int numberElementsToBeRemovedFromList) {
        final Random random = new Random();
        while (numberElementsToBeRemovedFromList >= 1) {
            int position = random.nextInt(this.list.size() - 1);
            this.list.remove(position);
            numberElementsToBeRemovedFromList--;
        }
    }

    public void getElementsByRandomIndex(int numberElementsToBeFound) {
        final Random random = new Random();
        while (numberElementsToBeFound >= 1) {
            int position = random.nextInt(this.list.size() - 1);
            this.list.get(position);
            numberElementsToBeFound--;
        }
    }

    public final List getList() {
        return this.list;
    }
}
