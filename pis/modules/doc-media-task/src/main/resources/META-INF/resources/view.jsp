<%@ include file="/init.jsp" %>



<table class="table table-sm">
  <thead>
    <tr>
      <th scope="col">Orgnization Name</th>
      <th scope="col">Document Type</th>
      <th scope="col">Document Name</th>
      <th scope="col">Date</th>
      <th scope="col">Time</th>
      <th scope="col">Details</th>
      <th scope="col">Action</th>
      
    </tr>
  </thead>
  <tbody>
 <c:set var="files" value='${requestScope["files"]}' />
  <c:forEach var="file" items="${files}">
    <tr>
      <td>${file.getOrganizationName()}</td>
      <td>${file.getDocumentType()}</td>
      <td>${file.getDocumentName()}</td>
      <td>${file.getLastUpdatedDate()}</td>
	  <td>${file.getLastUpdatedTime()}</td>
      <td>
		
			<c:forEach var="metaData" items="${file.getMetadata().entrySet()}">
			<c:if test="${not empty metaData.getValue()}">
  				<b>${metaData.getKey()} - </b>${metaData.getValue()}<br>
  			</c:if>
			</c:forEach>	
		
	  </td>

	  <td><a href="${file.getDocumentUrl()}">Download</a></td>
    </tr>
    </c:forEach>
   </tbody>
</table>

