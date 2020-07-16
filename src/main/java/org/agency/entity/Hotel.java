package org.agency.entity;

import javax.persistence.*;
import javax.validation.constraints.NotNull;
import javax.validation.constraints.Pattern;
import java.util.List;

@Entity
public class Hotel {
    @Id
    @GeneratedValue(strategy = GenerationType.IDENTITY)
    @Column
    private int id;

    @NotNull(message = "Please provide a valid hotel name!")
    @Column(name = "name")
    private String name;

    @NotNull(message = "Please provide a valid country!")
    @Pattern(regexp = "[\\-a-zA-Z\\s]+", message = "Please provide a valid country!")
    @Column(name = "country")
    private String country;

    @NotNull(message = "Please provide a valid city!")
    @Pattern(regexp = "[\\-a-zA-Z\\s]+", message = "Please provide a valid city!")
    @Column(name = "city")
    private String city;

    @OneToMany(mappedBy = "hotel",
            cascade = {CascadeType.DETACH, CascadeType.MERGE, CascadeType.PERSIST, CascadeType.REFRESH})
    private List<Room> rooms;

    public Hotel() {
    }

    public int getId() {
        return id;
    }

    public void setId(int id) {
        this.id = id;
    }

    public String getName() {
        return name;
    }

    public void setName(String name) {
        this.name = name;
    }

    public String getCountry() {
        return country;
    }

    public void setCountry(String country) {
        this.country = country;
    }

    public String getCity() {
        return city;
    }

    public void setCity(String city) {
        this.city = city;
    }

    public List<Room> getRooms() {
        return rooms;
    }

    public void setRooms(List<Room> rooms) {
        this.rooms = rooms;
    }

    @Override
    public String toString() {
        return "Hotel{" +
                "id=" + id +
                ", name='" + name + '\'' +
                ", country='" + country + '\'' +
                ", city='" + city + '\'' +
                ", rooms=" + rooms +
                '}';
    }
}
