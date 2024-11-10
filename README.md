# help-page

plugin 방식으로 도움말 페이지를 만들어보자 like swagger-ui

1. 이 depedency를 추가하면 도움말 페이지를 만들 수 있다.
2. 도움말 페이지는 ymal 파일을 만들어서 만들 수 있다.
3. 도움말 페이지는 default 값으로 /help로 접근할 수 있고 ymal 파일에서 설정한 값으로 접근할 수 있다.
4. 도움말 페이지에서는 지정한 email로 메일을 보낼 수 있다.
5. email을 보낼 때 보내는 회원의 정보도 같이 보낼 수 있다.(이걸 어떻게 구현할지 생각해보자)

## Getting Started

### Reference Documentation

ymal 파일을 만들어서 도움말 페이지를 만들어보자.

```yaml
help:
  version: 1.0.0
  url: /help
  contact:
    email: ${your-email}
  page:
    title: Help Page
    description: This is a help page.
    background-color: "#FF0000"
    font-color: "#FFFFFF"
    font-size: 20px
    font-family: Arial
  authentification:
    ????