# help-page

plugin 방식으로 도움말 페이지를 만들어보자 like swagger-ui

## V1 
1. 이 depedency를 추가하면 도움말 페이지를 만들 수 있다.
2. 도움말 페이지는 ymal 파일을 만들어서 만들 수 있다.
3. 도움말 페이지는 default 값으로 /help로 접근할 수 있고 ymal 파일에서 설정한 값으로 접근할 수 있다.
4. 회원의 문의 내용을 받아서 데이터베이스에 저장한다. 회원의 정보는 익명(UUID)으로 저장한다.

## Getting Started

### Reference Documentation

ymal 파일을 만들어서 도움말 페이지를 만들어보자.

```yaml
help:
  version: 1.0.0
  url: /help
  create-table: true
  page:
    title: Help Page
    description: This is a help page.
    background-color: "#FF0000"
    font-color: "#FFFFFF"
    font-size: 20px
    font-family: Arial
  authentification:
    ????

## TODO
1. 회원의 문의 내용을 받아서 데이터베이스에 저장한다. 회원의 정보를 JWT, Form Login에서 정보를 가져올 수 있게 커스터마이징을 지원하자.
2. 데이터베이스의 종류를 여러개 지원하자. ex) redis, mongo