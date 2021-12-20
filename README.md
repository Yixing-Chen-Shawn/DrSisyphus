### Introduction
This is term project originally for CSE389 Web System Arch/Prog in Fall 2021 at Syracuse University. Now, I am ambitious to turn it into a much larger project, and my target is to develop a http server with multiple features like support for all request methods in http1.1 and 1.0, basic access authentication and digest access authentication, handlers for static and dynamic file request, bandwidth throttling, cache requests, SSL(Secure Socket Layers), and support for multiple document roots in the different life cycle, replace traditional blocking I/O approach with non-blocking I/O for scaleability, etc..
___
### Quickstart:
We'll create a custom HTTP server project on Visual Studio Code. First, install Visual Studio Code, git and Java SDK if not already installed. Then open your terminal and run:

```text
git clone https://github.com/Yixing-Chen-Shawn/http-server.git
```
After cloning the project into your local directory, open your Visual Studio Code and import the project.

Open up the terminal in your local environment(do not use builtin terminal in the VScode), go to src folder of the project, type in

```text
make run
```

Then the drsisyphus will be running, and for server authentication, the username and password are both: admin.

I put index.html in the wwwroot folder, feel free to change the content. 

---
### Disclaimer
This HTTP server is currently under development. It only supports limited features.

___
### Project structure: 'todo
___
### Features implemented:
+ Software Architecture for server extensibility && long term development
+ Support for GET, POST && HEAD.
+ Basic access authentication.
+ Handlers for static file requests && dynamic file requests (static and dynamic servlets implemented).
+ Non-blocking IO approach for (scalable) client-server communication (no thread and stream).

### Under Test

