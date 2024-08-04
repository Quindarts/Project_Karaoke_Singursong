# Karaoke Sing Ur Song - Hệ thống Quản lý Karaoke

## Giới thiệu

**Karaoke Sing Ur Song** là một hệ thống quản lý karaoke được phát triển bằng Java Swing. Hệ thống này được thiết kế với giao diện người dùng hiện đại và trực quan, sử dụng các hiệu ứng icon đẹp mắt để nâng cao trải nghiệm người dùng. Dự án cung cấp các chức năng mạnh mẽ để quản lý phòng karaoke, bao gồm thống kê, thanh toán nhiều phòng, tách hóa đơn, xuất hóa đơn, và quản lý dịch vụ cho nhiều phòng.

![image](https://github.com/user-attachments/assets/6e76c4eb-6c28-4a1d-ace7-efe1a6c91f87)

![image](https://github.com/user-attachments/assets/6359e52e-bc35-437b-b5de-856744ae8509)

![image](https://github.com/user-attachments/assets/c97d4640-9eb2-4905-9a1b-e7c87f27707b)


## Các tính năng

### 🎯 Thống kê
- **Báo cáo chi tiết**: Cung cấp báo cáo chi tiết về việc sử dụng phòng, doanh thu hàng ngày và dịch vụ.
- **Biểu đồ & Số liệu**: Hiển thị biểu đồ và số liệu thống kê với hiệu ứng icon đẹp mắt giúp dễ dàng phân tích và theo dõi.
  

### 💳 Thanh toán nhiều phòng
- **Thanh toán đồng thời**: Cho phép thanh toán cho nhiều phòng cùng lúc với giao diện thanh toán hiện đại.
- **Nhiều phương thức thanh toán**: Hỗ trợ nhiều phương thức thanh toán với các icon tương ứng để dễ dàng lựa chọn.

### 📜 Tách hóa đơn
- **Hóa đơn linh hoạt**: Hỗ trợ tách hóa đơn cho từng phòng hoặc nhóm khách hàng.
- **Chỉnh sửa dễ dàng**: Giao diện người dùng cho phép chỉnh sửa và phân chia chi phí với các icon rõ ràng để biểu thị các tùy chọn.

### 📑 Xuất hóa đơn
- **Xuất PDF**: Cho phép xuất hóa đơn dưới định dạng PDF, hỗ trợ lưu trữ và báo cáo.
- **Tùy chỉnh mẫu hóa đơn**: Tùy chỉnh mẫu hóa đơn để phù hợp với nhu cầu của bạn, với các hiệu ứng icon đẹp trong giao diện xuất hóa đơn.

### 🛠️ Quản lý dịch vụ nhiều phòng
- **Theo dõi dịch vụ**: Quản lý và theo dõi các dịch vụ được cung cấp cho từng phòng karaoke.
- **Giao diện quản lý**: Giao diện quản lý dịch vụ được trang bị các icon và hiệu ứng để giúp theo dõi dễ dàng và hiệu quả.

### 🚀 Công nghệ và Thư viện Sử dụng

## Java Swing: 
Cung cấp các thành phần giao diện đồ họa để xây dựng ứng dụng desktop với trải nghiệm người dùng mượt mà.

## FlatLaf: flatlaf-3.2.jar 
- Thư viện giao diện người dùng cho Swing với phong cách phẳng, mang lại giao diện hiện đại và dễ nhìn.

## Apache Commons:

commons-codec-1.15.jar - Thư viện mã hóa và giải mã dữ liệu.
commons-collections4-4.1.jar - Các lớp tiện ích cho xử lý tập hợp và cấu trúc dữ liệu.
commons-io-2.7.jar - Công cụ hỗ trợ thao tác với luồng dữ liệu và tệp.
commons-logging-1.2.jar - API cho logging, giúp ghi lại các thông điệp và lỗi.

## Jackson:

jackson-core-2.14.0.jar - Cung cấp các công cụ cơ bản để phân tích và xử lý JSON.
jackson-databind-2.14.0.jar - Hỗ trợ ánh xạ dữ liệu JSON vào các đối tượng Java.
jackson-dataformat-xml-2.14.0.jar - Xử lý dữ liệu XML với Jackson.
jackson-datatype-jsr310-2.14.0.jar - Hỗ trợ ánh xạ các kiểu dữ liệu ngày tháng từ Java 8.
iTextPDF: itextpdf-5.5.13.2.jar - Thư viện tạo và xử lý tài liệu PDF.

## Apache POI:

poi-3.17.jar - Thư viện để đọc và ghi các định dạng tài liệu Microsoft Office.
poi-ooxml-3.17.jar - Hỗ trợ định dạng Office Open XML (tệp DOCX, XLSX).
poi-ooxml-schemas-3.17.jar - Cung cấp các lược đồ XML cho POI.
JWT:

jjwt-api-0.11.2.jar - API cho JSON Web Tokens (JWT).
jjwt-impl-0.11.2.jar - Cung cấp các triển khai cho JWT.
jjwt-jackson-0.11.2.jar - Tích hợp Jackson với JWT để xử lý JSON.

## Mail:

javax.mail.jar - Cung cấp API để gửi và nhận email.
mail.jar - Thư viện hỗ trợ gửi và nhận email.
mailapi-1.5.0.jar - API cho các chức năng liên quan đến email.

## Cài đặt

### 🖥️ Yêu cầu hệ thống

- **Java Development Kit (JDK)**: 11 hoặc cao hơn
- **IDE hỗ trợ Java**: Eclipse, IntelliJ IDEA, NetBeans, v.v.

### 🔧 Cài đặt dự án

1. **Tải mã nguồn**

   - Clone hoặc tải mã nguồn từ kho GitHub:

   ```bash
   git clone https://github.com/yourusername/karaoke-sing-ur-song.git
