package GUI;

import java.awt.BorderLayout;
import java.awt.Color;
import java.awt.EventQueue;
import java.awt.Image;

import javax.swing.JFrame;
import javax.swing.JPanel;
import javax.swing.border.EmptyBorder;
import javax.swing.table.DefaultTableModel;
import javax.swing.JScrollPane;

import org.w3c.dom.Text;

import BLL.ChuyenBayBLL;

import BLL.HoaDonBLL;
import BLL.KhachHangBLL;
import BLL.NhanVienBLL;
import BLL.VeChuyenBayBLL;
import DTO.ChuyenBayDTO;
import DTO.HoaDonDTO;
import DTO.KhachHangDTO;
import DTO.NhanVienDTO;
import DTO.VeChuyenBayDTO;

import javax.swing.ImageIcon;
import javax.swing.JButton;
import javax.swing.JLabel;
import javax.swing.JOptionPane;

import java.awt.Font;
import java.awt.Frame;
import java.awt.Image;
import java.awt.Label;
import java.awt.Panel;
import java.awt.Window;

import javax.swing.JScrollPane;
import javax.swing.JTable;
import javax.swing.JTextField;
import javax.swing.ListSelectionModel;
import javax.swing.UIManager;
import javax.swing.UnsupportedLookAndFeelException;

import java.awt.event.ActionListener;
import java.awt.event.MouseAdapter;
import java.awt.event.MouseEvent;
import java.sql.Time;
import java.util.ArrayList;
import java.util.Date;
import java.awt.event.ActionEvent;
import javax.swing.SwingConstants;
import javax.swing.ScrollPaneConstants;
import javax.swing.border.BevelBorder;
import javax.swing.border.CompoundBorder;
import javax.swing.border.LineBorder;
import javax.swing.Icon;

public class Control extends JFrame {

	private JPanel contentPane;
	private JTable tblHoadon;
	private JTable tblKhachhang;
	private JTable tblnhanvien;
	private JTable tblchuyenbay;
	private JTable tblvechuyenbay;
	private JPanel panelkh;
	private JPanel panel1;
	private JPanel panelhd;
	private JPanel panelvcb;
	private JPanel panelcb;

	/**
	 * Launch the application.
	 * @throws UnsupportedLookAndFeelException 
	 * @throws IllegalAccessException 
	 * @throws InstantiationException 
	 * @throws ClassNotFoundException 
	 */
	public static void main(String[] args) throws ClassNotFoundException, InstantiationException, IllegalAccessException, UnsupportedLookAndFeelException {
		UIManager.setLookAndFeel("com.jtattoo.plaf.aluminium.AluminiumLookAndFeel");
		EventQueue.invokeLater(new Runnable() {
			public void run() {
				try {
					Control frame = new Control();
					frame.setVisible(true);
				} catch (Exception e) {
					e.printStackTrace();
				}
			}
		});
	}

	public Control () throws ClassNotFoundException {
		Font ();
		header();
		loadAllNhanVien();
		loadAllChuyenBay();
		loadAllKhachHang();
		loadAllHoaDon();
		loadAllVeChuyenBay();
	}
	/**
	 * Create the frame.
	 */
	public void Font() {
		setDefaultCloseOperation(JFrame.EXIT_ON_CLOSE);
		setBounds(100, 100, 831, 561);
		contentPane = new JPanel();
		contentPane.setBackground(new Color(255, 255, 255));
		contentPane.setBorder(new EmptyBorder(5, 5, 5, 5));
		setContentPane(contentPane);
		contentPane.setLayout(null);
		
		
		JScrollPane scrollPane = new JScrollPane();
		scrollPane.setBounds(167, 79, 619, 146);
		
		
		
		contentPane.add(scrollPane);
		
// ve Chuyen bay {		
		panelvcb = new JPanel();
		panelvcb.setBounds(167, 269, 619, 245);

		panelvcb.setBackground(new Color(0,0,0,0));
		
		JTextField txtmavecb = new JTextField();
		txtmavecb.setColumns(10);
		txtmavecb.setBounds(116, 5, 96, 19);
		
		JTextField txtmacb = new JTextField();
		txtmacb.setBounds(318, 5, 96, 19);
		txtmacb.setColumns(10);
		
		JTextField txtmahdcb = new JTextField();
		txtmahdcb.setBounds(513, 5, 96, 19);
		txtmahdcb.setColumns(10);
		
		JTextField txtmahvcb = new JTextField();
		txtmahvcb.setBounds(116, 57, 96, 19);
		
		JTextField txtmadongia = new JTextField();
		txtmadongia.setColumns(10);
		txtmadongia.setBounds(318, 57, 96, 19);
		
		JTextField txttinhtrangve = new JTextField();
		txttinhtrangve.setColumns(10);
		txttinhtrangve.setBounds(513, 57, 96, 19);
                
                JTextField txttinhtrangve1 = new JTextField();
		txttinhtrangve1.setColumns(10);
		txttinhtrangve1.setBounds(513, 113, 96, 19);
		
		JLabel lblgio = new JLabel("GIO");
		lblgio.setBounds(222, 61, 68, 13);
                
                JLabel lbltinhtrangve = new JLabel("TINH TRANG VE");
		lbltinhtrangve.setBounds(400, 113, 150, 13);
		
		JLabel lblsoghe = new JLabel("SO GHE");
		lblsoghe.setBounds(10, 8, 102, 13);
		
		JLabel lblngay = new JLabel("NGAY");
		lblngay.setBounds(10, 61, 68, 13);
		
		JLabel lblkh = new JLabel("KH");
		lblkh.setBounds(435, 9, 68, 13);
		
		JLabel lblmacb = new JLabel("MA CB");
		lblmacb.setBounds(222, 9, 86, 13);
		
		JLabel lblgia = new JLabel("GIA");
		lblgia.setBounds(435, 61, 76, 13);
		
		panelvcb.setLayout(null);
		panelvcb.add(txtmavecb);
		panelvcb.add(txtmacb);
		panelvcb.add(txtmahdcb);
		panelvcb.add(txtmahvcb);
		panelvcb.add(txtmadongia);
		panelvcb.add(txttinhtrangve);
		panelvcb.add(lbltinhtrangve);
		panelvcb.add(lblkh);
		panelvcb.add(lblngay);
		panelvcb.add(lblsoghe);
		panelvcb.add(lblmacb);
		panelvcb.add(lblgia);
                panelvcb.add(lblgio);
                panelvcb.add(txttinhtrangve1);
		panelvcb.setVisible(false);
		
		JButton btnDvcb = new JButton("Delete");
		btnDvcb.setBounds(345, 163, 111, 57);
		btnDvcb.setFont(new Font("SansSerif", Font.BOLD, 12));
		btnDvcb.addActionListener(new ActionListener() {
			 public void actionPerformed(ActionEvent arg0) {
				 VeChuyenBayDTO vcb = new VeChuyenBayDTO();
				 vcb.setMa_ve_cb(txtmavecb.getText());
				 VeChuyenBayBLL vcbbll = new VeChuyenBayBLL();
				 int choice = JOptionPane.showConfirmDialog(null,
				 "BAN CHAC CHAN MUON XOA!", "XAC NHAN",
				 JOptionPane.YES_NO_OPTION);
				 if (choice == JOptionPane.YES_OPTION) {
				 try {
					 @SuppressWarnings("unused")
					 int result = vcbbll.deleteVeChuyenBay(vcb);
					 loadAllVeChuyenBay();
				 } catch (Exception ex) {
					 ex.printStackTrace();
				 	}
				 }
			}
		});
		panelvcb.add(btnDvcb);
		
		
		/*JButton btnEvcb = new JButton("Edit");
		btnEvcb.setBounds(482, 163, 111, 57);
		btnEvcb.setFont(new Font("SansSerif", Font.BOLD, 12));
		btnEvcb.addActionListener(new ActionListener() {
			@Override
			public void actionPerformed(ActionEvent e) {
				VeChuyenBayDTO vcb = new VeChuyenBayDTO();
				 vcb.setMa_ve_cb(txtmavecb.getText());
				 vcb.setMa_cb(txtmacb.getText());
				 vcb.setMa_dongia(txtmadongia.getText());
				 vcb.setMa_hd(txtmahdcb.getText());
				 vcb.setMa_hv(txtmahvcb.getText());
				 vcb.setTinhtrangve(txttinhtrangve.getText());
				 VeChuyenBayBLL vcbbll = new VeChuyenBayBLL();
				try {
					int result = vcbbll.updateVeChuyenBay(vcb);
					if(result !=0) {
						JOptionPane.showConfirmDialog(null,"cáº­p nháº­t thÃ nh cÃ´ng!","thÃ´ng bÃ¡o",JOptionPane.INFORMATION_MESSAGE);
					}
					loadAllVeChuyenBay();
				} catch (Exception ex) {
					ex.printStackTrace();
				}
			}
		});
		panelvcb.add(btnEvcb);*/
		
		contentPane.add(panelvcb);
		
		tblvechuyenbay = new JTable();
		tblvechuyenbay.setBorder(UIManager.getBorder("Table.scrollPaneBorder"));
		tblvechuyenbay.setSelectionMode(ListSelectionModel.SINGLE_SELECTION);
		tblvechuyenbay.addMouseListener(new MouseAdapter() {
			 // Láº¥y thÃ´ng tin dÃ²ng dá»¯ liá»‡u Ä‘Æ°á»£c chá»�n hiá»ƒn thá»‹ lÃªn component
			 public void mouseClicked(MouseEvent arg0) {
			 int row = tblvechuyenbay.getSelectedRow();
			 if (row != -1) {
			 txtmavecb.setText(tblvechuyenbay.getValueAt(row, 0).toString());
			 txtmahdcb.setText(tblvechuyenbay.getValueAt(row, 1).toString());
			 txtmacb.setText(tblvechuyenbay.getValueAt(row, 2).toString());				
			 txtmahvcb.setText(tblvechuyenbay.getValueAt(row, 3).toString());
			 txtmadongia.setText(tblvechuyenbay.getValueAt(row, 4).toString());
			 txttinhtrangve.setText(tblvechuyenbay.getValueAt(row, 5).toString());
			 }
			 }
			 });
		
		JButton btnVechuyenbay = new JButton("VE CHUYEN BAY");
		btnVechuyenbay.setFont(new Font("SansSerif", Font.BOLD, 14));
		btnVechuyenbay.setBackground(Color.white);
		btnVechuyenbay.setForeground(new Color(86, 172, 191));
		btnVechuyenbay.addActionListener(new ActionListener() {
			public void actionPerformed(ActionEvent arg0) {
				scrollPane.setViewportView(tblvechuyenbay);
				panel1.setVisible(false);
				panelhd.setVisible(false);
				panelkh.setVisible(false);
				panelvcb.setVisible(true);
				panelcb.setVisible(false);
			}
		});
		btnVechuyenbay.setBounds(10, 385, 128, 23);
		contentPane.add(btnVechuyenbay);
//}
//HoaDon {	
		panelhd = new JPanel();
		panelhd.setBounds(167, 269, 619, 245);
		panelhd.setBackground(new Color(0,0,0,0));
		
		JTextField txtmahoadon = new JTextField();
		txtmahoadon.setBounds(81, 4, 96, 19);
		txtmahoadon.setColumns(10);
		
		JTextField txtthanhtien = new JTextField();
		txtthanhtien.setBounds(81, 57, 96, 19);
		txtthanhtien.setColumns(10);
		
		JTextField txtngaylap = new JTextField();
		txtngaylap.setBounds(281, 57, 96, 19);
		txtngaylap.setColumns(10);
		
		JTextField txtnhanvienID = new JTextField();
		txtnhanvienID.setBounds(281, 4, 96, 19);
		txtnhanvienID.setColumns(10);
		
		
		JTextField txtkhachhangID = new JTextField();
		txtkhachhangID.setBounds(496, 4, 96, 19);
		txtkhachhangID.setColumns(10);
		
		 JLabel lblmahd = new JLabel("MÃ£ hÃ³a Ä‘Æ¡n");
		 lblmahd.setBounds(10, 8, 76, 13);
		 
		 JLabel lblthanhtien = new JLabel("ThÃ nh tiá»�n");
		 lblthanhtien.setBounds(10, 61, 76, 13);
		 
		 JLabel lblmanvhd = new JLabel("MÃ£ nhÃ¢n viÃªn");
		 lblmanvhd.setBounds(202, 8, 76, 13);
		 
		 JLabel lblkhachhangidhd = new JLabel("MÃ£ khÃ¡ch hÃ ng");
		 lblkhachhangidhd.setBounds(404, 8, 96, 13);
		 
		 JLabel lblngaylap = new JLabel("NgÃ y láº­p");
		 lblngaylap.setBounds(216, 61, 55, 13);
		panelhd.setLayout(null);
		panelhd.add(txtmahoadon);
		panelhd.add(txtkhachhangID);
		panelhd.add(txtnhanvienID);
		panelhd.add(txtngaylap);
		panelhd.add(txtthanhtien);
		panelhd.add(lblmahd);
		panelhd.add(lblmanvhd);
		panelhd.add(lblkhachhangidhd);
		panelhd.add(lblthanhtien);
		panelhd.add(lblngaylap);
		panelhd.setVisible(false);
		
		JButton btnEhd = new JButton("Edit");
		btnEhd.setBounds(482, 163, 111, 57);
		btnEhd.setFont(new Font("SansSerif", Font.BOLD, 12));
		btnEhd.addActionListener(new ActionListener() {
		@Override
		public void actionPerformed(ActionEvent e) {
			HoaDonDTO hd = new HoaDonDTO();
			hd.setMa_hd(txtmahoadon.getText());
			hd.setThanh_tien(Integer.parseInt(txtthanhtien.getText()));
			hd.setNgay_Lap(java.sql.Date.valueOf(txtngaylap.getText()));
			hd.setMa_kh(txtkhachhangID.getText());
			hd.setMa_nv(txtnhanvienID.getText());
			HoaDonBLL hdbll = new HoaDonBLL();
			try {
				int result = hdbll.updateHoaDon(hd);
				if(result !=0) {
					JOptionPane.showConfirmDialog(null,"cáº­p nháº­t thÃ nh cÃ´ng!","thÃ´ng bÃ¡o",JOptionPane.INFORMATION_MESSAGE);
				}
				loadAllHoaDon();
			} catch (Exception ex) {
				ex.printStackTrace();
			  }
		}
		});
		JButton btnDhd = new JButton("Delete");
		btnDhd.setBounds(345, 163, 111, 57);
		btnDhd.setFont(new Font("SansSerif", Font.BOLD, 12));
		btnDhd.addActionListener(new ActionListener() {
		 public void actionPerformed(ActionEvent arg0) {
			 HoaDonDTO hd = new HoaDonDTO();
				hd.setMa_hd(txtmahoadon.getText());
				HoaDonBLL hdbll = new HoaDonBLL();
			 int choice = JOptionPane.showConfirmDialog(null,
			 "Báº¡n cÃ³ cháº¯c cháº¯n xÃ³a dá»¯ liá»‡u!", "XÃ¡c nháº­n",
			 JOptionPane.YES_NO_OPTION);
			 if (choice == JOptionPane.YES_OPTION) {
			 try {
				 @SuppressWarnings("unused")
				 int result = hdbll.deleteHoaDon(hd);
				 loadAllHoaDon();
			 } catch (Exception ex) {
				 ex.printStackTrace();
			 	}
			 }
		}
		});
		panelhd.add(btnEhd);
		panelhd.add(btnDhd);
		
		contentPane.add(panelhd);
		
		 tblHoadon = new JTable();
		//
		 tblHoadon.setBorder(UIManager.getBorder("Table.scrollPaneBorder"));
		 tblHoadon.setSelectionMode(ListSelectionModel.SINGLE_SELECTION);
		 tblHoadon.addMouseListener(new MouseAdapter() {
			 // Láº¥y thÃ´ng tin dÃ²ng dá»¯ liá»‡u Ä‘Æ°á»£c chá»�n hiá»ƒn thá»‹ lÃªn component
			 public void mouseClicked(MouseEvent arg0) {
			 int row = tblHoadon.getSelectedRow();
			 if (row != -1) {
			 txtmahoadon.setText(tblHoadon.getValueAt(row, 0).toString());
			 txtthanhtien.setText(tblHoadon.getValueAt(row, 1).toString());
			 txtngaylap.setText(tblHoadon.getValueAt(row, 2).toString());				
			 txtnhanvienID.setText(tblHoadon.getValueAt(row, 3).toString());
			 txtkhachhangID.setText(tblHoadon.getValueAt(row, 4).toString());
			 }
			 }
			 });
		 
		JButton btnHoadon = new JButton("HÃ³a Ä‘Æ¡n");
		btnHoadon.setForeground(new Color(255, 255, 255));
		btnHoadon.setFont(new Font("SansSerif", Font.BOLD, 14));
		btnHoadon.setBackground(new Color(86, 172, 191));
		btnHoadon.addActionListener(new ActionListener() {
			public void actionPerformed(ActionEvent arg0) {
				scrollPane.setViewportView(tblHoadon);
				panel1.setVisible(false);
				panelkh.setVisible(false);
				panelhv.setVisible(false);
				panelsb.setVisible(false);
				panelmb.setVisible(false);
				paneltb.setVisible(false);
				panelhd.setVisible(true);
				panelvcb.setVisible(false);
				panelpdc.setVisible(false);
				paneldg.setVisible(false);
				panelcb.setVisible(false);
			}
		});
		btnHoadon.setBounds(10, 113, 128, 23);
		contentPane.add(btnHoadon);
//}
//Khach Hang {
		panelkh = new JPanel();
		panelkh.setBounds(167, 269, 619, 245);
		panelkh.setBackground(new Color(0,0,0,0));
		
		JTextField txtkhachhangemail = new JTextField();
		txtkhachhangemail.setColumns(10);
		txtkhachhangemail.setBounds(220, 57, 96, 19);
		//txtkhachhangemail.setVisible(false);
		
		
		JTextField txtsdtkh = new JTextField();
		txtsdtkh.setBounds(220, 5, 96, 19);
		//txtsdtkh.setVisible(false);
		
		txtsdtkh.setColumns(10);
		
		JTextField txtkhachhangname = new JTextField();
		txtkhachhangname.setColumns(10);
		txtkhachhangname.setBounds(50, 5, 96, 19);
		//txtkhachhangname.setVisible(false);
		
		
		JTextField  txtkhachhangId = new JTextField();
		 txtkhachhangId.setBounds(455, 5, 96, 19);
		// txtkhachhangId.setVisible(false);
		
		 txtkhachhangId.setColumns(10);
		 
		 JTextField  txtdiachikh = new JTextField();
		 txtdiachikh.setBounds(50, 56, 96, 19);
		// txtkhachhangId.setVisible(false);
		 txtdiachikh.setColumns(10);
		
		JTextField txtxacdinh=new JTextField();
		txtxacdinh.setBounds(455, 56, 96, 20);
		txtxacdinh.setColumns(10);
		 
		 JLabel lblmakh = new JLabel("MÃ£ khÃ¡ch hÃ ng");
		 lblmakh.setBounds(349, 8, 135, 13);
		 //lblmakh.setVisible(false);
		
		 JLabel lblxacdinh = new JLabel("CMND/PASSPORT");
		 lblxacdinh.setBounds(349, 60, 105, 13);
		 
			JLabel lbltenkh = new JLabel("Há»� tÃªn");
			lbltenkh.setBounds(9, 8, 49, 13);
			//lbltenkh.setVisible(false);
			
			
			JLabel lblemailkh = new JLabel("Email");
			lblemailkh.setBounds(185, 60, 49, 13);
			//lblemailkh.setVisible(false);
			
			
			JLabel lbldiachikh = new JLabel("Ä�á»‹a chá»‰");
			lbldiachikh.setBounds(9, 60, 50, 13);
			//lbldiachikh.setVisible(false);
		
			
			JLabel lblsdtkh = new JLabel("SÄ�T");
			lblsdtkh.setBounds(185, 8, 49, 13);
			panelkh.setLayout(null);
			
			//lblsdtkh.setVisible(false);
			
			
			panelkh.add(lbltenkh);
			panelkh.add(lbldiachikh);
			panelkh.add(lblemailkh);
			panelkh.add(lblmakh);
			panelkh.add(lblsdtkh);
			panelkh.add(lblxacdinh);
			panelkh.add(txtdiachikh);
			panelkh.add(txtkhachhangId);
			panelkh.add(txtsdtkh);
			panelkh.add(txtkhachhangname);
			panelkh.add(txtkhachhangemail);
			panelkh.add(txtxacdinh);
			panelkh.setVisible(false);
			
			JButton btnIkh = new JButton("Insert");
			btnIkh.setBounds(212, 163, 100, 57);
			btnIkh.setFont(new Font("SansSerif", Font.BOLD, 12));
			btnIkh.addActionListener(new ActionListener() {
			@Override
			public void actionPerformed(ActionEvent e) {
				KhachHangDTO kh = new KhachHangDTO();
				kh.setTen_kh(txtkhachhangname.getText());
				kh.setEmail(txtkhachhangemail.getText());
				kh.setSDT(txtsdtkh.getText());
				kh.setCmnd(txtxacdinh.getText());
				kh.setDiaChi(txtdiachikh.getText());
				KhachHangBLL khbll = new KhachHangBLL();
				try {
					int result = khbll.insertKhachHang(kh);
					if(result !=0) {
						JOptionPane.showConfirmDialog(null,"thÃªm thÃ nh cÃ´ng!","thÃ´ng bÃ¡o",JOptionPane.INFORMATION_MESSAGE);
					}
					loadAllKhachHang();
				} catch (Exception ex) {
					ex.printStackTrace();
				  }
			}
			});
			JButton btnEkh = new JButton("Edit");
			btnEkh.setBounds(482, 163, 111, 57);
			btnEkh.setFont(new Font("SansSerif", Font.BOLD, 12));
			btnEkh.addActionListener(new ActionListener() {
			@Override
			public void actionPerformed(ActionEvent e) {
				KhachHangDTO kh = new KhachHangDTO();
				kh.setMa_kh(txtkhachhangId.getText());
				kh.setTen_kh(txtkhachhangname.getText());
				kh.setEmail(txtkhachhangemail.getText());
				kh.setSDT(txtsdtkh.getText());
				kh.setCmnd(txtxacdinh.getText());
				kh.setDiaChi(txtdiachikh.getText());
				KhachHangBLL khbll = new KhachHangBLL();
				try {
					int result = khbll.updateKhachHang(kh);
					if(result !=0) {
						JOptionPane.showConfirmDialog(null,"cáº­p nháº­t thÃ nh cÃ´ng!","thÃ´ng bÃ¡o",JOptionPane.INFORMATION_MESSAGE);
					}
					loadAllKhachHang();
				} catch (Exception ex) {
					ex.printStackTrace();
				  }
			}
			});
			JButton btnDkh = new JButton("Delete");
			btnDkh.setBounds(345, 163, 111, 57);
			btnDkh.setFont(new Font("SansSerif", Font.BOLD, 12));
			btnDkh.addActionListener(new ActionListener() {
			 public void actionPerformed(ActionEvent arg0) {
				 KhachHangDTO kh = new KhachHangDTO();
					kh.setMa_kh(txtkhachhangId.getText());
					KhachHangBLL khbll = new KhachHangBLL();
				 int choice = JOptionPane.showConfirmDialog(null,
				 "Báº¡n cÃ³ cháº¯c cháº¯n xÃ³a dá»¯ liá»‡u!", "XÃ¡c nháº­n",
				 JOptionPane.YES_NO_OPTION);
				 if (choice == JOptionPane.YES_OPTION) {
				 try {
					 @SuppressWarnings("unused")
					 int result = khbll.deleteKhachHang(kh);
					 loadAllKhachHang();
				 } catch (Exception ex) {
					 ex.printStackTrace();
				 	}
				 }
			}
			});
			panelkh.add(btnIkh);
			panelkh.add(btnEkh);
			panelkh.add(btnDkh);
			
			contentPane.add(panelkh);
			
		tblKhachhang = new JTable();
		//
		tblKhachhang.setBorder(UIManager.getBorder("Table.scrollPaneBorder"));
		tblKhachhang.setSelectionMode(ListSelectionModel.SINGLE_SELECTION);
		tblKhachhang.addMouseListener(new MouseAdapter() {
		 // Láº¥y thÃ´ng tin dÃ²ng dá»¯ liá»‡u Ä‘Æ°á»£c chá»�n hiá»ƒn thá»‹ lÃªn component
		 public void mouseClicked(MouseEvent arg0) {
		 int row = tblKhachhang.getSelectedRow();
		 if (row != -1) {
		 txtkhachhangId.setText(tblKhachhang.getValueAt(row, 0).toString());
		 txtkhachhangname.setText(tblKhachhang.getValueAt(row, 1).toString());
		 txtxacdinh.setText(tblKhachhang.getValueAt(row, 2).toString());
		 txtkhachhangemail.setText(tblKhachhang.getValueAt(row, 3).toString());
		 txtsdtkh.setText(tblKhachhang.getValueAt(row, 4).toString()); 
		 txtdiachikh.setText(tblKhachhang.getValueAt(row, 5).toString());			
		 }
		 }
		 });
		JButton btnKhachhang = new JButton("KhÃ¡ch hÃ ng");
		btnKhachhang.setForeground(new Color(255, 255, 255));
		btnKhachhang.setFont(new Font("SansSerif", Font.BOLD, 14));
		btnKhachhang.setBackground(new Color(86, 172, 191));
		btnKhachhang.addActionListener(new ActionListener(){
			public void actionPerformed(ActionEvent arg0) {
				scrollPane.setViewportView(tblKhachhang);
				panel1.setVisible(false);
				panelhv.setVisible(false);
				panelhd.setVisible(false);
				panelsb.setVisible(false);
				panelmb.setVisible(false);
				paneltb.setVisible(false);
				panelkh.setVisible(true);
				panelvcb.setVisible(false);
				panelpdc.setVisible(false);
				paneldg.setVisible(false);
				panelcb.setVisible(false);
				
			}
		});
		btnKhachhang.setBounds(10, 147, 128, 23);
		
		contentPane.add(btnKhachhang);
//}
// NhanVien {
	//jtextfield
		panel1 = new JPanel();
		panel1.setBounds(167, 269, 619, 245);
		panel1.setBackground(new Color(0, 0,0,0));
		JTextField txtnhanvienemail = new JTextField();
		txtnhanvienemail.setColumns(10);
		txtnhanvienemail.setBounds(220, 57, 96, 19);

		JTextField txtsdtnv = new JTextField();
		txtsdtnv.setBounds(220, 5, 96, 19);
		txtsdtnv.setColumns(10);
		
		JTextField txtdiachinv = new JTextField();
		txtdiachinv.setBounds(50, 57, 96, 19);
		
		JTextField txtnhanvienname = new JTextField();
		txtnhanvienname.setColumns(10);
		txtnhanvienname.setBounds(50, 5, 96, 19);
		
		JTextField txtnhanvienId = new JTextField();
		txtnhanvienId.setBounds(455, 5, 96, 19);
		txtnhanvienId.setColumns(10);
	//jlabel		
		JLabel lblmanv = new JLabel("MÃ£ nhÃ¢n viÃªn");
		lblmanv.setBounds(349, 8, 135, 13);
		
		JLabel lbltennv = new JLabel("Há»� tÃªn");
		lbltennv.setBounds(10, 8, 49, 13);
		
		JLabel lblemailnv = new JLabel("Email");
		lblemailnv.setBounds(185, 60, 49, 13);
		
		JLabel lbldiachinv = new JLabel("Ä�á»‹a chá»‰");
		lbldiachinv.setBounds(9, 60, 50, 13);
		
		JLabel lblsdtnv = new JLabel("SÄ�T");
		lblsdtnv.setBounds(185, 8, 49, 13);
		panel1.setLayout(null);
		
	//Jpannel nhavien
		
		panel1.add(lbltennv);
		panel1.add(lbldiachinv);
		panel1.add(lblemailnv);
		panel1.add(lblmanv);
		panel1.add(lblsdtnv);
		panel1.add(txtnhanvienname);
		panel1.add(txtdiachinv);
		panel1.add(txtnhanvienemail);
		panel1.add(txtnhanvienId);
		panel1.add(txtsdtnv);
		panel1.setVisible(false);
		
		JButton btnInv = new JButton("Insert");
		btnInv.setBounds(212, 163, 100, 57);
		btnInv.setFont(new Font("SansSerif", Font.BOLD, 12));
		btnInv.addActionListener(new ActionListener() {
		@Override
		public void actionPerformed(ActionEvent e) {
			NhanVienDTO nv = new NhanVienDTO();
			
			nv.setTen_nv(txtnhanvienname.getText());
			nv.setDiaChi(txtdiachinv.getText());
			nv.setSDT(txtsdtnv.getText());
			nv.setEmail(txtnhanvienemail.getText());
			NhanVienBLL nvbll = new NhanVienBLL();
			try {
				int result = nvbll.insertNhanVien(nv);
				if(result !=0) {
					JOptionPane.showConfirmDialog(null,"thÃªm thÃ nh cÃ´ng!","thÃ´ng bÃ¡o",JOptionPane.INFORMATION_MESSAGE);
				}
				loadAllNhanVien();
			} catch (Exception ex) {
				ex.printStackTrace();
			  }
		}
		});
		JButton btnEnv = new JButton("Edit");
		btnEnv.setBounds(482, 163, 111, 57);
		btnEnv.setFont(new Font("SansSerif", Font.BOLD, 12));
		btnEnv.addActionListener(new ActionListener() {
		@Override
		public void actionPerformed(ActionEvent e) {
			NhanVienDTO nv = new NhanVienDTO();
			nv.setMa_nv(txtnhanvienID.getText());
			nv.setTen_nv(txtnhanvienname.getText());
			nv.setDiaChi(txtdiachinv.getText());
			nv.setSDT(txtsdtnv.getText());
			nv.setEmail(txtnhanvienemail.getText());
			NhanVienBLL nvbll = new NhanVienBLL();
			try {
				int result = nvbll.updateNhanVien(nv);
				if(result !=0) {
					JOptionPane.showConfirmDialog(null,"cáº­p nháº­t thÃ nh cÃ´ng!","thÃ´ng bÃ¡o",JOptionPane.INFORMATION_MESSAGE);
				}
				loadAllNhanVien();
			} catch (Exception ex) {
				ex.printStackTrace();
			  }
		}
		});
		JButton btnDnv = new JButton("Delete");
		btnDnv.setBounds(345, 163, 111, 57);
		btnDnv.setFont(new Font("SansSerif", Font.BOLD, 12));
		btnDnv.addActionListener(new ActionListener() {
		 public void actionPerformed(ActionEvent arg0) {
			 NhanVienDTO nv = new NhanVienDTO();
			 nv.setMa_nv(txtnhanvienID.getText());
			 NhanVienBLL nvbll = new NhanVienBLL();
			 int choice = JOptionPane.showConfirmDialog(null,
			 "Báº¡n cÃ³ cháº¯c cháº¯n xÃ³a dá»¯ liá»‡u!", "XÃ¡c nháº­n",
			 JOptionPane.YES_NO_OPTION);
			 if (choice == JOptionPane.YES_OPTION) {
			 try {
				 @SuppressWarnings("unused")
				 int result = nvbll.deleteNhanVien(nv);
				 loadAllNhanVien();
			 } catch (Exception ex) {
				 ex.printStackTrace();
			 	}
			 }
		}
		});
		panel1.add(btnInv);
		panel1.add(btnEnv);
		panel1.add(btnDnv);
		
		contentPane.add(panel1);		
	//btn nhanvien	
		 tblnhanvien = new JTable();
		 tblnhanvien.setBorder(UIManager.getBorder("Table.scrollPaneBorder"));
		 tblnhanvien.setSelectionMode(ListSelectionModel.SINGLE_SELECTION);
		 tblnhanvien.addMouseListener(new MouseAdapter() {
		 // Láº¥y thÃ´ng tin dÃ²ng dá»¯ liá»‡u Ä‘Æ°á»£c chá»�n hiá»ƒn thá»‹ lÃªn component
		 public void mouseClicked(MouseEvent arg0) {
		 int row = tblnhanvien.getSelectedRow();
		 if (row != -1) {
		 txtnhanvienId.setText(tblnhanvien.getValueAt(row, 0).toString());
		 txtnhanvienname.setText(tblnhanvien.getValueAt(row, 1).toString());
		 txtnhanvienemail.setText(tblnhanvien.getValueAt(row, 2).toString());
		 txtsdtnv.setText(tblnhanvien.getValueAt(row, 3).toString()); 
		 txtdiachinv.setText(tblnhanvien.getValueAt(row, 4).toString());	
		 }
		 }
		 });
		JButton btnNhanvien = new JButton("NhÃ¢n viÃªn");
		btnNhanvien.setFont(new Font("SansSerif", Font.BOLD, 14));
		btnNhanvien.setBackground(new Color(220, 242, 238));
		btnNhanvien.setForeground(new Color(95,  154,  156));
		btnNhanvien.addActionListener(new ActionListener(){
			public void actionPerformed(ActionEvent arg0) {
				scrollPane.setViewportView(tblnhanvien);
				panelhd.setVisible(false);
				panelkh.setVisible(false);
				panelhv.setVisible(false);
				panelsb.setVisible(false);
				panelmb.setVisible(false);
				paneltb.setVisible(false);
				panelvcb.setVisible(false);
				panel1.setVisible(true);
				panelpdc.setVisible(false);
				paneldg.setVisible(false);
				panelcb.setVisible(false);
			}
		});
		btnNhanvien.setBounds(10, 215, 128, 23);
		contentPane.add(btnNhanvien);
//}
// chuyen bay {
		panelcb = new JPanel();
		panelcb.setBounds(167, 269, 619, 245);
		panelcb.setBackground(new Color(0,0,0,0));
		
		JTextField txtchuyenbayid = new JTextField();
		txtchuyenbayid.setColumns(10);
		txtchuyenbayid.setBounds(89, 4, 96, 19);
		//txtkhachhangemail.setVisible(false);
		
		JTextField txtthoigian = new JTextField();
		txtthoigian.setBounds(295, 56, 96, 19);
		//txtsdtkh.setVisible(false);
		txtthoigian.setColumns(10);
		
		JTextField txtmatuyenbay = new JTextField();
		txtmatuyenbay.setBounds(295, 4, 96, 19);
		//txtsdtkh.setVisible(false);
		txtmatuyenbay.setColumns(10);
		
		JTextField txtmaybayid = new JTextField();
		txtmaybayid.setColumns(10);
		txtmaybayid.setBounds(492, 56, 96, 19);
		//txtkhachhangname.setVisible(false);
		
		
		JTextField  txtgheh1 = new JTextField();
		txtgheh1.setBounds(89,111, 96, 19);
		// txtkhachhangId.setVisible(false);
		txtgheh1.setColumns(10);
		 
		 JTextField  txtgheh2 = new JTextField();
		 txtgheh2.setBounds(89, 56, 96, 19);
		// txtkhachhangId.setVisible(false);
		 txtgheh2.setColumns(10);
		
		JTextField txtngaygio=new JTextField();
		txtngaygio.setBounds(492, 4, 96, 20);
		txtngaygio.setColumns(10);
		 
		 JLabel lblchuyenbayid = new JLabel("MÃ£ chuyáº¿n bay");
		 lblchuyenbayid.setBounds(9, 8, 95, 13);
		 //lblmakh.setVisible(false);
		
		 JLabel lblmatuyenbay = new JLabel("MÃ£ tuyáº¿n bay");
		 lblmatuyenbay.setBounds(213, 8, 95, 13);
		 
			JLabel lblmabayid = new JLabel("MÃ£ mÃ¡y bay");
			lblmabayid.setBounds(423, 8, 70, 13);
			//lbltenkh.setVisible(false);
			
			
			JLabel lblgheh1 = new JLabel("Sá»‘ gháº¿ háº¡ng 1");
			lblgheh1.setBounds(9, 60, 95, 13);
			//lblemailkh.setVisible(false);
			
			
			JLabel lblgheh2 = new JLabel("Sá»‘ gháº¿ háº¡ng 2");
			lblgheh2.setBounds(213, 60, 84, 13);
			//lbldiachikh.setVisible(false);
		
			
			JLabel lblngaygio = new JLabel("NgÃ y giá»�");
			lblngaygio.setBounds(423, 60, 70, 13);
			
			JLabel lblthoigian = new JLabel("Thá»�i gian bay");
			lblthoigian.setBounds(9, 115, 95, 13);
			panelcb.setLayout(null);
			panelcb.add(lblngaygio);
			panelcb.add(lblgheh1);
			panelcb.add(lblgheh2);
			panelcb.add(lblmabayid);
			panelcb.add(lblmatuyenbay);
			panelcb.add(lblchuyenbayid);
			panelcb.add(lblthoigian);
			panelcb.add(txtchuyenbayid);
			panelcb.add(txtngaygio);
			panelcb.add(txtgheh2);
			panelcb.add(txtgheh1);
			panelcb.add(txtmaybayid);
			panelcb.add(txtmatuyenbay);
			panelcb.add(txtthoigian);
			
			JButton btnEcb = new JButton("Edit");
			btnEcb.setBounds(482, 163, 111, 57);
			btnEcb.setFont(new Font("SansSerif", Font.BOLD, 12));
			btnEcb.addActionListener(new ActionListener() {
			@Override
			public void actionPerformed(ActionEvent e) {
				ChuyenBayDTO cb = new ChuyenBayDTO();
				cb.setMa_cb(txtchuyenbayid.getText());
				cb.setMa_tuyenbay(txtmatuyenbay.getText());
				cb.setMa_mb(txtmaybayid.getText());
				cb.setNgaygio(java.sql.Date.valueOf(txtngaygio.getText()));
				cb.setSoghehang1(Integer.parseInt(txtgheh1.getText()));
				cb.setSoghehang2(Integer.parseInt(txtgheh2.getText()));
				cb.setThoigianbay(txtthoigian.getText());
				
				ChuyenBayBLL sbbll = new ChuyenBayBLL();
				try {
					int result = sbbll.updateChuyenBay (cb);
					if(result !=0) {
						JOptionPane.showConfirmDialog(null,"cáº­p nháº­t thÃ nh cÃ´ng!","thÃ´ng bÃ¡o",JOptionPane.INFORMATION_MESSAGE);
					}
					loadAllChuyenBay();
				} catch (Exception ex) {
					ex.printStackTrace();
				  }
			}
			});
			JButton btnDcb = new JButton("Delete");
			btnDcb.setBounds(345, 163, 111, 57);
			btnDcb.setFont(new Font("SansSerif", Font.BOLD, 12));
			btnDcb.addActionListener(new ActionListener() {
			 public void actionPerformed(ActionEvent arg0) {
				 ChuyenBayDTO cb = new ChuyenBayDTO();
				 cb.setMa_cb(txtchuyenbayid.getText());
				 ChuyenBayBLL cbbll = new ChuyenBayBLL();
				 int choice = JOptionPane.showConfirmDialog(null,
				 "Báº¡n cÃ³ cháº¯c cháº¯n xÃ³a dá»¯ liá»‡u!", "XÃ¡c nháº­n",
				 JOptionPane.YES_NO_OPTION);
				 if (choice == JOptionPane.YES_OPTION) {
				 try {
					 @SuppressWarnings("unused")
					 int result = cbbll.deleteChuyenBay(cb);
					 loadAllChuyenBay();
				 } catch (Exception ex) {
					 ex.printStackTrace();
				 	}
				 }
			}
			});
			panelcb.add(btnEcb);
			panelcb.add(btnDcb);
			
			contentPane.add(panelcb);
		
		tblchuyenbay = new JTable();
		//
		tblchuyenbay.setBorder(UIManager.getBorder("Table.scrollPaneBorder"));
		tblchuyenbay.setSelectionMode(ListSelectionModel.SINGLE_SELECTION);
		tblchuyenbay.addMouseListener(new MouseAdapter() {
			 // Láº¥y thÃ´ng tin dÃ²ng dá»¯ liá»‡u Ä‘Æ°á»£c chá»�n hiá»ƒn thá»‹ lÃªn component
			 public void mouseClicked(MouseEvent arg0) {
			 int row = tblchuyenbay.getSelectedRow();
			 if (row != -1) {
				 txtchuyenbayid.setText(tblchuyenbay.getValueAt(row, 0).toString());
				 txtmatuyenbay.setText(tblchuyenbay.getValueAt(row, 1).toString());
				 txtmaybayid.setText(tblchuyenbay.getValueAt(row, 2).toString());				
				 txtgheh1.setText(tblchuyenbay.getValueAt(row, 3).toString());
				 txtgheh2.setText(tblchuyenbay.getValueAt(row, 4).toString());
				 txtthoigian.setText(tblchuyenbay.getValueAt(row, 5).toString());	
				 txtngaygio.setText(tblchuyenbay.getValueAt(row, 6).toString());	
			 }
			 }
			 });
		JButton btnChuyenbay = new JButton("Chuyáº¿n bay");
		btnChuyenbay.setFont(new Font("SansSerif", Font.BOLD, 14));
		btnChuyenbay.setBackground(Color.white);
		btnChuyenbay.setForeground(new Color(86, 172, 191));
		btnChuyenbay.addActionListener(new ActionListener(){
			public void actionPerformed(ActionEvent arg0) {
				scrollPane.setViewportView(tblchuyenbay);
				panelhd.setVisible(false);
				panelkh.setVisible(false);
				panel1.setVisible(false);
				panelvcb.setVisible(false);
				panelcb.setVisible(true);
			}
		});
		btnChuyenbay.setBounds(10, 317, 128, 23);
		contentPane.add(btnChuyenbay);
//}	
		
		JLabel lblNewLabel = new JLabel("ThÃ´ng tin chi tiáº¿t");
		lblNewLabel.setForeground(new Color(0, 0, 0));
		lblNewLabel.setFont(new Font("SansSerif", Font.BOLD, 20));
		lblNewLabel.setBounds(603, 11, 181, 48);
		contentPane.add(lblNewLabel);
	}

	public void header() {
		JLabel lblNewLabel = new JLabel("FourAirlines");
		lblNewLabel.setForeground(new Color(255, 255, 255));
		lblNewLabel.setFont(new Font("Gabriola", Font.BOLD, 23));
		lblNewLabel.setBounds(10, 22, 100, 50);
		contentPane.add(lblNewLabel);
		
		JLabel foradmin = new JLabel("admin");
		foradmin.setBounds(167, 11, 57, 57);
		contentPane.add(foradmin);
		
		
		
		JLabel lblNewLabel_2 = new JLabel("THONG TIN CHI TIET");
		lblNewLabel_2.setForeground(new Color(255, 0, 0));
		lblNewLabel_2.setFont(new Font("Calibri", Font.BOLD, 14));
		lblNewLabel_2.setBounds(177, 236, 128, 22);
		contentPane.add(lblNewLabel_2);
		
		JLabel window = new JLabel(new ImageIcon("image/forPDC.png"), SwingConstants.CENTER);
		window.setForeground(new Color(255, 255, 255));
		window.setBounds(322, 11, 46, 54);
		contentPane.add(window);
		window.setText("");
		window.setHorizontalTextPosition(SwingConstants.RIGHT);
		window.setHorizontalTextPosition(SwingConstants.CENTER);
		
		JLabel windownight = new JLabel(new ImageIcon("image/forPDC night.png"), SwingConstants.CENTER);
		windownight.setForeground(Color.WHITE);
		windownight.setBounds(276, 468, 46, 54);
		contentPane.add(windownight);
		windownight.setText("");
		windownight.setHorizontalTextPosition(SwingConstants.RIGHT);
		windownight.setHorizontalTextPosition(SwingConstants.CENTER);
		
		JLabel left=new JLabel(new ImageIcon("image/byTrang.jpg"), SwingConstants.CENTER);
		left.setText("");
		left.setBounds(0, 0, 322, 539);
		left.setHorizontalTextPosition(SwingConstants.RIGHT);
		left.setHorizontalTextPosition(SwingConstants.CENTER);
		contentPane.add(left);
		
		
		JLabel icon = new JLabel(new ImageIcon("image/plane.png"), SwingConstants.CENTER);
		icon.setForeground(new Color(255, 255, 255));
		icon.setBounds(548, 27, 46, 38);
		contentPane.add(icon);
		icon.setText("");
		icon.setHorizontalTextPosition(SwingConstants.RIGHT);
		icon.setHorizontalTextPosition(SwingConstants.CENTER);
		
	}
	
	/**
	  * Get all nhanvien to display table.
	 * @throws ClassNotFoundException 
	  */
	 public void loadAllNhanVien() throws ClassNotFoundException {
		 //táº¡o control DefaultTableModel Ä‘á»ƒ hiá»ƒn thá»‹ danh sÃ¡ch NhanVien
	 String[] header = { "MA NV", "TEN NV", "Email", "SDT", "CHUC VU", "DIA CHI" };
	 DefaultTableModel dtm = new DefaultTableModel(header, 0);
	 //láº¥y danh sÃ¡ch NhanVienDTO (gá»�i hÃ m getAllNhanVien() trong NhanVienBLL)
	 ArrayList<NhanVienDTO> arr = new ArrayList<NhanVienDTO>();
	 NhanVienBLL NhanVienBLL = new NhanVienBLL();
	 arr = NhanVienBLL.getAllNhanVien();
	 
	 //Duyá»‡t máº£ng NhanVienDTO vá»«a láº¥y Ä‘Æ°á»£c: arr
	 NhanVienDTO NhanVienDTO = new NhanVienDTO();
	 for (int i = 0; i < arr.size(); i++) {
		 NhanVienDTO = arr.get(i);
		 
		 String ma_nv = NhanVienDTO.getMa_nv();
		 String ten_nv = NhanVienDTO.getTen_nv();
		 String email = NhanVienDTO.getEmail();
		 String sdt = NhanVienDTO.getSDT();
                 String chuc_vu = NhanVienDTO.getChucVu();
		 String dia_chi = NhanVienDTO.getDiaChi();
		 //táº¡o row Ä‘á»ƒ add vÃ o control DefaultTableModel
		 Object[] row = { ma_nv, ten_nv, email, sdt, chuc_vu, dia_chi };
		 dtm.addRow(row);
	 }
	 tblnhanvien.setModel(dtm);
	 }
	 /**
	  * Get all khachhang to display table.
	 * @throws ClassNotFoundException 
	  */
	 public void loadAllKhachHang() throws ClassNotFoundException {
		 //táº¡o control DefaultTableModel Ä‘á»ƒ hiá»ƒn thá»‹ danh sÃ¡ch KhachHang
	 String[] header = { "MA KH", "TEN KH","CMND/PP", "Email", "SDT", "DIA CHI" };
	 DefaultTableModel dtm = new DefaultTableModel(header, 0);
	 //láº¥y danh sÃ¡ch KhachHangDTO (gá»�i hÃ m getAllKhachHang() trong KhachHangBLL)
	 ArrayList<KhachHangDTO> arr = new ArrayList<KhachHangDTO>();
	 KhachHangBLL KhachHangBLL = new KhachHangBLL();
	 arr = KhachHangBLL.getAllKhachHang();
	 
	 //Duyá»‡t máº£ng KhachHangDTO vá»«a láº¥y Ä‘Æ°á»£c: arr
	 KhachHangDTO KhachHangDTO = new KhachHangDTO();
	 for (int i = 0; i < arr.size(); i++) {
		 KhachHangDTO = arr.get(i);
		 
		 String ma_kh = KhachHangDTO.getMa_kh();
		 String ten_kh = KhachHangDTO.getTen_kh();
		 String cmnd = KhachHangDTO.getCmnd();
		 String email = KhachHangDTO.getEmail();
		 String sdt = KhachHangDTO.getSDT();
		 String dia_chi = KhachHangDTO.getDiaChi();
		 //táº¡o row Ä‘á»ƒ add vÃ o control DefaultTableModel
		 Object[] row = { ma_kh, ten_kh, cmnd, email, sdt, dia_chi };
		 dtm.addRow(row);
	 }
	 tblKhachhang.setModel(dtm);
	 }
	 /**
	  * Get all chuyenbay to display table.
	 * @throws ClassNotFoundException 
	  */
	 public void loadAllChuyenBay() throws ClassNotFoundException {
		 //táº¡o control DefaultTableModel Ä‘á»ƒ hiá»ƒn thá»‹ danh sÃ¡ch ChuyenBay
	 String[] header = { "MA CB", "HANG HK", "TEN", "DIEM DI", "DIEM DEN", "SB DI", "SB DEN", "GIO", "NGAY", "LOAI GHE", "GIA", "QUY DINH" };
	 DefaultTableModel dtm = new DefaultTableModel(header, 0);
	 //láº¥y danh sÃ¡ch ChuyenBayDTO (gá»�i hÃ m getAllChuyenBay() trong ChuyenBayBLL)
	 ArrayList<ChuyenBayDTO> arr = new ArrayList<ChuyenBayDTO>();
	 ChuyenBayBLL ChuyenBayBLL = new ChuyenBayBLL();
	 arr = ChuyenBayBLL.getAllChuyenBay();
	 
	 //Duyá»‡t máº£ng ChuyenBayDTO vá»«a láº¥y Ä‘Æ°á»£c: arr
	 ChuyenBayDTO ChuyenBayDTO = new ChuyenBayDTO();
	 for (int i = 0; i < arr.size(); i++) {
		 ChuyenBayDTO = arr.get(i);
		 
		 String ma_cb = ChuyenBayDTO.getMaChuyenbay();
		 String hang_HK = ChuyenBayDTO.getHangHK();
                 String ten = ChuyenBayDTO.getTenMayBay();
                 String di = ChuyenBayDTO.getDiemDi();
                 String den = ChuyenBayDTO.getDiemDen();
                 String sb_di = ChuyenBayDTO.getSanBayDi();
                 String sb_den = ChuyenBayDTO.getSanBayDen();
		 Date ngay = ChuyenBayDTO.getNgayBay();
		 Time gio = ChuyenBayDTO.getGioBay();
		 String loaighe = ChuyenBayDTO.getLoaiGhe();
		 int gia = ChuyenBayDTO.getGia();
		 String quydinh = ChuyenBayDTO.getQuyDinh();
		 //táº¡o row Ä‘á»ƒ add vÃ o control DefaultTableModel
		 Object[] row = { ma_cb, hang_HK, ten, di, den, sb_di, sb_den, ngay, gio, loaighe, gia, quydinh };
		 dtm.addRow(row);
	 }
	 tblchuyenbay.setModel(dtm);
	 }
	 public void loadAllHoaDon() throws ClassNotFoundException {
		 //táº¡o control DefaultTableModel Ä‘á»ƒ hiá»ƒn thá»‹ danh sÃ¡ch HoaDon
	 String[] header = { "MA HD, TEN, NV, KH, VE CB, THANH TIEN, TRANG THAI, NGAY"};
	 DefaultTableModel dtm = new DefaultTableModel(header, 0);
	 //láº¥y danh sÃ¡ch HoaDonDTO (gá»�i hÃ m getAllHoaDon() trong HoaDonBLL)
	 ArrayList<HoaDonDTO> arr = new ArrayList<HoaDonDTO>();
	 HoaDonBLL HoaDonBLL = new HoaDonBLL();
	 arr = HoaDonBLL.getAllHoaDon();
	 
	 //Duyá»‡t máº£ng HoaDonDTO vá»«a láº¥y Ä‘Æ°á»£c: arr
	 HoaDonDTO HoaDonDTO = new HoaDonDTO();
	 for (int i = 0; i < arr.size(); i++) {
		 HoaDonDTO = arr.get(i);
		 
		 String ma_hd = HoaDonDTO.getMa_hd();
                 String ten = HoaDonDTO.getTen_hd();
		 int thanh_tien = HoaDonDTO.getThanh_tien();
		 Date ngay_lap = HoaDonDTO.getNgay_Lap();
                 String ma_kh = HoaDonDTO.getMa_kh();
		 String ma_nv = HoaDonDTO.getMa_nv();
                 String ma_ve = HoaDonDTO.getMa_ve_cb();
                 String trangthai = HoaDonDTO.getTrangThai();
                 String nv = null;
                 String kh = null;
                 
                 NhanVienBLL NVBLL = new NhanVienBLL();
                 NhanVienDTO NVDTO = new NhanVienDTO();
                 ArrayList<NhanVienDTO> nvs = new ArrayList<NhanVienDTO>();
                 NVDTO.setMa_nv(ma_nv);
                 nvs = NVBLL.getNhanVienByMANV(NVDTO);
                 for (int j = 0; j < nvs.size(); j++) {
                    NVDTO = nvs.get(j);
                    nv = NVDTO.getTen_nv();
                 }
                 
                 KhachHangBLL KHBLL = new KhachHangBLL();
                 KhachHangDTO KHDTO = new KhachHangDTO();
                 ArrayList<KhachHangDTO> khs = new ArrayList<KhachHangDTO>();
                 KHDTO.setMa_kh(ma_kh);
                 khs = KHBLL.getKhachHangByma_kh(KHDTO);
                 for (int l = 0; l < khs.size(); l++) {
                    KHDTO = khs.get(l);
                    kh = KHDTO.getTen_kh();
                 }
                 
		 
		 //táº¡o row Ä‘á»ƒ add vÃ o control DefaultTableModel
		 Object[] row = { ma_hd, ten, thanh_tien, ngay_lap, nv, kh, ma_ve, trangthai };
		 dtm.addRow(row);
	 }
	 tblHoadon.setModel(dtm);
	 }
	 
	 /**
	  * Get all vechuyenbay to display table.
	 * @throws ClassNotFoundException 
	  */
	 public void loadAllVeChuyenBay() throws ClassNotFoundException {
		 //táº¡o control DefaultTableModel Ä‘á»ƒ hiá»ƒn thá»‹ danh sÃ¡ch VeChuyenBay
	 String[] header = { "MA VE, SO GHE, MA CB, KH, NGAY, GIO, GIA, TINH TRANG VE" };
	 DefaultTableModel dtm = new DefaultTableModel(header, 0);
	 //láº¥y danh sÃ¡ch VeChuyenBayDTO (gá»�i hÃ m getAllVeChuyenBay() trong HVeChuyenBayBLL)
	 ArrayList<VeChuyenBayDTO> arr = new ArrayList<VeChuyenBayDTO>();
	 VeChuyenBayBLL VeChuyenBayBLL = new VeChuyenBayBLL();
	 arr = VeChuyenBayBLL.getAllVeChuyenBay();
	 
	 //Duyá»‡t máº£ng HoaDonDTO vá»«a láº¥y Ä‘Æ°á»£c: arr
	 VeChuyenBayDTO VeChuyenBayDTO = new VeChuyenBayDTO();
	 for (int i = 0; i < arr.size(); i++) {
		 VeChuyenBayDTO = arr.get(i);
		 
		 String ma_ve_cb = VeChuyenBayDTO.getMa_ve_cb();
		 String soghe = VeChuyenBayDTO.getSo_ghe();
		 String ma_cb = VeChuyenBayDTO.getMa_cb();
		 String ma_kh = VeChuyenBayDTO.getMa_kh();
                 Time gio = VeChuyenBayDTO.getThoi_gian_bay();
                 Date ngay = VeChuyenBayDTO.getNgay_bay();
                 int gia = VeChuyenBayDTO.getGia();
		 String tinh_trang = VeChuyenBayDTO.getTinhtrangve();
                 String kh = null;
                 
                 KhachHangBLL KHBLL = new KhachHangBLL();
                 KhachHangDTO KHDTO = new KhachHangDTO();
                 ArrayList<KhachHangDTO> khs = new ArrayList<KhachHangDTO>();
                 KHDTO.setMa_kh(ma_kh);
                 khs = KHBLL.getKhachHangByma_kh(KHDTO);
                 for (int l = 0; l < khs.size(); l++) {
                    KHDTO = khs.get(l);
                    kh = KHDTO.getTen_kh();
                 }
		 //táº¡o row Ä‘á»ƒ add vÃ o control DefaultTableModel
		 Object[] row = { ma_ve_cb, soghe, ma_cb , kh, ngay, gio, gia, tinh_trang};
		 dtm.addRow(row);
	 }
	 tblvechuyenbay.setModel(dtm);
	 }
}
