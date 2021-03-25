# Description


+ 会员端（openapi）跟运营端（adminapi）在代码实现跟部署上都做严格分离，各自的业务接口都分开在自己的工程里面写，虽然他们底层用的是同一个数据库。
+ 会员端采用jwt + spring mvc拦截器来做登录认证与鉴权
+ 运营端使用spring security框架或shiro框架来做认证与鉴权