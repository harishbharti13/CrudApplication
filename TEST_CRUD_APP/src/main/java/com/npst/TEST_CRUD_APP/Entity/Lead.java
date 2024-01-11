package com.npst.TEST_CRUD_APP.Entity;


import javax.persistence.*;
import javax.validation.constraints.NotNull;
import javax.validation.constraints.Pattern;


@Entity
@Table(name = "Lead")
public class Lead {
    @Id
    @GeneratedValue(strategy = GenerationType.AUTO)
    @Column(name="LeadId", unique = true, nullable = false)
    private Long leadId;

    @Column(name = "FirstName")
    @NotNull(message = "First name is mandatory")
    @Pattern(regexp = "^[A-Za-z]+$", message = "First name should contain only alphabets with no spaces")
    private String firstName;

    @Column(name = "MiddleName")
    @NotNull(message = "Middle name is mandatory")
    @Pattern(regexp = "^[A-Za-z]+$", message = "Middle name should contain only alphabets with no spaces")
    private String middleName;

    @Column(name = "LastName")
    @NotNull(message = "Last name is mandatory")
    @Pattern(regexp = "^[A-Za-z]+$", message = "Last name should contain only alphabets with no spaces")
    private String lastName;

    @Column(name = "MobileNumber")
    @NotNull(message = "Mobile number is mandatory")
    @Pattern(regexp = "^[6-9]\\d{9}$", message = "Mobile number should start with a digit greater than 5 and contain exactly 10 digits")
    private String mobileNumber;

    @Column(name = "Gender")
    @NotNull(message = "Gender is mandatory")
    @Pattern(regexp = "^(Male|Female|Others)$", message = "Gender should be Male, Female, or Others")
    private String gender;

    @Column(name = "DOB")
    @NotNull(message = "Date of Birth is mandatory")
    @Pattern(regexp = "^\\d{4}-\\d{2}-\\d{2}$", message = "Date of Birth should be in the format YYYY-MM-DD")
    private String dob;
    @Column(name = "Email")
    @NotNull(message = "Email is mandatory")
    @Pattern(regexp = "[a-z0-9._%+-]+@[a-z0-9.-]+\\.[a-z]{2,3}", message = "Invalid email")
    private String email;

    public Lead() {
    }

    public Lead(Long leadId, String firstName, String middleName, String lastName, String mobileNumber, String gender, String dob, String email) {
        this.leadId = leadId;
        this.firstName = firstName;
        this.middleName = middleName;
        this.lastName = lastName;
        this.mobileNumber = mobileNumber;
        this.gender = gender;
        this.dob = dob;
        this.email = email;
    }

    public Long getLeadId() {
        return leadId;
    }

    public void setLeadId(Long leadId) {
        this.leadId = leadId;
    }

    public String getFirstName() {
        return firstName;
    }

    public void setFirstName(String firstName) {
        this.firstName = firstName;
    }

    public String getMiddleName() {
        return middleName;
    }

    public void setMiddleName(String middleName) {
        this.middleName = middleName;
    }

    public String getLastName() {
        return lastName;
    }

    public void setLastName(String lastName) {
        this.lastName = lastName;
    }

    public String getMobileNumber() {
        return mobileNumber;
    }

    public void setMobileNumber(String mobileNumber) {
        this.mobileNumber = mobileNumber;
    }

    public String getGender() {
        return gender;
    }

    public void setGender(String gender) {
        this.gender = gender;
    }

    public String getDob() {
        return dob;
    }

    public void setDob(String dob) {
        this.dob = dob;
    }

    public String getEmail() {
        return email;
    }

    public void setEmail(String email) {
        this.email = email;
    }

    @Override
    public String toString() {
        return "Lead{" +
                "leadId=" + leadId +
                ", firstName='" + firstName + '\'' +
                ", middleName='" + middleName + '\'' +
                ", lastName='" + lastName + '\'' +
                ", mobileNumber='" + mobileNumber + '\'' +
                ", gender='" + gender + '\'' +
                ", dob='" + dob + '\'' +
                ", email='" + email + '\'' +
                '}';
    }
}
