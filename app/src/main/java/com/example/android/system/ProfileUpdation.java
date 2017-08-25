package com.example.android.system;

public class ProfileUpdation {
    private String cName;
    private String cSurname;
    private String cAddress;
    private String cCity;
    private String cProvence;
    private String cGender;
    private String particitantsType;
    private String cMale;
    private String cfemale;
    private String cType;
    private String cDonar;
    private  String cRecipient;
    private String cCellPhone;


    public ProfileUpdation(){


    }

    public ProfileUpdation(String cName,String cSurname,String cAddress,String cCity,String cProvence,String cCellPhone,String cGender,String particitantsType)
    {
        this.cName = cName;
        this.cSurname = cSurname;
        this.cAddress = cAddress;
        this.cCity = cCity;
        this.cProvence = cProvence;
        this.cCellPhone = cCellPhone;

        this.cGender = cGender;
        this.particitantsType = particitantsType;
    }
     public  String getcName( ){return cName;}

    public void setcName(String cName){this.cName = cName;}


    public  String getcSurname( ){return cSurname;}
    public void setcSurname(String cSurname){this.cSurname= cSurname;}

    public  String getcAddress( ){return cAddress;}
    public void setcAddress(String cSurname){this.cAddress= cAddress;}

    public  String getcCity( ){return cCity;}
    public void setcCity(String cCity){this.cCity= cCity;}


    public  String getcProvence( ){return cProvence;}
    public void setcProvence(String provence){this.cProvence= cProvence;}

    public  String getcCellPhone( ){return cCellPhone;}
    public void setcCellPhone(String cCellPhone){this.cCellPhone= cCellPhone;}

    public String getcGender(){return cGender;};

    public void setcGender(String cGender){this.cGender = cGender;}

    public String getParticitantsType(){return particitantsType;}
    public  void  setParticitantsType(String particitantsType){this.particitantsType = particitantsType;}


}
