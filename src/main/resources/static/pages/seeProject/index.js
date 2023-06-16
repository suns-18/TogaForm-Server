onload = () => {
  $('#headerDivB').text('项目详情')

  let projectId = $util.getPageParam('seeProject')
  console.log(projectId)
  fetchProjectInfo(projectId)
}

const fetchProjectInfo = (id) => {
  let params = {
    id
  }
  $.ajax({
    url: API_BASE_URL + '/api/project/queryList',
    type: "POST",
    data: JSON.stringify(params),
    dataType: "json",
    contentType: "application/json",
    success(res) {
      let info = res.data[0]
      $('#projectName').text(info.projectName)
      $('#createTime').text(localTime(info.creationDate))
      $('#projectDescription').text(info.projectContent)
    }
  })
}

const localTime = (source) => {
  if (source === null) {
    return ''
  } else {
    const date = new Date(source)
    const y = date.getFullYear()
    let m = date.getMonth() + 1
    m = m < 10 ? `0${String(m)}` : m
    let d = date.getDate()
    d = d < 10 ? `0${String(d)}` : d
    let h = date.getHours()
    h = h < 10 ? `0${String(h)}` : h
    let minute = date.getMinutes()
    minute = minute < 10 ? `0${String(minute)}` : minute
    let second = date.getSeconds()
    second = second < 10 ? `0${String(second)}` : second
    return `${String(y)}-${String(m)}-${String(d)}   ${String(h)}:${String(
        minute
    )}:${String(second)}`
  }
}