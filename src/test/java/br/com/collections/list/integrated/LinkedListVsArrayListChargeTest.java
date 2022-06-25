package br.com.collections.list.integrated;

import br.com.collections.list.CollectionExperiment;
import org.apache.log4j.LogManager;
import org.apache.log4j.Logger;
import org.junit.jupiter.api.*;

import java.util.ArrayList;
import java.util.LinkedList;

import static org.junit.jupiter.api.Assertions.assertEquals;

@TestMethodOrder(value = MethodOrderer.OrderAnnotation.class)
public class LinkedListVsArrayListChargeTest {

    private static final Logger logger = LogManager.getLogger(LinkedListVsArrayListChargeTest.class);
    private static final int INITIAL_NUMBER_ELEMENTS_TO_BE_ADDED_AT_LIST = 10000000;
    private static int NUMBER_EXECUTIONS_OF_METHOD_ADD = 100;
    private static int NUMBER_EXECUTIONS_OF_METHOD_ADD_USING_RANDOM_INDEX = 100;
    private static int NUMBER_EXECUTIONS_OF_METHOD_REMOVE = 100;
    private static int NUMBER_EXECUTIONS_OF_METHOD_GET = 100;
    private final CollectionExperiment arrayListInstance;
    private final CollectionExperiment linkedListInstance;
    private static final ResultTimeExecution.BuilderResultTimeExecution builderResultTimeExecution;

    static {
        builderResultTimeExecution = new ResultTimeExecution.BuilderResultTimeExecution()
                .setInitialNumberElementsToBeAddedAtList(INITIAL_NUMBER_ELEMENTS_TO_BE_ADDED_AT_LIST)
                .setNumberExecutionsOfMethodAdd(NUMBER_EXECUTIONS_OF_METHOD_ADD)
                .setNumberExecutionsOfMethodAddUsingRandomIndex(NUMBER_EXECUTIONS_OF_METHOD_ADD_USING_RANDOM_INDEX)
                .setNumberExecutionsOfMethodRemove(NUMBER_EXECUTIONS_OF_METHOD_REMOVE)
                .setNumberExecutionsOfMethodGet(NUMBER_EXECUTIONS_OF_METHOD_GET);
    }

    public LinkedListVsArrayListChargeTest() {
        this.arrayListInstance = new CollectionExperiment(new ArrayList(), INITIAL_NUMBER_ELEMENTS_TO_BE_ADDED_AT_LIST);
        this.linkedListInstance = new CollectionExperiment(new LinkedList(), INITIAL_NUMBER_ELEMENTS_TO_BE_ADDED_AT_LIST);
    }

    @BeforeEach
    public void reEstablishListSize() {
        this.arrayListInstance.backToInitialListSize();
        this.linkedListInstance.backToInitialListSize();
    }

    @Test
    @Order(1)
    public void testAddArrayList() {
        var beginArrayListTime = System.nanoTime();

        this.arrayListInstance.add(NUMBER_EXECUTIONS_OF_METHOD_ADD);

        long result = System.nanoTime() - beginArrayListTime;

        assertEquals(INITIAL_NUMBER_ELEMENTS_TO_BE_ADDED_AT_LIST + NUMBER_EXECUTIONS_OF_METHOD_ADD, this.arrayListInstance.getList().size());

        final UnityTime unityTime = UnityTime.getUnityInstance(result);
        builderResultTimeExecution.withAddArrayListResultTime(unityTime);
        this.logInfo("Time to add in arrayList %s%s", unityTime.getResultTime(), unityTime.getUnity());
    }

    @Test
    @Order(2)
    public void testAddLinkedList() {
        var beginLInkedListTime = System.nanoTime();

        this.linkedListInstance.add(NUMBER_EXECUTIONS_OF_METHOD_ADD);

        long result = System.nanoTime() - beginLInkedListTime;

        assertEquals(INITIAL_NUMBER_ELEMENTS_TO_BE_ADDED_AT_LIST + NUMBER_EXECUTIONS_OF_METHOD_ADD, this.linkedListInstance.getList().size());

        final UnityTime unityTime = UnityTime.getUnityInstance(result);
        builderResultTimeExecution.withAddLinkedListResultTime(unityTime);
        this.logInfo("Time to add in linkedList %s%s", unityTime.getResultTime(), unityTime.getUnity());
    }

    @Test
    @Order(3)
    public void testAddRandomPositionArrayListTest() {

        var beginArrayListTime = System.nanoTime();

        this.arrayListInstance.addElementsAtGeneratedAndDeterminedRandomPosition(NUMBER_EXECUTIONS_OF_METHOD_ADD_USING_RANDOM_INDEX);

        long result = System.nanoTime() - beginArrayListTime;

        assertEquals(INITIAL_NUMBER_ELEMENTS_TO_BE_ADDED_AT_LIST + NUMBER_EXECUTIONS_OF_METHOD_ADD_USING_RANDOM_INDEX, this.arrayListInstance.getList().size());

        final UnityTime unityTime = UnityTime.getUnityInstance(result);
        builderResultTimeExecution.withAddArrayListInRandomPositionResultTime(unityTime);
        this.logInfo("Time to add elements at generated and determined random position using ArrayList %s%s", unityTime.getResultTime(), unityTime.getUnity());
    }

    @Test
    @Order(4)
    public void testAddRandomPositionLinkedListTest() {
        var beginLinkedListTime = System.nanoTime();
        linkedListInstance.addElementsAtGeneratedAndDeterminedRandomPosition(NUMBER_EXECUTIONS_OF_METHOD_ADD_USING_RANDOM_INDEX);

        long result = System.nanoTime() - beginLinkedListTime;

        assertEquals(INITIAL_NUMBER_ELEMENTS_TO_BE_ADDED_AT_LIST + NUMBER_EXECUTIONS_OF_METHOD_ADD_USING_RANDOM_INDEX, this.linkedListInstance.getList().size());

        final UnityTime unityTime = UnityTime.getUnityInstance(result);
        builderResultTimeExecution.withAddLinkedListInRandomPositionResultTime(unityTime);
        this.logInfo("Time to add elements at generated and determined random position using LinkedList %s%s", unityTime.getResultTime(), unityTime.getUnity());
    }

    @Test
    @Order(5)
    public void testRemoveRandomlyArrayList() {
        var beginArrayListTime = System.nanoTime();
        arrayListInstance.removeElementsFromListRandomly(NUMBER_EXECUTIONS_OF_METHOD_REMOVE);

        long result = System.nanoTime() - beginArrayListTime;

        assertEquals(INITIAL_NUMBER_ELEMENTS_TO_BE_ADDED_AT_LIST - NUMBER_EXECUTIONS_OF_METHOD_REMOVE, this.arrayListInstance.getList().size());

        final UnityTime unityTime = UnityTime.getUnityInstance(result);
        builderResultTimeExecution.withRemoveElementsFromListRandomlyArrayListTime(unityTime);
        this.logInfo("Time remove elements from ArrayList randomly %s%s", unityTime.getResultTime(), unityTime.getUnity());
    }

    @Test
    @Order(6)
    public void testRemoveRandomlyLinkedList() {
        var beginLinkedListTime = System.nanoTime();
        linkedListInstance.removeElementsFromListRandomly(NUMBER_EXECUTIONS_OF_METHOD_REMOVE);

        long result = System.nanoTime() - beginLinkedListTime;

        assertEquals(INITIAL_NUMBER_ELEMENTS_TO_BE_ADDED_AT_LIST - NUMBER_EXECUTIONS_OF_METHOD_REMOVE, this.linkedListInstance.getList().size());

        final UnityTime unityTime = UnityTime.getUnityInstance(result);
        builderResultTimeExecution.withRemoveElementsFromListRandomlyLinkedListList(unityTime);
        this.logInfo("Time remove elements from LinkedList randomly %s%s", unityTime.getResultTime(), unityTime.getUnity());
    }

    @Test
    @Order(7)
    public void testGetArrayList() {
        var beginArrayListTime = System.nanoTime();
        arrayListInstance.getElementsByRandomIndex(NUMBER_EXECUTIONS_OF_METHOD_GET);

        long result = System.nanoTime() - beginArrayListTime;

        assertEquals(INITIAL_NUMBER_ELEMENTS_TO_BE_ADDED_AT_LIST, arrayListInstance.getList().size());

        final UnityTime unityTime = UnityTime.getUnityInstance(result);
        builderResultTimeExecution.withGetElementsByRandomIndexArrayListTime(unityTime);
        this.logInfo("Time execute get on ArrayList randomly %s%s", unityTime.getResultTime(), unityTime.getUnity());
    }

    @Test
    @Order(8)
    public void testGetLinkedListList() {
        var beginLinkedListTime = System.nanoTime();
        linkedListInstance.getElementsByRandomIndex(NUMBER_EXECUTIONS_OF_METHOD_GET);

        long result = System.nanoTime() - beginLinkedListTime;

        assertEquals(INITIAL_NUMBER_ELEMENTS_TO_BE_ADDED_AT_LIST, this.linkedListInstance.getList().size());

        final UnityTime unityTime = UnityTime.getUnityInstance(result);
        builderResultTimeExecution.withGetElementsByRandomIndexLinkedListListTime(unityTime);
        this.logInfo("Time execute get on LinkedList randomly %s%s", unityTime.getResultTime(), unityTime.getUnity());
    }

    @AfterAll
    private static void result() {
        final ResultTimeExecution resultTimeExecution = builderResultTimeExecution.build();
        resultTimeExecution.printResults();
    }

    private void logInfo(final String message, final Object... params) {
        logger.info(String.format(message, params));
    }
}
