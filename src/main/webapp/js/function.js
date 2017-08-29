//设置轮播图
function setScorllImg(products) {
	console.log(products);
	var sliders = document.querySelectorAll('.swiper-slide');
	for (var i = 0; i < sliders.length; i++) {
		sliders[i].style.background = "url(http://192.168.20.91:8080/PC_Web/"
				+ products[i].proUrl + ") 0 0 no-repeat";
		sliders[i].style.backgroundSize = "cover";
	}
}

// 设置首页商品流
function setProductsFlow(products) {
	console.log(products)
	var length = products.length >= 4 ? 4 : products.length;
	for (var i = 0; i < length; i++) {

		var li = document.createElement('li');
		var cakeList = document.querySelector('.cakeList');
		li.innerHTML = '<a'
				+ ' href="/Mobile_web/html/descript.html?id='
				+ products[i].id
				+ '"'
				+ ' style="width:100%;"><div class="wrap"><img class="cover1" src="http://192.168.20.91:8080/PC_Web/'
				+ products[i].proUrl
				+ '" alt="" /><h5 class="mask"><span class="text">'
				+ products[i].proName
				+ '</span></h5></div><h5 class="text-overflow">'
				+ products[i].proInfo + '</h5></a>';

		cakeList.appendChild(li);
	}
}

function liClick(id) {
	window.location.href = "http://bgaiyaowai.com/wx/b520/html/descript.html?id="
			+ id;
}

// 所有产品
function setAll(products) {
	var listAll = document.querySelector('.list');
	for (var i = 0; i < products.length; i++) {
		var li = document.createElement('li');
		var name = products[i][1][0].typeName;
		console.log(name);
		li.className = "mui-card";
		li.innerHTML = '<a'
				+ ' href="/Mobile_web/html/descript.html?id='
				+ products[i][0][0].id
				+ '"'
				+ ' style="width:100%;"><div class="mui-card-content product"><div class="mask"><span class="text">'
				+ products[i][0][0].proName
				+ '</span></div><img class="cover" src="http://192.168.20.91:8080/PC_Web/'
				+ products[i][0][0].proUrl
				+ '" alt="" width="100%"></div><div class="mui-card-footer flexFlow"><span style="text-indent: 1.5rem;">'
				+ products[i][0][0].proInfo + '</span></div></a>';
		listAll.appendChild(li);
		document.querySelector('.mui-title').innerText = name
		document.querySelector('.a1').innerText = name
	}
}
function setAll1(products) {
	var listAll = document.querySelector('.list');
	for (var i = 0; i < products.length; i++) {
		var li = document.createElement('li');

		console.log(name);
		li.className = "mui-card";
		li.innerHTML = '<a'
				+ ' href="/Mobile_web/html/descript.html?id='
				+ products[i].id
				+ '"'
				+ ' style="width:100%;"><div class="mui-card-content product"><div class="mask"><span class="text">'
				+ products[i].proName
				+ '</span></div><img class="cover" src="http://192.168.20.91:8080/PC_Web/'
				+ products[i].proUrl
				+ '" alt="" width="100%"></div><div class="mui-card-footer flexFlow"><span style="text-indent: 1.5rem;">'
				+ products[i].proInfo + '</span></div></a>';
		listAll.appendChild(li);

	}
}

// ajax请求
function ajax(url, callback) {
	var ajax = new XMLHttpRequest();
	ajax.open('get', url);
	ajax.send();
	ajax.onreadystatechange = function() {
		if (ajax.readyState == 4 && ajax.status == 200) {
			var response = JSON.parse(ajax.responseText);
			console.log(response);
			callback(response);
		}
	}
}

// 获取商品信息
function getProduct(id) {
	var url = '/Mobile_web/selectPro?id=' + id;
	ajax(
			url,
			function(res) {

				for (var i = 0; i < res.length; i++) {

					var proname = res[i][0][0].proName;
					var prourl = res[i][0][0].proUrl;
					var proinfo = res[i][0][0].proInfo;
					var prosize = res[i][1][0].sizePrice;
					console.log(prourl);
				}

				// 图片
				document.querySelector('.pic').src = "http://192.168.20.91:8080/PC_Web/"
						+ prourl;
				// 名称
				document.querySelector('.productName').innerText = proname;
				// 描述
				document.querySelector('.descript').innerText = proinfo;
				// 价格
				document.querySelector('.price').innerText = prosize;
				$("#paynow")
						.on(
								'click',
								function() {
									window.location.href = "/Mobile_web/html/buy_now.html?id="
											+ id;
								});
			});
}
