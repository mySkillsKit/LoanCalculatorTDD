import org.decimal4j.util.DoubleRounder;

public class LoanCalculator {

    public double monthlyPayment(int loanAmount, double loanTerm, double interestRate) {
        double monthlyPayment = calculateMonthlyPayment(loanAmount, loanTerm, interestRate);
        double result = DoubleRounder.round(monthlyPayment, 2);
        System.out.println("Payment Every Month: USD" + result);
        return result;
    }

    public double totalPrincipalPaid(int loanAmount, double loanTerm, double interestRate) {
        double totalPrincipalPaid = calculateMonthlyPayment(loanAmount, loanTerm, interestRate) * loanTerm;
        double result = DoubleRounder.round(totalPrincipalPaid, 2);
        System.out.println("Total of " + loanTerm + " Payments: USD" + result);
        return result;
    }

    public double totalInterestPaid(int loanAmount, double loanTerm, double interestRate) {
        double totalInterestPaid = calculateMonthlyPayment(loanAmount, loanTerm, interestRate) * loanTerm - loanAmount;
        double result = DoubleRounder.round(totalInterestPaid, 2);
        System.out.println("Total Interest: USD" + result);
        return result;
    }


    private double calculateMonthlyPayment(int loanAmount, double loanTerm, double interestRate) {
        //Before calculating monthly payment, let’s find the monthly rate
        double monthlyInterestRate = interestRate / 100 / 12;
        //calculate the monthly payment
        //First, we calculate 1 + r to the power of n and keep the value into the variable mathPower.
        double mathPower = Math.pow(1 + monthlyInterestRate, loanTerm);
        //Next, we calculate the monthly payment and assign the value to monthlyPayment.
        return loanAmount * (monthlyInterestRate * mathPower / (mathPower - 1));
    }

}
