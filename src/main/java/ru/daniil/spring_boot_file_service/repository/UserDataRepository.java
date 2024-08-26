package ru.daniil.spring_boot_file_service.repository;

import org.springframework.data.jpa.repository.JpaRepository;
import org.springframework.stereotype.Repository;
import ru.daniil.spring_boot_file_service.entity.UserData;
import org.springframework.data.domain.Pageable;
import java.util.List;

@Repository
public interface UserDataRepository extends JpaRepository<UserData, Long>{

    List<UserData> findBy(Pageable pageable);
}
