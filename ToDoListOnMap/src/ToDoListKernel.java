import components.map.Map;
import components.standard.Standard;

/**
 * ToDoList kernel component with primary methods.
 */
public interface ToDoListKernel extends Standard<ToDoList> {

    //Kernel methods -----------------------------------------------------------

    /**
     *
     * @param task
     *            The string to be added
     * @param status
     *            Boolean true if task is finished, false if task is unfinished
     * @requires task is in not in DOMAIN(this)
     * @ensures this = #this UNION {<task, status>}
     * @updates this
     */
    void addTask(String task, Boolean status);

    /**
     *
     * @param task
     *            The string to be removed
     * @requires task is in DOMAIN(this)
     * @ensures this = #this \ {s}
     * @return task
     * @updates this
     */
    String removeTask(String task);

    /**
     * @requires this.size > 0
     * @ensures task is a string in this
     * @return task
     * @updates this
     */
    Map.Pair<String, Boolean> removeAny();

    /**
     *
     * @param task
     *            String name of task to be checked
     * @ensures hasTask = (task is in RANGE(this))
     * @return true iff this contains task
     * @restores this
     */
    Boolean hasTask(String task);

    /**
     *
     * @param task
     *            String name of task to be checked
     * @requires task is in DOMAIN(this)
     * @ensures status = Pair.checked()
     * @return true iff task is paired status = true, false if task is paired
     *         with status = false
     * @updates this
     */
    Boolean status(String task);

    /**
     * @return size
     * @ensures size = Number of tasks in this
     * @restores this
     */
    int size();

}
