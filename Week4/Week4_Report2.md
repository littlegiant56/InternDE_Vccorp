# Các phương pháp tối ưu hóa SQL

1. **Tránh đưa mệnh đề HAVING trong lệnh SELECT**

   - **Truy vấn gốc**: Dùng HAVING để lọc các giá trị sau khi đã nhóm (GROUP BY), làm việc lọc chậm hơn.
     ```sql
     SELECT s.cust_id, count(s.cust_id)
     FROM SH.sales s
     GROUP BY s.cust_id
     HAVING s.cust_id != '1660' AND s.cust_id != '2';
     ```
   - **Truy vấn đã cải thiện**: Chuyển điều kiện lọc sang WHERE trước khi nhóm, giúp cơ sở dữ liệu xử lý nhanh hơn vì không cần đợi nhóm dữ liệu xong mới lọc.
     ```sql
     SELECT s.cust_id, count(cust_id)
     FROM SH.sales s
     WHERE s.cust_id != '1660' AND s.cust_id != '2'
     GROUP BY s.cust_id;
     ```

2. **Loại bỏ các mệnh đề DISTINCT không cần thiết**

   - **Truy vấn gốc**: Sử dụng DISTINCT để loại bỏ các hàng trùng lặp trong một bảng có khóa chính, làm tăng chi phí so sánh và lọc.
     ```sql
     SELECT DISTINCT *
     FROM SH.sales s
     JOIN SH.customers c ON s.cust_id = c.cust_id
     WHERE c.cust_marital_status = 'single';
     ```
   - **Truy vấn đã cải thiện**: Bỏ DISTINCT vì bảng đã có khóa chính, giúp giảm tải cho cơ sở dữ liệu.
     ```sql
     SELECT *
     FROM SH.sales s
     JOIN SH.customers c ON s.cust_id = c.cust_id
     WHERE c.cust_marital_status = 'single';
     ```

3. **Sử dụng mệnh đề IN khi truy vấn một cột đã được đánh index**

   - **Truy vấn gốc**: Sử dụng OR cho nhiều điều kiện khiến cơ sở dữ liệu phải kiểm tra nhiều điều kiện riêng lẻ.
     ```sql
     SELECT s.*
     FROM SH.sales s
     WHERE s.prod_id = 14 OR s.prod_id = 17;
     ```
   - **Truy vấn đã cải thiện**: Sử dụng IN, giúp cơ sở dữ liệu tối ưu hóa việc tìm kiếm với các giá trị đã đánh index, cải thiện hiệu suất.
     ```sql
     SELECT s.*
     FROM SH.sales s
     WHERE s.prod_id IN (14, 17);
     ```

4. **Sử dụng EXISTS thay cho DISTINCT khi kết nối các bảng có một hoặc nhiều liên kết**

   - **Truy vấn gốc**: Sử dụng DISTINCT để loại bỏ trùng lặp giữa các bảng khi join, tốn thêm chi phí lọc.
     ```sql
     SELECT DISTINCT c.country_id, c.country_name
     FROM SH.countries c, SH.customers e
     WHERE e.country_id = c.country_id;
     ```
   - **Truy vấn đã cải thiện**: Dùng EXISTS để kiểm tra sự tồn tại của dữ liệu trong bảng liên kết, tránh việc trả về tất cả các hàng và loại bỏ trùng lặp.
     ```sql
     SELECT c.country_id, c.country_name
     FROM SH.countries c
     WHERE EXISTS (SELECT 'X'
                   FROM SH.customers e
                   WHERE e.country_id = c.country_id);
     ```

5. **Tránh đặt hàm số bên phải của toán tử so sánh**

   - **Truy vấn gốc**: Sử dụng hàm EXTRACT trong điều kiện lọc làm chậm việc tìm kiếm vì không thể tận dụng index.
     ```sql
     SELECT *
     FROM SH.sales
     WHERE EXTRACT(YEAR FROM TO_DATE(time_id, 'DDMON-RR')) = 2001
     AND EXTRACT(MONTH FROM TO_DATE(time_id, 'DD-MON-RR')) = 12;
     ```
   - **Truy vấn đã cải thiện**: Chuyển việc so sánh thành một dãy BETWEEN với TRUNC, tận dụng được index, giúp cải thiện tốc độ.
     ```sql
     SELECT *
     FROM SH.sales
     WHERE TRUNC(time_id)
     BETWEEN TRUNC(TO_DATE('12/01/2001', 'MM/DD/YYYY'))
     AND TRUNC(TO_DATE('12/30/2001', 'MM/DD/YYYY'));
     ```

6. **Tránh sử dụng OR trong các mệnh đề thỏa mãn nhiều điều kiện**

   - **Truy vấn gốc**: Sử dụng OR làm cơ sở dữ liệu phải thực hiện nhiều phép kiểm tra riêng lẻ, gây chậm.
     ```sql
     SELECT *
     FROM SH.costs c
     INNER JOIN SH.products p
     ON c.unit_price = p.prod_min_price OR c.unit_price = p.prod_list_price;
     ```
   - **Truy vấn đã cải thiện**: Thay bằng UNION ALL, cho phép cơ sở dữ liệu chạy từng truy vấn riêng biệt một cách nhanh hơn mà không cần kiểm tra trùng lặp (như UNION).
     ```sql
     SELECT *
     FROM SH.costs c
     INNER JOIN SH.products p
     ON c.unit_price = p.prod_min_price
     UNION ALL
     SELECT *
     FROM SH.costs c
     INNER JOIN SH.products p
     ON c.unit_price = p.prod_list_price;
     ```

7. **Sử dụng chỉ mục đúng cách**

   - **Truy vấn gốc**: Không sử dụng chỉ mục trên các cột thường xuyên tham gia vào điều kiện WHERE, dẫn đến việc quét toàn bộ bảng, tốn thời gian và tài nguyên.
     ```sql
     SELECT *
     FROM SH.sales
     WHERE cust_id = '1001';
     ```
   - **Truy vấn đã cải thiện**: Tạo chỉ mục trên các cột thường xuyên sử dụng trong điều kiện WHERE, giúp truy vấn nhanh hơn nhờ việc tận dụng chỉ mục.
     ```sql
     CREATE INDEX idx_sales_cust_id ON SH.sales(cust_id);
     SELECT *
     FROM SH.sales
     WHERE cust_id = '1001';
     ```

8. **Tránh sử dụng SELECT \* để lấy toàn bộ cột**

   - **Truy vấn gốc**: Dùng SELECT \* để lấy toàn bộ các cột từ bảng, gây lãng phí băng thông và tài nguyên xử lý khi không cần tất cả các cột.
     ```sql
     SELECT *
     FROM SH.sales
     WHERE prod_id = '101';
     ```
   - **Truy vấn đã cải thiện**: Chỉ chọn những cột cần thiết giúp giảm tải dữ liệu, tăng hiệu quả truy vấn.
     ```sql
     SELECT cust_id, sale_date
     FROM SH.sales
     WHERE prod_id = '101';
     ```

9. **Sử dụng LIMIT để giới hạn kết quả**

   - **Truy vấn gốc**: Truy vấn trả về toàn bộ kết quả từ bảng khi chỉ cần một số lượng nhỏ, làm tốn tài nguyên và thời gian xử lý không cần thiết.
     ```sql
     SELECT *
     FROM SH.sales
     ORDER BY sale_date DESC;
     ```
   - **Truy vấn đã cải thiện**: Dùng LIMIT để chỉ lấy một số lượng kết quả nhất định, giúp truy vấn nhanh hơn và tiết kiệm tài nguyên.
     ```sql
     SELECT *
     FROM SH.sales
     ORDER BY sale_date DESC LIMIT 10;
     ```

10. **Sử dụng JOIN thay vì subquery**

- **Truy vấn gốc**: Sử dụng subquery (truy vấn con) để lọc dữ liệu, gây chậm hiệu suất vì cơ sở dữ liệu phải thực hiện nhiều truy vấn con lồng nhau.
  ```sql
  SELECT *
  FROM SH.sales
  WHERE cust_id IN (SELECT cust_id FROM SH.customers WHERE country = 'US');
  ```
- **Truy vấn đã cải thiện**: Thay subquery bằng JOIN, giúp cơ sở dữ liệu tối ưu hóa quá trình kết nối giữa các bảng.
  ```sql
  SELECT s.*
  FROM SH.sales s
  JOIN SH.customers c ON s.cust_id = c.cust_id
  WHERE c.country = 'US';
  ```
