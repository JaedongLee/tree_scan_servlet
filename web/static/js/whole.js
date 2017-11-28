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
    var Request = new Object();
    Request = getUrlParameter();
    var id = "id=" + Request["id"];
    $.ajax({
        type: "get",
        url: "../../http",
        data: id,
        datatype: "json",
        success: function (data) {
            var json = JSON.parse(data);
            addData(json)
        }
    })
}

function addData(data) {
    document.getElementById('picture').setAttribute('src', '../images/' + data.picture_url + '.jpg')
    document.getElementById('name').innerText = data.name
    document.getElementById('name').innerText = data.name
    document.getElementById('category').innerText = data.category
    document.getElementById('provider_class').innerText = data.provider_class
    document.getElementById('provider_name').innerText = data.provider_name
    document.getElementById('appearance').innerText = data.appearance
    document.getElementById('habit').innerText = data.habit
    document.getElementById('distribution').innerText = data.distribution
    document.getElementById('point').innerText = data.point
}