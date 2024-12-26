package com.project.vn;

import com.project.vn.dao.EmployeeDAO;
import com.project.vn.dto.Employee;

import javax.swing.*;
import javax.swing.table.DefaultTableModel;
import java.awt.*;
import java.awt.event.MouseAdapter;
import java.awt.event.MouseEvent;
import java.util.regex.Matcher;
import java.util.regex.Pattern;

public class EmployeePanel extends javax.swing.JPanel {

    private boolean isAdd = false;

    public EmployeePanel() {
        initComponents();
        redesign();

    }

    private boolean isNameValid(String name) {
        // Biểu thức chính quy cho tên hợp lệ
        String regex = "^[A-ZẮẤẦẢẠẬẨẰẲẶẴÂĂÁÀAẼỄẾỀỂẺẸỆEỈÍÌĨỊIỌỎỐỖỒỔƠỜỚỞỠỢOÙÚỦŨƯỪỨỬỰUÝỲỶỸYĐD]"
                       + "[a-zắấầảạậẩằẳặẵâăáàaẽễếềểẻẹệeỉíìĩịiọỏốỗồổơờớởỡợoùúủũưừứửựuýỳỷỹyđd]*(\\s"
                       + "[A-ZẮẤẦẢẠẬẨẰẲẶẴÂĂÁÀAẼỄẾỀỂẺẸỆEỈÍÌĨỊIỌỎỐỖỒỔƠỜỚỞỠỢOÙÚỦŨƯỪỨỬỰUÝỲỶỸYĐD]"
                       + "[a-zắấầảạậẩằẳặẵâăáàaẽễếềểẻẹệeỉíìĩịiọỏốỗồổơờớởỡợoùúủũưừứửựuýỳỷỹyđd]*)*$";
        // Tạo Pattern object
        Pattern pattern = Pattern.compile(regex);
        // Tạo matcher object
        Matcher matcher = pattern.matcher(name);
        return matcher.matches(); // Trả về true nếu tên hợp lệ
    }

    private boolean isPhoneNumberValid(String phoneNumber) {
        // Biểu thức chính quy cho số điện thoại hợp lệ
        String regex = "^\\d{10,11}$";
        // Tạo Pattern object
        Pattern pattern = Pattern.compile(regex);
        // Tạo matcher object
        Matcher matcher = pattern.matcher(phoneNumber);
        return matcher.matches(); // Trả về true nếu số điện thoại hợp lệ
    }

    private void clearTextbox() {
        txtId.setText("");
        txtAddress.setText("");
        txtDepartment.setText("");
        txtFullname.setText("");
        txtPhone.setText("");
        txtPosition.setText("");
    }

    private void disableTextbox() {
        txtAddress.setEditable(false);
        txtDepartment.setEditable(false);
        txtFullname.setEditable(false);
        txtId.setEnabled(false);
        txtPhone.setEditable(false);
        txtPosition.setEditable(false);
        cboGender.setEnabled(false);
    }

    private void enableTextbox() {
        txtAddress.setEditable(true);
        txtDepartment.setEditable(true);
        txtFullname.setEditable(true);
        txtPhone.setEditable(true);
        txtPosition.setEditable(true);
        cboGender.setEnabled(true);
    }

    private void redesign() {
        tableModel = (DefaultTableModel) tblData.getModel();
        tableModel.setRowCount(0);

        tblData.addMouseListener(new MouseAdapter() {
            @Override
            public void mouseClicked(MouseEvent e) {
                int pos = tblData.rowAtPoint(e.getPoint());
                txtId.setText(tblData.getValueAt(pos, 0).toString());
                txtFullname.setText(tblData.getValueAt(pos, 1).toString());
                txtDepartment.setText(tblData.getValueAt(pos, 2).toString());
                txtAddress.setText(tblData.getValueAt(pos, 3).toString());
                txtPhone.setText(tblData.getValueAt(pos, 4).toString());
                cboGender.setSelectedItem(tblData.getValueAt(pos, 5).toString());
                txtPosition.setText(tblData.getValueAt(pos, 6).toString());

                btnDel.setEnabled("Còn làm".equalsIgnoreCase(tblData.getValueAt(pos, 7).toString()));
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
            for (Employee b : EmployeeDAO.getInstance().getAll()) {
                Object[] data = new Object[10];
                data[0] = b.getId();
                data[1] = b.getFullName();
                data[2] = b.getDepartment();
                data[3] = b.getAddress();
                data[4] = b.getPhone();
                data[5] = b.getGender();
                data[6] = b.getPosition();
                data[7] = b.getLeaveDate() == null ? "Còn làm" : "Đã nghỉ";
                tableModel.addRow(data);
            }
        } catch (Exception e) {
            JOptionPane.showMessageDialog(null, e.getMessage(), "Lỗi", JOptionPane.WARNING_MESSAGE);
        }
        // TODO Auto-generated catch block
    }

    // <editor-fold defaultstate="collapsed" desc="Generated Code">//GEN-BEGIN:initComponents
    private void initComponents() {

        javax.swing.JPanel jPanel1 = new javax.swing.JPanel();
        javax.swing.JLabel jLabel1 = new javax.swing.JLabel();
        txtId = new javax.swing.JTextField();
        javax.swing.JLabel jLabel2 = new javax.swing.JLabel();
        txtFullname = new javax.swing.JTextField();
        txtDepartment = new javax.swing.JTextField();
        javax.swing.JLabel jLabel3 = new javax.swing.JLabel();
        javax.swing.JLabel jLabel4 = new javax.swing.JLabel();
        txtAddress = new javax.swing.JTextField();
        javax.swing.JLabel jLabel5 = new javax.swing.JLabel();
        txtPhone = new javax.swing.JTextField();
        javax.swing.JLabel jLabel6 = new javax.swing.JLabel();
        txtPosition = new javax.swing.JTextField();
        javax.swing.JLabel jLabel7 = new javax.swing.JLabel();
        cboGender = new javax.swing.JComboBox<>();
        btnAdd = new javax.swing.JButton();
        btnEdit = new javax.swing.JButton();
        btnDel = new javax.swing.JButton();
        btnSave = new javax.swing.JButton();
        javax.swing.JButton btnReload = new javax.swing.JButton();
        javax.swing.JScrollPane scrollData = new javax.swing.JScrollPane();
        tblData = new javax.swing.JTable();

        setMaximumSize(new java.awt.Dimension(893, 600));
        setMinimumSize(new java.awt.Dimension(893, 600));
        setPreferredSize(new java.awt.Dimension(893, 600));
        setLayout(new java.awt.BorderLayout());

        jPanel1.setBackground(new java.awt.Color(129, 214, 247));
        jPanel1.setMaximumSize(new java.awt.Dimension(893, 250));
        jPanel1.setMinimumSize(new java.awt.Dimension(893, 250));
        jPanel1.setPreferredSize(new java.awt.Dimension(893, 200));
        jPanel1.setRequestFocusEnabled(false);

        jLabel1.setFont(new java.awt.Font("Segoe UI", Font.BOLD, 12)); // NOI18N
        jLabel1.setText("Mã nhân viên:");

        txtId.setEditable(false);

        jLabel2.setFont(new java.awt.Font("Segoe UI", Font.BOLD, 12)); // NOI18N
        jLabel2.setText("Tên nhân viên:");

        jLabel3.setFont(new java.awt.Font("Segoe UI", Font.BOLD, 12)); // NOI18N
        jLabel3.setText("Phòng ban:");

        jLabel4.setFont(new java.awt.Font("Segoe UI", Font.BOLD, 12)); // NOI18N
        jLabel4.setText("Địa chỉ:");

        jLabel5.setFont(new java.awt.Font("Segoe UI", Font.BOLD, 12)); // NOI18N
        jLabel5.setText("Số điện thoại:");

        jLabel6.setFont(new java.awt.Font("Segoe UI", Font.BOLD, 12)); // NOI18N
        jLabel6.setText("Giới tính:");

        jLabel7.setFont(new java.awt.Font("Segoe UI", Font.BOLD, 12)); // NOI18N
        jLabel7.setText("Vị trí công việc:");

        cboGender.setModel(new javax.swing.DefaultComboBoxModel<>(new String[]{"Nam", "Nữ"}));

        btnAdd.setText("Thêm");
        btnAdd.addMouseListener(new java.awt.event.MouseAdapter() {
            public void mouseClicked(java.awt.event.MouseEvent evt) {
                btnAddMouseClicked();
            }
        });

        btnEdit.setText("Sửa");
        btnEdit.addMouseListener(new java.awt.event.MouseAdapter() {
            public void mouseClicked(java.awt.event.MouseEvent evt) {
                btnEditMouseClicked();
            }
        });

        btnDel.setText("Nghỉ việc");
        btnDel.addMouseListener(new java.awt.event.MouseAdapter() {
            public void mouseClicked(java.awt.event.MouseEvent evt) {
                btnDelMouseClicked(evt);
            }
        });

        btnSave.setText("Lưu");
        btnSave.addMouseListener(new java.awt.event.MouseAdapter() {
            public void mouseClicked(java.awt.event.MouseEvent evt) {
                btnSaveMouseClicked();
            }
        });

        btnReload.setText("Làm mới");
        btnReload.addMouseListener(new java.awt.event.MouseAdapter() {
            public void mouseClicked(java.awt.event.MouseEvent evt) {
                btnReloadMouseClicked();
            }
        });


        javax.swing.GroupLayout jPanel1Layout = new javax.swing.GroupLayout(jPanel1);
        jPanel1.setLayout(jPanel1Layout);
        jPanel1Layout.setHorizontalGroup(
                jPanel1Layout.createParallelGroup(javax.swing.GroupLayout.Alignment.LEADING)
                             .addGroup(jPanel1Layout.createSequentialGroup()
                                                    .addGap(14, 14, 14)
                                                    .addGroup(jPanel1Layout.createParallelGroup(javax.swing.GroupLayout.Alignment.LEADING)
                                                                           .addGroup(jPanel1Layout.createSequentialGroup()
                                                                                                  .addComponent(
                                                                                                          jLabel1,
                                                                                                          javax.swing.GroupLayout.PREFERRED_SIZE,
                                                                                                          84,
                                                                                                          javax.swing.GroupLayout.PREFERRED_SIZE
                                                                                                  )
                                                                                                  .addPreferredGap(javax.swing.LayoutStyle.ComponentPlacement.RELATED)
                                                                                                  .addComponent(
                                                                                                          txtId,
                                                                                                          javax.swing.GroupLayout.PREFERRED_SIZE,
                                                                                                          241,
                                                                                                          javax.swing.GroupLayout.PREFERRED_SIZE
                                                                                                  ))
                                                                           .addGroup(jPanel1Layout.createSequentialGroup()
                                                                                                  .addComponent(
                                                                                                          jLabel2,
                                                                                                          javax.swing.GroupLayout.PREFERRED_SIZE,
                                                                                                          84,
                                                                                                          javax.swing.GroupLayout.PREFERRED_SIZE
                                                                                                  )
                                                                                                  .addPreferredGap(javax.swing.LayoutStyle.ComponentPlacement.RELATED)
                                                                                                  .addComponent(
                                                                                                          txtFullname,
                                                                                                          javax.swing.GroupLayout.PREFERRED_SIZE,
                                                                                                          241,
                                                                                                          javax.swing.GroupLayout.PREFERRED_SIZE
                                                                                                  ))
                                                                           .addGroup(jPanel1Layout.createSequentialGroup()
                                                                                                  .addComponent(
                                                                                                          jLabel3,
                                                                                                          javax.swing.GroupLayout.PREFERRED_SIZE,
                                                                                                          84,
                                                                                                          javax.swing.GroupLayout.PREFERRED_SIZE
                                                                                                  )
                                                                                                  .addPreferredGap(javax.swing.LayoutStyle.ComponentPlacement.RELATED)
                                                                                                  .addComponent(
                                                                                                          txtDepartment,
                                                                                                          javax.swing.GroupLayout.PREFERRED_SIZE,
                                                                                                          241,
                                                                                                          javax.swing.GroupLayout.PREFERRED_SIZE
                                                                                                  ))
                                                                           .addGroup(
                                                                                   javax.swing.GroupLayout.Alignment.TRAILING,
                                                                                   jPanel1Layout.createSequentialGroup()
                                                                                                .addComponent(
                                                                                                        jLabel4,
                                                                                                        javax.swing.GroupLayout.PREFERRED_SIZE,
                                                                                                        84,
                                                                                                        javax.swing.GroupLayout.PREFERRED_SIZE
                                                                                                )
                                                                                                .addPreferredGap(javax.swing.LayoutStyle.ComponentPlacement.RELATED)
                                                                                                .addComponent(
                                                                                                        txtAddress,
                                                                                                        javax.swing.GroupLayout.PREFERRED_SIZE,
                                                                                                        241,
                                                                                                        javax.swing.GroupLayout.PREFERRED_SIZE
                                                                                                )
                                                                           ))
                                                    .addGroup(jPanel1Layout.createParallelGroup(javax.swing.GroupLayout.Alignment.LEADING)
                                                                           .addGroup(jPanel1Layout.createSequentialGroup()
                                                                                                  .addPreferredGap(
                                                                                                          javax.swing.LayoutStyle.ComponentPlacement.RELATED,
                                                                                                          javax.swing.GroupLayout.DEFAULT_SIZE,
                                                                                                          Short.MAX_VALUE
                                                                                                  )
                                                                                                  .addGroup(
                                                                                                          jPanel1Layout.createParallelGroup(
                                                                                                                               javax.swing.GroupLayout.Alignment.LEADING)
                                                                                                                       .addComponent(
                                                                                                                               jLabel5,
                                                                                                                               javax.swing.GroupLayout.Alignment.TRAILING,
                                                                                                                               javax.swing.GroupLayout.PREFERRED_SIZE,
                                                                                                                               116,
                                                                                                                               javax.swing.GroupLayout.PREFERRED_SIZE
                                                                                                                       )
                                                                                                                       .addComponent(
                                                                                                                               jLabel6,
                                                                                                                               javax.swing.GroupLayout.Alignment.TRAILING,
                                                                                                                               javax.swing.GroupLayout.PREFERRED_SIZE,
                                                                                                                               116,
                                                                                                                               javax.swing.GroupLayout.PREFERRED_SIZE
                                                                                                                       )
                                                                                                                       .addComponent(
                                                                                                                               jLabel7,
                                                                                                                               javax.swing.GroupLayout.Alignment.TRAILING,
                                                                                                                               javax.swing.GroupLayout.PREFERRED_SIZE,
                                                                                                                               116,
                                                                                                                               javax.swing.GroupLayout.PREFERRED_SIZE
                                                                                                                       ))
                                                                                                  .addPreferredGap(javax.swing.LayoutStyle.ComponentPlacement.RELATED)
                                                                                                  .addGroup(
                                                                                                          jPanel1Layout.createParallelGroup(
                                                                                                                               javax.swing.GroupLayout.Alignment.TRAILING,
                                                                                                                               false
                                                                                                                       )
                                                                                                                       .addComponent(
                                                                                                                               txtPhone)
                                                                                                                       .addComponent(
                                                                                                                               txtPosition)
                                                                                                                       .addComponent(
                                                                                                                               cboGender,
                                                                                                                               0,
                                                                                                                               287,
                                                                                                                               Short.MAX_VALUE
                                                                                                                       ))
                                                                                                  .addGap(27, 27, 27))
                                                                           .addGroup(jPanel1Layout.createSequentialGroup()
                                                                                                  .addGap(76, 76, 76)
                                                                                                  .addComponent(btnAdd)
                                                                                                  .addPreferredGap(javax.swing.LayoutStyle.ComponentPlacement.RELATED)
                                                                                                  .addComponent(
                                                                                                          btnEdit,
                                                                                                          javax.swing.GroupLayout.PREFERRED_SIZE,
                                                                                                          72,
                                                                                                          javax.swing.GroupLayout.PREFERRED_SIZE
                                                                                                  )
                                                                                                  .addPreferredGap(javax.swing.LayoutStyle.ComponentPlacement.RELATED)
                                                                                                  .addComponent(
                                                                                                          btnDel,
                                                                                                          javax.swing.GroupLayout.PREFERRED_SIZE,
                                                                                                          91,
                                                                                                          javax.swing.GroupLayout.PREFERRED_SIZE
                                                                                                  )
                                                                                                  .addPreferredGap(javax.swing.LayoutStyle.ComponentPlacement.UNRELATED)
                                                                                                  .addComponent(
                                                                                                          btnSave,
                                                                                                          javax.swing.GroupLayout.PREFERRED_SIZE,
                                                                                                          64,
                                                                                                          javax.swing.GroupLayout.PREFERRED_SIZE
                                                                                                  )
                                                                                                  .addGap(12, 12, 12)
                                                                                                  .addComponent(
                                                                                                          btnReload,
                                                                                                          javax.swing.GroupLayout.PREFERRED_SIZE,
                                                                                                          91,
                                                                                                          javax.swing.GroupLayout.PREFERRED_SIZE
                                                                                                  )
                                                                                                  .addContainerGap(
                                                                                                          108,
                                                                                                          Short.MAX_VALUE
                                                                                                  ))))
        );
        jPanel1Layout.setVerticalGroup(
                jPanel1Layout.createParallelGroup(javax.swing.GroupLayout.Alignment.LEADING)
                             .addGroup(jPanel1Layout.createSequentialGroup()
                                                    .addContainerGap()
                                                    .addGroup(jPanel1Layout.createParallelGroup(javax.swing.GroupLayout.Alignment.LEADING)
                                                                           .addGroup(jPanel1Layout.createSequentialGroup()
                                                                                                  .addComponent(
                                                                                                          jLabel5,
                                                                                                          javax.swing.GroupLayout.PREFERRED_SIZE,
                                                                                                          34,
                                                                                                          javax.swing.GroupLayout.PREFERRED_SIZE
                                                                                                  )
                                                                                                  .addGap(
                                                                                                          0,
                                                                                                          0,
                                                                                                          Short.MAX_VALUE
                                                                                                  ))
                                                                           .addGroup(jPanel1Layout.createSequentialGroup()
                                                                                                  .addGroup(
                                                                                                          jPanel1Layout.createParallelGroup(
                                                                                                                               javax.swing.GroupLayout.Alignment.LEADING,
                                                                                                                               false
                                                                                                                       )
                                                                                                                       .addComponent(
                                                                                                                               txtId)
                                                                                                                       .addComponent(
                                                                                                                               jLabel1,
                                                                                                                               javax.swing.GroupLayout.DEFAULT_SIZE,
                                                                                                                               javax.swing.GroupLayout.DEFAULT_SIZE,
                                                                                                                               Short.MAX_VALUE
                                                                                                                       )
                                                                                                                       .addComponent(
                                                                                                                               txtPhone,
                                                                                                                               javax.swing.GroupLayout.DEFAULT_SIZE,
                                                                                                                               34,
                                                                                                                               Short.MAX_VALUE
                                                                                                                       ))
                                                                                                  .addPreferredGap(javax.swing.LayoutStyle.ComponentPlacement.RELATED)
                                                                                                  .addGroup(
                                                                                                          jPanel1Layout.createParallelGroup(
                                                                                                                               javax.swing.GroupLayout.Alignment.TRAILING)
                                                                                                                       .addComponent(
                                                                                                                               jLabel6,
                                                                                                                               javax.swing.GroupLayout.PREFERRED_SIZE,
                                                                                                                               34,
                                                                                                                               javax.swing.GroupLayout.PREFERRED_SIZE
                                                                                                                       )
                                                                                                                       .addComponent(
                                                                                                                               cboGender,
                                                                                                                               javax.swing.GroupLayout.PREFERRED_SIZE,
                                                                                                                               36,
                                                                                                                               javax.swing.GroupLayout.PREFERRED_SIZE
                                                                                                                       )
                                                                                                                       .addGroup(
                                                                                                                               jPanel1Layout.createParallelGroup(
                                                                                                                                                    javax.swing.GroupLayout.Alignment.LEADING,
                                                                                                                                                    false
                                                                                                                                            )
                                                                                                                                            .addComponent(
                                                                                                                                                    txtFullname)
                                                                                                                                            .addComponent(
                                                                                                                                                    jLabel2,
                                                                                                                                                    javax.swing.GroupLayout.PREFERRED_SIZE,
                                                                                                                                                    34,
                                                                                                                                                    javax.swing.GroupLayout.PREFERRED_SIZE
                                                                                                                                            )))
                                                                                                  .addPreferredGap(javax.swing.LayoutStyle.ComponentPlacement.RELATED)
                                                                                                  .addGroup(
                                                                                                          jPanel1Layout.createParallelGroup(
                                                                                                                               javax.swing.GroupLayout.Alignment.LEADING)
                                                                                                                       .addGroup(
                                                                                                                               jPanel1Layout.createSequentialGroup()
                                                                                                                                            .addComponent(
                                                                                                                                                    jLabel7,
                                                                                                                                                    javax.swing.GroupLayout.DEFAULT_SIZE,
                                                                                                                                                    javax.swing.GroupLayout.DEFAULT_SIZE,
                                                                                                                                                    Short.MAX_VALUE
                                                                                                                                            )
                                                                                                                                            .addGap(
                                                                                                                                                    12,
                                                                                                                                                    12,
                                                                                                                                                    12
                                                                                                                                            ))
                                                                                                                       .addComponent(
                                                                                                                               txtPosition)
                                                                                                                       .addGroup(
                                                                                                                               jPanel1Layout.createSequentialGroup()
                                                                                                                                            .addGap(
                                                                                                                                                    0,
                                                                                                                                                    0,
                                                                                                                                                    Short.MAX_VALUE
                                                                                                                                            )
                                                                                                                                            .addGroup(
                                                                                                                                                    jPanel1Layout.createParallelGroup(
                                                                                                                                                                         javax.swing.GroupLayout.Alignment.LEADING,
                                                                                                                                                                         false
                                                                                                                                                                 )
                                                                                                                                                                 .addComponent(
                                                                                                                                                                         txtDepartment)
                                                                                                                                                                 .addComponent(
                                                                                                                                                                         jLabel3,
                                                                                                                                                                         javax.swing.GroupLayout.PREFERRED_SIZE,
                                                                                                                                                                         34,
                                                                                                                                                                         javax.swing.GroupLayout.PREFERRED_SIZE
                                                                                                                                                                 ))))
                                                                                                  .addGap(18, 18, 18)
                                                                                                  .addGroup(
                                                                                                          jPanel1Layout.createParallelGroup(
                                                                                                                               javax.swing.GroupLayout.Alignment.LEADING,
                                                                                                                               false
                                                                                                                       )
                                                                                                                       .addGroup(
                                                                                                                               jPanel1Layout.createParallelGroup(
                                                                                                                                                    javax.swing.GroupLayout.Alignment.BASELINE)
                                                                                                                                            .addComponent(
                                                                                                                                                    txtAddress,
                                                                                                                                                    javax.swing.GroupLayout.PREFERRED_SIZE,
                                                                                                                                                    48,
                                                                                                                                                    javax.swing.GroupLayout.PREFERRED_SIZE
                                                                                                                                            )
                                                                                                                                            .addComponent(
                                                                                                                                                    btnAdd,
                                                                                                                                                    javax.swing.GroupLayout.PREFERRED_SIZE,
                                                                                                                                                    35,
                                                                                                                                                    javax.swing.GroupLayout.PREFERRED_SIZE
                                                                                                                                            )
                                                                                                                                            .addComponent(
                                                                                                                                                    btnEdit,
                                                                                                                                                    javax.swing.GroupLayout.PREFERRED_SIZE,
                                                                                                                                                    35,
                                                                                                                                                    javax.swing.GroupLayout.PREFERRED_SIZE
                                                                                                                                            )
                                                                                                                                            .addComponent(
                                                                                                                                                    btnDel,
                                                                                                                                                    javax.swing.GroupLayout.PREFERRED_SIZE,
                                                                                                                                                    35,
                                                                                                                                                    javax.swing.GroupLayout.PREFERRED_SIZE
                                                                                                                                            )
                                                                                                                                            .addComponent(
                                                                                                                                                    btnSave,
                                                                                                                                                    javax.swing.GroupLayout.PREFERRED_SIZE,
                                                                                                                                                    35,
                                                                                                                                                    javax.swing.GroupLayout.PREFERRED_SIZE
                                                                                                                                            )
                                                                                                                                            .addComponent(
                                                                                                                                                    btnReload,
                                                                                                                                                    javax.swing.GroupLayout.PREFERRED_SIZE,
                                                                                                                                                    35,
                                                                                                                                                    javax.swing.GroupLayout.PREFERRED_SIZE
                                                                                                                                            ))
                                                                                                                       .addComponent(
                                                                                                                               jLabel4,
                                                                                                                               javax.swing.GroupLayout.PREFERRED_SIZE,
                                                                                                                               34,
                                                                                                                               javax.swing.GroupLayout.PREFERRED_SIZE
                                                                                                                       ))
                                                                                                  .addGap(17, 17, 17))))
        );

        add(jPanel1, java.awt.BorderLayout.NORTH);

        tblData.setModel(new javax.swing.table.DefaultTableModel(
                new Object[][]{
                        {null, null, null, null, null, null, null, null},
                        {null, null, null, null, null, null, null, null},
                        {null, null, null, null, null, null, null, null},
                        {null, null, null, null, null, null, null, null}
                },
                new String[]{
                        "Mã nhân viên", "Tên nhân viên", "Phòng ban", "Địa chỉ", "Số điện thoại", "Giới tính", "Vị trí công việc", "Tình trạng"
                }
        ));
        scrollData.setViewportView(tblData);
        if (tblData.getColumnModel().getColumnCount() > 0) {
            tblData.getColumnModel().getColumn(0).setResizable(false);
            tblData.getColumnModel().getColumn(1).setResizable(false);
            tblData.getColumnModel().getColumn(2).setResizable(false);
            tblData.getColumnModel().getColumn(3).setResizable(false);
            tblData.getColumnModel().getColumn(4).setResizable(false);
            tblData.getColumnModel().getColumn(5).setResizable(false);
            tblData.getColumnModel().getColumn(6).setResizable(false);
        }

        add(scrollData, java.awt.BorderLayout.CENTER);
    }// </editor-fold>//GEN-END:initComponents

    private void btnAddMouseClicked() {//GEN-FIRST:event_btnAddMouseClicked
        // TODO add your handling code here:
        isAdd = true;
        enableTextbox();
        clearTextbox();
        enableButton();
        txtFullname.requestFocus();

    }//GEN-LAST:event_btnAddMouseClicked

    private void btnSaveMouseClicked() {//GEN-FIRST:event_btnSaveMouseClicked
        // TODO add your handling code here:
        try {
            // Kiểm tra tên
            if (!isNameValid(txtFullname.getText())) {
                JOptionPane.showMessageDialog(null, "Tên không hợp lệ", "Lỗi", JOptionPane.WARNING_MESSAGE);
                return;
            }

            // Kiểm tra số điện thoại
            if (!isPhoneNumberValid(txtPhone.getText())) {
                JOptionPane.showMessageDialog(null, "Số điện thoại không hợp lệ", "Lỗi", JOptionPane.WARNING_MESSAGE);
                return;
            }

            // Kiểm tra dữ liệu trống cho các thuộc tính khác
            if (txtAddress.getText().trim().isEmpty()) {
                JOptionPane.showMessageDialog(null, "Địa chỉ không được để trống", "Lỗi", JOptionPane.WARNING_MESSAGE);
                return;
            }

            if (txtDepartment.getText().trim().isEmpty()) {
                JOptionPane.showMessageDialog(
                        null,
                        "Phòng ban không được để trống",
                        "Lỗi",
                        JOptionPane.WARNING_MESSAGE
                );
                return;
            }

            if (cboGender.getSelectedItem().toString().trim().isEmpty()) {
                JOptionPane.showMessageDialog(
                        null,
                        "Giới tính không được để trống",
                        "Lỗi",
                        JOptionPane.WARNING_MESSAGE
                );
                return;
            }
            if (txtPosition.getText().trim().isEmpty()) {
                JOptionPane.showMessageDialog(null, "Vị trí không được để trống", "Lỗi", JOptionPane.WARNING_MESSAGE);
                return;
            }
            if (!isNameValid(txtFullname.getText().trim())) {
                JOptionPane.showMessageDialog(null, "Tên không hợp lệ", "Lỗi", JOptionPane.WARNING_MESSAGE);
                return;
            }

            if (!isPhoneNumberValid(txtPhone.getText().trim())) {
                JOptionPane.showMessageDialog(null, "Số điện thoại không hợp lệ", "Lỗi", JOptionPane.WARNING_MESSAGE);
                return;
            }
            var idEmployee = txtId.getText().isEmpty() ? 0 : Integer.parseInt(txtId.getText());
            if (EmployeeDAO.getInstance().checkIsExistPhone(txtPhone.getText().trim(), idEmployee)) {
                JOptionPane.showMessageDialog(null, "Số điện thoại đã tồn tại", "Lỗi", JOptionPane.WARNING_MESSAGE);
                return;
            }

            var emp = new Employee();
            emp.setAddress(txtAddress.getText().trim());
            emp.setDepartment(txtDepartment.getText().trim());
            emp.setFullName(txtFullname.getText().trim());
            emp.setGender(cboGender.getSelectedItem().toString());
            emp.setId(txtId.getText().isEmpty() ? 0 : Integer.parseInt(txtId.getText()));
            emp.setPhone(txtPhone.getText().trim());
            emp.setPosition(txtPosition.getText().trim());
            if (isAdd) {
                var isSuccess = EmployeeDAO.getInstance().add(emp);
                if (isSuccess) {
                    JOptionPane.showMessageDialog(null, "Thành công", "Thông báo", JOptionPane.INFORMATION_MESSAGE);
                }
            } else {
                if (EmployeeDAO.getInstance().update(emp)) {
                    JOptionPane.showMessageDialog(
                            null,
                            "Cập nhật thành công",
                            "Thông báo",
                            JOptionPane.INFORMATION_MESSAGE
                    );
                }
            }
            reload();
        } catch (Exception e) {
            JOptionPane.showMessageDialog(null, e.getMessage(), "Lỗi", JOptionPane.WARNING_MESSAGE);
        }
    }//GEN-LAST:event_btnSaveMouseClicked

    private void reload() {
        fillData();
        clearTextbox();
        disableButton();
        disableTextbox();
    }

    private void btnEditMouseClicked() {//GEN-FIRST:event_btnEditMouseClicked
        // TODO add your handling code here:
        isAdd = false;
        enableButton();
        enableTextbox();
        txtFullname.requestFocus();
    }//GEN-LAST:event_btnEditMouseClicked

    private void btnDelMouseClicked(java.awt.event.MouseEvent ignoredEvt) {//GEN-FIRST:event_btnDelMouseClicked
        if (!txtId.getText().isEmpty()) {
            int option = JOptionPane.showConfirmDialog(null, "Bạn có muốn nhân viên này nghỉ không?", "Xác nhận",
                                                       JOptionPane.YES_NO_OPTION
            );
            if (option == JOptionPane.YES_OPTION) {
                EmployeeDAO.getInstance().delete(Integer.parseInt(txtId.getText()));
                reload();
            }
        } else {
            JOptionPane.showMessageDialog(
                    null,
                    "Vui lòng chọn nhân viên muốn nhân viên này nghỉ",
                    "Lỗi",
                    JOptionPane.WARNING_MESSAGE
            );
        }
    }//GEN-LAST:event_btnDelMouseClicked

    private void btnReloadMouseClicked() {//GEN-FIRST:event_btnReloadMouseClicked
        // TODO add your handling code here:
        reload();
    }//GEN-LAST:event_btnReloadMouseClicked

    private javax.swing.table.DefaultTableModel tableModel;
    // Variables declaration - do not modify//GEN-BEGIN:variables
    private javax.swing.JButton btnAdd;
    private javax.swing.JButton btnDel;
    private javax.swing.JButton btnEdit;
    private javax.swing.JButton btnSave;
    private javax.swing.JComboBox<String> cboGender;
    private javax.swing.JTable tblData;
    private javax.swing.JTextField txtAddress;
    private javax.swing.JTextField txtDepartment;
    private javax.swing.JTextField txtFullname;
    private javax.swing.JTextField txtId;
    private javax.swing.JTextField txtPhone;
    private javax.swing.JTextField txtPosition;
    // End of variables declaration//GEN-END:variables
}
