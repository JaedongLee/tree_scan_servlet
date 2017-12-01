function addLoadEvent(func) {
    var oldonload = window.onload;
    if(typeof(window.onload) != 'function') {
        window.onload = func;
    }else {
        window.onload = function() {
            oldonload();
            func();
        };
    }
}

addLoadEvent(requestSingleData);

function getUrlParameter() {
    //var para = parseInt(window.location.search.substr(3));
    var url = location.search;
    var theRequest = new Object();
    if(url.indexOf("?") != -1) {
        var str = url.substr(1);
        strs = str.split("&");
        for(i=0;i<strs.length;i++) {
            theRequest[strs[i].split("=")[0]]=decodeURI(strs[i].split("=")[1]);
        }
        return theRequest;
    }
}

function requestSingleData() {
    // Request = getUrlParameter();
    // var id = "id=" + Request["id"];
    // var agent = Request["agent"];
    var url = location.search
    var para = url.substr(1)
    $.ajax({
        type: "get",
        url: "../../http",
        data: para,
        datatype: "json",
        success: function (data) {
            var json = JSON.parse(data);
            addData(json)
        },
        error: function (XMLHttpRequest, textStatus, errorThrown) {
            console.log(XMLHttpRequest.status);
            console.log(XMLHttpRequest.readyState);
            console.log(textStatus);
        },
        complete: function(XMLHttpRequest, textStatus) {
            console.log(textStatus); // 调用本次AJAX请求时传递的options参数
        }
    })
}

function addData(data) {
    if (data.status == "error") {
        document.getElementsByTagName("body")[0].removeChild(document.getElementById("prepare_remove"))
        window.location.assign("../../resource/tree_appreciate.apk")
    }
    else {
        document.getElementById('picture').setAttribute('src', '../images/' + data.id + '.jpg')
        document.getElementById('name').innerText = data.name
        document.getElementById('alias').innerText = data.alias
        document.getElementById('latin_name').innerText = data.latin_name
        document.getElementById('category').innerText = data.category
        document.getElementById('appearance').innerText = data.appearance
        document.getElementById('habit').innerText = data.habit
        document.getElementById('distribution').innerText = data.distribution
        document.getElementById('point').innerText = data.point
        document.getElementById('temperature').innerText = data.temperature
        document.getElementById('humidity').innerText = data.humidity
        document.getElementById('water').innerText = data.water
        document.getElementById('manure').innerText = data.manure
        document.getElementById('group').innerText = data.group
        document.getElementById('provider_class').innerText = data.provider_class
        document.getElementById('provider_name').innerText = data.provider_name
        document.getElementById('time').innerText = data.time
    }
}