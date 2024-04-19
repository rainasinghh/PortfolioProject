/**
 * {@code MapKernel} enhanced with secondary methods.
 *
 **/
public interface ToDoList extends ToDoListKernel {

    /**
     *
     * @param status
     *            Boolean indicating checked or unchecked
     * @requires status is in DOMAIN(this), this.size() > 0
     * @ensures tasks contains all tasks paired with status
     * @return array of all tasks with boolean argument
     * @restores this
     */
    String tasks(boolean status);

    /**
     *
     * @ensures tasks contains all tasks paired with b
     * @return array of all tasks with boolean argument
     * @restores this
     */
    String allTasks();

    /**
     *
     * @param task
     *            The string to be checked
     * @requires task is in DOMAIN(this)
     * @ensures this = #this UNION {task, !status}
     * @updates this
     */
    void toggleStatus(String task);

    /**
     *
     * @ensures isComplete = true iff no pairs in this contain false
     * @return isComplete boolean variable that describes if this is complete
     * @restores this
     */
    boolean isComplete();

    /**
     *
     * @param status
     *            The value to be checked
     * @ensures hasStatus = true iff this contains status
     * @return hasStatus
     * @restores this
     */
    boolean hasStatus(boolean status);

}
