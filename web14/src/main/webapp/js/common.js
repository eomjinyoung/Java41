//var bitacademy = new Object();
function bitacademy(value) {
	if (value.charAt(0) == "#") { // #태그아이디
		return document.getElementById(value.substr(1));
		
	} else if (value.charAt(0) == "<"){ // <태그명>
		var tag = value.substr(1, (value.length - 2));
		return document.createElement(tag);
	}
}

bitacademy.createRequest = function() {
    try {
        return new XMLHttpRequest();
    } catch (exception) {
        var versions = [
            'Msxml2.XMLHTTP.6.0',
            'Msxml2.XMLHTTP.5.0',
            'Msxml2.XMLHTTP.4.0',
            'Msxml2.XMLHTTP.3.0',
            'Msxml2.XMLHTTP',
            'Microsoft.XMLHttp'
        ];
        for (var i = 0; i < versions.length; i++) {
            try {
                return new ActiveXObject(versions[i]);
            } catch (e) { }
        }
    }
};

bitacademy.ajax = function(url, settings) {
	var xhr = bitacademy.createRequest();
	xhr.onreadystatechange = function() {
		if (xhr.readyState === 4) {
			if (xhr.status === 200) {
				var result = JSON.parse(xhr.responseText);
				if (settings.success) {
					settings.success(result);
				}
			} else {
				if (settings.error) {
					settings.error("서버 요청 오류!");
				}
			}
		}
	};
	
	var type = "GET";
	if (settings.type) {
		type = settings.type;
	}
	
	xhr.open(type, url, true);
	
	if (type == "GET") {
		xhr.send();
	} else {
		xhr.setRequestHeader("Content-Type", "application/x-www-form-urlencoded"); 
		var params = null;
		if (settings.data) {
			params = "";
			for(var name in settings.data) {
				if (params != "") {
					params += "&";
				}
				params += name + "=" + settings.data[name];
			}
		}
		xhr.send(params); 
	}
};

var $ = bitacademy;


























