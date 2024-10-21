package exercise1;

public class Health extends Insurance {

    public Health() {
        super("Health Insurance");
    }

    @Override
    public void setInsuranceCost(double cost) {
        setMonthlyCost(cost);
    }

    @Override
    public void displayInfo() {
        String message = "Type: " + getType() + "\nMonthly Cost: $" + getMonthlyCost();
        javax.swing.JOptionPane.showMessageDialog(null, message);
    }

}
