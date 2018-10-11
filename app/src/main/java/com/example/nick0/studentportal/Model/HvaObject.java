package com.example.nick0.studentportal.Model;

public class HvaObject {

    private String portalName;
    private String portalurl;

    public HvaObject(String portalName, String portalurl){

        this.portalName = portalName;
        this.portalurl = portalurl;
    }
    public String getPortalName() {
        return portalName;
    }
    public void setPortalName(String portalName) {
        this.portalName = portalName;
    }

    public String getPortalUrl(){
        return portalurl;
    }
    public void setPortalUrl(String portalurl){
        this.portalurl = portalurl;
    }
}
