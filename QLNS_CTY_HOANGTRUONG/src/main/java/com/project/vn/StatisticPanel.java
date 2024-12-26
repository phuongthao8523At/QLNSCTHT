package com.project.vn;

import com.project.vn.dao.EmployeeDAO;
import org.jfree.chart.ChartFactory;
import org.jfree.chart.ChartPanel;
import org.jfree.chart.JFreeChart;
import org.jfree.data.general.DefaultPieDataset;

import javax.swing.*;
import java.awt.*;
import java.sql.SQLException;
import java.util.ArrayList;

public class StatisticPanel extends JPanel {
    public StatisticPanel() throws SQLException {
        initComponents();
    }

    private void initComponents() throws SQLException {
        // Set the size of the panel
        setMaximumSize(new java.awt.Dimension(893, 600));
        setMinimumSize(new java.awt.Dimension(893, 600));
        setPreferredSize(new java.awt.Dimension(893, 600));
        setLayout(new java.awt.BorderLayout());
        ArrayList<Integer> list = EmployeeDAO.getInstance().getStatisticEmployee();
        // Create list cards with fixed dimensions
        JPanel listCards = new JPanel();
        listCards.setLayout(new java.awt.GridLayout(3, 3, 10, 10));
        listCards.setMaximumSize(new java.awt.Dimension(893, 600));
        listCards.setMinimumSize(new java.awt.Dimension(893, 600));
        listCards.setPreferredSize(new java.awt.Dimension(893, 600));

        // Define fixed dimensions for the cards
        java.awt.Dimension cardSize = new java.awt.Dimension(200, 200);
        int sizeLb = 18;

        // Create card 1
        JPanel card1 = new JPanel();
        card1.setBackground(new java.awt.Color(255, 255, 255));
        card1.setLayout(new java.awt.BorderLayout());
        card1.setPreferredSize(cardSize);
        card1.setMinimumSize(cardSize);
        card1.setMaximumSize(cardSize);
        JLabel label1 = new JLabel();
        label1.setFont(new java.awt.Font("Tahoma", Font.BOLD, sizeLb)); // NOI18N
        label1.setForeground(new java.awt.Color(0, 0, 0));
        label1.setHorizontalAlignment(javax.swing.SwingConstants.CENTER);
        label1.setText("Số lượng nhân viên đang làm việc: %s".formatted(list.get(0)));
        card1.add(label1, java.awt.BorderLayout.CENTER);
        listCards.add(card1);

        // Create card 2
        JPanel card2 = new JPanel();
        card2.setBackground(new java.awt.Color(255, 255, 255));
        card2.setLayout(new java.awt.BorderLayout());
        card2.setPreferredSize(cardSize);
        card2.setMinimumSize(cardSize);
        card2.setMaximumSize(cardSize);
        JLabel label2 = new JLabel();
        label2.setFont(new java.awt.Font("Tahoma", Font.BOLD, sizeLb)); // NOI18N
        label2.setForeground(new java.awt.Color(0, 0, 0));
        label2.setHorizontalAlignment(javax.swing.SwingConstants.CENTER);
        label2.setText("Số lượng nhân viên nghỉ: %s".formatted(list.get(1)));
        card2.add(label2, java.awt.BorderLayout.CENTER);
        listCards.add(card2);

        JPanel card3 = new JPanel();
        card3.setBackground(new java.awt.Color(255, 255, 255));
        card3.setLayout(new java.awt.BorderLayout());
        card3.setPreferredSize(cardSize);
        card3.setMinimumSize(cardSize);
        card3.setMaximumSize(cardSize);
        JLabel label3 = new JLabel();
        label3.setFont(new java.awt.Font("Tahoma", Font.BOLD, sizeLb)); // NOI18N
        label3.setForeground(new java.awt.Color(0, 0, 0));
        label3.setHorizontalAlignment(javax.swing.SwingConstants.CENTER);
        label3.setText("Số lượng nhân viên vào năm nay: %s".formatted(list.get(3)));
        card3.add(label3, java.awt.BorderLayout.CENTER);
        listCards.add(card3);

        JPanel card4 = new JPanel();
        card4.setBackground(new java.awt.Color(255, 255, 255));
        card4.setLayout(new java.awt.BorderLayout());
        card4.setPreferredSize(cardSize);
        card4.setMinimumSize(cardSize);
        card4.setMaximumSize(cardSize);
        JLabel label4 = new JLabel();
        label4.setFont(new java.awt.Font("Tahoma", Font.BOLD, sizeLb)); // NOI18N
        label4.setForeground(new java.awt.Color(0, 0, 0));
        label4.setHorizontalAlignment(javax.swing.SwingConstants.CENTER);
        label4.setText("Số lượng nhân viên ra năm nay: %s".formatted(list.get(2)));
        card4.add(label4, java.awt.BorderLayout.CENTER);
        listCards.add(card4);

        JPanel card5 = new JPanel();
        card5.setBackground(new java.awt.Color(255, 255, 255));
        card5.setLayout(new java.awt.BorderLayout());
        card5.setPreferredSize(cardSize);
        card5.setMinimumSize(cardSize);
        card5.setMaximumSize(cardSize);
        DefaultPieDataset dataset = new DefaultPieDataset();
        dataset.setValue("Số lượng nhân viên vào trong năm", list.get(3));
        dataset.setValue("Số lượng nhân viên nghỉ trong năm", list.get(2));
        JFreeChart pieChart = ChartFactory.createPieChart(
                "CƠ CẤU NHÂN VIÊN VÀO RA TRONG NĂM", dataset, true, true, true);
        ChartPanel chartPanel = new ChartPanel(pieChart);
        card5.add(chartPanel, java.awt.BorderLayout.CENTER);
        listCards.add(card5);

        JPanel card6 = new JPanel();
        card6.setBackground(new java.awt.Color(255, 255, 255));
        card6.setLayout(new java.awt.BorderLayout());
        card6.setPreferredSize(cardSize);
        card6.setMinimumSize(cardSize);
        card6.setMaximumSize(cardSize);
        DefaultPieDataset dataset2 = new DefaultPieDataset();
        dataset2.setValue("Số lượng nhân viên vào", list.get(0));
        dataset2.setValue("Số lượng nhân viên nghỉ", list.get(1));
        JFreeChart pieChart2 = ChartFactory.createPieChart(
                "CƠ CẤU NHÂN VIÊN VÀO RA", dataset2, true, true, true);
        ChartPanel chartPanel2 = new ChartPanel(pieChart2);
        card6.add(chartPanel2, java.awt.BorderLayout.CENTER);
        listCards.add(card6);

        add(listCards, java.awt.BorderLayout.CENTER);
    }
}
