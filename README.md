# 🌈 Weather Diary - 오늘의 날씨 일기

### 오늘의 날씨와 함께 일기를 작성해 보세요!

**오늘의 날씨 일기**는 OpenWeatherMap API를 활용해 **현재 날씨 데이터를 기반으로 일기를 작성**하고, 저장된 일기를 조회, 수정, 삭제할 수 있는 기능을 제공하는 프로젝트입니다

<br>


## ⚙ 기술 스택

- **Language**: `Java 17`
- **Framework**: `Spring Boot 3.3.3`
- **Database**: `MySQL`
- **Build Tool**: `Gradle`
- **Library**: `Lombok`, `Spring Data JPA`, `Spring Web`
- **Testing**: `Spring Boot Starter Test`
- **IDE**: `IntelliJ IDEA`
- **Logging**: `Logback`
- **API Documentation**: `Swagger (SpringDoc OpenAPI)`

<br>

## 💡 주요 기능

- **날씨 데이터 저장**
    
    매일 새벽 1시에 OpenWeatherMap API를 통해 **당일의 날씨 데이터를 저장**합니다
    
- **일기 작성**
    
    사용자는 **오늘의 날씨 정보**를 기반으로 일기를 작성할 수 있습니다
    
- **일기 조회**
    
    저장된 일기를 **날짜별 또는 기간별로 조회**할 수 있습니다
    
- **일기 수정 및 삭제**
    
    저장된 일기를 **수정하거나 삭제**할 수 있습니다


<br>

## 📚 주요 API

| HTTP Method | Endpoint | 설명 |
| --- | --- | --- |
| **POST** | `/create/diary` | 특정 날짜의 날씨 데이터를 기반으로 일기 작성 |
| **GET** | `/read/diary` | 특정 날씨의 일기를 List 형태로 반환 |
| **GET** | `/read/diaries` | 특정 기간의 일기를 List 형태로 반환 |
| **PUT** | `/update/diary` | 특정 날짜의 첫번째 일기 글을 새로 받아온 일기로 수정 |
| **DELETE** | `/delete/diary` | 특정 날짜의 모든 일기를 삭제 |


<br>


## Swagger UI

로컬환경에서 Swagger UI 확인하기: http://localhost:8080/swagger-ui/index.html

<br>

![swagger](https://github.com/user-attachments/assets/1a431d84-637e-480d-acad-b859b1afb892)

