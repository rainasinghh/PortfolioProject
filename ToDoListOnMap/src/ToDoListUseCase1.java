import components.map.Map;

/**
 *
 * This file demonstrates one possible use of ToDoList through a static method.
 *
 * @author Raina Singh
 *
 */
public final class ToDoListUseCase1 {

    /**
     * No argument constructor--private to prevent instantiation.
     */
    private ToDoListUseCase1() {
    }

    /**
     * Method "cleans" your ToDoList by removing finished tasks.
     *
     * @param list
     *            the list to clean
     */
    public static void removeFinishedTasks(ToDoList list) {
        while (list.hasStatus(true)) {
            Map.Pair<String, Boolean> p = list.removeAny();
            if (!p.value()) {
                list.addTask(p.key(), p.value());
            }

        }
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
        list.addTask("Study for CSE 2231 final", false);

        System.out.println(list);

        removeFinishedTasks(list);

        System.out.println(list);
    }

}
