﻿USE master;
DROP DATABASE IF EXISTS QL_SACH;
DROP TABLE IF EXISTS THU_THU;

CREATE DATABASE QL_SACH;
GO
USE QL_SACH;
GO

-- Bảng Tác giả
CREATE TABLE TAC_GIA (
    ma_tac_gia INT PRIMARY KEY,           
    ten_tac_gia NVARCHAR(255) NOT NULL
);
GO

-- Bảng Thể loại
CREATE TABLE THE_LOAI (
    ma_the_loai INT PRIMARY KEY,           
    ten_the_loai NVARCHAR(255) NOT NULL
);
GO

-- Bảng Sách
CREATE TABLE SACH (
    ma_sach INT PRIMARY KEY,            
    ten_sach NVARCHAR(255) NOT NULL,    
    ngon_ngu NVARCHAR(255) NOT NULL,
    gia_tri FLOAT,
    so_luong INT,
    ma_tac_gia INT,                             
    ma_the_loai INT,                     
    nxb NVARCHAR(255) NOT NULL,                        
    nam_xuat_ban DATE,
    FOREIGN KEY (ma_tac_gia) REFERENCES TAC_GIA(ma_tac_gia),
    FOREIGN KEY (ma_the_loai) REFERENCES THE_LOAI(ma_the_loai)
);
GO

-- Bảng Thủ thư với thêm email và password
CREATE TABLE THU_THU (
    ma_thu_thu INT IDENTITY(1,1) PRIMARY KEY,
    ten_thu_thu NVARCHAR(255) NOT NULL,
    cmnd VARCHAR(20) NOT NULL,
    sdt VARCHAR(20) NOT NULL,
    email NVARCHAR(255) NOT NULL,
    password NVARCHAR(255) NOT NULL
);
GO

SELECT * FROM THU_THU;

-- Bảng Độc giả
CREATE TABLE DOC_GIA (
    ma_doc_gia INT PRIMARY KEY,                                 
    ten_doc_gia NVARCHAR(255) NOT NULL,
    ngay_sinh DATE,
    dia_chi NVARCHAR(255) NOT NULL,
    cmnd VARCHAR(20) NOT NULL,
    sdt VARCHAR(20) NOT NULL
);
GO

-- Bảng Phiếu mượn
CREATE TABLE PHIEU_MUON (
    ma_phieu_muon INT PRIMARY KEY,      
    ma_thu_thu INT,
    ma_doc_gia INT,
    ngay_muon DATE DEFAULT GETDATE(),
    ngay_hen_tra DATE,
    ngay_tra DATE NULL,
	trang_thai TINYINT, -- 0: Đang mượn, 1: Đã trả
    FOREIGN KEY (ma_thu_thu) REFERENCES THU_THU(ma_thu_thu),
    FOREIGN KEY (ma_doc_gia) REFERENCES DOC_GIA(ma_doc_gia)
);
GO

SELECT * FROM PHIEU_MUON;

-- Bảng Chi tiết phiếu mượn
CREATE TABLE CHI_TIET_PHIEU_MUON (
    ma_chi_tiet INT PRIMARY KEY,
    ma_phieu_muon INT,
    ma_sach INT,
    so_luong INT,
    trang_thai TINYINT, -- 0: Đang mượn, 1: Đã trả
    FOREIGN KEY (ma_phieu_muon) REFERENCES PHIEU_MUON(ma_phieu_muon),
    FOREIGN KEY (ma_sach) REFERENCES SACH(ma_sach)
);
GO

-- Thêm dữ liệu vào bảng Tác giả
INSERT INTO TAC_GIA (ma_tac_gia, ten_tac_gia) VALUES
(1,N'Nguyễn Văn A'),
(2,N'Trần Thị B'),
(3,N'Tô Hoài');
GO

SELECT * FROM TAC_GIA;

-- Thêm dữ liệu vào bảng Thể loại
INSERT INTO THE_LOAI (ma_the_loai, ten_the_loai) VALUES
(1,N'Giáo trình'),
(2,N'Văn học');
GO
SELECT * FROM THE_LOAI;

-- Thêm dữ liệu vào bảng Sách
INSERT INTO SACH (ma_sach, ten_sach, ngon_ngu, gia_tri, so_luong, ma_tac_gia, ma_the_loai, nxb, nam_xuat_ban) VALUES
(1,N'Lập Trình C Căn Bản', N'Tiếng Việt', 100000, 50, 1, 1, N'NXB Giáo Dục', '1990-01-01'),
(2,N'Học Python Trong 24 Giờ', N'Tiếng Việt', 150000, 30, 2, 1, N'NXB Trẻ', '1985-06-15'),
(3,N'Dế Mèn Phiêu Lưu Ký', N'Tiếng Việt', 50000, 70, 3, 2, N'NXB Kim Đồng', '1995-12-30');
GO

SELECT  * FROM SACH;

-- Thêm dữ liệu vào bảng Thủ thư
INSERT INTO THU_THU (ten_thu_thu, cmnd, sdt, email, password) VALUES
(N'Nguyễn Văn Thủ Thư', '123456789', '0987654321', 'thu@thu.com', 'thu123');
GO

SELECT * FROM THU_THU;

-- Thêm dữ liệu vào bảng Độc giả
INSERT INTO DOC_GIA (ma_doc_gia, ten_doc_gia, ngay_sinh, dia_chi, cmnd, sdt) VALUES
(1,N'Nguyễn Văn C', '1990-01-01', N'Hà Nội', '123456789', '0987654321'),
(2,N'Trần Thị D', '1985-06-15', N'TP Hồ Chí Minh', '987654321', '0912345678'),
(3,N'Lê Văn E', '1995-12-30', N'Đà Nẵng', '456123789', '0934567890');
GO

SELECT * FROM DOC_GIA;

-- Thêm dữ liệu vào bảng Phiếu mượn
INSERT INTO PHIEU_MUON (ma_phieu_muon, ma_thu_thu, ma_doc_gia, ngay_muon, ngay_hen_tra, ngay_tra, trang_thai) VALUES
(1, 1, 1, '2023-08-01', '2023-08-15', NULL, 0),
(2, 1, 2, '2023-09-05', '2023-09-20', '2023-09-19', 1),
(3, 1, 3, '2023-08-10', '2023-08-25', NULL, 0);
GO

UPDATE PHIEU_MUON
SET ngay_tra = 0
WHERE ngay_tra IS NULL;

-- Cập nhật cột ngày trả trong bảng Phiếu mượn
UPDATE PHIEU_MUON
SET ngay_tra = CASE 
	WHEN ma_phieu_muon = 1 THEN '2024-09-19'
    WHEN ma_phieu_muon = 2 THEN '2023-08-10'
    WHEN ma_phieu_muon = 3 THEN '2024-09-15'
    ELSE ngay_tra
END
WHERE ma_phieu_muon IN (1, 2, 3);
GO

SELECT ma_phieu_muon, ma_thu_thu, ma_doc_gia, ngay_muon, ngay_hen_tra, ngay_tra, 
    CASE 
        WHEN trang_thai = 0 THEN N'Đang mượn'
        WHEN trang_thai = 1 THEN N'Đã trả'
    END AS trang_thai
FROM PHIEU_MUON;

SELECT * FROM PHIEU_MUON;

-- Thêm dữ liệu vào bảng Chi tiết phiếu mượn
INSERT INTO CHI_TIET_PHIEU_MUON (ma_chi_tiet, ma_phieu_muon, ma_sach, so_luong, trang_thai) VALUES
(1, 1, 1, 1, 0),
(2, 2, 2, 1, 1),
(3, 3, 3, 1, 0);
GO

SELECT * FROM CHI_TIET_PHIEU_MUON

DECLARE @keyword NVARCHAR(255) = N'nguye';

SELECT *
FROM SACH s
WHERE CAST(s.ma_sach AS NVARCHAR(255)) LIKE '%' + @keyword + '%'
   OR s.ten_sach LIKE '%' + @keyword + '%'
   OR s.ngon_ngu LIKE '%' + @keyword + '%'
   OR CAST(s.gia_tri AS NVARCHAR(255)) LIKE '%' + @keyword + '%'
   OR CAST(s.so_luong AS NVARCHAR(255)) LIKE '%' + @keyword + '%'
   OR CAST(s.ma_tac_gia AS NVARCHAR(255)) LIKE '%' + @keyword + '%'
   OR CAST(s.ma_the_loai AS NVARCHAR(255)) LIKE '%' + @keyword + '%'
   OR s.nxb LIKE '%' + @keyword + '%'
   OR CAST(s.nam_xuat_ban AS NVARCHAR(255)) LIKE '%' + @keyword + '%';


