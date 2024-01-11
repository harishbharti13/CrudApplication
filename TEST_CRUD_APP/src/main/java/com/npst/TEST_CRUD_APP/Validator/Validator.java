package com.npst.TEST_CRUD_APP.Validator;

import org.springframework.stereotype.Service;
import org.springframework.validation.annotation.Validated;

@Validated
@Service
public class Validator {

    /*
    private static boolean isValid(String value, String regex) {
        Pattern pattern = Pattern.compile(regex);
        return value != null && pattern.matcher(value).matches();
    }

    public boolean isValidName(String firstName) {
        String regexName = "^[A-Za-z]+$";
        return isValid(firstName, regexName);
    }
    public boolean isValidEmail(String email) {
        String regexEmail = "[a-z0-9._%+-]+@[a-z0-9.-]+\\.[a-z]{2,3}";
        return isValid(email, regexEmail);
    }

    public boolean isValidMobileNumber(String mobileNumber) {
        String regexMobile = "[1-9][0-9]{9}";
        return isValid(mobileNumber, regexMobile);
    }
    public boolean isValidDOB(String dob) {
        String regexp = "^\\d{4}-\\d{2}-\\d{2}$";
        return isValid(dob, regexp);
    } */
}
