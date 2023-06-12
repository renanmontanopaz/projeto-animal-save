package br.com.projetoanimalsave.Repository;

import br.com.projetoanimalsave.Entity.*;
import org.springframework.data.jpa.repository.JpaRepository;
import org.springframework.data.jpa.repository.Query;
import org.springframework.stereotype.Repository;

import java.util.List;

@Repository
public interface AdminRepository extends JpaRepository<Admin, Long> {
    @Query("SELECT associate FROM Associate associate WHERE associate.pending = true")
    public List<Object> findAssociatePending();

    @Query("SELECT caregiver FROM Caregiver caregiver WHERE caregiver.pending = true")
    public List<Object> findCaregiverPending();

    @Query("SELECT provider FROM Provider provider WHERE provider.pending = true")
    public List<Object> findProviderPending();
}