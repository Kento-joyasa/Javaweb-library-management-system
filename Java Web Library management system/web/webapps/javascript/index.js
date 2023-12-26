"use strict";
	
let buttons = $(".sidebar ul li");
let windows = $(".win-ul li");

const LEN = buttons.length;

// 切换界面选项卡
buttons.each(function(index, button){
	$(button).click(function(){
		
		buttons.each(function(index2, item) {
			$(item).css({
				backgroundColor:"#202423",
				boxShadow:"none"
			});
			
			$(windows[index2]).css({display:"none"});
		})
		
		$(this).css({
			backgroundColor:"#4c7bd2",
			boxShadow:"0px 0px 6px black inset"
		});
		$(windows[index]).css({display:"block"});
	})
})

// 添加按钮点击显示添加界面
let addButtons = $(".add-button");
let addWindwos = $(".table-add-back");
let awcbs = $(".table-add-back .close-but");

addButtons.each(function(index, button){
	$(button).click(function(){
		$(addWindwos[index]).css({display:"block"})
	})

	// 关闭添加界面
	$(awcbs).click(function(){
		$(addWindwos[index]).css({display:"none"})
		// 将其中所有的文本标签内容清空
		$(".table-add-back  .text-flag").each(function (index, item) {
			item.value = "";
		})
	})
})




