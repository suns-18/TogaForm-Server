onload = () => {
  $('#headerUsername').text($util.getItem('user').username)
  $('#headerDivB').text('创建用户')

  $('#startTime').datetimepicker({
    language: 'zh-CN', // 显示中文
    format: 'yyyy-mm-dd hh:mm:ss', // 显示格式
    // minView: "month", // 设置只显示到月份
    minView: 0,  //0表示可以选择小时、分钟   1只可以选择小时
    minuteStep: 1,//分钟间隔1分钟
    initialDate: new Date(), // 初始化当前日期
    autoclose: true, // 选中自动关闭
    todayBtn: true // 显示今日按钮
  })
  $('#endTime').datetimepicker({
    language: 'zh-CN', // 显示中文
    format: 'yyyy-mm-dd hh:mm:ss', // 显示格式
    // minView: "month", // 设置只显示到月份
    minView: 0,  //0表示可以选择小时、分钟   1只可以选择小时
    minuteStep: 1,//分钟间隔1分钟
    initialDate: new Date(), // 初始化当前日期
    autoclose: true, // 选中自动关闭
    todayBtn: true // 显示今日按钮
  })

  let user = $util.getPageParam('user')
  // console.log('--- 用户信息 ---');
  // console.log(user);
  if (user) {
    $('#username').val(user.username)
    $('#password').val(user.password)
    $('#startDate').val(user.startTime)
    $('#endDate').val(user.endTime)
  }
}

const handleCreateUser = () => {

  if (!$('#username').val()) return alert('账号不能为空！')
  if (!$('#password').val()) return alert('密码不能为空！')
  if (!($('#startDate').val() && new Date($('#startDate').val()).getTime())) return alert('开始时间不能为空！')
  if (!($('#endDate').val() && new Date($('#endDate').val()).getTime())) return alert('结束时间不能为空！')

  let user = $util.getPageParam('user');

  if(!user) {
    user = {};
  }
 
  user.username = $('#username').val();
  user.password = $('#password').val();
  user.startTime = $('#startDate').val() && new Date($('#startDate').val()).getTime();
  user.stopTime = $('#endDate').val() && new Date($('#endDate').val()).getTime();

  // 修改
  if(user.id) {

    $.ajax({
      url: API_BASE_URL + '/api/user/updateUser',
      type: 'POST',
      data: JSON.stringify(user),
      dataType: 'json',
      contentType: 'application/json',
      success(res) {
        if (res.code === "1") {
          location.href = '/pages/user/index.html'
        } else {
          alert(res.message)
        }
      }
    })

  } else {
    // 新建
    $.ajax({
      url: API_BASE_URL + '/api/user/addUser',
      type: 'POST',
      data: JSON.stringify(user),
      dataType: 'json',
      contentType: 'application/json',
      success(res) {
        if (res.code === "1") {
          location.href = '/pages/user/index.html'
        } else {
          alert(res.message)
        }
      }
    })
  }
}
