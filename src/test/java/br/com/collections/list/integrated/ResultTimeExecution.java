package br.com.collections.list.integrated;

import org.apache.log4j.LogManager;
import org.apache.log4j.Logger;

public class ResultTimeExecution {
    private static final Logger logger = LogManager.getLogger(ResultTimeExecution.class);
    private long addArrayListResultTime;
    private long addLinkedListResultTime;
    private long addArrayListInRandomPositionResultTime;
    private long addLinkedListInRandomPositionResultTime;
    private long removeElementsFromListRandomlyArrayListTime;
    private long removeElementsFromListRandomlyLinkedListListTime;
    private long getElementsByRandomIndexArrayListTime;
    private long getElementsByRandomIndexLinkedListListTime;
    private String timeUnity;
    private final int defaultSizeList;
    private int numberElementsToBeAddedRamdonly;
    private int numberElementsToBeRemovedFromList;
    private int numberElementsToBeFound;

    private ResultTimeExecution(final long addArrayListResultTime,
                                final long addLinkedListResultTime,
                                final long addArrayListInRandomPositionResultTime,
                                final long addLinkedListInRandomPositionResultTime,
                                final long removeElementsFromListRandomlyArrayListTime,
                                final long removeElementsFromListRandomlyLinkedListListTime,
                                final long getElementsByRandomIndexArrayListTime,
                                final long getElementsByRandomIndexLinkedListListTime,
                                final String timeUnity,
                                final int defaultSizeList,
                                final int numberElementsToBeAddedRamdonly,
                                final int numberElementsToBeRemovedFromList,
                                final int numberElementsToBeFound) {
        this.addArrayListResultTime = addArrayListResultTime;
        this.addLinkedListResultTime = addLinkedListResultTime;
        this.addArrayListInRandomPositionResultTime = addArrayListInRandomPositionResultTime;
        this.addLinkedListInRandomPositionResultTime = addLinkedListInRandomPositionResultTime;
        this.removeElementsFromListRandomlyArrayListTime = removeElementsFromListRandomlyArrayListTime;
        this.removeElementsFromListRandomlyLinkedListListTime = removeElementsFromListRandomlyLinkedListListTime;
        this.getElementsByRandomIndexArrayListTime = getElementsByRandomIndexArrayListTime;
        this.getElementsByRandomIndexLinkedListListTime = getElementsByRandomIndexLinkedListListTime;
        this.timeUnity = timeUnity;
        this.defaultSizeList = defaultSizeList;
        this.numberElementsToBeAddedRamdonly = numberElementsToBeAddedRamdonly;
        this.numberElementsToBeRemovedFromList = numberElementsToBeRemovedFromList;
        this.numberElementsToBeFound = numberElementsToBeFound;
    }

    private boolean isAddArrayListFasterThanLinkedList() {
        return this.addArrayListResultTime < this.addLinkedListResultTime;
    }

    private boolean isAddArrayListTimeEqualsToLinkedList() {
        return this.addArrayListResultTime == this.addLinkedListResultTime;
    }

    private boolean isAddArrayListInRandomPositionFasterThanLinkedList() {
        return this.addArrayListInRandomPositionResultTime < this.addLinkedListInRandomPositionResultTime;
    }

    private boolean isAddArrayListTimeInRandomPositionEqualsToLinkedList() {
        return this.addArrayListInRandomPositionResultTime == this.addLinkedListInRandomPositionResultTime;
    }

    private boolean isRemoveFromArrayListFasterThanLinkedList() {
        return this.removeElementsFromListRandomlyArrayListTime < this.removeElementsFromListRandomlyLinkedListListTime;
    }

    private boolean isTimeToRemoveFromArrayListEqualsToLinkedList() {
        return this.removeElementsFromListRandomlyArrayListTime == this.removeElementsFromListRandomlyLinkedListListTime;
    }

    private boolean isGetFromArrayListFasterThanLinkedList() {
        return this.getElementsByRandomIndexArrayListTime < this.getElementsByRandomIndexLinkedListListTime;
    }

    private boolean isTimeToGetFromArrayListEqualsToLinkedList() {
        return this.getElementsByRandomIndexArrayListTime == this.getElementsByRandomIndexLinkedListListTime;
    }

    public void printResults() {
        this.executionInfo();
        this.resultsOfAddMethod();
        this.resultsOfAddMethodUsingRandomPosition();
        this.resultsOfRemoveMethod();
        this.resultsOfGetMethod();
    }

    private void executionInfo() {
        this.logInfo("Tamanho default da lista %s", this.defaultSizeList);
        this.logInfo("Total de elementos adicionados via add(index, value) %s", this.numberElementsToBeAddedRamdonly);
        this.logInfo("Total de elementos removidos da lista via remove(index) %s", this.numberElementsToBeRemovedFromList);
        this.logInfo("Total de vezes que o metodo get(index) foi executado em cada lista randomicamente %s", this.numberElementsToBeFound);
    }

    private void resultsOfAddMethod() {
        if (this.isAddArrayListFasterThanLinkedList()) {
            this.logInfo("ArrayList, method add(value) is faster than LinkedList in %s %s ",
                    this.differenceTime(this.addLinkedListResultTime, this.addArrayListResultTime),
                    this.timeUnity);

        } else if (this.isAddArrayListTimeEqualsToLinkedList()) {

            this.logInfo("ArrayList and LinkedList, method add(value) was executed in the same time %s %",
                    this.addArrayListResultTime,
                    this.timeUnity);
        } else {
            this.logInfo("LinkedList, method add(value) is faster than ArrayList in %s %s ",
                    this.differenceTime(this.addArrayListResultTime, this.addLinkedListResultTime),
                    this.timeUnity);
        }
    }

    private void resultsOfAddMethodUsingRandomPosition() {
        if (this.isAddArrayListInRandomPositionFasterThanLinkedList()) {
            this.logInfo("ArrayList, method add(index, value) using random position is faster than LinkedList in %s %s ",
                    this.differenceTime(this.addLinkedListInRandomPositionResultTime, this.addArrayListInRandomPositionResultTime),
                    this.timeUnity);

        } else if (this.isAddArrayListTimeInRandomPositionEqualsToLinkedList()) {
            this.logInfo("ArrayList and LinkedList, method add(index, value) using random position was executed in the same time %s %",
                    this.addArrayListInRandomPositionResultTime,
                    this.timeUnity);
        } else {
            this.logInfo("LinkedList, method add(index, value) using random position is faster than ArrayList %s %s ",
                    this.differenceTime(this.addArrayListInRandomPositionResultTime, this.addLinkedListInRandomPositionResultTime),
                    this.timeUnity);
        }
    }

    private void resultsOfRemoveMethod() {
        if (this.isRemoveFromArrayListFasterThanLinkedList()) {
            this.logInfo("ArrayList, method remove(index) is faster than LinkedList in %s %s ",
                    this.differenceTime(this.removeElementsFromListRandomlyLinkedListListTime, this.removeElementsFromListRandomlyArrayListTime),
                    this.timeUnity);

        } else if (this.isTimeToRemoveFromArrayListEqualsToLinkedList()) {
            this.logInfo("ArrayList and LinkedList, method remove(index) were executed in the same time %s %",
                    this.removeElementsFromListRandomlyArrayListTime,
                    this.timeUnity);
        } else {
            this.logInfo("LinkedList, method remove(index) is faster than ArrayList %s %s ",
                    this.differenceTime(this.removeElementsFromListRandomlyArrayListTime, this.removeElementsFromListRandomlyLinkedListListTime),
                    this.timeUnity);
        }
    }

    private void resultsOfGetMethod() {
        if (this.isGetFromArrayListFasterThanLinkedList()) {
            this.logInfo("ArrayList, method get(index) is faster than LinkedList in %s %s ",
                    this.differenceTime(this.getElementsByRandomIndexLinkedListListTime, this.getElementsByRandomIndexArrayListTime),
                    this.timeUnity);

        } else if (this.isTimeToGetFromArrayListEqualsToLinkedList()) {
            this.logInfo("ArrayList and LinkedList, method get(index) were executed in the same time %s %",
                    this.getElementsByRandomIndexArrayListTime,
                    this.timeUnity);
        } else {
            this.logInfo("LinkedList, method get(index) is faster than ArrayList %s %s ",
                    this.differenceTime(this.getElementsByRandomIndexArrayListTime, this.getElementsByRandomIndexLinkedListListTime),
                    this.timeUnity);
        }
    }

    private long differenceTime(final long longerTime, final long shorterTime) {
        return longerTime - shorterTime;
    }

    private void logInfo(final String values, final Object... params) {
        logger.info(String.format(values, params));
    }

    static class BuilderResultTimeExecution {
        private long addArrayListResultTime;
        private long addLinkedListResultTime;
        private long addArrayListInRandomPositionResultTime;
        private long addLinkedListInRandomPositionResultTime;
        private long removeElementsFromListRandomlyArrayListTime;
        private long removeElementsFromListRandomlyLinkedListListTime;
        private long getElementsByRandomIndexArrayListTime;
        private long getElementsByRandomIndexLinkedListListTime;
        private String timeUnity;
        private int defaultSizeList;
        private int numberElementsToBeAddedRamdonly;
        private int numberElementsToBeRemovedFromList;
        private int numberElementsToBeFound;

        public BuilderResultTimeExecution(final String timeUnity,
                                          final int defaultSizeList,
                                          final int numberElementsToBeAddedRamdonly,
                                          final int numberElementsToBeRemovedFromList,
                                          final int numberElementsToBeFound) {
            this.timeUnity = timeUnity;
            this.defaultSizeList = defaultSizeList;
            this.numberElementsToBeAddedRamdonly = numberElementsToBeAddedRamdonly;
            this.numberElementsToBeRemovedFromList = numberElementsToBeRemovedFromList;
            this.numberElementsToBeFound = numberElementsToBeFound;
        }

        public BuilderResultTimeExecution withAddArrayListResultTime(final long addArrayListResultTimee) {
            this.addArrayListResultTime = addArrayListResultTimee;
            return this;
        }

        public BuilderResultTimeExecution withAddLinkedListResultTime(final long addLinkedListResultTime) {
            this.addLinkedListResultTime = addLinkedListResultTime;
            return this;
        }

        public BuilderResultTimeExecution withAddArrayListInRandomPositionResultTime(final long addArrayListInRandomPositionResultTime) {
            this.addArrayListInRandomPositionResultTime = addArrayListInRandomPositionResultTime;
            return this;
        }

        public BuilderResultTimeExecution withAddLinkedListInRandomPositionResultTime(final long addLinkedListInRandomPositionResultTime) {
            this.addLinkedListInRandomPositionResultTime = addLinkedListInRandomPositionResultTime;
            return this;
        }

        public BuilderResultTimeExecution withRemoveElementsFromListRandomlyArrayListTime(final long removeElementsFromListRandomlyArrayListTime) {
            this.removeElementsFromListRandomlyArrayListTime = removeElementsFromListRandomlyArrayListTime;
            return this;
        }

        public BuilderResultTimeExecution withRemoveElementsFromListRandomlyLinkedListList(final long removeElementsFromListRandomlyLinkedListList) {
            this.removeElementsFromListRandomlyLinkedListListTime = removeElementsFromListRandomlyLinkedListList;
            return this;
        }

        public BuilderResultTimeExecution withGetElementsByRandomIndexArrayListTime(final long getElementsByRandomIndexArrayListTime) {
            this.getElementsByRandomIndexArrayListTime = getElementsByRandomIndexArrayListTime;
            return this;
        }

        public BuilderResultTimeExecution withGetElementsByRandomIndexLinkedListListTime(final long getElementsByRandomIndexLinkedListListTime) {
            this.getElementsByRandomIndexLinkedListListTime = getElementsByRandomIndexLinkedListListTime;
            return this;
        }


        public ResultTimeExecution build() {
            return new ResultTimeExecution(this.addArrayListResultTime,
                    this.addLinkedListResultTime,
                    this.addArrayListInRandomPositionResultTime,
                    this.addLinkedListInRandomPositionResultTime,
                    this.removeElementsFromListRandomlyArrayListTime,
                    this.removeElementsFromListRandomlyLinkedListListTime,
                    this.getElementsByRandomIndexArrayListTime,
                    this.getElementsByRandomIndexLinkedListListTime,
                    this.timeUnity,
                    this.defaultSizeList,
                    this.numberElementsToBeAddedRamdonly,
                    this.numberElementsToBeRemovedFromList,
                    this.numberElementsToBeFound
            );
        }
    }


}
