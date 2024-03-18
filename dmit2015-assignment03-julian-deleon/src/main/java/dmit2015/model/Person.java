package dmit2015.model;

import lombok.Data;
import lombok.Getter;
import lombok.Setter;

import java.time.LocalDate;
import java.time.temporal.ChronoUnit;

/**
 * This class is models person information: name, birthdate.
 *
 * @author Julian De Leon
 * @version 2024.02.08
 * */

@Data
public class Person {

    private String firstName;
    private String lastName;
    private LocalDate birthDate;

    public Person() {
        firstName = "DMIT2015";
        lastName = "Student";
        birthDate = LocalDate.now();
    }

    public Person(String newFirstName, String newLastName, LocalDate newBirthDate)
    {
        firstName = newFirstName;
        lastName = newLastName;
        birthDate = newBirthDate;
    }

    public long currentAge() {
        return ChronoUnit.YEARS.between(birthDate, LocalDate.now());
    }
    public long ageOn(LocalDate onDate) {
        return ChronoUnit.YEARS.between(birthDate, onDate);
    }

    public String chineseZodiac() {
        int year = birthDate.getYear() % 12;
        switch (year) {
            case 0:
                return "Monkey";
            case 1:
                return "Rooster";
            case 2:
                return "Dog";
            case 3:
                return "Pig";
            case 4:
                return "Rat";
            case 5:
                return "Ox";
            case 6:
                return "Tiger";
            case 7:
                return "Rabbit";
            case 8:
                return "Dragon";
            case 9:
                return "Snake";
            case 10:
                return "Horse";
            case 11:
                return "Sheep";
            default:
                return "Invalid birth year";
        }
    }

    public String astrologicalSign() {
        int month = birthDate.getMonthValue();
        int day = birthDate.getDayOfMonth();

        if ((month == 3 && day >= 21) || (month == 4 && day <= 19)) {
            return "Aries";
        } else if ((month == 4 && day >= 20) || (month == 5 && day <= 20)) {
            return "Taurus";
        } else if ((month == 5 && day >= 21) || (month == 6 && day <= 21)) {
            return "Gemini";
        } else if ((month == 6 && day >= 22) || (month == 7 && day <= 22)) {
            return "Cancer";
        } else if ((month == 7 && day >= 23) || (month == 8 && day <= 22)) {
            return "Leo";
        } else if ((month == 8 && day >= 23) || (month == 9 && day <= 22)) {
            return "Virgo";
        } else if ((month == 9 && day >= 23) || (month == 10 && day <= 22)) {
            return "Libra";
        } else if ((month == 10 && day >= 23) || (month == 11 && day <= 22)) {
            return "Scorpio";
        } else if ((month == 11 && day >= 23) || (month == 12 && day <= 21)) {
            return "Sagittarius";
        } else if ((month == 12 && day >= 22) || (month == 1 && day <= 19)) {
            return "Capricorn";
        } else if ((month == 1 && day >= 20) || (month == 2 && day <= 18)) {
            return "Aquarius";
        } else if ((month == 2 && day >= 19) || (month == 3 && day <= 20)) {
            return "Pisces";
        } else {
            return "Invalid date";
        }
    }
}
