package com.kharitonov.spring_mvc.entity;

import javax.persistence.*;
import javax.validation.constraints.*;

@Entity
@Table(name = "city")
@NamedQueries({
        @NamedQuery(name = "City.findAll", query = "select c from City c")
})
public class City extends ProjectEntity {
    private int id;

    @Size(min = 2, max = 35, message = "Length must be between 2 and 35 characters")
    private String name;

    @Size(min = 3, max = 3, message = "Country code has 3 characters!")
    private String countryCode;

    @Size(max = 20, message = "Length must be 20 characters maximum")
    private String district;

    @Min(value = 1, message = "Population must be > 0")
    private int population;

    public City() {
    }

    public City(int id) {
        this.id = id;
    }

    @Id
    @GeneratedValue(strategy = GenerationType.IDENTITY)
    @Column(name = "ID")
    public int getId() {
        return id;
    }

    public void setId(int id) {
        this.id = id;
    }

    @Column(name = "Name")
    public String getName() {
        return name;
    }

    public void setName(String name) {
        this.name = name;
    }

    @Column(name = "CountryCode")
    public String getCountryCode() {
        return countryCode;
    }

    public void setCountryCode(String countryCode) {
        this.countryCode = countryCode;
    }

    @Column(name = "District")
    public String getDistrict() {
        return district;
    }

    public void setDistrict(String district) {
        this.district = district;
    }

    @Column(name = "Population")
    public int getPopulation() {
        return population;
    }

    public void setPopulation(int population) {
        this.population = population;
    }

    @Override
    public String toString() {
        final StringBuilder sb = new StringBuilder("City{");
        sb.append("id=").append(id);
        sb.append(", name='").append(name).append('\'');
        sb.append(", countryCode='").append(countryCode).append('\'');
        sb.append(", district='").append(district).append('\'');
        sb.append(", population=").append(population);
        sb.append('}');
        return sb.toString();
    }
}
