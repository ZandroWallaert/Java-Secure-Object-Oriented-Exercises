package be.howest.ti.design.patterns.builder.address;

public class Address {
    public String getStreet() {
        return street;
    }

    public String getNumber() {
        return number;
    }

    public String getCityCode() {
        return cityCode;
    }

    public String getCity() {
        return city;
    }

    public String getCountry() {
        return country;
    }

    private final String street;
    private final String number;
    private final String cityCode;
    private final String city;
    private final String country;

    public Address(String street, String number, String cityCode, String city, String country) {
        this.street = street;
        this.number = number;
        this.cityCode = cityCode;
        this.city = city;
        this.country = country;
    }


    @Override
    public String toString() {
        return "Address{" +
                "street='" + street + '\'' +
                ", number='" + number + '\'' +
                ", cityCode='" + cityCode + '\'' +
                ", city='" + city + '\'' +
                ", country='" + country + '\'' +
                '}';
    }
}
