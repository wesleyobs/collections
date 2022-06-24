package br.com.collections.list;

import java.util.List;
import java.util.Random;

public class CollectionExperiment {
    private final List<Integer> list;
    private final int initialNumberElementsToBeAddedAtList;
    private final Random random;

    public CollectionExperiment(final List list, int initialNumberElementsToBeAddedAtList) {
        this.initialNumberElementsToBeAddedAtList = initialNumberElementsToBeAddedAtList;
        this.list = list;
        this.random = new Random();
        this.add(initialNumberElementsToBeAddedAtList);
    }

    public void add(int iterationNumber) {
        while (iterationNumber >= 1) {
            this.list.add(this.random.nextInt());
            iterationNumber--;
        }
    }

    public void addElementsAtGeneratedAndDeterminedRandomPosition(int numberOfIteration) {
        while (numberOfIteration >= 1) {
            int positionAndValue = random.nextInt(this.list.size() - 1);
            this.list.add(positionAndValue, positionAndValue);
            numberOfIteration--;
        }
    }

    public void removeElementsFromListRandomly(int numberOfIteration) {
        while (numberOfIteration >= 1) {
            int position = this.random.nextInt(this.list.size() - 1);
            this.list.remove(position);
            numberOfIteration--;
        }
    }

    public void getElementsByRandomIndex(int numberOfIteration) {
        while (numberOfIteration >= 1) {
            int position = this.random.nextInt(this.list.size() - 1);
            this.list.get(position);
            numberOfIteration--;
        }
    }

    public void backToInitialListSize() {
        this.removeIfListIsLargerThanInitialSize();
        this.addIfListIsSmallerThanInitialSize();
    }


    private void removeIfListIsLargerThanInitialSize() {
        if (this.list.size() > this.initialNumberElementsToBeAddedAtList)
            this.removeElementsFromListRandomly(this.list.size() - this.initialNumberElementsToBeAddedAtList);
    }


    private void addIfListIsSmallerThanInitialSize() {
        if (this.list.size() < this.initialNumberElementsToBeAddedAtList)
            this.add(this.initialNumberElementsToBeAddedAtList - this.list.size());
    }

    public final List getList() {
        return this.list;
    }


}
