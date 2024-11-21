package com.example.muon_sach.repository;

import com.example.muon_sach.model.BorrowRecord;
import org.springframework.data.jpa.repository.JpaRepository;

public interface BorrowRecordRepository extends JpaRepository<BorrowRecord, String> {
}
