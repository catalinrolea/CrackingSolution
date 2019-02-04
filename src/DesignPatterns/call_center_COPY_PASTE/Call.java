package DesignPatterns.call_center_COPY_PASTE;


final class Call {
    private int rank;
    private Caller caller;
    private Employee employee;

    Call() {
        this.rank = 0;
    }

    Call(Caller caller) {
        super();
        this.caller = caller;
    }

    public int getRank() {
        return rank;
    }

    public void incrementRank() {
        this.rank += 1;
    }

    public void setCaller(Caller caller) {
        this.caller = caller;
    }

    public void setEmployee(Employee employee) {
        this.employee = employee;
    }
}