package com.studio.bookings.service;

import java.util.ArrayList;
import java.util.List;

import javax.inject.Named;

import com.google.api.server.spi.config.Api;
import com.google.api.server.spi.config.ApiMethod;
import com.studio.bookings.entity.Account;
import com.studio.bookings.entity.Calendar;
import com.studio.bookings.util.Constants;

@Api(
	    name = "booking",
	    version = "v1",
	    scopes = {Constants.EMAIL_SCOPE},
	    clientIds = {Constants.WEB_CLIENT_ID},
	    audiences = {Constants.ANDROID_AUDIENCE}
	)

public class CalendarService extends BaseService {
	
	@ApiMethod(name = "calendar.addCalendar", path="calendar.addCalendar", httpMethod = "post")
	public Calendar insertCalendar( 
			@Named("description") String description,  
			@Named("account") Long accountId) {
		Long oId = new Long(accountId);
		Account account =  accountDao.retrieve(oId);
		Calendar calendar = new Calendar(description, account);
		calendarDao.save(calendar);
	    return calendar; 
	}
	
	@ApiMethod(name = "calendar.findCalendar", path="calendar.findCalendar", httpMethod = "get")
	public Calendar findCalendar(@Named("calendar") Long calendarId, @Named("account") Long accountId) {
		Account account = accountDao.retrieve(accountId);
		return calendarDao.retrieveAncestor(calendarId, account);
	}
	
	@ApiMethod(name = "calendar.listCalendars", path="calendar.listCalendars", httpMethod = "get")
	public List<Calendar> listCalendars(@Named("account") Long accountId) {
		Account accountFetched = accountDao.retrieve(accountId);
		return calendarDao.listAncestors(accountFetched);
	}
	
	@ApiMethod(name = "calendar.updateCalendar", path="calendar.updateCalendar", httpMethod = "post")
	public Calendar updateCalendar(@Named("calendar") Long calendarId,  @Named("account") Long accountId, 
			@Named("description") String description) {
		Account accountFetched = accountDao.retrieve(accountId);
		Calendar calendarFetched = calendarDao.retrieveAncestor(calendarId, accountFetched);
		calendarFetched.setDescription(description);
		calendarDao.save(calendarFetched);
		return calendarFetched;
	}
	
	@ApiMethod(name = "calendar.deleteCalendar", path="calendar.deleteCalendar", httpMethod = "post")
	public void deleteCalendar(
			@Named("calendar") Long calendarId,
			@Named("account") Long accountId) {
		Account accountFetched = accountDao.retrieve(accountId);
		List<Long> idsToDelete = new ArrayList<Long>();
		idsToDelete.add(calendarId);
		calendarDao.deleteAncestors(idsToDelete, accountFetched);
	}
	
	public void deleteAcl(
			@Named("aclList") List<Long> aclIds,
			@Named("account") Long accountId) {
		Account accountFetched = accountDao.retrieve(accountId); 
		aclDao.deleteAncestors(aclIds, accountFetched);
	}
}
