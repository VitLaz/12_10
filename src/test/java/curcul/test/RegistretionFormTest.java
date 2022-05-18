package guru.qa.test;

import com.codeborne.selenide.Configuration;
import com.github.javafaker.Faker;
import curcul.page.RegistrationFromPage;
import org.junit.jupiter.api.BeforeAll;
import org.junit.jupiter.api.Test;

import java.util.Locale;

import static java.lang.String.format;

public class RegistretionFormTest {
    Faker faker = new Faker();

    String firstName = faker.name().firstName(),
            lastName = faker.name().lastName(),
            email = faker.internet().emailAddress(),
            teleNumber = faker.numerify("##########"),
            day = "29",
            month = "October",
            year = "1990",
            gender = "Male",
            hobbies = "Reading",
            file = "lightning_PNG52.png",
            state = "NCR",
            city = "Delhi",
            subject = "Maths",
            currentAddress = faker.address().fullAddress();

    String expectedFullName = format("%s %s", firstName, lastName);
    String expectedBirthdayDate = format("%s %s,%s",day, month,year);
    String expectedStateAndCity = format("%s %s", state, city);


    @BeforeAll
    static void beforeAll() {
        Configuration.baseUrl = "https://demoqa.com";
        Configuration.browserSize = "1920x1080";
    }

    @Test
    public void registrationFromTest () {
        RegistrationFromPage page = new RegistrationFromPage();
        page.openPage()
                .setFirstName(firstName)
                .setLastName(lastName)
                .setEmail(email)
                .setGender(gender)
                .setBirthDate(day, month, year)
                .setTele(teleNumber)
                .setSubjects(subject)
                .setHobbies(hobbies)
                .setUploadFile(file)
                .setCurrentAddress(currentAddress)
                .setState(state)
                .setCity(city)
                .setSubmit()
                .checkForm("Student Name", expectedFullName)
                .checkForm("Student Email", email)
                .checkForm("Gender", gender)
                .checkForm("Mobile", teleNumber)
                .checkForm("Date of Birth", expectedBirthdayDate)
                .checkForm("Subjects", subject)
                .checkForm("Hobbies", hobbies)
                .checkForm("Picture", file)
                .checkForm("Address", currentAddress)
                .checkForm("State and City",expectedStateAndCity);
    }
}