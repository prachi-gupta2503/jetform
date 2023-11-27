

$(document).ready(function () {
	
	//var table= $('#dataTable').DataTable();

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
	

	//This is for enabling select2 plugin for select/dropdown controls
	$(".select2-control").select({
				placeholder: {
		    id: '-1', // the value of the option
		    text: 'Select an option'
		  },
				allowClear: true
	});

	//$.fn.select2.defaults.reset();
	$('.select2-control').val(null).trigger('change');

	// Add the following code if you want the name of the file appear on select
	$(".custom-file-input").on("change", function() {
	  var fileName = $(this).val().split("\\").pop();
	  $(this).siblings(".custom-file-label").html(fileName);
	  //$(this).siblings(".custom-file-label").addClass("selected").html(fileName);
	});

	Handlebars.registerHelper('if_eq', function(a, b, opts) {
	    if(a === b) // Or === depending on your needs
	        return opts.fn(this);
	    else
	        return opts.inverse(this);
	});

	Handlebars.registerHelper('if_ne', function(a, b, opts) {
	    if(a === b) // Or === depending on your needs
	    	return opts.inverse(this);
	    else
	    	return opts.fn(this);
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

function uploadFile(repositoryId, folderId, fileElement, uploadProgressBar, callback){
	
	var fileSelected=readFileUrl(fileElement);
	
	if(!fileSelected){
		return false;
	}

    var mimeType='';
    var description=fileSelected.name;
    var changeLog=description+" uploaded on "+(new Date());
    try{
		if(uploadProgressBar){
			uploadProgressBar.startProgress();
		}
    }catch(e){}
	addFileEntryWithFile(repositoryId, folderId, description, fileSelected, callback);
		//callback(fileElement, response);
	//});
	
	return fileSelected;
}

function addFileEntryWithFile(repositoryId, folderId, description, file, callback){
	var title=file.name;
	var extn=title.substring(title.lastIndexOf("."));
	title=title.substring(0,title.lastIndexOf(".")-1);
	title=title+"-"+(new Date()).getTime();
	title=title+extn;
	
	var form = new FormData();
	form.append("file", file, file.name);
	form.append("repositoryId", repositoryId);
	form.append("folderId", folderId);
	form.append("sourceFileName", file.name);
	form.append("mimeType", file.type);
	form.append("title", title);
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

(function ($) {
    $.fn.serializeFormJSON = function () {

        var o = {};
        var a = this.serializeArray();
        $.each(a, function () {
            if (o[this.name]) {
                if (!o[this.name].push) {
                    o[this.name] = [o[this.name]];
                }
                o[this.name].push(this.value || '');
            } else {
                o[this.name] = this.value || '';
            }
        });
        return o;
    };
})(jQuery);

function reloadListOptions(element, list, key, label, placeHolder, value){
	$(element).empty();
	if(placeHolder!=null && placeHolder!=''){
		$(element).append($('<option>', {value : '0'}).text(placeHolder));
	}
	$.each(list, function(i, e){
		$(element).append($('<option>', {value : e[key]}).text(e[label]));
	});
	if(value!=null & value!=''){	
		$(element).val(value);
	}
}


