<%@page import="com.liferay.portal.kernel.portlet.LiferayWindowState"%>
<%@page import="com.liferay.portal.kernel.security.RandomUtil"%>
<%@page import="com.adjecti.jetform.annotation.HtmlElementWrapper"%>

<%
HtmlElementWrapper htmlElement=(HtmlElementWrapper)pageContext.getAttribute("htmlElement");
%>

<div class="input-group mb-3">
	<label class="form-control" id="<portlet:namespace /><%=htmlElement.getName()+"_document"%>">
		<span id="<portlet:namespace /><%=htmlElement.getName()+"_fileName"%>">Upload or browse or scan a document</span>
		<a id="<portlet:namespace /><%=htmlElement.getName()+"_addBtn"%>" style="float: right;"><i class="fa fa-th-large"></i></a>
		<a id="<portlet:namespace /><%=htmlElement.getName()+"_clearBtn"%>" style="float: right; display:none;"><i class="fa fa-close"></i></a>
	</label>
		
	<input type="hidden" name="<portlet:namespace /><%=htmlElement.getName()%>" id="<portlet:namespace/><%=htmlElement.getName()%>">
</div>
<aui:script use="aui-base, liferay-preview, liferay-util-window">
	A.one('#<portlet:namespace /><%=htmlElement.getName()%>_addBtn').on('click', function(event) {
		open_<portlet:namespace /><%=htmlElement.getName()%>_dialog();
	});
	
	A.one('#<portlet:namespace /><%=htmlElement.getName()%>_fileName').on('click', function(event) {
		open_<portlet:namespace /><%=htmlElement.getName()%>_dialog();
	});

	A.one('#<portlet:namespace /><%=htmlElement.getName()%>_clearBtn').on('click', function(event) {
		$('#<portlet:namespace/><%=htmlElement.getName()%>').val('');
		$('#<portlet:namespace/><%=htmlElement.getName()%>_fileName').html('Upload or browse or scan a document');
		$('#<portlet:namespace /><%=htmlElement.getName()+"_addBtn"%>').css("display", "block");
		$('#<portlet:namespace /><%=htmlElement.getName()+"_clearBtn"%>').css("display", "none");
	});
	
	function open_<portlet:namespace /><%=htmlElement.getName()%>_dialog(){
		Liferay.Util.openWindow({ dialog: 
			{ 
				centered: true, 
				height: 720, 
				width: 1080,
				modal: true,
				destroyOnHide: true
			}, 
			id: '<portlet:namespace /><%=htmlElement.getName()%>_dialog',
			title: 'Add Document', 
			uri: '<%=documentAdderURL.toString()%>&<portlet:namespace />documentElement=<%=htmlElement.getName()%>' 
		});
	}
	
	Liferay.provide(
		window,
		'<portlet:namespace /><%=htmlElement.getName()%>_closeDialog',
		function(data) {
			if(data){
				console.log(data);
				
				$('#<portlet:namespace/><%=htmlElement.getName()%>').val(data.fileEntryId);
				$('#<portlet:namespace/><%=htmlElement.getName()%>_fileName').html(data.fileName);
				$('#<portlet:namespace /><%=htmlElement.getName()+"_clearBtn"%>').css("display", "block");
				$('#<portlet:namespace /><%=htmlElement.getName()+"_addBtn"%>').css("display", "none");
			}
			var dialog = Liferay.Util.Window.getById('<portlet:namespace /><%=htmlElement.getName()%>_dialog');
			dialog.destroy();
		},
		['liferay-util-window']
	);
					
</aui:script>
