/**
 * Created by liguocheng on 2017/4/18.
 */

var localid;
function loadData() {
	$.ajax({
		url : "/Mobile_web/selectAddress",
		type : "get",
		success : function(data) {
			console.log(data);
			if (data == null||data=="") {
//				window.location.href="/Mobile_web/html/login.html";
			} else {
				$('#buy_user')[0].innerText = data[0].addressName;
				$('#buy_user_phone')[0].innerText = data[0].addressTel;
				$('#buy_user_address')[0].innerText = data[0].addressInfo;
				window.sessionStorage["localid"] = data[0].id;
				var addid = data[0].id;
			}

		}
	});
}

function loadProductData(id) {
	$.ajax({
		url : '/Mobile_web/selectPro?id=' + id,
		type : "get",
		success : function(data) {
			// console.log(data)
			$("#p_pri")[0].innerText = data[0][1][0].sizePrice;
			$("#totle_price")[0].innerText = data[0][1][0].sizePrice;
			$("#final_price")[0].innerText = data[0][1][0].sizePrice;
			$("#p_pic")[0].src = "http://192.168.20.91:8080/PC_Web/"
					+ data[0][0][0].proUrl;
			$("#p_info")[0].innerText = data[0][0][0].proInfo;
			$("#p_name")[0].innerText = data[0][0][0].proName;
			// payAction(res.p_pri,res.p_id,localid);
		}
	});
}
