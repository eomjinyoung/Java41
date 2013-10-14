//var bitacademy = new Object();
function bitacademy(value) {
	var extElement;
	if (value instanceof Element) {
		extElement = value;
		
	} else if (value.charAt(0) == "#") { // #태그아이디
		extElement = document.getElementById(value.substr(1));
		
	} else if (value.charAt(0) == "<"){ // <태그명>
		var tag = value.substr(1, (value.length - 2));
		extElement = document.createElement(tag);
		
	} else {
		extElement = document.querySelectorAll(value);
	}
	
	extElement.load = function(url) {
		bitacademy.ajax(url, {
			type: "GET",
			dataType: "html",
			success: function(result) {
				extElement.innerHTML = result;
				var elements = extElement.getElementsByTagName("script");
				for (var i = 0; i < elements.length; i++) {
					eval(elements[i].textContent);
				}
			}
		});
	};
	
	extElement.html = function(value) {
		this.innerHTML = value;
		return this;
	};
	
	extElement.append = function(childElement) {
		this.appendChild(childElement);
		return this;
	};
	
	extElement.appendTo = function(parentElement) {
		parentElement.appendChild(this);
		return this;
	};
	
	extElement.attr = function(attrName, value) {
		if (arguments.length > 1) {
			this.setAttribute(attrName, value);
			return this;
		} else if (arguments.length == 1) {
			return this.getAttribute(attrName);
		}
	};
	
	extElement.css = function(styleName, value) {
		if (extElement.length && extElement.length > 0) {
			// 엘리먼트가 여러 개인 경우, 
			if (arguments.length > 1) {
				// 모든 엘리먼트에 대해 값을 할 당한다.
				for(var i = 0; i < extElement.length; i++) {
					this[i].style[styleName] = value;
				} 
				return this;
			} else if (arguments.length == 1) {
				// 만약 특정 스타일의 값을 꺼내려 할 때 0번째인 값만 꺼내서 리턴한다.
				return this[0].style[styleName];
			}
		} else {
			if (arguments.length > 1) {
				this.style[styleName] = value;
				return this;
			} else if (arguments.length == 1) {
				return this.style[styleName];
			}
		}
	};
	
	extElement.val = function(value) {
		if (arguments.length > 0) {
			this.value = value;
			return this;
		} else if (arguments.length == 0) {
			return this.value;
		}
	};
	
	extElement.click = function(listener) {
		this.addEventListener("click", listener);
		return this;
	};
	
	return extElement;
}

bitacademy.load = function(selector, url) {
	bitacademy.ajax(url, {
		type: "GET",
		dataType: "html",
		success: function(result) {
			var element = bitacademy(selector);
			element.innerHTML = result;
		}
	});
};

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
				var dataType = "json";
				if (settings.dataType) {
					dataType = settings.dataType;
				}
				
				var result = null;
				if (dataType == "json") {
					result = JSON.parse(xhr.responseText);
				} else if (dataType == "html") {
					result = xhr.responseText;
				}
				
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


























