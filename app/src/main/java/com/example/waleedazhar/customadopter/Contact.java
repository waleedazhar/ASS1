package com.example.waleedazhar.customadopter;

/**
 * Created by Waleed Azhar on 10/3/2017.
 */

public class Contact {
    private String name;
    private String Num;    //phone number
    private String gender;

    public Contact(String name, String num, String gender) {
        this.name = name;
        this.Num = num;
        this.gender = gender;
    }

    @Override
    public String toString() {
        return "Contact{" +
                "name='" + name + '\'' +
                ", Num='" + Num + '\'' +
                ", gender='" + gender + '\'' +
                '}';
    }

    public String getName() {
        return name;
    }

    public String getNum() {
        return Num;
    }

    public String getGender() {
        return gender;
    }
}
