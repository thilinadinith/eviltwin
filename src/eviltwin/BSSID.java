/*
 * To change this license header, choose License Headers in Project Properties.
 * To change this template file, choose Tools | Templates
 * and open the template in the editor.
 */
package eviltwin;

/**
 *
 * @author thilinafo
 */
public class BSSID {
    
    String BSSID;
    String Encryption;
    String Authentication;
    String Networktype;
    String CurrentSignal;
    String RadioType;
    String Channel;
    String BasicRates;
    String otherRates;
    
 

    public BSSID(String BSSID, String Encryption, String Authentication, String Networktype, String CurrentSignal, String RadioType, String Channel, String BasicRates, String otherRates) {
        this.BSSID = BSSID;
        this.Encryption = Encryption;
        this.Authentication = Authentication;
        this.Networktype = Networktype;
        this.CurrentSignal = CurrentSignal;
        this.RadioType = RadioType;
        this.Channel = Channel;
        this.BasicRates = BasicRates;
        this.otherRates = otherRates;
    }
    
    
}
