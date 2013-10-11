function createRequest() {
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
}

function ajax(url, settings) {
	var xhr = createRequest();
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
}




























