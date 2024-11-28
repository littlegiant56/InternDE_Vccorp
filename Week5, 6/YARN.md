
# YARN: Workflow và Scheduling

## 1. Giới thiệu về YARN
YARN (Yet Another Resource Negotiator) là một thành phần cốt lõi trong kiến trúc Hadoop, quản lý tài nguyên và lập lịch công việc trên một môi trường tính toán phân tán. YARN tách biệt việc quản lý tài nguyên và lập lịch công việc thành các dịch vụ khác nhau, giúp tối ưu hóa việc sử dụng tài nguyên và tăng cường khả năng mở rộng để chạy các ứng dụng phân tán quy mô lớn.

## 2. Workflow của YARN

### 2.1. Gửi yêu cầu ứng dụng
- **Client** gửi một yêu cầu công việc tới YARN Resource Manager.
- Resource Manager phân bổ tài nguyên cho công việc dựa trên các node sẵn có trong cụm.
- **ApplicationMaster (AM)** được khởi chạy để quản lý ứng dụng. AM có nhiệm vụ đàm phán tài nguyên và theo dõi việc thực thi các task trên các node.

### 2.2. Phân bổ tài nguyên
- **Resource Manager (RM)** phân bổ các container trên các node phù hợp để chạy các task.
- **NodeManager (NM)** giám sát việc sử dụng tài nguyên trên các node và báo cáo lại cho RM.
- Container là đơn vị tài nguyên (bộ nhớ, CPU) được cấp phát để thực thi các task của ứng dụng.

### 2.3. Thực thi task
- Các task được thực thi trong các container do NodeManager quản lý.
- ApplicationMaster theo dõi tiến trình và đảm bảo các task bị lỗi sẽ được thực thi lại khi cần thiết.
- Sau khi tất cả các task hoàn thành, ApplicationMaster thông báo với Resource Manager để giải phóng tài nguyên.

### 2.4. Kết thúc workflow
- ApplicationMaster dọn dẹp trạng thái, giải phóng tài nguyên và kết thúc.
- Resource Manager của YARN cập nhật trạng thái công việc là đã hoàn thành.

## 3. Scheduling trong YARN

### 3.1. Resource Manager
Resource Manager là cơ quan trung tâm chịu trách nhiệm lập lịch và phân bổ tài nguyên cho các công việc khác nhau. Nó đảm nhận:
- **Giám sát tài nguyên cụm**: Theo dõi tài nguyên sẵn có (CPU, bộ nhớ) trên các node.
- **Lập lịch công việc**: Dựa trên chính sách và độ ưu tiên, quyết định công việc nào được nhận tài nguyên.

### 3.2. Các loại chính sách lập lịch

#### 3.2.1. FIFO (First-In-First-Out)
- Các công việc được lập lịch theo thứ tự gửi lên.
- Đơn giản, dễ thực hiện nhưng không tối ưu hóa hiệu quả sử dụng tài nguyên.

#### 3.2.2. Capacity Scheduler
- Cho phép nhiều người dùng chia sẻ tài nguyên của cụm.
- Mỗi người dùng được cấp một dung lượng tài nguyên cụ thể (phần trăm tài nguyên), và các công việc được lập lịch trong giới hạn đó.
- Đảm bảo sự công bằng về tài nguyên giữa các người dùng hoặc hàng đợi khác nhau.

#### 3.2.3. Fair Scheduler
- Đảm bảo rằng tất cả các ứng dụng nhận được một phần tài nguyên công bằng theo thời gian.
- Các công việc yêu cầu nhiều tài nguyên có thể nhận thêm tạm thời, nhưng sự công bằng được đảm bảo về lâu dài.
- Hỗ trợ **preemption**, cho phép Resource Manager lấy lại tài nguyên từ một công việc đang chạy và phân bổ cho công việc khác để duy trì sự công bằng.

### 3.3. Preemption trong lập lịch
- Preemption cho phép Resource Manager thu hồi tài nguyên từ các ứng dụng đang chạy để đáp ứng yêu cầu tài nguyên của các công việc có độ ưu tiên cao.
- Điều này đảm bảo rằng các công việc quan trọng không phải chờ đợi quá lâu để có tài nguyên.

### 3.4. Thách thức trong lập lịch
- **Phân mảnh tài nguyên**: Khi tài nguyên bị sử dụng không hiệu quả do lập lịch không tối ưu (ví dụ: các công việc chờ đợi cấu hình tài nguyên cụ thể).
- **Cân bằng giữa công bằng và hiệu quả**: Khó khăn trong việc cân bằng giữa phân bổ tài nguyên công bằng và tối ưu hóa hiệu quả sử dụng tài nguyên.
- **Khả năng mở rộng**: Khi số lượng công việc tăng lên, việc lập lịch và phân bổ tài nguyên trở nên phức tạp hơn.
