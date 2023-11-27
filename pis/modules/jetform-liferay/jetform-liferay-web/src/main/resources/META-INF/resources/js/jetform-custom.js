

$(document).ready(function () {
	
	$(document).ready(function() {
		var table= $('#dataTable').DataTable();
	});

    $('#leftToggle').click(function (e) {
        var left = $('#dataPanel');
        var pannel = 8;

        if ((left.hasClass('col-md-' + pannel))) {
        	   left.removeClass('col-md-' + (pannel)).addClass('col-md-' + (pannel + 2));
               $('#leftColumn').hide();
        
        }else {
        	 left.removeClass('col-md-' + (pannel + 2)).addClass('col-md-' + (pannel));
             $('#leftColumn').show(); 
        
        }
    });
    
    
    $('#RightToggle').click(function (e) {
        var left = $('#dataPanel');
        var pannel = 8;

        if ((left.hasClass('col-md-' + pannel))) {
        	   left.removeClass('col-md-' + (pannel)).addClass('col-md-' + (pannel + 2));
                    $('#rightColumn').hide();                 
        }else {
        	 left.removeClass('col-md-' + (pannel + 2)).addClass('col-md-' + (pannel));
                  $('#rightColumn').show();  
        }
    });
       
 
	function reloadListOptions(element, list, value, label, placeHolder){
		$(element).empty();
		if(placeHolder!=null && placeHolder!=''){
			$(element).append($('<option>', {value : '0'}).text(placeHolder));
		}
		$.each(list, function(i, e){
			$(element).append($('<option>', {value : e[value]}).text(e[label]));
		});		
	}

// Tooltips

	$(function () {
	  //$('[data-toggle="tooltip"]').tooltip()
	});
});

function readFileUrl(fileElement) {
	
	if(!$(fileElement) || !$(fileElement).prop('files') || $(fileElement).prop('files').length<1){
		return null;
	}

	var fileSelected = $(fileElement).prop('files')[0];

	if(fileSelected){	
		return fileSelected;
	}else{
		return null;
	}
}

function uploadFile(fileElement, uploadProgressBar, callback){
	
	var fileSelected=readFileUrl(fileElement);
	
	if(!fileSelected){
		return false;
	}

	var repositoryId = <%=repositoryId%>;
    var folderId = <%=folderId%>;
    var mimeType='';
    var description="Scanned file";
    var changeLog=description;
    
	if(uploadProgressBar){
		uploadProgressBar.startProgress();
	}
	
	addFileEntryWithFile(repositoryId, folderId, description, fileSelected, callback);
		//callback(fileElement, response);
	//});
	
	return fileSelected;
}

function addFileEntryWithFile(repositoryId, folderId, description, file, callback){
	var form = new FormData();
	form.append("file", file, file.name);
	form.append("repositoryId", repositoryId);
	form.append("folderId", folderId);
	form.append("sourceFileName", file.name);
	form.append("mimeType", file.type);
	form.append("title", file.name);
	form.append("description", description);
	form.append("changeLog", "Uploaded file");
	form.append("p_auth", Liferay.authToken);
	
	console.log(form);
	
	var settings = {
		"url": "/api/jsonws/dlapp/add-file-entry",
		"method": "POST",
		"timeout": 0,
		"headers": {},
		"processData": false,
		"mimeType": "multipart/form-data",
		"contentType": false,
		"data": form
	};
	
	$.ajax(settings).done(function (response) {
		console.log("addFileEntryWithFile");
		callback(JSON.parse(response));
	});
}

