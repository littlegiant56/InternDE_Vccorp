# Cơ sở dữ liệu SQL

**Database (Cơ sở dữ liệu)** là một tập hợp có tổ chức các dữ liệu, được quản lý và truy xuất dễ dàng bằng các phần mềm quản trị cơ sở dữ liệu (DBMS). Trong SQL, có nhiều hệ quản trị cơ sở dữ liệu (RDBMS) khác nhau, mỗi loại đều có các đặc điểm riêng biệt.

## 1. MySQL

- **Giới thiệu:** MySQL là một hệ quản trị cơ sở dữ liệu mã nguồn mở, phát triển bởi công ty MySQL AB, hiện thuộc sở hữu của Oracle Corporation. Phổ biến trong các trang web và ứng dụng quy mô lớn như Facebook, Twitter và YouTube.
- **Đặc điểm nổi bật:**
  - **Tương thích cao:** Dễ dàng tích hợp với nhiều ngôn ngữ lập trình như PHP, Python, Ruby.
  - **Đa dạng storage engine:** InnoDB (mặc định), MyISAM, Memory, CSV, v.v., cho phép người dùng lựa chọn theo nhu cầu.
  - **Cộng đồng lớn:** Có tài liệu và cộng đồng hỗ trợ phong phú.
- **Ứng dụng:** Phù hợp cho các ứng dụng web, thương mại điện tử và hệ thống có quy mô từ nhỏ đến trung bình.

## 2. Microsoft SQL Server

- **Giới thiệu:** SQL Server là hệ quản trị cơ sở dữ liệu của Microsoft, được sử dụng rộng rãi trong các tổ chức lớn, đặc biệt là doanh nghiệp sử dụng sản phẩm Microsoft.
- **Đặc điểm nổi bật:**
  - **Tích hợp với dịch vụ Microsoft:** Hoạt động tốt trên môi trường Windows và dễ dàng tích hợp với Azure, Visual Studio, Power BI.
  - **Bảo mật cao:** Hỗ trợ mã hóa, quản lý quyền truy cập, kiểm soát rủi ro.
  - **Tối ưu cho ứng dụng doanh nghiệp:** Cung cấp công cụ hỗ trợ quản trị, bảo trì và sao lưu dữ liệu cho các tổ chức lớn.
- **Ứng dụng:** Phù hợp với các ứng dụng doanh nghiệp yêu cầu bảo mật và quản lý dữ liệu lớn.

## 3. Oracle Database

- **Giới thiệu:** Oracle Database là hệ quản trị cơ sở dữ liệu quan hệ được phát triển bởi Oracle Corporation, nổi tiếng về tính ổn định và khả năng xử lý dữ liệu lớn.
- **Đặc điểm nổi bật:**
  - **Hỗ trợ đa nền tảng:** Tương thích với Linux, Windows và các hệ thống Unix.
  - **Phân tán và quản lý dữ liệu mạnh mẽ:** Hỗ trợ Real Application Clusters (RAC), Data Guard.
  - **Tích hợp công nghệ mới:** Liên tục phát triển các tính năng liên quan đến AI, phân tích dữ liệu lớn.
- **Ứng dụng:** Phù hợp cho các ứng dụng tài chính, ngân hàng, bảo hiểm, và các ngành công nghiệp có yêu cầu khắt khe về bảo mật và khả năng mở rộng.

## 4. MongoDB

- **Giới thiệu:** MongoDB là cơ sở dữ liệu NoSQL phổ biến, thuộc loại **document-oriented** (cơ sở dữ liệu theo tài liệu), ra mắt vào năm 2009. Dữ liệu được lưu trữ dưới dạng JSON hoặc BSON.
- **Đặc điểm nổi bật:**
  - **Lưu trữ dạng tài liệu:** Dữ liệu được lưu dưới dạng tài liệu JSON hoặc BSON, linh hoạt và dễ mở rộng.
  - **Khả năng mở rộng ngang:** Hỗ trợ sharding, cho phép phân chia dữ liệu trên nhiều máy chủ.
  - **Tính linh hoạt cao:** Không yêu cầu cấu trúc bảng cố định, dễ dàng thay đổi và mở rộng.
- **Ứng dụng:** Phù hợp cho các ứng dụng yêu cầu lưu trữ dữ liệu phức tạp, không đồng nhất như hệ thống quản lý nội dung và ứng dụng IoT.

## 5. Redis

- **Giới thiệu:** Redis là cơ sở dữ liệu NoSQL dạng **key-value store** (cơ sở dữ liệu lưu trữ khóa-giá trị), nổi bật với tốc độ truy xuất nhanh nhờ lưu dữ liệu trong bộ nhớ.
- **Đặc điểm nổi bật:**
  - **Lưu trữ trong bộ nhớ:** Dữ liệu được lưu trực tiếp trong RAM, giúp Redis có tốc độ truy xuất nhanh.
  - **Đa dạng kiểu dữ liệu:** Hỗ trợ nhiều kiểu như chuỗi, danh sách, tập hợp, băm, bitmap, và hyperloglog.
  - **Hỗ trợ tính bền vững:** Có các tùy chọn sao lưu để đảm bảo dữ liệu an toàn.
- **Ứng dụng:** Thường dùng làm cache, hệ thống xếp hàng, bộ đếm hoặc các ứng dụng thời gian thực như bảng xếp hạng.

## 6. Cassandra

- **Giới thiệu:** Apache Cassandra là cơ sở dữ liệu NoSQL phân tán thuộc loại **wide-column store** (cơ sở dữ liệu dạng cột), phát triển bởi Facebook và hiện được duy trì bởi Apache Software Foundation.
- **Đặc điểm nổi bật:**
  - **Mở rộng không giới hạn:** Hỗ trợ mở rộng ngang (scaling horizontally) không có điểm nút cổ chai.
  - **Tính sẵn sàng cao:** Với kiến trúc không có điểm thất bại, Cassandra có thể xử lý lỗi mà không ảnh hưởng toàn bộ hệ thống.
  - **Hiệu suất cao:** Tối ưu cho xử lý dữ liệu lớn với hiệu suất cao.
- **Ứng dụng:** Phù hợp cho các ứng dụng yêu cầu lưu trữ dữ liệu lớn, thời gian thực như IoT, quản lý thông tin doanh nghiệp, và mạng xã hội.

# 1. CAP trong hệ thống phân tán

**CAP** là định lý mô tả ba đặc tính của hệ thống phân tán, chỉ có thể đảm bảo hai trong ba tính chất này cùng lúc:

### 1. Consistency (Nhất quán):

- Tất cả các node đều có cùng một dữ liệu tại mọi thời điểm.

### 2. Availability (Sẵn sàng):

- Hệ thống luôn có thể trả lời các yêu cầu, kể cả khi có lỗi xảy ra.

### 3. Partition Tolerance (Chịu lỗi phân vùng):

- Hệ thống tiếp tục hoạt động dù một số node không thể liên lạc với nhau.

# 2. BASE trong hệ thống phân tán

**BASE** là mô hình thay thế cho ACID trong các hệ thống phân tán lớn, ưu tiên tính sẵn sàng và khả năng chịu lỗi:

### 1. Basically Available (Sẵn sàng cơ bản):

- Hệ thống đảm bảo xử lý yêu cầu nhưng không nhất thiết trả về dữ liệu chính xác.

### 2. Soft State (Trạng thái không cố định):

- Trạng thái có thể thay đổi theo thời gian, ngay cả khi không có yêu cầu mới.

### 3. Eventual Consistency (Nhất quán cuối cùng):

- Dữ liệu cuối cùng sẽ nhất quán sau một khoảng thời gian, nhưng không đảm bảo ngay lập tức.

# 3. ACID trong SQL

**ACID** là một tập hợp các tính chất đảm bảo rằng các giao dịch cơ sở dữ liệu được thực hiện một cách đáng tin cậy và đảm bảo tính toàn vẹn của dữ liệu. ACID bao gồm bốn thuộc tính:

### 1. Atomicity (Tính nguyên tử):

- Một giao dịch phải được thực thi hoàn toàn hoặc không có gì cả. Nếu bất kỳ phần nào thất bại, mọi thay đổi sẽ bị hủy (rollback).

### 2. Consistency (Tính nhất quán):

- Sau mỗi giao dịch, cơ sở dữ liệu phải chuyển từ trạng thái hợp lệ này sang trạng thái hợp lệ khác, đảm bảo các ràng buộc toàn vẹn.

### 3. Isolation (Tính cô lập):

- Các giao dịch phải hoạt động độc lập, không ảnh hưởng đến kết quả của giao dịch khác.

### 4. Durability (Tính bền vững):

- Sau khi giao dịch cam kết, dữ liệu sẽ được lưu trữ vĩnh viễn ngay cả khi có sự cố.

# 4. Ba dạng chuẩn của cơ sở dữ liệu

### Dạng chuẩn thứ nhất (1NF - First Normal Form):

- Mỗi cột chỉ chứa một giá trị nguyên tố.
- Các bản ghi phải là duy nhất.
- Mỗi trường phải có kiểu dữ liệu đồng nhất.

### Dạng chuẩn thứ hai (2NF - Second Normal Form):

- Thỏa mãn điều kiện của 1NF.
- Loại bỏ phụ thuộc một phần (Partial Dependency), nghĩa là các cột không thuộc khóa chính phải phụ thuộc hoàn toàn vào toàn bộ khóa chính.

### Dạng chuẩn thứ ba (3NF - Third Normal Form):

- Thỏa mãn điều kiện của 2NF.
- Loại bỏ phụ thuộc bắc cầu (Transitive Dependency), không có cột không thuộc khóa chính nào phụ thuộc vào cột không thuộc khóa khác.
  """
