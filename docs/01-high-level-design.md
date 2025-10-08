# High-Level Design (HLD)

## 🎯 Objective
Design a scalable personal finance management platform — **FinTrack** — that enables users to record transactions,
manage budgets, view analytics, and import/export data.

## 🧩 Core Modules
1. Authentication & Authorization (JWT)
2. Accounts & Categories
3. Transactions (CRUD + recurring)
4. Budgets & Alerts
5. Analytics Dashboard
6. Attachments (S3/MinIO)
7. Import/Export (CSV)
8. Notifications & Background Jobs

## 🏗️ Architecture Overview
Frontend (React SPA)
↕ REST API
Backend (Spring Boot)
↕
PostgreSQL (persistent data)
↔ Redis (cache/rate-limits)
↔ MinIO (attachments)

## 🔒 Non-Functional Requirements
- Scalable and modular
- Secure (JWT, encryption)
- Observable (metrics, logs)
- Tested (unit, integration, e2e)
- CI/CD ready
