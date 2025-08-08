package com.duan1.ui;
import javax.swing.*;
import javax.swing.table.DefaultTableModel;
import java.awt.*;

public class QuanLyNhanVienForm extends JFrame {
    private JTable table;
    private JTextField txtTim, txtMaNV, txtTenNV, txtTaiKhoan, txtMatKhau, txtSDT;
    private JButton btnTimKiem, btnThem, btnXoa, btnSua, btnNhapLai;
    private JRadioButton rdoNhanVien, rdoQuanLy;
    private ButtonGroup chucVuGroup;

    public QuanLyNhanVienForm() {
        setTitle("Quản lý nhân viên");
        setSize(1100, 650);
        setDefaultCloseOperation(JFrame.EXIT_ON_CLOSE);
        setLocationRelativeTo(null);

        JPanel mainPanel = new JPanel(new BorderLayout(10, 10));
        mainPanel.setBorder(BorderFactory.createEmptyBorder(10, 10, 10, 10));
        mainPanel.setBackground(new Color(245, 250, 255)); // nền pastel

        // ===== Tiêu đề =====
        JLabel lblTitle = new JLabel("Quản lý nhân viên", JLabel.CENTER);
        lblTitle.setFont(new Font("Segoe UI", Font.BOLD, 28));
        lblTitle.setForeground(new Color(30, 60, 90));
        mainPanel.add(lblTitle, BorderLayout.NORTH);

        // ===== Trung tâm =====
        JPanel centerPanel = new JPanel(new GridLayout(1, 2, 20, 10));
        centerPanel.setOpaque(false);

        // ==== Panel trái: bảng + tìm kiếm + phân trang ====
        JPanel leftPanel = new JPanel(new BorderLayout(10, 10));
        leftPanel.setOpaque(false);

        // Tìm kiếm
        JPanel searchPanel = new JPanel(new FlowLayout(FlowLayout.LEFT));
        searchPanel.setOpaque(false);
        searchPanel.add(new JLabel("Tìm nhân viên:"));
        txtTim = new JTextField(20);
        btnTimKiem = new JButton("Tìm kiếm");
        searchPanel.add(txtTim);
        searchPanel.add(btnTimKiem);
        leftPanel.add(searchPanel, BorderLayout.NORTH);

        // Bảng
        String[] columnNames = {"Mã NV", "Tên NV", "Tên tài khoản", "Mật khẩu", "Chức vụ", "SDT"};
        DefaultTableModel model = new DefaultTableModel(columnNames, 0);
        table = new JTable(model);
        table.setRowHeight(24);
        table.setShowGrid(true);
        table.setGridColor(Color.LIGHT_GRAY);
        table.getTableHeader().setFont(new Font("Segoe UI", Font.BOLD, 14));
        table.setFont(new Font("Segoe UI", Font.PLAIN, 13));
        JScrollPane scrollPane = new JScrollPane(table);
        leftPanel.add(scrollPane, BorderLayout.CENTER);

        // Phân trang
        JPanel pagingPanel = new JPanel(new FlowLayout(FlowLayout.CENTER));
        pagingPanel.setOpaque(false);
        pagingPanel.add(new JButton("<<"));
        pagingPanel.add(new JButton("<"));
        pagingPanel.add(new JButton(">"));
        pagingPanel.add(new JButton(">>"));
        leftPanel.add(pagingPanel, BorderLayout.SOUTH);

        centerPanel.add(leftPanel);

        // ==== Panel phải: form nhập liệu ====
        JPanel rightPanel = new JPanel(new GridBagLayout());
        rightPanel.setOpaque(false);
        GridBagConstraints gbc = new GridBagConstraints();
        gbc.insets = new Insets(5, 5, 5, 5);
        gbc.anchor = GridBagConstraints.WEST;

        int row = 0;
        gbc.gridx = 0; gbc.gridy = row; rightPanel.add(new JLabel("Mã nhân viên:"), gbc);
        txtMaNV = new JTextField(20); gbc.gridx = 1;
        rightPanel.add(txtMaNV, gbc);

        row++;
        gbc.gridx = 0; gbc.gridy = row; rightPanel.add(new JLabel("Tên nhân viên:"), gbc);
        txtTenNV = new JTextField(20); gbc.gridx = 1;
        rightPanel.add(txtTenNV, gbc);

        row++;
        gbc.gridx = 0; gbc.gridy = row; rightPanel.add(new JLabel("Tên tài khoản:"), gbc);
        txtTaiKhoan = new JTextField(20); gbc.gridx = 1;
        rightPanel.add(txtTaiKhoan, gbc);

        row++;
        gbc.gridx = 0; gbc.gridy = row; rightPanel.add(new JLabel("Mật khẩu:"), gbc);
        txtMatKhau = new JTextField(20); gbc.gridx = 1;
        rightPanel.add(txtMatKhau, gbc);

        row++;
        gbc.gridx = 0; gbc.gridy = row; rightPanel.add(new JLabel("Chức vụ:"), gbc);
        JPanel chucVuPanel = new JPanel(new FlowLayout(FlowLayout.LEFT));
        chucVuPanel.setOpaque(false);
        rdoNhanVien = new JRadioButton("Nhân viên");
        rdoQuanLy = new JRadioButton("Quản lý");
        rdoNhanVien.setOpaque(false); rdoQuanLy.setOpaque(false);
        chucVuGroup = new ButtonGroup();
        chucVuGroup.add(rdoNhanVien);
        chucVuGroup.add(rdoQuanLy);
        rdoNhanVien.setSelected(true);
        chucVuPanel.add(rdoNhanVien);
        chucVuPanel.add(rdoQuanLy);
        gbc.gridx = 1;
        rightPanel.add(chucVuPanel, gbc);

        row++;
        gbc.gridx = 0; gbc.gridy = row; rightPanel.add(new JLabel("Số điện thoại:"), gbc);
        txtSDT = new JTextField(20); gbc.gridx = 1;
        rightPanel.add(txtSDT, gbc);

        // ==== Nút chức năng ====
        row++;
        gbc.gridx = 0; gbc.gridy = row; gbc.gridwidth = 2;
        JPanel btnPanel = new JPanel(new FlowLayout(FlowLayout.CENTER));
        btnPanel.setOpaque(false);
        btnThem = new JButton("Thêm");
        btnXoa = new JButton("Xóa");
        btnSua = new JButton("Sửa");
        btnNhapLai = new JButton("Nhập lại");

        Font btnFont = new Font("Segoe UI", Font.PLAIN, 13);
        for (JButton btn : new JButton[]{btnThem, btnXoa, btnSua, btnNhapLai}) {
            btn.setFont(btnFont);
            btn.setPreferredSize(new Dimension(90, 30));
            btnPanel.add(btn);
        }

        rightPanel.add(btnPanel, gbc);
        centerPanel.add(rightPanel);

        mainPanel.add(centerPanel, BorderLayout.CENTER);
        add(mainPanel);
        setVisible(true);
    }

    public static void main(String[] args) {
        SwingUtilities.invokeLater(QuanLyNhanVienForm::new);
    }
}
