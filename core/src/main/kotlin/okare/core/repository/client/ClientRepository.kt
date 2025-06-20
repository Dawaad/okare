package okare.core.repository.client

import okare.core.entity.client.ClientEntity
import org.springframework.data.jpa.repository.JpaRepository
import java.util.*

interface ClientRepository : JpaRepository<ClientEntity, UUID> {
    fun findByUserId(userId: UUID): List<ClientEntity>
}