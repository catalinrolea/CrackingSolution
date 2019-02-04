package DesignPatterns.call_center_COPY_PASTE;

import java.util.ArrayList;
import java.util.List;

public class CallManager {
    List<List<Employee>> employeeLevels;
    List<List<Call>> waitQueue;

    CallManager() {
        this.employeeLevels = new ArrayList<>();
        this.employeeLevels.add(new ArrayList<>());
        this.employeeLevels.add(new ArrayList<>());
        this.employeeLevels.add(new ArrayList<>());
        this.waitQueue = new ArrayList<List<Call>>();
    }

    private Employee getCallHandler(Call call) {
        /* check all respondants */
        for (Employee respondant: employeeLevels.get(0)) {
            if (respondant.isFree()) return respondant;
        }

        /* check all managers */
        for (Employee manager: employeeLevels.get(1)) {
            if (manager.isFree()) return manager;
        }

        /* check all directors */
        for (Employee director: employeeLevels.get(2)) {
            if (director.isFree()) return director;
        }

        // No one is free
        return null; // returning null is not a good idea
    }

    public void addRespondant(Employee emp) {
        employeeLevels.get(0).add(emp);
    }

    public void addManager(Employee emp) {
        employeeLevels.get(1).add(emp);
    }

    public void addDirector(Employee emp) {
        employeeLevels.get(2).add(emp);
    }

    public void dispatch(Caller caller) {
        dispatch(new Call(caller));
    }

    public void dispatch(Call call) {
        /* check if any respondant is free */
        Employee handler = getCallHandler(call);
        if (handler == null) {
            System.out.println("Sorry, the line is busy, your call is going in wait queue");
            putCallInWaitQueue(call);
            return;
        }
        handler.assignCall(call);
        call.setEmployee(handler);
    }

    public void putCallInWaitQueue(Call call) {
        waitQueue.get(call.getRank()).add(call);
    }
}
