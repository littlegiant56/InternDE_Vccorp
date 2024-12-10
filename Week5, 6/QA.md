# Disk Blocks & HDFS Blocks trong Hadoop

## Disk Blocks
Trong hệ thống tệp truyền thống, **disk block** là đơn vị nhỏ nhất để lưu trữ dữ liệu. Nó là một khối dữ liệu có kích thước cố định, thường là 512 byte hoặc 4096 byte, tùy thuộc vào hệ thống tệp và loại đĩa. Các disk block đại diện cho cách dữ liệu được lưu trữ vật lý trên ổ cứng.

### Đặc điểm chính:
- Disk block tồn tại ở cấp độ phần cứng, được hệ điều hành sử dụng để quản lý các tệp trên các đĩa vật lý.
- Chúng có kích thước nhỏ, thường là từ 512 byte đến 4 KB (4096 byte).
- Hệ điều hành truy cập tệp bằng cách đọc và ghi vào các disk block này.
- Phân mảnh có thể xảy ra nếu các tệp không vừa vặn hoàn hảo vào các disk block này.

## HDFS Blocks
Ngược lại, **HDFS block** là đơn vị lưu trữ dữ liệu nhỏ nhất trong HDFS. Một HDFS block là một phần dữ liệu lớn, có kích thước cố định, thường là 64 MB, 128 MB hoặc lớn hơn tùy thuộc vào cấu hình Hadoop. Các khối này là các đơn vị logic mà Hadoop sử dụng để phân phối và quản lý các tập dữ liệu lớn trên nhiều nút trong một cụm.

### Đặc điểm chính:
- HDFS block là các đơn vị logic, không gắn với lưu trữ vật lý bên dưới.
- Kích thước khối mặc định lớn hơn nhiều so với disk block, thường là 128 MB hoặc lớn hơn.
- Hadoop chia các tệp thành các khối lớn này để lưu trữ và xử lý phân tán.
- Mỗi HDFS Block được sao chép trên nhiều nút để đảm bảo tính chịu lỗi.
- Kích thước lớn giúp giảm bớt chi phí quản lý quá nhiều khối, tăng hiệu quả cho các tập dữ liệu lớn.

## Đơn vị nhỏ nhất trên hệ thống Hadoop

Mặc dù cả disk block và HDFS Block đều quan trọng trong hệ sinh thái Hadoop, nhưng **đơn vị nhỏ nhất trên hệ thống Hadoop là HDFS Block**. Điều này là do HDFS xử lý và quản lý dữ liệu ở cấp độ khối, bất kể dữ liệu được lưu trữ vật lý như thế nào trên đĩa. Hệ thống coi các tệp như là các tập hợp của các HDFS Block lớn được phân phối trên nhiều nút, không phải là các disk block nhỏ hơn.

### Kết luận:
- **Disk block** là đơn vị nhỏ nhất trong bối cảnh lưu trữ vật lý, tương tác trực tiếp với phần cứng.
- **HDFS Block** là đơn vị nhỏ nhất trong bối cảnh hệ thống tệp phân tán, được Hadoop sử dụng để quản lý dữ liệu quy mô lớn.


# High Availability (HA) trong Hadoop

High Availability (HA) trong hệ thống Hadoop được thiết kế để giảm thiểu thời gian gián đoạn dịch vụ và bảo vệ dữ liệu quan trọng trước các sự cố không mong muốn. Cơ chế HA trong Hadoop đảm bảo rằng hệ thống vẫn có thể hoạt động bình thường ngay cả khi một thành phần chính bị lỗi, đặc biệt là Namenode, thành phần chịu trách nhiệm quản lý siêu dữ liệu của hệ thống tệp phân tán HDFS.

## Sự phát triển của HA: Secondary Namenode và Standby NameNode

### Secondary Namenode
Trong phiên bản Hadoop 1.x, Secondary Namenode được giới thiệu để giảm tải cho Namenode chính bằng cách lưu giữ một bản sao dữ liệu và thực hiện các nhiệm vụ liên quan đến việc hợp nhất các log chỉnh sửa (edit logs) vào hình ảnh hệ thống (fsimage). Secondary Namenode giúp giảm dung lượng edit logs và giảm tải công việc quản lý siêu dữ liệu.

Tuy nhiên, Secondary Namenode không phải là một nút có thể thay thế hoàn toàn Namenode khi xảy ra lỗi. Nó chỉ có vai trò lưu trữ một bản sao để giúp khởi động lại hệ thống dễ dàng hơn, nhưng không thể xử lý yêu cầu từ người dùng hoặc thực hiện vai trò của một Namenode chính.

### Standby Namenode
Để cải thiện khả năng chịu lỗi của hệ thống, Hadoop 2.x đã giới thiệu cơ chế High Availability thực sự với sự ra đời của Standby Namenode. Standby Namenode hoạt động như một nút sao lưu đầy đủ của Namenode chính, luôn giữ đồng bộ với trạng thái hiện tại của hệ thống thông qua việc sao chép các thay đổi từ log chỉnh sửa. Nếu Namenode chính gặp sự cố, Standby Namenode có thể ngay lập tức đảm nhận vai trò quản lý mà không làm gián đoạn dịch vụ.

Standby Namenode và Active Namenode thường giao tiếp với nhau thông qua giao thức Quorum Journal Manager (QJM), đảm bảo rằng cả hai luôn có cùng trạng thái dữ liệu.

## Chiến lược Replication giữa Hadoop 2.x và 3.x

### Replication trong Hadoop 2.x
Trong Hadoop 2.x, cơ chế replication truyền thống vẫn là cách thức chính để bảo vệ dữ liệu khỏi mất mát. Thông thường, một block dữ liệu sẽ được sao chép thành 3 bản sao, lưu trữ trên các datanode khác nhau trong cụm Hadoop. Việc sao chép này đảm bảo rằng nếu một hoặc hai datanode bị lỗi, dữ liệu vẫn có thể được truy cập từ các bản sao khác.

Cơ chế replication này tuy đáng tin cậy nhưng tốn kém về mặt tài nguyên lưu trữ, vì mỗi block cần được nhân bản nhiều lần.

### Erasure Coding trong Hadoop 3.x
Hadoop 3.x giới thiệu một phương pháp lưu trữ dữ liệu mới có tên là **Erasure Coding**. Khác với cơ chế replication, Erasure Coding chia nhỏ dữ liệu thành các phần và lưu trữ các mã bảo vệ (parity bits). Khi xảy ra lỗi, các parity bits có thể được sử dụng để tái tạo lại dữ liệu bị mất. Erasure Coding giúp giảm đáng kể lượng dung lượng lưu trữ yêu cầu mà vẫn đảm bảo mức độ tin cậy tương đương.

Sự khác biệt lớn nhất giữa replication và Erasure Coding là Erasure Coding tiết kiệm tài nguyên hơn nhưng có độ phức tạp tính toán cao hơn khi cần khôi phục dữ liệu.

# Quá trình thực thi của Transformations và Actions trong Spark

## Transformations

Transformations là các thao tác lười (lazy operations) trong Spark, nghĩa là chúng không được thực thi ngay lập tức mà chỉ được xác định. Mỗi lần gọi một transformation, Spark không thực sự thực thi ngay mà chỉ xây dựng một biểu đồ tính toán (DAG - Directed Acyclic Graph), biểu diễn các phụ thuộc dữ liệu.

Ví dụ về transformations:
- `map()`: Chuyển đổi mỗi phần tử của một tập dữ liệu (RDD, DataFrame) thành một phần tử khác thông qua hàm áp dụng.
- `filter()`: Lọc các phần tử của tập dữ liệu dựa trên điều kiện cho trước.
- `flatMap()`: Tương tự như `map()`, nhưng mỗi phần tử có thể được ánh xạ thành nhiều phần tử.
- `groupBy()`: Gom nhóm các phần tử dựa trên một điều kiện hoặc khóa.

Transformations chỉ được thực thi khi có một Action đi kèm. Spark được coi là hệ thống tính toán lười (lazy evaluation), giúp tối ưu hóa hiệu suất bằng cách giảm thiểu số lượng thao tác thực hiện trên dữ liệu.

## Actions

Actions là các thao tác thực sự kích hoạt quá trình tính toán trong Spark và trả về kết quả cho người dùng hoặc lưu kết quả vào đĩa. Khi một action được gọi, Spark sẽ tính toán toàn bộ biểu đồ tính toán (DAG) được xây dựng từ các transformations.

Ví dụ về actions:
- `collect()`: Thu thập toàn bộ dữ liệu từ các phân vùng và trả về kết quả cho người dùng.
- `count()`: Đếm số lượng phần tử trong tập dữ liệu.
- `reduce()`: Áp dụng hàm hợp nhất (reduce function) trên các phần tử của tập dữ liệu để tạo ra một giá trị duy nhất.
- `saveAsTextFile()`: Lưu kết quả của RDD hoặc DataFrame dưới dạng các tệp văn bản.

# Sự khác nhau giữa Spark DataFrame và DataSet

## DataFrame

DataFrame là một API cung cấp một tập dữ liệu có cấu trúc dưới dạng bảng. DataFrame được thiết kế để hoạt động giống như một bảng trong cơ sở dữ liệu quan hệ (RDBMS) và có thể được truy vấn bằng cú pháp SQL thông qua Spark SQL. DataFrame có thể được tối ưu hóa mạnh mẽ thông qua Catalyst Optimizer - bộ tối ưu hóa truy vấn của Spark.

Tính chất của DataFrame:
- Không kiểm tra kiểu tại thời điểm biên dịch (runtime-type).
- Hỗ trợ các thao tác SQL.
- Được tối ưu hóa bằng Catalyst.

## DataSet

DataSet là một API cao hơn DataFrame, được giới thiệu trong Spark 1.6, và cung cấp cả hai chế độ hoạt động: làm việc với dữ liệu có cấu trúc và dữ liệu không có cấu trúc. DataSet khác biệt so với DataFrame ở chỗ nó hỗ trợ kiểm tra kiểu dữ liệu tại thời điểm biên dịch (compile-time type checking). DataSet kết hợp tính linh hoạt của RDD và hiệu năng cao của DataFrame.

Tính chất của DataSet:
- Kiểm tra kiểu tĩnh (typed) tại thời điểm biên dịch.
- Có thể hoạt động với các loại đối tượng phức tạp.
- Kết hợp ưu điểm của RDD (tính năng kiểm tra kiểu) và DataFrame (tối ưu hóa bằng Catalyst).

| Đặc điểm               | DataFrame                          | DataSet                            |
|------------------------|------------------------------------|------------------------------------|
| Kiểm tra kiểu           | Runtime                           | Compile-time                      |
| Tối ưu hóa              | Catalyst                          | Catalyst                          |
| Kiểu dữ liệu            | Không kiểu tĩnh (untyped)          | Kiểu tĩnh (typed)                  |
| Hiệu suất               | Tối ưu hóa mạnh mẽ                 | Tốt nhưng có độ phức tạp cao hơn   |
| Tính năng               | Hỗ trợ thao tác SQL                | Kết hợp RDD và DataFrame            |

### Khi nào nên sử dụng DataFrame hay DataSet?
- **DataFrame**: Phù hợp khi bạn muốn thao tác trên dữ liệu có cấu trúc và ưu tiên hiệu năng, đặc biệt khi làm việc với khối lượng dữ liệu lớn và các truy vấn SQL.
- **DataSet**: Phù hợp khi bạn cần làm việc với các đối tượng phức tạp và yêu cầu kiểm tra kiểu tại thời điểm biên dịch để phát hiện lỗi sớm trong quá trình phát triển.

