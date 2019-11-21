package com.example.pidev.Entities;


import com.fasterxml.jackson.annotation.JsonManagedReference;

import javax.persistence.*;
import javax.validation.constraints.NotBlank;
import javax.validation.constraints.Size;
import java.util.ArrayList;
import java.util.Collection;
import java.util.List;
import java.util.Objects;

@Entity
public class User {
    @Id
    @Column(name="Id")
    @GeneratedValue(strategy = GenerationType.IDENTITY)
    private long Id;
    @NotBlank(message = "you should have a First Name")
    private String Prenom;
    @NotBlank(message = "you should have an Last Name")
    private String Nom;
    @NotBlank(message = "If you don't have an email you can't sign in")
    private String Email;
    @Size(min = 3, max = 50)
    private String Adresse;
    @NotBlank(message = "have you a profession???")
    private String profession;
    /*@OneToMany(cascade = CascadeType.ALL, mappedBy = "user", fetch = FetchType.LAZY)
    private List<Product> products;*/
    @OneToMany(mappedBy="user" ,cascade = CascadeType.ALL)
    @JsonManagedReference
    private Collection<Product> products = new ArrayList<>();


    public User(@NotBlank(message = "you should have a First Name") String prenom, @NotBlank(message = "you should have an Last Name") String nom, @NotBlank(message = "If you don't have an email you can't sign in") String email, @Size(min = 3, max = 50) String adresse, @NotBlank(message = "have you a profession???") String profession) {
        Prenom = prenom;
        Nom = nom;
        Email = email;
        Adresse = adresse;
        this.profession = profession;
    }

    public User() {
    }

    public long getId() {
        return Id;
    }

    public void setId(long id) {
        Id = id;
    }

    public String getPrenom() {
        return Prenom;
    }

    public void setPrenom(String prenom) {
        Prenom = prenom;
    }

    public String getNom() {
        return Nom;
    }

    public void setNom(String nom) {
        Nom = nom;
    }

    public String getEmail() {
        return Email;
    }

    public void setEmail(String email) {
        Email = email;
    }

    public String getAdresse() {
        return Adresse;
    }

    public void setAdresse(String adresse) {
        Adresse = adresse;
    }

    public String getProfession() {
        return profession;
    }

    public void setProfession(String profession) {
        this.profession = profession;
    }

    public Collection<Product> getProducts() {
        return products;
    }

    public void setProducts(Collection<Product> products) {
        this.products = products;
    }

    @Override
    public String toString() {
        return "User{" +
                "Id=" + Id +
                ", Prenom='" + Prenom + '\'' +
                ", Nom='" + Nom + '\'' +
                ", Email='" + Email + '\'' +
                ", Adresse='" + Adresse + '\'' +
                ", profession='" + profession + '\'' +
                '}';
    }

    @Override
    public boolean equals(Object o) {
        if (this == o) return true;
        if (!(o instanceof User)) return false;
        User user = (User) o;
        return getId() == user.getId() &&
                Objects.equals(getPrenom(), user.getPrenom()) &&
                Objects.equals(getNom(), user.getNom()) &&
                getEmail().equals(user.getEmail()) &&
                Objects.equals(getAdresse(), user.getAdresse()) &&
                Objects.equals(getProfession(), user.getProfession());
    }

    @Override
    public int hashCode() {
        return Objects.hash(getId(), getPrenom(), getNom(), getEmail(), getAdresse(), getProfession());
    }
}
