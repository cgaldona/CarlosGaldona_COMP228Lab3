package exercise1;

import javax.swing.JOptionPane;

public class InsuranceMain {

    public static void main(String[] args) {
        Insurance[] insurances = new Insurance[2];

        for (int i = 0; i < insurances.length; i++) {
            String type;
            while (true) {
                type = JOptionPane.showInputDialog("Enter type of insurance (Health/Life):");
                if (type == null) {
                    System.exit(0); // Exit the program if Cancel is pressed
                }
                if (type.equalsIgnoreCase("Health") || type.equalsIgnoreCase("Life")) {
                    break;
                } else {
                    JOptionPane.showMessageDialog(null, "Invalid insurance type. Please enter Health or Life.");
                }
            }

            String costInput;
            double cost;
            while (true) {
                costInput = JOptionPane.showInputDialog("Enter the monthly cost:");
                if (costInput == null) {
                    System.exit(0); // Exit the program if Cancel is pressed
                }
                try {
                    cost = Double.parseDouble(costInput);
                    break;
                } catch (NumberFormatException e) {
                    JOptionPane.showMessageDialog(null, "Invalid cost. Please enter a numeric value.");
                }
            }

            if (type.equalsIgnoreCase("Health")) {
                insurances[i] = new Health();
            } else {
                insurances[i] = new Life();
            }

            insurances[i].setInsuranceCost(cost);

            int option = JOptionPane.showOptionDialog(
                    null,
                    "Type: " + insurances[i].getType() + "\nMonthly Cost: $" + insurances[i].getMonthlyCost(),
                    "Insurance Info",
                    JOptionPane.DEFAULT_OPTION,
                    JOptionPane.INFORMATION_MESSAGE,
                    null,
                    new Object[]{"Next", "Finish"},
                    "Next"
            );

            if (option == JOptionPane.CLOSED_OPTION || option == 1) { // Finish button or close dialog
                break;
            }
        }

        StringBuilder details = new StringBuilder("Insurance Details:\n");
        for (Insurance insurance : insurances) {
            if (insurance != null) {
                details.append("Type: ").append(insurance.getType()).append("\n");
                details.append("Monthly Cost: $").append(insurance.getMonthlyCost()).append("\n\n");
            }
        }

        JOptionPane.showMessageDialog(null, details.toString());
    }
}
