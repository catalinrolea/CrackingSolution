package DesignPatterns.call_center_COPY_PASTE;

public class Employee {
    private String name;
    private Call currentCall;
    private CallManager callManager;

    Employee(String name, CallManager callManager) {
        this.name = name;
        this.callManager = callManager; // this is the required depedency hence must be there in constructor
    }

    public boolean isFree() {
        return this.currentCall == null;
    }

    private void escalateCall() {
        if (!isFree()) {
            currentCall.incrementRank();
            callManager.putCallInWaitQueue(currentCall);
        }
    }

    public void assignCall(Call call) {
        System.out.println(name + " Received call!");
        currentCall = call;
    }
}
