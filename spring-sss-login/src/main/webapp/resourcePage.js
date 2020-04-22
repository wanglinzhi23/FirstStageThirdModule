var lineClass = ["odd_line", "even_line"];

window.onload = function () {
    // 渲染页面
    refreshPage();
}

/**
 * 添加资源
 */
function onAddResource() {
    $("resourceBox").style.display = "block";
    $("resourceBoxTitle").innerText = "添 加 资 源";
    $("idHidden").value = "";
    $("nameInput").value = "";
    $("addressInput").value = "";
    $("phoneInput").value = "";
    currentMode = "add";
}

/**
 * 取消添加资源
 */
function doCancelResource() {
    $("resourceBox").style.display = "none";
}

var currentMode;

/**
 * 发送添加请求，请求完成后，刷新页面
 */
function doConfirmResource() {
    // 获取resume对象
    var resume = getResume();
    var url;
    if (currentMode === "add") {
        url = "/resume/add";
    } else {
        url = "/resume/update";
    }
    ajax({
        "url": url,
        "data": resume,
        "type": "post",
        "dataType": "json",
        success: function (text) {
            var result = JSON.parse(text);
            // 校验结果
            if (checkResult(result)) {
                // 刷新页面
                refreshPage();
            }
        },
        fail: function (status) {
            alert("操作人员失败: " + status);
        }
    });
}

function getResume() {
    var resume = {};
    resume["id"] = $("idHidden").value;
    resume["username"] = $("nameInput").value;
    resume["address"] = $("addressInput").value;
    resume["phoneNo"] = $("phoneInput").value;
    return resume;
}

/**
 * 修改资源
 */
function modifyResource(id) {
    currentMode = "modify";
    $("resourceBox").style.display = "block";
    $("resourceBoxTitle").innerText = "修 改 资 源";
    $("idHidden").value = id;
    $("nameInput").value = globalResources[id]["username"];
    $("addressInput").value = globalResources[id]["address"];
    $("phoneInput").value = globalResources[id]["phoneNo"];
}

/**
 * 删除资源
 */
function deleteResource(id) {
    var request = {"id": id};
    ajax({
        "url": "/resume/delete/",
        "type": "post",
        data: request,
        success: function (text) {
            var result = JSON.parse(text);
            // 校验结果
            if (checkResult(result)) {
                // 刷新页面
                refreshPage();
            }
        },
        fail: function (status) {
            alert("删除人员失败: " + status);
        }
    });
}


/**
 * 刷新页面
 */
function refreshPage() {
    $("resourceBox").style.display = "none";
    ajax({
        "url": "/resume/list",
        "type": "get",
        success: function (text) {
            var result = JSON.parse(text);
            checkResult(result);
            // 渲染资源
            printResources(result["data"]);
        },
        fail: function (status) {
            alert("获取资源失败：" + status);
        }
    });
}

function checkResult(result) {
    if (!result["success"]) {
        alert(result["msg"]);
        if (result["code"] === "SSS-SYS-002") {
            window.open("index.html", "_self")
        }
    }
    return result["success"];
}

var globalResources = {};

function printResources(resources) {
    var resourceBody = $("resourceBody");
    var printContent = "";
    if (resources == null) {
        printContent = "";
    } else {
        for (var i = 0; i < resources.length; i++) {
            var resource = resources[i];
            globalResources[resource["id"]] = resource;
            printContent += "<tr class='" + lineClass[i % 2] + "'>";
            printContent += "<td>" + resource["username"] + "</td>";
            printContent += "<td>" + resource["address"] + "</td>";
            printContent += "<td>" + resource["phoneNo"] + "</td>";
            printContent += "<td><a href='javascript:;' onclick='modifyResource(" + resource["id"] + ")'>修改</a>";
            printContent += "｜<a href='javascript:;' onclick='deleteResource(" + resource["id"] + ")'>删除</a></td>";
            printContent += "</tr>";
        }
    }
    resourceBody.innerHTML = printContent;
}


/**
 * 登出
 */
function doLogout() {
    ajax({
        "url": "logout",
        "type": "post",
        success: function (text) {
            var data = JSON.parse(text);
            if (checkResult(data)) {
                // 请求登出，成功后返回登录页
                window.open("index.html", "_self");
            }
        }
    });
}