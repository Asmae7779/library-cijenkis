package com.example.demo;
import org.springframework.data.jpa.repository.JpaRepository;

public interface LoanRepository extends JpaRepository<Loan, Long> {
    // Ajoutez des méthodes personnalisées si nécessaire
}
