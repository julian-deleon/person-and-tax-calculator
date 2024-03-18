package dmit2015.faces;

import dmit2015.model.CanadianPersonalIncomeTax;
import lombok.Getter;
import org.omnifaces.util.Messages;

import jakarta.faces.view.ViewScoped;
import jakarta.inject.Named;
import jakarta.annotation.PostConstruct;

import java.io.Serializable;

/**
 * This class is the CanadianPersonalIncomeTax backing bean.
 *
 * @author Julian De Leon
 * @version 2024.02.08
 * */

@Named("currentCanadianPersonalIncomeTaxViewScopedView")
@ViewScoped // create this object for one HTTP request and keep in memory if the next is for the same page
// class must implement Serializable
public class CanadianPersonalIncomeTaxViewScopedView implements Serializable {

    // Declare read/write properties (field + getter + setter) for each form field

    // Declare read only properties (field + getter) for data sources
    @Getter
    private CanadianPersonalIncomeTax currentIncomeTax = new CanadianPersonalIncomeTax();
    @Getter
    private double federalIncomeTaxDisplay;
    @Getter
    private double provincialIncomeTaxDisplay;
    @Getter
    private double totalIncomeTaxDisplay;

    // Declare private fields for internal usage only objects

    @PostConstruct // This method is executed after DI is completed (fields with @Inject now have values)
    public void init() { // Use this method to initialized fields instead of a constructor
        // Code to access fields annotated with @Inject

    }

    public void onCalculateFederalIncomeTax() {
        federalIncomeTaxDisplay = currentIncomeTax.federalIncomeTax();
    }

    public void onCalculateProvincialIncomeTax() {
        provincialIncomeTaxDisplay = currentIncomeTax.provincialIncomeTax();
    }

    public void onCalculateTotalIncomeTax() {
        totalIncomeTaxDisplay = currentIncomeTax.totalTaxAmount();
    }

    public void onClear() {
        // Set all fields to default values
        currentIncomeTax = new CanadianPersonalIncomeTax();
        federalIncomeTaxDisplay = 0;
        provincialIncomeTaxDisplay = 0;
        totalIncomeTaxDisplay = 0;
    }
}