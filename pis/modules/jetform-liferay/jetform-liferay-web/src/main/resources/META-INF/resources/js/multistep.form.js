$(document).ready(function() {
	var current_fs, next_fs, previous_fs; //fieldsets
	var opacity;

	$(".next").click(function() {
		
		var curIndex=parseInt($(this).attr("index"));
		var nextIndex=curIndex+1;
		//current_fs = $(this).parent();
		current_fs = $("#form"+curIndex);
		//next_fs = $(this).parent().next();
		next_fs = $("#form"+nextIndex);

		//Add Class Active
		$("#progressbar li").eq($("fieldset").index(next_fs)).addClass("active");

		//show the next fieldset
		next_fs.show();
		//hide the current fieldset with style
		current_fs.animate({ opacity: 0 }, {
			step: function(now) {
				// for making fielset appear animation
				opacity = 1 - now;

				current_fs.css({
					'display': 'none',
					'position': 'relative'
				});
				next_fs.css({ 'opacity': opacity });
			},
			duration: 600
		});
	});

	$(".previous").click(function() {
		
		var curIndex=parseInt($(this).attr("index"));
		var prevIndex=curIndex-1;
		
		//current_fs = $(this).parent();
		//previous_fs = $(this).parent().prev();
		
		current_fs = $("#form"+curIndex);
		previous_fs = $("#form"+prevIndex);

		//Remove class active
		$("#progressbar li").eq($("fieldset").index(current_fs)).removeClass("active");

		//show the previous fieldset
		previous_fs.show();

		//hide the current fieldset with style
		current_fs.animate({ opacity: 0 }, {
			step: function(now) {
				// for making fielset appear animation
				opacity = 1 - now;

				current_fs.css({
					'display': 'none',
					'position': 'relative'
				});
				previous_fs.css({ 'opacity': opacity });
			},
			duration: 600
		});
	});

	$('.radio-group .radio').click(function() {
		$(this).parent().find('.radio').removeClass('selected');
		$(this).addClass('selected');
	});

	$(".submit").click(function() {
		return false;
	})

});