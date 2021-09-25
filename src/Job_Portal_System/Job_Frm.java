/*
 * To change this license header, choose License Headers in Project Properties.
 * To change this template file, choose Tools | Templates
 * and open the template in the editor.
 */
package Job_Portal_System;

/**
 *
 * @author Biswajit Samanta
 */
import java.sql.*;
import javax.swing.JOptionPane;
import net.proteanit.sql.DbUtils;

public class Job_Frm extends javax.swing.JFrame {
    Connection cn =null;
    Statement st= null;
    ResultSet rs=null;
    PreparedStatement ps=null;
    String insert_sql="insert into job values(?,?,?,?,?,?,?,?,?,?)";
    String update_sql="update job set job_name=? where job_id=?";
    String delete_sql="delete from job where job_id=?";
    
    String sql="select Company_Id from company";

    /**
     * Creates new form job_Frm
     */
    public Job_Frm() {
        initComponents();
    }
    public void insertData()
    {
        try
        {
            ConnectionFactory con= new ConnectionFactory();
            cn=con.getConn();
            ps=cn.prepareStatement(insert_sql);
            ps.setString(1,jobid_txt.getText());
            ps.setString(2,jobname_txt.getText());
            ps.setString(3,jobtype_combo.getSelectedItem().toString());
            ps.setString(4,min_txt.getText());
            ps.setString(5,max_txt.getText());
            ps.setString(6,specializationarea_combo.getSelectedItem().toString());
            ps.setString(7,otherskill_txt.getText());
            ps.setString(8,dateofvalid_txt.getText());
            ps.setString(9,qualification_combo.getSelectedItem().toString());
            ps.setString(10,cid_combo.getSelectedItem().toString());
          ps.executeUpdate();
           JOptionPane.showMessageDialog(this,"INSERT SUCCESSFUL");
        }
        catch(SQLException se)
                {
                    se.printStackTrace();
                }
    }
    
    public void updateData()
    {
        try
        {
            ConnectionFactory con= new ConnectionFactory();
            cn=con.getConn();
            ps=cn.prepareStatement(update_sql);
            ps.setString(1,jobname_txt.getText());
            ps.setString(2,jobid_txt.getText());

          ps.executeUpdate();
        }
        catch(SQLException se)
                {
                    se.printStackTrace();
                }
    }
    
    public void deleteData()
    {
        try
        {
            ConnectionFactory con= new ConnectionFactory();
            cn=con.getConn();
            ps=cn.prepareStatement(delete_sql);
            ps.setString(1,jobid_txt.getText());

          ps.executeUpdate();
        }
        catch(SQLException se)
                {
                    se.printStackTrace();
                }
    }
    
   
       public void getId()
    {
        try
        {
            ConnectionFactory con= new ConnectionFactory();
            cn=con.getConn();
            st=cn.createStatement();
            rs=st.executeQuery(sql);
            while(rs.next()){
                cid_combo.addItem(rs.getString(1));
            }
            
        }
        catch(SQLException se)
                {
                    se.printStackTrace();
                }
    }
       public void getIdDetails(String Company_Id){
           String id="select * from company where Company_Id='"+Company_Id+"'";
            try
        {
            ConnectionFactory con= new ConnectionFactory();
            cn=con.getConn();
            st=cn.createStatement();
            rs=st.executeQuery(id);
         //  job_table.setModel(DbUtils.resultSetToTableModel(rs));
            
        }
        catch(SQLException se)
                {
                    se.printStackTrace();
                }
       }
    
    public void refreshData()
  {
      jobid_txt.setText("");
     jobname_txt.setText("");
     min_txt.setText("");
    max_txt.setText("");
    otherskill_txt.setText("");
    dateofvalid_txt.setText("");
    
  }

    /**
     * This method is called from within the constructor to initialize the form.
     * WARNING: Do NOT modify this code. The content of this method is always
     * regenerated by the Form Editor.
     */
    @SuppressWarnings("unchecked")
    // <editor-fold defaultstate="collapsed" desc="Generated Code">//GEN-BEGIN:initComponents
    private void initComponents() {

        jLabel1 = new javax.swing.JLabel();
        jLabel2 = new javax.swing.JLabel();
        jobid_txt = new javax.swing.JTextField();
        jLabel3 = new javax.swing.JLabel();
        jobname_txt = new javax.swing.JTextField();
        jLabel4 = new javax.swing.JLabel();
        jobtype_combo = new javax.swing.JComboBox<>();
        jLabel5 = new javax.swing.JLabel();
        jLabel7 = new javax.swing.JLabel();
        specializationarea_combo = new javax.swing.JComboBox<>();
        jLabel8 = new javax.swing.JLabel();
        otherskill_txt = new javax.swing.JTextField();
        jLabel9 = new javax.swing.JLabel();
        dateofvalid_txt = new javax.swing.JTextField();
        jLabel10 = new javax.swing.JLabel();
        qualification_combo = new javax.swing.JComboBox<>();
        add_button = new javax.swing.JButton();
        update_button = new javax.swing.JButton();
        delete_button = new javax.swing.JButton();
        jLabel6 = new javax.swing.JLabel();
        cid_combo = new javax.swing.JComboBox<>();
        min_txt = new javax.swing.JTextField();
        jLabel11 = new javax.swing.JLabel();
        max_txt = new javax.swing.JTextField();

        setDefaultCloseOperation(javax.swing.WindowConstants.DISPOSE_ON_CLOSE);
        addWindowListener(new java.awt.event.WindowAdapter() {
            public void windowOpened(java.awt.event.WindowEvent evt) {
                formWindowOpened(evt);
            }
        });

        jLabel1.setFont(new java.awt.Font("Tahoma", 1, 14)); // NOI18N
        jLabel1.setText("JOB");

        jLabel2.setText("JOB ID");

        jLabel3.setText("JOB NAME");

        jobname_txt.addActionListener(new java.awt.event.ActionListener() {
            public void actionPerformed(java.awt.event.ActionEvent evt) {
                jobname_txtActionPerformed(evt);
            }
        });

        jLabel4.setText("JOB TYPE");

        jobtype_combo.setModel(new javax.swing.DefaultComboBoxModel<>(new String[] { "Select", "Web Developer", "IT Technician", "Systems Analys", "Network Engineert", "Database Administrator", "Computer Scientist", "Software Engineer", "IT Director" }));

        jLabel5.setText("MINIMUM YEAR EXPERIENCE");

        jLabel7.setText("SPECIALIZATION AREA");

        specializationarea_combo.setModel(new javax.swing.DefaultComboBoxModel<>(new String[] { "Select", "Excellent listening skills", "Communication skills", "Handle Customers", "Ability to work as part of a team", "Self-driven & Pro-active" }));

        jLabel8.setText("OTHER SKILL AREA");

        jLabel9.setText("DATE OF VALID");

        jLabel10.setText("QUALIFICATION");

        qualification_combo.setModel(new javax.swing.DefaultComboBoxModel<>(new String[] { "Select", "Secondary", "Higher Secondary", "Graduate", "MBA", "BBA", "BCA", "BTECH" }));

        add_button.setText("ADD");
        add_button.addActionListener(new java.awt.event.ActionListener() {
            public void actionPerformed(java.awt.event.ActionEvent evt) {
                add_buttonActionPerformed(evt);
            }
        });

        update_button.setText("UPDATE");
        update_button.addActionListener(new java.awt.event.ActionListener() {
            public void actionPerformed(java.awt.event.ActionEvent evt) {
                update_buttonActionPerformed(evt);
            }
        });

        delete_button.setText("DELETE");
        delete_button.addActionListener(new java.awt.event.ActionListener() {
            public void actionPerformed(java.awt.event.ActionEvent evt) {
                delete_buttonActionPerformed(evt);
            }
        });

        jLabel6.setText("COMPANY ID");

        cid_combo.addPopupMenuListener(new javax.swing.event.PopupMenuListener() {
            public void popupMenuCanceled(javax.swing.event.PopupMenuEvent evt) {
            }
            public void popupMenuWillBecomeInvisible(javax.swing.event.PopupMenuEvent evt) {
                cid_comboPopupMenuWillBecomeInvisible(evt);
            }
            public void popupMenuWillBecomeVisible(javax.swing.event.PopupMenuEvent evt) {
            }
        });
        cid_combo.addActionListener(new java.awt.event.ActionListener() {
            public void actionPerformed(java.awt.event.ActionEvent evt) {
                cid_comboActionPerformed(evt);
            }
        });

        jLabel11.setText("MAXIMUM YEAR EXPERIENCE");

        javax.swing.GroupLayout layout = new javax.swing.GroupLayout(getContentPane());
        getContentPane().setLayout(layout);
        layout.setHorizontalGroup(
            layout.createParallelGroup(javax.swing.GroupLayout.Alignment.LEADING)
            .addGroup(javax.swing.GroupLayout.Alignment.TRAILING, layout.createSequentialGroup()
                .addGap(24, 24, 24)
                .addGroup(layout.createParallelGroup(javax.swing.GroupLayout.Alignment.LEADING)
                    .addGroup(layout.createSequentialGroup()
                        .addGroup(layout.createParallelGroup(javax.swing.GroupLayout.Alignment.TRAILING, false)
                            .addComponent(jLabel11, javax.swing.GroupLayout.Alignment.LEADING, javax.swing.GroupLayout.DEFAULT_SIZE, javax.swing.GroupLayout.DEFAULT_SIZE, Short.MAX_VALUE)
                            .addComponent(jLabel9, javax.swing.GroupLayout.Alignment.LEADING, javax.swing.GroupLayout.DEFAULT_SIZE, javax.swing.GroupLayout.DEFAULT_SIZE, Short.MAX_VALUE)
                            .addComponent(jLabel8, javax.swing.GroupLayout.Alignment.LEADING, javax.swing.GroupLayout.DEFAULT_SIZE, javax.swing.GroupLayout.DEFAULT_SIZE, Short.MAX_VALUE)
                            .addComponent(jLabel5, javax.swing.GroupLayout.Alignment.LEADING, javax.swing.GroupLayout.DEFAULT_SIZE, javax.swing.GroupLayout.DEFAULT_SIZE, Short.MAX_VALUE)
                            .addComponent(jLabel7, javax.swing.GroupLayout.Alignment.LEADING, javax.swing.GroupLayout.PREFERRED_SIZE, 145, javax.swing.GroupLayout.PREFERRED_SIZE))
                        .addGap(18, 18, 18)
                        .addGroup(layout.createParallelGroup(javax.swing.GroupLayout.Alignment.LEADING)
                            .addGroup(layout.createSequentialGroup()
                                .addComponent(cid_combo, javax.swing.GroupLayout.PREFERRED_SIZE, 160, javax.swing.GroupLayout.PREFERRED_SIZE)
                                .addGap(209, 374, Short.MAX_VALUE))
                            .addGroup(layout.createSequentialGroup()
                                .addGroup(layout.createParallelGroup(javax.swing.GroupLayout.Alignment.LEADING)
                                    .addComponent(jobtype_combo, javax.swing.GroupLayout.PREFERRED_SIZE, 275, javax.swing.GroupLayout.PREFERRED_SIZE)
                                    .addComponent(jobname_txt, javax.swing.GroupLayout.PREFERRED_SIZE, 294, javax.swing.GroupLayout.PREFERRED_SIZE)
                                    .addComponent(jobid_txt, javax.swing.GroupLayout.PREFERRED_SIZE, 170, javax.swing.GroupLayout.PREFERRED_SIZE)
                                    .addGroup(layout.createParallelGroup(javax.swing.GroupLayout.Alignment.TRAILING, false)
                                        .addComponent(specializationarea_combo, javax.swing.GroupLayout.Alignment.LEADING, 0, 252, Short.MAX_VALUE)
                                        .addComponent(otherskill_txt, javax.swing.GroupLayout.Alignment.LEADING)
                                        .addComponent(dateofvalid_txt, javax.swing.GroupLayout.Alignment.LEADING)
                                        .addComponent(max_txt, javax.swing.GroupLayout.Alignment.LEADING, javax.swing.GroupLayout.PREFERRED_SIZE, 108, javax.swing.GroupLayout.PREFERRED_SIZE))
                                    .addComponent(min_txt, javax.swing.GroupLayout.PREFERRED_SIZE, 108, javax.swing.GroupLayout.PREFERRED_SIZE)
                                    .addComponent(qualification_combo, javax.swing.GroupLayout.PREFERRED_SIZE, 203, javax.swing.GroupLayout.PREFERRED_SIZE))
                                .addGap(0, 0, Short.MAX_VALUE))))
                    .addGroup(layout.createSequentialGroup()
                        .addGroup(layout.createParallelGroup(javax.swing.GroupLayout.Alignment.LEADING)
                            .addComponent(jLabel10, javax.swing.GroupLayout.PREFERRED_SIZE, 163, javax.swing.GroupLayout.PREFERRED_SIZE)
                            .addComponent(jLabel6))
                        .addGap(0, 534, Short.MAX_VALUE))
                    .addGroup(layout.createSequentialGroup()
                        .addGroup(layout.createParallelGroup(javax.swing.GroupLayout.Alignment.LEADING)
                            .addGroup(layout.createParallelGroup(javax.swing.GroupLayout.Alignment.LEADING, false)
                                .addComponent(jLabel3, javax.swing.GroupLayout.DEFAULT_SIZE, 60, Short.MAX_VALUE)
                                .addComponent(jLabel4, javax.swing.GroupLayout.DEFAULT_SIZE, javax.swing.GroupLayout.DEFAULT_SIZE, Short.MAX_VALUE))
                            .addComponent(jLabel2, javax.swing.GroupLayout.PREFERRED_SIZE, 75, javax.swing.GroupLayout.PREFERRED_SIZE))
                        .addContainerGap())))
            .addGroup(layout.createSequentialGroup()
                .addGroup(layout.createParallelGroup(javax.swing.GroupLayout.Alignment.LEADING)
                    .addGroup(layout.createSequentialGroup()
                        .addGap(331, 331, 331)
                        .addComponent(jLabel1, javax.swing.GroupLayout.PREFERRED_SIZE, 45, javax.swing.GroupLayout.PREFERRED_SIZE))
                    .addGroup(layout.createSequentialGroup()
                        .addGap(116, 116, 116)
                        .addComponent(add_button)
                        .addGap(87, 87, 87)
                        .addComponent(update_button)
                        .addGap(105, 105, 105)
                        .addComponent(delete_button)))
                .addGap(0, 0, Short.MAX_VALUE))
        );
        layout.setVerticalGroup(
            layout.createParallelGroup(javax.swing.GroupLayout.Alignment.LEADING)
            .addGroup(layout.createSequentialGroup()
                .addContainerGap()
                .addComponent(jLabel1)
                .addGroup(layout.createParallelGroup(javax.swing.GroupLayout.Alignment.LEADING)
                    .addGroup(layout.createSequentialGroup()
                        .addGap(23, 23, 23)
                        .addGroup(layout.createParallelGroup(javax.swing.GroupLayout.Alignment.BASELINE)
                            .addComponent(jLabel2)
                            .addComponent(jobid_txt, javax.swing.GroupLayout.PREFERRED_SIZE, javax.swing.GroupLayout.DEFAULT_SIZE, javax.swing.GroupLayout.PREFERRED_SIZE))
                        .addGap(25, 25, 25)
                        .addGroup(layout.createParallelGroup(javax.swing.GroupLayout.Alignment.BASELINE)
                            .addComponent(jLabel3)
                            .addComponent(jobname_txt, javax.swing.GroupLayout.PREFERRED_SIZE, javax.swing.GroupLayout.DEFAULT_SIZE, javax.swing.GroupLayout.PREFERRED_SIZE))
                        .addGap(22, 22, 22)
                        .addGroup(layout.createParallelGroup(javax.swing.GroupLayout.Alignment.BASELINE)
                            .addComponent(jLabel4)
                            .addComponent(jobtype_combo, javax.swing.GroupLayout.PREFERRED_SIZE, javax.swing.GroupLayout.DEFAULT_SIZE, javax.swing.GroupLayout.PREFERRED_SIZE))
                        .addGap(24, 24, 24)
                        .addGroup(layout.createParallelGroup(javax.swing.GroupLayout.Alignment.BASELINE)
                            .addComponent(jLabel5, javax.swing.GroupLayout.PREFERRED_SIZE, 21, javax.swing.GroupLayout.PREFERRED_SIZE)
                            .addComponent(min_txt, javax.swing.GroupLayout.PREFERRED_SIZE, javax.swing.GroupLayout.DEFAULT_SIZE, javax.swing.GroupLayout.PREFERRED_SIZE))
                        .addGap(23, 23, 23)
                        .addGroup(layout.createParallelGroup(javax.swing.GroupLayout.Alignment.BASELINE)
                            .addComponent(jLabel11)
                            .addComponent(max_txt, javax.swing.GroupLayout.PREFERRED_SIZE, javax.swing.GroupLayout.DEFAULT_SIZE, javax.swing.GroupLayout.PREFERRED_SIZE))
                        .addGap(26, 26, 26)
                        .addGroup(layout.createParallelGroup(javax.swing.GroupLayout.Alignment.BASELINE)
                            .addComponent(jLabel7)
                            .addComponent(specializationarea_combo, javax.swing.GroupLayout.PREFERRED_SIZE, javax.swing.GroupLayout.DEFAULT_SIZE, javax.swing.GroupLayout.PREFERRED_SIZE))
                        .addGap(26, 26, 26)
                        .addGroup(layout.createParallelGroup(javax.swing.GroupLayout.Alignment.BASELINE)
                            .addComponent(jLabel8)
                            .addComponent(otherskill_txt, javax.swing.GroupLayout.PREFERRED_SIZE, javax.swing.GroupLayout.DEFAULT_SIZE, javax.swing.GroupLayout.PREFERRED_SIZE))
                        .addGap(18, 18, 18)
                        .addGroup(layout.createParallelGroup(javax.swing.GroupLayout.Alignment.BASELINE)
                            .addComponent(jLabel9)
                            .addComponent(dateofvalid_txt, javax.swing.GroupLayout.PREFERRED_SIZE, javax.swing.GroupLayout.DEFAULT_SIZE, javax.swing.GroupLayout.PREFERRED_SIZE))
                        .addGap(18, 18, 18)
                        .addGroup(layout.createParallelGroup(javax.swing.GroupLayout.Alignment.BASELINE)
                            .addComponent(jLabel10)
                            .addComponent(qualification_combo, javax.swing.GroupLayout.PREFERRED_SIZE, javax.swing.GroupLayout.DEFAULT_SIZE, javax.swing.GroupLayout.PREFERRED_SIZE))
                        .addGap(18, 18, 18)
                        .addGroup(layout.createParallelGroup(javax.swing.GroupLayout.Alignment.BASELINE)
                            .addComponent(jLabel6)
                            .addComponent(cid_combo, javax.swing.GroupLayout.PREFERRED_SIZE, javax.swing.GroupLayout.DEFAULT_SIZE, javax.swing.GroupLayout.PREFERRED_SIZE))
                        .addGap(58, 176, Short.MAX_VALUE))
                    .addGroup(javax.swing.GroupLayout.Alignment.TRAILING, layout.createSequentialGroup()
                        .addPreferredGap(javax.swing.LayoutStyle.ComponentPlacement.RELATED, javax.swing.GroupLayout.DEFAULT_SIZE, Short.MAX_VALUE)
                        .addGroup(layout.createParallelGroup(javax.swing.GroupLayout.Alignment.BASELINE)
                            .addComponent(update_button)
                            .addComponent(add_button)
                            .addComponent(delete_button))
                        .addGap(45, 45, 45))))
        );

        setBounds(0, 0, 735, 665);
    }// </editor-fold>//GEN-END:initComponents

    private void add_buttonActionPerformed(java.awt.event.ActionEvent evt) {//GEN-FIRST:event_add_buttonActionPerformed
        // TODO add your handling code here:
        this.insertData();
        this.refreshData();
    }//GEN-LAST:event_add_buttonActionPerformed

    private void delete_buttonActionPerformed(java.awt.event.ActionEvent evt) {//GEN-FIRST:event_delete_buttonActionPerformed
        // TODO add your handling code here:
        this.deleteData();
        this.refreshData();
    }//GEN-LAST:event_delete_buttonActionPerformed

    private void update_buttonActionPerformed(java.awt.event.ActionEvent evt) {//GEN-FIRST:event_update_buttonActionPerformed
        // TODO add your handling code here:
        this.updateData();
        this.refreshData();
    }//GEN-LAST:event_update_buttonActionPerformed

    private void jobname_txtActionPerformed(java.awt.event.ActionEvent evt) {//GEN-FIRST:event_jobname_txtActionPerformed
        // TODO add your handling code here:
    }//GEN-LAST:event_jobname_txtActionPerformed

    private void formWindowOpened(java.awt.event.WindowEvent evt) {//GEN-FIRST:event_formWindowOpened
        // TODO add your handling code here:
        this.getId();
    }//GEN-LAST:event_formWindowOpened

    private void cid_comboPopupMenuWillBecomeInvisible(javax.swing.event.PopupMenuEvent evt) {//GEN-FIRST:event_cid_comboPopupMenuWillBecomeInvisible
        // TODO add your handling code here:
        String Company_Id=cid_combo.getSelectedItem().toString();
        getIdDetails(Company_Id);
    }//GEN-LAST:event_cid_comboPopupMenuWillBecomeInvisible

    private void cid_comboActionPerformed(java.awt.event.ActionEvent evt) {//GEN-FIRST:event_cid_comboActionPerformed
        // TODO add your handling code here:
    }//GEN-LAST:event_cid_comboActionPerformed

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
            java.util.logging.Logger.getLogger(Job_Frm.class.getName()).log(java.util.logging.Level.SEVERE, null, ex);
        } catch (InstantiationException ex) {
            java.util.logging.Logger.getLogger(Job_Frm.class.getName()).log(java.util.logging.Level.SEVERE, null, ex);
        } catch (IllegalAccessException ex) {
            java.util.logging.Logger.getLogger(Job_Frm.class.getName()).log(java.util.logging.Level.SEVERE, null, ex);
        } catch (javax.swing.UnsupportedLookAndFeelException ex) {
            java.util.logging.Logger.getLogger(Job_Frm.class.getName()).log(java.util.logging.Level.SEVERE, null, ex);
        }
        //</editor-fold>
        //</editor-fold>

        /* Create and display the form */
        java.awt.EventQueue.invokeLater(new Runnable() {
            public void run() {
                new Job_Frm().setVisible(true);
            }
        });
    }

    // Variables declaration - do not modify//GEN-BEGIN:variables
    private javax.swing.JButton add_button;
    private javax.swing.JComboBox<String> cid_combo;
    private javax.swing.JTextField dateofvalid_txt;
    private javax.swing.JButton delete_button;
    private javax.swing.JLabel jLabel1;
    private javax.swing.JLabel jLabel10;
    private javax.swing.JLabel jLabel11;
    private javax.swing.JLabel jLabel2;
    private javax.swing.JLabel jLabel3;
    private javax.swing.JLabel jLabel4;
    private javax.swing.JLabel jLabel5;
    private javax.swing.JLabel jLabel6;
    private javax.swing.JLabel jLabel7;
    private javax.swing.JLabel jLabel8;
    private javax.swing.JLabel jLabel9;
    private javax.swing.JTextField jobid_txt;
    private javax.swing.JTextField jobname_txt;
    private javax.swing.JComboBox<String> jobtype_combo;
    private javax.swing.JTextField max_txt;
    private javax.swing.JTextField min_txt;
    private javax.swing.JTextField otherskill_txt;
    private javax.swing.JComboBox<String> qualification_combo;
    private javax.swing.JComboBox<String> specializationarea_combo;
    private javax.swing.JButton update_button;
    // End of variables declaration//GEN-END:variables
}
