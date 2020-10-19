package be.howest.ti.design.patterns.builder.address;

public class AddressBuilder {
    private String street;
    private String number;
    private String cityCode;
    private String city;
    private String country;

    public AddressBuilder setStreet(String street) {
        this.street = street;
        return this;
    }

    public AddressBuilder setNumber(String number) {
        this.number = number;
        return this;
    }

    public AddressBuilder setCityCode(String cityCode) {
        this.cityCode = cityCode;
        return this;
    }

    public AddressBuilder setCity(String city) {
        this.city = city;
        return this;
    }

    public AddressBuilder setCountry(String country) {
        this.country = country;
        return this;
    }



    public AddressBuilder setCityCode(int number) {
        return setCityCode(""+number);
    }

    public AddressBuilder setNumber(int i) {
        return setNumber(""+i);
    }
}