$(document).ready(function(){
			$(".sidebar-btn").click(function(){
				$(".wrapper").toggleClass("toggled");
				
			});
		
			$("#dropdown1").click(function(){
				$(".wrapper .sidebar .item #btn1").toggleClass("show");
			});
			$("#dropdown2").click(function(){
				$(".wrapper .sidebar .item #btn2").toggleClass("show1");
			});
			$("#dropdown3").click(function(){
				$(".wrapper .sidebar .item #btn3").toggleClass("show2");
			});
			$("#dropdown4").click(function(){
				$(".wrapper .sidebar .item #btn4").toggleClass("show3");
			});
		});