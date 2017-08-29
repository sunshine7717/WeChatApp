
function setTypesFlow(types){
	console.log(types)
	var length = types.length >= 10 ? 10 :types.length;
	for(var i = 0; i < length; i++) {

		var li = document.createElement('li');
		var typeList = document.querySelector('.typeList');
//		li.innerHTML = '<a'+ ' href="descript.html?id='+ types[i].id +'"'+' style="width:100%;">'
//		+'<h5 class="text-overflow">' + types[i].typeName + '</h5></a>';
		li.innerHTML = "<a href='/Mobile_web/html/products_type.html?typeId="+ types[i].id +"' style='width:100%;background-color: #4CD964;color: white;margin-top: 5px;'  class='mui-btn'>"+types[i].typeName+"</a>";
		typeList.appendChild(li);
	}
}

function settypeAll(products){
	var listAll= document.querySelector('.list');
	for (var i = 0; i < products.length; i++) {
		var li = document.createElement('li');
		li.className = "mui-card";
		li.innerHTML = 	'<a'+ ' href="/Mobile_web/html/descript.html?id='+ products[i].id +'"'+' style="width:100%;"><div class="mui-card-content product"><div class="mask"><span class="text">'+ products[i].p_name +'</span><span class="text">��'+ products[i].p_pri +'</span></div><img class="cover" src='+ products[i].p_pic +' alt="" width="100%"></div><div class="mui-card-footer flexFlow"><span style="text-indent: 1.5rem;">'+ products[i].p_info  +'</span></div></a>';
		listAll.appendChild(li);
	}
}
