<!doctype html>
<html>
<head>
<meta charset="utf-8">
<title>客服聊天</title>
<meta name="viewport" content="width=device-width, initial-scale=1.0, minimum-scale=1.0, maximum-scale=1.0, user-scalable=no">
<meta name="format-detection" content="telephone=no">
<meta name="apple-mobile-web-app-capable" content="yes">
<meta name="apple-mobile-web-app-status-bar-style" content="black">
<link rel="stylesheet" href="styles/style.css">
<script src="http://www.weizoom.com/static/resources/js/jquery-1.7.1.min.js"></script>
</head>
<body>
<div class="dialogue-wrapper">
    <div id="btn_open" class="dialogue-support-btn">
        <i class="dialogue-support-icon"></i>
        <i class="dialogue-support-line"></i>
        <span class="dialogue-support-text">联系客服</span>
    </div>
    <div class="dialogue-main">
        <div class="dialogue-header">
            <i id="btn_close" class="dialogue-close">></i>
            <div class="dialogue-service-info">
                <i class="dialogue-service-img">头像</i>
                <div class="dialogue-service-title">
                    <p class="dialogue-service-name">XX客服</p>
                    <p class="dialogue-service-detail">XX客服支持平台</p>
                </div>
            </div>
        </div>
        <div id="dialogue_contain" class="dialogue-contain">
            <p class="dialogue-service-contain"><span class="dialogue-text dialogue-service-text">您好，请提问</span></p>
            <!-- <p class="dialogue-customer-contain"><span class="dialogue-text dialogue-customer-text">我有个问题</span></p> -->
        </div>
        <div class="dialogue-submit">
            <p id="dialogue_hint" class="dialogue-hint"><span class="dialogue-hint-icon">!</span><span class="dialogue-hint-text">发送内容不能为空</span></p>
            <textarea id="dialogue_input" class="dialogue-input-text" placeholder="请输入您的问题，按Enter键提交（shift+Enter换行）"></textarea>
            <div class="dialogue-input-tools">
                小工具预留位置
            </div>
        </div>
    </div>
</div>
<script>
    var doc = document;
    // 模拟一些后端传输数据
    var serviceData = {
        'robot': {
            'name': 'robot001',
            'dialogue': ['模拟回复1', '模拟回复2', '模拟回复3'],
            'welcome': '您好，robot001为您服务'
        }
    };

    var dialogueInput = doc.getElementById('dialogue_input'),
        dialogueContain = doc.getElementById('dialogue_contain'),
        dialogueHint = doc.getElementById('dialogue_hint'),
        btnOpen = doc.getElementById('btn_open'),
        btnClose = doc.getElementById('btn_close'),
        timer,
        timerId,
        shiftKeyOn = false;  // 辅助判断shift键是否按住

    btnOpen.addEventListener('click', function(e) {
        $('.dialogue-support-btn').css({'display': 'none'});
        $('.dialogue-main').css({'display': 'inline-block', 'height': '0'});
        $('.dialogue-main').animate({'height': '600px'})
    })

    btnClose.addEventListener('click', function(e) {
        $('.dialogue-main').animate({'height': '0'}, function() {
            $('.dialogue-main').css({'display': 'none'});
            $('.dialogue-support-btn').css({'display': 'inline-block'});
        });
    })

    dialogueInput.addEventListener('keydown', function(e) {
        var e = e || window.event;
        if (e.keyCode == 16) {
            shiftKeyOn = true;
        }
        if (shiftKeyOn) {
            return true;
        } else if (e.keyCode == 13 && dialogueInput.value == '') {
            // console.log('发送内容不能为空');
            // 多次触发只执行最后一次渐隐
            setTimeout(function() {
                fadeIn(dialogueHint);
                clearTimeout(timerId)
                timer = setTimeout(function() {
                    fadeOut(dialogueHint)
                }, 2000);
            }, 10);
            timerId = timer;
            return true;
        } else if (e.keyCode == 13) {
            var nodeP = doc.createElement('p'),
                nodeSpan = doc.createElement('span');
            nodeP.classList.add('dialogue-customer-contain');
            nodeSpan.classList.add('dialogue-text', 'dialogue-customer-text');
            nodeSpan.innerHTML = dialogueInput.value;
            nodeP.appendChild(nodeSpan);
            dialogueContain.appendChild(nodeP);
            dialogueContain.scrollTop = dialogueContain.scrollHeight;
            submitCustomerText(dialogueInput.value);
        }
    });

    dialogueInput.addEventListener('keyup', function(e) {
        var e = e || window.event;
        if (e.keyCode == 16) {
            shiftKeyOn = false;
            return true;
        }
        if (!shiftKeyOn && e.keyCode == 13) {
            dialogueInput.value = null;
        }
    });

    function submitCustomerText(text) {
        console.log(text)
        // code here 向后端发送text内容

        // 模拟后端回复
        var num = Math.random() * 10;
        if (num <= 7) {
            getServiceText(serviceData);
        }
    }

    function getServiceText(data) {
        var serviceText = data.robot.dialogue,
            i = Math.floor(Math.random() * serviceText.length);
        var nodeP = doc.createElement('p'),
            nodeSpan = doc.createElement('span');
        nodeP.classList.add('dialogue-service-contain');
        nodeSpan.classList.add('dialogue-text', 'dialogue-service-text');
        nodeSpan.innerHTML = serviceText[i];
        nodeP.appendChild(nodeSpan);
        dialogueContain.appendChild(nodeP);
        dialogueContain.scrollTop = dialogueContain.scrollHeight;
    }

    // 渐隐
    function fadeOut(obj) {
        var n = 100;
        var time = setInterval(function() {
            if (n > 0) {
                n -= 10;
                obj.style.opacity = '0.' + n;
            } else if (n <= 30) {
                obj.style.opacity = '0';
                clearInterval(time);
            }
        }, 10);
        return true;
    }

    // 渐显
    function fadeIn(obj) {
        var n = 30;
        var time = setInterval(function() {
            if (n < 90) {
                n += 10;
                obj.style.opacity = '0.' + n;
            } else if (n >= 80) {
                
                obj.style.opacity = '1';
                clearInterval(time);
            }
        }, 100);
        return true;
    }
</script>
</body>
</html>