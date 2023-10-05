package com.example.demo;
import java.util.Date;
import java.util.List;
import java.util.ArrayList;
import java.util.Objects;

public class Donor {
    public int id;
    private PassportInfo passportInfo;
    private String cardNumber;
    private String lastName;
    private String firstName;
    private String middleName;
    private Date dateOfBirth;
    private String placeOfBirth;
    private List<BloodDonation> bloodDonations;
    private List<ChronicDisease> chronicDiseases;
    private List<String> medicalHistory;

    private Donor() {
    }
    public static class DonorBuilder {
        private Donor donor;

        public DonorBuilder() {
            donor = new Donor();
        }

        public DonorBuilder setId(int id) {
            donor.id = id;
            return this;
        }

        public DonorBuilder setPassportInfo(String passportNumber, Date issueDate, String issuingAuthority) {
            donor.passportInfo = new PassportInfo(passportNumber, issueDate, issuingAuthority);
            return this;
        }

        public DonorBuilder setCardNumber(String cardNumber) {
            donor.cardNumber = cardNumber;
            return this;
        }

        public DonorBuilder setLastName(String lastName) {
            donor.lastName = lastName;
            return this;
        }

        public DonorBuilder setFirstName(String firstName) {
            donor.firstName = firstName;
            return this;
        }

        public DonorBuilder setMiddleName(String middleName) {
            donor.middleName = middleName;
            return this;
        }

        public DonorBuilder setDateOfBirth(Date dateOfBirth) {
            donor.dateOfBirth = dateOfBirth;
            return this;
        }

        public DonorBuilder setPlaceOfBirth(String placeOfBirth) {
            donor.placeOfBirth = placeOfBirth;
            return this;
        }

        public DonorBuilder setBloodDonations(List<BloodDonation> bloodDonations) {
            donor.bloodDonations = bloodDonations;
            return this;
        }

        public DonorBuilder setChronicDiseases(List<ChronicDisease> chronicDiseases) {
            donor.chronicDiseases = chronicDiseases;
            return this;
        }

        public DonorBuilder setMedicalHistory(List<String> medicalHistory) {
            donor.medicalHistory = medicalHistory;
            return this;
        }

        public Donor build() {
            return donor;
        }

    }
    public int getId() {
        return id;
    }

    public PassportInfo getPassportInfo() {
        return passportInfo;
    }


    public String getCardNumber() {
        return cardNumber;
    }

    public String getLastName() {
        return lastName;
    }


    public String getFirstName() {
        return firstName;
    }


    public String getMiddleName() {
        return middleName;
    }


    public Date getDateOfBirth() {
        return dateOfBirth;
    }


    public String getPlaceOfBirth() {
        return placeOfBirth;
    }


    public List<BloodDonation> getBloodDonations() {
        return bloodDonations;
    }

    public void addBloodDonation(BloodDonation bloodDonation) {
        this.bloodDonations.add(bloodDonation);
    }

    public List<ChronicDisease> getChronicDiseases() {
        return chronicDiseases;
    }

    public void addChronicDisease(ChronicDisease disease) {
        this.chronicDiseases.add(disease);
    }

    public List<String> getMedicalHistory() {
        return medicalHistory;
    }

    public void addToMedicalHistory(String condition) {
        this.medicalHistory.add(condition);
    }

    public static class BloodDonation {
        private Date date;
        private double volume;
        private String bloodGroup;
        private String rhFactor;

        public BloodDonation(Date date, double volume, String bloodGroup, String rhFactor) {
            this.date = date;
            this.volume = volume;
            this.bloodGroup = bloodGroup;
            this.rhFactor = rhFactor;
        }

        public Date getDate() {
            return date;
        }

        public double getVolume() {
            return volume;
        }

        public String getBloodGroup() {
            return bloodGroup;
        }

        public String getRhFactor() {
            return rhFactor;
        }
    }

    public static class PassportInfo {
        private String passportNumber;
        private Date issueDate;
        private String issuingAuthority;

        public PassportInfo(String passportNumber, Date issueDate, String issuingAuthority) {
            this.passportNumber = passportNumber;
            this.issueDate = issueDate;
            this.issuingAuthority = issuingAuthority;
        }

        public String getPassportNumber() {
            return passportNumber;
        }

        public Date getIssueDate() {
            return issueDate;
        }

        public String getIssuingAuthority() {
            return issuingAuthority;
        }


    }

    public static class ChronicDisease {
        private String name;
        private Date diagnosisDate;

        public ChronicDisease(String name, Date diagnosisDate) {
            this.name = name;
            this.diagnosisDate = diagnosisDate;
        }

        public String getName() {
            return name;
        }

        public Date getDiagnosisDate() {
            return diagnosisDate;
        }


        @Override
        public boolean equals(Object o) {
            if (this == o) return true;
            if (o == null || getClass() != o.getClass()) return false;
            ChronicDisease that = (ChronicDisease) o;
            return Objects.equals(name, that.name) &&
                    Objects.equals(diagnosisDate, that.diagnosisDate);
        }

        @Override
        public int hashCode() {
            return Objects.hash(name, diagnosisDate);
        }
    }
}