# 01 — High-Level Design (HLD)

## 🎯 Objective
Design a scalable personal finance platform (**FinTrack**) that enables users to record transactions, set budgets, and visualize financial insights.

---

## 🧩 Core Modules
1. **Authentication & Authorization** – JWT-based login, role-based access.
2. **Accounts & Categories** – manage accounts (bank, cash, card) and spending categories.
3. **Transactions** – CRUD with recurring support and CSV import/export.
4. **Budgets** – define and track spending limits per category.
5. **Dashboard** – charts and insights using aggregated data.
6. **Attachments** – upload receipts (S3/MinIO).
7. **Notifications** – reminders or alerts (email/SMS optional).

---

## 🏗️ Architecture Overview
Frontend (React + Vite)
↕ REST API
Backend (Spring Boot)
↕
PostgreSQL ←→ Redis ←→ MinIO


- **Frontend:** SPA built with React + Vite.
- **Backend:** RESTful API using Spring Boot + JPA.
- **Database:** PostgreSQL for consistent data management.
- **Redis:** caching, rate limiting, and background job locking.
- **MinIO:** object storage for file uploads.
- **Docker-compose:** local orchestration.

---

## 🔒 Non-Functional Requirements
| Area | Requirement |
|-------|--------------|
| Security | JWT, HTTPS, validation, sanitized inputs |
| Scalability | Stateless services, caching, async jobs |
| Reliability | Health checks, retries, graceful shutdown |
| Observability | Logging, metrics, tracing |
| CI/CD | GitHub Actions, Docker build pipelines |

---

## 📊 Sample Data Flow
1. User logs in → receives JWT token.
2. Frontend calls `/api/v1/transactions`.
3. Backend fetches from Postgres; caches recent data in Redis.
4. Response rendered as chart or list on dashboard.
