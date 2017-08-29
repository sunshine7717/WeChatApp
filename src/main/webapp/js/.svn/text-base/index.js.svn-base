//商品信息
var products = [{
	"status": 1,
	"data": {
		"id": "1",
		"P_name": "草莓拿破仑",
		"P_prc": "../img/text.jpg",
		"P_info": "newsound",
		"P_pri": "300"
	}
}, {
	"status": 1,
	"data": {
		"id": "1",
		"P_name": "草莓拿破仑",
		"P_prc": "../img/text.jpg",
		"P_info": "newsound",
		"P_pri": "300"
	}
}, {
	"status": 1,
	"data": {
		"id": "1",
		"P_name": "草莓拿破仑",
		"P_prc": "../img/text.jpg",
		"P_info": "newsound",
		"P_pri": "300"
	}
}, {
	"status": 1,
	"data": {
		"id": "1",
		"P_name": "草莓拿破仑",
		"P_prc": "../img/text.jpg",
		"P_info": "newsound",
		"P_pri": "300"
	}
}, ];

//设置轮播图
function setScorllImg(productsImg) {
	var sliders = document.querySelectorAll('.swiper-slide');
	for(var i = 0; i < sliders.length; i++) {
		sliders[i].style.background = "url(" + productsImg[i].data.P_prc + ") 0 0 no-repeat";
		sliders[i].style.backgroundSize = "cover";
	}
}

//设置商品流
function setProductsFlow(productsImg) {
	var length = 0;
	if(productsImg.length >=4) {
		length = 4;
	} else {
		length = productsImg.length;
	}

	for(var i = 0; i < length; i++) {
		var li = document.createElement('li');
		var cakeList = document.querySelector('.cakeList');
		li.innerHTML = '<img src=' + productsImg[i].data.P_prc + ' alt="" /><h5>' + productsImg[i].data.P_info + '</h5><h5>' + productsImg[i].data.P_name + '<span>￥' + productsImg[i].data.P_pri + '</span></h5>';
		cakeList.appendChild(li);
	}
}

setScorllImg(products);
setProductsFlow(products);