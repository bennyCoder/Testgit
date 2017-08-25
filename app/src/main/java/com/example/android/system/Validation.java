package com.example.android.system;


import android.text.TextUtils;
import android.widget.EditText;
import android.widget.TextView;
import android.widget.Toast;

import java.util.regex.Pattern;
public class Validation {

    private TextView textName;
    private TextView textSurname;
    private TextView textProvence;
    private TextView textCity;
    private TextView textAdress;
    private TextView textCellNo;

        // Regular Expression
        // you can change the expression based on your need
        private static final String EMAIL_REGEX = "^[_A-Za-z0-9-\\+]+(\\.[_A-Za-z0-9-]+)*@[A-Za-z0-9-]+(\\.[A-Za-z0-9]+)*(\\.[A-Za-z]{2,})$";
        private static final String PHONE_REGEX = "\\d{3}-\\d{7}";

        // Error Messages
        private static final String REQUIRED_MSG = "required";
        private static final String EMAIL_MSG = "invalid email";
        private static final String PHONE_MSG = "###-#######";

    private String valid_name, valid_surname, valid_email, valid_streetname,
            valid_city, valid_areaname, valid_unitname, valid_phone,
            valid_cell;


        // return true if the input field is valid, based on the parameter passed


// ==================================================validations==========================================//

    public boolean Is_Valid_Name(String vname) {

    if(vname.isEmpty())
    {
        return false;
    }

        if(vname.matches("[0-9]+"))
        {
            return  false;

        }
 else
        {


            return true;
        }


    }


    public boolean vili_address(String vAddress){
        if(vAddress.isEmpty())
        {
            return false;
        }

        if(vAddress.matches("[0-9]+"))
        {
            return  false;

        }
        else
        {


            return true;
        }


    }

    public boolean Valid_City(String city) {



        if(city.isEmpty())
        {
            return false;
        }

        if(city.matches("[0-9]+"))
        {
            return  false;

        }
        else
        {


            return true;
        }

    }

    public boolean Valid_Cell(String vcell){

        if (vcell.length() <= 0|| vcell.length() <10) {
            return false;
        }

        return true;


    }

    public boolean vali_Provence(String vprovence) {
        if(vprovence.isEmpty())
        {
            return false;
        }

        if(vprovence.matches("[0-9]+"))
        {
            return  false;

        }
        else
        {

            return true;
        }


        }


    public boolean Is_Valid_Surname(String vsurname) {

        if(vsurname.isEmpty())
        {
            return false;
        }

        if(vsurname.matches("[0-9]+"))
        {
            return  false;

        }
        else
        {

            return true;
        }


    }


}
