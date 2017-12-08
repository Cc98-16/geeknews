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
	var replyid = $("#ns_pl").attr("replyid");
	var replytype = $("#ns_pl").attr("replytype");
	var commentid = $("#ns_pl").attr("replyid")
	var newsid = $("#ns_pl").attr("newsid")
	var url = $(this).data("replyload");
	$(this).parents("li").find("[name=replyloadbox]").load(url, function(){
		$(this).show("fast");
		$(this).find("[name=newsid]").val(newsid);
		$(this).find("[name=replyid]").val(replyid);
		$(this).find("[name=replytype]").val(replytype);
		$(this).find("[name=commentid]").val(replyid);
	});
})

$(document).on("click","[name='replyone']",function(e){
	var touser = $(this).parents("[name=warp]").attr("touser");
	var commentid = $(this).parents("[name=warp]").attr("commentid");
	var replyid = $(this).parents("[name=warp]").attr("replyid");
	var replytype = $(this).parents("[name=warp]").attr("replytype");
	var tuname = $(this).parents("[name=warp]").attr("tuname");
	$(this).parents("[name=onediv]").nextAll("form").find("[name=touser]").val(touser);
	$(this).parents("[name=onediv]").nextAll("form").find("[name=commentid]").val(commentid);
	$(this).parents("[name=onediv]").nextAll("form").find("[name=replyid]").val(replyid);
	$(this).parents("[name=onediv]").nextAll("form").find("[name=replytype]").val(replytype);
	$(this).parents("[name=onediv]").nextAll("form").find("[name=content]").attr("placeholder", "回复 "+tuname+" :");
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