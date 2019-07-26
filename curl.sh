#!/usr/bin/env bash
#! 我的dockerHost的IP为192.168.237.130
#! 判断是否登陆成功 ,成功返回：Login status ?true 不成功返回：Login status ?false
curl -H "Accept: application/json" -H "Content-type: application/json" -X POST -d '{"first_name": "180000","last_name": "dvds"}'  http://192.168.237.130:18080/v1/customer/login
#! 新增用户的请求, 新增成功返回：New CustomerID?600 ---600就是新增用户的ID
curl -X POST --header 'Content-Type: application/json' --header 'Accept: application/json' -d '{"first_name": "test1","last_name": "test2","email":"qq_email","address":"28 MySQL Boulevard"}' http://192.168.237.130:18080/v1/customer
#! 更新用户的请求 ,更新成功后会返回The update was successful, and the result of the updated object was?Customer的json字符串，---注意替换id
 curl -X PUT --header 'Content-Type: application/json' --header 'Accept: application/json' -d '{"first_name": "Mr","last_name": "Wang", "email":"vdsv","address":"125 Citt del Vaticano Boulevard"}' http://192.168.237.130:18080/v1/customer/600
#! 删除数据的请求,成功返回Successful deletion!!! ---注意替换IP和ID
 curl -X DELETE --header 'Content-Type: application/json' --header 'Accept: application/json' -b "customer_id=600"  http://192.168.237.130:18080/v1/customer/600
#! 分页的请求,请求成功返回分页的数据的json字符串
curl http://192.168.237.130:18080/v1/film/list?page=1\&pageSize=10
#! 插入电影数据的请求,插入成功返回电影的自增ID New Film ID?1001
curl -X POST --header 'Content-Type: application/json' --header 'Accept: application/json' -d '{"title": "dada","descripti' http://192.168.237.130:18080/v1/film
