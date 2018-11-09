package com.test.companyname.seg2505;

public class Service {
    private String name;
    private int hourRate;

    public Service(String name, int hourRate) throws IllegalArgumentException {
        if (name.isEmpty()) throw new IllegalArgumentException("Empty name");
        if (hourRate <= 0) throw new IllegalArgumentException("Invalid hour rate");
        this.name = name;
        this.hourRate = hourRate;
    }

    public String getName() {return name;}
    public int getHourRate() {return hourRate;}
}
