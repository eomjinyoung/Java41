if (window.appContext.getObject("projectjs") == undefined) {
	console.log("project.js 로딩...");
	var projectjs = {
		init: function(startPage) {
			var that = this;

			if (startPage) {
				$("#" + startPage).css("display", "");
			} else {
				$("#list").css("display", "");
			}
			
			$("#projectTable").on('click', '.projectTitleLink', function() {
				that.viewDetailProject($(this).attr("data-no"));
			});
			
			$("#btnList").click(function(event){
				$("#view").css("display", "none");
				$("#list").css("display", "");
			});
			
			$("#btnNewForm").click(function(event){
				$("#list").css("display", "none");
				$("#btnReset").trigger("click");
				$(".new-project").css("display", ""); // 등록버튼 보이기
				$(".view-project").css("display", "none"); // 수정버튼, 번호입력창 감추기
				$("#view").css("display", ""); // view 섹션 보이기
			});
			
			$("#btnAdd").click(function(){
				that.addProject();
			});
			
			$("#btnUpdate").click(function(){
				that.updateProject();
			});
			
			$("#btnDelete").click(function(){
				that.deleteProject();
			});
		},
		
		listProject: function() {
			$.getJSON("project/list.do", function(result) {
				if(result.status == "success") {
					var projects = result.data;
					$(".data-row").remove();
					var table = $("#projectTable");
					var rowno = 1;
					var tr = null;
					for (var i in projects) {
						tr = $(table).find("tr:eq(" + rowno + ")");
						tr.find("td:eq(0)").html(projects[i].no);
						tr.find("td:eq(1)").append(
							$("<a>")
								.addClass("projectTitleLink")
								.text(projects[i].title)
								.attr("href", "#")
								.attr("data-no", projects[i].no));
						tr.find("td:eq(2)").html(projects[i].startDate);
						tr.find("td:eq(3)").html(projects[i].endDate);
						rowno++;
					}
					$("#view").css("display", "none");
					$("#list").css("display", "");
				} else {
					alert("실행중 오류발생!");
					console.log(result.data);
				}
			});
		},
		
		updateProject: function() {
			var that = this;
			$.post("project/update.do", 
					{
						no: $("#no").val(),
						title: $("#title").val(),
						content: $("#pcontent").val(),
						startDate: $("#startDate").val(),
						endDate: $("#endDate").val(),
						tag: $("#tag").val()
					},
					function(result) {
						if(result.status == "success") {
							that.listProject();
							$("#view").trigger("projectChanged");
						} else {
							alert("실행중 오류발생!");
							console.log(result.data);
						}
					},
					"json");
		},
		
		addProject: function() {
			var that = this;
			$.post("project/add.do", 
					{
						title: $("#title").val(),
						content: $("#pcontent").val(),
						startDate: $("#startDate").val(),
						endDate: $("#endDate").val(),
						tag: $("#tag").val()
					},
					function(result) {
						if(result.status == "success") {
							that.listProject();
							$("#view").trigger("projectChanged");
						} else {
							alert("실행중 오류발생!");
							console.log(result.data);
						}
					},
					"json");
		},
		
		viewDetailProject: function (projectNo) {
			$.getJSON("project/view.do?no=" + projectNo, function(result) {
				if(result.status == "success") {
					var project = result.data;
					$("#no").val(project.no);
					$("#title").val(project.title);
					$("#pcontent").val(project.content);
					$("#startDate").val(project.startDate);
					$("#endDate").val(project.endDate);
					$("#tag").val(project.tag);
					$("#list").css("display", "none");
					$(".new-project").css("display", "none");
					$(".view-project").css("display", "");
					$("#view").css("display", "");
				} else {
					alert("실행중 오류발생!");
					console.log(result.data);
				}
			});
		},
		
		deleteProject: function() {
			var that = this;
			$.getJSON("project/delete.do?no=" + $("#no").val(), function(result) {
				if(result.status == "success") {
					that.listProject();
					$("#view").trigger("projectChanged");
				} else {
					alert("실행중 오류발생!");
					console.log(result.data);
				}
			});
		}
	};
	
	window.appContext.addObject("projectjs", projectjs);
}























