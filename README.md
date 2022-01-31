VIRGIN MONEY ANDROID TASK
=========================

VM would like a directory app to allow staff to:
· See and use all their colleagues contact details. · See which rooms in the office are currently
occupied. Your task is to create this app in Android Studio using Kotlin and using a minimum of SDK
19. It should contain list/detail pages for the people and a list page for the rooms. It should
include features that you deem important to delivering the desired experience to the user. The
actual design does not matter, however the consistency in which you implement your chosen design
style does. This task is designed to test your ability to functionally design an app that meets
real-world use goals. This skill is important to us at VM. Additionally, we are interested in the
way your app is structured (how the UI interacts with the data, how your file structure is set out)
so keep this in mind. The code should be structured in such a way that the app is easily testable.
    
🔌 Data Source The API that provides the necessary data is located
at https://61e947967bc0550017bc61bf.mockapi.io/api/v1/ and is RESTful with 2 endpoints:
· people 
· rooms 

Both support GET requests to list the data and to directly access individual
records (the API is currently read only). 📖 Development Story The following story around how the
app will be used should inform how you approach development/code structure:
VM aims to use their branding in all their internal services. They currently use a main brand colour
#C40202 however they are in the initial stages of a rebrand that may lead this to change soon. All
employees will have access to the app and will expect the ability to quickly pull up and use the
contact details of any of their colleagues. All details of the contact should be displayed in the
app. Employees use Android devices across the full range, so your implementation must work across
phones and tablets. Several of our employees use accessibility features, so your app must be
accessible. If the trial of the Directory app proves successful with the staff, VM may look to
expand the app so that it will also allow users to access and administer more data, so ensure that
the app can be easily expanded both in terms of codebase and UX. The code from this app could be
used in other applications so modularity is important. If the app expands in scope, it will be more
rigorously tested by our QA resource and will therefore need to support a test environment as well
as a live environment. VM cannot guarantee that the same developer(s) will always be working on this
app throughout its lifecycle, so it is important that other developers will be able to onboard
themselves onto the codebase with ease. 🏁 Finished! Now what?


Improvements & upcoming features
============

1) General search function 
   -----------------------
   Adding a Filterable to both the People and Room adapters so users are able to search for specific
   criteria
   
2) Save function
   -------------
   Add ROOM persistence library so users are able to store favourable staff members and also book a 
   room
   
3) Email capabilities
   ------------------
   Offer user ability to email another user when opening up a single user profile.


Libraries Used
==============

DAGGER 2
------
Many Android apps rely on instantiating objects that often require other dependencies. For instance,
a Twitter API client may be built using a networking library such as Retrofit. To use this library, 
you might also need to add parsing libraries such as Gson. In addition, classes that implement 
authentication or caching may require accessing shared preferences or other common storage, 
requiring instantiating them first and creating an inherent dependency chain.

I have used Dagger 2 as it analyzes these dependencies for you and generates code to help wire them 
together. While there are other Java dependency injection frameworks, many of them suffered 
limitations in relying on XML, required validating dependency issues at run-time, or incurred 
performance penalties during startup. Dagger 2 relies purely on using Java annotation processors and
compile-time checks to analyze and verify dependencies. It is considered to be one of the most 
efficient dependency injection frameworks built to date.


Coroutines
----------
On Android, it's essential to avoid blocking the main thread. The main thread is a single thread 
that handles all updates to the UI. It's also the thread that calls all click handlers and other UI 
callbacks. As such, it has to run smoothly to guarantee a great user experience.

Overall, Coroutines make multitasking very easy.

So, we can say that Coroutines and the threads, both are multitasking. But the difference is that 
threads are managed by the OS and coroutines managed by the users as it can execute a few lines of
function by taking advantage of the cooperation contained within a coroutine

It's an optimised framework written over the actual threading by taking advantage of the cooperative
nature of functions to make it light and yet powerful. So, we can say that Coroutines are 
lightweight threads, a pool of threads if you will. A lightweight thread means it doesn’t map on the
native thread, so it doesn’t require context switching on the processor, so they are faster.

Retrofit
--------
Networking is a crucial factor in mobile development. Most, if not all mobile applications 
incorporate networking on some level. Applications are either sending or receiving information. 
Initially, developers did networking on the main thread. This made applications less user-friendly 
since screens would “freeze”.

Retrofit is a type-safe HTTP networking library used for Android and Java. Retrofit was even better
since it was super fast, offered better functionality, and even simpler syntax. Most developers 
since then have switched to using Retrofit to make API requests.

ViewModel
---------
The ViewModel is essential when we want a separation of concerns between your DomainModel 
(DataModel) and the rest of your code. The less dependencies I have between the Model, View and 
Controller the easier down the line it will be to make changes to the DomainModel without breaking 
the interface contracts in the View and Controller. But once again it's something to be 
pragmatic. I like the approach as code re-factoring is a big part of general Android development - 
refactoring may include a simple spelling mistake on a property of a Model - that change could ripple 
through the code to the Contract level if the dependencies are not separated
