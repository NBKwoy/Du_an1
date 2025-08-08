import javax.swing.*;
import java.awt.*;
import java.awt.event.ActionEvent;
import java.awt.event.ActionListener;

public class DoiMatKhauForm extends JFrame {

    private JPasswordField tfMatKhauCu, tfMatKhauMoi, tfNhapLaiMatKhauMoi;
    private JButton btnDoiMatKhau;

    public DoiMatKhauForm() {
        setTitle("Đổi mật khẩu");
        setSize(400, 300);
        setDefaultCloseOperation(JFrame.DISPOSE_ON_CLOSE);
        setLocationRelativeTo(null);
        setLayout(null);

        // Tiêu đề
        JLabel lblTitle = new JLabel("Đổi mật khẩu", SwingConstants.CENTER);
        lblTitle.setFont(new Font("Arial", Font.BOLD, 24));
        lblTitle.setBounds(50, 20, 300, 30);
        add(lblTitle);

        // Label và field: Mật khẩu cũ
        JLabel lblOldPass = new JLabel("Mật khẩu cũ:");
        lblOldPass.setBounds(50, 70, 120, 25);
        add(lblOldPass);

        tfMatKhauCu = new JPasswordField();
        tfMatKhauCu.setBounds(180, 70, 150, 25);
        add(tfMatKhauCu);

        // Mật khẩu mới
        JLabel lblNewPass = new JLabel("Nhập mật khẩu mới:");
        lblNewPass.setBounds(50, 110, 120, 25);
        add(lblNewPass);

        tfMatKhauMoi = new JPasswordField();
        tfMatKhauMoi.setBounds(180, 110, 150, 25);
        add(tfMatKhauMoi);

        // Nhập lại mật khẩu
        JLabel lblConfirmPass = new JLabel("Nhập lại mật khẩu mới:");
        lblConfirmPass.setBounds(50, 150, 140, 25);
        add(lblConfirmPass);

        tfNhapLaiMatKhauMoi = new JPasswordField();
        tfNhapLaiMatKhauMoi.setBounds(180, 150, 150, 25);
        add(tfNhapLaiMatKhauMoi);

        // Nút đổi mật khẩu
        btnDoiMatKhau = new JButton("Đổi mật khẩu");
        btnDoiMatKhau.setBounds(130, 200, 120, 30);
        add(btnDoiMatKhau);

        // Xử lý sự kiện đổi mật khẩu (demo)
        btnDoiMatKhau.addActionListener(new ActionListener() {
            @Override
            public void actionPerformed(ActionEvent e) {
                String oldPass = String.valueOf(tfMatKhauCu.getPassword());
                String newPass = String.valueOf(tfMatKhauMoi.getPassword());
                String confirmPass = String.valueOf(tfNhapLaiMatKhauMoi.getPassword());

                // Kiểm tra đơn giản
                if (oldPass.isEmpty() || newPass.isEmpty() || confirmPass.isEmpty()) {
                    JOptionPane.showMessageDialog(DoiMatKhauForm.this, "Vui lòng điền đầy đủ thông tin.");
                } else if (!newPass.equals(confirmPass)) {
                    JOptionPane.showMessageDialog(DoiMatKhauForm.this, "Mật khẩu mới không khớp.");
                } else {
                    // Ở đây bạn có thể gọi CSDL để cập nhật mật khẩu
                    JOptionPane.showMessageDialog(DoiMatKhauForm.this, "Đổi mật khẩu thành công!");
                    dispose(); // Đóng form
                }
            }
        });
    }

    public static void main(String[] args) {
        SwingUtilities.invokeLater(() -> {
            new DoiMatKhauForm().setVisible(true);
        });
    }
}
