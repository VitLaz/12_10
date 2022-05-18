package curcul.page;

import com.codeborne.selenide.SelenideElement;
import curcul.page.component.Calendar;
import io.qameta.allure.Step;

import static com.codeborne.selenide.Condition.text;
import static com.codeborne.selenide.Selectors.byText;
import static com.codeborne.selenide.Selenide.*;

public class RegistrationFromPage {

    Calendar calendar = new Calendar();

    private SelenideElement firstNameLoc = $("#firstName"),
            lastNameLoc = $("#lastName"),
            emailLoc = $("#userEmail"),
            genderLoc = $("#genterWrapper"),
            teleNumberLoc = $("#userNumber"),
            birthDateLoc = $("#dateOfBirthInput"),
            subjectLoc = $("#subjectsInput"),
            hobbiesLoc = $("#hobbiesWrapper"),
            pictureLoc = $("#uploadPicture"),
            addressLoc = $("#currentAddress"),
            stateLoc =$("#state"),
            cityLoc = $("#city"),
            submitLoc =$("#submit"),
            resultsTableLoc = $(".table-responsive");





    @Step("Открываем страницу")
    public RegistrationFromPage openPage () {
        open("/automation-practice-form");
        executeJavaScript("$('footer').remove()");
        executeJavaScript("$('#fixedban').remove()");
        return this;
    }

    public RegistrationFromPage setFirstName (String firstName) {
        firstNameLoc.setValue(firstName);
        return this;
    }

    public RegistrationFromPage setLastName (String lastName){
        lastNameLoc.setValue(lastName);
        return this;
    }

    public RegistrationFromPage setEmail (String email) {
        emailLoc.setValue(email);
        return this;
    }

    public RegistrationFromPage setGender (String gender) {
        genderLoc.$(byText(gender)).click();
        return this;
    }

    public RegistrationFromPage setTele (String teleNumber) {
        teleNumberLoc.setValue(teleNumber);
        return this;
    }

    public RegistrationFromPage setBirthDate (String day, String month, String year) {
        birthDateLoc.click();
        calendar.setDate(day, month, year);
        return this;
    }

    public RegistrationFromPage setSubjects (String subject) {
        subjectLoc.setValue(subject).pressEnter();
        return this;
    }

    public RegistrationFromPage setHobbies (String hobbies) {
        hobbiesLoc.$(byText(hobbies)).click();
        return this;
    }

    public RegistrationFromPage setUploadFile (String file) {
        pictureLoc.uploadFromClasspath(file);
        return this;
    }

    public RegistrationFromPage setCurrentAddress (String currentAddress) {
        addressLoc.setValue(currentAddress);
        return this;
    }

    public RegistrationFromPage setState (String state) {
        stateLoc.click();
        $(byText(state)).click();
        return this;
    }

    public RegistrationFromPage setCity (String city) {
        cityLoc.click();
        $(byText(city)).click();
        return this;
    }

    public RegistrationFromPage setSubmit (){
        submitLoc.click();
        return this;
    }
    public RegistrationFromPage checkForm (String fieldName, String value) {
        resultsTableLoc.$(byText(fieldName)).parent().shouldHave(text(value));
        return this;
    }
}