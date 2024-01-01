// 获取第一个用户名输入框元素
var elUsername = document.getElementsByName("username")[0];

// 获取第一个 feedback 元素
var elMsg = document.getElementsByName("feedback")[0];

function checkusername(username) {
    if (username === null || username === "") {
        elMsg.textContent = "用户名不能为空";
        return;
    } else if (username.length <= 3) {
        elMsg.textContent = "用户名长度必须大于3";
        return;
    }

    elMsg.textContent = "";
}

// 添加事件监听器
elUsername.addEventListener('blur', function () {
    var username = elUsername.value.trim();
    checkusername(username);
});
