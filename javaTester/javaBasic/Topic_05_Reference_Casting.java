package javaBasic;

public class Topic_05_Reference_Casting {

	protected String ten;
	
	public String getTen() {
		return ten;
	}
	
	public void setTen(String ten) {
		this.ten = ten;
	}
	
	public void xuatThongTin() {
		System.out.println("Nhân viên: "+ ten);
	}
	
	public static void main(String[] args) {
		Topic_05_Reference_Casting nhanVien1 = new Topic_05_Reference_Casting();
		Topic_05_Reference_Casting nhanVien2 = new Topic_05_Reference_Casting();
		
		nhanVien1.setTen("Ha Noi");
		nhanVien2.setTen("Sai Gon");
		
		nhanVien1.xuatThongTin();
		nhanVien2.xuatThongTin();
		
		nhanVien2 = nhanVien1;
		
		nhanVien1.xuatThongTin();
		nhanVien2.xuatThongTin();
		
		nhanVien2.setTen("Da Nang");
		
		nhanVien1.xuatThongTin();
		nhanVien2.xuatThongTin();
	}
}
