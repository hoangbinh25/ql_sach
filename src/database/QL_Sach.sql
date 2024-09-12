USE master
DROP DATABASE IF EXISTS QL_SACH;
DROP TABLE IF EXISTS TacGia;
DROP TABLE IF EXISTS TheLoai;
DROP TABLE IF EXISTS NhaXuatBan;
DROP TABLE IF EXISTS Sach;
DROP TABLE IF EXISTS KhoSach;


CREATE DATABASE QL_SACH
GO
USE QL_SACH
GO

-- Tạo bảng Tác Giả (TacGia)
CREATE TABLE TacGia (
    ma_tac_gia INT PRIMARY KEY IDENTITY(1,1),        -- Mã tác giả (khóa chính)
    ten_tac_gia NVARCHAR(255) NOT NULL -- Tên tác giả
);
GO
-- Tạo bảng Thể Loại (TheLoai)
CREATE TABLE TheLoai (
    ma_the_loai INT PRIMARY KEY IDENTITY(1,1),        -- Mã thể loại (khóa chính)
    ten_the_loai NVARCHAR(255) NOT NULL -- Tên thể loại (ví dụ: Khoa học, Văn học)
);
GO
-- Tạo bảng Nhà Xuất Bản (NhaXuatBan)
CREATE TABLE NhaXuatBan (
    ma_nxb INT PRIMARY KEY IDENTITY(1,1),             -- Mã nhà xuất bản (khóa chính)
    ten_nxb NVARCHAR(255) NOT NULL,      -- Tên nhà xuất bản
    dia_chi NVARCHAR(255) NULL                -- Địa chỉ nhà xuất bản (tùy chọn)
);
GO

-- Tạo bảng Sách (Sach)
CREATE TABLE Sach (
    ma_sach INT PRIMARY KEY IDENTITY(1,1),            -- Mã sách (khóa chính)
    ten_sach NVARCHAR(255) NOT NULL,     -- Tên sách
    ma_tac_gia INT,                     -- Mã tác giả (khóa ngoại)
    ma_the_loai INT,                    -- Mã thể loại (khóa ngoại)
    ma_nxb INT,                         -- Mã nhà xuất bản (khóa ngoại)
    nam_xuat_ban Date,                   -- Năm xuất bản                 
    FOREIGN KEY (ma_tac_gia) REFERENCES TacGia(ma_tac_gia),    -- Khóa ngoại tham chiếu đến bảng TacGia
    FOREIGN KEY (ma_the_loai) REFERENCES TheLoai(ma_the_loai), -- Khóa ngoại tham chiếu đến bảng TheLoai
    FOREIGN KEY (ma_nxb) REFERENCES NhaXuatBan(ma_nxb)         -- Khóa ngoại tham chiếu đến bảng NhaXuatBan
);
GO
-- Tạo bảng Kho Sách (KhoSach)
CREATE TABLE KhoSach (
    ma_kho INT PRIMARY KEY IDENTITY(1,1),             -- Mã kho (khóa chính)
    ma_sach INT,                        -- Mã sách (khóa ngoại)
    vi_tri NVARCHAR(255),                -- Vị trí lưu trữ của sách trong kho
	so_luong INT,
	ngay_nhap date, 
	ngay_xuat date NULL,
    FOREIGN KEY (ma_sach) REFERENCES Sach(ma_sach)  -- Khóa ngoại tham chiếu đến bảng Sach
);
GO
CREATE TABLE TaiKhoan (
    ma_tai_khoan INT PRIMARY KEY IDENTITY(1,1),  -- Mã người dùng (khóa chính và tự động tăng)
    ten_tai_khoan NVARCHAR(255) NOT NULL,        -- Tên người dùng
    mat_khau NVARCHAR(255) NOT NULL,              -- Mật khẩu người dùng
    email NVARCHAR(255) NOT NULL,                 -- Email người dùng
    CONSTRAINT UQ_email UNIQUE (email)            -- Ràng buộc duy nhất cho cột email (email không được trùng)
);
GO
-- Chèn dữ liệu vào bảng Tác Giả (TacGia)
INSERT INTO TacGia (ten_tac_gia) VALUES
(N'Nguyễn Nhật Ánh'),
(N'J.K. Rowling'),
(N'George Orwell'),
(N'Stephen King');
GO
-- Chèn dữ liệu vào bảng Thể Loại (TheLoai)
INSERT INTO TheLoai (ten_the_loai) VALUES
(N'Văn học'),
(N'Khoa học'),
(N'Lịch sử'),
(N'Kỹ thuật'),
(N'Giáo dục');
GO
-- Chèn dữ liệu vào bảng Nhà Xuất Bản (NhaXuatBan)
INSERT INTO NhaXuatBan (ten_nxb, dia_chi) VALUES
(N'Nhà xuất bản Kim Đồng', N'Hà Nội'),
(N'Nhà xuất bản Trẻ', N'TP. Hồ Chí Minh'),
(N'Nhà xuất bản Lao Động', N'Hà Nội'),
(N'Nhà xuất bản Phụ Nữ', N'Hà Nội');
GO
-- Chèn dữ liệu vào bảng Sách (Sach)
INSERT INTO Sach (ten_sach, ma_tac_gia, ma_the_loai, ma_nxb, nam_xuat_ban) VALUES
(N'Mắt Biếcc', 1, 1, 1, '03-12-2012'),
(N'Harry Potter và Hòn Đá Phù Thủy', 2, 1, 2, '1997-4-2'),
(N'1984', 3, 3, 3, '1949-6-1'),
(N'Làm Thế Nào Để Thành Công Trong Cuộc Sống', 4, 5, 4, '2020-4-2');
GO
-- Chèn dữ liệu vào bảng Kho Sách (KhoSach)
INSERT INTO KhoSach (ma_sach, vi_tri) VALUES
(1, N'Kệ A1'),
(2, N'Kệ B3'),
(3, N'Kệ C2'),
(4, N'Kệ D4');
GO
-- Chèn dữ liệu mẫu vào bảng TaiKhoan
INSERT INTO TaiKhoan(ten_tai_khoan, mat_khau, email) VALUES
(N'user1', N'123', N'nguyenvana@example.com'),
(N'user2', N'123', N'tranthib@example.com')
GO

SELECT * FROM Sach;

SELECT * FROM TaiKhoan;

SELECT * FROM NhaXuatBan;

SELECT * FROM KhoSach;