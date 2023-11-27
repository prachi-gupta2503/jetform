<%@page import="com.liferay.portal.kernel.service.UserNotificationEventLocalServiceUtil"%>
<%@page import="com.liferay.portal.kernel.dao.orm.QueryUtil"%>
<%@page import="net.ayudh.portal.notification.model.Notification"%>
<%@page import="com.liferay.portal.kernel.service.UserNotificationEventLocalService" %>
<%@page import="java.util.List"%>
<%@ include file="/init.jsp"%>

<div id="notificationIndicator" class="text-right dropdown">
<button class="badge badge-light" data-toggle="dropdown">
<div class="mb-2 text-white bg-danger p-1 rounded-circle">                
 <span id="countNotification"></span></div>
 <i class="far fa-bell fa-3x text-warning"></i>         
         </button> 
         <ul id="notificationMessages" class="dropdown-menu" role="menu">         
         </ul>
          </div>  
<script>
class Notification{
	constructor(message,notificationId,table){
		this.message=message;
		this.notificationId=notificationId;
		this.table=table;
	}
}

$(document).ready(function() {
	getNotifications();
});

function getNotifications(){
	var unreadMessages=new Array();
	var unreadNotification=getUnreadNotifications();	
	var clientUnreadNotification=getClientUnreadNotifications(); 
    getUnreadNotificationCount();
    $.each(unreadNotification, function(key, val){
    	unreadMessages.push(val);
	  });
    $.each(clientUnreadNotification, function(key, val){
    	unreadMessages.push(val);
	  });
    createNotificationView(unreadMessages);	
}

function getUnreadNotificationCount(){
	Liferay.Service(
			  '/comnetportal.notification/unread-notifications-count',
			  function(obj) {
			    console.log(obj);
			    $('#countNotification').html(obj);
			  }
			);
}

function getUnreadNotifications(){
	var resp = [];
	 var form = new FormData();
	 form.append("p_auth", Liferay.authToken);
	 var settings = {
		        "url":  "http://localhost:8080/api/jsonws/comnetportal.notification/get-unread-user-notifications",
		        "timeout": 0,
		        "headers": {},
		        "processData": false,
		        "mimeType": "multipart/form-data",
		        "contentType": false,
		        "async": false,
		        "data": form
		    };
	 $.ajax(settings).done(function(result) {
		  $.each(JSON.parse(result), function(key, val){
			  resp.push(new Notification(val.payload,val.userNotificationEventId,"liferay"));
		  });
      
  });
	return resp;
}

function createNotificationView(notifications){
	var source = $('#notification-indicator-template').html();
	var template = Handlebars.compile(source);
	var resultHtml = template(notifications );
	$("#notificationMessages").html(resultHtml);
}

function changeNotificationStatus(notificationId){
	let id=notificationId.split(',');
	if(id[1]=="client"){
		clickClientNotification(id[0]);
	}
	else{
		clickNotification(id[0]);
	}
}


 function clickNotification(userNotificationEventId){
	 Liferay.Service(
			  '/comnetportal.notification/update-user-notification-archieved-status',
			  {
			    userNotificationEventId: userNotificationEventId
			  },
			  function(obj) {
				  getUnreadNotificationCount();
				  getNotifications();
			   
			  }
			);

 }
 
 function getClientUnreadNotifications(){
	 var clientresp=[];
	 var form = new FormData();
	 form.append("p_auth", Liferay.authToken);
	 var settings = {
		        "url":  "http://localhost:8080/api/jsonws/comnetportal.notification/get-notifications-by-status/status/0",
		        "timeout": 0,
		        "headers": {},
		        "processData": false,
		        "mimeType": "multipart/form-data",
		        "contentType": false,
		        "async": false,
		        "data": form
		    };
	 $.ajax(settings).done(function(result) {
		 $.each(JSON.parse(result), function(key, val){
			 let newNotification=new Notification(val.message,val.notificationId,"client");
			 clientresp.push(newNotification);
      
      
  });
	 });
		return clientresp;
				}
 
 function clickClientNotification(notificationId){
	 Liferay.Service(
			  '/comnetportal.notification/update-notification-status',
			  {
			    notificationId: notificationId
			  },
			  function(obj) {
				  getUnreadNotificationCount();
				  getNotifications();
			  }
			);

 }
 
</script>

<script type="text/x-handlebars-template" id="notification-indicator-template">
{{#each this}}
  <li><a onClick="changeNotificationStatus('{{this.notificationId}},{{this.table}}')">{{this.message}}</a></li>
{{/each}}
<li><a onClick="#">more</a></li>
  
</script>

