package exercise3;

public class PersonalMortgage extends Mortgage {

    public PersonalMortgage(String mortgageNumber, String customerName, double amount, double primeRate, int term) {
        super(mortgageNumber, customerName, amount, primeRate + 2.0, term);
    }

    @Override
    public void setInterestRate(double primeRate) {
        super.interestRate = primeRate + 2.0;
    }
}
