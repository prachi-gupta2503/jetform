<%@page import="com.liferay.portal.kernel.json.JSONArray"%>
<%@page import="java.text.SimpleDateFormat"%>
<%@page import="java.util.Date"%>
<%@ include file="/init.jsp" %>
<style>

.fc-day{
/* background-color:lightgrey !important; */
}

.fc-daygrid-day-top{
justify-content: center !important;
}

.fc-toolbar-chunk{
margin-bottom: var(--spacer-3) !important;
margin-top: var(--spacer-3) !important;

}

/* .ui-icon-closethick {
    background-position: -96px -128px;
    background-color: red;
} */

.pis-calendar{
  background-color: #D6EAF8;
  height:300px; 
}
.fc .fc-toolbar.fc-header-toolbar {
    margin-bottom: -1em;
    margin-top: -1em;
}

.container {
/*   background: gray; */
  width: 100%;
  max-height: 200px;
  overflow: auto;
}

</style>
<%
String pattern = "yyyy-MM-dd";
SimpleDateFormat simpleDateFormat = new SimpleDateFormat(pattern);

String currentDate = simpleDateFormat.format(new Date());
System.out.println(currentDate);

JSONArray eventsArray = (JSONArray)request.getAttribute("events");

System.out.println(eventsArray);
%>
<div id='calendar' class="pis-calendar"></div>
<div id="event-detail" class="container">
	<div class="card">
		<div class="card-body">
			<div id="event-detail-data">
				<div class="panel panel-default">
					<div class="taglib-header panel-heading">
						<h3 class="header-title">
							<span id="event-title"> </span>
						</h3>
					</div>
					<fieldset aria-labelledby="Title" class=" " role="group">
						<div aria-labelledby="Header" class="show  " id="Content"
							role="presentation">
							<div class="panel-body">
								<dl class="property-list">
									<dt>Starts:</dt>
									<dd id="event-start-date"></dd>
									<dt>Ends:</dt>
									<dd id="event-end-date"></dd>
								</dl>
							</div>
						</div>
					</fieldset>
				</div>
			</div>
		</div>
	</div>
</div>

<script>
	
    document.addEventListener('DOMContentLoaded', function() {
	var calendarEl = document.getElementById('calendar');

	var calendar = new FullCalendar.Calendar(calendarEl, {
    initialView: 'dayGridMonth',
    initialDate: '<%=currentDate%>',
    headerToolbar: {
      left: ''/* 'prev,next today' */,
      center: 'title',
      right: ''
    },
	customButtons: {
      addEventButton: {
        text: 'add event...',
        click: function() {
          var dateStr = prompt('Enter a date in YYYY-MM-DD format');
          var date = new Date(dateStr + 'T00:00:00'); // will be in local time

          if (!isNaN(date.valueOf())) { // valid?
            calendar.addEvent({
              title: 'dynamic event',
              start: date,
              allDay: true
            });
            alert('Great. Now, update your database...');
          } else {
            alert('Invalid date.');
          }
        }
      }
    },
    events: <%=eventsArray%>
  });

  calendar.render();
});
    
    $("#event-detail").dialog({
        autoOpen: false,
    });
    function showEventDetails(event){
    	var eventObject = jQuery.parseJSON( event );
    	$("#event-title").html(eventObject.title)
    	 $("#event-start-date").html(eventObject.start)
    	$("#event-end-date").html(eventObject.end)
    	setTimeout(function(){
    		$("#event-detail").dialog("open");
    	},1000);
    }
$(function(){
	$('[id^=portlet_calendar_CalendarPortlet_INSTANCE]').attr("style","margin-right:20px;")	
	$("th").children().each(function(){
		$(this).attr("style","background-color:black");
		$(this).find("a").attr("style","color:white");
	});
	$("td").children().each(function(){
		//$(this).attr("style","background-color:aqua");
	});
})


$(document).ready(function() {
let vv;
vv = $('button.ui-button.ui-corner-all.ui-widget.ui-button-icon-only.ui-dialog-titlebar-close')[0].childNodes[2].textContent = '';
/* vv.textContent = ''; */

});


</script>
 
  
