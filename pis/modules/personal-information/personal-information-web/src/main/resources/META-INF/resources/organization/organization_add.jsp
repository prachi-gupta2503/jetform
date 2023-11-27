<%@page import="com.adjecti.jetform.annotation.HtmlFormWrapper"%>
<%@page import="com.liferay.portal.kernel.service.OrganizationLocalServiceUtil"%>
<%@page import="com.liferay.portal.kernel.util.ParamUtil"%>
<%@ include file="/init.jsp" %>

<div class="page-wrapper">
	<div class="content container-fluid">
		<liferay-util:include page="/components/form/form-add.jsp" servletContext="<%=application%>">
		<portlet:param name="sectionMVCPath" value="/mdm/section_master_list.jsp" />
		</liferay-util:include>
	</div>
</div>
<%

String formId=(String)request.getAttribute("formId");
HtmlFormWrapper form=(HtmlFormWrapper)request.getAttribute(formId); 

System.out.println("formId:: "+formId);
%>

<aui:script>
function  beforeSubmit<portlet:namespace/><%=form.getId()%>(){
   var alrt="";
  // alert("calling beforeSubmit<portlet:namespace/><%=form.getId()%>");
 /*  var code=$("#<portlet:namespace/>expando_code").val();
   var name=$("#<portlet:namespace/>name").val();
   var type=$("#<portlet:namespace/>type").val();
   var unitType=$("#<portlet:namespace/><%=form.getId()%>expando_unitType").val();
   var description=$("#<portlet:namespace/>expando_longName").val();
   var parentId=$("#<portlet:namespace/><%=formId%>parentOrganizationId").val();
    var organizationId=$("#<portlet:namespace/>organizationId").val();*/
    
   var code=$("#<portlet:namespace/>organizationCode").val();
   var name=$("#<portlet:namespace/>shortName").val();
   var type=$("#<portlet:namespace/>type").val();
   var unitType=$("#<portlet:namespace/><%=form.getId()%>unitType").val();
   var description=$("#<portlet:namespace/>longName").val();
   var parentId=$("#<portlet:namespace/><%=formId%>parentId").val();
   var organizationId=$("#<portlet:namespace/>organizationId").val();
   var comments=$("#<portlet:namespace/>comments").val();
   // console.log("parentId "+parentId+"  organizationId  "+organizationId);
    
  if(type=="Institute"){
      parentId=0;
      unitType='';
      <!--  organizationId=0;   -->
   }
   
  
   if(type=="Section"){
    unitType='';
   Liferay.Service(
  '/mdm.organizationdetail/get-by-organization-id',
  {
    organizationId: parentId
  },
  function(obj) {
  
  var data=obj.name.concat("-");
  if(((organizationId*1)>0) && ((data.localeCompare(name.concat("-"))==0)) && (obj.name.localeCompare(name)==0)){
   name=obj.name.concat("-", name);
   }else if((organizationId*1)>0 && !(data.localeCompare(name.concat("-").substr(0,data.length))==0)){
    name=obj.name.concat("-", name);
   }else if(organizationId==0){
     if(!(data.localeCompare(name.concat("-").substr(0,data.length))==0) || (obj.name.localeCompare(name)==0)){
         name=obj.name.concat("-", name);
      
     }else if(!(obj.name.localeCompare(name)==0) && !(data.localeCompare(name.concat("-").substr(0,data.length))==0)){
       name=obj.name.concat("-", name);
     }
   }
   checkSectionCodeisAvailabeleornot(organizationId,code,unitType,name,description,type,parentId,comments)
  }
);
    //checkSectionCodeisAvailabeleornot(organizationId,code,unitType,name,description,type,parentId,comments) 
    }else if(type=="Institute" || type=="Unit"){
      //alert(organizationId,code,unitType,name,description,type,parentId,comments);
  // saveOrganization(organizationId,code,unitType,name,description,type,parentId,comments);
  checkDataAvailableOrNot(organizationId,code,unitType,name,description,type,parentId,comments);
   }else if(type=="Division"){
      unitType='';
      if(parentId==0){
      alert("Organization is required");
      }else{
       checkDataAvailableOrNot(organizationId,code,unitType,name,description,type,parentId,comments);
      }
   }

   return false; 
}

		
function checkSectionCodeisAvailabeleornot(organizationId,code,unitType,name,description,type,parentId,comments){
	//	alert("parentId "+parentId+"  organizationcode  "+code+" Type "+type);
		
		Liferay.Service(
  '/mdm.organizationdetail/code-is-available-or-not-based-on-type-and-unit-and-organization-code',
  {
    type: type,
    parentId:parentId ,
    fieldName:"code",
    fieldValue:code,
    organizationId: organizationId
  },
  function(obj) {
   
  //  alert("CheckSectionCodeAndSectionNameisAvailabeleornot   "+obj);
    if(obj==false){
    
    Liferay.Service(
  '/mdm.organizationdetail/code-is-available-or-not-based-on-type-and-unit-and-organization-code',
  {
    type: type,
    parentId:parentId ,
    fieldName:"name",
    fieldValue:name,
    organizationId: organizationId
  },
  function(obj) {
   
  //  alert("CheckSectionCodeAndSectionNameisAvailabeleornot   "+obj);
    if(obj==false){
   saveOrganization(organizationId,code,unitType,name,description,type,parentId,comments);
    }else{
    alert("Short Name is already available");
    }

  }
);
    
    
   //saveOrganization(organizationId,code,unitType,name,description,type,parentId,comments);
    }else{
    alert("Code is already available");
    }

  }
);
		
	
}
		
		
function checkDataAvailableOrNot(organizationId,code,unitType,name,description,type,parentId,comments){
  Liferay.Service(
  '/mdm.organizationdetail/data-is-availble-or-not',
  {
    fieldName: 'code',
    fieldValue: code,
    type: type,
    organizationId:organizationId
  },
  function(obj) {
    console.log(obj);
      if(obj==true){
      alert("Code is already exist.");
      }else{
      
      
       Liferay.Service(
  '/mdm.organizationdetail/data-is-availble-or-not',
  {
    fieldName: 'name',
    fieldValue: name,
    type: type,
    organizationId:organizationId
  },
  function(obj) {
    console.log(obj);
      if(obj==true){
      alert("Name is already exist.");
      }else{
      
      
     saveOrganization(organizationId,code,unitType,name,description,type,parentId,comments);
      }
  }
);
      
      
      
     
      }
  }
);

 }
 
 function saveOrganization(organizationId,code,unitType,name,description,type,parentId,comments){
 
 
 			Liferay.Service(
				  '/mdm.organizationdetail/save-organization',
 				 {
				    organizationId: organizationId ,
				    code: code,
				    unitType:unitType,
				    name: name,
				    description: description,
				    type: type,
				    parentId: parentId,
				    comments: comments
					},
				  function(obj) {
					console.log(obj);
					//alert("obj1"+obj)
					if(obj=="ERR01"){
					    alert("A "+tyorganizationIdpe +" already exist with the code["+code+"]")
					}else if(obj=="ERR02"){
						alert("There is another "+type+" named " +name);
					}else{
					  alert("Successfully Saved");
				   		 <portlet:namespace/><%=form.getId()%>OnSaveSuccess(obj); 
				    }
				  
				  }
				  
);
 return false; 
 }
		
</aui:script> 