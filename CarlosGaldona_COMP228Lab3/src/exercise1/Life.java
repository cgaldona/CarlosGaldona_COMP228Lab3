package exercise1;

public class Life extends Insurance {

    public Life() {
        super("Life Insurance");
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
