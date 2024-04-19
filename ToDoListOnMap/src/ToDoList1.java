import components.map.Map;
import components.map.Map2;

/**
 * {@code ToDoList} represented as a {@code Map} with implementations of primary
 * methods.
 *
 * @convention <pre>
 * [all pairs in this must be of <String, Boolean>]
 *
 * </pre>
 * @correspondence <pre>
 * this = [if $this.rep = empty_map, then ToDoList is empty]
 * </pre>
 *
 * @author Raina Singh
 *
 */

public class ToDoList1 extends ToDoListSecondary {

    //Constructors--------------------------------------------------------------

    /**
     * Initial representation of this.
     */
    private Map<String, Boolean> rep;

    /**
     * Creator of initial representation.
     */
    private void createNewRep() {
        this.rep = new Map2<>();
    }

    /**
     * No-argument constructor.
     */
    public ToDoList1() {
        this.createNewRep();
    }

    //Kernel methods------------------------------------------------------------

    /**
     * addTask Method.
     */
    @Override
    public void addTask(String task, Boolean status) {
        assert !(this.rep.hasKey(task)) : "This must not contain task";
        this.rep.add(task, status);
    }

    /**
     * removeTask Method.
     */
    @Override
    public String removeTask(String task) {
        assert this.rep.hasKey(task) : "This must contain task";
        return this.rep.remove(task).key();
    }

    /**
     * removeAny Method.
     */
    @Override
    public Map.Pair<String, Boolean> removeAny() {
        assert this.rep.size() > 0 : "This must not be empty";
        return this.rep.removeAny();
    }

    /**
     * hasTask Method.
     */
    @Override
    public Boolean hasTask(String task) {
        return this.rep.hasKey(task);
    }

    /**
     * status Method.
     */
    @Override
    public Boolean status(String task) {
        assert this.rep.hasKey(task) : "This must contain task";
        return this.rep.value(task);
    }

    /**
     * size Method.
     */
    @Override
    public int size() {
        return this.rep.size();
    }

    //Standard methods----------------------------------------------------------

    /**
     * clear Method.
     */
    @Override
    public void clear() {
        this.createNewRep();
    }

    /**
     * newInstance Method.
     */
    @Override
    public final ToDoList1 newInstance() {
        try {
            return this.getClass().getConstructor().newInstance();
        } catch (ReflectiveOperationException e) {
            throw new AssertionError(
                    "Cannot construct object of type " + this.getClass());
        }
    }

    /**
     * transferFrom Method.
     */
    @Override
    public void transferFrom(ToDoList source) {
        ToDoList1 localSource = (ToDoList1) source;
        this.rep = localSource.rep;
        localSource.createNewRep();
    }

}
