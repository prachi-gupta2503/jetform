
<%@page import="com.liferay.portal.kernel.service.ContactLocalServiceUtil"%>
<%@page import="com.liferay.portal.kernel.service.ContactServiceUtil"%>
<%@page import="com.liferay.portal.kernel.service.ServiceContextFactory"%>
<%@page import="com.liferay.portal.kernel.service.ServiceContext"%>
<%@page import="com.liferay.portal.kernel.util.GroupThreadLocal"%>
<%@page import="java.util.Locale"%>
<%@page import="com.liferay.portal.kernel.security.auth.CompanyThreadLocal"%>
<%@page import="com.liferay.portal.kernel.security.auth.PrincipalThreadLocal"%>
<%@page import="com.liferay.portal.kernel.service.UserLocalServiceUtil"%>
<%@page import="com.liferay.portal.kernel.model.User"%>
<%@page import="com.liferay.counter.kernel.service.CounterLocalServiceUtil"%>
<%@page import="com.liferay.portal.kernel.log.LogFactoryUtil"%>
<%@page import="com.liferay.portal.kernel.log.Log"%>
<%@ include file="/init.jsp"%>
<script type="text/javascript" src="<%=request.getContextPath()%>/js/jquery-3.5.1.min.js"></script>
<script type="text/javascript" src="<%=request.getContextPath()%>/js/handlebars.min.js"></script>
<%!
private static final Log LOGGER = LogFactoryUtil.getLog("org.apache.jsp.view002_jsp");
%>
<%
ServiceContext serviceContext = 
ServiceContextFactory.getInstance(User.class.getName(), request);
String message="";
try {
	
	//long userId = CounterLocalServiceUtil.increment(User.class.getName());
	
	//UserLocalServiceUtil.addUser(addUser(creatorUserId, companyId, autoPassword, password1, password2, autoScreenName, screenName, emailAddress, locale, firstName, middleName, lastName, prefixId, suffixId, male, birthdayMonth, birthdayDay, birthdayYear, jobTitle, groupIds, organizationIds, roleIds, userGroupIds, sendEmail, serviceContext)
	User user1=UserLocalServiceUtil.addUser(PrincipalThreadLocal.getUserId(), CompanyThreadLocal.getCompanyId(), false, "oFb12345@", "oFb12345@", true, null, "nayak.arjun@gmail.con", Locale.getDefault(), "Nayak", "", "Arjun", 0, 0, true, 06, 12, 1971, "Director", new long[]{GroupThreadLocal.getGroupId()}, new long[]{42602},  new long[]{52612}, new long[]{52622}, true, serviceContext);
	/*User user2=UserLocalServiceUtil.createUser(userId);
	
	user2.setCompanyId(CompanyThreadLocal.getCompanyId());
	user2.setEmailAddress("nayak.arjun@gmail.com");
	user2.setFirstName("Nayak");
	user2.setLastName("Arjun");
	user2.setMiddleName("Charan");
	user2.setScreenName("9923456");
	user2.setPassword("oFb12345@");
	//user2.setScreenName("Nayak Arjun");*/
	
	/*Date birthday = getBirthday(03, 21, 1971);

	Contact contact = ContactLocalServiceUtil.createContact(user.getContactId());

	contact.setCompanyId(user.getCompanyId());
	contact.setUserId(creatorUserId);
	contact.setUserName(creatorUserName);
	contact.setClassName(User.class.getName());
	contact.setClassPK(user.getUserId());
	contact.setAccountId(company.getAccountId());
	contact.setParentContactId(ContactConstants.DEFAULT_PARENT_CONTACT_ID);
	contact.setEmailAddress(user.getEmailAddress());
	contact.setFirstName(firstName);
	contact.setMiddleName(middleName);
	contact.setLastName(lastName);
	contact.setPrefixId(prefixId);
	contact.setSuffixId(suffixId);
	contact.setMale(male);
	contact.setBirthday(birthday);
	contact.setJobTitle(jobTitle);*/
	
	
	//UserLocalServiceUtil.updateUser(user2);
	message="User created - "+user1.getUserId()+" - "+user1.getFullName();
}catch(Exception e) {
	LOGGER.info(e);
	message=e.getMessage();
}
%>
<h3>
	<%=message%>
</h3>