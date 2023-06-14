onload = () => {
	$('#headerUsername').text($util.getItem('user').username)
	$('#headerDivB').text('创建项目')
}

const handleCreateProject = () => {
	let params = {
		createdBy: $util.getItem('user').id,
		lastUpdatedBy: $util.getItem('user').id,
		creationDate: new Date(),
		projectName: $('#projectName').val(),
		projectContent: $('#projectDescribe').val()
	}
	if (!params.projectName) return alert('项目名称不能为空！')
	if (!params.projectContent) return alert('项目描述不能为空！')
	$.ajax({
		url: API_BASE_URL + '/api/project/addProject',
		type: "POST",
		data: JSON.stringify(params),
		dataType: "json",
		contentType: "application/json",
		success(res) {
			alert(res.message)
			if (res.code === "1")
				location.href = "/pages/questionnaire/index.html"
		}
	})
}
