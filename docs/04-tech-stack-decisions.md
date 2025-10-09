# 04 — Tech Stack Decisions

| Area | Choice                           | Reason |
|-------|----------------------------------|--------|
| Language | Java 17                          | Mature, strong ecosystem |
| Framework | Spring Boot                      | Standard enterprise-ready solution |
| DB | PostgreSQL                       | ACID transactions, JSONB support |
| Frontend | React (Vite + TS / JS)           | Modern, fast, component-driven |
| Cache | Redis                            | Speed, rate-limiting, caching |
| Storage | MinIO                            | S3-compatible, local-friendly |
| Infra | Docker Compose                   | Easy local orchestration |
| CI | GitHub Actions                   | Built-in for public repos |
| Tests | JUnit + Testcontainers + Cypress | Full coverage from unit to E2E |
