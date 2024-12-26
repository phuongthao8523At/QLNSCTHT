package com.project.vn;

import com.project.vn.dao.EmployeeDAO;
import com.project.vn.dao.SalaryDAO;
import com.project.vn.dto.Employee;
import com.project.vn.dto.Salary;
import com.project.vn.format.DateLabelFormatter;
import org.jdatepicker.impl.JDatePanelImpl;
import org.jdatepicker.impl.JDatePickerImpl;
import org.jdatepicker.impl.UtilDateModel;

import javax.swing.*;
import javax.swing.table.DefaultTableModel;
import java.awt.*;
import java.awt.event.MouseAdapter;
import java.awt.event.MouseEvent;
import java.text.NumberFormat;
import java.text.ParseException;
import java.util.HashMap;
import java.util.Locale;
import java.util.Objects;
import java.util.Properties;
import java.util.logging.Level;
import java.util.logging.Logger;

public class SalaryPanel extends javax.swing.JPanel {

    boolean isAdd = false;
    Locale vnLocale = new Locale("vi", "VN");
    NumberFormat nf = NumberFormat.getCurrencyInstance(vnLocale);

    public SalaryPanel() {
        p.put("text.today", "Today");
        p.put("text.month", "Month");
        p.put("text.year", "Year");
        datePanel = new JDatePanelImpl(modelDate, p);
        datePicker = new JDatePickerImpl(datePanel, new DateLabelFormatter());
        initComponents();
        redesign();
    }

    private void clearTextbox() {
        txtId.setText("");
        txtAmount.setText("");
        txtDes.setText("");

    }

    private void disableTextbox() {
        txtId.setEnabled(false);
        txtAmount.setEnabled(false);
        datePicker.setEnabled(false);
        txtDes.setEnabled(false);
        txtWorkingDay.setEnabled(false);
        cboEmp.setEnabled(false);
    }

    private void enableTextbox() {
        txtAmount.setEnabled(true);
        datePicker.setEnabled(true);
        txtDes.setEnabled(true);
        txtWorkingDay.setEnabled(true);
        cboEmp.setEnabled(true);
    }

    private void redesign() {
        tableModel = (DefaultTableModel) tblData.getModel();
        tableModel.setRowCount(0);

        tblData.addMouseListener(new MouseAdapter() {
            @Override
            public void mouseClicked(MouseEvent e) {
                int pos = tblData.rowAtPoint(e.getPoint());
                txtId.setText(tblData.getValueAt(pos, 0).toString());
                cboEmp.setSelectedItem(tblData.getValueAt(pos, 1).toString());
                txtWorkingDay.setText(tblData.getValueAt(pos, 2).toString());
                txtAmount.setText(tblData.getValueAt(pos, 3).toString());
                datePicker.getModel().setDate(
                        Integer.parseInt(tblData.getValueAt(pos, 5).toString().split("-")[0]),
                        Integer.parseInt(tblData.getValueAt(pos, 5).toString().split("-")[1]) - 1,
                        Integer.parseInt(tblData.getValueAt(pos, 5).toString().split("-")[2])
                );
                txtDes.setText(tblData.getValueAt(pos, 6).toString());

                btnDel.setEnabled(true);
                btnEdit.setEnabled(true);
                btnSave.setEnabled(false);
            }
        });
        loadCombobox();
        fillData();
        disableTextbox();
        disableButton();
    }

    private void loadCombobox() {
        try {
            DefaultComboBoxModel<String> cboEmpModel = new DefaultComboBoxModel<>();
            var allEmpl = EmployeeDAO.getInstance().getEmployeeNoSalary();
            for (Employee employee : allEmpl) {
                cboEmpModel.addElement(employee.getId() + " - " + employee.getFullName() + " - " + employee.getPosition());
            }
            cboEmp.setModel(cboEmpModel);
        } catch (Exception ex) {
            Logger.getLogger(ContractPanel.class.getName()).log(Level.SEVERE, null, ex);
        }
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
            for (var b : SalaryDAO.getInstance().getAll()) {
                Object[] data = new Object[]{
                        b.getId(),
                        String.format(
                                "%s - %s - %s",
                                b.getEmployee().getId(),
                                b.getEmployee().getFullName(),
                                b.getEmployee().getPosition()
                        ),
                        b.getWorkingDay(),
                        b.getWage(),
                        b.getSalaryAmount(),
                        b.getSalaryDate(),
                        b.getDetail()
                };
                tableModel.addRow(data);
            }
        } catch (Exception e) {
            JOptionPane.showMessageDialog(null, e.getMessage(), "Lỗi", JOptionPane.WARNING_MESSAGE);
        }
        // TODO Auto-generated catch block
    }

    private void reload() {
        fillData();
        clearTextbox();
        disableButton();
        disableTextbox();
        loadCombobox();
    }

    // <editor-fold defaultstate="collapsed" desc="Generated Code">//GEN-BEGIN:initComponents
    private void initComponents() {

        javax.swing.JPanel jPanel1 = new javax.swing.JPanel();
        javax.swing.JLabel jLabel1 = new javax.swing.JLabel();
        txtId = new javax.swing.JTextField();
        javax.swing.JLabel jLabel2 = new javax.swing.JLabel();
        javax.swing.JLabel jLabel3 = new javax.swing.JLabel();
        txtAmount = new javax.swing.JTextField();
        javax.swing.JLabel jLabel4 = new javax.swing.JLabel();

        javax.swing.JLabel jLabel5 = new javax.swing.JLabel();
        javax.swing.JScrollPane jScrollPane1 = new javax.swing.JScrollPane();
        txtDes = new javax.swing.JTextArea();
        cboEmp = new javax.swing.JComboBox<>();
        javax.swing.JLabel jLabel6 = new javax.swing.JLabel();
        txtWorkingDay = new javax.swing.JTextField();

        javax.swing.JButton btnReload = new javax.swing.JButton();
        btnAdd = new javax.swing.JButton();
        btnEdit = new javax.swing.JButton();
        btnDel = new javax.swing.JButton();
        btnSave = new javax.swing.JButton();
        javax.swing.JScrollPane jScrollPane2 = new javax.swing.JScrollPane();
        tblData = new javax.swing.JTable();

        setMaximumSize(new java.awt.Dimension(893, 600));
        setMinimumSize(new java.awt.Dimension(893, 600));
        setPreferredSize(new java.awt.Dimension(893, 600));
        setLayout(new java.awt.BorderLayout());

        jPanel1.setBackground(new java.awt.Color(221, 237, 128));
        jPanel1.setPreferredSize(new java.awt.Dimension(893, 210));
        jPanel1.setLayout(new org.netbeans.lib.awtextra.AbsoluteLayout());

        jLabel1.setFont(new java.awt.Font("Segoe UI", Font.PLAIN, 14)); // NOI18N
        jLabel1.setText("Chi tiết");
        jPanel1.add(jLabel1, new org.netbeans.lib.awtextra.AbsoluteConstraints(470, 10, 110, 30));

        txtId.addActionListener(this::txtIdActionPerformed);
        jPanel1.add(txtId, new org.netbeans.lib.awtextra.AbsoluteConstraints(130, 10, 320, 30));

        jLabel2.setFont(new java.awt.Font("Segoe UI", Font.PLAIN, 14)); // NOI18N
        jLabel2.setText("Nhân viên:");
        jPanel1.add(jLabel2, new org.netbeans.lib.awtextra.AbsoluteConstraints(10, 60, 110, 30));

        jLabel3.setFont(new java.awt.Font("Segoe UI", Font.PLAIN, 14)); // NOI18N
        jLabel3.setText("Tiền công 1 ngày:");
        jPanel1.add(jLabel3, new org.netbeans.lib.awtextra.AbsoluteConstraints(10, 110, 110, 30));
        jPanel1.add(txtAmount, new org.netbeans.lib.awtextra.AbsoluteConstraints(130, 110, 320, 30));

        jLabel4.setFont(new java.awt.Font("Segoe UI", Font.PLAIN, 14)); // NOI18N
        jLabel4.setText("Ngày nhận:");
        jPanel1.add(jLabel4, new org.netbeans.lib.awtextra.AbsoluteConstraints(10, 160, 110, 30));
        jPanel1.add(datePicker, new org.netbeans.lib.awtextra.AbsoluteConstraints(130, 160, 320, 30));

        jLabel5.setFont(new java.awt.Font("Segoe UI", Font.PLAIN, 14)); // NOI18N
        jLabel5.setText("Mã nhận lương:");
        jPanel1.add(jLabel5, new org.netbeans.lib.awtextra.AbsoluteConstraints(10, 10, 110, 30));

        txtDes.setColumns(20);
        txtDes.setRows(2);
        jScrollPane1.setViewportView(txtDes);

        jLabel6.setFont(new java.awt.Font("Segoe UI", Font.PLAIN, 14)); // NOI18N
        jLabel6.setText("Số ngày làm:");
        jPanel1.add(jLabel6, new org.netbeans.lib.awtextra.AbsoluteConstraints(470, 80, 110, 30));
        jPanel1.add(txtWorkingDay, new org.netbeans.lib.awtextra.AbsoluteConstraints(470, 110, 400, -1));

        jPanel1.add(jScrollPane1, new org.netbeans.lib.awtextra.AbsoluteConstraints(470, 40, 400, -1));

        jPanel1.add(cboEmp, new org.netbeans.lib.awtextra.AbsoluteConstraints(130, 50, 320, 40));

        btnReload.setText("Làm mới");
        btnReload.addMouseListener(new java.awt.event.MouseAdapter() {
            public void mouseClicked(java.awt.event.MouseEvent evt) {
                btnReloadMouseClicked();
            }
        });
        jPanel1.add(btnReload, new org.netbeans.lib.awtextra.AbsoluteConstraints(780, 160, 90, 30));

        btnAdd.setText("Thêm");
        btnAdd.addMouseListener(new java.awt.event.MouseAdapter() {
            public void mouseClicked(java.awt.event.MouseEvent evt) {
                btnAddMouseClicked();
            }
        });
        jPanel1.add(btnAdd, new org.netbeans.lib.awtextra.AbsoluteConstraints(470, 160, 70, 30));

        btnEdit.setText("Sửa");
        btnEdit.addMouseListener(new java.awt.event.MouseAdapter() {
            public void mouseClicked(java.awt.event.MouseEvent evt) {
                btnEditMouseClicked();
            }
        });
        jPanel1.add(btnEdit, new org.netbeans.lib.awtextra.AbsoluteConstraints(550, 160, 60, 30));

        btnDel.setText("Xóa");
        btnDel.addMouseListener(new java.awt.event.MouseAdapter() {
            public void mouseClicked(java.awt.event.MouseEvent evt) {
                btnDelMouseClicked();
            }
        });
        jPanel1.add(btnDel, new org.netbeans.lib.awtextra.AbsoluteConstraints(620, 160, 60, 30));

        btnSave.setText("Lưu");
        btnSave.addMouseListener(new java.awt.event.MouseAdapter() {
            public void mouseClicked(java.awt.event.MouseEvent evt) {
                btnSaveMouseClicked();
            }
        });
        jPanel1.add(btnSave, new org.netbeans.lib.awtextra.AbsoluteConstraints(700, 160, 60, 30));

        add(jPanel1, java.awt.BorderLayout.PAGE_START);

        tblData.setModel(new javax.swing.table.DefaultTableModel(
                new Object[][]{
                        {null, null, null, null, null, null, null},
                        {null, null, null, null, null, null, null},
                        {null, null, null, null, null, null, null},
                        {null, null, null, null, null, null, null}
                },
                new String[]{
                        "Mã nhận lương", "Nhân viên", "Số ngày làm", "Tiền công", "Thực nhận", "Ngày nhận", "Mô tả"
                }
        ));
        jScrollPane2.setViewportView(tblData);

        add(jScrollPane2, java.awt.BorderLayout.CENTER);
    }// </editor-fold>//GEN-END:initComponents

    private void btnAddMouseClicked() {//GEN-FIRST:event_btnAddMouseClicked
        // TODO add your handling code here:
        isAdd = true;
        clearTextbox();
        enableButton();
        enableTextbox();
        txtAmount.requestFocus();
    }//GEN-LAST:event_btnAddMouseClicked

    private void btnEditMouseClicked() {//GEN-FIRST:event_btnEditMouseClicked
        // TODO add your handling code here:
        isAdd = false;
        enableButton();
        enableTextbox();
        cboEmp.setEnabled(false);
        txtAmount.requestFocus();
    }//GEN-LAST:event_btnEditMouseClicked

    private void btnDelMouseClicked() {//GEN-FIRST:event_btnDelMouseClicked
        // TODO add your handling code here:
        if (!txtId.getText().isEmpty()) {
            int option = JOptionPane.showConfirmDialog(null, "Bạn có muốn xóa không?", "Xác nhận",
                                                       JOptionPane.YES_NO_OPTION
            );
            if (option == JOptionPane.YES_OPTION) {
                SalaryDAO.getInstance().delete(Integer.parseInt(txtId.getText()));
                reload();
            }
        } else {
            JOptionPane.showMessageDialog(null, "Vui lòng chọn bản lương muốn xóa", "Lỗi", JOptionPane.WARNING_MESSAGE);
        }
    }//GEN-LAST:event_btnDelMouseClicked

    private void btnReloadMouseClicked() {//GEN-FIRST:event_btnReloadMouseClicked
        // TODO add your handling code here:
        reload();
    }//GEN-LAST:event_btnReloadMouseClicked

    private int getEmpId() {
        String text = Objects.requireNonNull(cboEmp.getSelectedItem()).toString();
        var rs = text.split("-");
        return Integer.parseInt(rs[0].trim());
    }

    private Double getPrice() {
        try {
            String priceText = txtAmount.getText();
            return nf.parse(priceText).doubleValue();
        } catch (ParseException ignored) {
        }
        try {
            return Double.valueOf(txtAmount.getText());
        } catch (NumberFormatException ignored) {
        }
        JOptionPane.showMessageDialog(null, "Tiền không hợp lệ", "Lỗi", JOptionPane.WARNING_MESSAGE);

        return (double) 0;
    }

    private void btnSaveMouseClicked() {//GEN-FIRST:event_btnSaveMouseClicked

        // Kiểm tra dữ liệu trống cho các thuộc tính khác

        if (datePicker.getModel().getValue() == null) {
            JOptionPane.showMessageDialog(null, "Ngày nhận không được để trống", "Lỗi", JOptionPane.WARNING_MESSAGE);
            return;
        }

        if (txtDes.getText().trim().isEmpty()) {
            JOptionPane.showMessageDialog(null, "Chi tiết không được để trống", "Lỗi", JOptionPane.WARNING_MESSAGE);
            return;
        }
        int workday;
        try {
            workday = Integer.parseInt(txtWorkingDay.getText());
            HashMap<Integer, Integer> numberDayInMonth = new HashMap<>();
            numberDayInMonth.put(1, 31);
            numberDayInMonth.put(2, 28);
            numberDayInMonth.put(3, 31);
            numberDayInMonth.put(4, 30);
            numberDayInMonth.put(5, 31);
            numberDayInMonth.put(6, 30);
            numberDayInMonth.put(7, 31);
            numberDayInMonth.put(8, 31);
            numberDayInMonth.put(9, 30);
            numberDayInMonth.put(10, 31);
            numberDayInMonth.put(11, 30);
            numberDayInMonth.put(12, 31);

            int maxDay = numberDayInMonth.get(datePicker.getModel().getMonth());

            if (maxDay < workday) {
                JOptionPane.showMessageDialog(
                        null,
                        "Số ngày làm không được vượt quá %d ngày".formatted(maxDay),
                        "Lỗi",
                        JOptionPane.WARNING_MESSAGE
                );
                return;
            }
        } catch (Exception e) {
            e.printStackTrace();
            JOptionPane.showMessageDialog(
                    null,
                    "Số ngày làm việc phải là số nguyên",
                    "Lỗi",
                    JOptionPane.WARNING_MESSAGE
            );
            return;
        }


        // TODO add your handling code here:
        try {
            var item = new Salary();
            item.setId(txtId.getText().isEmpty() ? 0 : Integer.parseInt(txtId.getText()));
            item.setEmployeeId(getEmpId());
            item.setWage(getPrice());
            item.setDetail(txtDes.getText());
            item.setSalaryDate(datePicker.getModel().getYear()
                               + "-" + (datePicker.getModel().getMonth() + 1)
                               + "-" + datePicker.getModel().getDay());
            item.setWorkingDay(workday);

            if (isAdd) {
                SalaryDAO.getInstance().add(item);
                JOptionPane.showMessageDialog(null, "Thành công", "Thông báo", JOptionPane.INFORMATION_MESSAGE);
            } else {
                SalaryDAO.getInstance().update(item);
                JOptionPane.showMessageDialog(null, "Thành công", "Thông báo", JOptionPane.INFORMATION_MESSAGE);
            }
            reload();
        } catch (Exception e) {
            JOptionPane.showMessageDialog(null, e.getCause(), "Lỗi", JOptionPane.WARNING_MESSAGE);
        }
    }//GEN-LAST:event_btnSaveMouseClicked

    private void txtIdActionPerformed(java.awt.event.ActionEvent evt) {//GEN-FIRST:event_txtIdActionPerformed
        // TODO add your handling code here:
    }//GEN-LAST:event_txtIdActionPerformed

    private javax.swing.table.DefaultTableModel tableModel;
    // Variables declaration - do not modify//GEN-BEGIN:variables
    private javax.swing.JButton btnAdd;
    private javax.swing.JButton btnDel;
    private javax.swing.JButton btnEdit;
    private javax.swing.JButton btnSave;
    private javax.swing.JComboBox<String> cboEmp;
    private javax.swing.JTable tblData;
    private javax.swing.JTextField txtAmount;
    private javax.swing.JTextField txtWorkingDay;
    private javax.swing.JTextArea txtDes;
    private javax.swing.JTextField txtId;

    Properties p = new Properties();
    private final UtilDateModel modelDate = new UtilDateModel();
    private final JDatePanelImpl datePanel;
    private final JDatePickerImpl datePicker;
    // End of variables declaration//GEN-END:variables

}
