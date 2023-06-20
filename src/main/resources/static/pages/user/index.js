onload = () => {
    $('#headerUsername').text($util.getItem('user').username)
    $('#headerDivB').text('用户管理')
    fetchUserList()
}

let pageNum = 1
let userList = []

const fetchUserList = () => {
    let params = {
        pageNum,
        pageSize: 10,
        username: $('#username').val()
    }
    $.ajax({
        url: API_BASE_URL + '/api/user/queryList',
        type: 'POST',
        data: JSON.stringify(params),
        dataType: 'json',
        contentType: 'application/json',
        success(res) {
            $('#table #tbody').html('')
            userList = res.data
            res.data.map((item, index) => {
                $('#table #tbody').append(`
          <tr>
            <td>${index + 1}</td>
            <td>${item.username}</td>
            <td>${item.password}</td>
            <td>${localTime(item.startTime)}</td>
            <td>${localTime(item.stopTime)}</td>
            <td>
              <button type="button" class="btn btn-link">重置密码</button>
              <button type="button" class="btn btn-link" onclick="handleEdit('${item.id}')">编辑</button>
              <button type="button" class="btn btn-link btn-red" >关闭</button>
              <button type="button" class="btn btn-link btn-red" onclick="deleteUser('${item.id}')">删除</button>
            </td>
          </tr>
        `)
            })
        }
    })
}
const deleteUser = (id) => {
    let params = {
        id: id
    }
    $.ajax({
        url: API_BASE_URL + '/api/user/delete',
        type: 'POST',
        data: JSON.stringify(params),
        dataType: 'json',
        contentType: 'application/json',
        success(res) {
            alert(res.message)
            if (res.code === 1)
                fetchUserList()
        }
    })
}
const handleTableChange = (page) => {
    if (page === 1) {
        if (pageNum === 1) return
        pageNum--
    } else if (page === 2) {
        pageNum++
    } else if (page === 3) {
        pageNum = +$('#goNum').val()
    }
    $('#currentPage').text(pageNum)
    fetchUserList()
}

const handleCreateUser = () => {
    $util.setPageParam('user', undefined)
    location.href = '/pages/createUser/index.html'
}


const handleEdit = (id) => {
    let user = userList.filter(item => item.id === id)[0]
    $util.setPageParam('user', user)
    location.href = '/pages/createUser/index.html'
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

