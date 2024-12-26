package com.project.vn;

import com.project.vn.dao.ContractDAO;
import com.project.vn.dao.EmployeeDAO;
import com.project.vn.dao.RecuitmentDAO;
import com.project.vn.dto.Contract;
import com.project.vn.dto.Employee;
import com.project.vn.dto.Recuitment;
import java.awt.event.MouseAdapter;
import java.awt.event.MouseEvent;
import java.util.logging.Level;
import java.util.logging.Logger;
import javax.swing.DefaultComboBoxModel;
import javax.swing.JOptionPane;
import javax.swing.table.DefaultTableModel;

public class RecuitmentPanel extends javax.swing.JPanel {

    boolean isAdd = false;

    /**
     * Creates new form RecuitmentPanel
     */
    public RecuitmentPanel() {
        initComponents();
        redesign();
    }

    private void clearTextbox() {
        txtId.setText("");
        txtDeadline.setText("");
        txtDes.setText("");
        txtPosition.setText("");
        txtQuantity.setText("");
    }

    private void disableTextbox() {
        txtId.setEnabled(false);
        txtDeadline.setEnabled(false);
        txtDes.setEnabled(false);
        txtPosition.setEnabled(false);
        txtQuantity.setEnabled(false);
    }

    private void enableTextbox() {
        txtDeadline.setEnabled(true);
        txtDes.setEnabled(true);
        txtPosition.setEnabled(true);
        txtQuantity.setEnabled(true);
    }

    private void redesign() {
        tableModel = (DefaultTableModel) tblData.getModel();
        tableModel.setRowCount(0);

        tblData.addMouseListener(new MouseAdapter() {
            @Override
            public void mouseClicked(MouseEvent e) {
                int pos = tblData.rowAtPoint(e.getPoint());
                txtId.setText(tblData.getValueAt(pos, 0).toString());
                txtPosition.setText(tblData.getValueAt(pos, 1).toString());
                txtQuantity.setText(tblData.getValueAt(pos, 2).toString());
                txtDeadline.setText(tblData.getValueAt(pos, 3).toString());
                txtDes.setText(tblData.getValueAt(pos, 4).toString());

                btnDel.setEnabled(true);
                btnEdit.setEnabled(true);
                btnSave.setEnabled(false);
            }
        });
        fillData();
        disableTextbox();
        disableButton();
    }

    private void disableButton() {
        btnAdd.setEnabled(true);

        btnEdit.setEnabled(false);
        btnDel.setEnabled(false);
        btnSave.setEnabled(false);
    }

    private void enableButton() {
        btnAdd.setEnabled(false);

        btnEdit.setEnabled(false);
        btnDel.setEnabled(false);
        btnSave.setEnabled(true);
    }

    private void fillData() {
        // TODO Auto-generated method stub
        tableModel.setRowCount(0);
        try {
            for (var b : RecuitmentDAO.getInstance().getAll()) {
                Object[] data = new Object[10];
                data[0] = b.getId();
                data[1] = b.getPosition();
                data[2] = b.getQuantity();
                data[3] = b.getDeadline();
                data[4] = b.getJobDescription();
                tableModel.addRow(data);
            }
        } catch (Exception e) {
            JOptionPane.showMessageDialog(null, e.getMessage(), "Lỗi", JOptionPane.WARNING_MESSAGE);
        }
        // TODO Auto-generated catch block
    }

    private void reload() {
        fillData();
        disableButton();
        disableTextbox();
        clearTextbox();
    }

    @SuppressWarnings("unchecked")
    // <editor-fold defaultstate="collapsed" desc="Generated Code">//GEN-BEGIN:initComponents
    private void initComponents() {

        jPanel1 = new javax.swing.JPanel();
        jLabel1 = new javax.swing.JLabel();
        txtId = new javax.swing.JTextField();
        jLabel2 = new javax.swing.JLabel();
        txtPosition = new javax.swing.JTextField();
        txtQuantity = new javax.swing.JTextField();
        jLabel3 = new javax.swing.JLabel();
        txtDeadline = new javax.swing.JTextField();
        jLabel4 = new javax.swing.JLabel();
        jLabel5 = new javax.swing.JLabel();
        jScrollPane1 = new javax.swing.JScrollPane();
        txtDes = new javax.swing.JTextArea();
        btnReload = new javax.swing.JButton();
        btnAdd = new javax.swing.JButton();
        btnDel = new javax.swing.JButton();
        btnEdit = new javax.swing.JButton();
        btnSave = new javax.swing.JButton();
        jScrollPane2 = new javax.swing.JScrollPane();
        tblData = new javax.swing.JTable();

        setMaximumSize(new java.awt.Dimension(893, 600));
        setMinimumSize(new java.awt.Dimension(893, 600));
        setPreferredSize(new java.awt.Dimension(893, 600));
        setLayout(new java.awt.BorderLayout());

        jPanel1.setBackground(new java.awt.Color(142, 250, 229));
        jPanel1.setPreferredSize(new java.awt.Dimension(893, 210));
        jPanel1.setLayout(new org.netbeans.lib.awtextra.AbsoluteLayout());

        jLabel1.setFont(new java.awt.Font("Segoe UI", 0, 14)); // NOI18N
        jLabel1.setText("Mô tả:");
        jPanel1.add(jLabel1, new org.netbeans.lib.awtextra.AbsoluteConstraints(460, 0, 130, 30));

        txtId.setEnabled(false);
        jPanel1.add(txtId, new org.netbeans.lib.awtextra.AbsoluteConstraints(130, 0, 310, 30));

        jLabel2.setFont(new java.awt.Font("Segoe UI", 0, 14)); // NOI18N
        jLabel2.setText("Vị trí tuyển dụng:");
        jPanel1.add(jLabel2, new org.netbeans.lib.awtextra.AbsoluteConstraints(0, 50, 130, 30));
        jPanel1.add(txtPosition, new org.netbeans.lib.awtextra.AbsoluteConstraints(130, 50, 310, 30));
        jPanel1.add(txtQuantity, new org.netbeans.lib.awtextra.AbsoluteConstraints(130, 100, 310, 30));

        jLabel3.setFont(new java.awt.Font("Segoe UI", 0, 14)); // NOI18N
        jLabel3.setText("Số lượng:");
        jPanel1.add(jLabel3, new org.netbeans.lib.awtextra.AbsoluteConstraints(0, 100, 130, 30));
        jPanel1.add(txtDeadline, new org.netbeans.lib.awtextra.AbsoluteConstraints(130, 150, 310, 30));

        jLabel4.setFont(new java.awt.Font("Segoe UI", 0, 14)); // NOI18N
        jLabel4.setText("Hạn tuyển dụng:");
        jPanel1.add(jLabel4, new org.netbeans.lib.awtextra.AbsoluteConstraints(0, 150, 130, 30));

        jLabel5.setFont(new java.awt.Font("Segoe UI", 0, 14)); // NOI18N
        jLabel5.setText("Mã bài tuyển dụng:");
        jPanel1.add(jLabel5, new org.netbeans.lib.awtextra.AbsoluteConstraints(0, 0, 130, 30));

        txtDes.setColumns(20);
        txtDes.setRows(5);
        jScrollPane1.setViewportView(txtDes);

        jPanel1.add(jScrollPane1, new org.netbeans.lib.awtextra.AbsoluteConstraints(460, 30, 410, 100));

        btnReload.setText("Làm mới");
        btnReload.addMouseListener(new MouseAdapter() {
            public void mouseClicked(MouseEvent evt) {
                btnReloadMouseClicked(evt);
            }
        });
        jPanel1.add(btnReload, new org.netbeans.lib.awtextra.AbsoluteConstraints(810, 150, -1, -1));

        btnAdd.setText("Thêm");
        btnAdd.addMouseListener(new MouseAdapter() {
            public void mouseClicked(MouseEvent evt) {
                btnAddMouseClicked(evt);
            }
        });
        jPanel1.add(btnAdd, new org.netbeans.lib.awtextra.AbsoluteConstraints(450, 150, -1, -1));

        btnDel.setText("Xóa");
        btnDel.addMouseListener(new MouseAdapter() {
            public void mouseClicked(MouseEvent evt) {
                btnDelMouseClicked(evt);
            }
        });
        jPanel1.add(btnDel, new org.netbeans.lib.awtextra.AbsoluteConstraints(540, 150, -1, -1));

        btnEdit.setText("Sửa");
        btnEdit.addMouseListener(new MouseAdapter() {
            public void mouseClicked(MouseEvent evt) {
                btnEditMouseClicked(evt);
            }
        });
        jPanel1.add(btnEdit, new org.netbeans.lib.awtextra.AbsoluteConstraints(630, 150, -1, -1));

        btnSave.setText("Lưu");
        btnSave.addMouseListener(new MouseAdapter() {
            public void mouseClicked(MouseEvent evt) {
                btnSaveMouseClicked(evt);
            }
        });
        jPanel1.add(btnSave, new org.netbeans.lib.awtextra.AbsoluteConstraints(720, 150, -1, -1));

        add(jPanel1, java.awt.BorderLayout.PAGE_START);

        tblData.setModel(new DefaultTableModel(
            new Object [][] {
                {null, null, null, null, null},
                {null, null, null, null, null},
                {null, null, null, null, null},
                {null, null, null, null, null}
            },
            new String [] {
                "Mã bài tuyển dụng", "Vị trí tuyển dụng", "Số lượng", "Hạn tuyển dụng", "Mô tả"
            }
        ));
        jScrollPane2.setViewportView(tblData);

        add(jScrollPane2, java.awt.BorderLayout.CENTER);
    }// </editor-fold>//GEN-END:initComponents

    private void btnAddMouseClicked(MouseEvent evt) {//GEN-FIRST:event_btnAddMouseClicked
        // TODO add your handling code here:
        isAdd = true;
        clearTextbox();
        enableButton();
        enableTextbox();
        txtPosition.requestFocus();
    }//GEN-LAST:event_btnAddMouseClicked

    private void btnReloadMouseClicked(MouseEvent evt) {//GEN-FIRST:event_btnReloadMouseClicked
        // TODO add your handling code here:
        reload();
    }//GEN-LAST:event_btnReloadMouseClicked

    private void btnDelMouseClicked(MouseEvent evt) {//GEN-FIRST:event_btnDelMouseClicked
        // TODO add your handling code here:
        if (!txtId.getText().isEmpty()) {
            int option = JOptionPane.showConfirmDialog(null, "Bạn có muốn xóa không?", "Xác nhận",
                    JOptionPane.YES_NO_OPTION);
            if (option == JOptionPane.YES_OPTION) {
                RecuitmentDAO.getInstance().delete(Integer.parseInt(txtId.getText()));
                reload();
            }
        } else {
            JOptionPane.showMessageDialog(null, "Vui lòng chọn bài tuyển dụng muốn xóa", "Lỗi", JOptionPane.WARNING_MESSAGE);
        }
    }//GEN-LAST:event_btnDelMouseClicked

    private void btnEditMouseClicked(MouseEvent evt) {//GEN-FIRST:event_btnEditMouseClicked
        // TODO add your handling code here:
        isAdd = false;
        enableButton();
        enableTextbox();
        txtPosition.requestFocus();
    }//GEN-LAST:event_btnEditMouseClicked

    private void btnSaveMouseClicked(MouseEvent evt) {//GEN-FIRST:event_btnSaveMouseClicked
                    // Kiểm tra dữ liệu trống cho các thuộc tính khác
            if (txtPosition.getText().trim().isEmpty()) {
                JOptionPane.showMessageDialog(null, "Vị trí tuyển dụng không được để trống", "Lỗi", JOptionPane.WARNING_MESSAGE);
                return;
            }

            if (txtQuantity.getText().trim().isEmpty()) {
                JOptionPane.showMessageDialog(null, "Số lượng không được để trống", "Lỗi", JOptionPane.WARNING_MESSAGE);
                return;
            }

            if (txtDes.getText().trim().isEmpty()) {
                JOptionPane.showMessageDialog(null, "Mô tả dụng không được để trống", "Lỗi", JOptionPane.WARNING_MESSAGE);
                return;
            }
            if (txtDeadline.getText().trim().isEmpty()) {
                JOptionPane.showMessageDialog(null, "Hạn tuyển dụng không được để trống", "Lỗi", JOptionPane.WARNING_MESSAGE);
                return;
            }


// TODO add your handling code here:
        try {
            var item = new Recuitment();
            item.setId(txtId.getText().isEmpty() ? 0 : Integer.valueOf(txtId.getText()));
            item.setDeadline(txtDeadline.getText());
            item.setJobDescription(txtDes.getText());
            item.setQuantity(Integer.valueOf(txtQuantity.getText()));
            item.setPosition(txtPosition.getText());
            if (isAdd) {
                RecuitmentDAO.getInstance().add(item);
                JOptionPane.showMessageDialog(null, "Thành công", "Thông báo", JOptionPane.INFORMATION_MESSAGE);
            } else {
                RecuitmentDAO.getInstance().update(item);
                JOptionPane.showMessageDialog(null, "Cập nhật thành công", "Thông báo", JOptionPane.INFORMATION_MESSAGE);
            }

            reload();
        } catch (Exception e) {
            JOptionPane.showMessageDialog(null, e.getCause(), "Lỗi", JOptionPane.WARNING_MESSAGE);
        }
    }//GEN-LAST:event_btnSaveMouseClicked

    private DefaultTableModel tableModel;
    // Variables declaration - do not modify//GEN-BEGIN:variables
    private javax.swing.JButton btnAdd;
    private javax.swing.JButton btnDel;
    private javax.swing.JButton btnEdit;
    private javax.swing.JButton btnReload;
    private javax.swing.JButton btnSave;
    private javax.swing.JLabel jLabel1;
    private javax.swing.JLabel jLabel2;
    private javax.swing.JLabel jLabel3;
    private javax.swing.JLabel jLabel4;
    private javax.swing.JLabel jLabel5;
    private javax.swing.JPanel jPanel1;
    private javax.swing.JScrollPane jScrollPane1;
    private javax.swing.JScrollPane jScrollPane2;
    private javax.swing.JTable tblData;
    private javax.swing.JTextField txtDeadline;
    private javax.swing.JTextArea txtDes;
    private javax.swing.JTextField txtId;
    private javax.swing.JTextField txtPosition;
    private javax.swing.JTextField txtQuantity;
    // End of variables declaration//GEN-END:variables

}
