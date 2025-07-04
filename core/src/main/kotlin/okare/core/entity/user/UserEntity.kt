package okare.core.entity.user

import io.hypersistence.utils.hibernate.type.json.JsonBinaryType
import jakarta.persistence.*
import okare.core.models.invoice.ChargeRate
import okare.core.models.user.Address
import okare.core.models.user.Company
import okare.core.models.user.User
import org.hibernate.annotations.Type
import java.time.ZonedDateTime
import java.util.*

@Entity
@Table(
    name = "users",
)
data class UserEntity(
    @Id
    @GeneratedValue
    @Column(name = "id")
    val id: UUID? = null,

    @Column(name = "name", nullable = false)
    var name: String,

    @Column(name = "email", nullable = false)
    var email: String,

    @Column(name = "phone", nullable = false)
    var phone: String,

    @Type(JsonBinaryType::class)
    @Column(name = "address", nullable = true, columnDefinition = "jsonb")
    var address: Address? = null,

    @Type(JsonBinaryType::class)
    @Column(name = "company", nullable = true, columnDefinition = "jsonb")
    var company: Company? = null,

    @Type(JsonBinaryType::class)
    @Column(name = "charge_rate", columnDefinition = "jsonb", nullable = true)
    var chargeRate: ChargeRate? = null,

    @Embedded
    var paymentDetails: Payment? = null,

    @Column(
        name = "created_at",
        nullable = false,
        updatable = false
    ) var createdAt: ZonedDateTime = ZonedDateTime.now(),

    @Column(name = "updated_at", nullable = false) var updatedAt: ZonedDateTime = ZonedDateTime.now()
) {
    @PrePersist
    fun onPrePersist() {
        createdAt = ZonedDateTime.now()
        updatedAt = ZonedDateTime.now()
    }

    @PreUpdate
    fun onPreUpdate() {
        updatedAt = ZonedDateTime.now()
    }

    @Embeddable
    data class Payment(
        @Column(name = "bsb")
        var bsb: String,

        @Column(name = "account_number")
        var accountNumber: String,

        @Column(name = "account_name")
        var accountName: String
    )
}

fun UserEntity.toModel(): User {
    this.id.let {
        if (it == null) {
            throw IllegalArgumentException("UserEntity id cannot be null")
        }
        return User(
            id = it,
            email = this.email,
            phone = this.phone,
            name = this.name,
            company = this.company,
            chargeRate = this.chargeRate,
            paymentDetails = this.paymentDetails,
            address = this.address,
        )
    }
}