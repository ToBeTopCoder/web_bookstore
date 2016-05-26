#网上书城
**web_bookstore**是一个基于servlet/jsp和html/css/js的网上书城项目。<br>
该网上书城项目分为前台和后台两大部分，前台部分包括会员注册、会员登录、购买书籍、添加购物车、结算等功能，后台部分包括查看会员、查看商品、添加商品等功能。有些功能模块还未添加，后续可能会继续完善。<br>

##注册模块
会员需要先注册后才能使用网上书城添加购物车和结算等功能，注意：会员注册后需要管理员激活该会员后才能登录。注册界面如下所示：<br>
![](https://github.com/ToBeTopCoder/web_bookstore/raw/master/WebContent/picture/register.png)

##登录模块
会员注册成功后，就可以直接登陆到网上书城了，登录界面如下所示。注意，如果是管理员登录的话，会跳转到后台管理员主页；如果是普通会员的话就会跳到会员主页。<br>
![](https://github.com/ToBeTopCoder/web_bookstore/raw/master/WebContent/picture/login.png)

##数据库模块
该网上书城使用了5个数据表，相关的表说明文件见web_bookstore/src/db.sql文件。<br>

##如何使用
下载项目后直接导入到eclipse工程中即可。