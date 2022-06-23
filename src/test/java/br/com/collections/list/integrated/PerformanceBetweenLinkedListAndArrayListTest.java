package br.com.collections.list.integrated;

import br.com.collections.list.CollectionExperiment;
import org.apache.log4j.LogManager;
import org.apache.log4j.Logger;
import org.junit.jupiter.api.*;

import java.util.*;

import static org.junit.jupiter.api.Assertions.assertEquals;

@TestMethodOrder(value = MethodOrderer.OrderAnnotation.class)
@TestInstance(TestInstance.Lifecycle.PER_CLASS)
public class PerformanceBetweenLinkedListAndArrayListTest {

    private static final Logger logger = LogManager.getLogger(PerformanceBetweenLinkedListAndArrayListTest.class);
    private static final int ARRAY_SIZE = 10000000;
    private static int NUMBER_ELEMENTS_TO_BE_ADDED_RAMDONLY = 50000;
    private static int NUMBER_ELEMENTS_TO_BE_REMOVED_FROM_LIST = 50000;
    private static int NUMBER_ELEMENTS_TO_BE_FOUND = 50000;
    private final String[] stringArray;
    private final ResultTimeExecution.BuilderResultTimeExecution builderResultTimeExecution;

    public PerformanceBetweenLinkedListAndArrayListTest() {
        this.stringArray = new String[ARRAY_SIZE];
        this.builderResultTimeExecution = new ResultTimeExecution.BuilderResultTimeExecution("ms",
                ARRAY_SIZE,
                NUMBER_ELEMENTS_TO_BE_ADDED_RAMDONLY,
                NUMBER_ELEMENTS_TO_BE_REMOVED_FROM_LIST,
                NUMBER_ELEMENTS_TO_BE_FOUND);
    }

    @BeforeAll
    public void init() {
        for (int i = 0; i < stringArray.length; i++) {
            this.stringArray[i] = UUID.randomUUID().toString();
        }
    }

    @Test
    @Order(1)
    public void testAddSequentiallyArrayList() {
        var beginArrayListTime = System.currentTimeMillis();

        final CollectionExperiment arrayListInstance = new CollectionExperiment(new ArrayList());
        arrayListInstance.toList(this.stringArray);

        long result = System.currentTimeMillis() - beginArrayListTime;

        this.logInfo("Time to add in arrayList %sms", result);

        assertEquals(this.stringArray.length, arrayListInstance.getList().size());

        this.builderResultTimeExecution.withAddArrayListResultTime(result);
    }

    @Test
    @Order(2)
    public void testAddSequentiallyLinkedList() {
        var beginLInkedListTime = System.currentTimeMillis();

        final CollectionExperiment linkedListInstance = new CollectionExperiment(new LinkedList());
        linkedListInstance.toList(this.stringArray);

        long result = System.currentTimeMillis() - beginLInkedListTime;

        this.logInfo("Time to add in linkedList %sms", result);

        assertEquals(this.stringArray.length, linkedListInstance.getList().size());

        this.builderResultTimeExecution.withAddLinkedListResultTime(result);
    }

    @Test
    @Order(3)
    public void testAddArrayListInRandomPositionTest() {
        final CollectionExperiment arrayListExperiment = new CollectionExperiment(new ArrayList());
        arrayListExperiment.toList(this.stringArray);

        var beginArrayListTime = System.currentTimeMillis();
        arrayListExperiment.addElementsAtGeneratedAndDeterminedRandomPosition(NUMBER_ELEMENTS_TO_BE_ADDED_RAMDONLY);

        long result = System.currentTimeMillis() - beginArrayListTime;

        this.logInfo("Time to add elements at generated and determined random position using ArrayList %sms", result);

        assertEquals(this.stringArray.length + NUMBER_ELEMENTS_TO_BE_ADDED_RAMDONLY, arrayListExperiment.getList().size());

        this.builderResultTimeExecution.withAddArrayListInRandomPositionResultTime(result);
    }

    @Test
    @Order(4)
    public void testAddInRamdomPositionLinkedListTest() {
        final CollectionExperiment linkedListExperiment = new CollectionExperiment(new LinkedList());
        linkedListExperiment.toList(this.stringArray);

        var beginLinkedListTime = System.currentTimeMillis();
        linkedListExperiment.addElementsAtGeneratedAndDeterminedRandomPosition(NUMBER_ELEMENTS_TO_BE_ADDED_RAMDONLY);

        long result = System.currentTimeMillis() - beginLinkedListTime;

        this.logInfo("Time to add elements at generated and determined random position using LinkedList %sms", result);

        assertEquals(this.stringArray.length + NUMBER_ELEMENTS_TO_BE_ADDED_RAMDONLY, linkedListExperiment.getList().size());

        this.builderResultTimeExecution.withAddLinkedListInRandomPositionResultTime(result);
    }

    @Test
    @Order(5)
    public void testRemoveElementsFromListRandomlyArrayList() {
        final CollectionExperiment arrayListExperiment = new CollectionExperiment(new ArrayList());
        arrayListExperiment.toList(this.stringArray);

        var beginArrayListTime = System.currentTimeMillis();
        arrayListExperiment.removeElementsFromListRandomly(NUMBER_ELEMENTS_TO_BE_REMOVED_FROM_LIST);

        long result = System.currentTimeMillis() - beginArrayListTime;

        this.logInfo("Time remove elements from ArrayList randomly %sms", result);

        assertEquals(this.stringArray.length - NUMBER_ELEMENTS_TO_BE_REMOVED_FROM_LIST, arrayListExperiment.getList().size());

        this.builderResultTimeExecution.withRemoveElementsFromListRandomlyArrayListTime(result);
    }

    @Test
    @Order(6)
    public void testRemoveElementsFromListRandomlyLinkedListList() {
        final CollectionExperiment linkedListExperiment = new CollectionExperiment(new LinkedList());
        linkedListExperiment.toList(this.stringArray);

        var beginLinkedListTime = System.currentTimeMillis();
        linkedListExperiment.removeElementsFromListRandomly(NUMBER_ELEMENTS_TO_BE_REMOVED_FROM_LIST);

        long result = System.currentTimeMillis() - beginLinkedListTime;

        this.logInfo("Time remove elements from LinkedList randomly %sms", result);

        assertEquals(this.stringArray.length - NUMBER_ELEMENTS_TO_BE_REMOVED_FROM_LIST, linkedListExperiment.getList().size());

        this.builderResultTimeExecution.withRemoveElementsFromListRandomlyLinkedListList(result);
    }

    @Test
    @Order(7)
    public void testGetElementsByRandomIndexArrayList() {
        final CollectionExperiment arrayListExperiment = new CollectionExperiment(new ArrayList());
        arrayListExperiment.toList(this.stringArray);

        var beginArrayListTime = System.currentTimeMillis();
        arrayListExperiment.getElementsByRandomIndex(NUMBER_ELEMENTS_TO_BE_FOUND);

        long result = System.currentTimeMillis() - beginArrayListTime;

        this.logInfo("Time execute get on ArrayList randomly %sms", result);

        assertEquals(this.stringArray.length, arrayListExperiment.getList().size());

        this.builderResultTimeExecution.withGetElementsByRandomIndexArrayListTime(result);
    }

    @Test
    @Order(8)
    public void testGetElementsByRandomIndexLinkedListList() {
        final CollectionExperiment linkedListExperiment = new CollectionExperiment(new LinkedList());
        linkedListExperiment.toList(this.stringArray);

        var beginLinkedListTime = System.currentTimeMillis();
        linkedListExperiment.getElementsByRandomIndex(NUMBER_ELEMENTS_TO_BE_FOUND);

        long result = System.currentTimeMillis() - beginLinkedListTime;

        this.logInfo("Time execute get on LinkedList randomly %sms", result);

        assertEquals(this.stringArray.length, linkedListExperiment.getList().size());

        this.builderResultTimeExecution.withGetElementsByRandomIndexLinkedListListTime(result);
    }

    @AfterAll
    private void result() {
        final ResultTimeExecution resultTimeExecution = this.builderResultTimeExecution.build();
        resultTimeExecution.printResults();

    }

    private void logInfo(final String message, final Object... params) {
        logger.info(String.format(message, params));
    }
}
