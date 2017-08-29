/**
 * Created by liguocheng on 2017/4/19.
 */

function beagent() {
    alert('市县级代理请联系后台管理员');
    alert('成为个人代理，可以推广其他会员，并从其他会员的购买过程中获得分成，个人代理申请需要88元，详细请联系后台管理员');
    $.ajax({
        url: "http://bgaiyaowai.com/wx/b520/php/controller/pay.php?price=" + 0.02 + "&url=" + encodeURIComponent('http://bgaiyaowai.com/wx/b520/html/index.html'),
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
                        $.ajax({
                            url:"http://bgaiyaowai.com/wx/b520/php/controller/personagent.php?type=register",
                            type:"get",
                            success:function(data) {
                                alert('您已经成为个人代理，您可以向好友推广本号了~');
                            },
                            error:function(data) {

                            }
                        });
                    }
                });
            });
        }

    });
}


function bebussness() {
    alert('成为商家需要交付3800元');
    $.ajax({
        url: "http://bgaiyaowai.com/wx/b520/php/controller/pay.php?price=" + 0.03 + "&url=" + encodeURIComponent('http://bgaiyaowai.com/wx/b520/html/index.html'),
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
                        $.ajax({
                            url:"http://bgaiyaowai.com/wx/b520/php/controller/bussness.php?type=register",
                            type:"get",
                            success:function(data) {
                                var resu = $.parseJSON(data);
                                alert('您已经成为商家，请登录后台管理系统，修改您的相关信息，方便后台为您派发客户订单。');
                                alert('以下信息请妥善保存：\n后台管理地址：http://bgaiyaowai.com/wx/b520/ayw \n用户名：'+ resu.username + "\n 密码："+resu.pwd);
                            },
                            error:function(data) {

                            }
                        });
                    }
                });
            });
        }

    });
}

function tuiguang() {
    $.ajax({
        url:"http://bgaiyaowai.com/wx/b520/php/controller/personagent.php?type=getMyself",
        type:'type',
        success:function(data) {
            var res = $.parseJSON(data);
            if(res.data == "not") {
                alert("您还不是个人代理，选择成为个人代理");
            } else {
                var json = $.parseJSON(data);
                window.location.href="http://bgaiyaowai.com/wx/b520/html/myqcode.html?openid="+json[0].openid;
            }
        }


    });
}


