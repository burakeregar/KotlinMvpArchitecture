# KotlinMvpArchitecture
Clean MVP Architecture with Dagger2 + Retrofit2 + Mockito + Fresco + EasiestGenericRecyclerAdapter + EventBus + Anko using Kotlin. 

This repo contains demo module which retrieves mars images from the NASA API. The main purpose of the repo is to reduce the time spent on starting a new project or adding new modules to your existing project. You can add new modules with just 2-3 clicks without writing any code. I have developed an Android Studio template for it. [You can check that KotlinMvpTemplateGenerator from here.](https://github.com/burakeregar/KotlinMvpTemplateGenerator)

I have separated activity dependencies/components from AppComponent to avoid conflicts. KotlinMvpTemplate generates all of required dependency classes, presenters etc. for each module automatically.

### UPDATE
Unit Tests are added!

**Mockito:** a mocking framework for unit tests

**EventBus** for handling click events & passing your models in viewholders or activities.

**Stetho** is a sophisticated debug bridge for Android applications. When enabled, developers have access to the Chrome Developer Tools 
feature natively part of the Chrome desktop browser. You should just type browser chrome://inspect then you can watch network traffic.

**LeakCanary** is a memory leak detection library for Android and Java. 

**LoggingInterceptor** for watching network traffic from Android Studio's Logcat

**SpHelper** for saving your models to Shared Preferences easily.

**Cache** for caching your get requests for a while. (Default cache time is 1 min)


### STARTING NEW PROJECT
If you start to develop new project, you can clone this repo to your computer. You just need to rename packages. Now, you are ready! You can start developing your modules.

![](https://github.com/burakeregar/KotlinMvpTemplateGenerator/blob/master/art/mvp_template.gif)

### LICENSE

MIT License

Copyright (c) 2017 Burak Eregar

Permission is hereby granted, free of charge, to any person obtaining a copy
of this software and associated documentation files (the "Software"), to deal
in the Software without restriction, including without limitation the rights
to use, copy, modify, merge, publish, distribute, sublicense, and/or sell
copies of the Software, and to permit persons to whom the Software is
furnished to do so, subject to the following conditions:

The above copyright notice and this permission notice shall be included in all
copies or substantial portions of the Software.

THE SOFTWARE IS PROVIDED "AS IS", WITHOUT WARRANTY OF ANY KIND, EXPRESS OR
IMPLIED, INCLUDING BUT NOT LIMITED TO THE WARRANTIES OF MERCHANTABILITY,
FITNESS FOR A PARTICULAR PURPOSE AND NONINFRINGEMENT. IN NO EVENT SHALL THE
AUTHORS OR COPYRIGHT HOLDERS BE LIABLE FOR ANY CLAIM, DAMAGES OR OTHER
LIABILITY, WHETHER IN AN ACTION OF CONTRACT, TORT OR OTHERWISE, ARISING FROM,
OUT OF OR IN CONNECTION WITH THE SOFTWARE OR THE USE OR OTHER DEALINGS IN THE
SOFTWARE.
