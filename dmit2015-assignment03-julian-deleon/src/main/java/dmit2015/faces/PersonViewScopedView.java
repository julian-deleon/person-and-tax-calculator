package dmit2015.faces;

import dmit2015.model.Person;
import lombok.Getter;
import lombok.Setter;
import org.omnifaces.util.Messages;

import jakarta.faces.view.ViewScoped;
import jakarta.inject.Named;
import jakarta.annotation.PostConstruct;

import java.io.Serializable;
import java.time.LocalDate;

/**
 * This class is the Person backing bean.
 *
 * @author Julian De Leon
 * @version 2024.02.08
 * */

@Named("currentPersonViewScopedView")
@ViewScoped // create this object for one HTTP request and keep in memory if the next is for the same page
// class must implement Serializable
public class PersonViewScopedView implements Serializable {

    // Declare read/write properties (field + getter + setter) for each form field
    @Getter @Setter
    private LocalDate ageOnDate;

    // Declare read only properties (field + getter) for data sources
    @Getter
    private Person currentPerson = new Person();
    @Getter
    private long currentAgeDisplay;
    @Getter
    private long ageOnDateDisplay;
    @Getter
    private String chineseZodiacDisplay;
    @Getter
    private String astrologicalSignDisplay;

    // Declare private fields for internal usage only objects

    @PostConstruct // This method is executed after DI is completed (fields with @Inject now have values)
    public void init() { // Use this method to initialized fields instead of a constructor
        // Code to access fields annotated with @Inject

    }

    public void onGetCurrentAge() {
        currentAgeDisplay = currentPerson.currentAge();
    }

    public void onGetAgeOnDate() {
        if (ageOnDate != null)
            ageOnDateDisplay = currentPerson.ageOn(ageOnDate);
    }

    public void onGetChineseZodiac() {
        chineseZodiacDisplay = currentPerson.chineseZodiac();
    }

    public void onGetAstrologicalSign() {
        astrologicalSignDisplay = currentPerson.astrologicalSign();
    }

    public void onClear() {
        // Set all fields to default values
        currentPerson = new Person();
        currentAgeDisplay = 0;
        ageOnDate = null;
        ageOnDateDisplay = 0;
        chineseZodiacDisplay = "N/A";
        astrologicalSignDisplay= "N/A";
    }
}