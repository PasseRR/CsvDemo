# CsvDemo

## 创建数据库
在mysql中创建数据库`test`，字符集选择utf-8

## 导入表
在数据库`test`中执行[init.sql]()

## 修改数据库配置

## 构建
```bash
cd CsvDemo;
gradle build;
```

## 运行
```bash
cd CsvDemo/build/libs;
java -jar CsvDemo-1.0-SNAPSHOT.jar
```

## 使用
在浏览器中打开http://localhost:8080上传文件测试