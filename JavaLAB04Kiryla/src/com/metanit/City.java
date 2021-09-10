package com.metanit;

class City{

    private String city;

    City(String city) {
        this.city = city;
    }

    void setCity(String city) {
        this.city = city;
    }

    String getCity() {
        return city;
    }

    @Override
    public String toString() {
        return "city='" + city + "'; ";
    }

    public boolean equals(City cities) {
        if (this == cities) return true;
        if (cities == null || getClass() != cities.getClass()) return false;

        City that = (City) cities;

        return city.equals(that.city);
    }

    @Override
    public int hashCode() {
        int result = city.hashCode();
        result = 31 * result;
        return result;
    }

    static City addCity() {
        City city = new City("");
        System.out.print("Введите город: ");
        city.city = Country.strInput();
        return city;
    }
}