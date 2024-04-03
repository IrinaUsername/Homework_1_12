package oaosugar;

import java.io.*;

public class Car implements Externalizable {
    private String mark;
    private int year;
    String registrNumber;

    private String colour;
    private int countOfIncidents;

    public Car(String mark, int year, String registrNumber,String colour, int countOfIncidents){
        this.mark = mark;
        this.year = year;
        this.registrNumber = registrNumber;
        this.colour = colour;
        this.countOfIncidents = countOfIncidents;
    }

    public String getColour() {
        return colour;
    }

    public void setColour(String colour) {
        this.colour = colour;
    }

    public int getCountOfIncidents() {
        return countOfIncidents;
    }

    public void setCountOfIncidents(int countOfIncidents) {
        this.countOfIncidents = countOfIncidents;
    }

    /**
     * @return the mark
     */
    public String getMark() {
        return mark;
    }

    /**
     * @return the registrNumber
     */
    public String getRegistrNumber() {
        return registrNumber;
    }

    /**
     * @param registrNumber the registrNumber to set
     */
    public void setRegistrNumber(String registrNumber) {
        this.registrNumber = registrNumber;
    }

    /**
     * @return the year
     */
    public int getYear() {
        return year;
    }

    public Car(){}


    @Override
    public void writeExternal(ObjectOutput out) throws IOException {
        out.writeObject(this.getMark());
        out.writeObject(this.getYear());
        out.writeObject(this.getRegistrNumber());
        out.writeObject(this.getColour());
        out.writeObject(this.getCountOfIncidents());

    }

    @Override
    public void readExternal(ObjectInput in) throws IOException, ClassNotFoundException {
        this.mark=(String)in.readObject();
        this.year=(Integer)in.readObject();
        this.registrNumber=(String)in.readObject();
        this.colour=(String)in.readObject();
        this.countOfIncidents=(Integer)in.readObject();

    }
}

