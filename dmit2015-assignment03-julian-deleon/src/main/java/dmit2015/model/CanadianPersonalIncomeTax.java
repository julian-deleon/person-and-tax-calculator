package dmit2015.model;

import lombok.Data;

/**
 * This class models income tax info.
 *
 * @author Julian De Leon
 * @version 2024.02.08
 * */

@Data
public class CanadianPersonalIncomeTax {
    private int taxYear;
    private double taxableIncome;
    private String province;

    public CanadianPersonalIncomeTax() {
        taxYear = 2023;
        taxableIncome = 50000;
        province = "AB";
    }

    public CanadianPersonalIncomeTax(int newTaxYear, double newTaxableIncome, String newProvince) {
        taxYear = newTaxYear;
        taxableIncome = newTaxableIncome;
        province = newProvince;
    }

    public double federalIncomeTax() {
        double federalTaxAmount = 0.0;

        // Bracket 1: 15%
        if (taxableIncome <= 53359) {
            federalTaxAmount += taxableIncome * 0.15;
        } else {
            federalTaxAmount += 53359 * 0.15;
        }

        // Bracket 2: 20.5%
        if (taxableIncome > 53359 && taxableIncome <= 106717) {
            federalTaxAmount += (taxableIncome - 53359) * 0.205;
        } else if (taxableIncome > 106717) {
            federalTaxAmount += (106717 - 53359) * 0.205;
        }

        // Bracket 3: 26%
        if (taxableIncome > 106717 && taxableIncome <= 165430) {
            federalTaxAmount += (taxableIncome - 106717) * 0.26;
        } else if (taxableIncome > 165430) {
            federalTaxAmount += (165430 - 106717) * 0.26;
        }

        // Bracket 4: 29%
        if (taxableIncome > 165430 && taxableIncome <= 235675) {
            federalTaxAmount += (taxableIncome - 165430) * 0.29;
        } else if (taxableIncome > 235675) {
            federalTaxAmount += (235675 - 165430) * 0.29;
        }

        // Bracket 5: 33%
        if (taxableIncome > 235675) {
            federalTaxAmount += (taxableIncome - 235675) * 0.33;
        }

        return federalTaxAmount;
    }

    public double provincialIncomeTax() {
        double provincialTaxAmount = 0.0;

        // Bracket 1: 10%
        if (taxableIncome <= 142292) {
            provincialTaxAmount += taxableIncome * 0.10;
        } else {
            provincialTaxAmount += 142292 * 0.10;
        }

        // Bracket 2: 12%
        if (taxableIncome > 142292 && taxableIncome <= 170751) {
            provincialTaxAmount += (taxableIncome - 142292) * 0.12;
        } else if (taxableIncome > 170751) {
            provincialTaxAmount += (170751 - 142292) * 0.12;
        }

        // Bracket 3: 13%
        if (taxableIncome > 170751 && taxableIncome <= 227668) {
            provincialTaxAmount += (taxableIncome - 170751) * 0.13;
        } else if (taxableIncome > 227668) {
            provincialTaxAmount += (227668 - 170751) * 0.13;
        }

        // Bracket 4: 14%
        if (taxableIncome > 227668 && taxableIncome <= 341502) {
            provincialTaxAmount += (taxableIncome - 227668) * 0.14;
        } else if (taxableIncome > 341502) {
            provincialTaxAmount += (341502 - 227668) * 0.14;
        }

        // Bracket 5: 15%
        if (taxableIncome > 341502) {
            provincialTaxAmount += (taxableIncome - 341502) * 0.15;
        }

        return provincialTaxAmount;
    }

    public double totalTaxAmount() {
        return federalIncomeTax() + provincialIncomeTax();
    }

}
