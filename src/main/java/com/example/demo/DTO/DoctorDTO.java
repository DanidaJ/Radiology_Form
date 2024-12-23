package com.example.demo.DTO;

public class DoctorDTO {
    private int id;
    private String fName;
    private String sName;
    private String email;


    public DoctorDTO(int id, String fName, String sName, String email) {
        this.id = id;
        this.fName = fName;
        this.sName = sName;
        this.email = email;

    }

    public DoctorDTO() {
    }


    public int getId() {
        return id;
    }

    public void setId(int id) {
        this.id = id;
    }


    public String getfName() {
        return fName;
    }

    public void setfName(String fName) {
        this.fName = fName;
    }

    public String getsName() {
        return sName;
    }

    public void setsName(String sName) {
        this.sName = sName;
    }

    public String getEmail() {
        return email;
    }

    public void setEmail(String email) {
        this.email = email;
    }




    @Override
    public String toString() {
        return "DoctorDTO{" +
                "id=" + id +
                ", fName='" + fName + '\'' +
                ", sName='" + sName + '\'' +
                ", email='" + email + '\'' +
                '}';
    }
}


