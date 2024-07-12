# Hướng dẫn sử dụng
## clone git
```bash
git clone https://github.com/TrinhLongVu/command-java.git
```
## nhảy vào project phụ 
```bash
cd command-java/animal-app
```
## tạo file jar trong thư mục phụ
```bash
find src -name "*.java" -print | xargs javac -d target/classes && jar cvfe animal.jar com.app.Main -C target/classes .
```
### Di chuyển animal.jar vào folder target/dependency trong main-app (project chính) 
### Hiện tại thì trong project chính đã có sẵn có thể xoá để add cái mới vào
##  nhảy vào project chính
```bash
cd ../main-app
```
## tạo file jar có nhúng tất cả thư viện trong target/dependency
```bash
find src -name "*.java" -print | xargs javac -cp "target/dependency/*" -d target/classes && 
mkdir -p ./target/library &&  
for jar in target/dependency/*.jar; do
   (cd ./target/library && jar xf "../../$jar")
done && 
jar cvfm target/app.jar META-INF/MANIFEST.MF -C target/classes . -C target/library .
```
## run file jar
```bash
java -jar target/app.jar
```
