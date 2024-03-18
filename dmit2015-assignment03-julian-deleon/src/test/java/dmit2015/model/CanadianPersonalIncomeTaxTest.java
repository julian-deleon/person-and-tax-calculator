package dmit2015.model;

import org.junit.jupiter.api.Test;
import org.junit.jupiter.params.ParameterizedTest;
import org.junit.jupiter.params.provider.CsvSource;
import static org.junit.jupiter.api.Assertions.*;

/**
 * This is a test class for CanadianPersonalIncomeTax.
 *
 * @author Julian De Leon
 * @version 2024.02.08
 * */

public class CanadianPersonalIncomeTaxTest {
    @ParameterizedTest
    @CsvSource({
            "2023, 26679.50, AB, 4001.93",
            "2023, 53359.00, AB, 8003.85",
            "2023, 80038.00, AB, 13473.05",
            "2023, 106717.00, AB, 18942.24",
            "2023, 136073.50, AB, 26574.93",
            "2023, 165430.00, AB, 34207.62",
            "2023, 200552.50, AB, 44393.15",
            "2023, 235675.00, AB, 54578.67",
            "2023, 471350.00, AB, 132351.42"
    })
    void federalTax_taxableIncome_returnsTaxAmount(
            int taxYear,
            double taxableIncome,
            String province,
            double expectedFederalTaxAmount
    ) {
        var currentCanadianPersonalIncomeTax = new CanadianPersonalIncomeTax(taxYear, taxableIncome, province);
        assertEquals(expectedFederalTaxAmount, currentCanadianPersonalIncomeTax.federalIncomeTax(), 0.50);
    }

    @ParameterizedTest
    @CsvSource({
            "2023, 71146.00, AB, 7114.60",
            "2023, 142292.00, AB, 14229.20",
            "2023, 156521.50, AB, 15936.74",
            "2023, 170751.00, AB, 17644.28",
            "2023, 199209.50, AB, 21343.89",
            "2023, 227668.00, AB, 25043.49",
            "2023, 284585.00, AB, 33011.87",
            "2023, 341502.00, AB, 40980.25",
            "2023, 512253.00, AB, 66592.90"
    })
    void provincialTax_taxableIncome_returnsTaxAmount(
            int taxYear,
            double taxableIncome,
            String province,
            double expectedProvincialTaxAmount
    ) {
        var currentCanadianPersonalIncomeTax = new CanadianPersonalIncomeTax(taxYear, taxableIncome, province);
        assertEquals(expectedProvincialTaxAmount, currentCanadianPersonalIncomeTax.provincialIncomeTax(), 0.50);
    }

    @Test
    void totalTaxAmount_taxableIncome_returnsTotalTaxAmount() {
        var currentCanadianPersonalIncomeTax = new CanadianPersonalIncomeTax(2023, 26679.50, "AB" );

        // expected total tax amount (sum of federal and provincial taxes)
        double expectedTotalTaxAmount = 6669.88; // Example value

        // Call the totalTaxAmount() method
        double actualTotalTaxAmount = currentCanadianPersonalIncomeTax.totalTaxAmount();

        // Verify the result
        assertEquals(expectedTotalTaxAmount, actualTotalTaxAmount, 0.01); // Adjust delta as needed
    }
}
