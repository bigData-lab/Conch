# Conch  海螺
负责内部消息（邮件，钉钉）通知

## Run the Conch
- mvn package
- java -jar xxx.jar


## Use the Conch

- open url http://ip:port/swagger-ui.html


## Send message
```
send dingding message

curl -X POST \
     http://127.0.0.1:8080/conch/notice/ding \
     -H 'Content-Type: application/json' \
     -d '{
     "access_token": "钉钉群自定义机器人的token",
     "content": "消息内容(换行使用\n)"
   }'
   
  
send mail message

curl -X POST \
  http://127.0.0.1:8080/conch/notice/mail \
  -H 'Content-Type: application/json' \
  -d '{
  "subject": "邮件主题 ",
  "text": "邮件内容 ",
  "to": "收件人(如果多个收件人中间英文逗号间隔)"
}'
   ```
