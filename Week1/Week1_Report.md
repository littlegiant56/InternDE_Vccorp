# Chương trình trên áp dụng các nguyên lý của lập trình hướng đối tượng (OOP) qua 4 tính chất cơ bản sau:

## Tính đóng gói (Encapsulation):

Các thuộc tính của lớp `Animal` như `name`, `age`, và `maxLifespan` được khai báo là `private`. Điều này đảm bảo rằng các thuộc tính này chỉ có thể được truy cập và thay đổi thông qua các phương thức getter và setter được cung cấp, thay vì trực tiếp từ bên ngoài lớp. Việc đóng gói giúp bảo vệ dữ liệu và kiểm soát quyền truy cập, từ đó đảm bảo tính toàn vẹn của dữ liệu trong các đối tượng.

## Tính kế thừa (Inheritance):

Các lớp con `Dog` và `Cat` kế thừa từ lớp cha `Animal`. Kế thừa cho phép các lớp con thừa hưởng các thuộc tính và phương thức từ lớp cha, giúp tái sử dụng mã và tránh lặp lại code. Cả `Dog` và `Cat` có thể sử dụng các thuộc tính và phương thức cơ bản của lớp `Animal`, đồng thời có thể định nghĩa thêm các phương thức riêng (như `sound()`).

## Tính đa hình (Polymorphism):

Tính đa hình thể hiện qua việc các lớp con (`Dog`, `Cat`) định nghĩa lại các phương thức của lớp cha (`sound()`). Khi gọi phương thức `sound()` trên một đối tượng `Animal`, chương trình sẽ tự động gọi phương thức phù hợp của lớp con (dựa vào kiểu thực của đối tượng), giúp mã trở nên linh hoạt và dễ mở rộng.

## Tính trừu tượng (Abstraction):

Trừu tượng hóa được thực hiện thông qua việc sử dụng các interface như `Soundable`, `Moveable`, và `Feedable`. Mỗi interface chỉ định các hành vi mà một đối tượng cần thực hiện, mà không cần biết cách triển khai cụ thể của các hành vi đó. Các lớp `Dog` và `Cat` đều phải triển khai các phương thức được định nghĩa trong các interface này.

# Hiểu về các khái niệm Interface, Static, và các khái niệm liên quan

## Interface:

Interface trong Java là một loại lớp trừu tượng hoàn toàn. Nó chỉ chứa các khai báo phương thức mà không chứa phần triển khai. Các lớp cụ thể khi triển khai một interface phải cung cấp phần thân (cụ thể) cho các phương thức được khai báo.
Trong chương trình trên, các interface như `Soundable`, `Moveable`, và `Feedable` được sử dụng để nhóm các hành vi (phương thức) mà các lớp động vật phải triển khai. Interface giúp tách biệt phần khai báo chức năng và phần triển khai, tạo ra một thiết kế hệ thống linh hoạt và dễ mở rộng.
Khi một lớp như `Dog` hoặc `Cat` triển khai interface này, nó buộc phải cung cấp phần triển khai cho phương thức `sound()`.

## Static:

Static là một từ khóa trong Java để chỉ ra rằng một thành viên (biến hoặc phương thức) thuộc về lớp thay vì đối tượng cụ thể của lớp đó.
Các phương thức hoặc biến `static` có thể được gọi trực tiếp bằng tên lớp mà không cần tạo đối tượng. Điều này thường hữu ích khi bạn có các phương thức tiện ích hoặc hằng số chung cho tất cả các đối tượng của lớp.

## Abstract Class (Lớp trừu tượng):

Lớp trừu tượng là lớp không thể tạo đối tượng trực tiếp từ nó, chỉ có thể được kế thừa bởi các lớp con. Lớp trừu tượng có thể chứa cả phương thức có triển khai lẫn phương thức trừu tượng (chưa có triển khai cụ thể).
Trong chương trình, `Animal` không phải là lớp trừu tượng, nhưng bạn có thể biến nó thành một lớp trừu tượng nếu bạn muốn buộc các lớp con phải triển khai các phương thức như `sound()` hay `move()`.

## Polymorphism (Đa hình):

Polymorphism, như đã giải thích ở trên, cho phép gọi cùng một phương thức trên các đối tượng khác nhau, nhưng kết quả thực thi có thể khác nhau tùy thuộc vào lớp cụ thể của đối tượng. Điều này rất hữu ích trong việc tạo ra các hệ thống linh hoạt và dễ mở rộng.

## Inheritance (Kế thừa):

Trong hệ thống này, kế thừa cho phép tái sử dụng mã và tạo ra cấu trúc phân cấp giữa các lớp. `Dog` và `Cat` kế thừa các thuộc tính và hành vi cơ bản từ `Animal`, nhưng chúng có thể ghi đè phương thức `sound()` để đưa ra hành vi cụ thể của mình.

# 5 nguyên tắc SOLID và cách áp dụng vào chương trình quản lý động vật

## Single Responsibility Principle (SRP) - Nguyên tắc đơn nhiệm

Mô tả: Mỗi class chỉ nên có một trách nhiệm duy nhất, tức là một lý do để thay đổi. Điều này giúp dễ dàng quản lý và bảo trì mã nguồn khi thay đổi yêu cầu.
Áp dụng:
Trong chương trình, lớp `Animal` chỉ chịu trách nhiệm quản lý các thông tin và hành vi liên quan đến một con vật (tên, tuổi, tính toán tuổi thọ còn lại, v.v.).
Lớp `AnimalPrinter` chịu trách nhiệm in thông tin động vật, tách biệt hoàn toàn với các chức năng khác của lớp `Animal`.
`AnimalFarm` quản lý danh sách các động vật, thêm/xóa các con vật, nhưng không trực tiếp thao tác với dữ liệu bên trong từng con vật, đảm bảo mỗi lớp chỉ tập trung vào một nhiệm vụ cụ thể.

## Open/Closed Principle (OCP) - Nguyên tắc mở/đóng

Mô tả: Phần mềm nên được thiết kế sao cho có thể mở rộng nhưng không cần sửa đổi mã gốc. Tức là có thể thêm các chức năng mới mà không thay đổi mã đã viết.
Áp dụng:
Các lớp như `Dog`, `Cat` có thể dễ dàng mở rộng bằng cách tạo các lớp con mới mà không cần thay đổi lớp cha `Animal`.
Thêm loài động vật mới chỉ cần tạo lớp mới kế thừa `Animal`, mà không cần sửa đổi trực tiếp mã của `Animal` hay bất kỳ lớp khác trong hệ thống.
Các interface như `Soundable` và `Moveable` giúp mở rộng các hành vi của động vật mà không cần thay đổi mã hiện có.

## Liskov Substitution Principle (LSP) - Nguyên tắc thay thế Liskov

Mô tả: Một đối tượng của lớp con có thể thay thế cho đối tượng của lớp cha mà không làm thay đổi tính đúng đắn của chương trình.
Áp dụng:
`Dog` và `Cat` đều kế thừa từ `Animal` và có thể được sử dụng thay thế cho `Animal` trong mọi ngữ cảnh.
Điều này đảm bảo rằng mọi đối tượng kế thừa từ `Animal` (như `Dog`, `Cat`) có thể được sử dụng mà không làm sai lệch hành vi của hệ thống.

## Interface Segregation Principle (ISP) - Nguyên tắc phân tách interface

Mô tả: Các class không nên bị ép buộc phải triển khai các phương thức mà chúng không sử dụng. Các interface lớn nên được tách ra thành nhiều interface nhỏ có mục đích cụ thể.
Áp dụng:
Chương trình sử dụng các interface riêng biệt như `Soundable`, `Moveable`, và `Feedable` để tách biệt các hành vi khác nhau. Điều này đảm bảo rằng các lớp động vật chỉ cần triển khai các phương thức cần thiết.
Ví dụ, nếu có một loại động vật chỉ phát ra âm thanh nhưng không di chuyển, nó có thể chỉ triển khai interface `Soundable` mà không cần quan tâm đến `Moveable`.

## Dependency Inversion Principle (DIP) - Nguyên tắc đảo ngược sự phụ thuộc

Mô tả: Các module cấp cao không nên phụ thuộc vào các module cấp thấp. Cả hai nên phụ thuộc vào các interface. Điều này giúp giảm sự phụ thuộc trực tiếp giữa các lớp, giúp chương trình dễ bảo trì và thay đổi.
Áp dụng:
Lớp `AnimalManager` sử dụng đối tượng `Soundable` thay vì trực tiếp sử dụng các lớp như `Dog` hay `Cat`. Điều này cho phép hệ thống dễ dàng thay đổi hoặc thêm các đối tượng động vật khác mà không cần sửa đổi `AnimalManager`.
Sử dụng các interface như `Soundable` giúp lớp `AnimalManager` chỉ cần quan tâm đến việc gọi phương thức `sound()`, bất kể đó là chó, mèo hay bất kỳ động vật nào khác.
