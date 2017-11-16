# CsvDemo

## 创建数据库
在mysql中创建数据库`test`，字符集选择utf-8

## 导入表
在数据库`test`中执行[init.sql](https://github.com/PasseRR/CsvDemo/blob/master/sql/init.sql)

## 修改数据库配置
修改数据源配置为本地的用户名密码，
[appplication-dev.yml](https://github.com/PasseRR/CsvDemo/blob/master/src/main/resources/application-dev.yml)

## 构建
```bash
cd CsvDemo;
gradle build;
```
打开/build/reports/tests/index.html可以看到完成的`测试报告`


## 运行
```bash
cd CsvDemo/build/libs;
java -jar CsvDemo-1.0-SNAPSHOT.jar
```

## 使用
在浏览器中打开http://localhost:8080上传文件测试，
可以使用[2017-11-16.csv](https://github.com/PasseRR/CsvDemo/blob/master/src/test/resources/2017-11-16.csv)