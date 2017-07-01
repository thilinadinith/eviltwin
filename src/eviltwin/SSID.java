/*
 * To change this license header, choose License Headers in Project Properties.
 * To change this template file, choose Tools | Templates
 * and open the template in the editor.
 */
package eviltwin;

import java.util.ArrayList;

/**
 *
 * @author thilinafo
 */
public class SSID {

     String SSIDname;
     ArrayList <BSSID> listofBSSID ;
            
 

    public SSID(String SSIDname, ArrayList<BSSID> listofBSSID) {
        this.SSIDname = SSIDname;
        this.listofBSSID = new ArrayList<BSSID>();
    }
    
    
    
}
