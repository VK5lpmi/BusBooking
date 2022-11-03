package VIJAY_LAP.BusBookingPrjt;

import java.util.List;

import org.hibernate.Criteria;
import org.hibernate.Session;
import org.hibernate.SessionFactory;

public class BookingDAO {

	SessionFactory sessionFactory;
	Session session;
	
	public String generateBookingId() {
		
		sessionFactory = SessionHelper.getConnection();
		session =sessionFactory.openSession();
		Criteria cr = session.createCriteria(Booking.class);
		List<Booking> bk = cr.list();
		session.close();
		String bookId = bk.get(bk.size() - 1).getBookingId();
		int id = Integer.parseInt(bookId.substring(1));
		id++;
		String id1 = String.format("BK%03d", id);
		return id1;
		
}
	public String  generateUserID() {
		
		sessionFactory = SessionHelper.getConnection();
		session =sessionFactory.openSession();
		Criteria cr = session.createCriteria(Booking.class);
		List<Booking> bk = cr.list();
		session.close();
		String bookId = bk.get(bk.size() - 1).getBookingId();
		int id = Integer.parseInt(bookId.substring(1));
		id++;
		String id1 = String.format("U%03d", id);
		return id1;
	}
}