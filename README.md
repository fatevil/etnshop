
### Usage

```
git clone git@github.com:fatevil/etnshop.git
cd etnshop
```

In MySQL database:
```
mysql> create database etnshop;
mysql> use etnshop;
mysql> source etnshop_product.sql;
 ```

Configure DB password
```
gedit src/main/resources/application.properties
gradle jettyRun
```