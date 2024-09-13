USE master;
DROP DATABASE IF EXISTS QL_SACH;
DROP TABLE IF EXISTS Sach;
DROP TABLE IF EXISTS KhoSach;
DROP TABLE IF EXISTS docGia;
DROP TABLE IF EXISTS muonTra;


CREATE DATABASE QL_SACH;
GO
USE QL_SACH;
GO

CREATE TABLE Sach (
    ma_sach INT PRIMARY KEY IDENTITY(1,1),            
    ten_sach NVARCHAR(255) NOT NULL,    
    ngon_ngu NVARCHAR(255) NOT NULL,
    gia_tri FLOAT,
    so_luong INT,
    tac_gia NVARCHAR(255) NOT NULL,                    
    the_loai NVARCHAR(255) NOT NULL,                    
    nxb NVARCHAR(255) NOT NULL,                        
    nam_xuat_ban int   
);
GO

CREATE TABLE KhoSach (
    ma_kho INT PRIMARY KEY IDENTITY(1,1),           
    ma_sach INT,                       
    vi_tri NVARCHAR(255),               
    so_luong INT,
    ngay_nhap int, 
    ngay_xuat int NULL,
    FOREIGN KEY (ma_sach) REFERENCES Sach(ma_sach) 
);
GO

CREATE TABLE docGia (
    ma_doc_gia INT PRIMARY KEY IDENTITY(1,1),                                 
    ten_doc_gia NVARCHAR(255) NOT NULL,
    ngay_sinh int,
    dia_chi NVARCHAR(255) NOT NULL,
    cmnd VARCHAR(20) NOT NULL,
    sdt VARCHAR(20) NOT NULL,
    chuc_vu TINYINT
);
GO

CREATE TABLE muonTra (
    ma_muon INT PRIMARY KEY IDENTITY(1,1),      
    ma_sach INT,
    ma_doc_gia INT,
    ngay_muon int,
    ngay_hen_tra int,
    ngay_tra int NULL,
    trang_thai TINYINT,
    FOREIGN KEY (ma_sach) REFERENCES Sach(ma_sach),
    FOREIGN KEY (ma_doc_gia) REFERENCES docGia(ma_doc_gia)
);
GO


INSERT INTO Sach (ten_sach, ngon_ngu, gia_tri, so_luong, tac_gia, the_loai, nxb, nam_xuat_ban) VALUES
(N'Lập Trình C Căn Bản', N'Tiếng Việt', 100000, 50, N'Nguyễn Văn A', 'Giáo trình', N'NXB Giáo Dục', 2019),
(N'Học Python Trong 24 Giờ', N'Tiếng Việt', 150000, 30, N'Trần Thị B', 'Giáo trình', N'NXB Trẻ', 2021),
(N'Dế Mèn Phiêu Lưu Ký', N'Tiếng Việt', 50000, 70, N'Tô Hoài', 'Văn học', N'NXB Kim Đồng', 2020);
GO

SELECT * FROM Sach;

INSERT INTO KhoSach (ma_sach, vi_tri, so_luong, ngay_nhap, ngay_xuat) VALUES
(1, N'Kệ A1', 30, 20230101, NULL),
(2, N'Kệ B2', 20, 20230301, NULL),
(3, N'Kệ C3', 40, 20230501, 20230901);
GO


INSERT INTO docGia (ten_doc_gia, ngay_sinh, dia_chi, cmnd, sdt, chuc_vu) VALUES
(N'Nguyễn Văn C', 19900101, N'Hà Nội', '123456789', '0987654321', 0),
(N'Trần Thị D', 19850615, N'TP Hồ Chí Minh', '987654321', '0912345678', 1),
(N'Lê Văn E', 19951230, N'Đà Nẵng', '456123789', '0934567890', 0);
GO


INSERT INTO muonTra (ma_sach, ma_doc_gia, ngay_muon, ngay_hen_tra, ngay_tra, trang_thai) VALUES
(1, 1, 20230801, 20230815, NULL, 0),
(2, 2, 20230905, 20230920, 20230919, 1),
(3, 3, 20230810, 20230825, NULL, 0);
GO
