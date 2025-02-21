package exercise1;

public abstract class Insurance {
    private String type;
    private double monthlyCost;

    public Insurance(String type) {
        this.type = type;
    }

    public String getType() {
        return type;
    }

    public double getMonthlyCost() {
        return monthlyCost;
    }

    protected void setMonthlyCost(double monthlyCost) {
        this.monthlyCost = monthlyCost;
    }

    public abstract void setInsuranceCost(double cost);

    public abstract void displayInfo();

}
