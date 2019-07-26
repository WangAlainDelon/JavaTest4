SpringBoot+MyBatis的CRUD
### 软件环境
* Java version: 1.8.0_191
* Apache Maven 3.5.4
* 接口风格：标准的restful风格的接口
## 提醒 ：如果运行.sh文件报错，需要用到dos2unix转换需要将素有的.sh文件都 dos2unix start.sh 转换成unix下的格式

* build.sh 用于编译maven 项目和构建镜像
* 有start.sh 后台启动docker-compose 容器
* 有stop.sh 用于查看Java 容器镜像日志，并停止dockercompose。
* 有curl.sh 用于向Java 容器发起请求
* curl中的请求需要修该数据
* 每个请求的执行结果都会有返回值，
* 功能写完了curl命令还没写完。。。。