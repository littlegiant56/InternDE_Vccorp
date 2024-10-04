#Chương trình trên áp dụng các nguyên lý của lập trình hướng đối tượng (OOP) qua 4 tính chất cơ bản sau:

##Tính đóng gói (Encapsulation):
Các thuộc tính của lớp Animal như name, age, và maxLifespan được khai báo là private. Điều này đảm bảo rằng các thuộc tính này chỉ có thể được truy cập và thay đổi thông qua các phương thức getter và setter được cung cấp, thay vì trực tiếp từ bên ngoài lớp. Việc đóng gói giúp bảo vệ dữ liệu và kiểm soát quyền truy cập, từ đó đảm bảo tính toàn vẹn của dữ liệu trong các đối tượng.
##Tính kế thừa (Inheritance):
Các lớp con Dog và Cat kế thừa từ lớp cha Animal. Kế thừa cho phép các lớp con thừa hưởng các thuộc tính và phương thức từ lớp cha, giúp tái sử dụng mã và tránh lặp lại code. Cả Dog và Cat có thể sử dụng các thuộc tính và phương thức cơ bản của lớp Animal, đồng thời có thể định nghĩa thêm các phương thức riêng (như sound()).
##Tính đa hình (Polymorphism):
Tính đa hình thể hiện qua việc các lớp con (Dog, Cat) định nghĩa lại các phương thức của lớp cha (sound()). Khi gọi phương thức sound() trên một đối tượng Animal, chương trình sẽ tự động gọi phương thức phù hợp của lớp con (dựa vào kiểu thực của đối tượng), giúp mã trở nên linh hoạt và dễ mở rộng.
##Tính trừu tượng (Abstraction):
Trừu tượng hóa được thực hiện thông qua việc sử dụng các interface như Soundable, Moveable, và Feedable. Mỗi interface chỉ định các hành vi mà một đối tượng cần thực hiện, mà không cần biết cách triển khai cụ thể của các hành vi đó. Các lớp Dog và Cat đều phải triển khai các phương thức được định nghĩa trong các interface này.
