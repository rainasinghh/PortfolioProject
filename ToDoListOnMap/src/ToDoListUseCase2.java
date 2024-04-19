import components.map.Map;

/**
 * This file TESTS and DEMONSTRATES the uses of ToDolist
 *
 * Tests Secondary Methods: tasks, allTasks, toggleStatus, isComplete,
 * hasStatus, equals, toString, and hashCode through a main method.
 *
 * @author Raina Singh
 *
 */
public final class ToDoListUseCase2 {

    /**
     * No argument constructor--private to prevent instantiation.
     */
    private ToDoListUseCase2() {
    }

    /**
     * This method sorts your ToDoList by moving unfinished tasks to the top.
     *
     * @param list
     *            the list to be sorted.
     * @return sortedList list with unfinished tasks listed first.
     */
    public static ToDoList sortByPriority(ToDoList list) {
        ToDoList sortedList = list.newInstance();

        while (list.hasStatus(false)) {
            Map.Pair<String, Boolean> p = list.removeAny();
            if (!p.value()) {
                sortedList.addTask(p.key(), p.value());
            } else {
                list.addTask(p.key(), p.value());
            }
        }

        while (list.size() > 0) {
            Map.Pair<String, Boolean> p = list.removeAny();
            sortedList.addTask(p.key(), p.value());
        }

        return sortedList;
    }

    /**
     * Main method.
     *
     * @param args
     *            the command line arguments
     */
    public static void main(String[] args) {
        ToDoList list = new ToDoList1();
        list.addTask("Walk the dog", true);
        list.addTask("Do the laundry", true);
        list.addTask("Study for CSE 2231 final", false); // :(
        list.addTask("Clean room", false);
        list.addTask("Go to the gym", false);
        list.addTask("Pay bills", false);

        System.out.println(list);

        list.transferFrom(sortByPriority(list));

        System.out.println(list);
    }
}
