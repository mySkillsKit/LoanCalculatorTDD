import org.junit.jupiter.api.BeforeEach;
import org.junit.jupiter.api.Test;

import static org.junit.jupiter.api.Assertions.assertEquals;

public class LoanCalculatorTest {

    LoanCalculator sut;

    @BeforeEach
    public void init() {
        System.out.println("test started");
        sut = new LoanCalculator();
    }

    @Test
    public void testMonthlyPayment() {
        //given:
        int loanAmount = 10_000;
        int loanTerm = 40;
        double interestRate = 8.2;

        double expected = 286.57;

        // when:
        double result = sut.monthlyPayment(loanAmount, loanTerm, interestRate);

        // then:
        assertEquals(expected, result);

    }


    @Test
    public void testTotalPrincipalPaid() {
        //given:
        int loanAmount = 120_109;
        int loanTerm = 60;
        double interestRate = 9.33;

        double expected = 150_752.75;

        // when:
        double result = sut.totalPrincipalPaid(loanAmount, loanTerm, interestRate);

        // then:
        assertEquals(expected, result);

    }

    @Test
    public void testTotalInterestPaid() {
        //given:
        int loanAmount = 1_029_350;
        int loanTerm = 12;
        double interestRate = 13.58;

        double expected = 77_278.89;

        // when:
        double result = sut.totalInterestPaid(loanAmount, loanTerm, interestRate);

        // then:
        assertEquals(expected, result);
    }


}
