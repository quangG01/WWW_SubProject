package com.example.lapweek5.repositories;

import com.example.lapweek5.entity.Address;
import org.springframework.data.jpa.repository.JpaRepository;
import org.springframework.stereotype.Repository;

@Repository
public interface AddressRepository extends JpaRepository<Address, Long> {
    // Bạn có thể thêm các phương thức tùy chỉnh ở đây nếu cần
}
