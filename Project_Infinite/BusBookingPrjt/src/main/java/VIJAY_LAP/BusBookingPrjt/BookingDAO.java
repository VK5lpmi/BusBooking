package vijaypc.BusBookingPrjt;


import java.text.ParseException;
import java.text.SimpleDateFormat;
import java.util.Date;
import java.util.List;

import org.hibernate.Criteria;
import org.hibernate.Session;
import org.hibernate.SessionFactory;
import org.hibernate.Transaction;

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
		String bookId = bk.get(bk.size() - 1).getUserId();
		int id = Integer.parseInt(bookId.substring(1));
		id++;
		String id1 = String.format("U%03d", id);
		return id1;
	}
	
	public String generateScheduleID() {
		
		sessionFactory = SessionHelper.getConnection();
		session =sessionFactory.openSession();
		Criteria cr = session.createCriteria(Booking.class);
		List<Booking> bk = cr.list();
		session.close();
		String bookId = bk.get(bk.size() - 1).getScheduleId();
		int id = Integer.parseInt(bookId.substring(1));
		id++;
		String id1 = String.format("SD%03d", id);
		return id1;
		
	}
	
public java.sql.Date convertDate(String dt) throws ParseException{
	SimpleDateFormat sdf = new SimpleDateFormat("yyyy-MM-dd");
	Date dl = sdf.parse(dt);
	return new java.sql.Date(dl.getTime());
	
}
	
	public String addBooking(Booking booking) {
		sessionFactory = SessionHelper.getConnection();
		session =sessionFactory.openSession();
		String bookingId = generateBookingId();
		String userId = generateUserID();
		String scheduleId = generateScheduleID();
		java.sql.Date sqlDate = new java.sql.Date(booking.getDateOfBooking().getTime());
		Transaction tr = session.beginTransaction();
		booking.setBookingId(bookingId);
		booking.setUserId(userId);
		booking.setScheduleId(scheduleId);
		booking.setBookingStatus(BookingStatus.PENDING);
		booking.setDateOfBooking(sqlDate);
		session.save(booking);
		tr.commit();
		return "Booking Done";
	}
	
	public BookingDAO() {}
}
