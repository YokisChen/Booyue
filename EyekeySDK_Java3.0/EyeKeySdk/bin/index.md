<div id="table-of-contents">
<h2>Table of Contents</h2>
<div id="text-table-of-contents">
<ul>
<li><a href="#sec-1">1. 环境需求</a></li>
<li><a href="#sec-2">2. 安装说明</a></li>
<li><a href="#sec-3">3. 配置说明</a></li>
<li><a href="#sec-4">4. 调用示例</a></li>
<li><a href="#sec-5">5. api 参考</a></li>
<li><a href="#sec-6">6. 常见问题</a></li>
<li><a href="#sec-7">7. 支持信息</a></li>
</ul>
</div>
</div>


# 环境需求<a id="sec-1" name="sec-1"></a>

-   jdk 版本:1.6及其以上版本
-   依赖的包:
    -   [fstjson]fastjson-1.1.24.jar(https://github.com/alibaba/fastjson)
    -   [apache-http-core]httpcore-4.3.3.jar(http://hc.apache.org/httpcomponents-core-ga/index.html)
    -   [apache-http-client]httpmime-4.3.6.jar(http://hc.apache.org/httpcomponents-client-ga/index.html)

# 安装说明<a id="sec-2" name="sec-2"></a>
把eyekeysdk.jar、fastjson-1.1.24.jar、httpcore-4.3.3.jar、httpmime-4.3.6.jar加的classpath中去

# 配置说明<a id="sec-3" name="sec-3"></a>
    #appid
    app_id=1
    #appkey
    app_key=1
    #以毫秒为单位
    readTimeOut=10000
    #以毫秒为单位
    connTimeOut=10000
    #website
    website=http://api.eyekey.com
    #update-url（sdk版本检测url）
    update-url=

# 调用示例<a id="sec-4" name="sec-4"></a>
    EyeKeyHttp http = new EyeKeyHttp();
        或者
    EyeKeyHttp http = new EyeKeyHttp(appid,appkey);
        参照api文档调用相关的方法
# api 参考<a id="sec-5" name="sec-5"></a>

参见 [javadoc](javadoc/)

# 常见问题<a id="sec-6" name="sec-6"></a>

# 支持信息<a id="sec-7" name="sec-7"></a>

-   支持邮箱 :zhangxinlei@techshino.com
-   QQ :376489090
-   QQ 群 :
-   微信号:
