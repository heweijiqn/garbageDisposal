# 垃圾分类查询管理系统
> 参考网站：[https://lajifenleiapp.com/](https://lajifenleiapp.com/)
> 
> 博客教程：[https://blog.csdn.net/WeiHao0240/article/details/127329490](https://blog.csdn.net/WeiHao0240/article/details/127329490)

网络上有很多以本系统进行讲解的博客和教程，\
请不要商用，并标明出处！\


## 1.介绍
垃圾分类查询管理系统，对不懂的垃圾进行查询进行分类并可以预约上门回收垃圾。\
让用户自己分类垃圾，\
按国家标准自己分类，\
然后在网上提交订单，\
专门有人负责回收，\
统一回收到垃圾处理站，\
然后工人开始再次分类，\
将可再次循环使用的贩卖给工厂（以后有钱自己开）。\
订单处理完（一般7天内），\
将一部分钱返还给用户。\
让垃圾变成钱！
### 1.1 功能点


| 序号 | 功能点 |
| ---- | ---- |
| 1 | 用户管理 |
| 2 | 页面管理 |
| 3 | 角色管理 |
| 4 | 首页 |
| 5 | 贡献管理 |
| 6 | 垃圾管理 |
| 7 | 全国统计|
| 8 | 搜索记录 |
| 9 | 分类管理 |
| 10 | 分类列表 |
| 11 | 垃圾列表 |
| 12 | 修改奖励 |
| 13 | 我的收益 |
| 14 | 随机数据 |
| 15 | 分类统计 |
| 16 | 投放统计 |
| 17 | 公告管理 |
| 18 | 公告列表 |
| 19 | 发布公告 |
| 21 | 每日垃圾 |
| 22 | 贡献记录 |
| 23 | 预约管理 |


## 2.软件架构
JDK 1.8\
SpringBoot 2.2.6.RELEASE\
freemarker 2.3.28\
mybatis-plus 3.2.0\
shiro 1.3.2

## 3.安装启动
源码地址：[https://gitee.com/jack0240/gcms.git](https://gitee.com/jack0240/gcms.git)
拉取代码之后用IDEA打开，注意修改MySQL用户名密码。

![输入图片说明](src/main/resources/%E6%88%AA%E5%9B%BE/0.%E5%90%AF%E5%8A%A8.png)

启动后访问地址：[http://127.0.0.1:8083/](http://127.0.0.1:8083/)
用户名：**admin**、密码：**123456**
![输入图片说明](src/main/resources/%E6%88%AA%E5%9B%BE/1.%E7%99%BB%E5%BD%95%E9%A1%B5%E9%9D%A2.png)


参考资料：

[MySQL8.0和5.7安装教程](https://blog.csdn.net/WeiHao0240/article/details/86908034)
[Java环境配置/JDK安装配置](https://blog.csdn.net/WeiHao0240/article/details/86550186)

## 4.运行截图
![输入图片说明](src/main/resources/%E6%88%AA%E5%9B%BE/2.%E7%94%A8%E6%88%B7%E7%AE%A1%E7%90%86.png)

![输入图片说明](src/main/resources/%E6%88%AA%E5%9B%BE/3.%E9%A1%B5%E9%9D%A2%E7%AE%A1%E7%90%86.png)

![输入图片说明](src/main/resources/%E6%88%AA%E5%9B%BE/4.%E8%A7%92%E8%89%B2%E7%AE%A1%E7%90%86.png)

![输入图片说明](src/main/resources/%E6%88%AA%E5%9B%BE/5.%E6%9F%A5%E8%AF%A2.png)

![输入图片说明](src/main/resources/%E6%88%AA%E5%9B%BE/6.%E6%90%9C%E7%B4%A2%E8%AE%B0%E5%BD%95.png)

![输入图片说明](src/main/resources/%E6%88%AA%E5%9B%BE/7.%E6%88%91%E7%9A%84%E6%94%B6%E7%9B%8A.png)

![输入图片说明](src/main/resources/%E6%88%AA%E5%9B%BE/8.%E8%B4%A1%E7%8C%AE%E7%AE%A1%E7%90%86.png)

![输入图片说明](src/main/resources/%E6%88%AA%E5%9B%BE/9.%E9%9A%8F%E6%9C%BA%E6%95%B0%E6%8D%AE.png)

![输入图片说明](src/main/resources/%E6%88%AA%E5%9B%BE/10.%E5%9E%83%E5%9C%BE%E7%AE%A1%E7%90%86.png)

![输入图片说明](src/main/resources/%E6%88%AA%E5%9B%BE/11.%E5%88%86%E7%B1%BB%E7%AE%A1%E7%90%86.png)

![输入图片说明](src/main/resources/%E6%88%AA%E5%9B%BE/12.%E5%9E%83%E5%9C%BE%E7%AE%A1%E7%90%86.png)

![输入图片说明](src/main/resources/%E6%88%AA%E5%9B%BE/13.%E5%85%A8%E5%9B%BD%E7%BB%9F%E8%AE%A1.png)

![输入图片说明](src/main/resources/%E6%88%AA%E5%9B%BE/14.%E5%88%86%E7%B1%BB%E7%BB%9F%E8%AE%A1.png)

![输入图片说明](src/main/resources/%E6%88%AA%E5%9B%BE/15.%E6%8A%95%E6%94%BE%E7%BB%9F%E8%AE%A1.png)

![输入图片说明](src/main/resources/%E6%88%AA%E5%9B%BE/16.%E5%85%AC%E5%91%8A%E7%AE%A1%E7%90%86.png)

![输入图片说明](src/main/resources/%E6%88%AA%E5%9B%BE/17.%E5%85%AC%E5%91%8A%E5%8F%91%E5%B8%83.png)

![输入图片说明](src/main/resources/%E6%88%AA%E5%9B%BE/18.%E9%A2%84%E7%BA%A6%E7%AE%A1%E7%90%86.png)




