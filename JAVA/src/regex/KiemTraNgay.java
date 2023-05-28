package regex;
import java.text.ParseException;
import java.text.SimpleDateFormat;
import java.util.Date;
public class KiemTraNgay {
	// trả về true nếu ngày 1 nhỏ hơn ngày 2
		public static boolean checkDate(String day) {
			SimpleDateFormat formatter = new SimpleDateFormat("dd/MM/yyyy");
			Date d1, d2;
			String date = new SimpleDateFormat("dd/MM/yyyy").format(new Date());
			boolean check = false;
			try {
				d1 = formatter.parse(day);
				d2 = formatter.parse(date);
				if (d1.compareTo(d2) < 0) {
					check = true;
				}
			} catch (ParseException e) {
				// TODO Auto-generated catch block
				e.printStackTrace();
			}
			return check;
		}

		public static boolean checkDate(String ngayDi, String ngayVe) {
			
			SimpleDateFormat formatter = new SimpleDateFormat("dd/MM/yyyy");
			
			Date d1, d2;
			
			boolean check = false;
			try {
				d1 = formatter.parse(ngayDi);
				d2 = formatter.parse(ngayVe);
				if (d1.compareTo(d2) < 0) {
					check = true;
				}
			} catch (ParseException e) {
				// TODO Auto-generated catch block
				e.printStackTrace();
			}
			return check;
		}
}
