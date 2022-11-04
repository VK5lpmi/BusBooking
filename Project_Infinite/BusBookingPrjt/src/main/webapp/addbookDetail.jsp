<%@ taglib uri="http://java.sun.com/jsp/jstl/core" prefix="c" %>
<%@ page language="java" contentType="text/html; charset=ISO-8859-1"
    pageEncoding="ISO-8859-1"%>
<!DOCTYPE html>
<html>
<head>
<meta charset="ISO-8859-1">
<title>Insert title here</title>
</head>
<body>
<form action="addbookDetail.jsp" method="post">
	
		Seat NO:
		<input type="number" name="seatNo"/> <br/> <br/>
		
		Fare Amount:
		<input type="number" name="fareAmount"/> <br/><br/>
		
		Total Amount:
		<input type="number" name = "totalAmount"/> <br/><br/>
		
		DateOfBooking:
		<input type="date" name="dateOfBooking"/> <br/><br/>
		<input type="submit" value="Booked..."/>
	</form>
<c:if test="${param.seatNo!=null }">
	<jsp:useBean id="dao" class="com.infinite.bus.BookingDAO"/>
	<jsp:useBean id="booking" class="com.infinite.bus.Booking"/>
	<c:set var="dob" value="${dao.convertDate(param.dateOfBooking) }"/>
	<jsp:setProperty property="seatNo" name="booking" value="${param.seatNo }"/>
	<jsp:setProperty property="fareAmount" name="booking" value="${param.fareAmount }"/>
	<jsp:setProperty property="totalAmount" name="booking" value="${param.totalAmount }"/>
	<jsp:setProperty property="dateOfBooking" name="booking" value="${dob}"/>
	<c:out value="${dao.addBooking(booking)}"/>
	</c:if>
</body>
</html>