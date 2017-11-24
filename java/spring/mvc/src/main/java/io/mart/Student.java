package io.mart;

import java.util.LinkedHashMap;

/**
 * Created by Aleksandr Martiushov.
 */
public class Student {

    private String firstName;
    private String lastName;
    private String country;
    private String countryFromFile;
    private String favouriteLanguage;
    private String[] favouriteOS;

    private LinkedHashMap<String, String> countryOptions;
    private LinkedHashMap<String, String> favouriteLanguages;
    private LinkedHashMap<String, String> favouriteOSs;

    public Student() {
        countryOptions = new LinkedHashMap<>();
        countryOptions.put("BR", "Brazil");
        countryOptions.put("FR", "France");
        countryOptions.put("DE", "Germany");
        countryOptions.put("IN", "India");

        favouriteLanguages = new LinkedHashMap<>();
        favouriteLanguages.put("Java", "Java");
        favouriteLanguages.put("PHP", "PHP");
        favouriteLanguages.put("Ruby", "Ruby");

        favouriteOSs = new LinkedHashMap<>();
        favouriteOSs.put("Linux", "Linux");
        favouriteOSs.put("MAC", "MAC");
        favouriteOSs.put("Windows", "Windows");

    }

    public String getFirstName() {
        return firstName;
    }

    public void setFirstName(String firstName) {
        this.firstName = firstName;
    }

    public String getLastName() {
        return lastName;
    }

    public void setLastName(String lastName) {
        this.lastName = lastName;
    }

    public String getCountry() {
        return country;
    }

    public void setCountry(String country) {
        this.country = country;
    }

    public LinkedHashMap<String, String> getCountryOptions() {
        return countryOptions;
    }

    public String getCountryFromFile() {
        return countryFromFile;
    }

    public void setCountryFromFile(String countryFromFile) {
        this.countryFromFile = countryFromFile;
    }

    public void setCountryOptions(LinkedHashMap<String, String> countryOptions) {
        this.countryOptions = countryOptions;
    }

    public LinkedHashMap<String, String> getFavouriteLanguages() {
        return favouriteLanguages;
    }

    public void setFavouriteLanguages(LinkedHashMap<String, String> favouriteLanguages) {
        this.favouriteLanguages = favouriteLanguages;
    }

    public String getFavouriteLanguage() {
        return favouriteLanguage;
    }

    public void setFavouriteLanguage(String favouriteLanguage) {
        this.favouriteLanguage = favouriteLanguage;
    }

    public LinkedHashMap<String, String> getFavouriteOSs() {
        return favouriteOSs;
    }

    public void setFavouriteOSs(LinkedHashMap<String, String> favouriteOSs) {
        this.favouriteOSs = favouriteOSs;
    }

    public String[] getFavouriteOS() {
        return favouriteOS;
    }

    public void setFavouriteOS(String[] favouriteOS) {
        this.favouriteOS = favouriteOS;
    }
}
