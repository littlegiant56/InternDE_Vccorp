# Lệnh cơ bản trong Linux và Quản lý tiến trình

## 1. Các lệnh cơ bản

### cd (Thay đổi thư mục)
- **Cú pháp**: `cd [thư_mục]`
- Chuyển thư mục hiện tại sang thư mục được chỉ định.
- **Ví dụ**:
  - `cd /home/user`: Di chuyển đến thư mục home của người dùng.
  - `cd ..`: Lùi lên một cấp trong cấu trúc thư mục.
  - `cd ~`: Chuyển đến thư mục home.

### ls (Liệt kê)
- **Cú pháp**: `ls [tùy_chọn] [thư_mục]`
- Liệt kê các tệp và thư mục trong thư mục được chỉ định.
- **Ví dụ**:
  - `ls`: Hiển thị nội dung của thư mục hiện tại.
  - `ls -l`: Hiển thị thông tin chi tiết, bao gồm quyền truy cập, quyền sở hữu và kích thước.

### cp (Sao chép)
- **Cú pháp**: `cp [nguồn] [đích]`
- Sao chép các tệp hoặc thư mục từ nguồn đến đích.
- **Ví dụ**:
  - `cp file.txt /home/user/`: Sao chép `file.txt` vào thư mục `/home/user/`.

### mv (Di chuyển)
- **Cú pháp**: `mv [nguồn] [đích]`
- Di chuyển hoặc đổi tên tệp và thư mục.
- **Ví dụ**:
  - `mv oldname.txt newname.txt`: Đổi tên `oldname.txt` thành `newname.txt`.
  - `mv file.txt /home/user/`: Di chuyển `file.txt` vào `/home/user/`.

### mkdir (Tạo thư mục)
- **Cú pháp**: `mkdir [tên_thư_mục]`
- Tạo thư mục mới với tên được chỉ định.
- **Ví dụ**:
  - `mkdir new_folder`: Tạo thư mục có tên `new_folder`.

### cat (Nối)
- **Cú pháp**: `cat [tệp]`
- Hiển thị nội dung của tệp.
- **Ví dụ**:
  - `cat file.txt`: Hiển thị nội dung của `file.txt`.

### head (Đầu tệp)
- **Cú pháp**: `head [tùy_chọn] [tệp]`
- Hiển thị vài dòng đầu của tệp (mặc định: 10 dòng).
- **Ví dụ**:
  - `head file.txt`: Hiển thị 10 dòng đầu của `file.txt`.

## 2. Các lệnh về quyền truy cập

### chmod (Thay đổi quyền)
- **Cú pháp**: `chmod [tùy_chọn] [quyền] [tệp]`
- Thay đổi quyền truy cập của tệp hoặc thư mục.
- **Ví dụ**:
  - `chmod 755 script.sh`: Đặt quyền đọc, ghi và thực thi cho chủ sở hữu, quyền đọc và thực thi cho người khác.

### chown (Thay đổi chủ sở hữu)
- **Cú pháp**: `chown [chủ_sở_hữu][:nhóm] [tệp]`
- Thay đổi chủ sở hữu của tệp hoặc thư mục.
- **Ví dụ**:
  - `chown user:usergroup file.txt`: Thay đổi chủ sở hữu của `file.txt` thành `user` và nhóm `usergroup`.

### ls -l (Liệt kê với quyền)
- **Cú pháp**: `ls -l`
- Hiển thị danh sách chi tiết các tệp và thư mục, bao gồm quyền truy cập.
- **Ví dụ**:
  - `ls -l`: Hiển thị tệp cùng với quyền truy cập, quyền sở hữu và các chi tiết khác.

## 3. Thực thi song song

### Pipe (`|`)
- Kết hợp nhiều lệnh để thực thi song song.
- **Ví dụ**:
  - `cat test.txt | wc -l`: Đếm số dòng trong `test.txt`.
  - `cat test.txt | grep "a"`: Tìm kiếm ký tự `a` trong `test.txt`.
  - `cat test.txt | head`: Hiển thị 10 dòng đầu của `test.txt`.

### Chuyển hướng (`>`, `>>`)
- Chuyển hướng đầu ra vào một tệp.
- **Ví dụ**:
  - `echo "aabb" > test.txt`: Ghi đè `test.txt` với văn bản `aabb`.
  - `echo "cc" >> test.txt`: Thêm văn bản `cc` vào `test.txt`.

## 4. Sử dụng vim (Trình soạn thảo văn bản)

### Tạo và chỉnh sửa tệp
- **Cú pháp**: `vim [tệp]`
- Mở hoặc tạo tệp để chỉnh sửa trong vim.
- **Ví dụ**:
  - `vim newfile.txt`: Mở `newfile.txt` để chỉnh sửa, tạo tệp nếu nó chưa tồn tại.

### Các lệnh phổ biến trong vim
- `i`: Chế độ chèn để chỉnh sửa.
- `:w`: Lưu tệp.
- `:q`: Thoát vim.
- `:wq`: Lưu và thoát.
- `:q!`: Thoát không lưu.

## 5. Quản lý tiến trình

### htop (Trình xem tiến trình tương tác)
- **Cú pháp**: `htop`
- Hiển thị chế độ xem tương tác của các tiến trình hệ thống cùng với sử dụng CPU và bộ nhớ.

### ps aux (Trạng thái tiến trình)
- **Cú pháp**: `ps aux`
- Hiển thị thông tin chi tiết về các tiến trình đang chạy.

### kill -9 (Kết thúc tiến trình)
- **Cú pháp**: `kill -9 [PID]`
- Buộc kết thúc tiến trình với PID (Process ID) được chỉ định.

