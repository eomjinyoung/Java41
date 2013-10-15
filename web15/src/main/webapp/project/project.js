$(function() {
	listProject();
	
	$("#projectTable").on('click', '.projectTitleLink', function() {
		viewDetailProject($(this).attr("data-no"));
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
		addProject();
	});
	
	$("#btnUpdate").click(function(){
		updateProject();
	});
	
	$("#btnDelete").click(function(){
		deleteProject();
	});
});

function listProject() {
	$.getJSON("project/list.do", function(result) {
		if(result.status == "success") {
			var projects = result.data;
			$(".data-row").remove();
			var table = $("#projectTable");
			for (var i in projects) {
				$("<tr>")
					.addClass("data-row")
					.append($("<td>").text( projects[i].no ))
					.append($("<td>").append(
								$("<a>")
									.addClass("projectTitleLink")
									.text(projects[i].title)
									.attr("href", "#")
									.attr("data-no", projects[i].no)))
					.append($("<td>").text( projects[i].startDate ))
					.append($("<td>").text( projects[i].endDate ))
					.appendTo(table);
			}
		} else {
			alert("실행중 오류발생!");
			console.log(result.data);
		}
	});
}

function updateProject() {
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
				listProject();
				$("#view").css("display", "none");
				$("#list").css("display", "");
				$("#view").trigger("projectChanged");
			} else {
				alert("실행중 오류발생!");
				console.log(result.data);
			}
		},
		"json"
	);
}

function addProject() {
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
				listProject();
				$("#view").css("display", "none");
				$("#list").css("display", "");
				$("#view").trigger("projectChanged");
			} else {
				alert("실행중 오류발생!");
				console.log(result.data);
			}
		},
		"json"
	);
}

function viewDetailProject(projectNo) {
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
}

function deleteProject() {
	$.getJSON("project/delete.do?no=" + $("#no").val(), function(result) {
		if(result.status == "success") {
			listProject();
			$("#view").css("display", "none");
			$("#list").css("display", "");
			$("#view").trigger("projectChanged");
		} else {
			alert("실행중 오류발생!");
			console.log(result.data);
		}
	});
}
























