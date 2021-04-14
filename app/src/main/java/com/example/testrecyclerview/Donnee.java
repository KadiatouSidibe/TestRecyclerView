package com.example.testrecyclerview;

public class Donnee {
    private String principal;
    private String auxiliaire;
    private  int image;

    Donnee (String text1, String text2,int img){
        principal = text1;
        auxiliaire = text2;
        image=img;
    }

    public String getPrincipal() {
        return principal;
    }

    public String getAuxiliaire() {
        return auxiliaire;
    }

    public int getImage() { return image; }

}
