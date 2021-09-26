package com.ss.utopia.dao;

import java.sql.Connection;
import java.sql.ResultSet;
import java.sql.SQLException;
import java.util.ArrayList;
import java.util.List;

import com.ss.utopia.entity.Airport;
import com.ss.utopia.entity.Booking;
import com.ss.utopia.entity.BookingAgent;
import com.ss.utopia.entity.User;

public class BookingAgentDAO extends BaseDAO<BookingAgent> {

	public BookingAgentDAO(Connection conn) {
		super(conn);
	}

	public void addBookingAgent(BookingAgent agent) throws ClassNotFoundException, SQLException {
		save("INSERT INTO booking_agent (booking_id, agent_id) VALUES (?, ?)", new Object[] {
				agent.getBookingId().getId(), agent.getAgentId().getUserId() });
	}

	public void updateBookingAgent(BookingAgent agent) throws ClassNotFoundException, SQLException {
		save("UPDATE booking_agent set booking_id = ? WHERE agent_id = ?",
				new Object[] {agent.getBookingId().getId(), agent.getAgentId().getUserId()});
	}

	public void deleteBookingAgent(BookingAgent agent) throws ClassNotFoundException, SQLException {
		save("Delete booking_agent where agent_id = ?", new Object[] { agent.getAgentId().getUserId() });
	}

	public List<BookingAgent> readBookingAgent() throws ClassNotFoundException, SQLException {
		return read("SELECT * FROM booking_agent", null);
	}

	@Override
	protected List<BookingAgent> extractData(ResultSet rs) throws SQLException {
		List<BookingAgent> agents = new ArrayList<>();

		while (rs.next()) {
			BookingAgent agent = new BookingAgent();
			agent.setBookingId(new Booking());
			agent.getBookingId().setId(rs.getInt("booking_id"));
			agent.setAgentId(new User());
			agent.getAgentId().setUserId(rs.getInt("agent_id"));
			agents.add(agent);
		}
		return agents;
	}
}
