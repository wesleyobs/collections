package br.com.collections.list.integrated;

import org.apache.log4j.LogManager;
import org.apache.log4j.Logger;

public class ResultTimeExecution {
    private static final Logger logger = LogManager.getLogger(ResultTimeExecution.class);
    private final UnityTime addArrayListResultTime;
    private final UnityTime addLinkedListResultTime;
    private final UnityTime addArrayListInRandomPositionResultTime;
    private final UnityTime addLinkedListInRandomPositionResultTime;
    private final UnityTime removeElementsFromListRandomlyArrayListTime;
    private final UnityTime removeElementsFromListRandomlyLinkedListListTime;
    private final UnityTime getElementsByRandomIndexArrayListTime;
    private final UnityTime getElementsByRandomIndexLinkedListListTime;
    private final int initialNumberElementsToBeAddedAtList;
    private final int numberExecutionsOfMethodAdd;
    private final int numberExecutionsOfMethodAddUsingRandomIndex;
    private final int numberExecutionsOfMethodRemove;
    private final int numberExecutionsOfMethodGet;

    private ResultTimeExecution(final UnityTime addArrayListResultTime,
                                final UnityTime addLinkedListResultTime,
                                final UnityTime addArrayListInRandomPositionResultTime,
                                final UnityTime addLinkedListInRandomPositionResultTime,
                                final UnityTime removeElementsFromListRandomlyArrayListTime,
                                final UnityTime removeElementsFromListRandomlyLinkedListListTime,
                                final UnityTime getElementsByRandomIndexArrayListTime,
                                final UnityTime getElementsByRandomIndexLinkedListListTime,
                                final int numberExecutionsOfMethodAdd,
                                final int initialNumberElementsToBeAddedAtList,
                                final int numberExecutionsOfMethodAddUsingRandomIndex,
                                final int numberExecutionsOfMethodRemove,
                                final int numberExecutionsOfMethodGet) {
        this.addArrayListResultTime = addArrayListResultTime;
        this.addLinkedListResultTime = addLinkedListResultTime;
        this.addArrayListInRandomPositionResultTime = addArrayListInRandomPositionResultTime;
        this.addLinkedListInRandomPositionResultTime = addLinkedListInRandomPositionResultTime;
        this.removeElementsFromListRandomlyArrayListTime = removeElementsFromListRandomlyArrayListTime;
        this.removeElementsFromListRandomlyLinkedListListTime = removeElementsFromListRandomlyLinkedListListTime;
        this.getElementsByRandomIndexArrayListTime = getElementsByRandomIndexArrayListTime;
        this.getElementsByRandomIndexLinkedListListTime = getElementsByRandomIndexLinkedListListTime;
        this.initialNumberElementsToBeAddedAtList = initialNumberElementsToBeAddedAtList;
        this.numberExecutionsOfMethodAdd = numberExecutionsOfMethodAdd;
        this.numberExecutionsOfMethodAddUsingRandomIndex = numberExecutionsOfMethodAddUsingRandomIndex;
        this.numberExecutionsOfMethodRemove = numberExecutionsOfMethodRemove;
        this.numberExecutionsOfMethodGet = numberExecutionsOfMethodGet;
    }

    private boolean isAddArrayListFasterThanLinkedList() {
        return this.addArrayListResultTime.getTimeInNanoseconds() < this.addLinkedListResultTime.getTimeInNanoseconds();
    }

    private boolean isAddArrayListTimeEqualsToLinkedList() {
        return this.addArrayListResultTime.getTimeInNanoseconds() == this.addLinkedListResultTime.getTimeInNanoseconds();
    }

    private boolean isAddArrayListInRandomPositionFasterThanLinkedList() {
        return this.addArrayListInRandomPositionResultTime.getTimeInNanoseconds() < this.addLinkedListInRandomPositionResultTime.getTimeInNanoseconds();
    }

    private boolean isAddArrayListTimeInRandomPositionEqualsToLinkedList() {
        return this.addArrayListInRandomPositionResultTime.getTimeInNanoseconds() == this.addLinkedListInRandomPositionResultTime.getTimeInNanoseconds();
    }

    private boolean isRemoveFromArrayListFasterThanLinkedList() {
        return this.removeElementsFromListRandomlyArrayListTime.getTimeInNanoseconds() < this.removeElementsFromListRandomlyLinkedListListTime.getTimeInNanoseconds();
    }

    private boolean isTimeToRemoveFromArrayListEqualsToLinkedList() {
        return this.removeElementsFromListRandomlyArrayListTime.getTimeInNanoseconds() == this.removeElementsFromListRandomlyLinkedListListTime.getTimeInNanoseconds();
    }

    private boolean isGetFromArrayListFasterThanLinkedList() {
        return this.getElementsByRandomIndexArrayListTime.getTimeInNanoseconds() < this.getElementsByRandomIndexLinkedListListTime.getTimeInNanoseconds();
    }

    private boolean isTimeToGetFromArrayListEqualsToLinkedList() {
        return this.getElementsByRandomIndexArrayListTime.getTimeInNanoseconds() == this.getElementsByRandomIndexLinkedListListTime.getTimeInNanoseconds();
    }

    public void printResults() {
        this.executionInfo();
        this.resultsOfAddMethod();
        this.resultsOfAddMethodUsingRandomPosition();
        this.resultsOfRemoveMethod();
        this.resultsOfGetMethod();
    }

    private void executionInfo() {
        this.logInfo("Initial number of elements to be added at list %s", this.initialNumberElementsToBeAddedAtList);
        this.logInfo("Number of executions of the method add(value) at list %s", this.numberExecutionsOfMethodAdd);
        this.logInfo("Number of executions of the method add(index, value) %s", this.numberExecutionsOfMethodAddUsingRandomIndex);
        this.logInfo("Number of executions of the method remove(index) %s", this.numberExecutionsOfMethodRemove);
        this.logInfo("Number of executions of the method get(index) %s", this.numberExecutionsOfMethodGet);
    }

    private void resultsOfAddMethod() {
        if (this.isAddArrayListFasterThanLinkedList()) {
            final UnityTime unityTime = this.differenceTime(this.addLinkedListResultTime, this.addArrayListResultTime);
            this.logInfo("ArrayList, method add(value) is faster than LinkedList in %s%s ",
                    unityTime.getResultTime(),
                    unityTime.getUnity());

        } else if (this.isAddArrayListTimeEqualsToLinkedList()) {
            this.logInfo("ArrayList and LinkedList, method add(value) was executed in the same time %s%s",
                    this.addArrayListResultTime.getResultTime(),
                    this.addArrayListResultTime.getUnity());
        } else {
            final UnityTime unityTime = this.differenceTime(this.addArrayListResultTime, this.addLinkedListResultTime);
            this.logInfo("LinkedList, method add(value) is faster than ArrayList in %s%s ",
                    unityTime.getResultTime(),
                    unityTime.getUnity());
        }
    }

    private void resultsOfAddMethodUsingRandomPosition() {
        if (this.isAddArrayListInRandomPositionFasterThanLinkedList()) {
            final UnityTime unityTime = this.differenceTime(this.addLinkedListInRandomPositionResultTime, this.addArrayListInRandomPositionResultTime);
            this.logInfo("ArrayList, method add(index, value) using random position is faster than LinkedList in %s%s ",
                    unityTime.getResultTime(),
                    unityTime.getUnity());

        } else if (this.isAddArrayListTimeInRandomPositionEqualsToLinkedList()) {
            this.logInfo("ArrayList and LinkedList, method add(index, value) using random position was executed in the same time %s%s",
                    this.addArrayListInRandomPositionResultTime.getResultTime(),
                    this.addArrayListInRandomPositionResultTime.getUnity());
        } else {
            final UnityTime unityTime = this.differenceTime(this.addArrayListInRandomPositionResultTime, this.addLinkedListInRandomPositionResultTime);
            this.logInfo("LinkedList, method add(index, value) using random position is faster than ArrayList %s%s ",
                    unityTime.getResultTime(),
                    unityTime.getUnity());
        }
    }

    private void resultsOfRemoveMethod() {
        if (this.isRemoveFromArrayListFasterThanLinkedList()) {
            final UnityTime unityTime =  this.differenceTime(this.removeElementsFromListRandomlyLinkedListListTime, this.removeElementsFromListRandomlyArrayListTime);
            this.logInfo("ArrayList, method remove(index) is faster than LinkedList in %s%s ",
                    unityTime.getResultTime(),
                    unityTime.getUnity());

        } else if (this.isTimeToRemoveFromArrayListEqualsToLinkedList()) {
            this.logInfo("ArrayList and LinkedList, method remove(index) were executed in the same time %s%s",
                    this.removeElementsFromListRandomlyLinkedListListTime.getResultTime(),
                    this.removeElementsFromListRandomlyLinkedListListTime.getUnity());
        } else {
            final UnityTime unityTime = this.differenceTime(this.removeElementsFromListRandomlyArrayListTime, this.removeElementsFromListRandomlyLinkedListListTime);
            this.logInfo("LinkedList, method remove(index) is faster than ArrayList %s%s ",
                    unityTime.getResultTime(),
                    unityTime.getUnity());
        }
    }

    private void resultsOfGetMethod() {
        if (this.isGetFromArrayListFasterThanLinkedList()) {
            final UnityTime unityTime = this.differenceTime(this.getElementsByRandomIndexLinkedListListTime, this.getElementsByRandomIndexArrayListTime);
            this.logInfo("ArrayList, method get(index) is faster than LinkedList in %s%s ",
                    unityTime.getResultTime(),
                    unityTime.getUnity());

        } else if (this.isTimeToGetFromArrayListEqualsToLinkedList()) {
            this.logInfo("ArrayList and LinkedList, method get(index) were executed in the same time %s%s",
                    this.getElementsByRandomIndexArrayListTime.getResultTime(),
                    this.getElementsByRandomIndexArrayListTime.getUnity());
        } else {
            final UnityTime unityTime = this.differenceTime(this.getElementsByRandomIndexArrayListTime, this.getElementsByRandomIndexLinkedListListTime);
            this.logInfo("LinkedList, method get(index) is faster than ArrayList %s%s ",
                    unityTime.getResultTime(),
                    unityTime.getUnity());
        }
    }

    private UnityTime differenceTime(final UnityTime longerTime, final UnityTime shorterTime) {
        return UnityTime.getUnityInstance(longerTime.getTimeInNanoseconds() - shorterTime.getTimeInNanoseconds());
    }

    private void logInfo(final String values, final Object... params) {
        logger.info(String.format(values, params));
    }

    static class BuilderResultTimeExecution {
        private UnityTime addArrayListResultTime;
        private UnityTime addLinkedListResultTime;
        private UnityTime addArrayListInRandomPositionResultTime;
        private UnityTime addLinkedListInRandomPositionResultTime;
        private UnityTime removeElementsFromListRandomlyArrayListTime;
        private UnityTime removeElementsFromListRandomlyLinkedListListTime;
        private UnityTime getElementsByRandomIndexArrayListTime;
        private UnityTime getElementsByRandomIndexLinkedListListTime;
        private int initialNumberElementsToBeAddedAtList;
        private int numberExecutionsOfMethodAdd;
        private int numberExecutionsOfMethodAddUsingRandomIndex;
        private int numberExecutionsOfMethodRemove;
        private int numberExecutionsOfMethodGet;


        public BuilderResultTimeExecution withAddArrayListResultTime(final UnityTime addArrayListResultTimee) {
            this.addArrayListResultTime = addArrayListResultTimee;
            return this;
        }

        public BuilderResultTimeExecution withAddLinkedListResultTime(final UnityTime addLinkedListResultTime) {
            this.addLinkedListResultTime = addLinkedListResultTime;
            return this;
        }

        public BuilderResultTimeExecution withAddArrayListInRandomPositionResultTime(final UnityTime addArrayListInRandomPositionResultTime) {
            this.addArrayListInRandomPositionResultTime = addArrayListInRandomPositionResultTime;
            return this;
        }

        public BuilderResultTimeExecution withAddLinkedListInRandomPositionResultTime(final UnityTime addLinkedListInRandomPositionResultTime) {
            this.addLinkedListInRandomPositionResultTime = addLinkedListInRandomPositionResultTime;
            return this;
        }

        public BuilderResultTimeExecution withRemoveElementsFromListRandomlyArrayListTime(final UnityTime removeElementsFromListRandomlyArrayListTime) {
            this.removeElementsFromListRandomlyArrayListTime = removeElementsFromListRandomlyArrayListTime;
            return this;
        }

        public BuilderResultTimeExecution withRemoveElementsFromListRandomlyLinkedListList(final UnityTime removeElementsFromListRandomlyLinkedListList) {
            this.removeElementsFromListRandomlyLinkedListListTime = removeElementsFromListRandomlyLinkedListList;
            return this;
        }

        public BuilderResultTimeExecution withGetElementsByRandomIndexArrayListTime(final UnityTime getElementsByRandomIndexArrayListTime) {
            this.getElementsByRandomIndexArrayListTime = getElementsByRandomIndexArrayListTime;
            return this;
        }

        public BuilderResultTimeExecution withGetElementsByRandomIndexLinkedListListTime(final UnityTime getElementsByRandomIndexLinkedListListTime) {
            this.getElementsByRandomIndexLinkedListListTime = getElementsByRandomIndexLinkedListListTime;
            return this;
        }

        public BuilderResultTimeExecution setInitialNumberElementsToBeAddedAtList(final int initialNumberElementsToBeAddedAtList) {
            this.initialNumberElementsToBeAddedAtList = initialNumberElementsToBeAddedAtList;
            return this;
        }

        public BuilderResultTimeExecution setNumberExecutionsOfMethodAdd(final int numberExecutionsOfMethodAdd) {
            this.numberExecutionsOfMethodAdd = numberExecutionsOfMethodAdd;
            return this;
        }

        public BuilderResultTimeExecution setNumberExecutionsOfMethodAddUsingRandomIndex(final int numberExecutionsOfMethodAddUsingRandomIndex) {
            this.numberExecutionsOfMethodAddUsingRandomIndex = numberExecutionsOfMethodAddUsingRandomIndex;
            return this;
        }

        public BuilderResultTimeExecution setNumberExecutionsOfMethodRemove(final int numberExecutionsOfMethodRemove) {
            this.numberExecutionsOfMethodRemove = numberExecutionsOfMethodRemove;
            return this;
        }

        public BuilderResultTimeExecution setNumberExecutionsOfMethodGet(final int numberExecutionsOfMethodGet) {
            this.numberExecutionsOfMethodGet = numberExecutionsOfMethodGet;
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
                    this.initialNumberElementsToBeAddedAtList,
                    this.numberExecutionsOfMethodAdd,
                    this.numberExecutionsOfMethodAddUsingRandomIndex,
                    this.numberExecutionsOfMethodRemove,
                    this.numberExecutionsOfMethodGet
            );
        }
    }


}
