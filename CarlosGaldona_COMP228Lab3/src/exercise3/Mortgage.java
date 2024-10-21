package exercise3;

public abstract class Mortgage implements MortgageConstants {

    private String mortgageNumber;
    private String customerName;
    private double amount;
    protected double interestRate;
    private int term;

    public Mortgage(String mortgageNumber, String customerName, double amount, double interestRate, int term) {
        this.mortgageNumber = mortgageNumber;
        this.customerName = customerName;
        if (amount > MAX_MORTGAGE_AMOUNT) {
            this.amount = MAX_MORTGAGE_AMOUNT;
        } else {
            this.amount = amount;
        }
        this.interestRate = interestRate;

        if (term != SHORT_TERM && term != MEDIUM_TERM && term != LONG_TERM) {
            this.term = SHORT_TERM; // default to short-term if invalid
        } else {
            this.term = term;
        }
    }

    public abstract void setInterestRate(double primeRate);

    public String getMortgageInfo() {
        return String.format(
                "Mortgage Number: %s\nCustomer Name: %s\nAmount: $%.2f\nInterest Rate: %.2f%%\nTerm: %d years",
                mortgageNumber, customerName, amount, interestRate, term
        );
    }

    public double getTotalAmountOwed() {
        return amount + (amount * interestRate / 100 * term);
    }
}
