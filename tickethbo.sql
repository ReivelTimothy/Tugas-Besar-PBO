-- phpMyAdmin SQL Dump
-- version 5.2.1
-- https://www.phpmyadmin.net/
--
-- Host: 127.0.0.1
-- Waktu pembuatan: 05 Jan 2025 pada 11.03
-- Versi server: 10.4.32-MariaDB
-- Versi PHP: 8.0.30

SET SQL_MODE = "NO_AUTO_VALUE_ON_ZERO";
START TRANSACTION;
SET time_zone = "+00:00";


/*!40101 SET @OLD_CHARACTER_SET_CLIENT=@@CHARACTER_SET_CLIENT */;
/*!40101 SET @OLD_CHARACTER_SET_RESULTS=@@CHARACTER_SET_RESULTS */;
/*!40101 SET @OLD_COLLATION_CONNECTION=@@COLLATION_CONNECTION */;
/*!40101 SET NAMES utf8mb4 */;

--
-- Database: `tickethbo`
--

-- --------------------------------------------------------

--
-- Struktur dari tabel `admin`
--

CREATE TABLE `admin` (
  `admin_id` int(11) NOT NULL,
  `admin_name` varchar(255) DEFAULT NULL,
  `password` varchar(255) DEFAULT NULL,
  `email` varchar(255) DEFAULT NULL,
  `phoneNum` varchar(20) DEFAULT NULL
) ENGINE=InnoDB DEFAULT CHARSET=latin1 COLLATE=latin1_swedish_ci;

--
-- Dumping data untuk tabel `admin`
--

INSERT INTO `admin` (`admin_id`, `admin_name`, `password`, `email`, `phoneNum`) VALUES
(1, 'Admin1', 'admin123', 'admin1@example.com', '1234567890'),
(2, 'Admin2', 'admin456', 'admin2@example.com', '0987654321');

-- --------------------------------------------------------

--
-- Struktur dari tabel `block`
--

CREATE TABLE `block` (
  `block_id` int(11) NOT NULL,
  `block_Reason` varchar(255) DEFAULT NULL,
  `seller_id` int(11) DEFAULT NULL,
  `cust_id` int(11) DEFAULT NULL
) ENGINE=InnoDB DEFAULT CHARSET=latin1 COLLATE=latin1_swedish_ci;

--
-- Dumping data untuk tabel `block`
--

INSERT INTO `block` (`block_id`, `block_Reason`, `seller_id`, `cust_id`) VALUES
(1, 'Aktivitas penipuan', NULL, 3),
(2, 'Perilaku mencurigakan', NULL, 4);

-- --------------------------------------------------------

--
-- Struktur dari tabel `cart`
--

CREATE TABLE `cart` (
  `cart_id` int(11) NOT NULL,
  `event_id` int(11) DEFAULT NULL,
  `ticket_id` int(11) DEFAULT NULL,
  `cust_id` int(11) DEFAULT NULL
) ENGINE=InnoDB DEFAULT CHARSET=latin1 COLLATE=latin1_swedish_ci;

-- --------------------------------------------------------

--
-- Struktur dari tabel `customer`
--

CREATE TABLE `customer` (
  `cust_id` int(11) NOT NULL,
  `cust_name` varchar(255) DEFAULT NULL,
  `password` varchar(255) DEFAULT NULL,
  `email` varchar(255) DEFAULT NULL,
  `phoneNum` varchar(20) DEFAULT NULL,
  `cardNumber` varchar(50) DEFAULT NULL,
  `Membership` enum('Active','Inactive') DEFAULT NULL,
  `Balance` double DEFAULT NULL,
  `block` enum('Blocked','Unblock') DEFAULT 'Unblock'
) ENGINE=InnoDB DEFAULT CHARSET=latin1 COLLATE=latin1_swedish_ci;

--
-- Dumping data untuk tabel `customer`
--

INSERT INTO `customer` (`cust_id`, `cust_name`, `password`, `email`, `phoneNum`, `cardNumber`, `Membership`, `Balance`, `block`) VALUES
(1, NULL, '123', 'mario', NULL, NULL, NULL, NULL, 'Unblock'),
(2, 'mario', '456', 'mario@crypto.com', '081122334455', NULL, NULL, NULL, 'Unblock'),
(3, 'John Doe', 'pass123', 'johndoe@email.com', '08123456789', '1234567890', '', 5000, 'Blocked'),
(4, 'Alice Smith', 'pass456', 'alice@crypto.com', '08223456789', '2345678901', '', 15000, 'Blocked'),
(5, 'Bob Brown', 'pass789', 'bob.brown@domain.com', '08323456789', '3456789012', '', 25000, 'Unblock'),
(6, 'Charlie Lee', 'pass101', 'charlie.lee@domain.com', '08423456789', '4567890123', '', 12000, 'Unblock');

-- --------------------------------------------------------

--
-- Struktur dari tabel `events`
--

CREATE TABLE `events` (
  `event_id` int(11) NOT NULL,
  `judul` varchar(255) DEFAULT NULL,
  `Singer` varchar(30) DEFAULT NULL,
  `Genre` varchar(30) DEFAULT NULL,
  `SportType` varchar(30) DEFAULT NULL,
  `Speaker` varchar(30) DEFAULT NULL,
  `harga` double DEFAULT NULL,
  `description` varchar(500) DEFAULT NULL,
  `kategori` enum('Music','Sport','Education','Others') DEFAULT NULL,
  `capacity` int(11) DEFAULT NULL,
  `Date` date NOT NULL,
  `imagePath` varchar(500) DEFAULT NULL,
  `seller_id` int(11) DEFAULT NULL
) ENGINE=InnoDB DEFAULT CHARSET=latin1 COLLATE=latin1_swedish_ci;

--
-- Dumping data untuk tabel `events`
--

INSERT INTO `events` (`event_id`, `judul`, `Singer`, `Genre`, `SportType`, `Speaker`, `harga`, `description`, `kategori`, `capacity`, `Date`, `imagePath`, `seller_id`) VALUES
(1, 'National Basketball Championship', NULL, NULL, 'Basketball', NULL, 150000, 'National level basketball competition', 'Sport', 5000, '2025-03-15', '../assets/basket1.jpg', 1),
(2, 'Streetball Challenge 2025', NULL, NULL, 'Basketball', NULL, 100000, 'Streetball competition for enthusiasts', 'Sport', 2000, '2025-05-20', '../assets/basket2.jpg', 2),
(3, 'FIFA World Cup Qualifiers', NULL, NULL, 'FIFA', NULL, 300000, 'World Cup qualifying match', 'Sport', 80000, '2025-11-10', '../assets/fifa1.jpg', 3),
(4, 'Pop Music Festival', 'Various Artists', 'Pop', NULL, NULL, 250000, 'Festival featuring top pop artists', '', 10000, '2025-06-12', '../assets/konser1.jpg', 1),
(5, 'Jazz Night', 'Jazz Legends', 'Jazz', NULL, NULL, 200000, 'A night of soothing jazz music', '', 3000, '2025-07-18', '../assets/konser2.jpg', 2),
(6, 'Rock Revolution', 'Rock Stars', 'Rock', NULL, NULL, 300000, 'Energetic rock concert', '', 5000, '2025-08-22', '../assets/konser3.jpg', 3),
(7, 'Business Seminar 2025', NULL, NULL, NULL, 'John Doe', 500000, 'Seminar on latest business trends', '', 1000, '2025-09-10', '../assets/seminar1.jpg', 1),
(8, 'Tech Innovations Summit', NULL, NULL, NULL, 'Jane Smith', 450000, 'Summit discussing future tech innovations', '', 1500, '2025-10-05', '../assets/seminar2.jpg', 2);

-- --------------------------------------------------------

--
-- Struktur dari tabel `feedback`
--

CREATE TABLE `feedback` (
  `feedback_id` int(11) NOT NULL,
  `FeedbackText` varchar(255) DEFAULT NULL,
  `cust_id` int(11) DEFAULT NULL,
  `event_id` int(11) DEFAULT NULL
) ENGINE=InnoDB DEFAULT CHARSET=latin1 COLLATE=latin1_swedish_ci;

-- --------------------------------------------------------

--
-- Struktur dari tabel `report`
--

CREATE TABLE `report` (
  `report_id` int(11) NOT NULL,
  `report_text` varchar(255) DEFAULT NULL,
  `seller_id` int(11) DEFAULT NULL,
  `event_id` int(11) DEFAULT NULL
) ENGINE=InnoDB DEFAULT CHARSET=latin1 COLLATE=latin1_swedish_ci;

-- --------------------------------------------------------

--
-- Struktur dari tabel `seller`
--

CREATE TABLE `seller` (
  `seller_id` int(11) NOT NULL,
  `seller_name` varchar(255) DEFAULT NULL,
  `password` varchar(255) DEFAULT NULL,
  `email` varchar(255) DEFAULT NULL,
  `phoneNum` varchar(20) DEFAULT NULL,
  `block` enum('Blocked','Unblock') DEFAULT 'Unblock'
) ENGINE=InnoDB DEFAULT CHARSET=latin1 COLLATE=latin1_swedish_ci;

--
-- Dumping data untuk tabel `seller`
--

INSERT INTO `seller` (`seller_id`, `seller_name`, `password`, `email`, `phoneNum`, `block`) VALUES
(1, 'Seller One', 'seller123', 'seller1@example.com', '6543210987', 'Unblock'),
(2, 'Seller Two', 'seller456', 'seller2@example.com', '5432109876', 'Unblock'),
(3, 'Seller Three', 'seller789', 'seller3@example.com', '4321098765', 'Unblock');

-- --------------------------------------------------------

--
-- Struktur dari tabel `ticket`
--

CREATE TABLE `ticket` (
  `ticket_id` int(11) NOT NULL,
  `ticket_desc` varchar(255) DEFAULT NULL,
  `cust_id` int(11) DEFAULT NULL,
  `event_id` int(11) DEFAULT NULL,
  `timeBuy` datetime DEFAULT NULL
) ENGINE=InnoDB DEFAULT CHARSET=latin1 COLLATE=latin1_swedish_ci;

--
-- Dumping data untuk tabel `ticket`
--

INSERT INTO `ticket` (`ticket_id`, `ticket_desc`, `cust_id`, `event_id`, `timeBuy`) VALUES
(1, 'VIP ticket', 1, 1, '2025-01-15 10:00:00'),
(2, 'Regular ticket', 2, 2, '2025-01-16 11:30:00'),
(3, 'VIP ticket', 3, 3, '2025-01-17 09:45:00'),
(4, 'Regular ticket', 4, 4, '2025-01-18 14:20:00'),
(5, 'Premium ticket', 5, 5, '2025-01-19 15:35:00'),
(6, 'Standard ticket', 6, 6, '2025-01-20 16:50:00'),
(7, 'General Admission', 1, 7, '2025-01-21 17:25:00'),
(8, 'Early Bird ticket', 2, 8, '2025-01-22 18:40:00'),
(9, 'VIP ticket', 3, 4, '2025-01-23 19:00:00');

--
-- Indexes for dumped tables
--

--
-- Indeks untuk tabel `admin`
--
ALTER TABLE `admin`
  ADD PRIMARY KEY (`admin_id`);

--
-- Indeks untuk tabel `block`
--
ALTER TABLE `block`
  ADD PRIMARY KEY (`block_id`),
  ADD KEY `seller_id` (`seller_id`),
  ADD KEY `cust_id` (`cust_id`);

--
-- Indeks untuk tabel `cart`
--
ALTER TABLE `cart`
  ADD PRIMARY KEY (`cart_id`),
  ADD KEY `event_id` (`event_id`),
  ADD KEY `ticket_id` (`ticket_id`),
  ADD KEY `cust_id` (`cust_id`);

--
-- Indeks untuk tabel `customer`
--
ALTER TABLE `customer`
  ADD PRIMARY KEY (`cust_id`);

--
-- Indeks untuk tabel `events`
--
ALTER TABLE `events`
  ADD PRIMARY KEY (`event_id`),
  ADD KEY `seller_id` (`seller_id`);

--
-- Indeks untuk tabel `feedback`
--
ALTER TABLE `feedback`
  ADD PRIMARY KEY (`feedback_id`),
  ADD KEY `cust_id` (`cust_id`),
  ADD KEY `event_id` (`event_id`);

--
-- Indeks untuk tabel `report`
--
ALTER TABLE `report`
  ADD PRIMARY KEY (`report_id`),
  ADD KEY `seller_id` (`seller_id`),
  ADD KEY `event_id` (`event_id`);

--
-- Indeks untuk tabel `seller`
--
ALTER TABLE `seller`
  ADD PRIMARY KEY (`seller_id`);

--
-- Indeks untuk tabel `ticket`
--
ALTER TABLE `ticket`
  ADD PRIMARY KEY (`ticket_id`),
  ADD KEY `cust_id` (`cust_id`),
  ADD KEY `event_id` (`event_id`);

--
-- AUTO_INCREMENT untuk tabel yang dibuang
--

--
-- AUTO_INCREMENT untuk tabel `admin`
--
ALTER TABLE `admin`
  MODIFY `admin_id` int(11) NOT NULL AUTO_INCREMENT, AUTO_INCREMENT=3;

--
-- AUTO_INCREMENT untuk tabel `block`
--
ALTER TABLE `block`
  MODIFY `block_id` int(11) NOT NULL AUTO_INCREMENT, AUTO_INCREMENT=13;

--
-- AUTO_INCREMENT untuk tabel `cart`
--
ALTER TABLE `cart`
  MODIFY `cart_id` int(11) NOT NULL AUTO_INCREMENT;

--
-- AUTO_INCREMENT untuk tabel `customer`
--
ALTER TABLE `customer`
  MODIFY `cust_id` int(11) NOT NULL AUTO_INCREMENT, AUTO_INCREMENT=8;

--
-- AUTO_INCREMENT untuk tabel `events`
--
ALTER TABLE `events`
  MODIFY `event_id` int(11) NOT NULL AUTO_INCREMENT, AUTO_INCREMENT=9;

--
-- AUTO_INCREMENT untuk tabel `feedback`
--
ALTER TABLE `feedback`
  MODIFY `feedback_id` int(11) NOT NULL AUTO_INCREMENT;

--
-- AUTO_INCREMENT untuk tabel `report`
--
ALTER TABLE `report`
  MODIFY `report_id` int(11) NOT NULL AUTO_INCREMENT;

--
-- AUTO_INCREMENT untuk tabel `seller`
--
ALTER TABLE `seller`
  MODIFY `seller_id` int(11) NOT NULL AUTO_INCREMENT, AUTO_INCREMENT=4;

--
-- AUTO_INCREMENT untuk tabel `ticket`
--
ALTER TABLE `ticket`
  MODIFY `ticket_id` int(11) NOT NULL AUTO_INCREMENT, AUTO_INCREMENT=10;
COMMIT;

/*!40101 SET CHARACTER_SET_CLIENT=@OLD_CHARACTER_SET_CLIENT */;
/*!40101 SET CHARACTER_SET_RESULTS=@OLD_CHARACTER_SET_RESULTS */;
/*!40101 SET COLLATION_CONNECTION=@OLD_COLLATION_CONNECTION */;
