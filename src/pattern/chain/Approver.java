package pattern.chain;

public abstract class Approver {

    Approver successor;
    String name;

    public Approver(String name) {
        this.name = name;
    }

    public void setSuccessor(Approver approver) {
        this.successor = approver;
    }

    public abstract void processRequest(PurchaseRequest request);
}
