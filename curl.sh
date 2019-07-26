#!/usr/bin/env bash

#! 判断是否登陆成功
curl -H "Accept: application/json" -H "Content-type: application/json" -X POST -d '{"first_name": "180000","last_name": "dvds"}'  http://{dockerHostIP}:18080/v1/customer
#! 新增用户的请求
curl -X POST --header 'Content-Type: application/json' --header 'Accept: application/json' -d '{"first_name": "sdvsd","last_name": "nvjsdk","email":"qq_email","address":"28 MySQL Boulevard"}' http://{dockerHostIP}:18080/v1/customer
#! 更新用户的请求
 curl -X PUT --header 'Content-Type: application/json' --header 'Accept: application/json' -d '{"first_name": "Mr","last_name": "Wang", "email":"vdsv","address":"125 Citt del Vaticano Boulevard"}' http://{dockerHostIP}:18080/v1/customer/{上一个返回的ID}
#! 删除数据的请求
http://localhost:18080/v1/customer/623
#! 分页的请求
http://localhost:18080/v1/film/list?page=1&pageSize=10
#!插入数据的请求
http://localhost:18080/v1/film
#! 登陆的请求