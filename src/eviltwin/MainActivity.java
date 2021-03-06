/*
 * To change this license header, choose License Headers in Project Properties.
 * To change this template file, choose Tools | Templates
 * and open the template in the editor.
 */
package eviltwin;

import java.awt.List;
import java.io.BufferedReader;
import java.io.BufferedWriter;
import java.io.FileWriter;
import java.io.IOException;
import java.io.InputStream;
import java.io.InputStreamReader;
import java.io.Reader;
import java.sql.Connection;

import java.sql.DriverManager;
import java.sql.ResultSet;
import java.sql.SQLException;
import java.sql.Statement;
import java.text.SimpleDateFormat;
import java.util.ArrayList;
import java.util.Date;
import java.util.HashMap;
import java.util.logging.Level;
import java.util.logging.Logger;
import javax.print.attribute.HashAttributeSet;
import javax.swing.JOptionPane;
import javax.swing.JTable;
import javax.swing.table.DefaultTableModel;
import javax.swing.table.TableModel;
import org.json.JSONArray;
import org.json.JSONObject;

/**
 *
 * @author thilinafo
 */
public class MainActivity extends javax.swing.JFrame {

    /**
     * Creates new form MainActivity
     */
    String Only_Needed_Info_About_BSSIDs[] = null;
    String Full_datasetofWIFI[] = null;
    HashMap<String, SSID> SSIDmap = new HashMap<String, SSID>();
    DefaultTableModel tableModel;
    Connection conn = null;
    Statement stmt = null;
    Date time1, time2, time3, time4;
    String timestr1, timestr2, timestr3, timestr4;
    SimpleDateFormat format = new SimpleDateFormat("HH:mm:ss");
    private static final String FILENAME = ".Profile.xml";

    public MainActivity() {

        initComponents();
        tableModel = new DefaultTableModel();
        tableModel.setColumnIdentifiers(new String[]{
            "SSID", "BSSID", "Authentication", "Security", "AP mode ", "Signal Strength"});

        jTable1.setModel(tableModel);
        //tableModel = (DefaultTableModel) jTable1.getModel();
        int rowCount = tableModel.getRowCount();
        for (int ig = rowCount - 1; ig >= 0; ig--) {
            tableModel.removeRow(ig);
        }
        try {

            conn = DriverManager.
                    getConnection("jdbc:h2:./test", "admin", "");

        } catch (SQLException ex) {
            Logger.getLogger(MainActivity.class.getName()).log(Level.SEVERE, null, ex);
        }
    }

    /**
     * This method is called from within the constructor to initialize the form.
     * WARNING: Do NOT modify this code. The content of this method is always
     * regenerated by the Form Editor.
     */
    @SuppressWarnings("unchecked")
    // <editor-fold defaultstate="collapsed" desc="Generated Code">//GEN-BEGIN:initComponents
    private void initComponents() {

        jFrame1 = new javax.swing.JFrame();
        jFrame2 = new javax.swing.JFrame();
        jButton1 = new javax.swing.JButton();
        jScrollPane1 = new javax.swing.JScrollPane();
        jTable1 = new javax.swing.JTable();
        jButton2 = new javax.swing.JButton();
        jButton3 = new javax.swing.JButton();

        javax.swing.GroupLayout jFrame1Layout = new javax.swing.GroupLayout(jFrame1.getContentPane());
        jFrame1.getContentPane().setLayout(jFrame1Layout);
        jFrame1Layout.setHorizontalGroup(
            jFrame1Layout.createParallelGroup(javax.swing.GroupLayout.Alignment.LEADING)
            .addGap(0, 400, Short.MAX_VALUE)
        );
        jFrame1Layout.setVerticalGroup(
            jFrame1Layout.createParallelGroup(javax.swing.GroupLayout.Alignment.LEADING)
            .addGap(0, 300, Short.MAX_VALUE)
        );

        javax.swing.GroupLayout jFrame2Layout = new javax.swing.GroupLayout(jFrame2.getContentPane());
        jFrame2.getContentPane().setLayout(jFrame2Layout);
        jFrame2Layout.setHorizontalGroup(
            jFrame2Layout.createParallelGroup(javax.swing.GroupLayout.Alignment.LEADING)
            .addGap(0, 400, Short.MAX_VALUE)
        );
        jFrame2Layout.setVerticalGroup(
            jFrame2Layout.createParallelGroup(javax.swing.GroupLayout.Alignment.LEADING)
            .addGap(0, 300, Short.MAX_VALUE)
        );

        setDefaultCloseOperation(javax.swing.WindowConstants.EXIT_ON_CLOSE);

        jButton1.setText("Search");
        jButton1.addActionListener(new java.awt.event.ActionListener() {
            public void actionPerformed(java.awt.event.ActionEvent evt) {
                jButton1ActionPerformed(evt);
            }
        });

        jTable1.setModel(new javax.swing.table.DefaultTableModel(
            new Object [][] {
                {null, null, null, null}
            },
            new String [] {
                "Title 1", "Title 2", "Title 3", "Title 4"
            }
        ));
        jScrollPane1.setViewportView(jTable1);

        jButton2.setText("connect");
        jButton2.addActionListener(new java.awt.event.ActionListener() {
            public void actionPerformed(java.awt.event.ActionEvent evt) {
                jButton2ActionPerformed(evt);
            }
        });

        jButton3.setText("Sync Data");
        jButton3.setToolTipText("");
        jButton3.addActionListener(new java.awt.event.ActionListener() {
            public void actionPerformed(java.awt.event.ActionEvent evt) {
                jButton3ActionPerformed(evt);
            }
        });

        javax.swing.GroupLayout layout = new javax.swing.GroupLayout(getContentPane());
        getContentPane().setLayout(layout);
        layout.setHorizontalGroup(
            layout.createParallelGroup(javax.swing.GroupLayout.Alignment.LEADING)
            .addGroup(javax.swing.GroupLayout.Alignment.TRAILING, layout.createSequentialGroup()
                .addContainerGap()
                .addGroup(layout.createParallelGroup(javax.swing.GroupLayout.Alignment.TRAILING)
                    .addComponent(jScrollPane1, javax.swing.GroupLayout.DEFAULT_SIZE, 901, Short.MAX_VALUE)
                    .addGroup(layout.createSequentialGroup()
                        .addGap(0, 0, Short.MAX_VALUE)
                        .addComponent(jButton1, javax.swing.GroupLayout.PREFERRED_SIZE, 179, javax.swing.GroupLayout.PREFERRED_SIZE)))
                .addGap(85, 85, 85))
            .addGroup(javax.swing.GroupLayout.Alignment.TRAILING, layout.createSequentialGroup()
                .addContainerGap(javax.swing.GroupLayout.DEFAULT_SIZE, Short.MAX_VALUE)
                .addComponent(jButton3)
                .addGap(18, 18, 18)
                .addComponent(jButton2)
                .addGap(114, 114, 114))
        );
        layout.setVerticalGroup(
            layout.createParallelGroup(javax.swing.GroupLayout.Alignment.LEADING)
            .addGroup(layout.createSequentialGroup()
                .addGap(13, 13, 13)
                .addComponent(jButton1, javax.swing.GroupLayout.PREFERRED_SIZE, 56, javax.swing.GroupLayout.PREFERRED_SIZE)
                .addPreferredGap(javax.swing.LayoutStyle.ComponentPlacement.RELATED)
                .addComponent(jScrollPane1, javax.swing.GroupLayout.PREFERRED_SIZE, 118, javax.swing.GroupLayout.PREFERRED_SIZE)
                .addGap(29, 29, 29)
                .addGroup(layout.createParallelGroup(javax.swing.GroupLayout.Alignment.BASELINE)
                    .addComponent(jButton2)
                    .addComponent(jButton3))
                .addContainerGap(339, Short.MAX_VALUE))
        );

        pack();
    }// </editor-fold>//GEN-END:initComponents

    private void jButton1ActionPerformed(java.awt.event.ActionEvent evt) {//GEN-FIRST:event_jButton1ActionPerformed

        time1 = new Date();
        timestr1 = format.format(time1);

        // TODO add your handling code here:
        Process p = null;
        Runtime r = Runtime.getRuntime();
        BSSID BSSIDobj;

        int rowCount = tableModel.getRowCount();
        for (int ig = rowCount - 1; ig >= 0; ig--) {
            tableModel.removeRow(ig);
        }

        try {

            p = p = r.exec("netsh wlan disconnect");
            p.getOutputStream().close();

            p = p = r.exec("netsh wlan show interfaces");
            p.getOutputStream().close();
            InputStream processStdOutput = p.getInputStream();
            Reader bbr = new InputStreamReader(processStdOutput);
            BufferedReader br = new BufferedReader(bbr);
            String line;
            String interfacedata = "";
            while ((line = br.readLine()) != null) {
                // the output is

                interfacedata = interfacedata + " " + line;

            }

            String interfaceData[] = interfacedata.split(" Name                   : ");
            String nameofinterface[] = interfaceData[1].split("     Description");
            p = p = r.exec("netsh wlan disconnect");
            p = p = r.exec("netsh interface set interface name=\"" + nameofinterface[0] + "\" admin=disabled");
            p.getOutputStream().close();
            processStdOutput = p.getInputStream();
            bbr = new InputStreamReader(processStdOutput);
            br = new BufferedReader(bbr);
            String exd = "";
            while ((line = br.readLine()) != null) {
                // the output
                exd = exd + " " + line;

            }
//            p = p = r.exec("netsh wlan disconnect");
//            p.getOutputStream().close();
            p = p = r.exec("netsh interface set interface name=\"" + nameofinterface[0] + "\" admin=enable");
            p.getOutputStream().close();

            Thread.sleep(4000);

            p = p = r.exec("netsh wlan disconnect");

            p = p = r.exec("netsh wlan show network mode=bssid");
            p.getOutputStream().close(); // close stdin of child

            processStdOutput = p.getInputStream();
            bbr = new InputStreamReader(processStdOutput);
            br = new BufferedReader(bbr);

            String AllLines = "";
            while ((line = br.readLine()) != null) {
                // the output is

                AllLines = AllLines + " " + line;

            }

            String SSIDinfo[] = AllLines.split(" SSID ");

            int FULLSETLENGTH = 0;
            for (int l = 1; l < SSIDinfo.length; l++) {
                if (SSIDinfo[l].contains("BSSID 2")) {
                    FULLSETLENGTH += 1;
                }
            }
            Full_datasetofWIFI = new String[FULLSETLENGTH];

            for (int i = 1; i < SSIDinfo.length; i++) {

                int start3 = SSIDinfo[i].indexOf("Network type");
                String currentSSID = SSIDinfo[i].substring(0, start3);
                String ssidName = currentSSID.substring(3);
                ssidName = ssidName.replaceAll("\\s+$", "");
                ssidName = ssidName.replaceAll("^\\s+", "");
                currentSSID = ssidName;
                int start9 = SSIDinfo[i].indexOf("Network type");
                String Networktype = SSIDinfo[i].substring(start9 + 26, start9 + 41);

                int start99 = SSIDinfo[i].indexOf("Authentication");
                String Authentication = SSIDinfo[i].substring(start99 + 26, start99 + 43);

                int start999 = SSIDinfo[i].indexOf("Encryption");
                String Encryption = SSIDinfo[i].substring(start999 + 26, start999 + 32);

                if (Encryption.equals("None  ")) {

                    try {
                        p = p = r.exec("netsh wlan disconnect");
                        p = p = r.exec("netsh wlan delete profile name=\"" + ssidName + "\"");

                        p.getOutputStream().close();
                    } catch (IOException ex) {
                        System.out.println("error in process creation in loop" + ex);
                    }

                }

                // Network type            : Infrastructure
                // Authentication          : WPA2-Personal
                // Encryption              : CCMP
                SSID SSIDobj = new SSID(ssidName, null);
                if (SSIDinfo[i].contains("BSSID 2")) {
                    if (Encryption.equals("None  ")) {

                        System.out.println(SSIDinfo[i]);
                        String SuspiciousString = SSIDinfo[i];

                        String All_BSSIDs[] = SuspiciousString.split("Other rates");
                        Only_Needed_Info_About_BSSIDs = new String[All_BSSIDs.length - 1];
                        for (int k = 0; k < All_BSSIDs.length - 1; k++) {

                            String EACH_BSSID = All_BSSIDs[k];

                            int start = EACH_BSSID.indexOf("BSSID");
                            String currentBSSID = EACH_BSSID.substring(start + 26, start + 43);

                            int start2 = EACH_BSSID.indexOf("Signal");
                            String CurrentSignal = EACH_BSSID.substring(start2 + 21, start2 + 25);

                            int start4 = EACH_BSSID.indexOf("Radio type");
                            String RadioType = EACH_BSSID.substring(start4 + 21, start4 + 31);

                            int start5 = EACH_BSSID.indexOf("Channel");
                            String Channel = EACH_BSSID.substring(start5 + 15, start5 + 22);

                            int start6 = EACH_BSSID.indexOf("Basic rates");
                            String BasicRates = EACH_BSSID.substring(start6 + 12, start6 + 32);

                            int start7 = EACH_BSSID.indexOf("Other rates");
                            String otherRates = EACH_BSSID.substring(start7 + 12, start7 + 32);

                            BSSIDobj = new BSSID(currentBSSID, Encryption, Authentication, Networktype, CurrentSignal, RadioType, Channel, BasicRates, otherRates);
                            SSIDobj.listofBSSID.add(BSSIDobj);
                            tableModel.addRow(new Object[]{currentSSID, BSSIDobj.BSSID, BSSIDobj.Encryption, BSSIDobj.Authentication, BSSIDobj.Networktype, BSSIDobj.CurrentSignal, BSSIDobj.RadioType, BSSIDobj.Channel, BSSIDobj.BasicRates, BSSIDobj.otherRates});
                            System.out.println(currentBSSID + "," + Encryption + "," + Authentication + "," + Networktype + "," + CurrentSignal + "," + RadioType + "," + Channel + "," + BasicRates + "," + otherRates);
                        }

                    //               if (Only_Needed_Info_About_BSSIDs.length != 0&& showstate != true) {
                        //                   showstate = true;
                        //
                        //                        int mc = JOptionPane.WARNING_MESSAGE;
                        //                        JOptionPane.showMessageDialog(null, "Found SSID duplication on same BSSID please access Wi-fi with caution", "EvilTwwin - Found", mc);
                        //                        System.out.println("Found");
                        //                    }
                        SSIDmap.put(ssidName, SSIDobj);
                    }
                }

                time2 = new Date();
                timestr2 = format.format(time2);

            }

        } catch (IOException ex) {
            System.out.println("error in process creation" + ex);
        } catch (InterruptedException ex) {
            Logger.getLogger(MainActivity.class.getName()).log(Level.SEVERE, null, ex);
        }

        long totaltime = (time2.getTime() - time1.getTime());

        float xx = totaltime / 1000f;
        System.out.println("  time spend to  search connection :" + xx);


    }//GEN-LAST:event_jButton1ActionPerformed

    private void jButton2ActionPerformed(java.awt.event.ActionEvent evt) {//GEN-FIRST:event_jButton2ActionPerformed
        // TODO add your handling code here:
        int row = jTable1.getSelectedRow();
        time3 = new Date();
        timestr3 = format.format(time3);
        boolean threaddetected = false;
        Process p = null;
        Runtime r = Runtime.getRuntime();
        ArrayList dbbssids = new ArrayList<String>();
        BSSID tempbssid = new BSSID(null, null, null, null, null, null, null, null, null);
        if (row == -1) {
            int mc = JOptionPane.WARNING_MESSAGE;
            JOptionPane.showMessageDialog(null, "No SSID Selected ", "SSID Selection", mc);
            return;
        }
        String selectedSSID = (String) jTable1.getValueAt(row, 0); //ssid
        String selectedBSSID = (String) jTable1.getValueAt(row, 1); //bssid

        SSID ssiddata = SSIDmap.get(selectedSSID);
        ArrayList<BSSID> temparr = ssiddata.listofBSSID;
        String query = "Select bssid  from ACCESS_POINTS where ssid= '" + selectedSSID + "'";
        try {
            stmt = conn.createStatement();
            ResultSet rs = stmt.executeQuery(query);
            while (rs.next()) {
                String dbBSSID = rs.getString("BSSID");
                dbbssids.add(dbBSSID);
//           tempbssid.BSSID=dbBSSID;
//                if(temparr.contains(tempbssid)){
//                  int mc = JOptionPane.WARNING_MESSAGE;
//            JOptionPane.showMessageDialog(null, "here ", "SSID Selection", mc);
//                }else{
//                
//                }
            }
        } catch (SQLException ex) {
            Logger.getLogger(MainActivity.class.getName()).log(Level.SEVERE, null, ex);
        }

        for (BSSID e : temparr) {
            if (!dbbssids.contains(e.BSSID)) {
                threaddetected = true;
                int mc = JOptionPane.WARNING_MESSAGE;
                JOptionPane.showMessageDialog(null, "Thread Detected", "SSID Selection", mc);
                return;

            }

        }
        if (!threaddetected) {

            BufferedWriter bw = null;
            FileWriter fw = null;

            try {

                String content = "<?xml version=\"1.0\"?>\n"
                        + "<WLANProfile xmlns=\"http://www.microsoft.com/networking/WLAN/profile/v1\">\n"
                        + "	<name>" + selectedSSID + "</name>\n"
                        + "	<SSIDConfig>\n"
                        + "		<SSID>\n"
                        + "		\n"
                        + "			<name>" + selectedSSID + "</name>\n"
                        + "		</SSID>\n"
                        + "		<nonBroadcast>false</nonBroadcast>\n"
                        + "	</SSIDConfig>\n"
                        + "	<connectionType>ESS</connectionType>\n"
                        + "	<connectionMode>auto</connectionMode>\n"
                        + "	<MSM>\n"
                        + "		<security>\n"
                        + "			<authEncryption>\n"
                        + "				<authentication>open</authentication>\n"
                        + "				<encryption>none</encryption>\n"
                        + "				<useOneX>false</useOneX>\n"
                        + "			</authEncryption>\n"
                        + "			<keyIndex>0</keyIndex>\n"
                        + "		</security>\n"
                        + "	</MSM>\n"
                        + "</WLANProfile>";

                fw = new FileWriter(FILENAME);
                bw = new BufferedWriter(fw);
                bw.write(content);

                System.out.println("Done");
            } catch (Exception ex) {

            } finally {

                try {

                    if (bw != null) {
                        bw.close();
                    }

                    if (fw != null) {
                        fw.close();
                    }

                    try {
                        String xx = "netsh wlan add profile filename=\".Profile.xml\"";
                        p = p = r.exec(xx);
                        p.getOutputStream().close();
                        p = null;
                        r = Runtime.getRuntime();
                        String yy = "netsh wlan connect ssid=\"" + selectedSSID + "\" name=\"" + selectedSSID + "\"";
                        p = p = r.exec(yy);

                        p.getOutputStream().close();
                    } catch (IOException ex) {
                        Logger.getLogger(MainActivity.class.getName()).log(Level.SEVERE, null, ex);
                    }

                } catch (IOException ex) {

                    ex.printStackTrace();

                }
                time4 = new Date();
                timestr4 = format.format(time4);

                long totaltime = (time2.getTime() - time1.getTime()) + (time4.getTime() - time3.getTime());

                float xx = totaltime / 1000f;
                System.out.println(" total time spend to connection :" + xx);

            }

        }
    }//GEN-LAST:event_jButton2ActionPerformed

    private void jButton3ActionPerformed(java.awt.event.ActionEvent evt) {//GEN-FIRST:event_jButton3ActionPerformed
        // TODO add your handling code here:
        String updatedlist = "";
        boolean syncstat = false;
        ServerConnect sv = new ServerConnect();
        try {
            JSONObject obj = sv.sendingGetRequest();

            JSONArray array = obj.getJSONArray("records");
            String query = "truncate table ACCESS_POINTS ";
            stmt = conn.createStatement();
            stmt.execute(query);

            for (int i = 0; i < array.length(); i++) {
                String BSSID = array.getJSONObject(i).getString("BSSID");
                //String query = "Select *  from ACCESS_POINTS where bssid= '" + BSSID + "'";

                try {

//            ResultSet rs = stmt.executeQuery(query);
//            if(!rs.isBeforeFirst() ) {
                    String SSID = array.getJSONObject(i).getString("SSID");
                    query = "INSERT INTO ACCESS_POINTS (BSSID,SSID) VALUES(\'" + BSSID + "\',\'" + SSID + "\')";

                    stmt = conn.createStatement();
                    stmt.executeUpdate(query);
                    //  syncstat = true;
                    updatedlist += updatedlist + "[BSSID:" + BSSID + ",SSID:" + SSID + "] ";

//                }
//            }
                } catch (SQLException ex) {
                    Logger.getLogger(MainActivity.class.getName()).log(Level.SEVERE, null, ex);
                }

            }

        } catch (Exception ex) {
            Logger.getLogger(MainActivity.class.getName()).log(Level.SEVERE, null, ex);
        }

        if (syncstat) {
            int mc = JOptionPane.INFORMATION_MESSAGE;
            JOptionPane.showMessageDialog(null, "Added " + updatedlist + " as new entires", "Synced", mc);
        }
    }//GEN-LAST:event_jButton3ActionPerformed

    /**
     * @param args the command line arguments
     */
    public static void main(String args[]) {
        /* Set the Nimbus look and feel */
        //<editor-fold defaultstate="collapsed" desc=" Look and feel setting code (optional) ">
        /* If Nimbus (introduced in Java SE 6) is not available, stay with the default look and feel.
         * For details see http://download.oracle.com/javase/tutorial/uiswing/lookandfeel/plaf.html 
         */
        try {
            for (javax.swing.UIManager.LookAndFeelInfo info : javax.swing.UIManager.getInstalledLookAndFeels()) {
                if ("Nimbus".equals(info.getName())) {
                    javax.swing.UIManager.setLookAndFeel(info.getClassName());
                    break;

                }
            }
        } catch (ClassNotFoundException ex) {
            java.util.logging.Logger.getLogger(MainActivity.class
                    .getName()).log(java.util.logging.Level.SEVERE, null, ex);
        } catch (InstantiationException ex) {
            java.util.logging.Logger.getLogger(MainActivity.class
                    .getName()).log(java.util.logging.Level.SEVERE, null, ex);
        } catch (IllegalAccessException ex) {
            java.util.logging.Logger.getLogger(MainActivity.class
                    .getName()).log(java.util.logging.Level.SEVERE, null, ex);
        } catch (javax.swing.UnsupportedLookAndFeelException ex) {
            java.util.logging.Logger.getLogger(MainActivity.class
                    .getName()).log(java.util.logging.Level.SEVERE, null, ex);
        }
        //</editor-fold>

        /* Create and display the form */
        java.awt.EventQueue.invokeLater(new Runnable() {
            public void run() {
                new MainActivity().setVisible(true);
            }
        });
    }

    // Variables declaration - do not modify//GEN-BEGIN:variables
    private javax.swing.JButton jButton1;
    private javax.swing.JButton jButton2;
    private javax.swing.JButton jButton3;
    private javax.swing.JFrame jFrame1;
    private javax.swing.JFrame jFrame2;
    private javax.swing.JScrollPane jScrollPane1;
    private javax.swing.JTable jTable1;
    // End of variables declaration//GEN-END:variables
}
