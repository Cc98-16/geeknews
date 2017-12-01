$(function() {
	
	/** 全局链接抛出消息 **/
    $(document).on("click", "a", function(event) {
	   	event.preventDefault();
	   	var url = $(this).attr("href");
	   	$.get(url, function(json) {
	   		if(typeof(json) == "string") {
	   			window.location.href=url;
	   		} else if(typeof(json) == "object") {
	   			$.each(json, function(code, message) {
	   				var name = "[data-error='"+code+"']";
					 if ($(name).length > 0) {
                        $(name).html(message);
                    }
	            });
	   		}
	   	})
    })
    
/*	$(document).on("click", "[name='submit']", function(e){
		var form = $(this).parents("form");
		var url = $(form).attr("action");
		var data = $(form).serialize()
		$("[data-error]").html(""); 
		$.post(url, data, function(json) {
			var result = 1;
			if (json.code == 412){
        		$.each(json, function(code, message) {
    				if (code != "tourl") {
    					result = 2;
    					var name = "[data-error='"+code+"']";
    					 if ($(name).length > 0) {
	                         $(name).html(message);
	                     }
    				}
    			});
			}else if (result == 1 && json.tourl != ""){
				window.location.href = json.tourl;
			}
		}, "json");
	});*/
    
    $(document).on("click","[name='submit']",function(e){
    	var form = $(this).parents("form");
    	var url = $(form).attr("action");
    	var data = $(form).serialize();
    	$("[data-error]").html("");
    	$.post(url,data,function(json){
    		console.log(123);
    		var result = 1;
    		if(typeof(json.tourl) == "undefined" || json.tourl == ""){
    			$.each(json,function(code,msg){
    				if(code != "tourl"){
    					result = 2;
    					var name = "[data-error='"+code+"']";
    					if($(name).length > 0){
    						$(name).html(msg);
    					};
    				};
    			});
    		}else if (result == 1 && json.tourl != ""){
    			window.location.href = json.tourl;
    		};
    	},"json");
    });
});

$(document).on("click","[data-replyload]",function(e){
	
})

	 
$(document).ready(function(){
$(".flip").click(function(){
$(".start").toggle(500);
});
});
$(".changeleft").click( function () { $(".person-left").hide(250); $(".all-theme").show(250); });

$(".returnleft").click( function () { $(".all-theme").hide(250); $(".person-left").show(250); });
$(".to_pub").click( function () { $(".intc-them").show(); $(".in-mb").show(); });
$(".in-mb").click( function () { $(".intc-them").hide(); $(".in-mb").hide(); });

if ('.intc-them') {
	  $('.in-mb').hide();
	} else {
	  $('.in-mb').show();
	} 