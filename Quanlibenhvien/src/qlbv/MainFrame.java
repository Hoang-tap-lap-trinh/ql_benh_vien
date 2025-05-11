package qlbv;

import java.awt.BorderLayout;

import java.awt.Color;
import java.awt.Font;
import java.awt.GridLayout;
import java.awt.Image;
import java.awt.Toolkit;
import java.net.URL;

import javax.swing.BorderFactory;
import javax.swing.ImageIcon;
import javax.swing.JButton;
import javax.swing.JFrame;
import javax.swing.JLabel;
import javax.swing.JPanel;
import javax.swing.SwingConstants;


public class MainFrame extends JFrame {
	public JPanel contentPanel;
	public MainFrame() {
        // Cấu hình JFrame
        setTitle("Quản lý bệnh viện");
        setSize(800, 600);
        setDefaultCloseOperation(JFrame.EXIT_ON_CLOSE);
        setLayout(new BorderLayout());
        this.setLocationRelativeTo(null);
        URL Iconview = MainFrame.class.getResource("iconlogin.png");
	    Image img = Toolkit.getDefaultToolkit().createImage(Iconview);
	    this.setIconImage(img);
        // Thêm các phần giao diện
        add(createHeader(), BorderLayout.NORTH);  // Header
        add(createMenu(), BorderLayout.WEST);    // Menu
        add(createContentPanel(), BorderLayout.CENTER); // Nội dung
       
        setVisible(true);
    }

    // Tạo phần header
    private JPanel createHeader() {
        JPanel headerPanel = new JPanel();
        headerPanel.setBackground(Color.CYAN);
        headerPanel.add(new JLabel("Hệ thống quản lý bệnh viện"));
        return headerPanel;
    }
   
    // Tạo menu (danh sách chức năng bên trái)
    private JPanel createMenu() {
        JPanel menuPanel = new JPanel();
        menuPanel.setLayout(new GridLayout(5, 1, 10, 10)); // 5 dòng, khoảng cách 10px
        JButton btnManagePatients = createMenuButton("Quản lý bệnh nhân","iconpatient.png");
        JButton btnManageDoctors = createMenuButton("Quản lý bác sĩ","icondoctor.png");
        JButton btnManageAppointments = createMenuButton("Quản lý lịch hẹn","iconapm.png");
        JButton btnReports = createMenuButton("Báo cáo","iconreport.png");
        JButton btnManageRecord = createMenuButton("Quản lí hồ sơ","iconmedical.png");
        btnManagePatients.addActionListener(e -> {
			contentPanel.removeAll();
            contentPanel.add(new PatientManagementForm());
            contentPanel.revalidate();
            contentPanel.repaint();
        });
        btnManageDoctors.addActionListener(e -> {
            contentPanel.removeAll();
            contentPanel.add(new DoctorManagementForm());
            contentPanel.revalidate();
            contentPanel.repaint();
        });
        btnManageAppointments.addActionListener(e -> {
            contentPanel.removeAll();
            contentPanel.add(new AppointmentManagementForm());
            contentPanel.revalidate();
            contentPanel.repaint();
        });
        btnReports.addActionListener(e -> {
            contentPanel.removeAll();
            contentPanel.add(new ReportForm());
            contentPanel.revalidate();
            contentPanel.repaint();
        });
        btnManageRecord.addActionListener(e -> {
            contentPanel.removeAll();
            contentPanel.add(new MedicalRecordManagementForm());
            contentPanel.revalidate();
            contentPanel.repaint();
        });
        menuPanel.add(btnManagePatients);
        menuPanel.add(btnManageDoctors);
        menuPanel.add(btnManageAppointments);
        menuPanel.add(btnReports);
        menuPanel.add(btnManageRecord);
        return menuPanel;
    }
    public JPanel createContentPanel() {
        contentPanel = new JPanel(new BorderLayout());
        JLabel welcomeLabel = new JLabel("Chào mừng bạn đến với hệ thống quản lý bệnh viện!", JLabel.CENTER);
        welcomeLabel.setFont(new Font("Arial", Font.BOLD, 18));
        contentPanel.add(welcomeLabel, BorderLayout.CENTER);
        return contentPanel;
    }

    // Tạo panel nội dung chính (hiển thị danh sách, form nhập liệu, v.v.)
    private JButton createMenuButton(String text, String iconPath) {
        JButton button = new JButton(text);
        button.setFocusPainted(false);
        button.setFont(new Font("Arial", Font.BOLD, 16));
        button.setBackground(new Color(240, 248, 255)); // Xanh nhạt
        button.setBorder(BorderFactory.createLineBorder(new Color(60, 179, 113), 2));

        // Thêm icon nếu có
        try {
        	 ImageIcon icon = new ImageIcon(getClass().getResource(iconPath));
             Image scaledImage = icon.getImage().getScaledInstance(50, 50, Image.SCALE_SMOOTH);
             button.setIcon(new ImageIcon(scaledImage));
             button.setHorizontalTextPosition(SwingConstants.RIGHT);
             button.setVerticalTextPosition(SwingConstants.CENTER);
        } catch (Exception e) {
            System.err.println("Không tìm thấy icon: " + iconPath);
        }
    
        // Thêm hiệu ứng hover
        button.addMouseListener(new java.awt.event.MouseAdapter() {
            public void mouseEntered(java.awt.event.MouseEvent evt) {
                button.setBackground(new Color(144, 238, 144)); // Màu khi hover
            }

            public void mouseExited(java.awt.event.MouseEvent evt) {
                button.setBackground(new Color(240, 248, 255)); // Màu bình thường
            }
        });

        return button;
    }

  
    public static void main(String[] args) {
        new MainFrame();
    }
}
