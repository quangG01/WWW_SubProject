package com.example.lapweek5.repositories;

import com.example.lapweek5.entity.Candidate;
import org.springframework.data.jpa.repository.JpaRepository;
import org.springframework.stereotype.Repository;

@Repository
public interface CandidateRepository extends JpaRepository<Candidate, Long> {
    // Bạn có thể thêm các phương thức tùy chỉnh ở đây nếu cần
}

