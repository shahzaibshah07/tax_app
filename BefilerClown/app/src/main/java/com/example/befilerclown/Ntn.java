package com.example.befilerclown;


public class Ntn {

    String name;
    String cnic;
    String dob;
    String occupation;
    String Nationality;
    String Residentianl;
   public Ntn( String name, String cnic, String dob, String occupation,String Nationality,String Residentianl){
       this.name=name;
       this.cnic=cnic;
       this.dob=dob;
       this.occupation=occupation;
       this.Nationality=Nationality;
       this.Residentianl=Residentianl;
   }

    public String getNationality() {
        return Nationality;
    }

    public void setNationality(String nationality) {
        Nationality = nationality;
    }

    public String getResidentianl() {
        return Residentianl;
    }

    public void setResidentianl(String residentianl) {
        Residentianl = residentianl;
    }

    public String getName() {
        return name;
    }

    public void setName(String name) {
        this.name = name;
    }

    public String getCnic() {
        return cnic;
    }

    public void setCnic(String cnic) {
        this.cnic = cnic;
    }

    public String getDob() {
        return dob;
    }

    public void setDob(String dob) {
        this.dob = dob;
    }

    public String getOccupation() {
        return occupation;
    }

    public void setOccupation(String occupation) {
        this.occupation = occupation;
    }
}