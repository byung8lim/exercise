# mydiet server
docker build -t kong-gw.bd.com:5000/fitness/mydiet:latest .

docker push kong-gw.bd.com:5000/fitness/mydiet:latest

docker run -d -p 8083:8080 --restart=always --name fitness-mydiet \
-e DB_URI=10.10.50.2:3306 \
-e DB_USER_NAME=byung8 \
-e DB_USER_PASSWORD=1q2w3e4r5t \
-v /etc/localtime:/etc/localtime \
-v /data/fitness/mydiet/logs:/data/fitness/mydiet/logs \
kong-gw.bd.com:5000/fitness/mydiet:latest

# Tomcat accesslog format
%a - Remote IP address
%A - Local IP address
%b - Bytes sent, excluding HTTP headers, or กฎ-กฎ if no bytes were sent
%B - Bytes sent, excluding HTTP headers
%h - Remote host name (or IP address if enableLookups for the connector is false)
%H - Request protocol
%l - Remote logical username from identd (always returns กฎ-กฎ)
%m - Request method
%p - Local port
%q - Query string (prepended with a กฎ?กฏ if it exists, otherwise an empty string
%r - First line of the request
%s - HTTP status code of the response
%S - User session ID
%t - Date and time, in Common Log Format format
%u - Remote user that was authenticated
%U - Requested URL path
%v - Local server name
%D - Time taken to process the request, in millis
%T - Time taken to process the request, in seconds
%I - current Request thread name (can compare later with stacktraces)

"%{yyyy-MM-dd HH:mm:ss}t\t%s\t%r\t%{User-Agent}i\t%{Referer}i\t%a\t%b\t%F\t%D"
