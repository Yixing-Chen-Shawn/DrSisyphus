### Introduction
This is term project originally for CSE389 Web System Arch/Prog in Fall 2021 at Syracuse University. Now, I am ambitious to turn it into a much larger project, and my target is to develop a http server with multiple features like support for all request methods in http1.1 and 1.0, basic access authentication and digest access authentication, handlers for static and dynamic file request, bandwidth throttling, cache requests, SSL(Secure Socket Layers), and support for multiple document roots in the different life cycle, replace traditional blocking I/O approach with non-blocking I/O for scaleability, etc..
___
### Quickstart:
We'll create a custom HTTP server project on Visual Studio Code. First, install Visual Studio Code, git and Java SDK if not already installed. Then open your terminal and run:

```text
git clone https://github.com/Yixing-Chen-Shawn/http-server.git
```
After cloning the project into your local directory, open your Visual Studio Code and import the project.

---
### Disclaimer
This HTTP server is currently set to private due to ongoing development. This project will be extended into a large, full-fledged http server benchmarked against Apache Tomcat. Therefore, I would not like to reveal any sourcecode for now. 
___
### Developer list with responsibility:
Team lead: Yixing Chen

Team members: Cheng Yu Sung, Akshay Ram, Hang Zhao, Fiona Tubiana

Responsibility:
+ Yixing Chen: will be responsible for deriving the software architecture and designing the framework to structure the whole project. Apart from those, He is also responsible for implementing two request methods GET & POST methods from basic requirements, basic access authentication, handlers for static and dynamic file requests, NIO for replacing BIO in multithreading, and etc. for additional requirements. 
+ Cheng Yu Sung: will be in charge with implementing logging. 
+ Akshay Ram: will be implementing one of request methods HEAD.
+ Hang Zhao: will be implementing SSL. 
+ Fiona Tubiana: will be implementing one of request methods DELETE.
___
### Project structure: 'todo
___
### Features implemented:
+ Support for GET and POST methods
+ Basic access authentication
+ Handlers for static file requests
+ Non-blocking IO 

