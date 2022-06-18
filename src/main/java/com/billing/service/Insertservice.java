package com.billing.service;

import java.io.FileNotFoundException;
import java.io.IOException;
import java.sql.SQLException;
import java.util.List;
import com.billing.dao.*;
import com.billing.dao.AdminproDao;
import com.billing.dao.History;
import com.billing.entity.Billdata;
import com.billing.entity.Cdata;

public class Insertservice {
	public static boolean insertdata(Cdata c) throws SQLException, IOException, Exception {
		int n = new AdminproDao().prodao(c);
		if (n == 1) {
			return true;
		} else {
			return false;
		}
	}

	public static List<Cdata> view() {
		List<Cdata> al = new History().record();
		return al;
	}

	public static Cdata billing(int meter) throws SQLException {
		return new BillDao().billing(meter);

	}

	public double getbillamount(int unit) {
		double billToPay = 0;
		if (unit <= 100) {
			billToPay = unit * 4.40;
		}

		else if (unit <= 300) {
			billToPay = 100 * 4.40 + (unit - 100) * 2;
		}

		else if (unit > 300) {
			billToPay = 100 * 4.40 + 200 * 2 + (unit - 300) * 3;
		}

		return billToPay;
	}

	public void gobillinsert(Billdata bd) throws SQLException {
		new BillDao().billinsert(bd);
	}

	public void update(Cdata c) throws SQLException {
		new UpdateDao().Udao(c);

	}

	public void erase(Cdata c) throws FileNotFoundException, ClassNotFoundException, IOException {
		new Admindelete().delete(c);
	}

}
