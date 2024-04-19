import components.map.Map;
import components.map.Map2;

/**
 * Implementation of ToDoList secondary methods.
 *
 * @author Raina Singh
 */
public abstract class ToDoListSecondary implements ToDoList {

    //Secondary methods---------------------------------------------------------

    /**
     * tasks Method.
     */
    @Override
    public String tasks(boolean status) {
        Map<String, Boolean> m = new Map2<>();
        String strTasks = "";

        while (this.size() > 0) {
            Map.Pair<String, Boolean> p = this.removeAny();
            m.add(p.key(), p.value());
        }

        for (Map.Pair<String, Boolean> pair : m) {
            this.addTask(pair.key(), pair.value());
            if (status == pair.value()) {
                strTasks += pair.key() + ", ";
            }
        }

        return strTasks;
    }

    /**
     * allTasks Method.
     */
    @Override
    public String allTasks() {
        Map<String, Boolean> m = new Map2<>();
        String strTasks = "";

        while (this.size() > 0) {
            Map.Pair<String, Boolean> p = this.removeAny();
            m.add(p.key(), p.value());
        }

        for (Map.Pair<String, Boolean> pair : m) {
            this.addTask(pair.key(), pair.value());
            strTasks += pair.key() + ": ";
            if (pair.value()) {
                strTasks += "complete";
            } else {
                strTasks += "incomplete";
            }
            strTasks += " ";
        }

        return strTasks;
    }

    /**
     * toggleStatus Method.
     */
    @Override
    public void toggleStatus(String task) {
        assert this.hasTask(task) : "This must contain task";
        boolean status = !(this.status(task));
        this.removeTask(task);
        this.addTask(task, status);
    }

    /**
     * isComplete Method.
     */
    @Override
    public boolean isComplete() {
        return !(this.hasStatus(false));
    }

    /**
     * hasStatus Method.
     */
    @Override
    public boolean hasStatus(boolean status) {
        Boolean hasStatus = false;
        Map<String, Boolean> m = new Map2<>();

        while (this.size() > 0) {
            Map.Pair<String, Boolean> p = this.removeAny();
            m.add(p.key(), p.value());
        }

        for (Map.Pair<String, Boolean> pair : m) {
            this.addTask(pair.key(), pair.value());
            if (pair.value() == status) {
                hasStatus = true;
            }
        }
        return hasStatus;
    }

    // Common methods-----------------------------------------------------------

    /**
     * toString Method.
     */
    @Override
    public String toString() {
        return this.allTasks();
    }

    /**
     * equals Method.
     */
    @Override
    public boolean equals(Object obj) {
        assert obj != null : "Object must not be null";
        return obj instanceof ToDoList;
    }

    /**
     * hashCode Method.
     */
    @Override
    public int hashCode() {
        return this.size();
    }

}
