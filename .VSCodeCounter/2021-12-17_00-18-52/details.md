# Details

Date : 2021-12-17 00:18:52

Directory /Users/shawnchen/Desktop/http-server/src

Total : 51 files,  1628 codes, 78 comments, 552 blanks, all 2258 lines

[summary](results.md)

## Files
| filename | language | code | comment | blank | total |
| :--- | :--- | ---: | ---: | ---: | ---: |
| [src/Makefile](/src/Makefile) | Makefile | 16 | 1 | 7 | 24 |
| [src/http.properties](/src/http.properties) | Properties | 6 | 0 | 3 | 9 |
| [src/http/server/auth/Authenticator.java](/src/http/server/auth/Authenticator.java) | Java | 3 | 0 | 3 | 6 |
| [src/http/server/auth/AuthenticatorBase.java](/src/http/server/auth/AuthenticatorBase.java) | Java | 4 | 0 | 3 | 7 |
| [src/http/server/auth/BasicAuthenticator.java](/src/http/server/auth/BasicAuthenticator.java) | Java | 40 | 5 | 17 | 62 |
| [src/http/server/auth/DigestAuthenticator.java](/src/http/server/auth/DigestAuthenticator.java) | Java | 3 | 0 | 3 | 6 |
| [src/http/server/auth/FormAuthenticator.java](/src/http/server/auth/FormAuthenticator.java) | Java | 3 | 0 | 3 | 6 |
| [src/http/server/auth/SSLAuthenticator.java](/src/http/server/auth/SSLAuthenticator.java) | Java | 3 | 0 | 3 | 6 |
| [src/http/server/bean/ChannelStatus.java](/src/http/server/bean/ChannelStatus.java) | Java | 4 | 0 | 2 | 6 |
| [src/http/server/bean/ConfigField.java](/src/http/server/bean/ConfigField.java) | Java | 21 | 0 | 7 | 28 |
| [src/http/server/bean/Const.java](/src/http/server/bean/Const.java) | Java | 17 | 0 | 3 | 20 |
| [src/http/server/bean/Context.java](/src/http/server/bean/Context.java) | Java | 3 | 0 | 3 | 6 |
| [src/http/server/bean/Field.java](/src/http/server/bean/Field.java) | Java | 61 | 2 | 7 | 70 |
| [src/http/server/bean/Method.java](/src/http/server/bean/Method.java) | Java | 25 | 2 | 7 | 34 |
| [src/http/server/bean/StatusCode.java](/src/http/server/bean/StatusCode.java) | Java | 60 | 5 | 12 | 77 |
| [src/http/server/bean/URL.java](/src/http/server/bean/URL.java) | Java | 24 | 0 | 9 | 33 |
| [src/http/server/context/Context.java](/src/http/server/context/Context.java) | Java | 3 | 0 | 3 | 6 |
| [src/http/server/context/ContextWrapper.java](/src/http/server/context/ContextWrapper.java) | Java | 3 | 0 | 3 | 6 |
| [src/http/server/cookie/Cookie.java](/src/http/server/cookie/Cookie.java) | Java | 3 | 0 | 3 | 6 |
| [src/http/server/cookie/CookieWrapper.java](/src/http/server/cookie/CookieWrapper.java) | Java | 3 | 0 | 3 | 6 |
| [src/http/server/filter/Filter.java](/src/http/server/filter/Filter.java) | Java | 3 | 0 | 4 | 7 |
| [src/http/server/listener/Listener.java](/src/http/server/listener/Listener.java) | Java | 3 | 0 | 3 | 6 |
| [src/http/server/log/AccessLog.java](/src/http/server/log/AccessLog.java) | Java | 47 | 0 | 17 | 64 |
| [src/http/server/log/ErrorLog.java](/src/http/server/log/ErrorLog.java) | Java | 3 | 0 | 3 | 6 |
| [src/http/server/log/Log.java](/src/http/server/log/Log.java) | Java | 3 | 0 | 3 | 6 |
| [src/http/server/log/LogWriter.java](/src/http/server/log/LogWriter.java) | Java | 3 | 0 | 2 | 5 |
| [src/http/server/main/Main.java](/src/http/server/main/Main.java) | Java | 12 | 0 | 7 | 19 |
| [src/http/server/net/AcceptHandler.java](/src/http/server/net/AcceptHandler.java) | Java | 27 | 4 | 10 | 41 |
| [src/http/server/net/BaseHandler.java](/src/http/server/net/BaseHandler.java) | Java | 25 | 0 | 9 | 34 |
| [src/http/server/net/ChannelMap.java](/src/http/server/net/ChannelMap.java) | Java | 27 | 6 | 10 | 43 |
| [src/http/server/net/Handler.java](/src/http/server/net/Handler.java) | Java | 4 | 0 | 2 | 6 |
| [src/http/server/net/ReadHandler.java](/src/http/server/net/ReadHandler.java) | Java | 34 | 8 | 10 | 52 |
| [src/http/server/net/Server.java](/src/http/server/net/Server.java) | Java | 58 | 8 | 17 | 83 |
| [src/http/server/net/WriteHandler.java](/src/http/server/net/WriteHandler.java) | Java | 57 | 3 | 20 | 80 |
| [src/http/server/request/Request.java](/src/http/server/request/Request.java) | Java | 19 | 0 | 18 | 37 |
| [src/http/server/request/RequestHeaderParser.java](/src/http/server/request/RequestHeaderParser.java) | Java | 134 | 9 | 45 | 188 |
| [src/http/server/request/RequestWrapper.java](/src/http/server/request/RequestWrapper.java) | Java | 164 | 2 | 45 | 211 |
| [src/http/server/response/Response.java](/src/http/server/response/Response.java) | Java | 37 | 0 | 36 | 73 |
| [src/http/server/response/ResponseHeaderBuilder.java](/src/http/server/response/ResponseHeaderBuilder.java) | Java | 115 | 1 | 26 | 142 |
| [src/http/server/response/ResponseWrapper.java](/src/http/server/response/ResponseWrapper.java) | Java | 183 | 1 | 47 | 231 |
| [src/http/server/servlet/DefaultServlet.java](/src/http/server/servlet/DefaultServlet.java) | Java | 145 | 5 | 25 | 175 |
| [src/http/server/servlet/DynamicServlet.java](/src/http/server/servlet/DynamicServlet.java) | Java | 14 | 0 | 9 | 23 |
| [src/http/server/servlet/Servlet.java](/src/http/server/servlet/Servlet.java) | Java | 8 | 0 | 7 | 15 |
| [src/http/server/servlet/StaticServlet.java](/src/http/server/servlet/StaticServlet.java) | Java | 14 | 0 | 8 | 22 |
| [src/http/server/session/Session.java](/src/http/server/session/Session.java) | Java | 3 | 0 | 3 | 6 |
| [src/http/server/session/SessionWrapper.java](/src/http/server/session/SessionWrapper.java) | Java | 3 | 0 | 3 | 6 |
| [src/http/server/task/LifeCycle.java](/src/http/server/task/LifeCycle.java) | Java | 62 | 14 | 27 | 103 |
| [src/http/server/task/LifeCycleExecution.java](/src/http/server/task/LifeCycleExecution.java) | Java | 24 | 0 | 10 | 34 |
| [src/http/server/util/Config.java](/src/http/server/util/Config.java) | Java | 31 | 0 | 9 | 40 |
| [src/http/server/util/Util.java](/src/http/server/util/Util.java) | Java | 33 | 2 | 11 | 46 |
| [src/wwwroot/index.html](/src/wwwroot/index.html) | HTML | 28 | 0 | 2 | 30 |

[summary](results.md)