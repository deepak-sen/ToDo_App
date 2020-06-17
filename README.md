
# TODO.
---

<p align="center">
  <img src="https://i.ibb.co/SQKHL27/todo.png">
</p>

---
[![Build Status](http://img.shields.io/travis/badges/badgerbadgerbadger.svg?style=flat-square)](https://travis-ci.org/badges/badgerbadgerbadger)
![Coverage Status](http://img.shields.io/coveralls/badges/badgerbadgerbadger.svg?style=flat-square)
![Badges](http://img.shields.io/:badges-9/9-ff6799.svg?style=flat-square)
![Badges](http://img.shields.io/:perfection%20badge-5/7-ff6799.svg?style=flat-square)

---


## Features
Register          |  Sign-IN                      | Adding ToooDooo              |  Adding ToDo List
:----------------------------:|:--------------------------------------:|:----------------------:|:-----------------
<img src = "http://g.recordit.co/FA4dI80KXq.gif" width="200" height="360">  |  <img src = "http://g.recordit.co/2BUesdd1wI.gif" width="200" height="360">        |  <img src = "http://g.recordit.co/NWyseEnKvW.gif" width="200" height="360">  | <img src = "http://g.recordit.co/9BEfyIXARp.gif" width="200" height="360">
#
SpeechToText          |  Adding Name Description                   | Marking Complete/Incomplete              |  Undo Todo
:----------------------------:|:--------------------------------------:|:----------------------:|:-----------------
 <img src = "http://g.recordit.co/LSOThTsE2i.gif" width="200" height="360"> |   <img src = "http://g.recordit.co/eo7po84uIf.gif" width="200" height="360">        | <img src = "http://g.recordit.co/0VtmQQ2dEI.gif" width="200" height="360">   | <img src = "http://g.recordit.co/Tlhc9nYTSb.gif" width="200" height="360">



---

## Downloads:

| Platform | Architecture    | Version | Link                                                                                                                         |
| -------- | ------- | ------- | ---------------------------------------------------------------------------------------------------------------------------- |
| Android  | x64     | 1.o   | <a href='https://play.google.com/store/apps/details?id=com.np.pramitmarattha&pcampaignid=pcampaignidMKT-Other-global-all-co-prtnr-py-PartBadge-Mar2515-1'><img alt='Get it on Google Play' src='https://play.google.com/intl/en_us/badges/static/images/badges/en_badge_web_generic.png' width="200" height="70"/></a>  |

---

## About Installation (Installing and using the App)
#### ***1 Register/ Sign Up:*** : Fill the Required Information and Sign Up.
#### ***2 Login:*** : After Signing Up Login with the same credentials.
##### ***3 Todo List:*** : Click on the floating Add icon and create the Todo List
#### ***4 Todo Item:***  : After creating a Todo List ,Now click on the list and create your Todo Items.
#### ***5 Editing the Todo Items:*** : Click on the Todo Item and edit it.
#### ***6 Deleting the todo items and list:***. : You can delete Todolist or a todoItem.
#### ***7 Sorting or filtering out:*** : Sort the completed and incomplete Todo items.
#### ***8 Searching Todo items :*** : Search the todo items.

---

### Design Architecture 
# MODEL
* `adapter`  consists of recyclerviews adapters.<br>
-`TaskListsAdapter` <br>
-`TaskItemsAdapter` <br>
* `InterfacePrompt` consists of dialog prompts popup & Swipe to delete<br>
-`AddNewTodoListDialog`<br>
-`SwipeLeftDelete`<br>
-`TodoItemsCallBack`<br>
-`TodoListCallbacks`<br>
-`SignoutDialog`<br>
* `Database` consists of dao(class for room database) ,UserAuthentication,db..<br>
-`DataAccessObject`<br>
-`AppDatabase`<br>
-`Dateconvert`<br>
-`EntireUserDatabase`<br>
-`RegisterUserAuthentication`<br>
-`TodoItems`<br>
-`TodoLists`<br>
-`TodoListsAndItems`<br>

# VIEW
* `Activity`  consists of main activity<br>
-`MainActivity` <br>
* `Fragments` consists of all fragments<br>
-`LoginFragments`<br>
-`RegisterFragments`<br>
-`SplashFragments`<br>
-`TodoListFormFragments`<br>
-`TodoListFragments`<br>

# ViewModel
* `authHandleHomeViewModel`  <br>
* `ParentExtendHomeViewModel` <br>
* `SignInViewModel` <br>
* `SignInviewModel` <br>
*  `SignUpViewModel` <br>
*  `TodoListViewModel`<br>
*  `TodoItemViewModel`<br>

---

# Development Stages
```bash
├── Master
|
|---->|─ InitialStep Branch
│     ├── Entity Branch
│     ├── DataAccessObject branch
│     ├── Database Branch
│     ├── TypeConverter Branch
│     ├── Thread runnable & executor Branch 
│     ├── PopulateList Branch
│     ├── DeleteList Branch
│     ├── UpdateList branch
│     ├── Live Data Branch
│     ├── MainActivityViewModel Branch
│     ├── AddEditTaskActivityViewModel Branch
│     ├── Repository Branch
│     ├── UserInterface Branch
│     ├── Updating The Icons Branch
│     ├── Updating the Task branch
│     ├── Undo Feature Branch
│     ├── SnackBarPopUPFeature after delete Branch
│     ├── New AppIcon Branch
│     ├── CustomDate Feature Brach
│     ├── SpeechToText Branch
│     ├── ConvertActivityToFragment Branch    
│     ├── Login/SignUp-toSaveTODO branch       
│     ├── RefinedUserInterface Branch
│     ├── NavigationComponent-viewPager Branch        
│<----├── WrappingInPackage-&-Apk-Export Branch        
│   
├── Final Phase(Apk Export)                       <-------- Current progress
```

---

<p align="center">
<img src="https://user-images.githubusercontent.com/37651620/84611109-8d9aec00-aedc-11ea-8205-2345e2481927.png" alt="" width="700" height="720">
</p>

---

## Documentation (Model–view–viewmodel architecture in a nutshell) 
Model–view–viewmodel (MVVM) is a software architectural pattern that facilitates the separation of the development of the graphical user interface (the view) be it via a markup language or GUI code from the development of the business logic or back-end logic (the model) so that the view is not dependent on any specific model platform. The view model of MVVM is a value converter,meaning the view model is responsible for exposing (converting) the data objects from the model in such a way that objects are easily managed and presented. In this respect, the view model is more model than view, and handles most if not all of the view's display logic.The view model may implement a mediator pattern, organizing access to the back-end logic around the set of use cases supported by the view.
#
![](https://codelabs.developers.google.com/codelabs/android-room-with-a-view-kotlin/img/a7da8f5ea91bac52.png)

---

# `References`
### `Resources used to create this App`
#### List of all modules , libraries & Repo-references to create this App:

1. Room persistance library: [https://developer.android.com/topic/libraries/architecture/room]
2. Paint class holds the style and color information about how to draw geometries, text and bitmaps.: [https://developer.android.com/reference/android/graphics/Paint]
3. LayoutInflater: It Instantiates a layout XML file into its corresponding View objects[https://developer.android.com/reference/android/view/LayoutInflater]
4. RxAndroid: Reactive Extensions for Android : [https://github.com/ReactiveX/RxAndroid]
5. Appache commons hashcodebuilder: [https://commons.apache.org/proper/commons-lang/apidocs/org/apache/commons/lang3/builder/HashCodeBuilder.html]
6. Data Binding: It is a is a support library that allows you to bind UI components in your layouts to data sources in your app using a declarative format rather than programmatically. : [https://developer.android.com/topic/libraries/data-binding]
7. Validation: [https://github.com/thyrlian/AwesomeValidation]
8. Handling Lifecycles with Lifecycle-Aware Components: [https://developer.android.com/topic/libraries/architecture/lifecycle]
9. Navigation Components: [https://developer.android.com/guide/navigation/navigation-getting-started]
10. Material Components: [https://material.io/develop/android/docs/getting-started/]
11. Material-components-android: [https://github.com/material-components/material-components-android]
12. Referencing complex data using Room:[https://developer.android.com/training/data-storage/room/referencing-data]
13. TypeConverter: [https://developer.android.com/reference/android/arch/persistence/room/TypeConverter]
14. android.widget:[https://developer.android.com/reference/android/widget/package-summary]
15. Uri :[https://developer.android.com/reference/android/net/Uri]
16. Creating Task Room: [https://github.com/ebbi/TaskRoom]
17. Creating Task Fragment:[https://github.com/ebbi/TaskFragment]
18. TodoViewModel:[https://github.com/ebbi/TodoViewModel]
19. Todo app Model View ViewModel architecture:[https://github.com/ebbi/TodoMVVM]

---

# Detailed Documented process of each Branch
InitialPhase Branch                                |  Entity Branch
:-------------------------------------------------:|:-------------------------------------------------:
![](http://g.recordit.co/oz8cX3el2G.gif)           |  ![](http://g.recordit.co/JQvMR5cJbj.gif)

DataAcessObject Branch                             |  Database Branch
:-------------------------------------------------:|:-------------------------------------------------:
![](http://g.recordit.co/pjNmkW9T0q.gif)           |  ![](http://g.recordit.co/HD0k1JbdKd.gif)

TypeConverter Branch                               |  ThreadRunnableExectors Branch
:-------------------------------------------------:|:-------------------------------------------------:
![](http://g.recordit.co/5IAQC2JeJr.gif)           |  ![](http://g.recordit.co/21sIloC9N2.gif)


PopulatingList Branch                              |  DeletingTask Branch
:-------------------------------------------------:|:-------------------------------------------------:
![](http://g.recordit.co/4hB24sPSYN.gif)           |  ![](https://user-images.githubusercontent.com/37651620/82155625-fb300a00-9895-11ea-891c-6aac9f21f03e.gif)

UpdatingTask Branch                                |  LiveData Branch
:-------------------------------------------------:|:-------------------------------------------------:
![](https://user-images.githubusercontent.com/37651620/82155701-8f9a6c80-9896-11ea-8c1e-a0c8454cc8d8.gif)           |  ![](http://g.recordit.co/LqSU525J4J.gif)

MainActivityViewModel Branch                       | AddEditTaskActivityViewModel Branch  
:-------------------------------------------------:|:-------------------------------------------------:
![](https://user-images.githubusercontent.com/37651620/82155735-bfe20b00-9896-11ea-82eb-c62bda5bf779.gif)           |  ![](https://user-images.githubusercontent.com/37651620/82155763-e0aa6080-9896-11ea-8939-2996e3f3dec9.gif)

Repository Branch                                  |  DeletePopUp Branch 
:-------------------------------------------------:|:-------------------------------------------------:
![](https://user-images.githubusercontent.com/37651620/82156059-c1acce00-9898-11ea-8be8-55d18a64fc93.gif)           |  ![](http://g.recordit.co/idA7vDJzaI.gif)

SppechToText Branch                                | CustomDate Branch
:-------------------------------------------------:|:-------------------------------------------------:
![XK8laCyYBo](https://user-images.githubusercontent.com/37651620/82156096-e1dc8d00-9898-11ea-85de-2bdef7f144b0.gif)         |  ![9Wte9nXKLN](https://user-images.githubusercontent.com/37651620/82156420-ae9afd80-989a-11ea-88f8-c15c399b1722.gif)


OraganizingFilesByPackage Branch                   | Activity to Fragment & Nav. component
:-------------------------------------------------:|---------------------------------------------------:
![](https://user-images.githubusercontent.com/37651620/82150888-59022900-9879-11ea-91e7-41ea0ee6e4f3.gif) |![activityTofragment](https://user-images.githubusercontent.com/37651620/83865108-6bb7a180-a745-11ea-9965-d1ee35b68cad.gif)

---
