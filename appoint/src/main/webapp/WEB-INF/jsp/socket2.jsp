<%@ page contentType="text/html;charset=UTF-8" language="java" %>
<html>
<head>
    <title>WebScoket</title>
    <script src="/sockjs.min.js"></script>
    <script src="/stomp.min.js"></script>
    <script src="/jquery.min.js"></script>
</head>
<body>
    Welcome<br/><input id="text" type="text" />
    <button onclick="send()">发送消息</button>
    <button onclick="subscribe1()">订阅消息/topic/msg1</button>
    <button onclick="subscribe2()">订阅消息/topic/msg2</button>
    <hr/>
    <button onclick="disconnect()">关闭WebSocket连接</button>
    <hr/>
    <div id="message"></div>
</body>
<script type="text/javascript">
    // 建立连接对象（还未发起连接）
    var socket = new SockJS("http://localhost:8087/webSocketServer");

    // 获取 STOMP 子协议的客户端对象
    var stompClient = Stomp.over(socket);

    // 向服务器发起websocket连接并发送CONNECT帧
    stompClient.connect({},
        function connectCallback(frame) {
            // 连接成功时（服务器响应 CONNECTED 帧）的回调方法
            setMessageInnerHTML("连接成功");
        },
        function errorCallBack(error) {
            // 连接失败时（服务器响应 ERROR 帧）的回调方法
            setMessageInnerHTML("连接失败");
        }
    );
    //断开连接
    function disconnect(){
        if(stompClient!=null)
        {
            stompClient.disconnect();
        }
        setMessageInnerHTML("断开连接!");
        console.log("断开连接!");
    }
    //发送消息
    function send() {
        var message = document.getElementById('text').value;
        var messageJson = JSON.stringify({ "name": message });
        stompClient.send("/websocket/sendTest", {}, messageJson);
        setMessageInnerHTML("/websocket/sendTest 你发送的消息:" + message);
    }

    //订阅消息
    function subscribe1() {
    	stompClient.subscribe('/websocket/msg1', function (response) {
            var returnData = JSON.parse(response.body);
            setMessageInnerHTML(returnData.responseMessage);
        });
        stompClient.subscribe('/topic/msg1', function (response) {
            var returnData = JSON.parse(response.body);
            setMessageInnerHTML(returnData.responseMessage);
        });
    }

    //订阅消息
    function subscribe2() {
    	stompClient.subscribe('/websocket/msg2', function (response) {
            var returnData = JSON.parse(response.body);
            setMessageInnerHTML(returnData.responseMessage);
        });
        stompClient.subscribe('/topic/msg2', function (response) {
            var returnData = JSON.parse(response.body);
            setMessageInnerHTML(returnData.responseMessage);
        });
    }

    //将消息显示在网页上
    function setMessageInnerHTML(innerHTML) {
        document.getElementById('message').innerHTML += innerHTML + '<br/>';
    }

</script>
</html>
