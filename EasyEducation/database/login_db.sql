-- phpMyAdmin SQL Dump
-- version 5.1.3
-- https://www.phpmyadmin.net/
--
-- Εξυπηρετητής: 127.0.0.1
-- Χρόνος δημιουργίας: 06 Απρ 2022 στις 19:15:33
-- Έκδοση διακομιστή: 10.4.24-MariaDB
-- Έκδοση PHP: 7.3.33

SET SQL_MODE = "NO_AUTO_VALUE_ON_ZERO";
START TRANSACTION;
SET time_zone = "+00:00";


/*!40101 SET @OLD_CHARACTER_SET_CLIENT=@@CHARACTER_SET_CLIENT */;
/*!40101 SET @OLD_CHARACTER_SET_RESULTS=@@CHARACTER_SET_RESULTS */;
/*!40101 SET @OLD_COLLATION_CONNECTION=@@COLLATION_CONNECTION */;
/*!40101 SET NAMES utf8mb4 */;

--
-- Βάση δεδομένων: `login_db`
--

-- --------------------------------------------------------

--
-- Δομή πίνακα για τον πίνακα `class_srms`
--

CREATE TABLE `class_srms` (
  `id` int(11) NOT NULL,
  `class_id` int(11) NOT NULL,
  `class_name` varchar(250) COLLATE utf8_unicode_ci NOT NULL,
  `student_id` int(100) NOT NULL,
  `subject_id` int(100) NOT NULL,
  `project` varchar(10) COLLATE utf8_unicode_ci NOT NULL
) ENGINE=InnoDB DEFAULT CHARSET=utf8 COLLATE=utf8_unicode_ci;

--
-- Άδειασμα δεδομένων του πίνακα `class_srms`
--

INSERT INTO `class_srms` (`id`, `class_id`, `class_name`, `student_id`, `subject_id`, `project`) VALUES
(1, 1, 'Τμήμα01', 0, 1, 'off'),
(2, 2, 'Τμήμα02', 2, 2, 'off'),
(3, 3, 'Τμήμα06', 5, 3, 'on'),
(4, 4, 'Τμήμα04', 6, 4, 'off'),
(5, 5, 'Τμήμα05', 6, 5, 'on'),
(6, 6, 'Αγγλικά1010', 8, 6, 'off'),
(6, 7, 'Αγγλικά1010', 6, 6, 'on'),
(6, 8, 'Αγγλικά1010', 13, 6, 'off'),
(6, 9, 'Αγγλικά1010', 18, 6, 'off'),
(6, 10, 'Αγγλικά1010', 3, 6, 'on'),
(7, 11, 'Κοινωνιολογία', 8, 7, 'off'),
(5, 12, 'Τμήμα05', 3, 5, 'on'),
(5, 13, 'Τμήμα05', 15, 5, 'on'),
(5, 14, 'Τμήμα05', 12, 5, 'off'),
(5, 15, 'Τμήμα05', 8, 5, 'off'),
(6, 16, 'Αγγλικά1010', 4, 6, 'on'),
(6, 17, 'Αγγλικά1010', 12, 6, 'on'),
(6, 18, 'Αγγλικά1010', 15, 6, 'off'),
(6, 19, 'Αγγλικά1010', 2, 6, 'on');

-- --------------------------------------------------------

--
-- Δομή πίνακα για τον πίνακα `marks_srms`
--

CREATE TABLE `marks_srms` (
  `marks_id` int(11) NOT NULL,
  `subject_id` int(11) NOT NULL,
  `student_id` int(100) NOT NULL,
  `marks` int(11) NOT NULL
) ENGINE=InnoDB DEFAULT CHARSET=utf8 COLLATE=utf8_unicode_ci;

--
-- Άδειασμα δεδομένων του πίνακα `marks_srms`
--

INSERT INTO `marks_srms` (`marks_id`, `subject_id`, `student_id`, `marks`) VALUES
(1, 4, 2, 85),
(2, 5, 3, 56),
(3, 3, 4, 75),
(4, 2, 5, 89),
(5, 6, 5, 63),
(6, 7, 6, 55),
(7, 7, 7, 79),
(8, 3, 5, 75),
(9, 5, 6, 89),
(10, 6, 13, 63),
(11, 7, 15, 55),
(12, 7, 3, 79),
(13, 6, 18, 75),
(14, 5, 16, 89),
(15, 5, 15, 63);

-- --------------------------------------------------------

--
-- Δομή πίνακα για τον πίνακα `student_srms`
--

CREATE TABLE `student_srms` (
  `student_id` int(11) NOT NULL,
  `class_id` int(11) NOT NULL,
  `subject_id` bigint(20) NOT NULL,
  `student_name` varchar(250) COLLATE utf8_unicode_ci NOT NULL,
  `student_email` varchar(250) COLLATE utf8_unicode_ci NOT NULL,
  `student_status` varchar(150) COLLATE utf8_unicode_ci NOT NULL,
  `student_gender` enum('Male','Female') COLLATE utf8_unicode_ci NOT NULL,
  `student_age` int(11) NOT NULL,
  `student_dept` enum('True','False') COLLATE utf8_unicode_ci NOT NULL
) ENGINE=InnoDB DEFAULT CHARSET=utf8 COLLATE=utf8_unicode_ci;

--
-- Άδειασμα δεδομένων του πίνακα `student_srms`
--

INSERT INTO `student_srms` (`student_id`, `class_id`, `subject_id`, `student_name`, `student_email`, `student_status`, `student_gender`, `student_age`, `student_dept`) VALUES
(0, 0, 0, '', '', '', '', 0, ''),
(2, 7, 7, 'Γιώργος Παπαδόπουλος', 'gp@gmail.com', 'Μηχανικός', 'Male', 25, 'True'),
(3, 3, 3, 'Ελένη Μαυρομάτη', 'em@yahoo.com', 'Ηλεκτρολόγος', 'Female', 19, 'True'),
(4, 3, 3, 'Μανώλης Χατζηστεφάνου', 'mx@hotmail.com', 'Μηχανικός Υπολογιστών', 'Male', 20, 'False'),
(5, 3, 3, 'Λουίζα Παπουτέ', 'lp@gmail.com', 'Δομικών έργων', 'Female', 29, 'True'),
(6, 5, 5, 'Ιωάννης Λαναράς', 'lanar@gmail.com', 'Μηχανικός', 'Male', 35, 'True'),
(7, 6, 6, 'Βασίλης Παπαντωνίου', 'vp@gmail.com', 'Μηχανικός', 'Male', 22, 'False'),
(8, 7, 6, 'Άγγελος Βλάχος', 'av@gmail.com', 'Μηχανικός', 'Male', 21, 'False'),
(9, 7, 6, 'Αλέξανδρος Μουρατίδης', 'enrique55@gmail.com', 'Ηλεκτρολόγος', 'Male', 20, 'True'),
(10, 7, 6, 'Αγγελική Σαρηγιαννίδου', 'as@gmail.com', 'Δομικών έργων', 'Female', 23, 'True'),
(11, 5, 5, 'Ρουμπίνη Σταμάτη', 'rs@gmail.com', 'Δομικών έργων', 'Female', 24, 'True'),
(12, 3, 3, 'Κατερίνα Μαωλοπούλου', 'lw@gmail.com', 'Δομικών έργων', 'Female', 27, 'False'),
(13, 3, 3, 'Ιωάννης Παπαζήσης', 'ipap@gmail.com', 'Μηχανικός', 'Male', 25, 'True'),
(14, 5, 5, 'Δημήτρης Συμεωνίδης', 'ds@gmail.com', 'Ηλεκτρολόγος', 'Male', 29, 'True'),
(15, 5, 5, 'Θωμάς Καρτερόπουλος', 'tomaskar@gmail.com', 'Δομικών έργων', 'Male', 23, 'True'),
(16, 5, 5, 'Χριστίνα Φωτοπούλου', 'hfgmail.com', 'Δομικών έργων', 'Female', 24, 'False'),
(17, 6, 6, 'Γρηγόρης Μανώλης', 'gm@gmail.com', 'Δομικών έργων', 'Male', 25, 'False'),
(18, 6, 6, 'Αριστείδης Μυλωνάς', 'gar99@gmail.com', 'Μηχανικός', 'Male', 28, 'True'),
(19, 6, 6, 'Νεφέλη Κωνστατινίδου', 'nefelik@gmail.com', 'Μηχανικός', 'Female', 26, 'True'),
(20, 7, 6, 'Κατερίνα Δούπκαρη', 'kathrynel@gmail.com', 'Μηχανικός', 'Female', 28, 'False');

-- --------------------------------------------------------

--
-- Δομή πίνακα για τον πίνακα `subject_srms`
--

CREATE TABLE `subject_srms` (
  `subject_id` int(20) NOT NULL,
  `class_id` int(11) NOT NULL,
  `subject_name` varchar(250) COLLATE utf8_unicode_ci NOT NULL,
  `subject_created_on` datetime NOT NULL
) ENGINE=InnoDB DEFAULT CHARSET=utf8 COLLATE=utf8_unicode_ci;

--
-- Άδειασμα δεδομένων του πίνακα `subject_srms`
--

INSERT INTO `subject_srms` (`subject_id`, `class_id`, `subject_name`, `subject_created_on`) VALUES
(1, 1, 'Λογιστική', '2020-12-16 16:37:33'),
(2, 2, 'Δίκτυα', '2020-12-17 17:55:29'),
(3, 3, 'Παιδοψυχολογία', '2020-12-17 17:55:16'),
(4, 4, 'Μαθηματικά', '2020-12-17 17:55:29'),
(5, 5, 'Πληροφορική', '2020-12-16 15:44:04'),
(6, 6, 'Αγγλικά', '2020-12-17 17:55:29'),
(7, 7, 'Κοινωνιολογία', '2020-12-17 17:55:29');

-- --------------------------------------------------------

--
-- Δομή πίνακα για τον πίνακα `teachers`
--

CREATE TABLE `teachers` (
  `teacher_id` bigint(20) NOT NULL,
  `teacher_name` varchar(100) NOT NULL,
  `subject_id` varchar(100) NOT NULL,
  `class_id` varchar(100) NOT NULL
) ENGINE=InnoDB DEFAULT CHARSET=utf8mb4;

--
-- Άδειασμα δεδομένων του πίνακα `teachers`
--

INSERT INTO `teachers` (`teacher_id`, `teacher_name`, `subject_id`, `class_id`) VALUES
(1, 'Παπαδουράκης Νικόλαος', '1', '1'),
(2, 'Μαούνης Θεόδωρος', '1', '1'),
(3, 'Αλεξιάδης Βασίλειος', '2', '2'),
(4, 'Διαμαντάρας Κωνσταντίνος', '3', '3'),
(5, 'Ξεζωνάκης Ιωάννης', '4', '4'),
(6, 'Κουνελάκης Τσαμπίκος', '5', '5'),
(7, 'Μαυροειδής Ιάκωβος', '6', '6'),
(8, 'Μαρακάκης Μανώλης', '7', '7');

-- --------------------------------------------------------

--
-- Δομή πίνακα για τον πίνακα `users`
--

CREATE TABLE `users` (
  `id` bigint(20) NOT NULL,
  `user_id` bigint(20) NOT NULL,
  `user_name` varchar(100) NOT NULL,
  `password` varchar(100) NOT NULL,
  `date` timestamp NOT NULL DEFAULT current_timestamp() ON UPDATE current_timestamp()
) ENGINE=InnoDB DEFAULT CHARSET=utf8mb4;

--
-- Άδειασμα δεδομένων του πίνακα `users`
--

INSERT INTO `users` (`id`, `user_id`, `user_name`, `password`, `date`) VALUES
(1, 157638203366, 'admin', '1234', '2022-04-01 09:38:08'),
(5, 35669240840187, 'admin2', '12345', '2022-04-01 10:18:02');

--
-- Ευρετήρια για άχρηστους πίνακες
--

--
-- Ευρετήρια για πίνακα `class_srms`
--
ALTER TABLE `class_srms`
  ADD PRIMARY KEY (`class_id`),
  ADD KEY `subject_id` (`subject_id`);

--
-- Ευρετήρια για πίνακα `marks_srms`
--
ALTER TABLE `marks_srms`
  ADD PRIMARY KEY (`marks_id`);

--
-- Ευρετήρια για πίνακα `student_srms`
--
ALTER TABLE `student_srms`
  ADD PRIMARY KEY (`student_id`),
  ADD KEY `class_id` (`class_id`),
  ADD KEY `subject_id` (`subject_id`);

--
-- Ευρετήρια για πίνακα `subject_srms`
--
ALTER TABLE `subject_srms`
  ADD PRIMARY KEY (`subject_id`),
  ADD KEY `class_id` (`class_id`);

--
-- Ευρετήρια για πίνακα `teachers`
--
ALTER TABLE `teachers`
  ADD PRIMARY KEY (`teacher_id`);

--
-- Ευρετήρια για πίνακα `users`
--
ALTER TABLE `users`
  ADD PRIMARY KEY (`id`),
  ADD KEY `user_id` (`user_id`),
  ADD KEY `user_name` (`user_name`),
  ADD KEY `date` (`date`);

--
-- AUTO_INCREMENT για άχρηστους πίνακες
--

--
-- AUTO_INCREMENT για πίνακα `teachers`
--
ALTER TABLE `teachers`
  MODIFY `teacher_id` bigint(20) NOT NULL AUTO_INCREMENT, AUTO_INCREMENT=9;

--
-- AUTO_INCREMENT για πίνακα `users`
--
ALTER TABLE `users`
  MODIFY `id` bigint(20) NOT NULL AUTO_INCREMENT, AUTO_INCREMENT=6;
COMMIT;

/*!40101 SET CHARACTER_SET_CLIENT=@OLD_CHARACTER_SET_CLIENT */;
/*!40101 SET CHARACTER_SET_RESULTS=@OLD_CHARACTER_SET_RESULTS */;
/*!40101 SET COLLATION_CONNECTION=@OLD_COLLATION_CONNECTION */;
