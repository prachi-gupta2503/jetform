<%@page import="com.liferay.portal.kernel.portlet.LiferayWindowState"%>
<%@page import="com.adjecti.jetform.annotation.HtmlElementWrapper"%>
<%@page import="com.liferay.portal.kernel.security.RandomUtil"%>

<%
HtmlElementWrapper htmlElement=(HtmlElementWrapper)pageContext.getAttribute("htmlElement");
%>
<div class="input-group mb-3">
	<label class="form-control" id="<portlet:namespace /><%=htmlElement.getName()+"_document"%>">
		<span id="<portlet:namespace /><%=htmlElement.getName()+"_fileName"%>" style="width:90%;">Browse a document</span>
		<a id="<portlet:namespace /><%=htmlElement.getName()+"_browseBtn"%>" style="float: right;"><i class="fa fa-folder-open"></i></a>
		<a id="<portlet:namespace /><%=htmlElement.getName()+"_clearBtn"%>" style="float: right; display:none;"><i class="fa fa-close"></i></a>
	</label>
	<input type="hidden" name="<portlet:namespace /><%=htmlElement.getName()%>" id="<portlet:namespace/><%=htmlElement.getName()%>">
	<%--<button type="button" class="btn btn-light btn-sm" id="<portlet:namespace /><%=htmlElement.getName()+"_browseBtn"%>" value="Browse"><i class="fa fa-folder-open"></i></button>
	<button type="button" class="btn btn-sm" id="<portlet:namespace /><%=htmlElement.getName()+"_clearBtn"%>" value="Clear" style="display:none;margin-left:-40px;"></button> --%>
</div>

<aui:script use="aui-base, liferay-preview, liferay-util-window">
	A.one('#<portlet:namespace /><%=htmlElement.getName()%>_fileName').on('click', function(event) {
		open_<portlet:namespace /><%=htmlElement.getName()%>_dialog();
	});
	
	A.one('#<portlet:namespace /><%=htmlElement.getName()%>_browseBtn').on('click', function(event) {
		open_<portlet:namespace /><%=htmlElement.getName()%>_dialog();
	});
	
	A.one('#<portlet:namespace /><%=htmlElement.getName()%>_clearBtn').on('click', function(event) {
		$('#<portlet:namespace/><%=htmlElement.getName()%>').val('');
		$('#<portlet:namespace/><%=htmlElement.getName()%>_fileName').html('Browse a document');
		$('#<portlet:namespace /><%=htmlElement.getName()+"_browseBtn"%>').css("display", "block");
		$('#<portlet:namespace /><%=htmlElement.getName()+"_clearBtn"%>').css("display", "none");
	});
	
	function open_<portlet:namespace /><%=htmlElement.getName()%>_dialog(){
		Liferay.Util.openWindow({ dialog: 
			{ 
				centered: true, 
				height: 640, 
				width: 1080,
				modal: true,
				destroyOnHide: true
			}, 
			id: '<portlet:namespace /><%=htmlElement.getName()%>_dialog',
			title: 'Document Browser', 
			uri: '<%=documentBrowserURL.toString()%>&<portlet:namespace />documentElement=<%=htmlElement.getName()%>' 
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
				$('#<portlet:namespace /><%=htmlElement.getName()+"_browseBtn"%>').css("display", "none");
			}
			var dialog = Liferay.Util.Window.getById('<portlet:namespace /><%=htmlElement.getName()%>_dialog');
			dialog.destroy();
		},
		['liferay-util-window']
	);					
</aui:script>