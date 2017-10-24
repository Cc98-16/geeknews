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
    
	$(document).on("click", "[name='submit']", function(e){
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
	});
});