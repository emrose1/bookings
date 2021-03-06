package com.studio.bookings.service;

import java.util.List;

import com.google.api.server.spi.config.Api;
import com.google.api.server.spi.config.ApiMethod;
import com.google.api.server.spi.config.Named;
import com.google.api.server.spi.config.ApiMethod.HttpMethod;
import com.google.appengine.api.users.User;
import com.studio.bookings.entity.Account;
import com.studio.bookings.entity.Calendar;
import com.studio.bookings.enums.Permission;
import com.studio.bookings.util.Constants;

@Api(
	    name = "booking",
	    version = "v1",
	    scopes = {Constants.EMAIL_SCOPE},
	    clientIds = {Constants.WEB_CLIENT_ID},
	    audiences = {Constants.ANDROID_AUDIENCE}
	)

public class CalendarService extends BaseService {
	public static AccessControlListService aclService = new AccessControlListService();
	Permission aclPermission = Permission.CALENDAR;
	
	@ApiMethod(name = "calendar.insertCalendar", path="account/{account_id}/calendar",  httpMethod = HttpMethod.POST)
	public Calendar insertCalendar( 
		@Named("description") String description,  
		@Named("account_id") Long accountId,
		User user) {
		
		Calendar calendar = null;
		//if(user != null) { 
    		// TODO THROW UNAUTHORIZED EXCEPTION
    		//if (aclService.allowInsert(accountId, aclPermission.toString(), user).get(0)) {
				Account account =  accountDao.retrieve(accountId);
				calendar = new Calendar(description, account);
				calendarDao.save(calendar);
    		//}
		//}
	    return calendar; 
	}
	
	@ApiMethod(name = "calendar.getCalendar", path="account/{account_id}/calendar/{id}",  httpMethod = HttpMethod.GET)
	public Calendar getCalendar(
		@Named("id") Long calendarId, 
		@Named("account_id") Long accountId,
		User user) {

		Calendar calendar = null;
		//if(user != null) { 
    		// TODO THROW UNAUTHORIZED EXCEPTION
    		//if (aclService.allowView(accountId, aclPermission.toString(), user).get(0)) {
    			Account account = accountDao.retrieve(accountId);
    			calendar = calendarDao.retrieveAncestor(calendarId, account);
    		//}
		//}
		return calendar;
	}
	
	@ApiMethod(name = "calendar.listCalendars", path="account/{account_id}/calendar",  httpMethod = HttpMethod.GET)
	public List<Calendar> listCalendars(
			@Named("account_id") Long accountId,
			User user) {
		
		List<Calendar> calendarList = null;
		//if(user != null) { 
    		// TODO THROW UNAUTHORIZED EXCEPTION
    		//if (aclService.allowViewAll(accountId, aclPermission.toString(), user).get(0)) {
    			Account accountFetched = accountDao.retrieve(accountId);
    			calendarList = calendarDao.listAncestors(accountFetched);
    		//}
		//}
		return calendarList;
	}
	
	@ApiMethod(name = "calendar.updateCalendar", path="account/{account_id}/calendar/{id}", httpMethod = HttpMethod.PUT)
	public Calendar updateCalendar(@Named("id") Long calendarId,  @Named("account_id") Long accountId, 
			@Named("description") String description, User user) {
		Calendar calendar = null;
		//if(user != null) {	
			//if (aclService.allowUpdate(accountId, aclPermission.toString(), user).get(0)) {
				Account accountFetched = accountDao.retrieve(accountId);
				calendar = calendarDao.retrieveAncestor(calendarId, accountFetched);
				calendar.setDescription(description);
				calendarDao.save(calendar);
			//}
		//}
		return calendar;
	}
	
	@ApiMethod(name = "calendar.removeCalendar", path="account/{account_id}/calendar/{id}", httpMethod = HttpMethod.DELETE)
	public void removeCalendar(
			@Named("id") String calendarId,
			@Named("account_id") String accountId,
			User user) {
		
		//if(user != null) {	
			//if (aclService.allowDelete(Long.valueOf(accountId), aclPermission.toString(), user).get(0)) {
				Account accountFetched = accountDao.retrieve(Long.valueOf(accountId));
				calendarDao.deleteAncestors(Long.valueOf(calendarId), accountFetched);
			//}
		//}
	}

}
