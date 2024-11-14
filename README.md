# 1. BaseBallGame 어플리케이션

## 게임 사용 설명 

### 회원 가입 기능
- 회원가입 
- 로그인 후 jwt 토큰을 헤더가 기입
- 사용자 인증 후 게임 진행 

### 게임 기능
- /api/v1/baseballGame api를 통해 게임 생성 후 
- /api/v1/baseballGame/{gameId} api를 통해 게임 진행 
- 답은 맨앞자리에 0이 올 수 없고 중복 없는 3자리
-  스트라이크 (Strike):
   -  입력값에서 같은 자리에 같은 숫자가 있을 때.
   예: 답 "301", 입력값 "123" -> 1스트라이크 (3번째 자리 숫자 '1'이 같음)
- 볼 (Ball):
   - 입력값에서 답에 포함된 숫자가 다른 자리에 있을 때.
   예: 답 "301", 입력값 "123" -> 2볼 (숫자 '1', '3'은 답에 있지만 위치가 다름)


# 2. Kotlin 과 Java 비교 

  | **특징**                | **Java (BaseBallGameResultResponse)**                                                                                          | **Kotlin (LoginResponse)**                                                                                      |
  |-----------------------|----------------------------------------------------------------------------------------------------------------------------|--------------------------------------------------------------------------------------------------------------|
  | **필드 접근**            | `@Getter`, `@Setter` 애노테이션을 사용하여 getter와 setter 메서드를 수동으로 생성.                                          | `data class`는 자동으로 getter와 setter 메서드를 생성.                                                    |
  | **빌더 패턴**            | `@Builder` 애노테이션을 통해 빌더 패턴을 사용하여 객체 생성.                                                                | `data class`에서는 생성자 문법을 사용하여 간단하게 객체를 생성.                                            |
  | **메서드 생성**          | `toString()`, `equals()`, `hashCode()` 메서드는 기본적으로 제공되지 않으며, 수동으로 오버라이드 해야 함.                         | `data class`는 `toString()`, `equals()`, `hashCode()`, `copy()` 메서드를 자동으로 제공.                    |
  | **정적 팩토리 메서드**   | `from()` 메서드와 같은 정적 팩토리 메서드를 사용하여 객체를 생성.                                                            | `data class`는 이러한 정적 팩토리 메서드 없이 간단한 생성자로 객체를 바로 생성할 수 있음.                 |
  | **엔티티에서의 사용**    | JPA 엔티티에서 `getter`와 `setter`를 반드시 작성하거나 Lombok을 사용하여 자동으로 생성.                                      | JPA 엔티티에서 `data class`를 사용하면 자동으로 `getter`와 `setter`가 생성되므로 따로 애노테이션이나 메서드를 작성할 필요가 없음. |
  
| **특징**       | **Java(Entity)**                                        | **Kotlin(Entity)**                                   |
  |----------------|-----------------------------------------------------|------------------------------------------------------|
  | **접근 제어**  | 필드를 `private`로 선언하고, `getter`/`setter` 메서드를 작성해야 함. | `var` 또는 `val`로 필드 선언시 자동으로 `getter`와 `setter`가 제공됨. |
  | **변경 가능성** | `private` 필드는 객체 내부에서만 수정하고, 외부에서 `setter`를 통해 수정 가능. | `var`는 값을 변경할 수 있고, `val`은 읽기 전용 (변경 불가).            |
  | **코드 길이**  | `getter`와 `setter` 메서드를 수동으로 작성해야 해서 코드가 길어짐.       | 필드에 대해 `var`/`val`을 선언만 하면 자동으로 메서드가 제공됨.            |


# 3. API 명세서

| Name         | URI(Resource)          | Method | Status Code |
|--------------|------------------------|--------|-------------|
| 회원 로그인       | /api/v1/user/login     | POST   | 200         |
| 회원 가입        | /api/v1/feeds/signup   | POST   | 200         |
| 게임 생성(답 생성 ) | /api/v1/baseballGame | GET    | 200         |
| 게임 진행        | /api/v1/baseballGame/{gameId} | POST   | 200         |