
# HDFS: Hệ thống Quản lý Tập tin Phân tán Hadoop

## 1. Filesystem (Hệ thống tập tin)
HDFS (Hadoop Distributed File System) là hệ thống quản lý tập tin phân tán của Hadoop, được thiết kế để lưu trữ dữ liệu lớn trên nhiều máy chủ trong một cụm (cluster). HDFS đảm bảo tính sẵn sàng và khả năng chịu lỗi bằng cách sao chép dữ liệu trên nhiều node khác nhau. Nó cũng được tối ưu hóa để xử lý các tập tin lớn với khả năng truy cập nhanh chóng.

## 2. Disk Blocks & HDFS Blocks (Khối đĩa và khối HDFS)
- **Disk Blocks (Khối đĩa)**: Khi một tập tin được lưu trên đĩa, nó được chia thành các khối nhỏ hơn gọi là **disk blocks**. Kích thước của một khối đĩa thường nằm trong khoảng từ 4KB đến 64KB.
- **HDFS Blocks (Khối HDFS)**: HDFS sử dụng khái niệm **block** tương tự nhưng với kích thước lớn hơn, thường là 128MB hoặc 256MB. Khi một tập tin được lưu trữ trên HDFS, nó sẽ được chia thành các khối lớn và phân phối trên nhiều máy khác nhau trong cụm.

## 3. Block Replication (Sao chép khối)
HDFS đảm bảo tính khả dụng và bảo vệ dữ liệu bằng cách sao chép mỗi khối dữ liệu nhiều lần trên các node khác nhau. Thông thường, mỗi khối sẽ được sao chép **3 lần** (replication factor mặc định là 3):
- Một bản sao sẽ được lưu trữ trên node chính (gọi là Datanode).
- Các bản sao khác sẽ được lưu trữ trên các Datanode khác để đảm bảo nếu một Datanode bị lỗi, dữ liệu vẫn có thể được truy cập từ các bản sao khác.

## 4. Namenode và Datanode
### 4.1. Namenode
- **Namenode** là thành phần quan trọng của HDFS, chịu trách nhiệm quản lý metadata (dữ liệu mô tả) về các tập tin và các khối dữ liệu trên HDFS.
- Nó theo dõi vị trí của từng khối dữ liệu, kích thước và các bản sao của chúng, đồng thời đảm bảo rằng tất cả các yêu cầu đọc/ghi đều được quản lý chính xác.
- Namenode là một điểm trọng yếu, nếu Namenode gặp sự cố, cụm HDFS sẽ không thể hoạt động.

### 4.2. Datanode
- **Datanode** là các node lưu trữ thực tế các khối dữ liệu. Mỗi Datanode quản lý các khối trên hệ thống tập tin cục bộ của nó và thực hiện các tác vụ đọc/ghi dữ liệu khi được yêu cầu.
- Datanode cũng gửi báo cáo định kỳ tới Namenode về tình trạng các khối mà nó đang quản lý.

## 5. Writing and Reading (Ghi và Đọc Dữ liệu)
### 5.1. Ghi dữ liệu (Write)
- Khi một client gửi yêu cầu ghi dữ liệu lên HDFS, Namenode sẽ xác định vị trí lưu trữ các khối và truyền thông tin cho client.
- Client sẽ chia dữ liệu thành các khối và gửi các khối này tới một Datanode.
- Khối dữ liệu đầu tiên được ghi vào Datanode sẽ được sao chép sang các Datanode khác để đảm bảo tính khả dụng.

### 5.2. Đọc dữ liệu (Read)
- Khi client gửi yêu cầu đọc một tập tin, Namenode sẽ trả về danh sách các Datanode chứa các khối dữ liệu tương ứng.
- Client sẽ kết nối trực tiếp với Datanode để truy xuất dữ liệu, không cần phải qua Namenode sau khi đã nhận thông tin về vị trí của các khối.

## 6. High Availability (Khả năng sẵn sàng cao)
- Để tăng tính sẵn sàng của HDFS, hệ thống **High Availability (HA)** được thiết lập, cho phép chạy nhiều Namenode.
- HDFS sử dụng cơ chế **Active Namenode** và **Standby Namenode**:
  - **Active Namenode** xử lý tất cả các yêu cầu truy cập hệ thống từ client.
  - **Standby Namenode** được đồng bộ hóa liên tục với Active Namenode để đảm bảo rằng khi Active Namenode gặp sự cố, Standby Namenode có thể nhanh chóng thay thế mà không làm gián đoạn dịch vụ.
- HDFS HA thường kết hợp với cơ chế **Quorum Journal Manager (QJM)** hoặc các hệ thống lưu trữ phân tán khác để đảm bảo rằng metadata được sao chép đồng bộ trên nhiều thành phần.

