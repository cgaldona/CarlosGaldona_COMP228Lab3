package exercise3;

import javax.swing.JOptionPane;

public class ProcessMortgage {
    public static void main(String[] args) {
        Mortgage[] mortgages = new Mortgage[3];

        double primeRate = 0.0;
        while (true) {
            String primeRateStr = JOptionPane.showInputDialog("Enter the current prime interest rate:");
            if (primeRateStr == null) {
                System.exit(0); // Exit if Cancel is pressed
            }
            try {
                primeRate = Double.parseDouble(primeRateStr);
                if (primeRate < 0) {
                    JOptionPane.showMessageDialog(null, "Invalid input. Prime interest rate must be a positive number.");
                } else {
                    break;
                }
            } catch (NumberFormatException e) {
                JOptionPane.showMessageDialog(null, "Invalid input. Please enter a numeric value.");
            }
        }

        int currentIndex = 0;
        while (currentIndex < mortgages.length) {
            String type = "";
            while (true) {
                type = JOptionPane.showInputDialog("Enter mortgage type (business/personal):");
                if (type == null) {
                    System.exit(0); // Exit if Cancel is pressed
                }
                if (type.equalsIgnoreCase("business") || type.equalsIgnoreCase("personal")) {
                    break;
                } else if (type.matches("\\d+")) {
                    JOptionPane.showMessageDialog(null, "Invalid input. Type must be a string, not a number.");
                } else {
                    JOptionPane.showMessageDialog(null, "Invalid input. Please enter either 'business' or 'personal'.");
                }
            }

            String mortgageNumber = "";
            while (true) {
                mortgageNumber = JOptionPane.showInputDialog("Enter mortgage number:");
                if (mortgageNumber == null) {
                    System.exit(0); // Exit if Cancel is pressed
                }
                try {
                    int number = Integer.parseInt(mortgageNumber);
                    if (number < 0) {
                        JOptionPane.showMessageDialog(null, "Invalid input. Mortgage number must be a positive value.");
                    } else {
                        break;
                    }
                } catch (NumberFormatException e) {
                    JOptionPane.showMessageDialog(null, "Invalid input. Mortgage number must be a numeric value.");
                }
            }

            String customerName = "";
            while (true) {
                customerName = JOptionPane.showInputDialog("Enter customer name:");
                if (customerName == null) {
                    System.exit(0); // Exit if Cancel is pressed
                }
                if (customerName.matches(".*\\d.*")) {
                    JOptionPane.showMessageDialog(null, "Invalid input. Customer name must be a string, not a number.");
                } else {
                    break;
                }
            }

            double amount = 0.0;
            while (true) {
                String amountStr = JOptionPane.showInputDialog("Enter mortgage amount:");
                if (amountStr == null) {
                    System.exit(0); // Exit if Cancel is pressed
                }
                try {
                    amount = Double.parseDouble(amountStr);
                    if (amount < 0) {
                        JOptionPane.showMessageDialog(null, "Invalid input. Mortgage amount must be a positive number.");
                    } else {
                        break;
                    }
                } catch (NumberFormatException e) {
                    JOptionPane.showMessageDialog(null, "Invalid input. Please enter a numeric value.");
                }
            }

            int term = 0;
            while (true) {
                String termStr = JOptionPane.showInputDialog("Enter mortgage term (1, 3, 5 years):");
                if (termStr == null) {
                    System.exit(0); // Exit if Cancel is pressed
                }
                try {
                    term = Integer.parseInt(termStr);
                    if (term == 1 || term == 3 || term == 5) {
                        break;
                    } else {
                        JOptionPane.showMessageDialog(null, "Invalid input. Please enter 1, 3, or 5.");
                    }
                } catch (NumberFormatException e) {
                    JOptionPane.showMessageDialog(null, "Invalid input. Please enter a numeric value.");
                }
            }

            if (type.equalsIgnoreCase("business")) {
                mortgages[currentIndex] = new BusinessMortgage(mortgageNumber, customerName, amount, primeRate, term);
            } else if (type.equalsIgnoreCase("personal")) {
                mortgages[currentIndex] = new PersonalMortgage(mortgageNumber, customerName, amount, primeRate, term);
            }

            currentIndex++;

            if (currentIndex < mortgages.length) {
                int option = JOptionPane.showOptionDialog(
                        null,
                        "Do you want to enter another mortgage?",
                        "Continue or Finish",
                        JOptionPane.YES_NO_OPTION,
                        JOptionPane.QUESTION_MESSAGE,
                        null,
                        new Object[]{"Next", "Finish"},
                        "Next"
                );
                if (option == JOptionPane.NO_OPTION) {
                    break;
                }
            }
        }

        StringBuilder allMortgagesInfo = new StringBuilder("All Mortgages:\n");
        for (Mortgage mortgage : mortgages) {
            if (mortgage != null) {
                allMortgagesInfo.append(mortgage.getMortgageInfo()).append("\n");
                allMortgagesInfo.append("Total Amount Owed: $").append(mortgage.getTotalAmountOwed()).append("\n\n");
            }
        }

        JOptionPane.showMessageDialog(null, allMortgagesInfo.toString());
    }
}
