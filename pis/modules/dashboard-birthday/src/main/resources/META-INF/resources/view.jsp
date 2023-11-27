<%@page import="com.liferay.portal.kernel.json.JSONArray"%>
<%@ include file="/init.jsp"%>


<%
	JSONArray birthdayList = (JSONArray) request.getAttribute("birthdayList");
	//out.println(birthdayList);
%>

<%--<link href="http://maxcdn.bootstrapcdn.com/bootstrap/3.3.7/css/bootstrap.min.css" rel="stylesheet"/>
<script	src="//ajax.googleapis.com/ajax/libs/jquery/1.12.4/jquery.min.js"></script>
<script	src="//maxcdn.bootstrapcdn.com/bootstrap/3.3.7/js/bootstrap.min.js"></script> --%>
<style>
.carousel-inner>.item {
	position: relative;
	bottom: 15px;
	opacity: 0;
	opacity: 0;
	height: 0;
	overflow: hidden;
	-webkit-transition: bottom 600ms cubic-bezier(0.1, 1, 0.28, 1), opacity
		400ms cubic-bezier(0.1, 1, 0.28, 1), visibility 400ms
		cubic-bezier(0.1, 1, 0.28, 1);
	transition: bottom 600ms cubic-bezier(0.1, 1, 0.28, 1), opacity 400ms
		cubic-bezier(0.1, 1, 0.28, 1), height 600ms
		cubic-bezier(0.1, 1, 0.28, 1);
	-webkit-transition: bottom 600ms cubic-bezier(0.6, 1, 0.28, 1) 150ms,
		opacity 400ms cubic-bezier(0.1, 1, 0.28, 1) 200ms;
	transition: bottom 600ms cubic-bezier(0.1, 1, 0.28, 1) 150ms, opacity
		400ms cubic-bezier(0.1, 1, 0.28, 1) 150ms;
	transform: none !important;
}

.modal-dialog{
    overflow-y: initial !important
}

.modal-body{
    height: 500px;
    overflow-y: auto;
}


.carousel-inner>.item.active {
	bottom: 0;
	opacity: 1;
	height: inherit;
	-webkit-transition: bottom 600ms cubic-bezier(0.1, 1, 0.28, 1), opacity
		450ms cubic-bezier(0.1, 1, 0.28, 1);
	transition: bottom 600ms cubic-bezier(0.1, 1, 0.28, 1), opacity 400ms
		cubic-bezier(0.1, 1, 0.32, 1);
	-webkit-transition: bottom 600ms cubic-bezier(0.1, 1, 0.28, 1) 130ms,
		opacity 400ms cubic-bezier(0.1, 1, 0.28, 1) 150ms;
	transition: bottom 600ms cubic-bezier(0.6, 1, 0.28, 1) 130ms, opacity
		450ms cubic-bezier(0.1, 1, 0.28, 1) 130ms;
	transform: none !important;
} 
/* .modal.show .modal-dialog {
    transform: matrix(1, 0, 0, 1, 0, 0); 
}  */
</style>

<div class="card"
    style="background-color: CornflowerBlue; height: 210px;">
	<div class="row">
		<div class="mt-2 mb-1 ml-3 mr-1 col-sm-8">
			<h3 style="color: white;">Birthday's Today</h3>
		</div>
		<div class="col-sm-3 mt-1"></div>
	</div>
	<div class="card-body">

		<%
			if (birthdayList != null && birthdayList.length() > 0) {
		%>
		        <div id="carouselExampleControls" class="carousel slide"
            data-ride="carousel">
			<div class="carousel-inner">
				<c:forEach begin="0" end="${birthdayList.length() -1}" var="index">

					<c:choose>
						<c:when test="${index == 0}">
							<div class="carousel-item active">
						</c:when>
						<c:otherwise>
							<div class="carousel-item">
						</c:otherwise>
					</c:choose>
					<div class="text-center">
						<c:choose>
							<c:when test="${birthdayList.getJSONObject(index).getString('profileImage')!=''}">
								<div class='birthday-user-image'>
									<img src='/documents/${birthdayList.getJSONObject(index).getString("profileImage")}'>
								</div>
							</c:when>
							<c:otherwise>
								<div class='birthday-user-image'>
									<img src='<%=request.getContextPath()%>/images/blankUser.jpg' />
								</div>
							</c:otherwise>
						</c:choose>

						<h4 class="text-white">${birthdayList.getJSONObject(index).getString("fullName")}</h4>
						<p class="text-white">${birthdayList.getJSONObject(index).getString("designationName")}&nbsp;</p>
					</div>
			</div>

			</c:forEach>
		</div>
		<a class="carousel-control-prev" href="#carouselExampleControls" role="button" data-slide="prev"> <span class="carousel-control-prev-icon" aria-hidden="true"></span> <span
			class="sr-only">Previous</span>
		</a> <a class="carousel-control-next" href="#carouselExampleControls" role="button" data-slide="next"> <span class="carousel-control-next-icon" aria-hidden="true"></span> <span
			class="sr-only">Next</span>
		</a>
	</div>
	    <div class="text-right text-white">
        
         <a class="link" id="show-panel" data-toggle="modal" style="color:white;" data-target="#policy" onclick="addClass1()"><b><u>View All</font></u></b></a> 
            
            <!-- <button onclick = "createPopupWin('',
            'GeeksforGeeks Website', 1200, 650);">
        GeeksforGeeks
    </button> -->
            
            
    </div>
	<%
		} else {
	%>
	<div class="text-center">
		<i class="fa fa-user-circle fa-3x" style="color: white"></i>
		<h4 class="text-white"></h4>
		<p class="text-white">No birthday available for today!</p>
	</div>
	<%
		}
	%>
</div>

<div id="policy" class="modal fade" role="dialog" aria-hidden="true"
    style="display: none;">
    <div class="modal-dialog">

        <!-- Modal content-->
        <div class="modal-content">
            <div class="modal-header">
                
                <h4 class="modal-title">Birthday List</h4>
                <button type="button" class="btn btn-danger close" data-dismiss="modal" style="float:right;color:white;">X</button>
            </div>
            <div class="modal-body">
<table class="table table-striped">
  <thead>
    <tr>
    <th></th>
     <th scope="col">Name</th>
      <th scope="col">Designation</th>
     
    </tr>
  </thead>
  <tbody>
  <%
            if (birthdayList != null && birthdayList.length() > 0) {
        %>
  <c:forEach begin="0" end="${birthdayList.length() -1}" var="index">
    <tr>
       <td>
      <c:choose>
        <c:when
            test="${birthdayList.getJSONObject(index).getString('profileImage')!=''}">
            <div class='birthday-user-image'>
                <img
                    src='/documents/${birthdayList.getJSONObject(index).getString("profileImage")}'>     
            </div>
        </c:when>
        <c:otherwise>
            <div class='birthday-user-image'>
                <img src='<%=request.getContextPath()%>/images/blankUser.jpg' />     
            </div>
        </c:otherwise>
    </c:choose>
  
</td>
<td> ${birthdayList.getJSONObject(index).getString("fullName")}</td>
      <td>${birthdayList.getJSONObject(index).getString("designationName")}</td>
      
    </tr>
    
    </c:forEach>
    <%
            }
        %>
  </tbody>
</table>

            </div>

        </div>

    </div>
</div>

<script type="text/javascript">
/* $('#mybirthModal').on('click', function () {
    console.log("test");
   
        $('#myModal').modal('show');
        console.log("inside add class");
        console.log($('div#policy'));
        console.log($('#policy'));
        
        
        
}); */

$('#policy').on('hide.bs.modal', function () {
    console.log("remove");
   
    setTimeout( function(){ 
    	 $('div#policy').removeClass("d-flex justify-content-center");
  }  , 1000 );
    
});
    
function addClass1(){
    console.log("inside add class");
   
  $('div#policy').addClass("d-flex justify-content-center");
}
   
function removeClass(){
	   
}


    /*  function createPopupWin(pageURL, pageTitle,
                    popupWinWidth, popupWinHeight) {
            var left = (screen.width ) ;
            var top = (screen.height ) ;
            var myWindow = window.open(pageURL, pageTitle,
                    'resizable=yes, width=' + popupWinWidth
                    + ', height=' + popupWinHeight + ', top='
                    + top + ', left=' + left);
        } */
    </script>
