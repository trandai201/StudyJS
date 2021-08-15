/*
 * To change this license header, choose License Headers in Project Properties.
 * To change this template file, choose Tools | Templates
 * and open the template in the editor.
 */

/**
 *
 * @author Dai
 */
public class UserFull {
    private String nameString,ngaySinhString,soDTString,dicChiString,emailString;

    public UserFull(String nameString, String ngaySinhString, String soDTString, String dicChiString, String emailString) {
        this.nameString = nameString;
        this.ngaySinhString = ngaySinhString;
        this.soDTString = soDTString;
        this.dicChiString = dicChiString;
        this.emailString = emailString;
    }

    public String getNameString() {
        return nameString;
    }

    public void setNameString(String nameString) {
        this.nameString = nameString;
    }

    public String getNgaySinhString() {
        return ngaySinhString;
    }

    public void setNgaySinhString(String ngaySinhString) {
        this.ngaySinhString = ngaySinhString;
    }

    public String getSoDTString() {
        return soDTString;
    }

    public void setSoDTString(String soDTString) {
        this.soDTString = soDTString;
    }

    public String getDicChiString() {
        return dicChiString;
    }

    public void setDicChiString(String dicChiString) {
        this.dicChiString = dicChiString;
    }

    public String getEmailString() {
        return emailString;
    }

    public void setEmailString(String emailString) {
        this.emailString = emailString;
    }
    
    
}
