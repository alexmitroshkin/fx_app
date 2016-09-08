package model;

import java.io.Serializable;

/**
 * Created by alex on 15.08.2016.
 */
public class Client implements Serializable {
    private static final long serialVersionUID = 1L;

    private Integer clientId;
    private String name;
    private String address;
    private Integer age;
    private Integer weight;
    private Integer height;
    private Integer sex;
    private String phoneNumber;
    private String email;


    public Client(String name, String address, Integer age, Integer weight, Integer height, Integer sex, String phoneNumber, String email) {
        this.name = name;
        this.address = address;
        this.age = age;
        this.weight = weight;
        this.height = height;
        this.sex = sex;
        this.phoneNumber = phoneNumber;
        this.email = email;
    }

    public Client() {
    }

    public Integer getClientId() {
        return clientId;
    }

    public void setClientId(Integer clientId) {
        this.clientId = clientId;
    }

    public String getName() {
        return name;
    }

    public void setName(String name) {
        this.name = name;
    }

    public String getAddress() {
        return address;
    }

    public void setAddress(String address) {
        this.address = address;
    }

    public Integer getAge() {
        return age;
    }

    public void setAge(Integer age) {
        this.age = age;
    }

    public Integer getWeight() {
        return weight;
    }

    public void setWeight(Integer weight) {
        this.weight = weight;
    }

    public Integer getHeight() {
        return height;
    }

    public void setHeight(Integer height) {
        this.height = height;
    }

    public Integer getSex() {
        return sex;
    }

    public void setSex(Integer sex) {
        this.sex = sex;
    }

    public String getPhoneNumber() {
        return phoneNumber;
    }

    public void setPhoneNumber(String phoneNumber) {
        this.phoneNumber = phoneNumber;
    }

    public String getEmail() {
        return email;
    }

    public void setEmail(String email) {
        this.email = email;
    }
}
