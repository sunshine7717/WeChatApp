/**
 * Created by liguocheng on 2017/4/18.
 */
function loadPage(id) {
    $.ajax({
        url:'http://bgaiyaowai.com/wx/b520/php/controller/product.php?type=getOne&id='+ id,
        type:"get",
        success:function(res) {
            $("#paynow").on('click',function() {
                $.ajax({
                    url:"http://bgaiyaowai.com/wx/b520/php/controller/pay.php?price="+res.p_pri+"&url="+encodeURIComponent('http://bgaiyaowai.com/wx/b520/html/index.html'),
                    type:"get",
                    success: function (data) {
                        var response = JSON.parse(data);
                        window.sessionStorage["out_trade_no"] = response.out_trade_no;
                        window.sessionStorage["timeStamp"] = response.timestamp;
                        wx.config({
                            debug: false, // 开启调试模式,调用的所有api的返回值会在客户端alert出来，若要查看传入的参数，可以在pc端打开，参数信息会通过log打出，仅在pc端时才会打印。
                            appId: response.appid, // 必填，公众号的唯一标识
                            timestamp: response.timestamp, // 必填，生成签名的时间戳
                            nonceStr: response.noncestr, // 必填，生成签名的随机串
                            signature: response.signature, // 必填，签名，见附录1
                            jsApiList: ["chooseWXPay"] // 必填，需要使用的JS接口列表，所有JS接口列表见附录2
                        });
                        // 验证成功之后在此函数内调用各种接口函数

                        wx.ready(function () {
                            wx.chooseWXPay({
                                timestamp: response.timestamp, // 支付签名时间戳，注意微信jssdk中的所有使用timestamp字段均为小写。但最新版的支付后台生成签名使用的timeStamp字段名需大写其中的S字符
                                nonceStr: response.noncestr, // 支付签名随机串，不长于 32 位
                                package: "prepay_id=" + response.prepay_id[0], // 统一支付接口返回的prepay_id参数值，提交格式如：prepay_id=***）
                                signType: 'MD5', // 签名方式，默认为'SHA1'，使用新版支付需传入'MD5'
                                paySign: response.paySign, // 支付签名
                                success: function (res) {
                                    alert('支付成功');
                                }

                            });
                        });
                    }

                });
            });
        }
    });

}

function getCookie(name)
{
    var arr,reg=new RegExp("(^| )"+name+"=([^;]*)(;|$)");
    if(arr=document.cookie.match(reg))
        return unescape(arr[2]);
    else
        return null;
}

function jiluxinxi() {
    var ext_info = $("#ext_info")[0].value;
    window.sessionStorage['ext_info'] = ext_info;
}

function payAction(p_pri,p_id,localid) {
   // alert("购买后15分钟内，可以在订单页面退款");
    $("#buy_now").on('click',function() {
        if($('#buy_user_phone')[0].innerText == "") {
            alert("请选择收货地址");
            return;
        }
        alert("支付发起中，请稍后... 确认支付后无法退单");
        $.ajax({
            url: "http://bgaiyaowai.com/wx/b520/php/controller/pay.php?info=" + $("#ext_info").val() + "&price=" + p_pri + "&url=" + encodeURIComponent('http://bgaiyaowai.com/wx/b520/html/index.html'),
            type: "get",
            success: function (data) {
                var response = JSON.parse(data);
                window.sessionStorage["out_trade_no"] = response.out_trade_no;
                window.sessionStorage["timeStamp"] = response.timestamp;
                wx.config({
                    debug: false, // 开启调试模式,调用的所有api的返回值会在客户端alert出来，若要查看传入的参数，可以在pc端打开，参数信息会通过log打出，仅在pc端时才会打印。
                    appId: response.appid, // 必填，公众号的唯一标识
                    timestamp: response.timestamp, // 必填，生成签名的时间戳
                    nonceStr: response.noncestr, // 必填，生成签名的随机串
                    signature: response.signature, // 必填，签名，见附录1
                    jsApiList: ["chooseWXPay"] // 必填，需要使用的JS接口列表，所有JS接口列表见附录2
                });
                // 验证成功之后在此函数内调用各种接口函数
                wx.ready(function () {
                    wx.chooseWXPay({
                        timestamp: response.timestamp, // 支付签名时间戳，注意微信jssdk中的所有使用timestamp字段均为小写。但最新版的支付后台生成签名使用的timeStamp字段名需大写其中的S字符
                        nonceStr: response.noncestr, // 支付签名随机串，不长于 32 位
                        package: "prepay_id=" + response.prepay_id[0], // 统一支付接口返回的prepay_id参数值，提交格式如：prepay_id=***）
                        signType: 'MD5', // 签名方式，默认为'SHA1'，使用新版支付需传入'MD5'
                        paySign: response.paySign, // 支付签名
                        success: function (res) {

                            localid = window.sessionStorage.getItem('localid');

                            p_id = window.sessionStorage.getItem('p_id');

                            var c_id = window.sessionStorage.getItem('c_id');//$("#cityResult3")[0].value;
                            var u_info = window.sessionStorage.getItem('ext_info');

                            $.ajax({
                                url:"http://bgaiyaowai.com/wx/b520/php/controller/orders.php?type=creat&o_num="+response.out_trade_no+"&stauts=0&location="+localid+"&p_id="+p_id+"&u_info="+u_info+"&c_id="+c_id+"",
                                type:"get",
                                success:function(data) {

                                    window.location.href = "http://bgaiyaowai.com/wx/b520/html/myorders.html";
                                },
                                error:function(XMLHttpRequest, textStatus, errorThrown) {

                                }
                            });
                        }

                    });
                });
            }

        });
		// alert("确认支付后无法退单");
    });
}


function subPayContent(p_pri) {
        alert(p_pri);

        $.ajax({
            url: "http://bgaiyaowai.com/wx/b520/php/controller/pay.php?price=" + 0.01 + "&url=" + encodeURIComponent('http://bgaiyaowai.com/wx/b520/html/index.html'),
            type: "get",
            success: function (data) {

                var response = JSON.parse(data);
                window.sessionStorage["out_trade_no"] = response.out_trade_no;
                window.sessionStorage["timeStamp"] = response.timestamp;
                wx.config({
                    debug: false, // 开启调试模式,调用的所有api的返回值会在客户端alert出来，若要查看传入的参数，可以在pc端打开，参数信息会通过log打出，仅在pc端时才会打印。
                    appId: response.appid, // 必填，公众号的唯一标识
                    timestamp: response.timestamp, // 必填，生成签名的时间戳
                    nonceStr: response.noncestr, // 必填，生成签名的随机串
                    signature: response.signature, // 必填，签名，见附录1
                    jsApiList: ["chooseWXPay"] // 必填，需要使用的JS接口列表，所有JS接口列表见附录2
                });
                // 验证成功之后在此函数内调用各种接口函数
                wx.ready(function () {
                    wx.chooseWXPay({
                        timestamp: response.timestamp, // 支付签名时间戳，注意微信jssdk中的所有使用timestamp字段均为小写。但最新版的支付后台生成签名使用的timeStamp字段名需大写其中的S字符
                        nonceStr: response.noncestr, // 支付签名随机串，不长于 32 位
                        package: "prepay_id=" + response.prepay_id[0], // 统一支付接口返回的prepay_id参数值，提交格式如：prepay_id=***）
                        signType: 'MD5', // 签名方式，默认为'SHA1'，使用新版支付需传入'MD5'
                        paySign: response.paySign, // 支付签名
                        success: function (res) {
                            //日期
                            var date = document.querySelector('.dbtn').value;
                            alert(date);
                            //人数
                            var personNumber = document.querySelector('#personCount').value;
                            //姓名
                            var personName = document.querySelector('#personName').value;
                            //电话
                            var phoneNumber = document.querySelector('#phoneNumber').value;
                            //地址
                            var address = document.querySelector('#address').value;
                            //套餐
                            var sign_type = document.querySelector('#showUserPicker').value;
                            $.ajax({

                                url:"http://bgaiyaowai.com/wx/b520/php/controller/diys.php?type=create&contactName="+personName+"&contactPhone="+phoneNumber+"&diytime="+date+"&location="+address+"&teamSize="+personNumber+"",
                                type:"get",
                                success:function(data) {
                                    alert("成功");
                                },
                                error:function(XMLHttpRequest, textStatus, errorThrown) {

                                }
                            });
                        }

                    });
                });
            }

        });

}