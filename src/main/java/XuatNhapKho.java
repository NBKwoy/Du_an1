import javax.swing.*;
import java.awt.*;

public class XuatNhapKho extends JFrame {
    // Khai báo các thành phần giao diện
    private JTable table;
    private JTextField tfSearch, tfMaSP, tfTenSP, tfLoai, tfSoLuong, tfSize;
    private JButton btnTim, btnThem, btnXoa, btnSua, btnNhapLai;
    private JRadioButton rbXuat, rbNhap;
    private ButtonGroup trangThaiGroup;
    
    public XuatNhapKho() {
        setTitle("Quản lý xuất nhập kho");
        setSize(900, 600);
        setDefaultCloseOperation(JFrame.EXIT_ON_CLOSE);
        setLocationRelativeTo(null);

        setLayout(null);

        // Tiêu đề
        JLabel lblTitle = new JLabel("Quản lý xuất nhập kho", SwingConstants.CENTER);
        lblTitle.setFont(new Font("Arial", Font.BOLD, 24));
        lblTitle.setBounds(250, 10, 400, 30);
        add(lblTitle);

        // Ô tìm kiếm
        tfSearch = new JTextField("search");
        tfSearch.setBounds(30, 50, 200, 25);
        add(tfSearch);

        btnTim = new JButton("Tìm");
        btnTim.setBounds(240, 50, 60, 25);
        add(btnTim);

        // Bảng dữ liệu
        String[] columnNames = {"Mã SP", "Tên SP", "Loại", "SL", "Size", "Trạng thái"};
        Object[][] data = {};
        table = new JTable(data, columnNames);
        JScrollPane scrollPane = new JScrollPane(table);
        scrollPane.setBounds(30, 90, 500, 300);
        add(scrollPane);

        // Điều hướng trang
        JPanel navPanel = new JPanel();
        navPanel.setBounds(30, 400, 500, 40);
        navPanel.setLayout(new FlowLayout());
        navPanel.add(new JButton("<<"));
        navPanel.add(new JButton("<"));
        navPanel.add(new JButton(">"));
        navPanel.add(new JButton(">>"));
        add(navPanel);

        // Các ô nhập liệu bên phải
        int xRight = 550, width = 300, h = 25, y = 90, gap = 35;

        addLabelAndField("Mã sản phẩm:", xRight, y, width, h, tfMaSP = new JTextField());
        y += gap;
        addLabelAndField("Tên sản phẩm:", xRight, y, width, h, tfTenSP = new JTextField());
        y += gap;
        addLabelAndField("Loại:", xRight, y, width, h, tfLoai = new JTextField());
        y += gap;
        addLabelAndField("Số lượng:", xRight, y, width, h, tfSoLuong = new JTextField());
        y += gap;
        addLabelAndField("Size:", xRight, y, width, h, tfSize = new JTextField());

        // Trạng thái radio button
        JLabel lblTrangThai = new JLabel("Trạng thái:");
        lblTrangThai.setBounds(xRight, y, 100, h);
        add(lblTrangThai);

        rbXuat = new JRadioButton("Xuất kho");
        rbNhap = new JRadioButton("Nhập kho");
        rbXuat.setBounds(xRight + 100, y, 100, h);
        rbNhap.setBounds(xRight + 200, y, 100, h);

        trangThaiGroup = new ButtonGroup();
        trangThaiGroup.add(rbXuat);
        trangThaiGroup.add(rbNhap);

        add(rbXuat);
        add(rbNhap);

        // Nút chức năng
        btnThem = new JButton("Thêm");
        btnXoa = new JButton("Xóa");
        btnSua = new JButton("Sửa");
        btnNhapLai = new JButton("Nhập lại");

        int buttonY = y + 50;
        btnThem.setBounds(xRight, buttonY, 80, 30);
        btnXoa.setBounds(xRight + 90, buttonY, 80, 30);
        btnSua.setBounds(xRight + 180, buttonY, 80, 30);
        btnNhapLai.setBounds(xRight + 270, buttonY, 90, 30);

        add(btnThem);
        add(btnXoa);
        add(btnSua);
        add(btnNhapLai);
    }

    private void addLabelAndField(String label, int x, int y, int width, int height, JTextField field) {
        JLabel lbl = new JLabel(label);
        lbl.setBounds(x, y, 100, height);
        field.setBounds(x + 100, y, width - 100, height);
        add(lbl);
        add(field);
    }

    public static void main(String[] args) {
        SwingUtilities.invokeLater(() -> {
            new XuatNhapKho().setVisible(true);
        });
    }
}
