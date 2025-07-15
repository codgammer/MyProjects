# 🧠 AI Resume Ranker

A full-stack web application that uses OpenAI's GPT API to intelligently rank a resume against a job description. Built with **Java Spring Boot (Backend)** and **React.js (Frontend)**, this tool helps applicants evaluate how well their resume matches the desired job role.

---

## 🚀 Features

- ✨ Rank resumes based on job descriptions using AI
- 🔌 OpenAI GPT-powered matching
- 📤 React frontend with resume & JD form
- ☕ Spring Boot backend with REST API integration
- 🌐 CORS-enabled API communication
- 🔐 Secure API Key handling (suggested via `application.properties` or environment variable)

---

## 🛠️ Tech Stack

| Layer      | Technology           |
|------------|----------------------|
| Frontend   | React.js, Axios      |
| Backend    | Java 17, Spring Boot |
| API        | OpenAI GPT API       |
| Build Tool | Maven                |
| Language   | Java, JavaScript     |

---

## 🧑‍💻 How It Works

1. **User Inputs:**
   - Job Description (JD)
   - Resume Text

2. **Frontend:**
   - Sends data via POST to backend `/api/rank`

3. **Backend:**
   - Uses OpenAI GPT API to compare and generate ranking feedback

4. **Output:**
   - Returns AI-generated resume match score or feedback

---

## ⚙️ Setup Instructions

### ✅ Prerequisites

- Node.js + npm
- Java 17+
- Maven
- OpenAI API Key (from https://platform.openai.com/account/api-keys)

---

### 📦 Backend Setup (Spring Boot)

```bash
cd backend

