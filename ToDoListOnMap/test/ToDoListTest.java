import static org.junit.Assert.assertEquals;

import org.junit.Test;

/**
 * Tests all kernel, secondary, common and standard methods of ToDoList.
 */
public class ToDoListTest {

    //Kernel method tests-------------------------------------------------------

    /**
     * Test addTask.
     */
    @Test
    public void testAddTask() {
        ToDoList list = new ToDoList1();
        list.addTask("Do laundry", false);
        assertEquals(list.tasks(false), "Do laundry, ");
        assertEquals(list.size(), 1);
        assert !list.status("Do laundry");
    }

    /**
     * Test removeTask.
     */
    @Test
    public void testRemoveTask() {
        ToDoList list = new ToDoList1();
        list.addTask("Do laundry", false);
        list.addTask("Walk the dog", true);

        list.removeTask("Walk the dog");

        assertEquals(1, list.size());
        assert !list.hasTask("Walk the dog");
        assert list.hasTask("Do laundry");
    }

    /**
     * Test removeAny.
     */
    @Test
    public void testRemoveAny() {
        ToDoList list = new ToDoList1();
        list.addTask("Do laundry", false);
        list.addTask("Walk the dog", true);
        int initialSize = list.size();

        list.removeAny();

        assertEquals(list.size(), initialSize - 1);
    }

    /**
     * Test hasTask.
     */
    @Test
    public void testHasTask() {
        ToDoList list = new ToDoList1();
        list.addTask("Do laundry", false);
        list.addTask("Walk the dog", true);

        assert !list.hasTask("Go to the gym");
        assert list.hasTask("Do laundry");
    }

    /**
     * Test status.
     */
    @Test
    public void testStatus() {
        ToDoList list = new ToDoList1();
        list.addTask("Do laundry", false);

        assert !list.status("Do laundry");
    }

    /**
     * Test testSize.
     */
    @Test
    public void testSize() {
        ToDoList list = new ToDoList1();
        list.addTask("Do laundry", false);
        list.addTask("Walk the dog", true);

        assertEquals(2, list.size());
    }

    //Standard method tests-----------------------------------------------------

    /**
     * Test clear.
     */
    @Test
    public void testClear() {
        ToDoList list = new ToDoList1();
        list.addTask("Do laundry", false);
        list.addTask("Walk the dog", true);

        list.clear();

        assertEquals(0, list.size());
    }

    /**
     * Test newInstance.
     */
    @Test
    public void testNewInstance() {
        ToDoList list = new ToDoList1();
        ToDoList list2 = list.newInstance();
        assertEquals(list2, list);
    }

    /**
     * Test transferFrom.
     */
    @Test
    public void testTransferFrom() {
        ToDoList list = new ToDoList1();
        list.addTask("Do laundry", false);
        list.addTask("Walk the dog", true);

        ToDoList list2 = new ToDoList1();
        list2.addTask("Do laundry", false);
        list2.addTask("Walk the dog", true);

        ToDoList list3 = list.newInstance();
        list3.transferFrom(list);

        assertEquals(list2, list3);
        assertEquals(0, list.size());
    }

    //Secondary method tests----------------------------------------------------

    /**
     * Test Tasks.
     */
    @Test
    public void testTasks() {
        ToDoList list = new ToDoList1();
        list.addTask("Do laundry", false);
        list.addTask("Walk the dog", true);

        String str = "Do laundry, ";

        assertEquals(str, list.tasks(false));
    }

    /**
     * Test allTasks.
     */
    @Test
    public void testAllTasks() {
        ToDoList list = new ToDoList1();
        list.addTask("Do laundry", false);
        list.addTask("Walk the dog", true);

        String str = "Do laundry: incomplete Walk the dog: complete ";

        assertEquals(str, list.allTasks());
    }

    /**
     * Test hasStatus.
     */
    @Test
    public void testHasStatus() {
        ToDoList list = new ToDoList1();
        list.addTask("Do laundry", true);
        list.addTask("Walk the dog", true);

        assert !list.hasStatus(false);
        assert list.hasStatus(true);
    }

    /**
     * Test isComplete.
     */
    @Test
    public void testIsComplete() {
        ToDoList list = new ToDoList1();
        list.addTask("Do laundry", false);
        list.addTask("Walk the dog", true);
        Boolean b1 = list.isComplete();

        list.toggleStatus("Do laundry");
        Boolean b2 = list.isComplete();

        assert !b1;
        assert b2;
    }

    /**
     * Test toggleStatus.
     */
    @Test
    public void testToggleStatus() {
        ToDoList list = new ToDoList1();
        list.addTask("Do laundry", false);
        list.addTask("Walk the dog", true);
        Boolean b = !list.status("Do laundry");
        list.toggleStatus("Do laundry");

        assertEquals(b, list.status("Do laundry"));
    }

    //Common method test--------------------------------------------------------

    /**
     * Test toString.
     */
    @Test
    public void testToString() {
        ToDoList list = new ToDoList1();
        list.addTask("Do laundry", false);
        list.addTask("Walk the dog", true);

        String str = "Do laundry: incomplete Walk the dog: complete ";
        assertEquals(str, list.toString());
    }

    /**
     * Test equals.
     */
    @Test
    public void testEquals() {
        ToDoList list = new ToDoList1();
        list.addTask("Do laundry", false);

        ToDoList list2 = new ToDoList1();
        list2.addTask("Do laundry", false);

        Boolean equals = list.equals(list2);

        assert equals;
    }

}
