<%@page import="com.adjecti.mdm.liferay.service.CourseLocalServiceUtil"%>
<%@page import="com.liferay.portal.kernel.service.CountryServiceUtil"%>
<%@page import="com.adjecti.jetform.annotation.HtmlFormWrapper"%>
<%@page import="com.liferay.portal.kernel.service.OrganizationLocalServiceUtil"%>
<%@page import="com.liferay.portal.kernel.util.ParamUtil"%>
<%@ include file="/init.jsp" %>

<div class="page-wrapper">
	<div class="content container-fluid">
		<liferay-util:include page="/components/form/form-add.jsp" servletContext="<%=application%>">
		</liferay-util:include>
	</div>
</div>

<%

String formId=(String)request.getAttribute("formId");
HtmlFormWrapper form=(HtmlFormWrapper)request.getAttribute(formId); 

System.out.println("formId:: "+formId);
%>


<aui:script>

let status=true;
let alrt="";



 
 


 function  beforeSubmit<portlet:namespace/><%=form.getId()%>(){
  var alrt="";
  
  
  
  const regExp =new RegExp(/^([A-Z]){3}$/);
  const regExp2 =new RegExp(/^([A-Z]){2}$/);
  
  var a3=$("#<portlet:namespace/>a3").val();
  var a2=$("#<portlet:namespace/>a2").val();
  var number=$("#<portlet:namespace/>number").val();
  var name=$("#<portlet:namespace/>name").val();
  
  if(regExp.test(a3)){
	} else {
alrt=alrt.concat("Long Code Allowed  With Three  Characters In Capital Latter  \n");
}
   
if(regExp2.test(a2)){
} else {
alrt=alrt.concat("Short Code Allowed With Two  Character In Capital Latter  ");

}


  var   fieldValue= [number, a3,name,a2];
  var   fieldName= ['number', 'a3', 'name', 'a2'];
  

if(!(alrt=="")){
alert(alrt);
alrt="";
}else{
CheckDataAvailableOrNot(fieldName,fieldValue);
}
  

  
  
  return false;
}
		
function saveCountry(name,a2,a3,number)
{
//alert('Inside Status True');
Liferay.Service(
'/country/add-country',
{
  name: name,
  a2: a2,
  a3: a3,
  number: number,
  idd: number,
  active: true
},
function(obj) {
//  alert(obj);
   <portlet:namespace/><%=form.getId()%>OnSaveSuccess(obj);
}
);
}

function CheckDataAvailableOrNot(fieldName,fieldValue){
  Liferay.Service(
  '/mdm.course/data-is-availble-or-not',
  {
    fieldName: fieldName[0],
    fieldValue:fieldValue[0]
  },
  function(obj) {
  if(obj==true){
  status=false;
 alrt= alrt.concat("Value Of Number Is Already Available.");
 alert(alrt);
 alrt="";
  }else{
 //alert(alrt+"inside else alrt"+fieldName[0]);
  Liferay.Service(
  '/mdm.course/data-is-availble-or-not',
  {
    fieldName: fieldName[1],
    fieldValue:fieldValue[1]
  },
  function(obj) {
  if(obj==true){
  status=false;
 alrt= alrt.concat("Value Of Long Code Is Already Available.\n");
 alert(alrt);
 alrt="";
  }else{
   //  alert(alrt+"inside else alrt");
     
     
      Liferay.Service(
  '/mdm.course/data-is-availble-or-not',
  {
    fieldName: fieldName[2],
    fieldValue:fieldValue[2]
  },
  function(obj) {
  if(obj==true){
  status=false;
 alrt= alrt.concat("Value Of Name Is Already Available.\n");
 alert(alrt);
 alrt="";
  }else{
  //alert(alrt);
 
    Liferay.Service(
  '/mdm.course/data-is-availble-or-not',
  {
    fieldName: fieldName[3],
    fieldValue:fieldValue[3]
  },
  function(obj) {
  if(obj==true){
  status=false;
 alrt= alrt.concat("Value Of Short Code Is Already Available In Database.\n");
 alert(alrt);
 alrt="";
  }else{
 //alert(alrt+"inside else alrt");
 if(alrt==""){
 saveCountry(fieldValue[2],fieldValue[3],fieldValue[1],fieldValue[0]);
 // alert('Save Successfully');
  }else{
  alert(alrt);
  alrt="";
  }
  }
   
  }
);
 
  }
   
  }
);
  }
   
  }
);
  }
   
  }
);
 alrt="";
 }
		
</aui:script> 

