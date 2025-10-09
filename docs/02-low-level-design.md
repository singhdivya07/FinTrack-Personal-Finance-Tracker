# 02 — Low-Level Design (LLD)

## 🧱 Entities
| Entity | Description |
|---------|--------------|
| User | Holds credentials, preferences, and roles |
| Account | Represents a source of funds (bank, wallet, card) |
| Category | Defines spending classification (food, travel) |
| Transaction | Records amount, type, timestamp, and note |
| Budget | Defines spending limit per category |
| Attachment | Links uploaded receipts to transactions |

---

## 🧩 Example: Transaction Entity
```java
@Entity
public class Transaction {
  @Id
  @GeneratedValue(strategy = GenerationType.IDENTITY)
  private Long id;

  @ManyToOne
  private User user;

  @ManyToOne
  private Account account;

  @ManyToOne
  private Category category;

  private BigDecimal amount;
  private String type; // debit or credit
  private LocalDate occurredAt;
  private String note;
  private LocalDateTime createdAt;
}
```
## 🧭 Layered Architecture
Controller → Service → Repository → Domain Model → DB

Each module follows Separation of Concerns:

Controller: Input/output validation and API responses.

Service: Business logic.

Repository: Database access (JPA).

Model: Domain entity definitions.

## 🔁 Sequence Example

Flow: Add new transaction

- Frontend → POST /api/v1/transactions
- Backend validates → updates account balance → saves in DB
- Response → UI refresh → show new entry in dashboard

