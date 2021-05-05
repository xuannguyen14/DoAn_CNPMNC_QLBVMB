package DAL;

import java.sql.Connection;
import java.sql.PreparedStatement;
import java.sql.ResultSet;
import java.sql.SQLException;
import java.sql.Statement;
import java.util.ArrayList;
import java.util.Date;

import DTO.VeChuyenBayDTO;
import UTILS.ConnectionUtil;

public class VeChuyenBayDAL {
	private ConnectionUtil conUtil=null;
	private Connection con=null;
	
	private PreparedStatement preparedStatement;

	private ResultSet resultSet;
	
	private Statement st;

	public ArrayList<VeChuyenBayDTO> getAllVeChuyenBay() throws ClassNotFoundException {
			
		ArrayList<VeChuyenBayDTO> result = new ArrayList<VeChuyenBayDTO>();
		String sqlSelectAll = "select * from vechuyenbay";
			
		try {
			
			conUtil = new ConnectionUtil();
			con = conUtil.getConnection();
			
			preparedStatement = con.prepareStatement(sqlSelectAll);
			resultSet = preparedStatement.executeQuery();
			
			while(resultSet.next()) {
				VeChuyenBayDTO VeChuyenBayDTO = new VeChuyenBayDTO();
				VeChuyenBayDTO.setMa_ve_cb(resultSet.getString("ma_ve_cb"));
				VeChuyenBayDTO.setMa_cb(resultSet.getString("ma_cb"));
				VeChuyenBayDTO.setSo_ghe(resultSet.getString("soghe"));
				VeChuyenBayDTO.setMa_kh(resultSet.getString("ma_kh"));
				VeChuyenBayDTO.setThoi_gian_bay(resultSet.getTime("giobay"));
				VeChuyenBayDTO.setNgay_bay(resultSet.getDate("ngaybay"));
				VeChuyenBayDTO.setGia(resultSet.getInt("gia"));
				VeChuyenBayDTO.setTinhtrangve(resultSet.getString("tinh_trang_ve"));
				
				
				result.add(VeChuyenBayDTO);
			}
		} catch (SQLException e) {
			e.printStackTrace();
		}
		finally {
			try {
				
				con.close();
				preparedStatement.close();
				resultSet.close();
			} catch (SQLException e) {
				e.printStackTrace();
			  }
		}
		return result;
	}

	public ArrayList<VeChuyenBayDTO> getVeChuyenBayByMa_ve_cb(VeChuyenBayDTO VeChuyenBayDTO) throws ClassNotFoundException {
			
		ArrayList<VeChuyenBayDTO> result = new ArrayList<VeChuyenBayDTO>();
		String sqlSelectByma_ve_cb = "select * from vechuyenbay where ma_ve_cb = ?";
			
		try {
				
			conUtil = new ConnectionUtil();
			con = conUtil.getConnection();
			
			preparedStatement = con.prepareStatement(sqlSelectByma_ve_cb);
			preparedStatement.setString(1, VeChuyenBayDTO.getMa_ve_cb());
			resultSet  = preparedStatement.executeQuery();			
			
			while(resultSet.next()) {
				VeChuyenBayDTO VeChuyenBay = new VeChuyenBayDTO();
				VeChuyenBay.setMa_ve_cb(resultSet.getString("ma_ve_cb"));
				VeChuyenBay.setMa_cb(resultSet.getString("ma_cb"));
				VeChuyenBay.setSo_ghe(resultSet.getString("soghe"));
				VeChuyenBay.setMa_kh(resultSet.getString("ma_kh"));
				VeChuyenBay.setThoi_gian_bay(resultSet.getTime("giobay"));
				VeChuyenBay.setNgay_bay(resultSet.getDate("ngaybay"));
				VeChuyenBay.setGia(resultSet.getInt("gia"));
				VeChuyenBay.setTinhtrangve(resultSet.getString("tinh_trang_ve"));
				
				result.add(VeChuyenBay);
			}
		} catch (SQLException e) {
			e.printStackTrace();
		}
		finally {
			try {
				
				con.close();
				preparedStatement.close();
				resultSet.close();
			} catch (SQLException e) {
				e.printStackTrace();
			  }
		}
		return result;
	}
	
	public int insertVeChuyenBay(VeChuyenBayDTO VeChuyenBayDTO) throws ClassNotFoundException {
		
		int result = 0;
		String sqlInsert = "insert into vechuyenbay(ma_ve_cb,soghe,ma_cb,ma_kh,giobay,ngaybay,gia,tinh_trang_ve) values(?,?,?,?,?,?,?,?)";
		
		try {
			
			conUtil = new ConnectionUtil();
			con = conUtil.getConnection();
			
			preparedStatement = con.prepareStatement(sqlInsert);
			preparedStatement.setString(1,VeChuyenBayDTO.getMa_ve_cb());
			preparedStatement.setString(2, VeChuyenBayDTO.getSo_ghe());
			preparedStatement.setString(3, VeChuyenBayDTO.getMa_cb());
                        preparedStatement.setString(4, VeChuyenBayDTO.getMa_kh());
			preparedStatement.setTime(5, VeChuyenBayDTO.getThoi_gian_bay());
			preparedStatement.setDate(6, VeChuyenBayDTO.getNgay_bay());
			preparedStatement.setInt(7, VeChuyenBayDTO.getGia());
			preparedStatement.setString(8, VeChuyenBayDTO.getTinhtrangve());
		
			
			result = preparedStatement.executeUpdate();
		} catch (SQLException e) {
			e.printStackTrace();
		  }
		finally {
			try {
				con.close();
				preparedStatement.close();
			} catch (SQLException e) {
				e.printStackTrace();
			  }
		}
		return result;
	}
	
		public int updateVeChuyenBay(VeChuyenBayDTO VeChuyenBayDTO) throws ClassNotFoundException {
			
			int result = 0;
			String sqlUpdate = "update ve_chuyen_bay set soghe=?,ma_cb=?,ma_kh=?,giobay=?,ngaybay=?,gia=?,tinh_trang_ve=? where ma_ve_cb=? ";
			
			try {
			
				conUtil = new ConnectionUtil();
				con = conUtil.getConnection();
				
				preparedStatement = con.prepareStatement(sqlUpdate);
				preparedStatement.setString(1, VeChuyenBayDTO.getSo_ghe());
				preparedStatement.setString(2, VeChuyenBayDTO.getMa_cb());
				preparedStatement.setString(3, VeChuyenBayDTO.getMa_kh());
				preparedStatement.setTime(4, VeChuyenBayDTO.getThoi_gian_bay());
				preparedStatement.setDate(5, VeChuyenBayDTO.getNgay_bay());
				preparedStatement.setInt(6, VeChuyenBayDTO.getGia());
				preparedStatement.setString(7, VeChuyenBayDTO.getTinhtrangve());
				
				preparedStatement.setString(8, VeChuyenBayDTO.getMa_ve_cb());
				result = preparedStatement.executeUpdate();
			} catch (SQLException e) {
				e.printStackTrace();
			  }
			finally {
				try {
					con.close();
					preparedStatement.close();
				} catch (SQLException e) {
					e.printStackTrace();
				  }
			}
			return result;
		}
		
		public int deleteVeChuyenBay(VeChuyenBayDTO VeChuyenBayDTO) throws ClassNotFoundException {
				
			int result = 0;
			String sqlDelete = "delete from vechuyenbay where ma_ve_cb = ?";
			
			try {
					
				conUtil = new ConnectionUtil();
				con = conUtil.getConnection();
				
				preparedStatement = con.prepareStatement(sqlDelete);
				preparedStatement.setString(1,VeChuyenBayDTO.getMa_ve_cb());
				result = preparedStatement.executeUpdate();
			} catch (SQLException e) {
				e.printStackTrace();
			  }
			finally {
				try {
					con.close();
					preparedStatement.close();
				} catch (SQLException e) {
					e.printStackTrace();
				  }
			}
			return result;
		}
		
		public ArrayList<VeChuyenBayDTO> getVeChuyenBayByMa_cb(VeChuyenBayDTO VeChuyenBayDTO) throws ClassNotFoundException {
			
			ArrayList<VeChuyenBayDTO> result = new ArrayList<VeChuyenBayDTO>();
			String sqlSelectByma_ve_cb = "select * from vechuyenbay where ma_cb = ?";
				
			try {
					
				conUtil = new ConnectionUtil();
				con = conUtil.getConnection();
				
				preparedStatement = con.prepareStatement(sqlSelectByma_ve_cb);
				preparedStatement.setString(1, VeChuyenBayDTO.getMa_cb());
				resultSet  = preparedStatement.executeQuery();			
				
				while(resultSet.next()) {
					VeChuyenBayDTO VeChuyenBay = new VeChuyenBayDTO();
					VeChuyenBay.setMa_ve_cb(resultSet.getString("ma_ve_cb"));
                                        VeChuyenBay.setMa_cb(resultSet.getString("ma_cb"));
                                        VeChuyenBay.setSo_ghe(resultSet.getString("soghe"));
                                        VeChuyenBay.setMa_kh(resultSet.getString("ma_kh"));
                                        VeChuyenBay.setThoi_gian_bay(resultSet.getTime("giobay"));
                                        VeChuyenBay.setNgay_bay(resultSet.getDate("ngaybay"));
                                        VeChuyenBay.setGia(resultSet.getInt("gia"));
                                        VeChuyenBay.setTinhtrangve(resultSet.getString("tinh_trang_ve"));
					
					result.add(VeChuyenBay);
				}
			} catch (SQLException e) {
				e.printStackTrace();
			}
			finally {
				try {
					
					con.close();
					preparedStatement.close();
					resultSet.close();
				} catch (SQLException e) {
					e.printStackTrace();
				  }
			}
			return result;
		}
}
